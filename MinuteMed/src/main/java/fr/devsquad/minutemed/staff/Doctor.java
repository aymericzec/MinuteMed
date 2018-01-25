package fr.devsquad.minutemed.staff;

import fr.devsquad.minutemed.database.IDoctor;
import fr.devsquad.minutemed.database.INurse;
import fr.devsquad.minutemed.database.JPADoctor;
import fr.devsquad.minutemed.dmp.Diagnostic;
import fr.devsquad.minutemed.dmp.Dosage;
import fr.devsquad.minutemed.dmp.Exam;
import fr.devsquad.minutemed.dmp.MedicalRecord;
import fr.devsquad.minutemed.dmp.Prescription;
import fr.devsquad.minutemed.specialization.Specialization;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Doctor implements Serializable, IHospitalStaff, IMedicalStaff, IDoctor, INurse {

    @Id @GeneratedValue
    private long idStaff; 
    private String firstName;
    private String lastName;
    private String adress;
    private String email;
    private String phoneNumber;
    
    @OneToOne
    private Node node;
    @OneToOne
    private Specialization specialization;
    
    public Doctor() { }
    
    public Doctor(String firstName, String lastName, String adress, String email, String phoneNumber, Node node , Specialization specialization) { 
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.node = node;
        this.specialization = specialization;
    }

    @Override
    public long getIdStaff() {
        return idStaff;
    }
    
    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getAdress() {
        return adress;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPhoneNumber() {
       return phoneNumber;
    }
    
    @Override
    public Node getNode() {
        return node;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public void setNode(Node node) {
        this.node = node;
    }

    /**
     * Add a MedicalRecord in the database
     * 
     * @param medicalRecord The MedicalRecord to add
     * @return True if the medicalRecord don't exists in the database, or false otherwise
     */
    @Override
    public boolean createMedicalRecord(MedicalRecord medicalRecord) {
        JPADoctor doctor = new JPADoctor();
        return doctor.createMedicalRecord(medicalRecord);
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
        JPADoctor doctor = new JPADoctor();
        return doctor.createExam(exam);
    }

    /**
     * Get an Exam with its id passed in argument
     * 
     * @param idExam The id of the Exam
     * @return The Exam
     */
    @Override
    public Exam getExam(long idExam) {
        JPADoctor doctor = new JPADoctor();
        return doctor.getExam(idExam);
    }

    /**
     * Get all exams corresponding to the MedicalRecord passed in parameter
     * 
     * @param idMedicalRecord The id of the MedicalRecord
     * @return A List of Exam
     */
    @Override
    public List<Exam> getAllExams(long idMedicalRecord) {
        JPADoctor doctor = new JPADoctor();
        return doctor.getAllExams(idMedicalRecord);
    }

    @Override
    public boolean validateExam(long idExam) {
        JPADoctor doctor = new JPADoctor();
        return doctor.validateExam(idExam);
    }

    @Override
    public boolean removeDraftExam(long idExam) {
        JPADoctor doctor = new JPADoctor();
        return doctor.removeDraftExam(idExam);
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
        JPADoctor doctor = new JPADoctor();
        return doctor.createPrescription(prescription);
    }

    /**
     * Get a Prescription with its id passed in argument
     * 
     * @param idPrescription The id of the Prescription
     * @return The Prescription
     */
    @Override
    public Prescription getPrescription(long idPrescription) {
        JPADoctor doctor = new JPADoctor();
        return doctor.getPrescription(idPrescription);
    }

    /**
     * Get all prescriptions corresponding to the MedicalRecord passed in parameter
     * 
     * @param idMedicalRecord The id of the MedicalRecord
     * @return A List of Prescription
     */
    @Override
    public List<Prescription> getAllPrescriptions(long idMedicalRecord) {
        JPADoctor doctor = new JPADoctor();
        return doctor.getAllPrescriptions(idMedicalRecord);
    }

    @Override
    public boolean validatePrescription(long idPrescription) {
        JPADoctor doctor = new JPADoctor();
        return doctor.validatePrescription(idPrescription);
    }

    @Override
    public boolean removeDraftPrescription(long idPrescription) {
        JPADoctor doctor = new JPADoctor();
        return doctor.removeDraftPrescription(idPrescription);
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
        JPADoctor doctor = new JPADoctor();
        return doctor.createDiagnostic(diagnostic);
    }

    /**
     * Get a Diagnostic with its id passed in argument
     * 
     * @param idDiagnostic The id of the Diagnostic
     * @return The Diagnostic
     */
    @Override
    public Diagnostic getDiagnostic(long idDiagnostic) {
        JPADoctor doctor = new JPADoctor();
        return doctor.getDiagnostic(idDiagnostic);
    }

    /**
     * Get all diagnostics corresponding to the MedicalRecord passed in parameter
     * 
     * @param idMedicalRecord The id of the MedicalRecord
     * @return A List of Diagnostic
     */
    @Override
    public List<Diagnostic> getAllDiagnostics(long idMedicalRecord) {
        JPADoctor doctor = new JPADoctor();
        return doctor.getAllDiagnostics(idMedicalRecord);
    }

    @Override
    public boolean validateDiagnostic(long idDiagnostic) {
        JPADoctor doctor = new JPADoctor();
        return doctor.validateDiagnostic(idDiagnostic);
    }

    @Override
    public boolean removeDraftDiagnostic(long idDiagnostic) {
        JPADoctor doctor = new JPADoctor();
        return doctor.removeDraftDiagnostic(idDiagnostic);
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
        JPADoctor doctor = new JPADoctor();
        return doctor.createDosage(dosage);
    }

    @Override
    public boolean validateDosage(long idDosage) {
        JPADoctor doctor = new JPADoctor();
        return doctor.validateDosage(idDosage);
    }

    @Override
    public boolean removeDraftDosage(long idDosage) {
        JPADoctor doctor = new JPADoctor();
        return doctor.removeDraftDosage(idDosage);
    }

    /**
     * Get a MedicalRecord with its id passed in argument
     * 
     * @param idMedicalRecord The id of the MedicalRecord
     * @return The MedicalRecord
     */
    @Override
    public MedicalRecord getMedicalRecord(long idMedicalRecord) {
        JPADoctor doctor = new JPADoctor();
        return doctor.getMedicalRecord(idMedicalRecord);
    }

    /**
     * Get all MedicalRecords
     * 
     * @return A list of MedicalRecords
     */
    @Override
    public List<MedicalRecord> getAllMedicalRecords() {
        JPADoctor doctor = new JPADoctor();
        return doctor.getAllMedicalRecords();
    }

    /**
     * Get a MedicalRecord by its number of social security
     *
     * @param ss The number of social security of the patient
     * @return The MedicalRecord
     */
    @Override
    public MedicalRecord searchMedicalRecordBySS(String ss) {
        JPADoctor doctor = new JPADoctor();
        return doctor.searchMedicalRecordBySS(ss);
    }
    
    /**
     * Get a MedicalRecord by its lastName
     *
     * @param lastName The lastName of the patient
     * @return A List of MedicalRecord
     */
    @Override
    public List<MedicalRecord> searchMedicalRecordByName(String lastName) {
        JPADoctor doctor = new JPADoctor();
        return doctor.searchMedicalRecordByName(lastName);
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
        JPADoctor doctor = new JPADoctor();
        return doctor.searchMedicalRecord(ss, lastName);
    }

    /**
     * Get a Dosage with its id passed in argument
     *
     * @param idDosage The id of the Dosage
     * @return The Dosage
     */
    @Override
    public Dosage getDosage(long idDosage) {
        JPADoctor doctor = new JPADoctor();
        return doctor.getDosage(idDosage);
    }

    /**
     * Get all dosages corresponding to the MedicalRecord passed in parameter
     *
     * @param idMedicalRecord The id of the MedicalRecord
     * @return A List of Dosage
     */
    @Override
    public List<Dosage> getAllDosages(long idMedicalRecord) {
        JPADoctor doctor = new JPADoctor();
        return doctor.getAllDosages(idMedicalRecord);
    }

    /**
     * Get a Doctor with its id passed in argument
     * 
     * @param idDoctor The id of the Doctor
     * @return The Doctor
     */
    @Override
    public Doctor getDoctor(long idDoctor) {
        JPADoctor doctor = new JPADoctor();
        return doctor.getDoctor(idDoctor);
    }

    /**
     * Get a Nurse with its id passed in argument
     * 
     * @param idNurse The id of the Nurse
     * @return The Nurse
     */
    @Override
    public Nurse getNurse(long idNurse) {
        JPADoctor doctor = new JPADoctor();
        return doctor.getNurse(idNurse);
    }
}
