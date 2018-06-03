/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import domain.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import service.BookService;

/**
 *
 * @author M
 */
@Stateless
@Path("books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookRest {

    @Inject
    BookService bookService;

    @GET
    @Path("{id}")
    public Book getBook(@PathParam("id") Integer bookId) throws PersistenceException {
        return bookService.getBook(bookId);
    }

    @GET
    public List<Book> getBooks() throws PersistenceException {
        return bookService.getBooks();
    }
    
    @POST
    @Path("items")
    public List<Book> getBooksById(List<Integer> bookIds) throws PersistenceException {
        return bookService.getBooksById(bookIds);
    }

    @POST
    public Boolean insertBook(Book book) throws PersistenceException {
        return bookService.insertBook(book);
    }

    @DELETE
    public Boolean deleteBook(Book book) throws PersistenceException {
        return bookService.deleteBook(book);
    }

    @PUT
    public Boolean updateBook(Book book) throws PersistenceException {
        return bookService.updateBook(book);
    }
}
