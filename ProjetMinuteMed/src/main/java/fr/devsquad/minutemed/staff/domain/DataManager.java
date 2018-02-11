package fr.devsquad.minutemed.staff.domain;

import fr.devsquad.minutemed.arborescence.domain.NodeAPHP;
import fr.devsquad.minutemed.arborescence.domain.NodeCU;
import fr.devsquad.minutemed.arborescence.domain.NodeHU;
import fr.devsquad.minutemed.arborescence.domain.NodeHospital;
import fr.devsquad.minutemed.arborescence.domain.NodePole;
import fr.devsquad.minutemed.arborescence.domain.NodeService;
import fr.devsquad.minutemed.authentication.domain.UserAccount;
import fr.devsquad.minutemed.database.IDataManager;
import fr.devsquad.minutemed.database.JPADataManager;
import fr.devsquad.minutemed.specialization.domain.Specialization;
import static fr.devsquad.minutemed.staff.domain.DataManager.FIND_ALL_DATAMANAGER;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = FIND_ALL_DATAMANAGER, query = "SELECT staff FROM DataManager staff")
public class DataManager implements Serializable, IHospitalStaff, IDataManager {

    public static final String FIND_ALL_DATAMANAGER = "DataManager.findAllDataManager";
    
    @Id
    @GeneratedValue
    @Column(name = "idDataManager")
    private long id;
    private String type;
    private String firstName;
    private String lastName;
    private String adress;
    private String email;
    private String phoneNumber;

    public DataManager() {
    }

    public DataManager(StaffEnum type, String firstName, String lastName, String adress, String email, String phoneNumber) {
        if( type == null){
            throw new NullPointerException();
        }
        if( firstName == null){
            throw new NullPointerException();
        }
        if( lastName == null){
            throw new NullPointerException();
        }
        if( adress == null){
            throw new NullPointerException();
        }
        if( email == null){
            throw new NullPointerException();
        }
        if( phoneNumber == null){
            throw new NullPointerException();
        }
        
        if( stringNotConform(firstName) ){
            throw new IllegalArgumentException();
        }
        if( stringNotConform(lastName) ){
            throw new IllegalArgumentException();
        }
        if( stringNotConform(adress) ){
            throw new IllegalArgumentException();
        }
        if( stringNotConform(email) ){
            throw new IllegalArgumentException();
        }
        if( stringNotConform(phoneNumber) ){
            throw new IllegalArgumentException();
        }
        
        this.type = type.DATAMANAGER.name();
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    private static boolean stringNotConform(String s){
        return s.matches("[ ]*");
    }

    @Override
    public long getId() {
        return id;
    }
    
    @Override
    public String getType() {
        return type;
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
        if(firstName==null){
            throw new NullPointerException();
        }
        if(stringNotConform(firstName) ){
            throw new IllegalArgumentException();
        }
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        if(lastName==null){
            throw new NullPointerException();
        }
        if(stringNotConform(lastName) ){
            throw new IllegalArgumentException();
        }
        this.lastName = lastName;
    }

    @Override
    public void setAdress(String adress) {
        if(adress==null){
            throw new NullPointerException();
        }
        if(stringNotConform(adress) ){
            throw new IllegalArgumentException();
        }
        this.adress = adress;
    }

    @Override
    public void setEmail(String email) {
        if(email==null){
            throw new NullPointerException();
        }
        if(stringNotConform(email) ){
            throw new IllegalArgumentException();
        }
        this.email = email;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber==null){
            throw new NullPointerException();
        }
        if(stringNotConform(phoneNumber) ){
            throw new IllegalArgumentException();
        }
        this.phoneNumber = phoneNumber;
    }

    /**
     * Add an Account in the database
     *
     * @param account The Account to add
     * @return True if the account don't exists in the database, or false
     * otherwise
     */
    @Override
    public boolean createAccount(UserAccount account) {
        if(account==null){
            throw new NullPointerException();
        }
        JPADataManager dataManager = new JPADataManager();
        return dataManager.createAccount(account);
    }

