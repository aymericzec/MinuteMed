package fr.devsquad.minutemed.authentication;

import java.util.*;

/**
 *
 * @author enzo
 */
public class Authenticator {
    
    private static final long ERROR_CODE = -1;
    
    private final AccountManager _accounts;
    
    private final ConnectedUserManager _connectedUsers;

    
    public Authenticator(AccountManager manager) {
        this._accounts = Objects.requireNonNull(manager);
        this._connectedUsers = new ConnectedUserManager();
    }
    

    public long login(String username, String password) throws AuthenticationException {
        UserAccount account = _accounts.getAccount(Objects.requireNonNull(username));
        if(account == null){ 
            throw new NullPointerException("This username [" + username + "] does not exists in the base !");
        }
        if(account.getUsername().equals(username)
            && account.getPassword().equals(Objects.requireNonNull(password))){
            _connectedUsers.login(account);
            return account.getUserid();
        }
        return ERROR_CODE; // password does not match username
    }
    
    
    public boolean logout(long userid) throws AuthenticationException {
        return _connectedUsers.logout(userid);
    }
        
}
