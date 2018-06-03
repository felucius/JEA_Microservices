/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import domain.Account;
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
import service.AccountService;

/**
 *
 * @author M
 */
@Stateless
@Path("accounts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountRest {

    @Inject
    AccountService accountService;

    @GET
    @Path("{id}")
    public Account getAccount(@PathParam("id") Integer accountId) throws PersistenceException {
        return accountService.getAccount(accountId);
    }

    @GET
    public List<Account> getAccounts() throws PersistenceException {
        return accountService.getAccounts();
    }

    @POST
    public Boolean insertAccount(Account account) throws PersistenceException {
        return accountService.insertAccount(account);
    }

    @PUT
    public Boolean updateAccount(Account account) throws PersistenceException {
        return accountService.updateAccount(account);
    }

    @DELETE
    public Boolean removeAccount(Account account) throws PersistenceException {
        return accountService.removeAccount(account);
    }

    @GET
    @Path("username/{username}")
    public Account getAccountByUsername(@PathParam("username") String username) throws PersistenceException {
        return accountService.getAccountByUsername(username);
    }

    // Authentication
    @POST
    @Path("login")
    public Account loginAccount(Account account) throws PersistenceException {
        return accountService.loginAccount(account);
    }
}
