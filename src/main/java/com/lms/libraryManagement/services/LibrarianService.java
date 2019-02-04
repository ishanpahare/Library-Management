package com.lms.libraryManagement.services;

import com.lms.libraryManagement.dao.LibrarianDao;
import com.lms.libraryManagement.dto.Librarian;
import com.lms.libraryManagement.utils.CurrentSession;
import org.hibernate.HibernateException;

import java.util.List;

public class LibrarianService {
    LibrarianDao librarianDao=new LibrarianDao();

    public LibrarianService() {
        super();
    }

    public List<Librarian> getAllLibrarian()
    {
        List<Librarian> librarians = null;
        try {
            librarians=librarianDao.getLibrarianList(CurrentSession.getCurrentSession());
        }catch (HibernateException h){
            System.out.println(h.getMessage());
        }
        return librarians;
    }

    public Librarian getLibrarian(int id)
    {
        Librarian librarian= librarianDao.getLibrarianById(id,CurrentSession.getCurrentSession());
        return librarian;
    }

    public Librarian addLibrarian(String name,String password)
    {
        Librarian librarian = new Librarian();
        librarian.setUsername(name);
        librarian.setPassword(password);
        librarianDao.insertLibrarian(librarian,CurrentSession.getCurrentSession());
        return librarian;
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
    public void deleteLibrarian(int id)
    {
        Librarian librarian = librarianDao.getLibrarianById(id,CurrentSession.getCurrentSession());
        librarianDao.deleteLibrarian(librarian,CurrentSession.getCurrentSession());
    }
}
