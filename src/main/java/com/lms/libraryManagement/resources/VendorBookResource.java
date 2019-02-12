package com.lms.libraryManagement.resources;

import com.lms.libraryManagement.dao.VendorBookDao;
import com.lms.libraryManagement.dao.VendorDao;
import com.lms.libraryManagement.dto.Book;
import com.lms.libraryManagement.dto.Vendor;
import com.lms.libraryManagement.dto.VendorBook;
import com.lms.libraryManagement.services.VendorBookService;
import com.lms.libraryManagement.services.VendorService;
import com.lms.libraryManagement.utils.CurrentSession;
import org.json.simple.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.List;

@Path("/vendorBooks")
public class VendorBookResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List getVendorBookList() {
        List<VendorBook> vendorBookList =null;
        VendorBookService vendorBookService = new VendorBookService();
        vendorBookList=vendorBookService.getAllVendorBooks();
        return vendorBookList;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public VendorBook getVendorBook(@PathParam("id") int id){
        VendorBookService vendorBookService = new VendorBookService();
        VendorBook vendorBook = vendorBookService.getVendorBook(id);
        return vendorBook;
    }

    @PUT
    @Path("/order")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void getVendorOrder(JSONObject inputJsonObject){
        Integer isbn = ((BigDecimal) inputJsonObject.get("isbn")).intValue();
        Integer quantity = ((BigDecimal) inputJsonObject.get("quantity")).intValue();
        Integer id = ((BigDecimal) inputJsonObject.get("id")).intValue();
        System.out.println("ISBN :"+isbn);
        System.out.println("Quantity :"+quantity);
        System.out.println("id :"+id);
        VendorBookService vendorBookService = new VendorBookService();
        vendorBookService.orderBook(id,isbn,quantity);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public VendorBook addVendorBook(JSONObject inputJsonObject){
        VendorBookService vendorBookService = new VendorBookService();
        String name = (String) inputJsonObject.get("name");
        String author = (String) inputJsonObject.get("author");
        String publisher = (String) inputJsonObject.get("publisher");
        Integer isbn = ((BigDecimal) inputJsonObject.get("isbn")).intValue();
        Integer price = ((BigDecimal) inputJsonObject.get("price")).intValue();
        VendorBook vendorBook = vendorBookService.addVendorBook(name,author,publisher,isbn,price);
        return vendorBook;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteVendor(@PathParam("id") int id){
        VendorBookService vendorBookService = new VendorBookService();
        vendorBookService.deleteVendorBook(id);
    }

    @GET
    @Path("/vendor/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<VendorBook> getVendorBooks(@PathParam("id") int id){
        VendorBookService vendorBookService = new VendorBookService();
        return vendorBookService.getVendorBookById(id);
    }

}
