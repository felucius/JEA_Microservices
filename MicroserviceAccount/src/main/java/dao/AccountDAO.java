/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Account;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author M
 */
public interface AccountDAO {
    Account getAccount(Integer accountId) throws PersistenceException;
    
    Account getAccountByUsername(String username) throws PersistenceException;
    
    List<Account> getAccounts() throws PersistenceException;
    
    Boolean insertAccount(Account account) throws PersistenceException;
    
    Boolean updateAccount(Account account) throws PersistenceException;

    Boolean removeAccount(Account account) throws PersistenceException;
    
    Account loginAccount(Account account) throws PersistenceException;
}
