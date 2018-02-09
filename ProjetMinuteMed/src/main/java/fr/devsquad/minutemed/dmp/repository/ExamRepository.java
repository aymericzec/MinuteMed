package fr.devsquad.minutemed.dmp.repository;

import fr.devsquad.minutemed.dmp.domain.Exam;

import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ExamRepository {

    @PersistenceContext(unitName = "APHPPU")
    private EntityManager em;

    public List<Exam> list() {
        return em.createNamedQuery(Exam.FIND_ALL_EXAM, Exam.class).getResultList();
    }

    public Exam find(Long id) {
        return em.find(Exam.class, id);
    }

    public Long save(Exam exam) {
        em.persist(exam);
        return exam.getId();
    }

    public void update(Exam exam) {
        em.merge(exam);
    }

    public void delete(Long id) {
        Exam exam = find(id);
        if (exam == null) {
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(exam);
    }
}