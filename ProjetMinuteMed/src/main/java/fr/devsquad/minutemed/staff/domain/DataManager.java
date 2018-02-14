package fr.devsquad.minutemed.staff.domain;

import fr.devsquad.minutemed.arborescence.domain.*;
import static fr.devsquad.minutemed.staff.domain.DataManager.FIND_ALL_DATAMANAGER;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@DiscriminatorValue("DATA_MANAGER")
@NamedQuery(name = FIND_ALL_DATAMANAGER, query = "SELECT staff FROM DataManager staff")
public class DataManager extends MedicalStaff implements Serializable {

    public static final String FIND_ALL_DATAMANAGER = "DataManager.findAllDataManager";
    
    private static final String STATUS = "DATA_MANAGER";
 
    public DataManager() {
        super(STATUS);
    }

    public DataManager(String firstName, String lastName, String address, String email, String phoneNumber, Node node) {
        super(STATUS, Objects.requireNonNull(firstName), Objects.requireNonNull(lastName), Objects.requireNonNull(address),
                Objects.requireNonNull(email), Objects.requireNonNull(phoneNumber), Objects.requireNonNull(node));
    }
    
}
