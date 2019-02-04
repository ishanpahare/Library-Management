package com.lms.libraryManagement.services;

import com.lms.libraryManagement.dao.LibrarianDao;
import com.lms.libraryManagement.dao.VendorDao;
import com.lms.libraryManagement.dto.Librarian;
import com.lms.libraryManagement.dto.Vendor;
import com.lms.libraryManagement.utils.CurrentSession;
import org.hibernate.HibernateException;

import java.util.List;

public class VendorService {
   VendorDao vendorDao = new VendorDao();

    public VendorService() {
        super();
    }

    public List<Vendor> getAllVendor()
    {
        List<Vendor> vendors = null;
        try {
            vendors=vendorDao.getVendorList(CurrentSession.getCurrentSession());
        }catch (HibernateException h){
            System.out.println(h.getMessage());
        }
        return vendors;
    }

    public Vendor getVendor(int id)
    {
        Vendor vendor = vendorDao.getVendorById(id,CurrentSession.getCurrentSession());
        return vendor;
    }

    public Vendor addVendor(String name)
    {
        Vendor vendor=new Vendor();
        vendor.setName(name);
        vendorDao.insertVendor(vendor,CurrentSession.getCurrentSession());
        return vendor;
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
    public void deleteVendor(int id)
    {
        Vendor vendor = vendorDao.getVendorById(id,CurrentSession.getCurrentSession());
        vendorDao.deleteVendor(vendor,CurrentSession.getCurrentSession());
    }
}
