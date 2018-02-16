/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.staff.repository;

import fr.devsquad.minutemed.staff.domain.*;
import fr.devsquad.minutemed.staff.domain.utils.*;
import java.util.*;
import javax.ejb.*;
import javax.persistence.*;

/**
 *
 * @author JSalmon
 */
@Stateless
public class StaffRepository {
    
    @PersistenceContext(unitName = "APHPPU")
    private EntityManager em;
    
    
    
    public List<MedicalStaff> findAllMedicalStaffs(){
        TypedQuery<MedicalStaff> qry = em.createQuery("Select m FROM MedicalStaff m", MedicalStaff.class);
        return qry.getResultList();      
    }
    
    public <T extends MedicalStaff> List<T> findMedicalStaffs(Class<T> clazz) {
        Objects.requireNonNull(clazz);
        TypedQuery<T> qry = em.createQuery("Select m FROM MedicalStaff m WHERE m.status = :status", clazz);
        return qry.setParameter("status", MedicalStaffStatusSupplier.getStatus(clazz)).getResultList();
    }
    
    public <T extends MedicalStaff> T findMedicalStaff(Long medicalStaffID, Class<T> clazz){
        Objects.requireNonNull(clazz);
        T result = null;
        TypedQuery<T> qry = em.createQuery("SELECT m FROM MedicalStaff m WHERE m.idMedicalStaff = :id AND m.status = :status", clazz);
        try{
            result = qry.setParameter("id", medicalStaffID).setParameter("status", MedicalStaffStatusSupplier.getStatus(clazz)).getSingleResult();  
        } catch (NoResultException nre){
           //do nothing 
        }
        return result;
    }
    
    public MedicalStaff findMedicalStaff(Long medicalStaffID){
        return em.find(MedicalStaff.class, Objects.requireNonNull(medicalStaffID));
    }
    
    public <T extends MedicalStaff> Long saveMedicalStaff(T medicalStaff){
        em.persist(medicalStaff);
        return medicalStaff.getIdMedicalStaff();
    }
    
    public <T extends MedicalStaff> void deleteMedicalStaff(Long medicalStaffID, Class<T> clazz){
        T medicalStaff = findMedicalStaff(Objects.requireNonNull(medicalStaffID), Objects.requireNonNull(clazz));
        if(medicalStaff == null){
            throw new NoSuchEntityException("No entity with the id: " + medicalStaffID);
        }
        em.remove(medicalStaff);
    }
    
}
