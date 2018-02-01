package fr.devsquad.minutemed.dmp;

import fr.devsquad.minutemed.staff.Doctor;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-01T11:27:35")
@StaticMetamodel(ResultExam.class)
public class ResultExam_ { 

    public static volatile SingularAttribute<ResultExam, Doctor> examinator;
    public static volatile SingularAttribute<ResultExam, Date> examDate;
    public static volatile SingularAttribute<ResultExam, List> files;
    public static volatile SingularAttribute<ResultExam, Long> id;
    public static volatile SingularAttribute<ResultExam, String> results;

}