package fr.devsquad.minutemed.dmp.repository;

import fr.devsquad.minutemed.dmp.domain.Diagnostic;

import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DiagnosticRepository {

    @PersistenceContext(unitName = "APHPPU")
    private EntityManager em;

    public List<Diagnostic> list() {
        return em.createNamedQuery(Diagnostic.FIND_ALL_DIAGNOSTIC, Diagnostic.class).getResultList();
    }

    public Diagnostic find(Long id) {
        return em.find(Diagnostic.class, id);
    }

    public Long save(Diagnostic diagnostic) {
        em.persist(diagnostic);
        return diagnostic.getId();
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