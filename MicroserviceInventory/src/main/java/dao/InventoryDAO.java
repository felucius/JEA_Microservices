/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Inventory;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author M
 */
public interface InventoryDAO {
    Inventory getInventory(Integer inventoryId) throws PersistenceException;
    
    List<Inventory> getInventories() throws PersistenceException;
    
    Boolean insertInventory(Inventory inventory) throws PersistenceException;
    
    Boolean updateInventory(Inventory inventory) throws PersistenceException;
    
    Boolean removeInventory(Inventory inventory) throws PersistenceException;
}
