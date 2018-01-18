package fr.devsquad.minutemed.database;

import java.util.List;
import java.util.function.Predicate;


public interface INurse {
    
    public MedicalRecord getMedicalRecord(long idMedicalRecord);
    
    public List<MedicalRecord> getAllMedicalRecords();
    
    public List<MedicalRecord> searchMedicalRecord(Predicate predicate);
    
    public Dosage getDosage(long idMedicalRecord, long idDosage);
    
    public List<Dosage> getAllDosages(long idMedicalRecord);
    
    public Doctor getDoctor(long idDoctor);
    
    public Nurse getNurse(long idNurse);
}
