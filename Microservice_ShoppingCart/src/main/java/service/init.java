/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.ShoppingCart;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author M
 */
@Startup
@Singleton
public class init {

    @Inject
    ShoppingCartService shoppingCartService;

    private List<Integer> itemIds;
    
    @PostConstruct
    public void init() {
        itemIds = new ArrayList();
        itemIds.add(1);
        itemIds.add(1);
        itemIds.add(2);
        itemIds.add(3);
        ShoppingCart shoppingCart = new ShoppingCart(100, 1, itemIds);
        
        shoppingCartService.insertShoppingCart(shoppingCart);
    }
}
