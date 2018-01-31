package fr.devsquad.minutemed.staff;

import fr.devsquad.minutemed.arborescence.INode;
import fr.devsquad.minutemed.arborescence.Node;
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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Doctor implements Serializable, IHospitalStaff, IMedicalStaff, IDoctor, INurse, ISpecialistStaff {

    @Id @GeneratedValue
    @Column(name = "idDoctor")
    private long id; 
    private String type;
    private String firstName;
    private String lastName;
    private String adress;
    private String email;
    private String phoneNumber;
    private String specialization;
    
    @OneToOne
    @JoinColumn(name = "idNode")
    private Node node;
 
    public Doctor() { }
    
    public Doctor(StaffEnum type, String firstName, String lastName, String adress, String email, String phoneNumber, Node node , Specialization specialization) { 
        if( type == null){
            throw new NullPointerException();
        }
        if( firstName == null){
            throw new NullPointerException();
        }
        if( lastName == null){
            throw new NullPointerException();
        }
        if( adress == null){
            throw new NullPointerException();
        }
        if( email == null){
            throw new NullPointerException();
        }
        if( phoneNumber == null){
            throw new NullPointerException();
        }
        if( node == null){
            throw new NullPointerException();
        }
        if( specialization == null){
            throw new NullPointerException();
        }
        
        if( stringNotConform(firstName) ){
            throw new IllegalArgumentException();
        }
        if( stringNotConform(lastName) ){
            throw new IllegalArgumentException();
        }
        if( stringNotConform(adress) ){
            throw new IllegalArgumentException();
        }
        if( stringNotConform(email) ){
            throw new IllegalArgumentException();
        }
        if( stringNotConform(phoneNumber) ){
            throw new IllegalArgumentException();
        }
        
        this.type = type.DOCTOR.name();
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.node = node;
        this.specialization = specialization.getStaffName();
    }
    
    private static boolean stringNotConform(String s){
        return s.matches("[ ]*");
    }

    @Override
    public long getId() {
        return id;
    }
       
    @Override
    public String getType() {
        return type;
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
    public String getSpecialization() {
        return specialization;
    }
    
    @Override
    public void setFirstName(String firstName) {
        if(firstName==null){
            throw new NullPointerException();
        }
        if(stringNotConform(firstName)){
            throw new IllegalArgumentException();
        }
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        if(lastName==null){
            throw new NullPointerException();
        }
        if(stringNotConform(lastName)){
            throw new IllegalArgumentException();
        }
        this.lastName = lastName;
    }

    @Override
    public void setAdress(String adress) {
        if(adress==null){
            throw new NullPointerException();
        }
        if(stringNotConform(adress)){
            throw new IllegalArgumentException();
        }
        this.adress = adress;
    }

    @Override
    public void setEmail(String email) {
        if(email==null){
            throw new NullPointerException();
        }
        if(stringNotConform(email)){
            throw new IllegalArgumentException();
        }
        this.email = email;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber==null){
            throw new NullPointerException();
        }
        if(stringNotConform(phoneNumber)){
            throw new IllegalArgumentException();
        }
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public void setNode(Node node) {
        if(node==null){
            throw new NullPointerException();
        }
        this.node = node;
    }
    
    @Override
    public void setSpecialization(Specialization specialization){
        if(specialization==null){
            throw new NullPointerException();
        }
        this.specialization = specialization.getStaffName();
    }

    /**
     * Add a MedicalRecord in the database
     * 
     * @param medicalRecord The MedicalRecord to add
     * @return True if the medicalRecord don't exists in the database, or false otherwise
     */
    @Override
    public boolean createMedicalRecord(MedicalRecord medicalRecord) {
        if( medicalRecord==null){
            throw new NullPointerException();
        }
        
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
        if(exam==null){
            throw new NullPointerException();
        }
        
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
        if(idExam<0){
            throw new IllegalArgumentException();
        }
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
        if(idMedicalRecord<0){
            throw new IllegalArgumentException();
        }
        JPADoctor doctor = new JPADoctor();
        return doctor.getAllExams(idMedicalRecord);
    }

    /**
     * Validate a Draft Exam
     * 
     * @param idExam The id of the Exam to validate
     * @return True if the draft Exam don't exists in the database, or false otherwise
     */
    @Override
    public boolean validateExam(long idExam) {
        if(idExam<0){
            throw new IllegalArgumentException();
        }
        JPADoctor doctor = new JPADoctor();
        return doctor.validateExam(idExam);
    }

    /**
     * Remove a Draft Exam from the database
     * 
     * @param idExam Draft Exam to remove
     * @return True if the draft Exam don't exists in the database, or false otherwise
     */
    @Override
    public boolean removeDraftExam(long idExam) {
        if(idExam<0){
            throw new IllegalArgumentException();
        }
        
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
        if(prescription==null){
            throw new NullPointerException();
        }
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
        if(idPrescription<0){
            throw new IllegalArgumentException();
        }
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
        if(idMedicalRecord<0){
            throw new IllegalArgumentException();
        }
        JPADoctor doctor = new JPADoctor();
        return doctor.getAllPrescriptions(idMedicalRecord);
    }

    /**
     * Validate a Draft Prescription
     * 
     * @param idPrescription The id of the Prescription to validate
     * @return True if the draft prescription don't exists in the database, or false otherwise
     */
    @Override
    public boolean validatePrescription(long idPrescription) {
        if(idPrescription<0){
            throw new IllegalArgumentException();
        }
        JPADoctor doctor = new JPADoctor();
        return doctor.validatePrescription(idPrescription);
    }

    /**
     * Remove a Draft Prescription from the database
     * 
     * @param idPrescription Draft Prescription to remove
     * @return True if the draft Prescription don't exists in the database, or false otherwise
     */
    @Override
    public boolean removeDraftPrescription(long idPrescription) {
        if(idPrescription<0){
            throw new IllegalArgumentException();
        }
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
        if(diagnostic==null){
            throw new NullPointerException();
        }
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
        if(idDiagnostic<0){
            throw new IllegalArgumentException();
        }
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
        if(idMedicalRecord<0){
            throw new IllegalArgumentException();
        }
        JPADoctor doctor = new JPADoctor();
        return doctor.getAllDiagnostics(idMedicalRecord);
    }

    /**
     * Validate a Draft Diagnostic
     * 
     * @param idDiagnostic The id of the Diagnostic to validate
     * @return True if the draft diagnostic don't exists in the database, or false otherwise
     */
    @Override
    public boolean validateDiagnostic(long idDiagnostic) {
        if(idDiagnostic<0){
            throw new IllegalArgumentException();
        }
        JPADoctor doctor = new JPADoctor();
        return doctor.validateDiagnostic(idDiagnostic);
    }

    /**
     * Remove a Draft Diagnostic from the database
     * 
     * @param idDiagnostic Draft Diagnostic to remove
     * @return True if the draft diagnostic don't exists in the database, or false otherwise
     */
    @Override
    public boolean removeDraftDiagnostic(long idDiagnostic) {
        if(idDiagnostic<0){
            throw new IllegalArgumentException();
        }
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
        if(dosage==null){
            throw new NullPointerException();
        }
        JPADoctor doctor = new JPADoctor();
        return doctor.createDosage(dosage);
    }

    /**
     * Validate a Draft Dosage
     * 
     * @param idDosage The id of the Dosage to validate
     * @return True if the draft dosage don't exists in the database, or false otherwise
     */
    @Override
    public boolean validateDosage(long idDosage) {
        if(idDosage<0){
            throw new IllegalArgumentException();
        }
        JPADoctor doctor = new JPADoctor();
        return doctor.validateDosage(idDosage);
    }

    /**
     * Remove a Draft Dosage from the database
     * 
     * @param idDosage Draft Dosage to remove
     * @return True if the draft dosage don't exists in the database, or false otherwise
     */
    @Override
    public boolean removeDraftDosage(long idDosage) {
        if(idDosage<0){
            throw new IllegalArgumentException();
        }
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
        if(idMedicalRecord<0){
            throw new IllegalArgumentException();
        }
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
        if(ss==null){
            throw new NullPointerException();
        }
        if(stringNotConform(ss)){
            throw new IllegalArgumentException();
        }
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
        if(lastName==null){
            throw new NullPointerException();
        }
        if(stringNotConform(lastName)){
            throw new IllegalArgumentException();
        }
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
        if(ss==null || lastName==null){
            throw new NullPointerException();
        }
        if(stringNotConform(lastName) || stringNotConform(ss)){
            throw new IllegalArgumentException();
        }
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
        if(idDosage<0){
            throw new IllegalArgumentException();
        }
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
        if(idMedicalRecord<0){
            throw new IllegalArgumentException();
        }
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
        if(idDoctor<0){
            throw new IllegalArgumentException();
        }
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
        if(idNurse<0){
            throw new IllegalArgumentException();
        }
        JPADoctor doctor = new JPADoctor();
        return doctor.getNurse(idNurse);
    }
    
    /**
     * Get the Staff in the Staff Entity
     * 
     * @param type The type of the Staff
     * @param idStaff The if of the Staff
     * @return The MedicalStaff
     */
    public MedicalStaff getStaff(String type, long idStaff) {
        if(type==null){
            throw new NullPointerException();
        }
        if(stringNotConform(type) || idStaff<0){
            throw new IllegalArgumentException();
        }
        JPADoctor doctor = new JPADoctor();
        return doctor.getMedicalStaff(type, idStaff);
    }
}
