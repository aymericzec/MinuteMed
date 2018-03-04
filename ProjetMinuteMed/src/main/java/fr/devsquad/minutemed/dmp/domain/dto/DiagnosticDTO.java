/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.dmp.domain.dto;

import fr.devsquad.minutemed.dmp.domain.Diagnostic;
import fr.devsquad.minutemed.dmp.domain.MedicalRecord;
import fr.devsquad.minutemed.dmp.repository.MedicalRecordRepository;
import fr.devsquad.minutemed.staff.domain.MedicalStaff;
import fr.devsquad.minutemed.staff.repository.StaffRepository;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author enzo
 */
public class DiagnosticDTO implements Serializable {
    
    private long id;
    
    private long creatorId;
    
    private long medicalRecordId;
    
    private String title;
    
    private String creationDate;
    
    private String body;
    
    private boolean draft;

    
    public DiagnosticDTO() {
    }

    public DiagnosticDTO(long id, long creatorId, long medicalRecordId, String title, String creationDate, String body, boolean draft) {
        this.id = id;
        this.creatorId = creatorId;
        this.medicalRecordId = medicalRecordId;
        this.title = Objects.requireNonNull(title);
        this.creationDate = Objects.requireNonNull(creationDate);
        this.body = Objects.requireNonNull(body);
        this.draft = draft;
    }
    
    public static DiagnosticDTO create(Diagnostic diagnostic){
        Objects.requireNonNull(diagnostic);
        return new DiagnosticDTO(diagnostic.getIdDiagnostic(),
                diagnostic.getCreator().getIdMedicalStaff(),
                diagnostic.getMedicalRecord().getIdMedicalRecord(), 
                diagnostic.getTitle(), 
                diagnostic.getCreationDate(), 
                diagnostic.getBody(), 
                diagnostic.isDraft());
    }
    
    
    public Diagnostic toDiagnostic(StaffRepository staffRepository, MedicalRecordRepository medicalRecordRepository){
        Objects.requireNonNull(staffRepository);
        Objects.requireNonNull(medicalRecordRepository);
        MedicalRecord record = medicalRecordRepository.find(medicalRecordId);
        MedicalStaff creator = staffRepository.findMedicalStaff(creatorId);
        return new Diagnostic(title, creator, record, creationDate, body);
    }
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }

    public long getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(long medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
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
