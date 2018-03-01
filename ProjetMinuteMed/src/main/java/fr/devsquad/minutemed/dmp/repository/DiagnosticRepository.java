package fr.devsquad.minutemed.dmp.repository;

import fr.devsquad.minutemed.dmp.domain.Diagnostic;
import fr.devsquad.minutemed.dmp.domain.Exam;

import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.TypedQuery;

@Stateless
public class DiagnosticRepository {

    @PersistenceContext(unitName = "APHPPU")
    private EntityManager em;

    public List<Diagnostic> list(Long idMedicalRecord) {
        TypedQuery<Diagnostic> tq = em.createQuery("SELECT d FROM Diagnostic d WHERE d.medicalRecord.idMedicalRecord = :idMedicalRecord AND d.draft = :draft", Diagnostic.class);
        return tq.setParameter("idMedicalRecord", idMedicalRecord).setParameter("draft", false).getResultList();
    }

    public Diagnostic find(Long id) {
        return em.find(Diagnostic.class, id);
    }

    public Long save(Diagnostic diagnostic) {
        em.persist(diagnostic);
        return diagnostic.getIdDiagnostic();
    }

    public void update(Diagnostic diagnostic) {
        em.merge(diagnostic);
    }

    public void delete(Long id) {
        Diagnostic diagnostic = find(id);
        if (diagnostic == null) {
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(diagnostic);
    }
}