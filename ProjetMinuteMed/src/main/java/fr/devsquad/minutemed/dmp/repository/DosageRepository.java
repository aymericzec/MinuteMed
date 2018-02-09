package fr.devsquad.minutemed.dmp.repository;

import fr.devsquad.minutemed.dmp.domain.Dosage;
import java.util.List;
import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author myfou
 */
@Stateless
public class DosageRepository {
@PersistenceContext(unitName = "APHPPU")
    private EntityManager em;

    public List<Dosage> list() {
        return em.createNamedQuery(Dosage.FIND_ALL_DOSAGE, Dosage.class).getResultList();
    }

    public Dosage find(Long id) {
        return em.find(Dosage.class, id);
    }

    public Long save(Dosage dosage) {
        em.persist(dosage);
        return dosage.getId();
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
