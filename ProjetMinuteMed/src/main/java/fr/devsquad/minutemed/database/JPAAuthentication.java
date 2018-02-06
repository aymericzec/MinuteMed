package fr.devsquad.minutemed.database;

import fr.devsquad.minutemed.authentication.domain.UserAccount;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class JPAAuthentication {
    
    private static final String PERSISTENCE_UNIT = "APHPPU";
    private final EntityManagerFactory emf;
    private final EntityManager em;
    
    /**
     * Constructor of the class, initialize the fields to manipulate the database
     */
    public JPAAuthentication() {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        em = emf.createEntityManager();
    }

    /**
     * Get the account of an user with its username and password passed in argument
     * 
     * @param username The username of the user 
     * @param password The password of the user
     * @return The account
     */
    public UserAccount login(String username, String password) {
        
        TypedQuery<UserAccount> user = em.createQuery("SELECT account FROM UserAccount account WHERE account.username = :username AND account.password = :password", UserAccount.class);
        return user.setParameter("username", username).setParameter("password", password).getSingleResult();
    }
    
    
}
