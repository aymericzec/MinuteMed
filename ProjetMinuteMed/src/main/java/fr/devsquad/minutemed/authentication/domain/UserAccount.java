package fr.devsquad.minutemed.authentication.domain;

import com.google.common.hash.Hashing;
import static fr.devsquad.minutemed.authentication.domain.UserAccount.FIND_ALL_USER_ACCOUNT;
import fr.devsquad.minutemed.staff.domain.MedicalStaff;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@NamedQuery(name = FIND_ALL_USER_ACCOUNT, query = "SELECT u FROM UserAccount u")
public class UserAccount implements Serializable {
    
    public static final String FIND_ALL_USER_ACCOUNT = "UserAccount.findAllUserAccounts";

    @Id
    @GeneratedValue
    private long idAccount;
    
    @NotNull
    private String username;
    
    @NotNull
    private String password; //encrypted password

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idStaff")
    private MedicalStaff user;

    public UserAccount() {
    }

    public UserAccount(String username, String password, MedicalStaff user) {
        this.username = Objects.requireNonNull(username);
        this.password = Hashing.sha256().hashString(Objects.requireNonNull(password), StandardCharsets.UTF_8).toString();
        this.user = Objects.requireNonNull(user);
    }

    public long getIdAccount() {
        return idAccount;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public MedicalStaff getUser() {
        return user;
    }

    public void setPassword(String newPassword) {
        password = Objects.requireNonNull(newPassword);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserAccount)) {
            return false;
        }
        UserAccount otherAccount = (UserAccount) obj;
        return (otherAccount.getIdAccount() == idAccount
                && otherAccount.getUsername().equals(username)
                && otherAccount.getPassword().equals(password));
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash += idAccount * 31;
        hash += username.hashCode() * 33;
        hash += password.hashCode() * 32;
        return hash;
    }

}
