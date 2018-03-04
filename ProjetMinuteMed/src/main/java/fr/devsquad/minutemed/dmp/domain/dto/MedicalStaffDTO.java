/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.dmp.domain.dto;

import fr.devsquad.minutemed.arborescence.domain.Node;
import fr.devsquad.minutemed.arborescence.repository.ArborescenceRepository;
import fr.devsquad.minutemed.staff.domain.MedicalStaff;
import fr.devsquad.minutemed.staff.repository.StaffRepository;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author enzo
 */
public class MedicalStaffDTO implements Serializable {
    
    private Long id;
    
    private String lastname;
    
    private String firstname;
    
    private Long idNode;
    
    private String status;
    
    public MedicalStaffDTO() {
    }

    public MedicalStaffDTO(long id, String lastname, String firstname, Long idNode, String status) {
        this.id = Objects.requireNonNull(id);
        this.lastname = Objects.requireNonNull(lastname);
        this.firstname = Objects.requireNonNull(firstname);
        this.idNode = Objects.requireNonNull(idNode);
        this.status = Objects.requireNonNull(status);
    }
    
    public static MedicalStaffDTO create(MedicalStaff staff){
        Objects.requireNonNull(staff);
        return new MedicalStaffDTO(staff.getIdMedicalStaff(), staff.getFirstName(), staff.getLastName(), staff.getNode().getIdNode(), staff.getStatus());
    }
    
    
    public MedicalStaff toMedicalStaff(StaffRepository staffRepository, ArborescenceRepository arborescenceRepository){
        Objects.requireNonNull(staffRepository);
        Objects.requireNonNull(arborescenceRepository);
        MedicalStaff medicalStaff = staffRepository.findMedicalStaff(this.id);
        Node node = arborescenceRepository.findNode(idNode, Node.class);
        return new MedicalStaff(status, firstname, lastname, medicalStaff.getAddress(), medicalStaff.getEmail(), medicalStaff.getPhoneNumber(), node);
    }
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public Long getIdNode() {
        return idNode;
    }

    public void setIdNode(Long idNode) {
        this.idNode = idNode;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
    
    
    
}
