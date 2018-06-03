/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author M
 */
@Stateless
@Entity
@NamedQueries({
    @NamedQuery(name = "Inventory.findInventory", query = "SELECT i from Inventory i WHERE i.id = :inventoryId")
    ,
    @NamedQuery(name = "Inventory.getInventories", query = "SELECT i from Inventory i")
})
public class Inventory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "inventoryGameId", cascade = CascadeType.ALL)
    private List<Game> games;

    @OneToMany(mappedBy = "inventoryBookId", cascade = CascadeType.ALL)
    private List<Book> books;

    public Inventory() {

    }

    public Inventory(String name) {
        this.name = name;
        games = new ArrayList();
    }

    public Inventory(List<Game> items) {
        this.games = items;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer totalItemsSize() {
        return this.games.size();
    }

    public void addItem(Game item) {
        this.games.add(item);
    }
}
