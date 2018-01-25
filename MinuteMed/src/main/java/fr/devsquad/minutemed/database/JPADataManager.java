package fr.devsquad.minutemed.database;

import fr.devsquad.minutemed.authentication.UserAccount;
import fr.devsquad.minutemed.staff.Doctor;
import fr.devsquad.minutemed.staff.IHospitalStaff;
import fr.devsquad.minutemed.staff.Nurse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class JPADataManager implements IDataManager {
    
    private static final String PERSISTENCE_UNIT = "APHPPU";
    private final EntityManagerFactory emf;
    private final EntityManager em;
    private final EntityTransaction et;
    
    /**
     * Constructor of the class, initialize the fields to manipulate the database
     */
    public JPADataManager() {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        em = emf.createEntityManager();
        et = em.getTransaction();
    }

    /**
     * Add an Account in the database
     * 
     * @param account The Account to add
     * @return True if the account don't exists in the database, or false otherwise
     */
    @Override
    public boolean createAccount(UserAccount account) {
        
        Objects.requireNonNull(account);
        
        try {
            et.begin();
            em.persist(account);
            et.commit();
        } catch(EntityExistsException e) {
            return false;
        }
        return true;
    }

    /**
     * Remove an Account from the database
     * 
     * @param idAccount Account to remove
     * @return True if the account don't exists in the database, or false otherwise
     */
    @Override
    public boolean removeAccount(long idAccount) {
        
        try {
            et.begin();
            UserAccount account = em.find(UserAccount.class, idAccount);
            em.remove(account);
            et.commit();
        } catch (EntityNotFoundException e) {
            return false;
        }
        return true;
    }

    /**
     * Add a Hospital in the database
     * 
     * @param hospital The Hospital to add
     * @return True if the hospital don't exists in the database, or false otherwise
     */
    @Override
    public boolean createHospital(NodeHospital hospital) {
        
        Objects.requireNonNull(hospital);
        
        try {
            et.begin();
            em.persist(hospital);
            et.commit();
        } catch(EntityExistsException e) {
            return false;
        }
        return true;
    }

    /**
     * Get an Hospital with its id passed in argument
     * 
     * @param idHospital The id of the Hospital
     * @return The Hospital
     */
    @Override
    public NodeHospital getHospital(long idHospital) {
        
        NodeHospital hospital;
        
        try {
            hospital = em.find(NodeHospital.class, idHospital);
        } catch(EntityNotFoundException e) {
            return null;
        }
        return hospital;
    }

    /**
     * Get all Hospitals
     * 
     * @return A list of Hospitals
     */
    @Override
    public List<NodeHospital> getAllHospitals() {
        
        List<NodeHospital> hospitals;
        
        try {
            TypedQuery<NodeHospital> tq = em.createQuery("SELECT hospital FROM NodeHospital hospital", NodeHospital.class);
            hospitals = tq.getResultList();
        } catch(NoResultException e) {
            return null;
        }
        return hospitals;
    }

    @Override
    public boolean createPole(long idHospital, NodePole pole) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NodePole getPole(long idHospital, long idPole) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NodePole> getAllPoles(long idHospital) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createService(long idHospital, long idPole, NodeService service) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NodeService getService(long idHospital, long idPole, long idService) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NodeService> getAllServices(long idHospital) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createHospitalUnit(long idHospital, long idPole, long idService, NodeHU hu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NodeHU getHospitalUnit(long idHospital, long idPole, long idService, long idHU) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NodeHU> getAllHospitalUnits(long idHospital) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createCareUnit(long idHospital, long idPole, long idService, long idHU, NodeCU cu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NodeCU getCareUnit(long idHospital, long idPole, long idService, long idHU, long idCU) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NodeCU> getCareUnits(long idHospital) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Node getNode(long idHospital, long idNode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Node> getAllNodes(long idHospital) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Add a Doctor in the database
     * 
     * @param doctor Docotor to add
     * @return True if the doctor don't exists in the database, or false otherwise
     */
    @Override
    public boolean createDoctor(Doctor doctor) {
        
        Objects.requireNonNull(doctor);
        
        try {
            et.begin();
            em.persist(doctor);
            et.commit();
        } catch(EntityExistsException e) {
            return false;
        }
        return true;
    }

    /**
     * Get a Doctor with its id passed in argument
     * 
     * @param idDoctor The id of the Doctor
     * @return The Doctor
     */
    @Override
    public Doctor getDoctor(long idDoctor) {
        
        Doctor doctor;
        
        try {
            doctor = em.find(Doctor.class, idDoctor);
        } catch(EntityNotFoundException e) {
            return null;
        }
        return doctor;
    }

    /**
     * Get all Doctors
     * 
     * @return A list of Doctors
     */
    @Override
    public List<Doctor> getAllDoctors() {
        
        List<Doctor> doctors;
        
        try {
            TypedQuery<Doctor> tq = em.createQuery("SELECT doctor FROM Doctor doctor", Doctor.class);
            doctors = tq.getResultList();
        } catch(NoResultException e) {
            return null;
        }
        return doctors;
    }

    /**
     * Remove a Doctor from the database
     * 
     * @param idDoctor Doctor to remove
     * @return True if the doctor don't exists in the database, or false otherwise
     */
    @Override
    public boolean removeDoctor(long idDoctor) {
        
        try {
            et.begin();
            Doctor doctor = em.find(Doctor.class, idDoctor);
            em.remove(doctor);
            et.commit();
        } catch (EntityNotFoundException e) {
            return false;
        }
        return true;
    }

    /**
     * Add a Nurse in the database
     * 
     * @param nurse Nurse to add
     * @return True if the nurse don't exists in the database, or false otherwise
     */
    @Override
    public boolean createNurse(Nurse nurse) {
        
        Objects.requireNonNull(nurse);
        
        try {
            et.begin();
            em.persist(nurse);
            et.commit();
        } catch(EntityExistsException e) {
            return false;
        }
        return true;
    }

    /**
     * Get a Nurse with its id passed in argument
     * 
     * @param idNurse The id of the Nurse
     * @return The Nurse
     */
    @Override
    public Nurse getNurse(long idNurse) {
        
        Nurse nurse;
        
        try {
            nurse = em.find(Nurse.class, idNurse);
        } catch(EntityNotFoundException e) {
            return null;
        }
        return nurse;
    }

    /**
     * Get all Nurses
     * 
     * @return A list of Nurses
     */
    @Override
    public List<Nurse> getAllNurses() {
        
        List<Nurse> nurses;
        
        try {
            TypedQuery<Nurse> tq = em.createQuery("SELECT nurse FROM Nurse nurse", Nurse.class);
            nurses = tq.getResultList();
        } catch(NoResultException e) {
            return null;
        }
        return nurses;
    }

    /**
     * Remove a Nurse from the database
     * 
     * @param idNurse Nurse to remove
     * @return True if the nurse don't exists in the database, or false otherwise
     */
    @Override
    public boolean removeNurse(long idNurse) {
        
        try {
            et.begin();
            Nurse nurse = em.find(Nurse.class, idNurse);
            em.remove(nurse);
            et.commit();
        } catch (EntityNotFoundException e) {
            return false;
        }
        return true;
    }

    /**
     * Get the all Staff of the APHP
     * 
     * @return A List that contains the staff
     */
    @Override
    public List<IHospitalStaff> getStaff() {
       
        List<IHospitalStaff> staff = new ArrayList<>();
        
        List<Doctor> doctors = getAllDoctors();
        List<Nurse> nurses = getAllNurses();
        
        for(Doctor d : doctors) {
            staff.add(d);
        }
        
        for(Nurse n : nurses) {
            staff.add(n);
        }
        
        return staff;
    }
    
}
