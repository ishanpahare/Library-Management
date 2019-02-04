package com.lms.libraryManagement.services;

import com.lms.libraryManagement.dao.BookDao;
import com.lms.libraryManagement.dao.CustomerDao;
import com.lms.libraryManagement.dto.Book;
import com.lms.libraryManagement.dto.Customer;
import com.lms.libraryManagement.utils.CurrentSession;
import org.hibernate.HibernateException;

import java.util.List;

public class CustomerService {

    CustomerDao customerDao=new CustomerDao();

    public CustomerService() {
        super();
    }

    public List<Customer> getAllCustomer()
    {
        List<Customer> customers = null;
        try {
            customers=customerDao.getCustomerList(CurrentSession.getCurrentSession());
        }catch (HibernateException h){
            System.out.println(h.getMessage());
        }
        return customers;
    }

    public Customer getCustomer(int id)
    {
        Customer customer= customerDao.getCustomerById(id,CurrentSession.getCurrentSession());
        return customer;
    }

    public Customer addCustomer(String name)
    {
        Customer customer = new Customer();
        customer.setName(name);
        customerDao.insertCustomer(customer,CurrentSession.getCurrentSession());
        return customer;
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
    public void deleteCustomer(int id)
    {
        Customer customer = customerDao.getCustomerById(id,CurrentSession.getCurrentSession());
        customerDao.deleteCustomer(customer,CurrentSession.getCurrentSession());
    }

}
