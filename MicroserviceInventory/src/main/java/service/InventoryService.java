/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.InventoryDAO;
import domain.Inventory;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;

/**
 *
 * @author M
 */
@Stateless
public class InventoryService {

    @Inject
    InventoryDAO inventoryDAO;
    
    public Inventory getInventory(Integer inventoryId) throws PersistenceException {
        return inventoryDAO.getInventory(inventoryId);
    }


    public List<Inventory> getInventories() throws PersistenceException {
        return inventoryDAO.getInventories();
    }

    public Boolean insertInventory(Inventory inventory) throws PersistenceException {
        return inventoryDAO.insertInventory(inventory);
    }

    public Boolean updateInventory(Inventory inventory) throws PersistenceException {
        return inventoryDAO.updateInventory(inventory);
    }

    public Boolean removeInventory(Inventory inventory) throws PersistenceException {
        return inventoryDAO.removeInventory(inventory);
    }
}
