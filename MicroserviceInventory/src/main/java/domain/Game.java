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
    @NamedQuery(name = "Game.findGame", query = "SELECT g from Game g WHERE g.id = :gameId")
    ,
    @NamedQuery(name = "Game.getGames", query = "SELECT g from Game g")
})
public class Game extends Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne()
    private Inventory inventoryGameId;
    private String name;
    private Integer price;
    private String genre;
    private String releaseDate;

    public Game() {

    }

    public Game(String name, Integer price, String genre, String releaseDate) {
        this.name = name;
        this.price = price;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public Inventory getInventoryGameId() {
        return inventoryGameId;
    }

    public void setInventoryGameId(Inventory inventoryId) {
        this.inventoryGameId = inventoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return this.price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

}
