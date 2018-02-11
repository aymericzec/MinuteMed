/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.staff.repository;

import fr.devsquad.minutemed.staff.domain.DataManager;
import fr.devsquad.minutemed.staff.domain.Doctor;
import fr.devsquad.minutemed.staff.domain.IHospitalStaff;
import fr.devsquad.minutemed.staff.domain.Nurse;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.NoSuchEntityException;
import javax.persistence.EntityManager;

/**
 *
 * @author JSalmon
 */
public class StaffRepository {
    
    private EntityManager em;
    
    public Doctor findDoctor(Long id){
        return em.find(Doctor.class, id);
    }
    
    public DataManager findDataManager(Long id){
        return em.find(DataManager.class, id);
    }
    
    public Nurse findNurse(Long id){
        return em.find(Nurse.class,id);
    }
    
    public void deleteDoctor(Long id){
        Doctor staff = findDoctor(id);
        if( staff == null){
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(staff);
    }
    
    public void deleteDataManager(Long id){
        DataManager staff = findDataManager(id);
        if( staff == null){
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(staff);
    }
    
    public void deleteNurse(Long id){
        Nurse staff = findNurse(id);
        if( staff == null){
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(staff);
    }
    
    public Long saveDoctor(Doctor staff){
        em.persist(staff);
        return staff.getId();
    }
    
    public Long saveDataManager(DataManager staff){
        em.persist(staff);
        return staff.getId();
    }
    
    public Long saveNurse(Nurse staff){
        em.persist(staff);
        return staff.getId();
    }
    
    public List<Doctor> findAllDoctor(){
        return em.createNamedQuery(Doctor.FIND_ALL_DOCTOR, Doctor.class).getResultList();
    }
    
    public List<Nurse> findAllNurse(){
        return em.createNamedQuery(Nurse.FIND_ALL_NURSE, Nurse.class).getResultList();
    }
    
    public List<DataManager> findALLDataManager(){
        return em.createNamedQuery(DataManager.FIND_ALL_DATAMANAGER, DataManager.class).getResultList();
    }
    
    public List<IHospitalStaff> findAllStaffs(){
        List<Doctor> doctors= findAllDoctor();
        List<DataManager> datamanagers= findALLDataManager();
        List<Nurse> nurses= findAllNurse();
        
        List<IHospitalStaff> staffs = new ArrayList<>();
        
        datamanagers.forEach((staff) -> {
            staffs.add(staff);
        });
        
        doctors.forEach((staff) -> {
            staffs.add(staff);
        });
        
        nurses.forEach((staff) -> {
            staffs.add(staff);
        });
        
        return staffs;
    }
}
