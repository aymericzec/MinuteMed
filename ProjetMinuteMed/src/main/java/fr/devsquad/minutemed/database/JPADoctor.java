package fr.devsquad.minutemed.database;

import fr.devsquad.minutemed.arborescence.domain.NodeHU;
import fr.devsquad.minutemed.dmp.domain.Diagnostic;
import fr.devsquad.minutemed.dmp.domain.Dosage;
import fr.devsquad.minutemed.dmp.domain.Exam;
import fr.devsquad.minutemed.dmp.domain.MedicalRecord;
import fr.devsquad.minutemed.dmp.domain.Prescription;
import fr.devsquad.minutemed.staff.domain.Doctor;
import fr.devsquad.minutemed.staff.domain.MedicalStaff;
import fr.devsquad.minutemed.staff.domain.Nurse;
import java.util.List;
import java.util.Objects;
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
     * Constructor of the class, initialize the fields to manipulate the
     * database
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
     * @return True if the medicalRecord don't exists in the database, or false
     * otherwise
     */
    @Override
    public boolean createMedicalRecord(MedicalRecord medicalRecord) {

        Objects.requireNonNull(medicalRecord);

        try {
            et.begin();
            em.persist(medicalRecord);
            et.commit();
        } catch (EntityExistsException e) {
            return false;
        }
        return true;
    }
    
    /**
     * Change a Node MedicalRecord 
     * 
     * @param idMedicalRecord The id of the MedicalRecord
     * @param hu The Node to affect them
     * @return True if the medicalRecord don't exists in the database, or false
     */
    @Override
    public boolean changeNodeMedicalRecord(long idMedicalRecord, NodeHU hu) {
        
        try {
            et.begin();
            MedicalRecord mRecord = em.find(MedicalRecord.class, idMedicalRecord);
            mRecord.setHU(hu);
            et.commit();
        } catch(EntityNotFoundException e) {
            return false;
        }
        return true;
    }

    /**
     * Add an Exam in the database
     *
     * @param exam The Exam to add
     * @return True if the exam don't exists in the database, or false
     * otherwise
     */
    @Override
    public boolean createExam(Exam exam) {
        
        Objects.requireNonNull(exam);

        try {
            et.begin();
            em.persist(exam);
            et.commit();
        } catch (EntityExistsException e) {
            return false;
        }
        return true;
    }

    /**
     * Get an Exam with its id passed in argument
     * 
     * @param idExam The id of the Exam
     * @return The Exam
     */
    @Override
    public Exam getExam(long idExam) {
        
        Exam exam;
        
        try {
            exam = em.find(Exam.class, idExam);
        } catch(EntityNotFoundException e) {
            return null;
        }
        return exam;
    }

    /**
     * Get all exams corresponding to the MedicalRecord passed in parameter
     * 
     * @param idMedicalRecord The id of the MedicalRecord
     * @return A List of Exam
     */
    @Override
    public List<Exam> getAllExams(long idMedicalRecord) {
        
        List<Exam> exams;
        
        try {
            TypedQuery<Exam> tq = em.createQuery("SELECT exam FROM Exam exam WHERE exam.medicalRecord = :idMedicalRecord AND exam.draft = :draft", Exam.class);
            exams = tq.setParameter("idMedicalRecord", idMedicalRecord).setParameter("draft", false).getResultList();
        } catch(NoResultException e) {
            return null;
        }
        return exams;
    }

    /**
     * Validate a Draft Exam
     * 
     * @param idExam The id of the Exam to validate
     * @return True if the draft Exam don't exists in the database, or false otherwise
     */
    @Override
    public boolean validateExam(long idExam) {
       
        try {
            et.begin();
            Exam exam = em.find(Exam.class, idExam);
            exam.setDraft(false);
            et.commit();
        } catch(EntityNotFoundException e) {
            return false;
        }
        return true;
    }

    /**
     * Remove a Draft Exam from the database
     * 
     * @param idExam Draft Exam to remove
     * @return True if the draft Exam don't exists in the database, or false otherwise
     */
    @Override
    public boolean removeDraftExam(long idExam) {
        
        try {
            et.begin();
            Exam exam = em.find(Exam.class, idExam);
            if(!exam.getDraft()) {
                return false;
            }
            em.remove(exam);
            et.commit();
        } catch(EntityNotFoundException e) {
            return false;
        }
        return true;
    }

    /**
     * Add a Prescription in the database
     *
     * @param prescription The Prescription to add
     * @return True if the prescription don't exists in the database, or false
     * otherwise
     */
    @Override
    public boolean createPrescription(Prescription prescription) {
        
        Objects.requireNonNull(prescription);

        try {
            et.begin();
            em.persist(prescription);
            et.commit();
        } catch (EntityExistsException e) {
            return false;
        }
        return true;
    }

    /**
     * Get a Prescription with its id passed in argument
     * 
     * @param idPrescription The id of the Prescription
     * @return The Prescription
     */
    @Override
    public Prescription getPrescription(long idPrescription) {
        
        Prescription prescription;
        
        try {
            prescription = em.find(Prescription.class, idPrescription);
        } catch(EntityNotFoundException e) {
            return null;
        }
        return prescription;
    }

    /**
     * Get all prescriptions corresponding to the MedicalRecord passed in parameter
     * 
     * @param idMedicalRecord The id of the MedicalRecord
     * @return A List of Prescription
     */
    @Override
    public List<Prescription> getAllPrescriptions(long idMedicalRecord) {
        
        List<Prescription> prescriptions;
        
        try {
            TypedQuery<Prescription> tq = em.createQuery("SELECT prescription FROM Prescription prescription WHERE prescription.medicalRecord = :idMedicalRecord AND prescription.draft = :draft", Prescription.class);
            prescriptions = tq.setParameter("idMedicalRecord", idMedicalRecord).setParameter("draft", false).getResultList();
        } catch(NoResultException e) {
            return null;
        }
        return prescriptions;
    }

    /**
     * Validate a Draft Prescription
     * 
     * @param idPrescription The id of the Prescription to validate
     * @return True if the draft prescription don't exists in the database, or false otherwise
     */
    @Override
    public boolean validatePrescription(long idPrescription) {
        
        try {
            et.begin();
            Prescription prescription = em.find(Prescription.class, idPrescription);
            prescription.setDraft(false);
            et.commit();
        } catch(EntityNotFoundException e) {
            return false;
        }
        return true;
    }

    /**
     * Remove a Draft Prescription from the database
     * 
     * @param idPrescription Draft Prescription to remove
     * @return True if the draft Prescription don't exists in the database, or false otherwise
     */
    @Override
    public boolean removeDraftPrescription(long idPrescription) {
        
        try {
            et.begin();
            Prescription prescription = em.find(Prescription.class, idPrescription);
            if(!prescription.getDraft()) {
                return false;
            }
            em.remove(prescription);
            et.commit();
        } catch(EntityNotFoundException e) {
            return false;
        }
        return true;
    }

    /**
     * Add a Diagnostic in the database
     *
     * @param diagnostic The Diagnostic to add
     * @return True if the diagnostic don't exists in the database, or false
     * otherwise
     */
    @Override
    public boolean createDiagnostic(Diagnostic diagnostic) {
        
        Objects.requireNonNull(diagnostic);

        try {
            et.begin();
            em.persist(diagnostic);
            et.commit();
        } catch (EntityExistsException e) {
            return false;
        }
        return true;
    }

    /**
     * Get a Diagnostic with its id passed in argument
     * 
     * @param idDiagnostic The id of the Diagnostic
     * @return The Diagnostic
     */
    @Override
    public Diagnostic getDiagnostic(long idDiagnostic) {
        
        Diagnostic diagnostic;
        
        try {
            diagnostic = em.find(Diagnostic.class, idDiagnostic);
        } catch(EntityNotFoundException e) {
            return null;
        }
        return diagnostic;
    }

    /**
     * Get all diagnostics corresponding to the MedicalRecord passed in parameter
     * 
     * @param idMedicalRecord The id of the MedicalRecord
     * @return A List of Diagnostic
     */
    @Override
    public List<Diagnostic> getAllDiagnostics(long idMedicalRecord) {
        
        List<Diagnostic> diagnostics;
        
        try {
            TypedQuery<Diagnostic> tq = em.createQuery("SELECT diagnostic FROM Diagnostic diagnostic WHERE diagnostic.medicalRecord = :idMedicalRecord AND diagnostic.draft = :draft", Diagnostic.class);
            diagnostics = tq.setParameter("idMedicalRecord", idMedicalRecord).setParameter("draft", false).getResultList();
        } catch(NoResultException e) {
            return null;
        }
        return diagnostics;
    }

    /**
     * Validate a Draft Diagnostic
     * 
     * @param idDiagnostic The id of the Diagnostic to validate
     * @return True if the draft diagnostic don't exists in the database, or false otherwise
     */
    @Override
    public boolean validateDiagnostic(long idDiagnostic) {
        
        try {
            et.begin();
            Diagnostic diagnostic = em.find(Diagnostic.class, idDiagnostic);
            diagnostic.setDraft(false);
            et.commit();
        } catch(EntityNotFoundException e) {
            return false;
        }
        return true;
    }

    /**
     * Remove a Draft Diagnostic from the database
     * 
     * @param idDiagnostic Draft Diagnostic to remove
     * @return True if the draft diagnostic don't exists in the database, or false otherwise
     */
    @Override
    public boolean removeDraftDiagnostic(long idDiagnostic) {
        
        try {
            et.begin();
            Diagnostic diagnostic = em.find(Diagnostic.class, idDiagnostic);
            if(!diagnostic.getDraft()) {
                return false;
            }
            em.remove(diagnostic);
            et.commit();
        } catch(EntityNotFoundException e) {
            return false;
        }
        return true;
    }

    /**
     * Add a Dosage in the database
     *
     * @param dosage The Dosage to add
     * @return True if the dosage don't exists in the database, or false
     * otherwise
     */
    @Override
    public boolean createDosage(Dosage dosage) {
        
        Objects.requireNonNull(dosage);

        try {
            et.begin();
            em.persist(dosage);
            et.commit();
        } catch (EntityExistsException e) {
            return false;
        }
        return true;
    }

    /**
     * Validate a Draft Dosage
     * 
     * @param idDosage The id of the Dosage to validate
     * @return True if the draft dosage don't exists in the database, or false otherwise
     */
    @Override
    public boolean validateDosage(long idDosage) {
        
        try {
            et.begin();
            Dosage dosage = em.find(Dosage.class, idDosage);
            dosage.setDraft(false);
            et.commit();
        } catch(EntityNotFoundException e) {
            return false;
        }
        return true;
    }

    /**
     * Remove a Draft Dosage from the database
     * 
     * @param idDosage Draft Dosage to remove
     * @return True if the draft dosage don't exists in the database, or false otherwise
     */
    @Override
    public boolean removeDraftDosage(long idDosage) {
        
        try {
            et.begin();
            Dosage dosage = em.find(Dosage.class, idDosage);
            if(!dosage.getDraft()) {
                return false;
            }
            em.remove(dosage);
            et.commit();
        } catch(EntityNotFoundException e) {
            return false;
        }
        return true;
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
        } catch (EntityNotFoundException e) {
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
        } catch (NoResultException e) {
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
        } catch (NoResultException e) {
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
        } catch (NoResultException e) {
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
        } catch (NoResultException e) {
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
        } catch (EntityNotFoundException e) {
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
        } catch (EntityNotFoundException e) {
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
        } catch (EntityNotFoundException e) {
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
