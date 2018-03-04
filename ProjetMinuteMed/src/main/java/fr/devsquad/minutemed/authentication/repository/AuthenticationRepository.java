package fr.devsquad.minutemed.authentication.repository;

import fr.devsquad.minutemed.authentication.domain.DataManagerCreator;
import fr.devsquad.minutemed.authentication.domain.DoctorCreator;
import fr.devsquad.minutemed.authentication.domain.NurseCreator;
import fr.devsquad.minutemed.authentication.domain.UserAccount;
import fr.devsquad.minutemed.jwt.utils.PasswordUtils;
import fr.devsquad.minutemed.staff.domain.StaffEnum;
import java.util.*;

import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.*;


@Stateless
public class AuthenticationRepository {

    @PersistenceContext(unitName = "APHPPU")
    private EntityManager em;
    

    public List<UserAccount> findAllUsers() {
        return em.createNamedQuery(UserAccount.FIND_ALL_USER, UserAccount.class).getResultList();
    }
    
    public UserAccount Authenticate(String username, String password) {
        System.out.println("fr.devsquad.minutemed.authentication.repository.AuthenticationRepository.Authenticate()");
        TypedQuery<UserAccount> qry = em.createQuery("SELECT u FROM UserAccount u WHERE u.username = :username", UserAccount.class);
        List<UserAccount> tmp = qry.setParameter("username", username).getResultList();
        
        UserAccount user = tmp.isEmpty() ? null : tmp.get(0);
        System.out.println("nb result : " + tmp.size());
        if (null != user ) {
            if (!PasswordUtils.digestPassword(password).equals(user.getPassword())) {
                user = null;
            }
        }
        return user;
    }

    public UserAccount find(Long id) {
        return em.find(UserAccount.class, id);
    }
    
    
    public boolean usernameAlreadyExist(String username){
        TypedQuery<UserAccount> qry = em.createQuery("SELECT u FROM UserAccount u WHERE u.username = :username", UserAccount.class);
        return !qry.setParameter("username", username).getResultList().isEmpty();
    }

    
    public UserAccount saveDoctorAccount(Long id, DoctorCreator doctorCreator){
        Objects.requireNonNull(doctorCreator);
        UserAccount doctorAccount = new UserAccount(Objects.requireNonNull(id), doctorCreator.getUsername(), doctorCreator.getPassword(), StaffEnum.DOCTOR);
        saveUserAccount(doctorAccount);
        return doctorAccount;
    }
    
    public UserAccount saveNurseAccount(Long id, NurseCreator nurseCreator){
        Objects.requireNonNull(nurseCreator);
        UserAccount nurseAccount = new UserAccount(Objects.requireNonNull(id), nurseCreator.getUsername(), nurseCreator.getPassword(), StaffEnum.NURSE);
        saveUserAccount(nurseAccount);
        return nurseAccount;
    }
    
    public UserAccount saveDataManagerAccount(Long id, DataManagerCreator dataManagerCreator){
        Objects.requireNonNull(dataManagerCreator);
        UserAccount dataManagerAccount = new UserAccount(Objects.requireNonNull(id), dataManagerCreator.getUsername(), dataManagerCreator.getPassword(), StaffEnum.DATA_MANAGER);
        saveUserAccount(dataManagerAccount);
        return dataManagerAccount;
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