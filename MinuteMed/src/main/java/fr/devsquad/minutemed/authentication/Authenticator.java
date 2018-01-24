package fr.devsquad.minutemed.authentication;

import com.google.common.hash.Hashing;
import fr.devsquad.minutemed.database.JPAAuthentication;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 *
 * @author enzo
 */
public class Authenticator {
    
    private static final long ERROR_CODE = -1;
    
    private final AccountManager accounts;
    
    private final ConnectedUserManager connectedUsers;

    
    public Authenticator(AccountManager manager) {
        this.accounts = Objects.requireNonNull(manager);
        this.connectedUsers = new ConnectedUserManager();
    }
    

    public long login(String username, String password) throws AuthenticationException {
        //UserAccount account = accounts.getAccount(Objects.requireNonNull(username));
        JPAAuthentication auth = new JPAAuthentication();
        UserAccount account = auth.login(username, Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString());
        
        if(account == null){ 
            throw new NullPointerException("This username [" + username + "] does not exists in the base !");
        }
        if(account.getUsername().equals(username)
            && account.getPassword().equals(Hashing.sha256().hashString(Objects.requireNonNull(password), StandardCharsets.UTF_8).toString())){
            connectedUsers.login(account);
            return account.getIdAccount();
        }
        return ERROR_CODE; // password does not match username
    }
    
    
    public boolean logout(long userid) throws AuthenticationException {
        return connectedUsers.logout(userid);
    }
        
}
