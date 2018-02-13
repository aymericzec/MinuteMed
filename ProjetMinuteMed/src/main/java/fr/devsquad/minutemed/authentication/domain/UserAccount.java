package fr.devsquad.minutemed.authentication.domain;

import com.google.common.hash.Hashing;
import fr.devsquad.minutemed.staff.domain.StaffEnum;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class UserAccount implements Serializable {
    
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
        this.password = Hashing.sha256().hashString(Objects.requireNonNull(password), StandardCharsets.UTF_8).toString();
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
        password = Objects.requireNonNull(newPassword);
    }
    
    public void setType(StaffEnum type){
        this.type = Objects.requireNonNull(type).name();
    }


}
