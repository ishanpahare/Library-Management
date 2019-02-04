package com.lms.libraryManagement.services;

import com.lms.libraryManagement.dao.BookDao;
import com.lms.libraryManagement.dao.CustomerDao;
import com.lms.libraryManagement.dao.IssuedBookDao;
import com.lms.libraryManagement.dao.LibrarianDao;
import com.lms.libraryManagement.dto.Book;
import com.lms.libraryManagement.dto.Customer;
import com.lms.libraryManagement.dto.IssuedBook;
import com.lms.libraryManagement.dto.Librarian;
import com.lms.libraryManagement.utils.CurrentSession;
import com.lms.libraryManagement.utils.DateUtil;
import org.hibernate.HibernateException;

import java.util.Date;
import java.util.List;

public class IssuedService {
    IssuedBookDao issuedBookDao = new IssuedBookDao();

    public IssuedService() {
        super();
    }

    public List<IssuedBook> getAllBook()
    {
        List<IssuedBook> issuedBooks = null;
        try {
            issuedBooks=issuedBookDao.getIssuedBookList(CurrentSession.getCurrentSession());
        }catch (HibernateException h){
            System.out.println(h.getMessage());
        }
        return issuedBooks;
    }

    public IssuedBook getIssuedBook(int id)
    {
        IssuedBook issuedBook= issuedBookDao.getIssuedBookById(id,CurrentSession.getCurrentSession());
        return issuedBook;
    }

    public IssuedBook addIssuedBook(int uid,int cid,int lid)
    {
        BookDao bookDao = new BookDao();
        LibrarianDao librarianDao = new LibrarianDao();
        CustomerDao customerDao = new CustomerDao();

        IssuedBook issuedBook = new IssuedBook();
        Librarian librarian = librarianDao.getLibrarianById(lid,CurrentSession.getCurrentSession());
        Book book = bookDao.getBookById(uid,CurrentSession.getCurrentSession());
        Customer customer = customerDao.getCustomerById(cid,CurrentSession.getCurrentSession());

        String name = book.getName();
        issuedBook.setName(name);
        String author = book.getAuthor();
        issuedBook.setAuthor(author);
        int isbn = book.getIsbn();
        issuedBook.setIsbn(isbn);
        int price = book.getPrice();
        issuedBook.setPrice(price);
        String publisher = book.getPublisher();
        issuedBook.setPublisher(publisher);
        //issuedBook.setIssueDate(new Date());
        //issuedBook.setReturnDate(DateUtil.addDays(new Date(),14));

        issuedBook.getCustomers().add(customer);
        customer.getIssuedBooks().add(issuedBook);
        issuedBook.getLibrarians().add(librarian);
        librarian.getIssuedBooks().add(issuedBook);

        issuedBookDao.insertIssuedBook(issuedBook,CurrentSession.getCurrentSession());
        bookDao.deleteBook(book,CurrentSession.getCurrentSession());

        return issuedBook;
    }

    /*
    public Country updateCountry(Country country)
    {
        if(country.getId()<=0)
            return null;
        countryIdMap.put(country.getId(), country);
        return country;

    }
    */
    public void deleteBook(int id)
    {
        IssuedBook issuedBook = issuedBookDao.getIssuedBookById(id, CurrentSession.getCurrentSession());
        issuedBookDao.deleteIssuedBook(issuedBook,CurrentSession.getCurrentSession());
    }
}
