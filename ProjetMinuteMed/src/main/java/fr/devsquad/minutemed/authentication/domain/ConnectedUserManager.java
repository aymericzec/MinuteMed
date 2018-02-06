/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.authentication.domain;

import java.util.*;

/**
 *
 * @author enzo
 */
public class ConnectedUserManager {
    
    private final Map<Long, UserAccount> connected;

    
    public ConnectedUserManager() {
        this.connected = new HashMap<>();
    }

    
    public void login(UserAccount userAccount) throws AuthenticationException {
        if(connected.containsKey(Objects.requireNonNull(userAccount).getIdAccount())){
            logout(userAccount.getIdAccount());
            throw new AuthenticationException("This user is already connected ! Must logout him !");
        }
        connected.put(userAccount.getIdAccount(), userAccount);
    }
    
    
    public boolean logout(long idAccount) throws AuthenticationException {
        if(!connected.containsKey(idAccount)){
            throw new AuthenticationException("This user is not even connected !");
        }
        return connected.remove(idAccount) != null;
    }
    
    
}
