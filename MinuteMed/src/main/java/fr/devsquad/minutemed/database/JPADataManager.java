package fr.devsquad.minutemed.database;

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

    @Override
    public boolean createAccount(String login, String password, IHospitalStaff user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAccount(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            TypedQuery tq = em.createQuery("SELECT hospital FROM NodeHospital hospital", NodeHospital.class);
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
    public boolean createService(long idHospital, NodeService service) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NodeService getService(long idHospital, lond idService) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NodeService> getAllServices(long idHospital) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createHospitalUnit(long idHospital, NodeHU hu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NodeHU getHospitalUnit(long idHospital, long idHU) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NodeHU> getAllHospitalUnits(long idHospital) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createCareUnit(long idHospital, NodeCU cu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NodeCU getCareUnit(long idHospital, long idCU) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NodeCU> getCareUnits(long idHospital) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public INode getNode(long idHospital, long idNode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<INode> getAllNodes(long idHospital) {
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
            TypedQuery tq = em.createQuery("SELECT doctor FROM Doctor doctor", Doctor.class);
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
            TypedQuery tq = em.createQuery("SELECT nurse FROM Nurse nurse", Nurse.class);
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

    @Override
    public List<IHospitalStaff> getStaff() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
