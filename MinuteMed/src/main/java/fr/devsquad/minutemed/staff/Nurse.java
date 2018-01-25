package fr.devsquad.minutemed.staff;

import fr.devsquad.minutemed.database.INurse;
import fr.devsquad.minutemed.database.JPANurse;
import fr.devsquad.minutemed.dmp.MedicalRecord;
import fr.devsquad.minutemed.dmp.Dosage;
import java.io.Serializable;
import java.util.List;
import java.util.function.Predicate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Nurse implements Serializable, IHospitalStaff, IMedicalStaff, INurse {

    @Id @GeneratedValue
    private long idStaff; 
    private String firstName;
    private String lastName;
    private String adress;
    private String email;
    private String phoneNumber;
    
    @OneToOne
    private Node node;
    
    public Nurse() { }
    
    public Nurse(String firstName, String lastName, String adress, String email, String phoneNumber, Node node) { 
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.node = node;
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
     * Get a MedicalRecord with its id passed in argument
     * 
     * @param idMedicalRecord The id of the MedicalRecord
     * @return The MedicalRecord
     */
    @Override
    public MedicalRecord getMedicalRecord(long idMedicalRecord) {
        JPANurse nurse = new JPANurse();
        return nurse.getMedicalRecord(idMedicalRecord);
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

    @Override
    public List<MedicalRecord> searchMedicalRecord(Predicate predicate) {
        JPANurse nurse = new JPANurse();
        return nurse.searchMedicalRecord(predicate);
    }

    @Override
    public Dosage getDosage(long idMedicalRecord, long idDosage) {
        JPANurse nurse = new JPANurse();
        return nurse.getDosage(idMedicalRecord, idDosage);
    }

    @Override
    public List<Dosage> getAllDosages(long idMedicalRecord) {
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
        JPANurse nurse = new JPANurse();
        return nurse.getNurse(idNurse);
    }
}
