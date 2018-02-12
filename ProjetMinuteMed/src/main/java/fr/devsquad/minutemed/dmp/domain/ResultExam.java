package fr.devsquad.minutemed.dmp.domain;

import static fr.devsquad.minutemed.dmp.domain.ResultExam.FIND_ALL_RESULT_EXAM;
import fr.devsquad.minutemed.staff.domain.Doctor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = FIND_ALL_RESULT_EXAM, query = "SELECT u FROM ResultExam u")
public class ResultExam implements Serializable {
    public static final String FIND_ALL_RESULT_EXAM = "ResultExam.findAllResultExam";
    @Id @GeneratedValue
    @Column(name = "idResultExam")
    private long id;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idDoctor")
    private Doctor examinator;
    private String examDate;
    private String results;
    private final List<String> files = new ArrayList<>();
    
    public ResultExam() { }

    public ResultExam(Doctor examinator, String examDate, String results) {
        this.examinator = examinator;
        this.examDate = examDate;
        this.results = results;
    }

    public long getId() {
        return id;
    }

    public Doctor getExaminator() {
        return examinator;
    }

    public String getExamDate() {
        return examDate;
    }

    public String getResult() {
        return results;
    }

    public List<String> getFiles() {
        return files;
    }
    
    public void addFiles (String s) {
        files.add(s);
    } 
}
