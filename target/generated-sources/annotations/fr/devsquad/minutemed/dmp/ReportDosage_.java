package fr.devsquad.minutemed.dmp;

import fr.devsquad.minutemed.dmp.Dosage;
import fr.devsquad.minutemed.staff.MedicalStaff;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-30T19:37:23")
@StaticMetamodel(ReportDosage.class)
public class ReportDosage_ { 

    public static volatile SingularAttribute<ReportDosage, Dosage> dosage;
    public static volatile SingularAttribute<ReportDosage, String> report;
    public static volatile SingularAttribute<ReportDosage, Long> id;
    public static volatile SingularAttribute<ReportDosage, MedicalStaff> supervisor;
    public static volatile SingularAttribute<ReportDosage, Date> createDate;

}