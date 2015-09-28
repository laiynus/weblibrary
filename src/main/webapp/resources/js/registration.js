$(document).ready(function () {
    $("#registredUser").click(function registrationUser() {
        $("#errorBox").remove();
        var username = $("#username").val();
        var email = $("#mail").val();
        var password = $("#password").val();
        var confirmPassword = $("#confirmPassword").val();
        var user = {"username": username, "password": password, "confirmPassword": confirmPassword, "email": email};
        if (!username.trim() || !password.trim() || !confirmPassword.trim() || !email.trim()) {
            $("<div id='errorBox' class='alert alert-danger fade in'>" +
                "<button type='button' class='close' data-dismiss='alert'>&times;</button>All fields are required!</div>")
                .insertBefore("#registrationForm");
        } else {
            if (password != confirmPassword) {
                $("<div id='errorBox' class='alert alert-danger fade in'>" +
                    "<button type='button' class='close' data-dismiss='alert'>&times;</button>Passwords aren't match!</div>")
                    .insertBefore("#registrationForm");
            } else {
                if (!IsEmail(email)) {
                    $("<div id='errorBox' class='alert alert-danger fade in'>" +
                        "<button type='button' class='close' data-dismiss='alert'>&times;</button>Please enter valid email!</div>")
                        .insertBefore("#registrationForm");
                } else {
                    $.ajax({
                        url: "registrationUser",
                        type: 'POST',
                        data: JSON.stringify(user),
                        dataType: 'json',
                        contentType: 'application/json; charset=utf-8',
                        mimeType: 'application/json; charset=utf-8',
                        beforeSend: function (xhr) {
                            var token = $("meta[name='_csrf']").attr("content");
                            var header = $("meta[name='_csrf_header']").attr("content");
                            $(document).ajaxSend(function (e, xhr, options) {
                                xhr.setRequestHeader(header, token);
                            });
                        },
                        success: function (response) {
                            if (response != "Success") {
                                $("<div id='errorBox' class='alert alert-success fade in'>" +
                                    "<button type='button' class='close' data-dismiss='alert'>&times;</button>" + response + "</div>")
                                    .insertBefore("#registrationForm");
                                $("#username").val('');
                                $("#mail").val('');
                                $("#password").val('');
                                $("#confirmPassword").val('');
                            }
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            ("<div id='errorBox' class='alert alert-success fade in'>" +
                            "<button type='button' class='close' data-dismiss='alert'>&times;</button>error:" + textStatus + " - exception:" + errorThrown + "</div>")
                                .insertBefore("#registrationForm");
                        }
                    })
                }
            }
        }
    })

});

function IsEmail(email) {
    var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    return regex.test(email);
}
