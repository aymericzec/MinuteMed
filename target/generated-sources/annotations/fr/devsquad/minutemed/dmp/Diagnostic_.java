package fr.devsquad.minutemed.dmp;

import fr.devsquad.minutemed.dmp.MedicalRecord;
import fr.devsquad.minutemed.staff.Doctor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-31T10:15:23")
@StaticMetamodel(Diagnostic.class)
public class Diagnostic_ { 

    public static volatile SingularAttribute<Diagnostic, Doctor> diagnosticDoctor;
    public static volatile SingularAttribute<Diagnostic, Boolean> draft;
    public static volatile SingularAttribute<Diagnostic, MedicalRecord> medicalRecord;
    public static volatile SingularAttribute<Diagnostic, String> description;
    public static volatile SingularAttribute<Diagnostic, Long> id;
    public static volatile SingularAttribute<Diagnostic, String> title;
    public static volatile SingularAttribute<Diagnostic, Date> consultDiagnostic;

}