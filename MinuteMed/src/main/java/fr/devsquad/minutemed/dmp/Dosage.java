package fr.devsquad.minutemed.dmp;

import fr.devsquad.minutemed.staff.Doctor;
import fr.devsquad.minutemed.staff.IHospitalStaff;
import fr.devsquad.minutemed.staff.MedicalStaff;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Dosage implements Serializable {
    
    @Id @GeneratedValue
    @Column(name = "idDosage")
    private long id;
    private String title;
    @OneToOne
    @JoinColumn(name = "idDoctor")
    private Doctor doctorConsulting;
    @OneToOne
    @JoinColumn(name = "idMedicalRecord")
    private MedicalRecord medicalRecord;
    @Temporal(TemporalType.DATE)
    private Date dateDosage;
    @OneToOne
    @JoinColumn(name = "idDiagnostic")
    private Diagnostic diagnostic;
    private String dosagePrescription;
    @OneToMany(mappedBy = "dosage")
    private List<ReportDosage> report;
    @Temporal(TemporalType.DATE)
    private Date beginDosage;
    @Temporal(TemporalType.DATE)
    private Date endDosage;
    private boolean draft;
    
    public Dosage () {
        
    }
    
    public Dosage (String title, Doctor doctorConsulting, MedicalRecord medicalRecord, Date dateDosage, Diagnostic diagnostic, String dosagePrescription, Date beginDosage, Date endDosage) {
        this.title = title;
        this.doctorConsulting = doctorConsulting;
        this.dateDosage = dateDosage;
        this.diagnostic = diagnostic;
        this.dosagePrescription = dosagePrescription;
        this.report = new ArrayList();
        this.beginDosage = beginDosage;
        this.endDosage = endDosage;
        this.draft = true;
    }

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }

    public Doctor getDoctorConsulting() {
        return doctorConsulting;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public Date getDateDosage() {
        return dateDosage;
    }

    public Diagnostic getDiagnostic() {
        return diagnostic;
    }

    public String getDosagePrescription() {
        return dosagePrescription;
    }

    public List<ReportDosage> getRepport() {
        return report;
    }

    public Date getBeginDosage() {
        return beginDosage;
    }

    public Date getEndDosage() {
        return endDosage;
    }
    
    public boolean getDraft() {
        return draft;
    }
    
    public void setDraft(boolean draft) {
        this.draft = draft;
    }
    
    public ReportDosage getLastReport () {
        if (report.size() > 0) {
            return report.get(0);
        }
        
        return null;
    }
    
    public void addReport (MedicalStaff staff, Date dateDosage, String repport) {
        ReportDosage reportDosage = new ReportDosage(staff, dateDosage, repport);
        this.report.add(reportDosage);
    }

    
    
}
