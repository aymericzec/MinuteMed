package fr.devsquad.minutemed.dmp.repository;

import fr.devsquad.minutemed.dmp.domain.Exam;

import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.TypedQuery;
@Stateless
public class ExamRepository {

    @PersistenceContext(unitName = "APHPPU")
    private EntityManager em;

    public List<Exam> list(Long idMedicalRecord) {
        TypedQuery<Exam> tq = em.createQuery("SELECT e FROM Exam e WHERE e.medicalRecord.idMedicalRecord = :idMedicalRecord AND e.draft = :draft", Exam.class);
        return tq.setParameter("idMedicalRecord", idMedicalRecord).setParameter("draft", false).getResultList();
    }

    public Exam find(Long id) {
        return em.find(Exam.class, id);
    }

    public Long save(Exam exam) {
        em.persist(exam);
        return exam.getIdExam();
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