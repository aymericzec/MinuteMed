package fr.devsquad.minutemed.database;

import fr.devsquad.minutemed.dmp.domain.Dosage;
import fr.devsquad.minutemed.dmp.domain.MedicalRecord;
import fr.devsquad.minutemed.staff.domain.Doctor;
import fr.devsquad.minutemed.staff.domain.MedicalStaff;
import fr.devsquad.minutemed.staff.domain.Nurse;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class JPANurse implements INurse {
    
    private static final String PERSISTENCE_UNIT = "APHPPU";
    private final EntityManagerFactory emf;
    private final EntityManager em;
    
    /**
     * Constructor of the class, initialize the fields to manipulate the database
     */
    public JPANurse() {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        em = emf.createEntityManager();
    }

    /**
     * Get a MedicalRecord with its id passed in argument
     * 
     * @param idMedicalRecord The id of the MedicalRecord
     * @return The MedicalRecord
     */
    @Override
    public MedicalRecord getMedicalRecord(long idMedicalRecord) {
        
        MedicalRecord medicalRecord;
        
        try {
            medicalRecord = em.find(MedicalRecord.class, idMedicalRecord);
        } catch(EntityNotFoundException e) {
            return null;
        }
        return medicalRecord;
    }

    /**
     * Get all MedicalRecords
     * 
     * @return A list of MedicalRecords
     */
    @Override
    public List<MedicalRecord> getAllMedicalRecords() {
        
        List<MedicalRecord> medicalRecords;
        
        try {
            TypedQuery<MedicalRecord> tq = em.createQuery("SELECT mRecord FROM MedicalRecord mRecord", MedicalRecord.class);
            medicalRecords = tq.getResultList();
        } catch(NoResultException e) {
            return null;
        }
        return medicalRecords;
    }

    /**
     * Get a MedicalRecord by its number of social security
     * 
     * @param ss The number of social security of the patient
     * @return The MedicalRecord
     */
    @Override
    public MedicalRecord searchMedicalRecordBySS(String ss) {
        
        MedicalRecord medicalRecord;
        
        try {
            TypedQuery<MedicalRecord> tq = em.createQuery("SELECT mRecord FROM MedicalRecord mRecord WHERE mRecord.ss = :ss", MedicalRecord.class);
            medicalRecord = tq.setParameter("ss", ss).getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
        return medicalRecord;
    }

    /**
     * Get a MedicalRecord by its lastName
     * 
     * @param lastName The lastName of the patient
     * @return A List of MedicalRecord
     */
    @Override
    public List<MedicalRecord> searchMedicalRecordByName(String lastName) {
        
        List<MedicalRecord> medicalRecords;
        
        try {
            TypedQuery<MedicalRecord> tq = em.createQuery("SELECT mRecord FROM MedicalRecord mRecord WHERE mRecord.lastName = :lastName", MedicalRecord.class);
            medicalRecords = tq.setParameter("lastName", lastName).getResultList();
        } catch(NoResultException e) {
            return null;
        }
        return medicalRecords;
    }
    
    /**
     * Get a MedicalRecord by its number of social security and its lastName
     * 
     * @param ss The number of social security of the patient
     * @param lastName The lastName of the patient
     * @return The MedicalRecord
     */
    @Override
    public MedicalRecord searchMedicalRecord(String ss, String lastName) {
        
        MedicalRecord medicalRecord;
        
        try {
            TypedQuery<MedicalRecord> tq = em.createQuery("SELECT mRecord FROM MedicalRecord mRecord WHERE mRecord.ss = :ss AND mRecord.lastName = :lastName", MedicalRecord.class);
            medicalRecord = tq.setParameter("ss", ss).setParameter("lastName", lastName).getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
        return medicalRecord;
    }
    
    /**
     * Get a Dosage with its id passed in argument
     * 
     * @param idDosage The id of the Dosage
     * @return The Dosage
     */
    @Override
    public Dosage getDosage(long idDosage) {
        
        Dosage dosage;
        
        try {
            dosage = em.find(Dosage.class, idDosage);
        } catch(EntityNotFoundException e) {
            return null;
        }
        return dosage;
    }

    /**
     * Get all dosages corresponding to the MedicalRecord passed in parameter
     * 
     * @param idMedicalRecord The id of the MedicalRecord
     * @return A List of Dosage
     */
    @Override
    public List<Dosage> getAllDosages(long idMedicalRecord) {
        
        List<Dosage> dosages;

        try {
            TypedQuery<Dosage> tq = em.createQuery("SELECT dosage FROM Dosage dosage WHERE dosage.medicalRecord = :idMedicalRecord AND dosage.draft := draft", Dosage.class);
            dosages = tq.setParameter("idMedicalRecord", idMedicalRecord).setParameter("draft", false).getResultList();
        } catch (NoResultException e) {
            return null;
        }
        return dosages;
    }

    /**
     * Get a Doctor with its id passed in argument
     * 
     * @param idDoctor The id of the Doctor
     * @return The Doctor
     */
    @Override
    public Doctor getDoctor(long idDoctor) {
        
        Doctor doctor;
        
        try {
            doctor = em.find(Doctor.class, idDoctor);
        } catch(EntityNotFoundException e) {
            return null;
        }
        return doctor;
    }

    /**
     * Get a Nurse with its id passed in argument
     * 
     * @param idNurse The id of the Nurse
     * @return The Nurse
     */
    @Override
    public Nurse getNurse(long idNurse) {
        
        Nurse nurse;
        
        try {
            nurse = em.find(Nurse.class, idNurse);
        } catch(EntityNotFoundException e) {
            return null;
        }
        return nurse;
    }
    
    /**
     * Get the Staff in the Staff Entity
     * 
     * @param type The type of the Staff
     * @param idStaff The if of the Staff
     * @return The MedicalStaff
     */
    public MedicalStaff getMedicalStaff(String type, long idStaff) {
        
        MedicalStaff staff;
        
        try {
            TypedQuery<MedicalStaff> tq = em.createQuery("SELECT staff FROM MedicalStaff staff WHERE staff.type = :type AND staff.idMedicalStaff = :idStaff", MedicalStaff.class);
            staff = tq.setParameter("type", type).setParameter("idStaff", idStaff).getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
        return staff;
    }
}
