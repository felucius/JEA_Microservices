/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.BookDAO;
import domain.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;

/**
 *
 * @author M
 */
@Stateless
public class BookService {

    @Inject
    BookDAO bookDAO;

    public Book getBook(Integer bookId) throws PersistenceException {
        return bookDAO.getBook(bookId);
    }

    public List<Book> getBooks() throws PersistenceException {
        return bookDAO.getBooks();
    }

    public List<Book> getBooksById(List<Integer> bookIds) throws PersistenceException {
        return bookDAO.getBooksById(bookIds);
    }

    public Boolean insertBook(Book book) throws PersistenceException {
        return bookDAO.insertBook(book);
    }

    public Boolean deleteBook(Book book) throws PersistenceException {
        return bookDAO.deleteBook(book);
    }

    public Boolean updateBook(Book book) throws PersistenceException {
        return bookDAO.updateBook(book);
    }
}
