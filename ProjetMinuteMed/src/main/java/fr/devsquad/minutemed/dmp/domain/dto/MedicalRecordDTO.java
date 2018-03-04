/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.dmp.domain.dto;

import fr.devsquad.minutemed.arborescence.domain.NodeCU;
import fr.devsquad.minutemed.arborescence.domain.dto.NodeDTO;
import fr.devsquad.minutemed.arborescence.repository.ArborescenceRepository;
import fr.devsquad.minutemed.dmp.domain.MedicalRecord;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author enzo
 */
public class MedicalRecordDTO implements Serializable {
    
    
    private long id;
    
    private String ss;
    
    private String firstName;
    
    private String lastName;
    
    private String address;
    
    private String cityBorn;
    
    private String birthday;
    
    private String gender;
    
    private String phoneNumber;
    
    private String email;

    private NodeDTO careUnit;
    
    
    public MedicalRecordDTO(){}

    
    public MedicalRecordDTO(long id, String ss, String firstName, String lastName, String address, String cityBorn, String birthday, String gender, String phoneNumber, String email, NodeDTO careUnit) {
        this.id = id;
        this.ss = Objects.requireNonNull(ss);
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.address = Objects.requireNonNull(address);
        this.cityBorn = Objects.requireNonNull(cityBorn);
        this.birthday = Objects.requireNonNull(birthday);
        this.gender = Objects.requireNonNull(gender);
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
        this.email = Objects.requireNonNull(email);
        this.careUnit = Objects.requireNonNull(careUnit);
    }
    
    
    public static MedicalRecordDTO create(MedicalRecord medicalRecord){
        Objects.requireNonNull(medicalRecord);
        return new MedicalRecordDTO(medicalRecord.getIdMedicalRecord(),
                medicalRecord.getSs(),
                medicalRecord.getFirstName(),
                medicalRecord.getLastName(),
                medicalRecord.getAddress(),
                medicalRecord.getCityBorn(),
                medicalRecord.getBirthday(),
                medicalRecord.getGender(),
                medicalRecord.getPhoneNumber(),
                medicalRecord.getEmail(),
                NodeDTO.create(medicalRecord.getCU()));
    }
    
    
    public MedicalRecord toMedicalRecord(ArborescenceRepository arborescenceRepository){
        Objects.requireNonNull(arborescenceRepository);
        NodeCU node = arborescenceRepository.findNode(this.careUnit.getId(), NodeCU.class);
        MedicalRecord record = new MedicalRecord(ss, firstName, lastName, address, email, phoneNumber, cityBorn, birthday, gender, node);
        return record;
    }
    
    

    
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param idMedicalRecord the idMedicalRecord to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the ss
     */
    public String getSs() {
        return ss;
    }

    /**
     * @param ss the ss to set
     */
    public void setSs(String ss) {
        this.ss = ss;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the careUnit
     */
    public NodeDTO getCareUnit() {
        return careUnit;
    }

    /**
     * @param careUnit the careUnit to set
     */
    public void setCareUnit(NodeDTO careUnit) {
        this.careUnit = careUnit;
    }

    public String getCityBorn() {
        return cityBorn;
    }

    public void setCityBorn(String cityBorn) {
        this.cityBorn = cityBorn;
    }
    
    
    
}
