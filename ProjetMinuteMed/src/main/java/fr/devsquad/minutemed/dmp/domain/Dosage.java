package fr.devsquad.minutemed.dmp.domain;

import static fr.devsquad.minutemed.dmp.domain.Dosage.FIND_ALL_DOSAGE;
import fr.devsquad.minutemed.staff.domain.Doctor;
import fr.devsquad.minutemed.staff.domain.MedicalStaff;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = FIND_ALL_DOSAGE, query = "SELECT u FROM Dosage u")
public class Dosage implements Serializable {
    public static final String FIND_ALL_DOSAGE = "Dosage.findAllDosage";
    
    @Id @GeneratedValue
    @Column(name = "idDosage")
    private long id;
    private String title;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idDoctor")
    private Doctor doctorConsulting;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idMedicalRecord")
    private MedicalRecord medicalRecord;
    private String dateDosage;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idDiagnostic")
    private Diagnostic diagnostic;
    private String dosagePrescription;
    @OneToMany(mappedBy = "dosage", cascade = CascadeType.PERSIST)
    private List<ReportDosage> report;
    private String beginDosage;
    private String endDosage;
    private boolean draft;
    
    public Dosage () {
        
    }
    
    public Dosage (String title, Doctor doctorConsulting, MedicalRecord medicalRecord, String dateDosage, Diagnostic diagnostic, String dosagePrescription, String beginDosage, String endDosage) {
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

    public String getDateDosage() {
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

    public String getBeginDosage() {
        return beginDosage;
    }

    public String getEndDosage() {
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
    
    public void addReport (MedicalStaff staff, String dateDosage, String repport) {
        ReportDosage reportDosage = new ReportDosage(staff, dateDosage, repport);
        this.report.add(reportDosage);
    }
    
}
