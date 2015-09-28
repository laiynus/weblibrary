package by.khrapovitsky.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book implements Serializable{

    @Id
    @Column(name = "bookHash",unique = true, nullable = false)
    private String bookHash;
    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "annotation",nullable = true)
    private String annotation;
    @Column(name = "dateOfPublication",nullable = true)
    private Timestamp dateOfPublication;
    @Column(name = "filePath",nullable = false)
    private String filePath;
    @ManyToOne
    @JoinColumn(name="fileType",nullable = false)
    private FileType fileType;
    @OneToOne
    @JoinColumn(name = "fileStatusId",nullable = false)
    private FileStatus fileStatus;
    @ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name="authors_books", joinColumns=@JoinColumn(name="bookHash"), inverseJoinColumns=@JoinColumn(name="authorId"))
    private Set<Author> authors;
    @ManyToOne
    @JoinColumn(name="publisherId",nullable = true)
    private Publisher publisher;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "book",fetch = FetchType.LAZY)
    private Set<Bookmark> bookmarks;

    public Book() {
    }

    public Book(String bookHash, String title, String annotation, Timestamp dateOfPublication, FileType fileType, FileStatus fileStatus ,String filePath, Set<Author> authors, Publisher publisher) {
        this.bookHash = bookHash;
        this.title = title;
        this.annotation = annotation;
        this.dateOfPublication = dateOfPublication;
        this.filePath = filePath;
        this.fileType = fileType;
        this.fileStatus = fileStatus;
        this.authors = authors;
        this.publisher = publisher;
    }

    public String getBookHash() {
        return bookHash;
    }

    public void setBookHash(String bookHash) {
        this.bookHash = bookHash;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public Timestamp getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(Timestamp dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public FileStatus getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(FileStatus fileStatus) {
        this.fileStatus = fileStatus;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Set<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(Set<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }

}
