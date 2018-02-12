/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.specialization.repository;

import fr.devsquad.minutemed.specialization.domain.Specialization;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JSalmon
 */
@Stateless
public class SpecializationRepository {
    
    @PersistenceContext(unitName = "APHPPU")
    private EntityManager em;
    
    public List<Specialization> listAllSpecializations(){
        return em.createNamedQuery(Specialization.FIND_ALL_SPECIALIZATION, Specialization.class).getResultList();
    }
    
    public Specialization findSpecialization(Long id){
        return em.find(Specialization.class, id);
    }
}
