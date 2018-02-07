/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.specialization.repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author JSalmon
 */
public class SpecializationRepository {
    
    private EntityManager em;
    
    public List<Specialization> listAllSpecializations(){
        TypedQuery<Specialization> services = em.createQuery("SELECT idSpecialization FROM Specialization", Specialization.class);
        return services.setParameter("idSpecialization", idSpecialization).getResultList();
    }
}
