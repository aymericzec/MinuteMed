/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.dmp;

import fr.devsquad.minutemed.staff.Doctor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author myfou
 */
public class ResultExam {

    private long id;
    private Doctor examinator;
    private Date examDate;
    private String result;
    private List<String> files = new ArrayList<>();

    public ResultExam(Doctor examinator, Date examDate, String result) {
        this.examinator = examinator;
        this.examDate = examDate;
        this.result = result;
    }

    public long getId() {
        return id;
    }

    public Doctor getExaminator() {
        return examinator;
    }

    public Date getExamDate() {
        return examDate;
    }

    public String getResult() {
        return result;
    }

    public List<String> getFiles() {
        return files;
    }
    
    public void addFiles (String s) {
        files.add(s);
    }
    
    
    
}
