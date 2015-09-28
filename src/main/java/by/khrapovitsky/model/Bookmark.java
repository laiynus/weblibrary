package by.khrapovitsky.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "bookmarks")
public class Bookmark implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bookmarkId",unique = true, nullable = false)
    private Integer bookmarkId;
    @Column(name = "lastDateReading",nullable = false)
    private Timestamp lastDateReading;
    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "bookHash", nullable = false)
    private Book book;

    public Bookmark(Timestamp lastDateReading, User user, Book book) {
        this.lastDateReading = lastDateReading;
        this.user = user;
        this.book = book;
    }

    public Bookmark() {
    }

    public Integer getBookmarkId() {
        return bookmarkId;
    }

    public void setBookmarkId(Integer bookmarkId) {
        this.bookmarkId = bookmarkId;
    }

    public Timestamp getLastDateReading() {
        return lastDateReading;
    }

    public void setLastDateReading(Timestamp lastDateReading) {
        this.lastDateReading = lastDateReading;
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
