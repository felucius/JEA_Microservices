/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.ShoppingCart;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author M
 */
public interface ShoppingCartDAO {

    List<ShoppingCart> getShoppingCarts() throws PersistenceException;

    List<ShoppingCart> getShoppingCartsByAccountId(Integer accountId) throws PersistenceException;
    
    ShoppingCart findShoppingCart(Integer id) throws PersistenceException;

    Boolean insertShoppingCart(ShoppingCart shoppingCart) throws PersistenceException;

    Boolean updateShoppingCart(ShoppingCart shoppingCart) throws PersistenceException;

    Boolean removeShoppingCart(ShoppingCart shoppingCart) throws PersistenceException;
}
