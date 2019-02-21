package com.lms.libraryManagement;

import com.lms.libraryManagement.dao.LibrarianDao;
import com.lms.libraryManagement.dao.VendorBookDao;
import com.lms.libraryManagement.dao.VendorDao;
import com.lms.libraryManagement.dto.Librarian;
import com.lms.libraryManagement.dto.Vendor;
import com.lms.libraryManagement.dto.VendorBook;
import com.lms.libraryManagement.utils.CurrentSession;
import com.lms.libraryManagement.utils.ReadJson;
import com.lms.libraryManagement.utils.VendorUtil;
import com.lms.libraryManagement.views.MainView;
import org.hibernate.Session;

public class App {
    public static void main(String[] args) {

        MainView mv = new MainView();
        LibrarianDao librarianDao = new LibrarianDao();
        VendorDao vendorDao = new VendorDao();
        VendorBookDao vendorBookDao = new VendorBookDao();

        Session session = CurrentSession.getCurrentSession();
        Librarian librarian1 = new Librarian();
        ReadJson.getJson(session);
        librarian1.setUsername("lib1");
        librarian1.setPassword("password");
        librarianDao.insertLibrarian(librarian1, session);

/*        Vendor v1 = new Vendor();
        v1.setName("vendor 1");
        Vendor v2 = new Vendor();
        v2.setName("vendor 2");
        Vendor v3 = new Vendor();
        v3.setName("vendor 3");
        Vendor v4 = new Vendor();
        v4.setName("vendor 4");
        Vendor v5 = new Vendor();
        v5.setName("vendor 5");*/

       /* VendorBook vendorBook = new VendorBook();
        vendorBook.setName("Vendor Book 1");
        vendorBook.setAuthor("Sample Author");
        vendorBook.setIsbn(123);
        vendorBook.setPrice(999);
        vendorBook.setPublisher("Sample publisher");

        v1.getVendorBooks().add(vendorBook);
        vendorBook.setVendor(v1);

        vendorDao.insertVendor(v1,session);
        vendorBookDao.insertVendorBook(vendorBook,session);*/


        Librarian librarian2 = new Librarian();
        Librarian librarian3 = new Librarian();
        Librarian librarian4 = new Librarian();
        Librarian librarian5 = new Librarian();

        //Run Once to add Books to DB

        //Adding books to list of vendors
        Vendor v1 = new Vendor();
        v1.setName("vendor 1");
        Vendor v2 = new Vendor();
        v2.setName("vendor 2");
        Vendor v3 = new Vendor();
        v3.setName("vendor 3");
        Vendor v4 = new Vendor();
        v4.setName("vendor 4");
        Vendor v5 = new Vendor();
        v5.setName("vendor 5");

        VendorUtil.addBook(v1, session);
        VendorUtil.addBook(v2, session);
        VendorUtil.addBook(v3, session);
        VendorUtil.addBook(v4, session);
        VendorUtil.addBook(v5, session);



        librarian2.setUsername("lib2");
        librarian2.setPassword("password");
        librarianDao.insertLibrarian(librarian2, session);

        librarian3.setUsername("lib3");
        librarian3.setPassword("password");
        librarianDao.insertLibrarian(librarian3, session);

        librarian4.setUsername("lib4");
        librarian4.setPassword("password");
        librarianDao.insertLibrarian(librarian4, session);

        librarian5.setUsername("lib5");
        librarian5.setPassword("password");
        librarianDao.insertLibrarian(librarian5, session);


        mv.getMainView(mv,session);
    }
}
