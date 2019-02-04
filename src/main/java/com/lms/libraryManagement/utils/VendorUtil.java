package com.lms.libraryManagement.utils;


import com.lms.libraryManagement.dao.VendorBookDao;
import com.lms.libraryManagement.dao.VendorDao;
import com.lms.libraryManagement.dto.Vendor;
import com.lms.libraryManagement.dto.VendorBook;
import org.hibernate.Session;

/* Utility class for adding vendors and books into them */
public class VendorUtil {
    public static void addBook(Vendor vendor, Session session) {
        VendorBookDao vendorBookDao = new VendorBookDao();
        VendorDao vendorDao = new VendorDao();

        for (int i = 1; i <= 10; i++) {
            VendorBook vendorBook = new VendorBook();
            vendorBook.setName("book" + i);
            vendorBook.setPrice((i * 10 + 99));
            vendorBook.setPublisher("Publisher" + i);
            vendorBook.setIsbn(30 + i);
            vendorBook.setAuthor("author" + i);

            vendorDao.insertVendor(vendor, session);
            vendorBookDao.insertVendorBook(vendorBook, session);
            vendorBook.setVendor(vendor);
            vendor.getVendorBooks().add(vendorBook);
        }

    }


}
