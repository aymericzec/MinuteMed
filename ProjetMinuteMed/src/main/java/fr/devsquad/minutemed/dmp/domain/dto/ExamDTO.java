/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.dmp.domain.dto;

import fr.devsquad.minutemed.dmp.domain.Exam;
import fr.devsquad.minutemed.dmp.domain.MedicalRecord;
import fr.devsquad.minutemed.dmp.domain.ResultExam;
import fr.devsquad.minutemed.dmp.repository.MedicalRecordRepository;
import fr.devsquad.minutemed.staff.domain.Doctor;
import fr.devsquad.minutemed.staff.repository.StaffRepository;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author enzo
 */
public class ExamDTO implements Serializable {
    
    private long id;
    
    private long doctorId;

    private long medicalRecordId;
    
    private String title;
    
    private String description;
    
    private String dateExam;
    
    private ResultExamDTO resultExam;
    
    private boolean draft;
    

    public ExamDTO() {
    }

    public ExamDTO(long id, long doctorId, long medicalRecordId, String title, String description, String dateExam, ResultExamDTO resultExam, boolean draft) {
        this.id = id;
        this.doctorId = doctorId;
        this.medicalRecordId = medicalRecordId;
        this.title = Objects.requireNonNull(title);
        this.description = Objects.requireNonNull(description);
        this.dateExam = Objects.requireNonNull(dateExam);
        this.resultExam = resultExam;
        this.draft = draft;
    }
    
    public static ExamDTO create(Exam exam){
        Objects.requireNonNull(exam);
        
        if (exam.getResultExam() == null) {
             return new ExamDTO(exam.getIdExam(),
                exam.getDoctor().getIdMedicalStaff(),
                exam.getMedicalRecord().getIdMedicalRecord(),
                exam.getTitle(),
                exam.getDescription(),
                exam.getDateExam(),
                null,
                exam.getDraft());
        }
        else {
             return new ExamDTO(exam.getIdExam(),
                exam.getDoctor().getIdMedicalStaff(),
                exam.getMedicalRecord().getIdMedicalRecord(),
                exam.getTitle(),
                exam.getDescription(),
                exam.getDateExam(),
                ResultExamDTO.create(exam.getResultExam()),
                exam.getDraft());
        }
    }
       
    
    public Exam toExam(StaffRepository staffRepository, MedicalRecordRepository medicalRecordRepository){
        Objects.requireNonNull(staffRepository);
        Objects.requireNonNull(medicalRecordRepository);
        Doctor doctor = staffRepository.findMedicalStaff(doctorId, Doctor.class);
        MedicalRecord record = medicalRecordRepository.find(medicalRecordId);
        Exam exam = new Exam(title, description, dateExam, doctor, record);
        if(this.resultExam != null){
            ResultExam resExam = this.resultExam.toResultExam(staffRepository);
            exam.setResultExam(resExam);
        }
        return exam;
    }
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateExam() {
        return dateExam;
    }

    public void setDateExam(String dateExam) {
        this.dateExam = dateExam;
    }

    public ResultExamDTO getResultExam() {
        return resultExam;
    }

    public void setResultExam(ResultExamDTO resultExam) {
        this.resultExam = resultExam;
    }

    public boolean isDraft() {
        return draft;
    }

    public void setDraft(boolean draft) {
        this.draft = draft;
    }
    
    
    
}
