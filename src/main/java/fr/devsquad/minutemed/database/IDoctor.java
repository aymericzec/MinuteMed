package fr.devsquad.minutemed.database;

import fr.devsquad.minutemed.dmp.Diagnostic;
import fr.devsquad.minutemed.dmp.Dosage;
import fr.devsquad.minutemed.dmp.Exam;
import fr.devsquad.minutemed.dmp.MedicalRecord;
import fr.devsquad.minutemed.dmp.Prescription;
import java.util.List;


public interface IDoctor {
    
    public boolean createMedicalRecord(MedicalRecord medicalRecord);
    
    public boolean createExam(Exam exam);
    
    public Exam getExam(long idExam);
    
    public List<Exam> getAllExams(long idMedicalRecord);
    
    public boolean validateExam(long idExam);
    
    public boolean removeDraftExam(long idExam);
    
    public boolean createPrescription(Prescription prescription);
    
    public Prescription getPrescription(long idPrescription);
    
    public List<Prescription> getAllPrescriptions(long idMedicalRecord);
    
    public boolean validatePrescription(long idPrescription);
    
    public boolean removeDraftPrescription(long idPrescription);
    
    public boolean createDiagnostic(Diagnostic diagnostic);
    
    public Diagnostic getDiagnostic(long idDiagnostic);
    
    public List<Diagnostic> getAllDiagnostics(long idMedicalRecord);
    
    public boolean validateDiagnostic(long idDiagnostic);
    
    public boolean removeDraftDiagnostic(long idDiagnostic);
    
    public boolean createDosage(Dosage dosage);
    
    public boolean validateDosage(long idDosage);
    
    public boolean removeDraftDosage(long idDosage);
}
