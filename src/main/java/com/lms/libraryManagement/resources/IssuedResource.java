package com.lms.libraryManagement.resources;

import com.lms.libraryManagement.dto.IssuedBook;
import com.lms.libraryManagement.services.IssuedService;
import org.json.simple.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
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
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public IssuedBook getIssued(@PathParam("id") int id){
        IssuedService issuedService = new IssuedService();
        IssuedBook issuedBook = issuedService.getIssuedBook(id);
        return issuedBook;
    }

    @PUT
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

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteIssuedBook(@PathParam("id") int id){
        IssuedService issuedService = new IssuedService();
        issuedService.deleteBook(id);
    }

}

