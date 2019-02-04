package com.lms.libraryManagement.resources;

import com.lms.libraryManagement.dto.Book;
import com.lms.libraryManagement.services.BookService;
import org.json.simple.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Path("/books")
public class BookResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List getBookList() {
        List<Book> bookList =null;
        BookService bookService = new BookService();
        bookList=bookService.getAllBook();
        return bookList;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBook(@PathParam("id") int id){
        BookService bookService = new BookService();
        Book book = bookService.getBook(id);
        return book;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Book addLibrarian(JSONObject inputJsonObject){
        BookService bookService = new BookService();
        String name = (String) inputJsonObject.get("bookName");
        String author = (String) inputJsonObject.get("author");
        String publisher = (String) inputJsonObject.get("publisher");
        Integer isbn = ((BigDecimal) inputJsonObject.get("isbn")).intValue();
        Integer price = ((BigDecimal) inputJsonObject.get("price")).intValue();
        Book book = bookService.addBook(name,author,publisher,isbn,price);
        return book;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteBook(@PathParam("id") int id){
        BookService bookService = new BookService();
        bookService.deleteBook(id);
    }

}
