package fr.devsquad.minutemed.authentication.repository;

import fr.devsquad.minutemed.authentication.domain.DoctorCreator;
import fr.devsquad.minutemed.authentication.domain.NurseCreator;
import fr.devsquad.minutemed.authentication.domain.UserAccount;
import fr.devsquad.minutemed.staff.domain.StaffEnum;

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
public class AuthenticationRepository {

    @PersistenceContext(unitName = "APHPPU")
    private EntityManager em;

    public List<UserAccount> list() {
        return em.createNamedQuery(UserAccount.FIND_ALL_USER_ACCOUNT, UserAccount.class).getResultList();
    }

    public UserAccount find(Long id) {
        return em.find(UserAccount.class, id);
    }

    
    public UserAccount saveDoctorAccount(DoctorCreator doctorCreator){
        UserAccount doctorAccount = new UserAccount(doctorCreator.getUsername(), doctorCreator.getPassword(), StaffEnum.DOCTOR);
        saveUserAccount(doctorAccount);
        return doctorAccount;
    }
    
    public UserAccount saveNurseAccount(NurseCreator nurseCreator){
        UserAccount nurseAccount = new UserAccount(nurseCreator.getUsername(), nurseCreator.getPassword(), StaffEnum.NURSE);
        saveUserAccount(nurseAccount);
        return nurseAccount;
    }
    
    private Long saveUserAccount(UserAccount userAccount) {
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