/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.authentication;

import java.util.*;
import java.util.stream.*;

/**
 *
 * @author enzo
 */
public class AccountManager {
    
    private final Map<String,UserAccount> _accounts;
    
    
    private AccountManager(Map<String,UserAccount> accounts) {
        this._accounts = Objects.requireNonNull(accounts);
    }
    
    
    public static AccountManager create(List<UserAccount> accountsList){
        Map<String,UserAccount> accounts = Objects.requireNonNull(accountsList)
                .stream()
                .collect(Collectors.toMap(acc -> acc.getUsername(), acc -> acc));
        return new AccountManager(accounts);
    }
    
    
    public boolean createAccount(long userid, String username, String password){
        UserAccount userAccount = new UserAccount(userid, username, password);
        if(!_accounts.containsKey(userAccount.getUsername())){
            return _accounts.put(userAccount.getUsername(), userAccount) != null;
        }
        return false;
    }
    
    
    public boolean removeAccount(String username){
        return _accounts.remove(Objects.requireNonNull(username)) != null;
    }
    
    
    public UserAccount getAccount(String username){
        return _accounts.get(Objects.requireNonNull(username));
    }
    
        
    public boolean modifyPassword(long userid, String username, String newPassword){
        if(_accounts.containsKey(Objects.requireNonNull(username))){
           _accounts.get(username).setPassword(Objects.requireNonNull(newPassword));
           return true;
        }
        return false;
    }
    
}
