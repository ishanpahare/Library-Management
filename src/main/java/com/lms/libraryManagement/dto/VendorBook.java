package com.lms.libraryManagement.dto;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Entity
public class VendorBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private int isbn;
    private int price;
    private String name;
    private String author;
    private String publisher;
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            targetEntity = Vendor.class)
    @JsonbTransient
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "VID")
    private Vendor vendor;

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
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
