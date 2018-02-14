/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.specialization.repository;

import fr.devsquad.minutemed.specialization.domain.Specialization;
import java.util.*;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author JSalmon
 */
@Stateless
public class SpecializationRepository {
    
    @PersistenceContext(unitName = "APHPPU")
    private EntityManager em;
    
    public List<Specialization> listAllSpecializations(){
        return em.createQuery("SELECT spe FROM Specialization spe", Specialization.class).getResultList();
    }
    
    public Specialization findSpecialization(Long id){
        return em.find(Specialization.class, id);
    }
    
    public Specialization findByStaffName(String staffName){
        Objects.requireNonNull(staffName);
        TypedQuery<Specialization> qry = em.createQuery("SELECT s FROM Specialization s WHERE s.staffName = :staffName", Specialization.class);
        List<Specialization> tmp = qry.setParameter("staffName", staffName).getResultList();
        return tmp.isEmpty() ? null : tmp.get(0);
    }
    
    
}
