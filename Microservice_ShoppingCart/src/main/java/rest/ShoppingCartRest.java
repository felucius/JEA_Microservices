/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import domain.ShoppingCart;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import service.ShoppingCartService;

/**
 *
 * @author M
 */
@Stateless
@Path("shoppingcarts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ShoppingCartRest implements Serializable {

    @Inject
    ShoppingCartService shoppingCartService;

    @GET
    public List<ShoppingCart> getShoppingCarts() throws PersistenceException {
        return shoppingCartService.getShoppingCarts();
    }

    @GET
    @Path("orders/{accountId}")
    public List<ShoppingCart> getShoppingCartsByAccountId(@PathParam("accountId") Integer accountId) throws PersistenceException {
        return shoppingCartService.getShoppingCartsByAccountId(accountId);
    }

    @GET
    @Path("{id}")
    public ShoppingCart findShoppingCart(@PathParam("id") Integer id) throws PersistenceException {
        return shoppingCartService.findShoppingCart(id);
    }

    @POST
    public Boolean insertShoppingCart(ShoppingCart shoppingCart) throws PersistenceException {
        return shoppingCartService.insertShoppingCart(shoppingCart);
    }

    @PUT
    public Boolean updateShoppingCart(ShoppingCart shoppingCart) throws PersistenceException {
        return shoppingCartService.updateShoppingCart(shoppingCart);
    }

    @POST
    @Path("remove")
    public Boolean removeShoppingCart(ShoppingCart shoppingCart) throws PersistenceException {
        return shoppingCartService.removeShoppingCart(shoppingCart);
    }
}
