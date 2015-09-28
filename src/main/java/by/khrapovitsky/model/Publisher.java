package by.khrapovitsky.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "publishers")
public class Publisher implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "publisherId",unique = true, nullable = false)
    private Integer publisherId;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "town",nullable = true)
    private String town;
    @Column(name = "address",nullable = true)
    private String address;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "publisher",fetch = FetchType.LAZY)
    private Set<Book> books;

    public Publisher(String name, String town, String address) {
        this.name = name;
        this.town = town;
        this.address = address;
    }

    public Publisher() {
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

}
