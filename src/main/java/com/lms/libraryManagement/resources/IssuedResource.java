package com.lms.libraryManagement.resources;

import com.lms.libraryManagement.dto.Book;
import com.lms.libraryManagement.dto.Customer;
import com.lms.libraryManagement.dto.IssuedBook;
import com.lms.libraryManagement.services.IssuedService;
import org.json.simple.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Path("/issuedBooks")
public class IssuedResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List getIssuedList(){
        List<IssuedBook> issuedList = null;
        IssuedService issuedService = new IssuedService();
        issuedList = issuedService.getAllBook();
        return issuedList;
    }

    @GET
    @Path("customer/{cid}")
    @Produces(MediaType.APPLICATION_JSON)
    public List getIssuedCustomerList(@PathParam("cid") int cid){
        System.out.println("INSIDE THE REST END-POINT");
        List<IssuedBook> issuedList = null;
        IssuedService issuedService = new IssuedService();
        issuedList = issuedService.getAllCustomerIssued(cid);
        return issuedList;

    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public IssuedBook getIssued(@PathParam("id") int id){
        IssuedService issuedService = new IssuedService();
        IssuedBook issuedBook = issuedService.getIssuedBook(id);
        return issuedBook;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public IssuedBook addIssuedBook(JSONObject inputJsonObject){
        IssuedService issuedService = new IssuedService();
        Integer uid = ((BigDecimal) inputJsonObject.get("uid")).intValue();
        Integer cid = ((BigDecimal) inputJsonObject.get("cid")).intValue();
        Integer lid = ((BigDecimal) inputJsonObject.get("lid")).intValue();
        IssuedBook issuedBook = issuedService.addIssuedBook(uid,cid,lid);

        return issuedBook;
    }

    @POST
    @Path("/return")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Book returnBook(JSONObject inputJsonObject){
        IssuedService issuedService = new IssuedService();
        Integer uid = ((BigDecimal) inputJsonObject.get("uid")).intValue();
        Integer cid = ((BigDecimal) inputJsonObject.get("cid")).intValue();
        Integer lid = ((BigDecimal) inputJsonObject.get("lid")).intValue();
        Book book = issuedService.returnBook(uid,cid,lid);

        return book;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteIssuedBook(@PathParam("id") int id){
        IssuedService issuedService = new IssuedService();
        issuedService.deleteBook(id);
    }

}

