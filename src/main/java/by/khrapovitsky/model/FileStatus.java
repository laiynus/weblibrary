package by.khrapovitsky.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table
public class FileStatus implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fileStatusId",unique = true, nullable = false)
    private Integer fileStatusId;
    @Column(name = "dateOfUpload",nullable = false)
    private Timestamp dateOfUpload;
    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;
    @OneToOne(mappedBy = "fileStatus", cascade = CascadeType.ALL)
    private Book book;

    public FileStatus(Timestamp dateOfUpload, User user) {
        this.dateOfUpload = dateOfUpload;
        this.user = user;
    }

    public FileStatus() {
    }

    public Integer getFileStatusId() {
        return fileStatusId;
    }

    public void setFileStatusId(Integer fileStatusId) {
        this.fileStatusId = fileStatusId;
    }

    public Timestamp getDateOfUpload() {
        return dateOfUpload;
    }

    public void setDateOfUpload(Timestamp dateOfUpload) {
        this.dateOfUpload = dateOfUpload;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
