package fr.devsquad.minutemed.database;

import fr.devsquad.minutemed.arborescence.domain.INode;
import fr.devsquad.minutemed.arborescence.domain.Node;
import fr.devsquad.minutemed.arborescence.domain.NodeAPHP;
import fr.devsquad.minutemed.arborescence.domain.NodeCU;
import fr.devsquad.minutemed.arborescence.domain.NodeHU;
import fr.devsquad.minutemed.arborescence.domain.NodeHospital;
import fr.devsquad.minutemed.arborescence.domain.NodePole;
import fr.devsquad.minutemed.arborescence.domain.NodeService;
import fr.devsquad.minutemed.authentication.domain.UserAccount;
import fr.devsquad.minutemed.specialization.domain.Specialization;
import fr.devsquad.minutemed.staff.domain.Doctor;
import fr.devsquad.minutemed.staff.domain.IHospitalStaff;
import fr.devsquad.minutemed.staff.domain.MedicalStaff;
import fr.devsquad.minutemed.staff.domain.Nurse;
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
