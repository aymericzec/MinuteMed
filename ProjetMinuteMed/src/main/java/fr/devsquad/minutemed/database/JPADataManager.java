package fr.devsquad.minutemed.database;

import fr.devsquad.minutemed.arborescenceOld.domain.NodeOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodeAPHPOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodeCUOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodeHUOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodeHospitalOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodePoleOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodeServiceOld;
import fr.devsquad.minutemed.authentication.domain.UserAccount;
import fr.devsquad.minutemed.dmp.domain.MedicalRecord;
import fr.devsquad.minutemed.specialization.domain.Specialization;
import fr.devsquad.minutemed.staff.domain.Doctor;
import fr.devsquad.minutemed.staff.domain.IHospitalStaff;
import fr.devsquad.minutemed.staff.domain.MedicalStaff;
import fr.devsquad.minutemed.staff.domain.Nurse;
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
    public boolean createAPHP(NodeAPHPOld aphp) {
        
        Objects.requireNonNull(aphp);
        
        NodeOld node = new NodeOld(aphp.getType(), aphp.getId());
        
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
    public boolean createHospital(NodeHospitalOld hospital) {
        
        Objects.requireNonNull(hospital);
        
        NodeOld node = new NodeOld(hospital.getType(), hospital.getId());
        
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
    public NodeHospitalOld getHospital(long idHospital) {
        
        NodeHospitalOld hospital;
        
        try {
            hospital = em.find(NodeHospitalOld.class, idHospital);
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
    public List<NodeHospitalOld> getAllHospitals() {
        
        List<NodeHospitalOld> hospitals;
        
        try {
            TypedQuery<NodeHospitalOld> tq = em.createQuery("SELECT hospital FROM NodeHospital hospital", NodeHospitalOld.class);
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
    public boolean createPole(NodePoleOld pole) {
        
        Objects.requireNonNull(pole);
        
        NodeOld node = new NodeOld(pole.getType(), pole.getId());
        
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
    public NodePoleOld getPole(long idPole) {
        
        NodePoleOld pole;
        
        try {
            pole = em.find(NodePoleOld.class, idPole);
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
    public List<NodePoleOld> getAllPoles(long idHospital) {
       
        List<NodePoleOld> poles;
        
        try {
            TypedQuery<NodePoleOld> tq = em.createQuery("SELECT pole FROM NodePole pole WHERE pole.hospital = :idHospital", NodePoleOld.class);
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
    public boolean createService(NodeServiceOld service) {
        
        Objects.requireNonNull(service);
        
        NodeOld node = new NodeOld(service.getType(), service.getId());
        
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
    public NodeServiceOld getService(long idService) {
        
        NodeServiceOld service;
        
        try {
            service = em.find(NodeServiceOld.class, idService);
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
    public List<NodeServiceOld> getAllServices(long idPole) {
        
        List<NodeServiceOld> services;
        
        try {
            TypedQuery<NodeServiceOld> tq = em.createQuery("SELECT service FROM NodeService service WHERE service.pole = :idPole", NodeServiceOld.class);
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
    public boolean createHospitalUnit(NodeHUOld hu) {
        
        Objects.requireNonNull(hu);
        
        NodeOld node = new NodeOld(hu.getType(), hu.getId());
        
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
    public NodeHUOld getHospitalUnit(long idHU) {
        
        NodeHUOld hu;
        
        try {
            hu = em.find(NodeHUOld.class, idHU);
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
    public List<NodeHUOld> getAllHospitalUnits(long idService) {
        
        List<NodeHUOld> hu;
        
        try {
            TypedQuery<NodeHUOld> tq = em.createQuery("SELECT hu FROM NodeHU hu WHERE hu.service = :idService", NodeHUOld.class);
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
    public boolean createCareUnit(NodeCUOld cu) {
        
        Objects.requireNonNull(cu);
        
        NodeOld node = new NodeOld(cu.getType(), cu.getId());
        
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
    public NodeCUOld getCareUnit(long idCU) {
        
        NodeCUOld cu;
        
        try {
            cu = em.find(NodeCUOld.class, idCU);
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
    public List<NodeCUOld> getAllCareUnits(long idHU) {
        
        List<NodeCUOld> cu;
        
        try {
            TypedQuery<NodeCUOld> tq = em.createQuery("SELECT cu FROM NodeCU cu WHERE cu.hu = :idHU", NodeCUOld.class);
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
    public NodeOld getNode(String type, long idNodeInfo) {
        
        NodeOld node;
        
        try {
            TypedQuery<NodeOld> tq = em.createQuery("SELECT node FROM Node node WHERE node.type = :type AND node.idNodeInfo = :idNodeInfo", NodeOld.class);
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
  
    /**
     * Get the staff in the Entity MedicalStaff
     * 
     * @param type Type of the MedicalStaff
     * @param idMedicalStaff Id of the MedicalStaff
     * @return The MedicalStaff
     */
    public MedicalStaff getMedicalStaff(String type, long idMedicalStaff) {
        
        MedicalStaff staff;
        
        try {
            TypedQuery<MedicalStaff> tq = em.createQuery("SELECT staff FROM MedicalStaff staff WHERE staff.type = :type AND staff.idMedicalStaff = :idMedicalStaff", MedicalStaff.class);
            staff = tq.setParameter("type", type).setParameter("idMedicalStaff", idMedicalStaff).getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
        return staff;
    }
}
