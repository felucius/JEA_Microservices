/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AccountDAO;
import domain.Account;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;

/**
 *
 * @author M
 */
@Stateless
public class AccountService {

    @Inject
    AccountDAO accountDAO;

    public Account getAccount(Integer accountId) throws PersistenceException {
        return accountDAO.getAccount(accountId);
    }

    public List<Account> getAccounts() throws PersistenceException {
        return accountDAO.getAccounts();
    }

    public Boolean insertAccount(Account account) throws PersistenceException {
        return accountDAO.insertAccount(account);
    }

    public Boolean updateAccount(Account account) throws PersistenceException {
        return accountDAO.updateAccount(account);
    }

    public Boolean removeAccount(Account account) throws PersistenceException {
        return accountDAO.removeAccount(account);
    }

    public Account loginAccount(Account account) throws PersistenceException {
        return accountDAO.loginAccount(account);
    }

    public Account getAccountByUsername(String username) throws PersistenceException {
        return accountDAO.getAccountByUsername(username);
    }
}
