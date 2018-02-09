package fr.devsquad.minutemed.dmp.repository;

import fr.devsquad.minutemed.dmp.domain.Prescription;

import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PrescriptionRepository {

    @PersistenceContext(unitName = "APHPPU")
    private EntityManager em;

    public List<Prescription> list() {
        return em.createNamedQuery(Prescription.FIND_ALL_PRESCRIPTION, Prescription.class).getResultList();
    }

    public Prescription find(Long id) {
        return em.find(Prescription.class, id);
    }

    public Long save(Prescription prescription) {
        em.persist(prescription);
        return prescription.getId();
    }

    public void update(Prescription prescription) {
        em.merge(prescription);
    }

    public void delete(Long id) {
        Prescription prescription = find(id);
        if (prescription == null) {
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(prescription);
    }
}