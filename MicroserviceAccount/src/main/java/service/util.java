/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Account;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author M
 */
@Singleton
@Startup
public class util {
    
    @Inject
    AccountService accountService;
    
    @PostConstruct
    public void init(){
        Account account = new Account("Maxime", "Maximizer", "1234");
        
        accountService.insertAccount(account);
    }
}
