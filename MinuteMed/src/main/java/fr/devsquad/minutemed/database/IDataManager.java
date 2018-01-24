package fr.devsquad.minutemed.database;

import fr.devsquad.minutemed.authentication.UserAccount;
import fr.devsquad.minutemed.staff.Doctor;
import fr.devsquad.minutemed.staff.IHospitalStaff;
import fr.devsquad.minutemed.staff.Nurse;
import java.util.List;


public interface IDataManager {
    
    public boolean createAccount(UserAccount account);
    
    public boolean removeAccount(long idAccount);
    
    public boolean createHospital(NodeHospital hospital);
    
    public NodeHospital getHospital(long idHospital);
    
    public List<NodeHospital> getAllHospitals();
    
    public boolean createPole(long idHospital, NodePole pole);
    
    public NodePole getPole(long idHospital, long idPole);
    
    public List<NodePole> getAllPoles(long idHospital);
    
    public boolean createService(long idHospital, long idPole, NodeService service);
    
    public NodeService getService(long idHospital, long idPole, long idService);
    
    public List<NodeService> getAllServices(long idHospital);
    
    public boolean createHospitalUnit(long idHospital, long idPole, long idService, NodeHU hu);
    
    public NodeHU getHospitalUnit(long idHospital, long idPole, long idService, long idHU);
    
    public List<NodeHU> getAllHospitalUnits(long idHospital);
    
    public boolean createCareUnit(long idHospital, long idPole, long idService, long idHU, NodeCU cu);
    
    public NodeCU getCareUnit(long idHospital, long idPole, long idService, long idHU, long idCU);
    
    public List<NodeCU> getCareUnits(long idHospital);
    
    public INode getNode(long idHospital, long idNode);
    
    public List<INode> getAllNodes(long idHospital);
    
    public boolean createDoctor(Doctor doctor);
    
    public Doctor getDoctor(long idDoctor);
    
    public List<Doctor> getAllDoctors();
    
    public boolean removeDoctor(long idDoctor);
    
    public boolean createNurse(Nurse nurse);
    
    public Nurse getNurse(long idNurse);
    
    public List<Nurse> getAllNurses();
    
    public boolean removeNurse(long idNurse);
    
    public List<IHospitalStaff> getStaff();
}
