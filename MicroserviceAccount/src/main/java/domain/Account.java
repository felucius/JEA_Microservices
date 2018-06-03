/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author M
 */
@Stateless
@Entity
@NamedQueries({
    @NamedQuery(name = "Account.findAccount", query = "SELECT a from Account a WHERE a.Id = :accountId"),
    @NamedQuery(name = "Account.getAccounts", query = "SELECT a from Account a"),
    @NamedQuery(name = "Account.login", query = "SELECT a from Account a WHERE a.username = :username"),
    @NamedQuery(name = "Account.findAccountByUsername", query = "SELECT a FROM Account a WHERE a.username = :username")
})
public class Account implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String name;
    private String username;
    private String password;
    
    public Account() {
        
    }
    
    public Account(String name, String username, String password){
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
