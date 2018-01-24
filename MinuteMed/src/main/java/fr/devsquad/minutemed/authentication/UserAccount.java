package fr.devsquad.minutemed.authentication;

import java.util.*;

/**
 *
 * @author enzo
 */
public class UserAccount {
     
    private final long _userid;
    
    private final String _username;
    
    //encrypted password
    private String _password;
    

    public UserAccount(long userid, String username, String password) {
        this._userid = userid;
        this._username = Objects.requireNonNull(username);
        this._password = Objects.requireNonNull(password);
    }

    
    public long getUserid(){
        return _userid;
    }

    public String getUsername(){
        return _username;
    }
    
    public String getPassword(){
        return _password;
    }
    
    public void setPassword(String newPassword){
        _password = Objects.requireNonNull(newPassword);
    }   
    
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof UserAccount)){
            return false;
        }
        UserAccount otherAccount = (UserAccount) obj;
        return (otherAccount.getUserid() == _userid &&
                otherAccount.getUsername().equals(_username) &&
                otherAccount.getPassword().equals(_password));            
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash += _userid * 31;
        hash += _username.hashCode() * 33;
        hash += _password.hashCode() * 32;
        return hash;
    }
    
}
