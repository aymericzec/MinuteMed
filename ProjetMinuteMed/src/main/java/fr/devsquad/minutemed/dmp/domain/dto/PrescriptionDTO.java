/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.dmp.domain.dto;

import fr.devsquad.minutemed.dmp.domain.Diagnostic;
import fr.devsquad.minutemed.dmp.domain.MedicalRecord;
import fr.devsquad.minutemed.dmp.domain.Prescription;
import fr.devsquad.minutemed.dmp.repository.DiagnosticRepository;
import fr.devsquad.minutemed.dmp.repository.MedicalRecordRepository;
import fr.devsquad.minutemed.staff.domain.Doctor;
import fr.devsquad.minutemed.staff.domain.MedicalStaff;
import fr.devsquad.minutemed.staff.repository.StaffRepository;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author enzo
 */
public class PrescriptionDTO implements Serializable {
    
    private long id;

    private long prescriptorId;

    private long medicalRecordId;
    
    private long diagnosticId;
    
    private String title;
    
    private String creationDate;

    private String body;
    
    private boolean draft;

    public PrescriptionDTO() {
    }

    public PrescriptionDTO(long id, long prescriptorId, long medicalRecordId, long diagnosticId, String title, String creationDate, String body, boolean draft) {
        this.id = id;
        this.prescriptorId = prescriptorId;
        this.medicalRecordId = medicalRecordId;
        this.diagnosticId = diagnosticId;
        this.title = Objects.requireNonNull(title);
        this.creationDate = Objects.requireNonNull(creationDate);
        this.body = Objects.requireNonNull(body);
        this.draft = draft;
    }
    
    public static PrescriptionDTO create(Prescription prescription){
        Objects.requireNonNull(prescription);
        return new PrescriptionDTO(prescription.getIdPrescription(),
                prescription.getPrescriptor().getIdMedicalStaff(),
                prescription.getMedicalRecord().getIdMedicalRecord(),
                prescription.getDiagnostic().getIdDiagnostic(),
                prescription.getTitle(),
                prescription.getCreationDate(),
                prescription.getBody(),
                prescription.isDraft());
    }
    
    public Prescription toPrescription(StaffRepository staffRepository, MedicalRecordRepository medicalRecordRepository, DiagnosticRepository diagnosticRepository){
        Objects.requireNonNull(staffRepository);
        Objects.requireNonNull(medicalRecordRepository);
        Objects.requireNonNull(diagnosticRepository);
        MedicalStaff prescriptor = staffRepository.findMedicalStaff(prescriptorId);
        MedicalRecord record = medicalRecordRepository.find(medicalRecordId);
        Diagnostic diagnostic = diagnosticRepository.find(diagnosticId);
        
        Prescription prescription = new Prescription(title, prescriptor, record, creationDate, diagnostic, body);
        
        if (!this.draft) {
            prescription.setDraft();
        }
        return prescription;
    }
    
    

    public long getId() {
        return id;
    }

    public void setIdP(long id) {
        this.id = id;
    }

    public long getPrescriptorId() {
        return prescriptorId;
    }

    public void setPrescriptorId(long prescriptorId) {
        this.prescriptorId = prescriptorId;
    }

    public long getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(long medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public long getDiagnosticId() {
        return diagnosticId;
    }

    public void setDiagnosticId(long diagnosticId) {
        this.diagnosticId = diagnosticId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isDraft() {
        return draft;
    }

    public void setDraft(boolean draft) {
        this.draft = draft;
    }
    
    
    
    
    
}
