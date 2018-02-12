package fr.devsquad.minutemed.database;

import fr.devsquad.minutemed.arborescenceOld.domain.INode;
import fr.devsquad.minutemed.arborescenceOld.domain.NodeOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodeAPHPOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodeCUOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodeHUOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodeHospitalOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodePoleOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodeServiceOld;
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
    
    public boolean createAPHP(NodeAPHPOld aphp);
    
    public boolean createHospital(NodeHospitalOld hospital);
    
    public NodeHospitalOld getHospital(long idHospital);
    
    public List<NodeHospitalOld> getAllHospitals();
    
    public boolean createPole(NodePoleOld pole);
    
    public NodePoleOld getPole(long idPole);
    
    public List<NodePoleOld> getAllPoles(long idHospital);
    
    public boolean createService(NodeServiceOld service);
    
    public NodeServiceOld getService(long idService);
    
    public List<NodeServiceOld> getAllServices(long idPole);
    
    public boolean createHospitalUnit(NodeHUOld hu);
    
    public NodeHUOld getHospitalUnit(long idHU);
    
    public List<NodeHUOld> getAllHospitalUnits(long idService);
    
    public boolean createCareUnit(NodeCUOld cu);
    
    public NodeCUOld getCareUnit(long idCU);
    
    public List<NodeCUOld> getAllCareUnits(long idHU);
    
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
