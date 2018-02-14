package fr.devsquad.minutemed.dmp.repository;

import fr.devsquad.minutemed.dmp.domain.MedicalRecord;

import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Manages interactions with the database.
 * Created by jefferson on 11/11/2017.
 */
@Stateless
public class MedicalRecordRepository {

    @PersistenceContext(unitName = "APHPPU")
    private EntityManager em;

    public List<MedicalRecord> list() {
        return em.createNamedQuery(MedicalRecord.FIND_ALL_MEDICAL_RECORD, MedicalRecord.class).getResultList();
    }

    public MedicalRecord find(Long id) {
        return em.find(MedicalRecord.class, id);
    }

    public Long save(MedicalRecord medicalRecord) {
        em.persist(medicalRecord);
        return medicalRecord.getIdMedicalRecord();
    }

    public void update(MedicalRecord medicalRecord) {
        em.merge(medicalRecord);
    }

    public void delete(Long id) {
        MedicalRecord medicalRecord = find(id);
        if (medicalRecord == null) {
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(medicalRecord);
    }
}