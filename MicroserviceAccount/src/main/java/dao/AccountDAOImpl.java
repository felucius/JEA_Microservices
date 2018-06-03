/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Account;
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
public class AccountDAOImpl implements AccountDAO {

    @PersistenceContext(name = "MicroserviceAccountPU")
    EntityManager em;

    @Override
    public Account getAccount(Integer accountId) throws PersistenceException {
        return (Account) em.createNamedQuery("Account.findAccount").setParameter("accountId", accountId).getSingleResult();
    }

    @Override
    public List<Account> getAccounts() throws PersistenceException {
        return em.createNamedQuery("Account.getAccounts").getResultList();
    }

    @Override
    public Boolean insertAccount(Account account) throws PersistenceException {
        em.persist(account);
        return true;
    }

    @Override
    public Boolean updateAccount(Account account) throws PersistenceException {
        em.merge(account);
        return true;
    }

    @Override
    public Boolean removeAccount(Account account) throws PersistenceException {
        em.remove(account);
        return true;
    }

    @Override
    public Account loginAccount(Account account) throws PersistenceException {
        try {
            Account a =(Account) em.createNamedQuery("Account.login").setParameter("username", account.getUsername()).getSingleResult();
            return a;
        } catch (PersistenceException pe) {
            pe.getMessage();
            return null;
        }
    }

    @Override
    public Account getAccountByUsername(String username) throws PersistenceException {
        try{
            Account a = (Account) em.createNamedQuery("Account.findAccountByUsername").setParameter("username", username).getSingleResult();
            return a;
        }catch(PersistenceException pe){
            pe.getMessage();
            return null;
        }
    }

}
