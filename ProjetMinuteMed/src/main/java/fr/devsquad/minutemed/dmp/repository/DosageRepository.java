package fr.devsquad.minutemed.dmp.repository;

import fr.devsquad.minutemed.dmp.domain.Dosage;
import java.util.List;
import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author myfou
 */
@Stateless
public class DosageRepository {
@PersistenceContext(unitName = "APHPPU")
    private EntityManager em;

    public List<Dosage> list(Long idMedicalRecord) {
        TypedQuery<Dosage> tq = em.createQuery("SELECT d FROM Dosage d WHERE d.medicalRecord.idMedicalRecord = :idMedicalRecord AND d.draft = :draft", Dosage.class);
        return tq.setParameter("idMedicalRecord", idMedicalRecord).setParameter("draft", false).getResultList();
    }

    public Dosage find(Long id) {
        return em.find(Dosage.class, id);
    }

    public Long save(Dosage dosage) {
        em.persist(dosage);
        return dosage.getIdDosage();
    }

    public void update(Dosage dosage) {
        em.merge(dosage);
    }

    public void delete(Long id) {
        Dosage dosage = find(id);
        if (dosage == null) {
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(dosage);
    }    
}
