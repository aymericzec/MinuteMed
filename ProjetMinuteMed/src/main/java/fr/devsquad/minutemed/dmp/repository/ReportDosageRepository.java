package fr.devsquad.minutemed.dmp.repository;

import fr.devsquad.minutemed.dmp.domain.DosageReport;
import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ReportDosageRepository {

    @PersistenceContext(unitName = "APHPPU")
    private EntityManager em;

    public List<DosageReport> list() {
        return em.createNamedQuery(DosageReport.FIND_ALL_REPORT_DOSAGE, DosageReport.class).getResultList();
    }

    public DosageReport find(Long id) {
        return em.find(DosageReport.class, id);
    }

    public Long save(DosageReport reportDosage) {
        em.persist(reportDosage);
        return reportDosage.getIdReportDosage();
    }

    public void update(DosageReport reportDosage) {
        em.merge(reportDosage);
    }

    public void delete(Long id) {
        DosageReport reportDosage = find(id);
        if (reportDosage == null) {
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(reportDosage);
    }
}