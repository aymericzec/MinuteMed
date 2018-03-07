/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.dmp.domain.dto;

import fr.devsquad.minutemed.dmp.domain.Dosage;
import fr.devsquad.minutemed.dmp.domain.DosageReport;
import fr.devsquad.minutemed.staff.domain.MedicalStaff;
import fr.devsquad.minutemed.staff.repository.StaffRepository;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author enzo
 */
public class DosageReportDTO implements Serializable {
    
    private long id;
    
    private MedicalStaffDTO supervisor;
    
    private long dosageId;
    
    private String creationDate;

    private String body;

    public DosageReportDTO() {
    }

    public DosageReportDTO(long id, MedicalStaffDTO supervisor, long dosageId, String creationDate, String body) {
        this.id = id;
        this.supervisor = supervisor;
        this.dosageId = dosageId;
        this.creationDate = Objects.requireNonNull(creationDate);
        this.body = Objects.requireNonNull(body);
    }
    
    public static DosageReportDTO create(DosageReport dosageReport){
        Objects.requireNonNull(dosageReport);
        return new DosageReportDTO(dosageReport.getIdReportDosage(),
                MedicalStaffDTO.create(dosageReport.getSupervisor()),
                dosageReport.getDosage().getIdDosage(),
                dosageReport.getCreationDate(),
                dosageReport.getBody());
    }
    
    public DosageReport toDosageReport(StaffRepository repository, Dosage dosage){
        Objects.requireNonNull(repository);
        Objects.requireNonNull(dosage);
        MedicalStaff supervisor = repository.findMedicalStaff(this.supervisor.getId());
        return new DosageReport(supervisor, dosage, creationDate, body);
    }
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MedicalStaffDTO getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(MedicalStaffDTO supervisor) {
        this.supervisor = supervisor;
    }

    public long getDosageId() {
        return dosageId;
    }

    public void setDosageId(long dosageId) {
        this.dosageId = dosageId;
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
    
    
    
    
    
}
