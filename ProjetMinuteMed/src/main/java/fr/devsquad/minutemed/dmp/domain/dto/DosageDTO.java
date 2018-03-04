/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.dmp.domain.dto;

import fr.devsquad.minutemed.dmp.domain.Diagnostic;
import fr.devsquad.minutemed.dmp.domain.Dosage;
import fr.devsquad.minutemed.dmp.domain.DosageReport;
import fr.devsquad.minutemed.dmp.domain.MedicalRecord;
import fr.devsquad.minutemed.dmp.repository.DiagnosticRepository;
import fr.devsquad.minutemed.dmp.repository.MedicalRecordRepository;
import fr.devsquad.minutemed.staff.domain.Doctor;
import fr.devsquad.minutemed.staff.domain.MedicalStaff;
import fr.devsquad.minutemed.staff.repository.StaffRepository;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author enzo
 */
public class DosageDTO implements Serializable {
    
    private Long id;
    
    private long medicalRecordId;

    private long creatorId;
    
    private long diagnosticId;
    
    private String title;
    
    private String creationDate;

    private String body;

    private String beginDosage;
    
    private String endDosage;
    
    private List<DosageReportDTO> reports;
    
    private boolean draft;
    

    public DosageDTO() {
    }

    public DosageDTO(Long id, long medicalRecordId, long creatorId, long diagnosticId, String title, String creationDate, String body, String beginDosage, String endDosage, List<DosageReportDTO> reports, boolean draft) {
        this.id = id;
        this.medicalRecordId = medicalRecordId;
        this.creatorId = creatorId;
        this.diagnosticId = diagnosticId;
        this.title = Objects.requireNonNull(title);
        this.creationDate = Objects.requireNonNull(creationDate);
        this.body = Objects.requireNonNull(body);
        this.beginDosage = Objects.requireNonNull(beginDosage);
        this.endDosage = Objects.requireNonNull(endDosage);
        this.reports = Objects.requireNonNull(reports);
        this.draft = draft;
    }
    
        public static DosageDTO create(Dosage dosage){
        Objects.requireNonNull(dosage);
        return new DosageDTO(dosage.getId(),
                dosage.getMedicalRecord().getIdMedicalRecord(),
                dosage.getCreator().getIdMedicalStaff(),
                dosage.getDiagnostic().getIdDiagnostic(),
                dosage.getTitle(),
                dosage.getCreationDate(),
                dosage.getBody(),
                dosage.getBeginDosage(),
                dosage.getEndDosage(),
                dosage.getReports().stream().map(DosageReportDTO::create).collect(Collectors.toList()),
                dosage.isDraft());
    }
    
    public Dosage toDosage(StaffRepository staffRepository, MedicalRecordRepository medicalRecordRepository, DiagnosticRepository diagnosticRepository){
        Objects.requireNonNull(staffRepository);
        Objects.requireNonNull(medicalRecordRepository);
        Objects.requireNonNull(diagnosticRepository);
        MedicalRecord record = medicalRecordRepository.find(medicalRecordId);
        MedicalStaff creator = staffRepository.findMedicalStaff(creatorId);
        Diagnostic diagnostic = diagnosticRepository.find(diagnosticId);
        Dosage dosage = new Dosage(title, creator, record, creationDate, diagnostic, body, beginDosage, endDosage);
        List<DosageReport> rs = reports.stream().map(dto -> dto.toDosageReport(staffRepository, dosage)).collect(Collectors.toList());
        rs.stream().forEach(dosage::addReport);
        return dosage;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(long medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
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

    public String getBeginDosage() {
        return beginDosage;
    }

    public void setBeginDosage(String beginDosage) {
        this.beginDosage = beginDosage;
    }

    public String getEndDosage() {
        return endDosage;
    }

    public void setEndDosage(String endDosage) {
        this.endDosage = endDosage;
    }

    public List<DosageReportDTO> getReports() {
        return reports;
    }

    public void setReports(List<DosageReportDTO> reports) {
        this.reports = reports;
    }

    public boolean isDraft() {
        return draft;
    }

    public void setDraft(boolean draft) {
        this.draft = draft;
    }
    
     
    
}
