/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Book;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author M
 */
public interface BookDAO {

    Book getBook(Integer bookId) throws PersistenceException;

    List<Book> getBooks() throws PersistenceException;

    List<Book> getBooksById(List<Integer> bookIds) throws PersistenceException;
    
    Boolean insertBook(Book book) throws PersistenceException;

    Boolean deleteBook(Book book) throws PersistenceException;

    Boolean updateBook(Book book) throws PersistenceException;
}
