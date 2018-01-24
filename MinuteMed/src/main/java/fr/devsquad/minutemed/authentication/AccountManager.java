/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.authentication;

import com.google.common.hash.Hashing;
import fr.devsquad.minutemed.staff.IHospitalStaff;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.*;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author enzo
 */
public class AccountManager {
    
    private final Map<String, UserAccount> accounts;
    
    
    private AccountManager(Map<String,UserAccount> accounts) {
        this.accounts = Objects.requireNonNull(accounts);
    }
    
    
    public static AccountManager create(List<UserAccount> accountsList){
        Map<String,UserAccount> accounts = Objects.requireNonNull(accountsList)
                .stream()
                .collect(Collectors.toMap(acc -> acc.getUsername(), acc -> acc));
        return new AccountManager(accounts);
    }
    
    
    public boolean createAccount(String username, String password, IHospitalStaff user){
        UserAccount userAccount = new UserAccount(username, Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString(), user);
        if(!accounts.containsKey(userAccount.getUsername())){
            return accounts.put(userAccount.getUsername(), userAccount) != null;
        }
        return false;
    }
    
    
    public boolean removeAccount(String username){
        return accounts.remove(Objects.requireNonNull(username)) != null;
    }
    
    
    public UserAccount getAccount(String username){
        return accounts.get(Objects.requireNonNull(username));
    }
    
        
    public boolean modifyPassword(long userid, String username, String newPassword){
        if(accounts.containsKey(Objects.requireNonNull(username))){
           accounts.get(username).setPassword(Hashing.sha256().hashString(Objects.requireNonNull(newPassword), StandardCharsets.UTF_8).toString());
           return true;
        }
        return false;
    }
    
}
