package fr.devsquad.minutemed.database;

import java.util.List;


public interface IDataManager {
    
    public boolean createAccount(String login, String password, IHospitalStaff user);
    
    public boolean removeAccount(String login);
    
    public boolean createHospital(NodeHospital hospital);
    
    public NodeHospital getHospital(long idHospital);
    
    public List<NodeHospital> getAllHospitals();
    
    public boolean createPole(long idHospital, NodePole pole);
    
    public NodePole getPole(long idHospital, long idPole);
    
    public List<NodePole> getAllPoles(long idHospital);
    
    public boolean createService(long idHospital, NodeService service);
    
    public NodeService getService(long idHospital, lond idService);
    
    public List<NodeService> getAllServices(long idHospital);
    
    public boolean createHospitalUnit(long idHospital, NodeHU hu);
    
    public NodeHU getHospitalUnit(long idHospital, long idHU);
    
    public List<NodeHU> getAllHospitalUnits(long idHospital);
    
    public boolean createCareUnit(long idHospital, NodeCU cu);
    
    public NodeCU getCareUnit(long idHospital, long idCU);
    
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
