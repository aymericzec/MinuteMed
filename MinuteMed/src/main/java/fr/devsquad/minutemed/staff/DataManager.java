package fr.devsquad.minutemed.staff;

import fr.devsquad.minutemed.arborescence.NodeCU;
import fr.devsquad.minutemed.arborescence.NodeHU;
import fr.devsquad.minutemed.arborescence.NodeHospital;
import fr.devsquad.minutemed.arborescence.NodePole;
import fr.devsquad.minutemed.arborescence.NodeService;
import fr.devsquad.minutemed.authentication.UserAccount;
import fr.devsquad.minutemed.database.IDataManager;
import fr.devsquad.minutemed.database.JPADataManager;
import fr.devsquad.minutemed.specialization.Specialization;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DataManager implements Serializable, IHospitalStaff, IDataManager {

    @Id @GeneratedValue
    private long idStaff; 
    private String firstName;
    private String lastName;
    private String adress;
    private String email;
    private String phoneNumber;
        
    public DataManager() { }
        
    public DataManager(String firstName, String lastName, String adress, String email, String phoneNumber) { 
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

   @Override
    public long getIdStaff() {
        return idStaff;
    }
    
    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getAdress() {
        return adress;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPhoneNumber() {
       return phoneNumber;
    }
    
    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Add an Account in the database
     * 
     * @param account The Account to add
     * @return True if the account don't exists in the database, or false otherwise
     */
    @Override
    public boolean createAccount(UserAccount account) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.createAccount(account);
    }

    /**
     * Remove an Account from the database
     * 
     * @param idAccount Account to remove
     * @return True if the account don't exists in the database, or false otherwise
     */
    @Override
    public boolean removeAccount(long idAccount) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.removeAccount(idAccount);
    }
    
    @Override
    public boolean createSpecialization(Specialization specialization) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.createSpecialization(specialization);
    }
    
    @Override
    public boolean removeSpecialization(long idSpecialization) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.removeSpecialization(idSpecialization);
    }

    /**
     * Add a Hospital in the database
     * 
     * @param hospital The Hospital to add
     * @return True if the hospital don't exists in the database, or false otherwise
     */
    @Override
    public boolean createHospital(NodeHospital hospital) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.createHospital(hospital);
    }

    /**
     * Get an Hospital with its id passed in argument
     * 
     * @param idHospital The id of the Hospital
     * @return The Hospital
     */
    @Override
    public NodeHospital getHospital(long idHospital) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getHospital(idHospital);
    }

    /**
     * Get all Hospitals
     * 
     * @return A list of Hospitals
     */
    @Override
    public List<NodeHospital> getAllHospitals() {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getAllHospitals();
    }

    @Override
    public boolean createPole(NodePole pole) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.createPole(pole);
    }

    @Override
    public NodePole getPole(long idPole) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getPole(idPole);
    }

    @Override
    public List<NodePole> getAllPoles(long idHospital) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getAllPoles(idHospital);
    }

    @Override
    public boolean createService(NodeService service) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.createService(service);
    }

    @Override
    public NodeService getService(long idService) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getService(idService);
    }

    @Override
    public List<NodeService> getAllServices(long idPole) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getAllServices(idPole);
    }

    @Override
    public boolean createHospitalUnit(NodeHU hu) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.createHospitalUnit(hu);
    }

    @Override
    public NodeHU getHospitalUnit(long idHU) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getHospitalUnit(idHU);
    }

    @Override
    public List<NodeHU> getAllHospitalUnits(long idService) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getAllHospitalUnits(idService);
    }

    @Override
    public boolean createCareUnit(NodeCU cu) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.createCareUnit(cu);
    }

    @Override
    public NodeCU getCareUnit(long idCU) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getCareUnit(idCU);
    }

    @Override
    public List<NodeCU> getAllCareUnits(long idHU) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getAllCareUnits(idHU);
    }

    /**
     * Add a Doctor in the database
     * 
     * @param doctor Docotor to add
     * @return True if the doctor don't exists in the database, or false otherwise
     */
    @Override
    public boolean createDoctor(Doctor doctor) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.createDoctor(doctor);
    }

    /**
     * Get a Doctor with its id passed in argument
     * 
     * @param idDoctor The id of the Doctor
     * @return The Doctor
     */
    @Override
    public Doctor getDoctor(long idDoctor) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getDoctor(idDoctor);
    }

    /**
     * Get all Doctors
     * 
     * @return A list of Doctors
     */
    @Override
    public List<Doctor> getAllDoctors() {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getAllDoctors();
    }

    /**
     * Remove a Doctor from the database
     * 
     * @param idDoctor Doctor to remove
     * @return True if the doctor don't exists in the database, or false otherwise
     */
    @Override
    public boolean removeDoctor(long idDoctor) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.removeDoctor(idDoctor);
    }

    /**
     * Add a Nurse in the database
     * 
     * @param nurse Nurse to add
     * @return True if the nurse don't exists in the database, or false otherwise
     */
    @Override
    public boolean createNurse(Nurse nurse) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.createNurse(nurse);
    }

    /**
     * Get a Nurse with its id passed in argument
     * 
     * @param idNurse The id of the Nurse
     * @return The Nurse
     */
    @Override
    public Nurse getNurse(long idNurse) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getNurse(idNurse);
    }

    /**
     * Get all Nurses
     * 
     * @return A list of Nurses
     */
    @Override
    public List<Nurse> getAllNurses() {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getAllNurses();
    }

    /**
     * Remove a Nurse from the database
     * 
     * @param idNurse Nurse to remove
     * @return True if the nurse don't exists in the database, or false otherwise
     */
    @Override
    public boolean removeNurse(long idNurse) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.removeNurse(idNurse);
    }

    /**
     * Get the all Staff of the APHP
     * 
     * @return A List that contains the staff
     */
    @Override
    public List<IHospitalStaff> getStaff() {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getStaff();
    }  
}
