package fr.devsquad.minutemed.database;

import fr.devsquad.minutemed.dmp.domain.Dosage;
import fr.devsquad.minutemed.dmp.domain.MedicalRecord;
import fr.devsquad.minutemed.staff.domain.Doctor;
import fr.devsquad.minutemed.staff.domain.Nurse;
import java.util.List;
import java.util.function.Predicate;


public interface INurse {
    
    public MedicalRecord getMedicalRecord(long idMedicalRecord);
    
    public List<MedicalRecord> getAllMedicalRecords();
    
    public MedicalRecord searchMedicalRecordBySS(String ss);
    
    public List<MedicalRecord> searchMedicalRecordByName(String lastName);
    
    public MedicalRecord searchMedicalRecord(String ss, String lastName);
    
    public Dosage getDosage(long idDosage);
    
    public List<Dosage> getAllDosages(long idMedicalRecord);
    
    public Doctor getDoctor(long idDoctor);
    
    public Nurse getNurse(long idNurse);
}
