/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.dmp.domain.dto;

import fr.devsquad.minutemed.dmp.domain.ResultExam;
import fr.devsquad.minutemed.staff.domain.Doctor;
import fr.devsquad.minutemed.staff.domain.MedicalStaff;
import fr.devsquad.minutemed.staff.repository.StaffRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author enzo
 */
public class ResultExamDTO implements Serializable {
    
    private long id;
    
    private long examinatorId;
    
    private String examDate;

    private String body;
    
    private final List<String> files = new ArrayList<>();

    public ResultExamDTO() {
    }

    public ResultExamDTO(long id, long examinatorId, String examDate, String body) {
        this.id = id;
        this.examinatorId = examinatorId;
        this.examDate = Objects.requireNonNull(examDate);
        this.body = Objects.requireNonNull(body);
    }

    public static ResultExamDTO create(ResultExam resultExam){
        Objects.requireNonNull(resultExam);
        return new ResultExamDTO(resultExam.getIdResultExam(),
                resultExam.getExaminator().getIdMedicalStaff(),
                resultExam.getExamDate(),
                resultExam.getBody());
    }
    
    public ResultExam toResultExam(StaffRepository staffRepository){
        Objects.requireNonNull(staffRepository);
        MedicalStaff examinator = staffRepository.findMedicalStaff(examinatorId);
        return new ResultExam(examinator, examDate, body);
    }
   
    
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getExaminatorId() {
        return examinatorId;
    }

    public void setExaminatorId(long examinatorId) {
        this.examinatorId = examinatorId;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    
    
    
    
    
    
}
