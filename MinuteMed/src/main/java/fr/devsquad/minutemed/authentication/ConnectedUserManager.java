/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.authentication;

import java.util.*;

/**
 *
 * @author enzo
 */
public class ConnectedUserManager {
    
    private final Map<Long,UserAccount> _connected;

    
    public ConnectedUserManager() {
        this._connected = new HashMap<>();
    }

    
    public void login(UserAccount userAccount) throws AuthenticationException {
        if(_connected.containsKey(Objects.requireNonNull(userAccount).getUserid())){
            logout(userAccount.getUserid());
            throw new AuthenticationException("This user is already connected ! Must logout him !");
        }
        _connected.put(userAccount.getUserid(), userAccount);
    }
    
    
    public boolean logout(long userid) throws AuthenticationException {
        if(!_connected.containsKey(userid)){
            throw new AuthenticationException("This user is not even connected !");
        }
        return _connected.remove(userid) != null;
    }
    
    
}
