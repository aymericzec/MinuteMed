package fr.devsquad.minutemed.staff.domain;

import fr.devsquad.minutemed.authentication.domain.UserAccount;
import fr.devsquad.minutemed.specialization.domain.Specialization;
import static fr.devsquad.minutemed.staff.domain.DataManager.FIND_ALL_DATAMANAGER;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = FIND_ALL_DATAMANAGER, query = "SELECT staff FROM DataManager staff")
public class DataManager implements Serializable, IHospitalStaff {

    public static final String FIND_ALL_DATAMANAGER = "DataManager.findAllDataManager";
    
    @Id
    @GeneratedValue
    @Column(name = "idDataManager")
    private long id;
    private String type;
    private String firstName;
    private String lastName;
    private String adress;
    private String email;
    private String phoneNumber;

    public DataManager() {
    }

    public DataManager(StaffEnum type, String firstName, String lastName, String adress, String email, String phoneNumber) {
        if( type == null){
            throw new NullPointerException();
        }
        if( firstName == null){
            throw new NullPointerException();
        }
        if( lastName == null){
            throw new NullPointerException();
        }
        if( adress == null){
            throw new NullPointerException();
        }
        if( email == null){
            throw new NullPointerException();
        }
        if( phoneNumber == null){
            throw new NullPointerException();
        }
        
        if( stringNotConform(firstName) ){
            throw new IllegalArgumentException();
        }
        if( stringNotConform(lastName) ){
            throw new IllegalArgumentException();
        }
        if( stringNotConform(adress) ){
            throw new IllegalArgumentException();
        }
        if( stringNotConform(email) ){
            throw new IllegalArgumentException();
        }
        if( stringNotConform(phoneNumber) ){
            throw new IllegalArgumentException();
        }
        
        this.type = type.DATAMANAGER.name();
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    private static boolean stringNotConform(String s){
        return s.matches("[ ]*");
    }

    @Override
    public long getId() {
        return id;
    }
    
    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getAdress() {
        return adress;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void setFirstName(String firstName) {
        if(firstName==null){
            throw new NullPointerException();
        }
        if(stringNotConform(firstName) ){
            throw new IllegalArgumentException();
        }
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        if(lastName==null){
            throw new NullPointerException();
        }
        if(stringNotConform(lastName) ){
            throw new IllegalArgumentException();
        }
        this.lastName = lastName;
    }

    @Override
    public void setAdress(String adress) {
        if(adress==null){
            throw new NullPointerException();
        }
        if(stringNotConform(adress) ){
            throw new IllegalArgumentException();
        }
        this.adress = adress;
    }

    @Override
    public void setEmail(String email) {
        if(email==null){
            throw new NullPointerException();
        }
        if(stringNotConform(email) ){
            throw new IllegalArgumentException();
        }
        this.email = email;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber==null){
            throw new NullPointerException();
        }
        if(stringNotConform(phoneNumber) ){
            throw new IllegalArgumentException();
        }
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public String toString() {
        StringBuilder stb =  new StringBuilder();
        stb.append("DataManager :").append(this.lastName).append(this.firstName);
        return stb.toString();
    }
}
