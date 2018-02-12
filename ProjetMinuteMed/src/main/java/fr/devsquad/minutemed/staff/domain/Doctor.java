package fr.devsquad.minutemed.staff.domain;

import fr.devsquad.minutemed.arborescenceOld.domain.INode;
import fr.devsquad.minutemed.arborescenceOld.domain.NodeOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodeEnumOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodeHUOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodeHospitalOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodePoleOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodeServiceOld;
import fr.devsquad.minutemed.authentication.domain.DoctorCreator;
import fr.devsquad.minutemed.database.IDoctor;
import fr.devsquad.minutemed.database.INurse;
import fr.devsquad.minutemed.database.JPADataManager;
import fr.devsquad.minutemed.database.JPADoctor;
import fr.devsquad.minutemed.dmp.domain.Diagnostic;
import fr.devsquad.minutemed.dmp.domain.Dosage;
import fr.devsquad.minutemed.dmp.domain.Exam;
import fr.devsquad.minutemed.dmp.domain.MedicalRecord;
import fr.devsquad.minutemed.dmp.domain.Prescription;
import fr.devsquad.minutemed.specialization.domain.Specialization;
import static fr.devsquad.minutemed.staff.domain.Doctor.FIND_ALL_DOCTOR;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;


@Entity
@NamedQuery(name = FIND_ALL_DOCTOR, query = "SELECT staff FROM Doctor staff")
public class Doctor implements Serializable, IHospitalStaff, IMedicalStaff, IDoctor, INurse, ISpecialistStaff {

    public static final String FIND_ALL_DOCTOR = "Doctor.findAllDoctor";
    
    @Id
    @Column(name = "idDoctor")
    private Long id; 
    
    @NotNull
    private String type;
    
    @NotNull
    private String firstName;
    
    @NotNull
    private String lastName;
    
    @NotNull
    private String adress;
    
    @NotNull
    private String email;
    
    @NotNull
    private String phoneNumber;
    
    @NotNull
    private String specialization;
    
    @NotNull
    @JoinColumn(name = "idNode")
    private NodeOld node;
 
    public Doctor() { }
    
    public Doctor(Long id, String firstName, String lastName, String adress, String email, String phoneNumber, NodeOld node , Specialization specialization) { 
      
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
        this.id = Objects.requireNonNull(id);
        this.type = StaffEnum.DOCTOR.name();
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.adress = Objects.requireNonNull(adress);
        this.email = Objects.requireNonNull(email);
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
        this.node = Objects.requireNonNull(node);
        this.specialization = Objects.requireNonNull(specialization).getStaffName();
    }
    
    public static Doctor createFromDoctorCreator(Long id, DoctorCreator doctorCreator, NodeOld node, Specialization specialization){
        Objects.requireNonNull(doctorCreator);
        return new Doctor(Objects.requireNonNull(id), doctorCreator.getFirstName(), doctorCreator.getFirstName(), 
                            doctorCreator.getAdress(), doctorCreator.getEmail(), doctorCreator.getPhoneNumber(),
                            Objects.requireNonNull(node), specialization);
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
    public NodeOld getNode() {
        return node;
    }

    @Override
    public String getSpecialization() {
        return specialization;
    }
    
    @Override
    public void setFirstName(String firstName) {
        Objects.requireNonNull(firstName);
        if(stringNotConform(firstName)){
            throw new IllegalArgumentException();
        }
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        Objects.requireNonNull(lastName);
        if(stringNotConform(lastName)){
            throw new IllegalArgumentException();
        }
        this.lastName = lastName;
    }

    @Override
    public void setAdress(String adress) {
        Objects.requireNonNull(adress);
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
    public void setNode(NodeOld node) {
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
     * Change a Node MedicalRecord 
     * 
     * @param idMedicalRecord The id of the MedicalRecord
     * @param hu The Node to affect them
     * @return True if the medicalRecord don't exists in the database, or false
     */
    @Override
    public boolean changeNodeMedicalRecord(long idMedicalRecord, NodeHUOld hu) {
        
        if(node.getIdNodeInfo() == hu.getId()) {
            JPADoctor doctor = new JPADoctor();
            return doctor.changeNodeMedicalRecord(idMedicalRecord, hu);
        }
        return false;
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
        JPADataManager manager = new JPADataManager();
        JPADoctor doctor = new JPADoctor();
        
        MedicalRecord mRecord = doctor.getMedicalRecord(idMedicalRecord);
        
        if(node.getType().equals(NodeEnumOld.HOSPITAL.name())) {
            
            NodeHospitalOld hospital = manager.getHospital(node.getIdNodeInfo());
            
            for(INode node : hospital.getAttachedNodes()) {
                if(node.getId() == mRecord.getId()) {
                    return mRecord;
                }
            }
        }
        
        if(node.getType().equals(NodeEnumOld.POLE.name())) {
            
            NodePoleOld pole = manager.getPole(node.getIdNodeInfo());
            
            for(INode node : pole.getAttachedNodes()) {
                if(node.getId() == mRecord.getId()) {
                    return mRecord;
                }
            }
        }
        
        if(node.getType().equals(NodeEnumOld.SERVICE.name())) {
            
            NodeServiceOld service = manager.getService(node.getIdNodeInfo());
            
            for(INode node : service.getAttachedNodes()) {
                if(node.getId() == mRecord.getId()) {
                    return mRecord;
                }
            }
        }
        
        if(node.getType().equals(NodeEnumOld.HOSPITAL_UNIT.name())) {
            
            NodeHUOld hu = manager.getHospitalUnit(node.getIdNodeInfo());
            
            for(INode node : hu.getAttachedNodes()) {
                if(node.getId() == mRecord.getId()) {
                    return mRecord;
                }
            }
        }
         
        return null;
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

    @Override
    public String toString() {
        StringBuilder stb =  new StringBuilder();
        stb.append("Infirmière :").append(this.lastName).append(this.firstName);
        return stb.toString();
    }
    
    
}
