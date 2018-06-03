/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.ShoppingCart;
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
public class ShoppingCartDAOImpl implements ShoppingCartDAO {

    @PersistenceContext(name = "ShoppingCartPU")
    EntityManager em;

    @Override
    public List<ShoppingCart> getShoppingCarts() throws PersistenceException {
        return em.createNamedQuery("ShoppingCart.getOrders").getResultList();
    }

    @Override
    public List<ShoppingCart> getShoppingCartsByAccountId(Integer accountId) throws PersistenceException {
        return em.createNamedQuery("ShoppingCart.getOrdersByAccountId").setParameter("accountId", accountId).getResultList();
    }

    @Override
    public ShoppingCart findShoppingCart(Integer id) throws PersistenceException {
        return (ShoppingCart) em.createNamedQuery("ShoppingCart.findOrder").setParameter("id", id).getSingleResult();
    }

    @Override
    public Boolean insertShoppingCart(ShoppingCart shoppingCart) throws PersistenceException {
        em.persist(shoppingCart);
        return true;
    }

    @Override
    public Boolean updateShoppingCart(ShoppingCart shoppingCart) throws PersistenceException {
        em.merge(shoppingCart);
        return true;
    }

    @Override
    public Boolean removeShoppingCart(ShoppingCart shoppingCart) throws PersistenceException {
        ShoppingCart s = em.find(ShoppingCart.class, shoppingCart.getId());
        em.remove(s);
        return true;
    }

}
