package com.lms.libraryManagement.dto;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    private String name;
    private String email;
    private String dob;
    private String doj;

    @ManyToMany(
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY
    )
    @JsonbTransient
    @JoinTable(name = "CUSTOMER_ISSUED",
            joinColumns = @JoinColumn(name = "CUSTOMER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ISSUED_ID"))
    private Collection<IssuedBook> issuedBooks = new ArrayList<IssuedBook>();

    public Collection<IssuedBook> getIssuedBooks() {
        return issuedBooks;
    }

    public void setIssuedBooks(Collection<IssuedBook> issuedBooks) {
        this.issuedBooks = issuedBooks;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }


    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

}
