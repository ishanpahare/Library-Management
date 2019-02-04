package com.lms.libraryManagement.services;

import com.lms.libraryManagement.dao.BookDao;
import com.lms.libraryManagement.dto.Book;
import com.lms.libraryManagement.utils.CurrentSession;
import org.hibernate.HibernateException;

import java.util.List;

public class BookService {
    BookDao bookDao = new BookDao();
    public BookService() {
        super();
    }

    public List<Book> getAllBook()
    {
        List<Book> books = null;
        try {
            books=bookDao.getBookList(CurrentSession.getCurrentSession());
        }catch (HibernateException h){
            System.out.println(h.getMessage());
        }
        return books;
    }

    public Book getBook(int id)
    {
        Book book= bookDao.getBookById(id,CurrentSession.getCurrentSession());
        return book;
    }

    public Book addBook(String name,String author,String publisher,int isbn,int price)
    {
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setIsbn(isbn);
        book.setPrice(price);
        book.setPublisher(publisher);
        bookDao.insertBook(book,CurrentSession.getCurrentSession());
        return book;
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
        Book book = bookDao.getBookById(id,CurrentSession.getCurrentSession());
        bookDao.deleteBook(book,CurrentSession.getCurrentSession());
    }
}
