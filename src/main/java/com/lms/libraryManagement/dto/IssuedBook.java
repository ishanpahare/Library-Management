package com.lms.libraryManagement.dto;


import com.lms.libraryManagement.utils.DateUtil;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


@Entity
public class IssuedBook{
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private int isbn;
    private int price;
    private String name;
    private String author;
    private String publisher;

    //@Temporal(TemporalType.DATE)
    private String issueDate;
    //@Temporal(TemporalType.DATE)
    private String returnDate;

    @ManyToMany(mappedBy = "issuedBooks",
    targetEntity = Customer.class,
    cascade = {CascadeType.ALL},
    fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonbTransient
    private Collection<Customer> customers = new ArrayList<Customer>();

    @ManyToMany(mappedBy = "issuedBooks",
    targetEntity = Librarian.class,
    cascade = {CascadeType.ALL},
    fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonbTransient
    private Collection<Librarian> librarians = new ArrayList<Librarian>();

    public Collection<Librarian> getLibrarians() {
        return librarians;
    }

    public void setLibrarians(Collection<Librarian> librarians) {
        this.librarians = librarians;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }

   public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String date) {
        this.issueDate = date;
    }


    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
