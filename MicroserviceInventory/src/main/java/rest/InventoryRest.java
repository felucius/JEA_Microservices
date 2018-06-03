/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import domain.Inventory;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import service.InventoryService;

/**
 *
 * @author M
 */
@Stateless
@Path("inventories")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InventoryRest {

    @Inject
    InventoryService inventoryService;

    @GET
    @Path("{id}")
    public Inventory getInventory(@PathParam("id") Integer inventoryId) throws PersistenceException {
        return inventoryService.getInventory(inventoryId);
    }

    @GET
    public List<Inventory> getInventories() throws PersistenceException {
        return inventoryService.getInventories();
    }

    @POST
    public Boolean insertInventory(Inventory inventory) throws PersistenceException {
        return inventoryService.insertInventory(inventory);
    }

    @PUT
    public Boolean updateInventory(Inventory inventory) throws PersistenceException {
        return inventoryService.updateInventory(inventory);
    }
    
    @Remove
    public Boolean removeInventory(Inventory inventory) throws PersistenceException {
        return inventoryService.removeInventory(inventory);
    }
}
