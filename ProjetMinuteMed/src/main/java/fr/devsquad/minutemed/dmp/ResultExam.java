package fr.devsquad.minutemed.dmp;

import fr.devsquad.minutemed.staff.Doctor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ResultExam implements Serializable {

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
