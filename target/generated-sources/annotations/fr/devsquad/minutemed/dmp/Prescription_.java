package fr.devsquad.minutemed.dmp;

import fr.devsquad.minutemed.dmp.Diagnostic;
import fr.devsquad.minutemed.dmp.MedicalRecord;
import fr.devsquad.minutemed.staff.Doctor;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-01T15:01:32")
@StaticMetamodel(Prescription.class)
public class Prescription_ { 

    public static volatile SingularAttribute<Prescription, String> consultDate;
    public static volatile SingularAttribute<Prescription, String> prescription;
    public static volatile SingularAttribute<Prescription, Doctor> prescriptor;
    public static volatile SingularAttribute<Prescription, Boolean> draft;
    public static volatile SingularAttribute<Prescription, MedicalRecord> medicalRecord;
    public static volatile SingularAttribute<Prescription, Long> id;
    public static volatile SingularAttribute<Prescription, Diagnostic> diagnostic;
    public static volatile SingularAttribute<Prescription, String> title;

}