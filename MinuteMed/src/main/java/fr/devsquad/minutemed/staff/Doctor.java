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
import java.util.function.Predicate;
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

    @Override
    public boolean createExam(long idMedicalRecord, Exam exam) {
        JPADoctor doctor = new JPADoctor();
        return doctor.createExam(idMedicalRecord, exam);
    }

    @Override
    public Exam getExam(long idMedicalRecord, long idExam) {
        JPADoctor doctor = new JPADoctor();
        return doctor.getExam(idMedicalRecord, idExam);
    }

    @Override
    public List<Exam> getAllExams(long idMedicalREcord) {
        JPADoctor doctor = new JPADoctor();
        return doctor.getAllExams(idMedicalREcord);
    }

    @Override
    public boolean validateExam(long idMedicalFolder, long idExam) {
        JPADoctor doctor = new JPADoctor();
        return doctor.validateExam(idMedicalFolder, idExam);
    }

    @Override
    public boolean removeDraftExam(long idMedicalFolder, long idExam) {
        JPADoctor doctor = new JPADoctor();
        return doctor.removeDraftExam(idMedicalFolder, idExam);
    }

    @Override
    public boolean createPrescription(long idMedicalRecord, Prescription prescription) {
        JPADoctor doctor = new JPADoctor();
        return doctor.createPrescription(idMedicalRecord, prescription);
    }

    @Override
    public Prescription getPrescription(long idMedicalRecord, long idPrescription) {
        JPADoctor doctor = new JPADoctor();
        return doctor.getPrescription(idMedicalRecord, idPrescription);
    }

    @Override
    public List<Prescription> getAllPrescriptions(long idMedicalREcord) {
        JPADoctor doctor = new JPADoctor();
        return doctor.getAllPrescriptions(idMedicalREcord);
    }

    @Override
    public boolean validatePrescription(long idMedicalFolder, long idPrescription) {
        JPADoctor doctor = new JPADoctor();
        return doctor.validatePrescription(idMedicalFolder, idPrescription);
    }

    @Override
    public boolean removeDraftPrescription(long idMedicalFolder, long idPrescription) {
        JPADoctor doctor = new JPADoctor();
        return doctor.removeDraftPrescription(idMedicalFolder, idPrescription);
    }

    @Override
    public boolean createDiagnostic(long idMedicalRecord, Diagnostic diagnostic) {
        JPADoctor doctor = new JPADoctor();
        return doctor.createDiagnostic(idMedicalRecord, diagnostic);
    }

    @Override
    public Diagnostic getDiagnostic(long idMedicalRecord, long idDiagnostic) {
        JPADoctor doctor = new JPADoctor();
        return doctor.getDiagnostic(idMedicalRecord, idDiagnostic);
    }

    @Override
    public List<Diagnostic> getAllDiagnostics(long idMedicalREcord) {
        JPADoctor doctor = new JPADoctor();
        return doctor.getAllDiagnostics(idMedicalREcord);
    }

    @Override
    public boolean validateDiagnostic(long idMedicalFolder, long idDiagnostic) {
        JPADoctor doctor = new JPADoctor();
        return doctor.validateDiagnostic(idMedicalFolder, idDiagnostic);
    }

    @Override
    public boolean removeDraftDiagnostic(long idMedicalFolder, long idDiagnostic) {
        JPADoctor doctor = new JPADoctor();
        return doctor.removeDraftDiagnostic(idMedicalFolder, idDiagnostic);
    }

    @Override
    public boolean createDosage(long idMedicalRecord, Dosage dosage) {
        JPADoctor doctor = new JPADoctor();
        return doctor.createDosage(idMedicalRecord, dosage);
    }

    @Override
    public boolean validateDosage(long idMedicalFolder, long idDosage) {
        JPADoctor doctor = new JPADoctor();
        return doctor.validateDosage(idMedicalFolder, idDosage);
    }

    @Override
    public boolean removeDraftDosage(long idMedicalFolder, long idDosage) {
        JPADoctor doctor = new JPADoctor();
        return doctor.removeDraftDosage(idMedicalFolder, idDosage);
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

    @Override
    public List<MedicalRecord> searchMedicalRecord(Predicate predicate) {
        JPADoctor doctor = new JPADoctor();
        return doctor.searchMedicalRecord(predicate);
    }

    @Override
    public Dosage getDosage(long idMedicalRecord, long idDosage) {
        JPADoctor doctor = new JPADoctor();
        return doctor.getDosage(idMedicalRecord, idDosage);
    }

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
