package fr.devsquad.minutemed.database;

import fr.devsquad.minutemed.arborescence.domain.NodeHU;
import fr.devsquad.minutemed.dmp.domain.Diagnostic;
import fr.devsquad.minutemed.dmp.domain.Dosage;
import fr.devsquad.minutemed.dmp.domain.Exam;
import fr.devsquad.minutemed.dmp.domain.MedicalRecord;
import fr.devsquad.minutemed.dmp.domain.Prescription;
import java.util.List;


public interface IDoctor {
    
    public boolean createMedicalRecord(MedicalRecord medicalRecord);
    
    public boolean changeNodeMedicalRecord(long idMedicalRecord, NodeHU hu);
    
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
