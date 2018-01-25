package fr.devsquad.minutemed.staff;

import fr.devsquad.minutemed.authentication.UserAccount;
import fr.devsquad.minutemed.database.IDataManager;
import fr.devsquad.minutemed.database.JPADataManager;
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
    public boolean createPole(long idHospital, NodePole pole) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.createPole(idHospital, pole);
    }

    @Override
    public NodePole getPole(long idHospital, long idPole) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getPole(idHospital, idPole);
    }

    @Override
    public List<NodePole> getAllPoles(long idHospital) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getAllPoles(idHospital);
    }

    @Override
    public boolean createService(long idHospital, long idPole, NodeService service) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.createService(idHospital, idPole, service);
    }

    @Override
    public NodeService getService(long idHospital, long idPole, long idService) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getService(idHospital, idPole, idService);
    }

    @Override
    public List<NodeService> getAllServices(long idHospital) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getAllServices(idHospital);
    }

    @Override
    public boolean createHospitalUnit(long idHospital, long idPole, long idService, NodeHU hu) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.createHospitalUnit(idHospital, idPole, idService, hu);
    }

    @Override
    public NodeHU getHospitalUnit(long idHospital, long idPole, long idService, long idHU) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getHospitalUnit(idHospital, idPole, idService, idHU);
    }

    @Override
    public List<NodeHU> getAllHospitalUnits(long idHospital) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getAllHospitalUnits(idHospital);
    }

    @Override
    public boolean createCareUnit(long idHospital, long idPole, long idService, long idHU, NodeCU cu) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.createCareUnit(idHospital, idPole, idService, idHU, cu);
    }

    @Override
    public NodeCU getCareUnit(long idHospital, long idPole, long idService, long idHU, long idCU) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getCareUnit(idHospital, idPole, idService, idHU, idCU);
    }

    @Override
    public List<NodeCU> getCareUnits(long idHospital) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getCareUnits(idHospital);
    }

    @Override
    public Node getNode(long idHospital, long idNode) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getNode(idHospital, idNode);
    }

    @Override
    public List<Node> getAllNodes(long idHospital) {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getAllNodes(idHospital);
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
