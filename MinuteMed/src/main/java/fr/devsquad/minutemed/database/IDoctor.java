package fr.devsquad.minutemed.database;

import java.util.List;


public interface IDoctor {
    
    public boolean createMedicalRecord(MedicalRecord medicalRecord);
    
    public boolean createExam(long idMedicalRecord, Exam exam);
    
    public Exam getExam(long idMedicalRecord, long idExam);
    
    public List<Exam> getAllExams(long idMedicalREcord);
    
    public boolean validateExam(long idMedicalFolder, long idExam);
    
    public boolean removeDraftExam(long idMedicalFolder, long idExam);
    
    public boolean createPrescription(long idMedicalRecord, Prescription prescription);
    
    public Prescription getPrescription(long idMedicalRecord, long idPrescription);
    
    public List<Prescription> getAllPrescriptions(long idMedicalREcord);
    
    public boolean validatePrescription(long idMedicalFolder, long idPrescription);
    
    public boolean removeDraftPrescription(long idMedicalFolder, long idPrescription);
    
    public boolean createDiagnostic(long idMedicalRecord, Diagnostic diagnostic);
    
    public Diagnostic getDiagnostic(long idMedicalRecord, long idDiagnostic);
    
    public List<Diagnostic> getAllDiagnostics(long idMedicalREcord);
    
    public boolean validateDiagnostic(long idMedicalFolder, long idDiagnostic);
    
    public boolean removeDraftDiagnostic(long idMedicalFolder, long idDiagnostic);
    
    public boolean createDosage(long idMedicalRecord, Dosage dosage);
    
    public boolean validateDosage(long idMedicalFolder, long idDosage);
    
    public boolean removeDraftDosage(long idMedicalFolder, long idDosage);
}
