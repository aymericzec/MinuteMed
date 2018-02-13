package fr.devsquad.minutemed.dmp.repository;

import fr.devsquad.minutemed.dmp.domain.ResultExam;

import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ResultExamRepository {

    @PersistenceContext(unitName = "APHPPU")
    private EntityManager em;

    public List<ResultExam> list() {
        return em.createNamedQuery(ResultExam.FIND_ALL_RESULT_EXAM, ResultExam.class).getResultList();
    }

    public ResultExam find(Long id) {
        return em.find(ResultExam.class, id);
    }

    public Long save(ResultExam resultExam) {
        em.persist(resultExam);
        return resultExam.getIdResultExam();
    }

    public void update(ResultExam resultExam) {
        em.merge(resultExam);
    }

    public void delete(Long id) {
        ResultExam resultExam = find(id);
        if (resultExam == null) {
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(resultExam);
    }
}