    /**
     * Remove an Account from the database
     *
     * @param idAccount Account to remove
     * @return True if the account don't exists in the database, or false
     * otherwise
     */
    @Override
    public boolean removeAccount(long idAccount) {
        if(idAccount<0){
            throw new IllegalArgumentException();
        }
        JPADataManager dataManager = new JPADataManager();
        return dataManager.removeAccount(idAccount);
    }

    /**
     * Add a Specialization in the database
     *
     * @param specialization The Specialization to add
     * @return True if the specialization don't exists in the database, or false
     * otherwise
     */
    @Override
    public boolean createSpecialization(Specialization specialization) {
        if(specialization==null){
            throw new NullPointerException();
        }
        JPADataManager dataManager = new JPADataManager();
        return dataManager.createSpecialization(specialization);
    }

    /**
     * Remove a Specialization from the database
     *
     * @param idSpecialization Specialization to remove
     * @return True if the specialization don't exists in the database, or false
     * otherwise
     */
    @Override
    public boolean removeSpecialization(long idSpecialization) {
        if(idSpecialization<0){
            throw new IllegalArgumentException();
        }
        JPADataManager dataManager = new JPADataManager();
        return dataManager.removeSpecialization(idSpecialization);
    }

    /**
     * Add APHP in the database
     * 
     * @param aphp The APHP to add
     * @return True if the APHP don't exists in the database, or false otherwise
     */
    @Override
    public boolean createAPHP(NodeAPHP aphp) {
        if(aphp==null){
            throw new NullPointerException();
        }
        JPADataManager dataManager = new JPADataManager();
        return dataManager.createAPHP(aphp);
    }

