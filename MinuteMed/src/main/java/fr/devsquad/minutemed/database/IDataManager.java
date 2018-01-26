package fr.devsquad.minutemed.database;

import fr.devsquad.minutemed.arborescence.INode;
import fr.devsquad.minutemed.arborescence.NodeAPHP;
import fr.devsquad.minutemed.arborescence.NodeCU;
import fr.devsquad.minutemed.arborescence.NodeHU;
import fr.devsquad.minutemed.arborescence.NodeHospital;
import fr.devsquad.minutemed.arborescence.NodePole;
import fr.devsquad.minutemed.arborescence.NodeService;
import fr.devsquad.minutemed.authentication.UserAccount;
import fr.devsquad.minutemed.specialization.Specialization;
import fr.devsquad.minutemed.staff.Doctor;
import fr.devsquad.minutemed.staff.IHospitalStaff;
import fr.devsquad.minutemed.staff.Nurse;
import java.util.List;


public interface IDataManager {
    
    public boolean createAccount(UserAccount account);
    
    public boolean removeAccount(long idAccount);
    
    public boolean createSpecialization(Specialization specialization);
    
    public boolean removeSpecialization(long idSpecialization);
    
    public boolean createAPHP(NodeAPHP aphp);
    
    public boolean createHospital(NodeHospital hospital);
    
    public NodeHospital getHospital(long idHospital);
    
    public List<NodeHospital> getAllHospitals();
    
    public boolean createPole(NodePole pole);
    
    public NodePole getPole(long idPole);
    
    public List<NodePole> getAllPoles(long idHospital);
    
    public boolean createService(NodeService service);
    
    public NodeService getService(long idService);
    
    public List<NodeService> getAllServices(long idPole);
    
    public boolean createHospitalUnit(NodeHU hu);
    
    public NodeHU getHospitalUnit(long idHU);
    
    public List<NodeHU> getAllHospitalUnits(long idService);
    
    public boolean createCareUnit(NodeCU cu);
    
    public NodeCU getCareUnit(long idCU);
    
    public List<NodeCU> getAllCareUnits(long idHU);
    
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
