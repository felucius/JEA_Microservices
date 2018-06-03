/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ShoppingCartDAO;
import domain.ShoppingCart;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;

/**
 *
 * @author M
 */
@Stateless
public class ShoppingCartService implements Serializable {

    @Inject
    ShoppingCartDAO shoppingCartDAO;

    public List<ShoppingCart> getShoppingCarts() throws PersistenceException {
        return shoppingCartDAO.getShoppingCarts();
    }

    public List<ShoppingCart> getShoppingCartsByAccountId(Integer accountId) throws PersistenceException {
        return shoppingCartDAO.getShoppingCartsByAccountId(accountId);
    }

    public ShoppingCart findShoppingCart(Integer id) throws PersistenceException {
        return shoppingCartDAO.findShoppingCart(id);
    }

    public Boolean insertShoppingCart(ShoppingCart shoppingCart) throws PersistenceException {
        return shoppingCartDAO.insertShoppingCart(shoppingCart);
    }

    public Boolean updateShoppingCart(ShoppingCart shoppingCart) throws PersistenceException {
        return shoppingCartDAO.updateShoppingCart(shoppingCart);
    }

    public Boolean removeShoppingCart(ShoppingCart shoppingCart) throws PersistenceException {
        return shoppingCartDAO.removeShoppingCart(shoppingCart);
    }
}
