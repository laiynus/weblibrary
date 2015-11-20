package by.khrapovitsky.controller;

import by.khrapovitsky.model.VerificationToken;
import by.khrapovitsky.registration.OnRegistrationCompleteEvent;
import by.khrapovitsky.model.Role;
import by.khrapovitsky.model.User;
import by.khrapovitsky.service.UserService;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.isAlphanumeric;

@Controller
public class UserController {

    @Autowired
    UserService usersService;

    @Autowired
    private ShaPasswordEncoder passwordEncoder;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Autowired
    private MessageSource messages;

    @RequestMapping(value = {"/signin"}, method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout,@RequestParam(value = "message", required = false) String message) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", error);
        }
        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        if (message != null) {
            model.addObject("msg", "You've been confirm email successfully.");
        }
        model.setViewName("signin");
        if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
            return new ModelAndView("redirect:/home");
        }
        return model;
    }

    @RequestMapping(value = {"/registration","/join**"}, method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView model = new ModelAndView();
        model.setViewName("join");
        if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
            return new ModelAndView("redirect:/index");
        }
        return model;
    }

    @Secured("isAnonymous()")
    @RequestMapping(value = {"registrationUser"}, method = RequestMethod.POST)
    public @ResponseBody String registerUser(@RequestBody Object object,final HttpServletRequest request) {
        User user = new User((String)((Map)object).get("username"),(String)((Map)object).get("password"),(String)((Map)object).get("email"));
        String confirmPassword = (String)((Map)object).get("confirmPassword");
        if (user.getEmail() == null || user.getEmail().isEmpty() || user.getPassword() == null || user.getPassword().isEmpty() || confirmPassword == null || confirmPassword.isEmpty() || user.getUsername() == null || user.getUsername().isEmpty()) {
            return "All fields are required!";
        }
        if(!isAlphanumeric(user.getUsername()) || !isAlphanumeric(user.getPassword()) || ! isAlphanumeric(confirmPassword)){
            return "Login and password must contains only letters or numbers!";
        }
        EmailValidator validator = EmailValidator.getInstance();
        if(!validator.isValid(user.getEmail())){
            return "Email address is not valid!";
        }
        if(usersService.read(user.getUsername())!=null){
            return "This user already exist!";
        }
        if(usersService.getByEmail(user.getEmail())!=null){
            return "This email already used!";
        }else{
            if(!user.getPassword().equals(confirmPassword)){
                return "Passwords aren't match!";
            }
            user.setPassword(passwordEncoder.encodePassword(user.getPassword(), null));
            Role role = new Role(user,"ROLE_USER");
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            user.setUserRole(roles);
            usersService.create(user);
            final String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(user, request.getLocale(), appUrl));
        }
        return "You have registered successfully, please confirm email address.";
    }

    @Secured("isAnonymous()")
    @RequestMapping(value = "/registrationConfirm", method = RequestMethod.GET)
    public String confirmRegistration (WebRequest request, Model model, @RequestParam("token") String token) {
        Locale locale = request.getLocale();
        VerificationToken verificationToken = usersService.getVerificationToken(token);
        if (verificationToken == null) {
            String message = messages.getMessage("auth.message.invalidToken", null, locale);
            model.addAttribute("message", message);
            return "redirect:/errors/baduser";
        }
        User user = verificationToken.getUser();
        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            model.addAttribute("message", messages.getMessage("auth.message.expired", null, locale));
            return "redirect:/errors/baduser";
        }
        user.setIsEnabled(true);
        usersService.update(user);
        usersService.deleteVerificationTokenForUser(verificationToken);
        model.addAttribute("message", "success");
        return "redirect:/signin";
    }

}
