package fr.devsquad.minutemed.dmp.repository;

import fr.devsquad.minutemed.dmp.domain.MedicalRecord;
import java.util.*;

import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.*;

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
    
    public MedicalRecord findBySS(String ss) {
        Objects.requireNonNull(ss);
        TypedQuery<MedicalRecord> qry = em.createQuery("SELECT m FROM MedicalRecord m WHERE m.ss = :ss",MedicalRecord.class);
        List<MedicalRecord> records = qry.setParameter("ss", ss).getResultList();
        return records.isEmpty() ? null : records.get(0);
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