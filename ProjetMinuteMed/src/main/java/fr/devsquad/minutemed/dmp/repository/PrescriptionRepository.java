package fr.devsquad.minutemed.dmp.repository;

import fr.devsquad.minutemed.dmp.domain.Exam;
import fr.devsquad.minutemed.dmp.domain.Prescription;

import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.TypedQuery;

@Stateless
public class PrescriptionRepository {

    @PersistenceContext(unitName = "APHPPU")
    private EntityManager em;

    public List<Prescription> list(Long idMedicalRecord) {
        TypedQuery<Prescription> tq = em.createQuery("SELECT p FROM Prescription p WHERE p.medicalRecord.idMedicalRecord = :idMedicalRecord AND p.draft = :draft", Prescription.class);
        return tq.setParameter("idMedicalRecord", idMedicalRecord).setParameter("draft", false).getResultList();
    }

    public Prescription find(Long id) {
        return em.find(Prescription.class, id);
    }

    public Long save(Prescription prescription) {
        em.persist(prescription);
        return prescription.getIdPrescription();
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