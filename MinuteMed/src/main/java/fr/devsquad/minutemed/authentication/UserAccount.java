package fr.devsquad.minutemed.authentication;

import fr.devsquad.minutemed.staff.IHospitalStaff;
import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.apache.commons.codec.digest.DigestUtils;

@Entity
public class UserAccount implements Serializable {

    @Id
    @GeneratedValue
    private long idAccount;
    private String username;
    private String password; //encrypted password

    @OneToOne
    @JoinColumn(name = "idStaff")
    private IHospitalStaff user;

    public UserAccount() {
    }

    public UserAccount(String username, String password, IHospitalStaff user) {
        this.username = Objects.requireNonNull(username);
        this.password = DigestUtils.sha256Hex(Objects.requireNonNull(password));
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

    public IHospitalStaff getUser() {
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
