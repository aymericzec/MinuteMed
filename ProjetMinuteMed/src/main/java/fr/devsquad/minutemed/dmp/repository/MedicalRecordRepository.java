package fr.devsquad.minutemed.dmp.repository;

import fr.devsquad.minutemed.authentication.domain.UserAccount;

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

    public List<UserAccount> list() {
        return em.createNamedQuery(UserAccount.FIND_ALL_USER_ACCOUNT, UserAccount.class).getResultList();
    }

    public UserAccount find(Long id) {
        return em.find(UserAccount.class, id);
    }

    public Long save(UserAccount userAccount) {
        em.persist(userAccount);
        return userAccount.getIdAccount();
    }

    public void update(UserAccount userAccount) {
        em.merge(userAccount);
    }

    public void delete(Long id) {
        UserAccount userAccount = find(id);
        if (userAccount == null) {
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(userAccount);
    }
}