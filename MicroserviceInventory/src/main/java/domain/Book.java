/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author M
 */
@Stateless
@Entity
@NamedQueries({
    @NamedQuery(name = "Book.findBook", query = "SELECT b from Book b where b.id = :bookId")
    ,
    @NamedQuery(name = "Book.getBooks", query = "SELECT b from Book b")
})
public class Book extends Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Inventory inventoryBookId;
    private String name;
    private Integer price;
    private String publisher;
    private String author;

    public Book() {

    }

    public Book(String name, Integer price, String publisher, String author) {
        this.name = name;
        this.price = price;
        this.publisher = publisher;
        this.author = author;
    }

    public Inventory getInventoryBookId() {
        return inventoryBookId;
    }

    public void setInventoryBookId(Inventory inventoryBookId) {
        this.inventoryBookId = inventoryBookId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
