package by.khrapovitsky.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public class FileType implements Serializable{

    @Id
    @Column(name = "fileType",unique = true,nullable = false)
    private String fileType;
    @Column(name = "extension",nullable = false)
    private String extension;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "fileType",fetch = FetchType.LAZY)
    private Set<Book> books;

    public FileType(String fileType, String extension) {
        this.fileType = fileType;
        this.extension = extension;
    }

    public FileType() {
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
