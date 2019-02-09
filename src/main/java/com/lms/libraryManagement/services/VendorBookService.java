package com.lms.libraryManagement.services;

import com.lms.libraryManagement.dao.VendorBookDao;
import com.lms.libraryManagement.dao.VendorDao;
import com.lms.libraryManagement.dto.Vendor;
import com.lms.libraryManagement.dto.VendorBook;
import com.lms.libraryManagement.utils.CurrentSession;
import org.hibernate.HibernateException;

import java.util.ArrayList;
import java.util.List;

public class VendorBookService {
    VendorBookDao vendorBookDao = new VendorBookDao();

    public VendorBookService() {
        super();
    }

    public List<VendorBook> getAllVendorBooks()
    {
        List<VendorBook> vendorBooks = null;
        try {
            vendorBooks=vendorBookDao.getVendorBookList(CurrentSession.getCurrentSession());
        }catch (HibernateException h){
            System.out.println(h.getMessage());
        }
        return vendorBooks;
    }

    public VendorBook getVendorBook(int id)
    {
        VendorBook vendorBook = vendorBookDao.getVendorBookById(id,CurrentSession.getCurrentSession());
        return vendorBook;
    }

    public VendorBook addVendorBook(String name,String author,String publisher,int isbn,int price)
    {
        VendorBook vendorBook=new VendorBook();
        vendorBook.setName(name);
        vendorBook.setPublisher(publisher);
        vendorBook.setPrice(price);
        vendorBook.setIsbn(isbn);
        vendorBook.setAuthor(author);
        vendorBookDao.insertVendorBook(vendorBook,CurrentSession.getCurrentSession());
        return vendorBook;
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
    public void deleteVendorBook(int id)
    {
        VendorBook vendorBook = vendorBookDao.getVendorBookById(id,CurrentSession.getCurrentSession());
        vendorBookDao.deleteBook(vendorBook,CurrentSession.getCurrentSession());
    }

    public List<VendorBook> getVendorBookById(int id){
        VendorDao vendorDao = new VendorDao();
        List<VendorBook> vendorBooks=new ArrayList<>();
        Vendor vendor = vendorDao.getVendorById(id, CurrentSession.getCurrentSession());
        for(VendorBook vendorBook : vendor.getVendorBooks()){
            vendorBooks.add(vendorBook);
        }
        return vendorBooks;
    }
}
