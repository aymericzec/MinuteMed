package fr.devsquad.minutemed.staff.domain;

import fr.devsquad.minutemed.arborescence.domain.INode;
import fr.devsquad.minutemed.arborescence.domain.Node;
import fr.devsquad.minutemed.arborescence.domain.NodeEnum;
import fr.devsquad.minutemed.arborescence.domain.NodeHU;
import fr.devsquad.minutemed.arborescence.domain.NodeHospital;
import fr.devsquad.minutemed.arborescence.domain.NodePole;
import fr.devsquad.minutemed.arborescence.domain.NodeService;
import fr.devsquad.minutemed.database.INurse;
import fr.devsquad.minutemed.database.JPADataManager;
import fr.devsquad.minutemed.database.JPANurse;
import fr.devsquad.minutemed.dmp.domain.MedicalRecord;
import fr.devsquad.minutemed.dmp.domain.Dosage;
import static fr.devsquad.minutemed.staff.domain.Nurse.FIND_ALL_NURSE;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = FIND_ALL_NURSE, query = "SELECT staff FROM Nurse staff")
public class Nurse implements Serializable, IHospitalStaff, IMedicalStaff, INurse {

    public static final String FIND_ALL_NURSE = "Nurse.findAllNurse";
    
    @Id @GeneratedValue
    @Column(name = "idNurse")
    private long id;
    private String type;
    private String firstName;
    private String lastName;
    private String adress;
    private String email;
    private String phoneNumber;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idNode")
    private Node node;
    
    public Nurse() { }
    
    public Nurse(StaffEnum type, String firstName, String lastName, String adress, String email, String phoneNumber, Node node) { 
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
        
        this.type = type.NURSE.name();
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.node = node;
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
        JPANurse nurse = new JPANurse();
        
        MedicalRecord mRecord = nurse.getMedicalRecord(idMedicalRecord);
        
        if(node.getType().equals(NodeEnum.HOSPITAL.name())) {
            
            NodeHospital hospital = manager.getHospital(node.getIdNodeInfo());
            
            for(INode node : hospital.getAttachedNodes()) {
                if(node.getId() == mRecord.getId()) {
                    return mRecord;
                }
            }
        }
        
        if(node.getType().equals(NodeEnum.POLE.name())) {
            
            NodePole pole = manager.getPole(node.getIdNodeInfo());
            
            for(INode node : pole.getAttachedNodes()) {
                if(node.getId() == mRecord.getId()) {
                    return mRecord;
                }
            }
        }
        
        if(node.getType().equals(NodeEnum.SERVICE.name())) {
            
            NodeService service = manager.getService(node.getIdNodeInfo());
            
            for(INode node : service.getAttachedNodes()) {
                if(node.getId() == mRecord.getId()) {
                    return mRecord;
                }
            }
        }
        
        if(node.getType().equals(NodeEnum.HOSPITAL_UNIT.name())) {
            
            NodeHU hu = manager.getHospitalUnit(node.getIdNodeInfo());
            
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
        JPANurse nurse = new JPANurse();
        return nurse.getAllMedicalRecords();
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
        JPANurse nurse = new JPANurse();
        return nurse.searchMedicalRecordBySS(ss);
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
        JPANurse nurse = new JPANurse();
        return nurse.searchMedicalRecordByName(lastName);
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
        if(stringNotConform(ss) || stringNotConform(lastName)){
            throw new IllegalArgumentException();
        }
        JPANurse nurse = new JPANurse();
        return nurse.searchMedicalRecord(ss, lastName);
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
        JPANurse nurse = new JPANurse();
        return nurse.getDosage(idDosage);
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
        JPANurse nurse = new JPANurse();
        return nurse.getAllDosages(idMedicalRecord);
    }

    /**
     * Get a Doctor with its id passed in argument
     * 
     * @param idDoctor The id of the Doctor
     * @return The Doctor
     */
    @Override
    public Doctor getDoctor(long idDoctor) {
        if( idDoctor<0){
            throw new IllegalArgumentException();
        }
        JPANurse nurse = new JPANurse();
        return nurse.getDoctor(idDoctor);
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
        JPANurse nurse = new JPANurse();
        return nurse.getNurse(idNurse);
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
        JPANurse nurse = new JPANurse();
        return nurse.getMedicalStaff(type, idStaff);
    }
    
    @Override
    public String toString() {
        StringBuilder stb =  new StringBuilder();
        stb.append("Doctor :").append(this.lastName).append(this.firstName);
        return stb.toString();
    }
}
