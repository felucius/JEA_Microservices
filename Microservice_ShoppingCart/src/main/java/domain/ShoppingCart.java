/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author M
 */
@Stateless
@Entity
@NamedQueries({
    @NamedQuery(name = "ShoppingCart.getOrders", query = "SELECT s FROM ShoppingCart s")
    ,
    @NamedQuery(name = "ShoppingCart.findOrder", query = "SELECT s FROM ShoppingCart s WHERE s.id = :id"),
    @NamedQuery(name = "ShoppingCart.getOrdersByAccountId", query = "SELECT s FROM ShoppingCart s WHERE s.accountId = :accountId")
})
public class ShoppingCart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer price;
    private Integer accountId;
    private List<Integer> itemIds;

    public ShoppingCart() {

    }

    public ShoppingCart(Integer price, Integer accountId, List<Integer> itemIds) {
        this.price = price;
        this.accountId = accountId;
        this.itemIds = itemIds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public List<Integer> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Integer> itemIds) {
        this.itemIds = itemIds;
    }
}
