package fr.devsquad.minutemed.authentication;

import fr.devsquad.minutemed.staff.MedicalStaff;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-01T11:27:35")
@StaticMetamodel(UserAccount.class)
public class UserAccount_ { 

    public static volatile SingularAttribute<UserAccount, Long> idAccount;
    public static volatile SingularAttribute<UserAccount, String> password;
    public static volatile SingularAttribute<UserAccount, MedicalStaff> user;
    public static volatile SingularAttribute<UserAccount, String> username;

}