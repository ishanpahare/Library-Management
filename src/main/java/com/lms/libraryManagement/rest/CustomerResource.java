package com.lms.libraryManagement.rest;

import com.lms.libraryManagement.dto.Customer;
import com.lms.libraryManagement.services.CustomerService;
import org.json.simple.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/customers")
public class CustomerResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List getCustomerList() {
        List<Customer> customerList =null;
        CustomerService customerService = new CustomerService();
        customerList=customerService.getAllCustomer();
        return customerList;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomer(@PathParam("id") int id){
        CustomerService customerService = new CustomerService();
        Customer customer = customerService.getCustomer(id);
        return customer;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer addCustomer(JSONObject inputJsonObject){
        String name = (String) inputJsonObject.get("name");
        String email = (String) inputJsonObject.get("email");
        String dob = (String) inputJsonObject.get("dob");
        String doj = (String) inputJsonObject.get("doj");
        System.out.println("THE NAME IS :"+name);
        CustomerService customerService = new CustomerService();
        Customer customer = customerService.addCustomer(name,email,dob,doj);
        return customer;

    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCustomer(@PathParam("id") int id){
        CustomerService customerService = new CustomerService();
        customerService.deleteCustomer(id);
    }

}
