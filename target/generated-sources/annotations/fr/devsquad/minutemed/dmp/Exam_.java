package fr.devsquad.minutemed.dmp;

import fr.devsquad.minutemed.dmp.MedicalRecord;
import fr.devsquad.minutemed.dmp.ResultExam;
import fr.devsquad.minutemed.staff.Doctor;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-01T15:01:32")
@StaticMetamodel(Exam.class)
public class Exam_ { 

    public static volatile SingularAttribute<Exam, Doctor> doctor;
    public static volatile SingularAttribute<Exam, Boolean> draft;
    public static volatile SingularAttribute<Exam, MedicalRecord> medicalRecord;
    public static volatile SingularAttribute<Exam, String> description;
    public static volatile SingularAttribute<Exam, String> dateExam;
    public static volatile SingularAttribute<Exam, Long> id;
    public static volatile SingularAttribute<Exam, String> title;
    public static volatile SingularAttribute<Exam, ResultExam> resultExam;

}