package fr.devsquad.minutemed.database;

import fr.devsquad.minutemed.arborescence.Node;
import fr.devsquad.minutemed.arborescence.NodeAPHP;
import fr.devsquad.minutemed.arborescence.NodeCU;
import fr.devsquad.minutemed.arborescence.NodeHU;
import fr.devsquad.minutemed.arborescence.NodeHospital;
import fr.devsquad.minutemed.arborescence.NodePole;
import fr.devsquad.minutemed.arborescence.NodeService;
import fr.devsquad.minutemed.authentication.UserAccount;
import fr.devsquad.minutemed.dmp.MedicalRecord;
import fr.devsquad.minutemed.specialization.Specialization;
import fr.devsquad.minutemed.staff.Doctor;
import fr.devsquad.minutemed.staff.IHospitalStaff;
import fr.devsquad.minutemed.staff.MedicalStaff;
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
     * Add a Specialization in the database
     * 
     * @param specialization The Specialization to add
     * @return True if the specialization don't exists in the database, or false otherwise
     */
    @Override
    public boolean createSpecialization(Specialization specialization) {
        
        Objects.requireNonNull(specialization);
        
        try {
            et.begin();
            em.persist(specialization);
            et.commit();
        } catch(EntityExistsException e) {
            return false;
        }
        return true;
    }
    
    /**
     * Remove a Specialization from the database
     * 
     * @param idSpecialization Specialization to remove
     * @return True if the specialization don't exists in the database, or false otherwise
     */
    @Override
    public boolean removeSpecialization(long idSpecialization) {
        
        try {
            et.begin();
            Specialization specialization = em.find(Specialization.class, idSpecialization);
            em.remove(specialization);
            et.commit();
        } catch (EntityNotFoundException e) {
            return false;
        }
        return true;
    }
    
    /**
     * Add APHP in the database
     * 
     * @param aphp The APHP to add
     * @return True if the APHP don't exists in the database, or false otherwise
     */
    @Override
    public boolean createAPHP(NodeAPHP aphp) {
        
        Objects.requireNonNull(aphp);
        
        Node node = new Node(aphp.getType(), aphp.getId());
        
        try {
            et.begin();
            em.persist(aphp);
            em.persist(node);
            et.commit();
        } catch(EntityExistsException e) {
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
        
        Node node = new Node(hospital.getType(), hospital.getId());
        
        try {
            et.begin();
            em.persist(hospital);
            em.persist(node);
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

    /**
     * Add a Pole in the database
     * 
     * @param pole The Pole to add
     * @return True if the pole don't exists in the database, or false otherwise
     */
    @Override
    public boolean createPole(NodePole pole) {
        
        Objects.requireNonNull(pole);
        
        Node node = new Node(pole.getType(), pole.getId());
        
        try {
            et.begin();
            em.persist(pole);
            em.persist(node);
            et.commit();
        } catch(EntityExistsException e) {
            return false;
        }
        return true;
    }

    /**
     * Get a Pole with its id passed in argument
     * 
     * @param idPole The id of the Pole
     * @return The Pole
     */
    @Override
    public NodePole getPole(long idPole) {
        
        NodePole pole;
        
        try {
            pole = em.find(NodePole.class, idPole);
        } catch(EntityNotFoundException e) {
            return null;
        }
        return pole;
    }

    /**
     * Get all Poles attached to an Hospital
     * 
     * @param idHospital The id of the Hospital
     * @return A list of Poles
     */
    @Override
    public List<NodePole> getAllPoles(long idHospital) {
       
        List<NodePole> poles;
        
        try {
            TypedQuery<NodePole> tq = em.createQuery("SELECT pole FROM NodePole pole WHERE pole.hospital = :idHospital", NodePole.class);
            poles = tq.setParameter("idHospital", idHospital).getResultList();
        } catch(NoResultException e) {
            return null;
        }
        return poles;
    }

    /**
     * Add a Service in the database
     * 
     * @param service The Service to add
     * @return True if the service don't exists in the database, or false otherwise
     */
    @Override
    public boolean createService(NodeService service) {
        
        Objects.requireNonNull(service);
        
        Node node = new Node(service.getType(), service.getId());
        
        try {
            et.begin();
            em.persist(service);
            em.persist(node);
            et.commit();
        } catch(EntityExistsException e) {
            return false;
        }
        return true;
    }

    /**
     * Get a Service with its id passed in argument
     * 
     * @param idService The id of the Service
     * @return The Service
     */
    @Override
    public NodeService getService(long idService) {
        
        NodeService service;
        
        try {
            service = em.find(NodeService.class, idService);
        } catch(EntityNotFoundException e) {
            return null;
        }
        return service;
    }

    /**
     * Get all Services attached to a Pole
     * 
     * @param idPole The id of the Pole
     * @return A list of Services
     */
    @Override
    public List<NodeService> getAllServices(long idPole) {
        
        List<NodeService> services;
        
        try {
            TypedQuery<NodeService> tq = em.createQuery("SELECT service FROM NodeService service WHERE service.pole = :idPole", NodeService.class);
            services = tq.setParameter("idPole", idPole).getResultList();
        } catch(NoResultException e) {
            return null;
        }
        return services;
    }

    /**
     * Add a Hospital Unit in the database
     * 
     * @param hu The Hospital Unit to add
     * @return True if the hospital unit don't exists in the database, or false otherwise
     */
    @Override
    public boolean createHospitalUnit(NodeHU hu) {
        
        Objects.requireNonNull(hu);
        
        Node node = new Node(hu.getType(), hu.getId());
        
        try {
            et.begin();
            em.persist(hu);
            em.persist(node);
            et.commit();
        } catch(EntityExistsException e) {
            return false;
        }
        return true;
    }

    /**
     * Get a Hospital Unit with its id passed in argument
     * 
     * @param idHU The id of the Hospital Unit
     * @return The Hospital Unit
     */
    @Override
    public NodeHU getHospitalUnit(long idHU) {
        
        NodeHU hu;
        
        try {
            hu = em.find(NodeHU.class, idHU);
        } catch(EntityNotFoundException e) {
            return null;
        }
        return hu;
    }

    /**
     * Get all Hospital Units attached to a Service
     * 
     * @param idService The id of the Service
     * @return A list of Hospital Unit
     */
    @Override
    public List<NodeHU> getAllHospitalUnits(long idService) {
        
        List<NodeHU> hu;
        
        try {
            TypedQuery<NodeHU> tq = em.createQuery("SELECT hu FROM NodeHU hu WHERE hu.service = :idService", NodeHU.class);
            hu = tq.setParameter("idService", idService).getResultList();
        } catch(NoResultException e) {
            return null;
        }
        return hu;
    }

    /**
     * Add a Care Unit in the database
     * 
     * @param cu The Care Unit to add
     * @return True if the care unit don't exists in the database, or false otherwise
     */
    @Override
    public boolean createCareUnit(NodeCU cu) {
        
        Objects.requireNonNull(cu);
        
        Node node = new Node(cu.getType(), cu.getId());
        
        try {
            et.begin();
            em.persist(cu);
            em.persist(node);
            et.commit();
        } catch(EntityExistsException e) {
            return false;
        }
        return true;
    }

    /**
     * Get a Care Unit with its id passed in argument
     * 
     * @param idCU The id of the Care Unit
     * @return The Care Unit
     */
    @Override
    public NodeCU getCareUnit(long idCU) {
        
        NodeCU cu;
        
        try {
            cu = em.find(NodeCU.class, idCU);
        } catch(EntityNotFoundException e) {
            return null;
        }
        return cu;
    }

    /**
     * Get all Care Units attached to a Hospital Unit
     * 
     * @param idHU The id of the Hospital Unit
     * @return A list of Care Unit
     */
    @Override
    public List<NodeCU> getAllCareUnits(long idHU) {
        
        List<NodeCU> cu;
        
        try {
            TypedQuery<NodeCU> tq = em.createQuery("SELECT cu FROM NodeCU cu WHERE cu.hu = :idHU", NodeCU.class);
            cu = tq.setParameter("idHU", idHU).getResultList();
        } catch(NoResultException e) {
            return null;
        }
        return cu;
    }
    
    /**
     * Get the node in the Entity Node
     * 
     * @param type Type of the Node
     * @param idNodeInfo Id of the Node
     * @return The Node
     */
    public Node getNode(String type, long idNodeInfo) {
        
        Node node;
        
        try {
            TypedQuery<Node> tq = em.createQuery("SELECT node FROM Node node WHERE node.type = :type AND node.idNodeInfo = :idNodeInfo", Node.class);
            node = tq.setParameter("type", type).setParameter("idNodeInfo", idNodeInfo).getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
        return node;
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
        
        MedicalStaff staff = new MedicalStaff(doctor.getType(), doctor.getId());
        
        try {
            et.begin();
            em.persist(doctor);
            em.persist(staff);
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
        
        MedicalStaff staff = new MedicalStaff(nurse.getType(), nurse.getId());
        
        try {
            et.begin();
            em.persist(nurse);
            em.persist(staff);
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
