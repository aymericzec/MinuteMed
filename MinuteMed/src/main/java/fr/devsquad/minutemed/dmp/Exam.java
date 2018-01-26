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
    @Temporal(TemporalType.DATE)
    private Date dateExam;
    @OneToOne
    @JoinColumn(name = "idStaff")
    private Doctor doctor;
    @OneToOne
    @JoinColumn(name = "idMedicalRecord")
    private MedicalRecord medicalRecord;
    private boolean draft;
    
    public Exam() { }
    
    public Exam(String title, String description, Date dateExam, Doctor doctor, MedicalRecord medicalRecord) {
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
 
    public MedicalRecord getPatient () {
         return medicalRecord;
    }
    
    public String getDescription () {
        return description;
    }
    
    public Date getDateExam() {
        return dateExam;
    }
    
    public boolean getDraft() {
        return draft;
    }
    
    public void setDraft(boolean draft) {
        this.draft = draft;
    }
    
    public IAnnex getAnnexes () {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ResultExam getResultExam () {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setResultExam (ResultExam resultExam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
