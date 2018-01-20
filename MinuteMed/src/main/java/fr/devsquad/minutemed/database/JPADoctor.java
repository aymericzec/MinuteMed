package fr.devsquad.minutemed.database;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class JPADoctor implements IDoctor, INurse {

    private static final String PERSISTENCE_UNIT = "APHPPU";
    private final EntityManagerFactory emf;
    private final EntityManager em;
    private final EntityTransaction et;
    
    /**
     * Constructor of the class, initialize the fields to manipulate the database
     */
    public JPADoctor() {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        em = emf.createEntityManager();
        et = em.getTransaction();
    }
    
    /**
     * Add a MedicalRecord in the database
     * 
     * @param medicalRecord The MedicalRecord to add
     * @return True if the medicalRecord don't exists in the database, or false otherwise
     */
    @Override
    public boolean createMedicalRecord(MedicalRecord medicalRecord) {
        
        Objects.requireNonNull(medicalRecord);
        
        try {
            et.begin();
            em.persist(medicalRecord);
            et.commit();
        } catch(EntityExistsException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean createExam(long idMedicalRecord, Exam exam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Exam getExam(long idMedicalRecord, long idExam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Exam> getAllExams(long idMedicalREcord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validateExam(long idMedicalFolder, long idExam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeDraftExam(long idMedicalFolder, long idExam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createPrescription(long idMedicalRecord, Prescription prescription) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Prescription getPrescription(long idMedicalRecord, long idPrescription) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Prescription> getAllPrescriptions(long idMedicalREcord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validatePrescription(long idMedicalFolder, long idPrescription) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeDraftPrescription(long idMedicalFolder, long idPrescription) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createDiagnostic(long idMedicalRecord, Diagnostic diagnostic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Diagnostic getDiagnostic(long idMedicalRecord, long idDiagnostic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Diagnostic> getAllDiagnostics(long idMedicalREcord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validateDiagnostic(long idMedicalFolder, long idDiagnostic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeDraftDiagnostic(long idMedicalFolder, long idDiagnostic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createDosage(long idMedicalRecord, Dosage dosage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validateDosage(long idMedicalFolder, long idDosage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeDraftDosage(long idMedicalFolder, long idDosage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            TypedQuery tq = em.createQuery("SELECT mRecord FROM MedicalRecord hmRecord", MedicalRecord.class);
            medicalRecords = tq.getResultList();
        } catch(NoResultException e) {
            return null;
        }
        return medicalRecords;
    }

    @Override
    public List<MedicalRecord> searchMedicalRecord(Predicate predicate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dosage getDosage(long idMedicalRecord, long idDosage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Dosage> getAllDosages(long idMedicalRecord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}
