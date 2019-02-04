package com.lms.libraryManagement.resources;

import com.lms.libraryManagement.dto.Librarian;
import com.lms.libraryManagement.services.LibrarianService;
import org.json.simple.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/librarians")
public class LibrarianResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List getLibrarianList() {
        List<Librarian> librarianList =null;
        LibrarianService librarianService = new LibrarianService();
        librarianList=librarianService.getAllLibrarian();
        return librarianList;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Librarian getLibrarian(@PathParam("id") int id){
        LibrarianService librarianService = new LibrarianService();
        Librarian librarian = librarianService.getLibrarian(id);
        return librarian;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Librarian addLibrarian(JSONObject object){
        LibrarianService librarianService = new LibrarianService();
        String username = (String) object.get("username");
        String password=  (String) object.get("password");
        Librarian librarian = librarianService.addLibrarian(username,password);
        return librarian;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCustomer(@PathParam("id") int id){
        LibrarianService librarianService = new LibrarianService();
        librarianService.deleteLibrarian(id);
    }

}
