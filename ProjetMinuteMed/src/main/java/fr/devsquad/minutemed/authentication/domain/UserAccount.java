package fr.devsquad.minutemed.authentication.domain;

import fr.devsquad.minutemed.jwt.util.PasswordUtils;
import fr.devsquad.minutemed.staff.domain.StaffEnum;
import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
        @NamedQuery(name = UserAccount.FIND_ALL_USER, query = "SELECT u FROM UserAccount u"),
        @NamedQuery(name = UserAccount.FIND_USER_BY_USERNAME, query = "SELECT u FROM UserAccount u WHERE u.username = :username"),
})
public class UserAccount implements Serializable {
    
    
    // ======================================
    // =             Constants              =
    // ======================================

    public static final String FIND_ALL_USER = "UserAccount.findAll";
    public static final String FIND_USER_BY_USERNAME = "UserAccount.findUSerByUsername";
    
    @Id
    private Long idAccount; //id of the medicalStaff associated
    
    @NotNull
    private String username;
    
    @NotNull
    private String password; //encrypted password

    @NotNull
    private String type;

    public UserAccount() {
    }

    public UserAccount(Long idAccount, String username, String password, StaffEnum type) {
        this.idAccount = Objects.requireNonNull(idAccount);
        this.username = Objects.requireNonNull(username);
        this.password = PasswordUtils.digestPassword(Objects.requireNonNull(password));
        this.type = Objects.requireNonNull(type).name();
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public void setPassword(String newPassword) {
        password = PasswordUtils.digestPassword(Objects.requireNonNull(newPassword));
    }
    
    public void setType(StaffEnum type){
        this.type = Objects.requireNonNull(type).name();
    }


}
