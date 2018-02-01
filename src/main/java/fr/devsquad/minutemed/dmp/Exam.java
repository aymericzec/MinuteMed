package fr.devsquad.minutemed.dmp;

import fr.devsquad.minutemed.staff.Doctor;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Exam implements Serializable {
    
    @Id @GeneratedValue
    @Column(name = "idExam")
    private long id;
    private String title;
    private String description;
    private String dateExam;
    @OneToOne
    @JoinColumn(name = "idDoctor")
    private Doctor doctor;
    @OneToOne
    @JoinColumn(name = "idMedicalRecord")
    private MedicalRecord medicalRecord;
    private boolean draft;
    @OneToOne
    @JoinColumn(name = "idResultExam")
    private ResultExam resultExam;
    
    public Exam() { }
    
    public Exam(String title, String description, String dateExam, Doctor doctor, MedicalRecord medicalRecord) {
        this.title = Objects.requireNonNull(title);
        this.description = Objects.requireNonNull(description);
        this.dateExam = Objects.requireNonNull(dateExam);
        this.doctor = Objects.requireNonNull(doctor);
        this.medicalRecord = Objects.requireNonNull(medicalRecord);
        this.draft = true;
    }
    
    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    
    public Doctor getDoctorAskExamination () {
         return doctor;
    }
 
    public MedicalRecord getMedicalRecord () {
         return medicalRecord;
    }
    
    public String getDescription () {
        return description;
    }
    
    public String getDateExam() {
        return dateExam;
    }
    
    public boolean getDraft() {
        return draft;
    }
    
    public ResultExam getResultExam() {
        return resultExam;
    }
    
    public void setDraft(boolean draft) {
        this.draft = draft;
    }
    
    public void setResultExam (ResultExam resultExam) {
        this.resultExam = resultExam;
    }
    
}
