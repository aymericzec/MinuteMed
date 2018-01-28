package fr.devsquad.minutemed.dmp;

import fr.devsquad.minutemed.staff.Doctor;
import java.util.Date;


public class Prescription {

    private long id;
    private String title;
    private Doctor prescriptor;
    private MedicalRecord medicalRecord;
    private Date consultDate;
    private Diagnostic diagnostic;
    private String prescription;

    public Prescription(String title, Doctor prescriptor, MedicalRecord medicalRecord, Date consultDate, Diagnostic diagnostic, String prescription) {
        this.title = title;
        this.prescriptor = prescriptor;
        this.medicalRecord = medicalRecord;
        this.consultDate = consultDate;
        this.diagnostic = diagnostic;
        this.prescription = prescription;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Doctor getPrescriptor() {
        return prescriptor;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public Date getConsultDate() {
        return consultDate;
    }

    public Diagnostic getDiagnostic() {
        return diagnostic;
    }

    public String getPrescription() {
        return prescription;
    }

    
}
