package fr.devsquad.minutemed.dmp;

import fr.devsquad.minutemed.dmp.Diagnostic;
import fr.devsquad.minutemed.dmp.MedicalRecord;
import fr.devsquad.minutemed.dmp.ReportDosage;
import fr.devsquad.minutemed.staff.Doctor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-31T10:15:23")
@StaticMetamodel(Dosage.class)
public class Dosage_ { 

    public static volatile SingularAttribute<Dosage, Date> dateDosage;
    public static volatile SingularAttribute<Dosage, Date> beginDosage;
    public static volatile SingularAttribute<Dosage, Doctor> doctorConsulting;
    public static volatile SingularAttribute<Dosage, String> dosagePrescription;
    public static volatile SingularAttribute<Dosage, Boolean> draft;
    public static volatile SingularAttribute<Dosage, MedicalRecord> medicalRecord;
    public static volatile ListAttribute<Dosage, ReportDosage> report;
    public static volatile SingularAttribute<Dosage, Date> endDosage;
    public static volatile SingularAttribute<Dosage, Long> id;
    public static volatile SingularAttribute<Dosage, Diagnostic> diagnostic;
    public static volatile SingularAttribute<Dosage, String> title;

}