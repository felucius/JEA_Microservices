/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Book;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author M
 */
@Stateless
public class BookDAOImpl implements BookDAO {

    @PersistenceContext(name = "MicroserviceInventoryPU")
    EntityManager em;

    @Override
    public Book getBook(Integer bookId) throws PersistenceException {
        return (Book) em.createNamedQuery("Book.findBook").setParameter("bookId", bookId).getSingleResult();
    }

    @Override
    public List<Book> getBooks() throws PersistenceException {
        return em.createNamedQuery("Book.getBooks").getResultList();
    }

    @Override
    public List<Book> getBooksById(List<Integer> bookIds) throws PersistenceException {
        List<Book> books = new ArrayList();
        Book book;
        for(Integer b : bookIds){
            book = (Book) em.createNamedQuery("Book.findBook").setParameter("bookId", b).getSingleResult();
            books.add(book);
        }
        return books;
    }

    @Override
    public Boolean insertBook(Book book) throws PersistenceException {
        em.persist(book);
        return true;
    }

    @Override
    public Boolean deleteBook(Book book) throws PersistenceException {
        em.remove(book);
        return true;
    }

    @Override
    public Boolean updateBook(Book book) throws PersistenceException {
        em.merge(book);
        return true;
    }

}
