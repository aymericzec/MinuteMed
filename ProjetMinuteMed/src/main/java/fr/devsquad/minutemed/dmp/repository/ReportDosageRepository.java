package fr.devsquad.minutemed.dmp.repository;

import fr.devsquad.minutemed.dmp.domain.ReportDosage;
import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ReportDosageRepository {

    @PersistenceContext(unitName = "APHPPU")
    private EntityManager em;

    public List<ReportDosage> list() {
        return em.createNamedQuery(ReportDosage.FIND_ALL_REPORT_DOSAGE, ReportDosage.class).getResultList();
    }

    public ReportDosage find(Long id) {
        return em.find(ReportDosage.class, id);
    }

    public Long save(ReportDosage reportDosage) {
        em.persist(reportDosage);
        return reportDosage.getId();
    }

    public void update(ReportDosage reportDosage) {
        em.merge(reportDosage);
    }

    public void delete(Long id) {
        ReportDosage reportDosage = find(id);
        if (reportDosage == null) {
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(reportDosage);
    }
}