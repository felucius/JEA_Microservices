/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Inventory;
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
public class InventoryDAOImpl implements InventoryDAO{

    @PersistenceContext(name = "MicroserviceInventoryPU")
    EntityManager em;
    
    @Override
    public Inventory getInventory(Integer inventoryId) throws PersistenceException {
        return (Inventory) em.createNamedQuery("Inventory.findInventory").setParameter("inventoryId", inventoryId).getSingleResult();
    }

    @Override
    public List<Inventory> getInventories() throws PersistenceException {
        return em.createNamedQuery("Inventory.getInventories").getResultList();
    }

    @Override
    public Boolean insertInventory(Inventory inventory) throws PersistenceException {
        em.persist(inventory);
        return true;
    }

    @Override
    public Boolean updateInventory(Inventory inventory) throws PersistenceException {
        em.merge(inventory);
        return true;
    }

    @Override
    public Boolean removeInventory(Inventory inventory) throws PersistenceException {
        em.remove(inventory);
        return true;
    }
    
}
