package fr.devsquad.minutemed.dmp.domain;

import static fr.devsquad.minutemed.dmp.domain.ResultExam.FIND_ALL_RESULT_EXAM;
import fr.devsquad.minutemed.staff.domain.Doctor;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@NamedQuery(name = FIND_ALL_RESULT_EXAM, query = "SELECT u FROM ResultExam u")
public class ResultExam implements Serializable {
    public static final String FIND_ALL_RESULT_EXAM = "ResultExam.findAllResultExam";
    
    @Id @GeneratedValue
    private long idResultExam;
    
    @NotNull
    @ManyToOne @MapsId
    private Doctor examinator;
    
    @NotNull
    private String examDate;
    
    @NotNull
    private String body;
    
    @ElementCollection
    private final List<String> files = new ArrayList<>();
    
    
    public ResultExam() { }

    public ResultExam(Doctor examinator, String examDate, String body) {
        this.examinator = Objects.requireNonNull(examinator);
        this.examDate = Objects.requireNonNull(examDate);
        this.body = Objects.requireNonNull(body);
    }

    public long getIdResultExam() {
        return idResultExam;
    }

    public Doctor getExaminator() {
        return examinator;
    }

    public String getExamDate() {
        return examDate;
    }

    public String getBody() {
        return body;
    }

    public List<String> getFiles() {
        return files;
    }
    
    public void addFiles (String file) {
        files.add(Objects.requireNonNull(file));
    } 
}