    /**
     * Add a Hospital in the database
     *
     * @param hospital The Hospital to add
     * @return True if the hospital don't exists in the database, or false
     * otherwise
     */
    @Override
    public boolean createHospital(NodeHospital hospital) {
        if(hospital==null){
            throw new NullPointerException();
        }
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
        if(idHospital<0){
            throw new IllegalArgumentException();
        }
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

    /**
     * Add a Pole in the database
     *
     * @param pole The Pole to add
     * @return True if the pole don't exists in the database, or false otherwise
     */
    @Override
    public boolean createPole(NodePole pole) {
        if(pole==null){
            throw new NullPointerException();
        }
        JPADataManager dataManager = new JPADataManager();
        return dataManager.createPole(pole);
    }

    /**
     * Get a Pole with its id passed in argument
     *
     * @param idPole The id of the Pole
     * @return The Pole
     */
    @Override
    public NodePole getPole(long idPole) {
        if(idPole<0){
            throw new IllegalArgumentException();
        }
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getPole(idPole);
    }

    /**
     * Get all Poles attached to an Hospital
     *
     * @param idHospital The id of the Hospital
     * @return A list of Poles
     */
    @Override
    public List<NodePole> getAllPoles(long idHospital) {
        if(idHospital<0){
            throw new IllegalArgumentException();
        }
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getAllPoles(idHospital);
    }

    /**
     * Add a Service in the database
     *
     * @param service The Service to add
     * @return True if the service don't exists in the database, or false
     * otherwise
     */
    @Override
    public boolean createService(NodeService service) {
        if(service==null){
            throw new NullPointerException();
        }
        JPADataManager dataManager = new JPADataManager();
        return dataManager.createService(service);
    }

    /**
     * Get a Service with its id passed in argument
     *
     * @param idService The id of the Service
     * @return The Service
     */
    @Override
    public NodeService getService(long idService) {
        if(idService<0){
            throw new IllegalArgumentException();
        }
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getService(idService);
    }

    /**
     * Get all Services attached to a Pole
     *
     * @param idPole The id of the Pole
     * @return A list of Services
     */
    @Override
    public List<NodeService> getAllServices(long idPole) {
        if(idPole<0){
            throw new IllegalArgumentException();
        }
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getAllServices(idPole);
    }

    /**
     * Add a Hospital Unit in the database
     *
     * @param hu The Hospital Unit to add
     * @return True if the hospital unit don't exists in the database, or false
     * otherwise
     */
    @Override
    public boolean createHospitalUnit(NodeHU hu) {
        if(hu==null){
            throw new NullPointerException();
        }
        JPADataManager dataManager = new JPADataManager();
        return dataManager.createHospitalUnit(hu);
    }

    /**
     * Get a Hospital Unit with its id passed in argument
     *
     * @param idHU The id of the Hospital Unit
     * @return The Hospital Unit
     */
    @Override
    public NodeHU getHospitalUnit(long idHU) {
        if(idHU<0){
            throw new IllegalArgumentException();
        }
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getHospitalUnit(idHU);
    }

    /**
     * Get all Hospital Units attached to a Service
     *
     * @param idService The id of the Service
     * @return A list of Hospital Unit
     */
    @Override
    public List<NodeHU> getAllHospitalUnits(long idService) {
        if(idService<0){
            throw new IllegalArgumentException();
        }
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getAllHospitalUnits(idService);
    }

    /**
     * Add a Care Unit in the database
     *
     * @param cu The Care Unit to add
     * @return True if the care unit don't exists in the database, or false
     * otherwise
     */
    @Override
    public boolean createCareUnit(NodeCU cu) {
        if(cu==null){
            throw new NullPointerException();
        }
        JPADataManager dataManager = new JPADataManager();
        return dataManager.createCareUnit(cu);
    }

    /**
     * Get a Care Unit with its id passed in argument
     *
     * @param idCU The id of the Care Unit
     * @return The Care Unit
     */
    @Override
    public NodeCU getCareUnit(long idCU) {
        if(idCU<0){
            throw new IllegalArgumentException();
        }
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getCareUnit(idCU);
    }

    /**
     * Get all Care Units attached to a Hospital Unit
     *
     * @param idHU The id of the Hospital Unit
     * @return A list of Care Unit
     */
    @Override
    public List<NodeCU> getAllCareUnits(long idHU) {
        if(idHU<0){
            throw new IllegalArgumentException();
        }
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getAllCareUnits(idHU);
    }

    /**
     * Add a Doctor in the database
     *
     * @param doctor Docotor to add
     * @return True if the doctor don't exists in the database, or false
     * otherwise
     */
    @Override
    public boolean createDoctor(Doctor doctor) {
        if(doctor==null){
            throw new NullPointerException();
        }
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
        if(idDoctor<0){
            throw new IllegalArgumentException();
        }
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
     * @return True if the doctor don't exists in the database, or false
     * otherwise
     */
    @Override
    public boolean removeDoctor(long idDoctor) {
        if(idDoctor<0){
            throw new IllegalArgumentException();
        }
        JPADataManager dataManager = new JPADataManager();
        return dataManager.removeDoctor(idDoctor);
    }

    /**
     * Add a Nurse in the database
     *
     * @param nurse Nurse to add
     * @return True if the nurse don't exists in the database, or false
     * otherwise
     */
    @Override
    public boolean createNurse(Nurse nurse) {
        if(nurse==null){
            throw new NullPointerException();
        }
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
        if(idNurse<0){
            throw new IllegalArgumentException();
        }
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
     * @return True if the nurse don't exists in the database, or false
     * otherwise
     */
    @Override
    public boolean removeNurse(long idNurse) {
        if(idNurse<0){
            throw new IllegalArgumentException();
        }
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
    
    @Override
    public String toString() {
        StringBuilder stb =  new StringBuilder();
        stb.append("DataManager :").append(this.lastName).append(this.firstName);
        return stb.toString();
    }
}
