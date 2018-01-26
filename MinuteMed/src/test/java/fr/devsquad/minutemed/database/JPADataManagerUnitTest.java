package fr.devsquad.minutemed.database;


import fr.devsquad.minutemed.arborescence.INode;
import fr.devsquad.minutemed.arborescence.NodeAPHP;
import fr.devsquad.minutemed.arborescence.NodeCU;
import fr.devsquad.minutemed.arborescence.NodeEnum;
import fr.devsquad.minutemed.arborescence.NodeHU;
import fr.devsquad.minutemed.arborescence.NodeHospital;
import fr.devsquad.minutemed.arborescence.NodePole;
import fr.devsquad.minutemed.arborescence.NodeService;
import fr.devsquad.minutemed.authentication.UserAccount;
import fr.devsquad.minutemed.specialization.Specialization;
import fr.devsquad.minutemed.specialization.SpecializationEnum;
import fr.devsquad.minutemed.staff.Doctor;
import fr.devsquad.minutemed.staff.IHospitalStaff;
import fr.devsquad.minutemed.staff.Nurse;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class JPADataManagerUnitTest {
    
     /**
      * Return an exception if a field is null
      */
     @Test
     public void testCreateAccountNull() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());    
                  
         Mockito.doThrow(new NullPointerException()).when(dataManager).createAccount(null);
     }
     
     /**
      * Test if a account is already present in the database or not, to create them 
      */
     @Test
     public void testCreateAccount() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager()); 
         
         Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
         
         NodePole nodePole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie));
         List<NodePole> poles = new ArrayList<>();
         poles.add(nodePole);
         
         NodeHospital nodeHospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
         List<NodeHospital> hospitals = new ArrayList<>();
         hospitals.add(nodeHospital);
         
         NodeAPHP nodeAPHP = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
         
         nodeHospital.setAPHP(nodeAPHP);
         nodePole.setHospital(nodeHospital);
         
         INode pole = nodePole;
         
         IHospitalStaff doctor = Mockito.spy(new Doctor("Dupont", "Patrick", "5 Avenue de la Republique", "patoche@gmail.com", "0718547896", pole, pediatrie));
         IHospitalStaff nurse = Mockito.spy(new Nurse("Durand", "Emilie", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", pole));
         
         UserAccount doctorAccount = Mockito.spy(new UserAccount("pseudoDoctor", "passwordDoctor", doctor));
         UserAccount nurseAccount = Mockito.spy(new UserAccount("pseudoNurse", "passwordNurse", nurse));
         
         assertTrue(dataManager.createAPHP(nodeAPHP));
         assertTrue(dataManager.createPole(nodePole));
         assertTrue(dataManager.createDoctor((Doctor)doctor));
         assertTrue(dataManager.createNurse((Nurse)nurse));
         assertTrue(dataManager.createAccount(doctorAccount));
         assertTrue(dataManager.createAccount(nurseAccount));
         assertFalse(dataManager.createAccount(doctorAccount));
     }
       
     /**
      * Test if an account is present in the database to remove them 
      */
     @Test
     public void testRemoveAccount() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());    
         
         Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
         
         NodePole nodePole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie));
         List<NodePole> poles = new ArrayList<>();
         poles.add(nodePole);
         
         NodeHospital nodeHospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
         List<NodeHospital> hospitals = new ArrayList<>();
         hospitals.add(nodeHospital);
         
         NodeAPHP nodeAPHP = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
         
         nodeHospital.setAPHP(nodeAPHP);
         nodePole.setHospital(nodeHospital);
         
         INode pole = nodePole;
         
         IHospitalStaff doctor = Mockito.spy(new Doctor("Dupont", "Patrick", "5 Avenue de la Republique", "patoche@gmail.com", "0718547896", pole, pediatrie));
         
         UserAccount doctorAccount = Mockito.spy(new UserAccount("pseudoDoctor", "passwordDoctor", doctor));
         
         assertTrue(dataManager.createAPHP(nodeAPHP));
         assertTrue(dataManager.createPole(nodePole));
         assertTrue(dataManager.createDoctor((Doctor)doctor));
         assertTrue(dataManager.createAccount(doctorAccount));
         assertTrue(dataManager.removeAccount(doctorAccount.getIdAccount()));
         assertFalse(dataManager.removeAccount(doctorAccount.getIdAccount()));
     }
     
      /**
      * Return an exception if a field is null
      */
     @Test
     public void testCreateHospitalNull() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());    
       
         Mockito.doThrow(new NullPointerException()).when(dataManager).createHospital(null);
     }
     
      /**
      * Test the creation of an Hospital
      */
     @Test
     public void testCreateHospital() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager()); 
         
         NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris"));
         List<NodeHospital> hospitals = new ArrayList<>();
         hospitals.add(hospital);
         
         NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
         hospital.setAPHP(aphp);
       
         assertTrue(dataManager.createAPHP(aphp));
         assertTrue(dataManager.createHospital(hospital));
         assertFalse(dataManager.createHospital(hospital));
     }
     
     /**
      * Test if an Hospital exists, it don't returns null
      */
     @Test
     public void testGetHospital() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         
         NodeHospital hospitalCreate = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris"));
         List<NodeHospital> hospitals = new ArrayList<>();
         hospitals.add(hospitalCreate);
         
         NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
         hospitalCreate.setAPHP(aphp);
         
         assertTrue(dataManager.createAPHP(aphp));
         assertTrue(dataManager.createHospital(hospitalCreate));
         
         NodeHospital hospitalResult = dataManager.getHospital(hospitalCreate.getId());
         
         assertNotNull(hospitalResult);
         assertEquals(hospitalCreate.getId(), hospitalResult.getId());
         assertEquals(hospitalCreate.getName(), hospitalResult.getName());
         assertEquals(hospitalCreate.getType(), hospitalResult.getType());
         assertEquals(hospitalCreate.getAPHP(), hospitalResult.getAPHP());
     }
     
     /**
      * Test if Hospitals exists, it don't returns null
      */
     @Test
     public void testGetAllHospitals() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         
         NodeHospital hospital1 = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris"));
         NodeHospital hospital2 = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "CHU de Reims"));
         List<NodeHospital> hospitals = new ArrayList<>();
         hospitals.add(hospital1);
         hospitals.add(hospital2);
         
         NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
         hospital1.setAPHP(aphp);
         hospital2.setAPHP(aphp);
         
         assertTrue(dataManager.createAPHP(aphp));
         assertTrue(dataManager.createHospital(hospital1));
         assertTrue(dataManager.createHospital(hospital2));
         assertNotNull(dataManager.getAllHospitals());
     }
     
     /**
      * Return an exception if a field is null
      */
     @Test
     public void testCreatePoleNull() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
                
         Mockito.doThrow(new NullPointerException()).when(dataManager).createPole(null);
     }
     
     /**
      * Test the creation of a Pole
      */
     @Test
     public void testCreatePole() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager()); 
         
         Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
         
         NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie));
         List<NodePole> poles = new ArrayList<>();
         poles.add(pole);
         
         NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
         List<NodeHospital> hospitals = new ArrayList<>();
         hospitals.add(hospital);
         
         NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
         pole.setHospital(hospital);
         hospital.setAPHP(aphp);
       
         assertTrue(dataManager.createAPHP(aphp));
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createPole(pole));
     }
     
     /**
      * Test if a Pole exists, it don't returns null
      */
     @Test
     public void testGetPole() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         
         Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
         
         NodePole poleCreate = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie));
         List<NodePole> poles = new ArrayList<>();
         poles.add(poleCreate);
         
         NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
         List<NodeHospital> hospitals = new ArrayList<>();
         hospitals.add(hospital);
         
         NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
         poleCreate.setHospital(hospital);
         hospital.setAPHP(aphp);
         
         assertTrue(dataManager.createAPHP(aphp));
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createPole(poleCreate));
         
         NodePole poleResult = dataManager.getPole(poleCreate.getId());
         
         assertNotNull(poleResult);
         assertEquals(poleCreate.getId(), poleResult.getId());
         assertEquals(poleCreate.getType(), poleResult.getType());
         assertEquals(poleCreate.getSpecialization(), poleResult.getSpecialization());
         assertEquals(poleCreate.getHospital(), poleResult.getHospital());
     }
     
     /**
      * Test if Poles exists, it don't returns null
      */
     @Test
     public void testGetAllPoles() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
        
         Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
         Specialization cardiologie = new Specialization(SpecializationEnum.Cardiologie);
         
         NodePole pole1 = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie));
         NodePole pole2 = Mockito.spy(new NodePole(NodeEnum.POLE, cardiologie));
         List<NodePole> poles = new ArrayList<>();
         poles.add(pole1);
         poles.add(pole2);
         
         NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
         List<NodeHospital> hospitals = new ArrayList<>();
         hospitals.add(hospital);
         
         NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
         pole1.setHospital(hospital);
         pole2.setHospital(hospital);
         hospital.setAPHP(aphp);
         
         assertTrue(dataManager.createAPHP(aphp));
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createPole(pole1));
         assertTrue(dataManager.createPole(pole2));
         assertNotNull(dataManager.getAllPoles(hospital.getId()));
     }
     
     /**
      * Return an exception if a field is null
      */
     @Test
     public void testCreateServiceNull() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
 
         Mockito.doThrow(new NullPointerException()).when(dataManager).createService(null);
     }
     
     /**
      * Test the creation of a Service
      */
     @Test
     public void testCreateService() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager()); 
         
         Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
         Specialization andrologie = new Specialization(SpecializationEnum.Andrologie);
         
         NodeService service = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie));
         List<NodeService> services = new ArrayList<>();
         services.add(service);
         
         NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
         List<NodePole> poles = new ArrayList<>();
         poles.add(pole);
         
         NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
         List<NodeHospital> hospitals = new ArrayList<>();
         hospitals.add(hospital);
         
         NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
         service.setPole(pole);
         pole.setHospital(hospital);
         hospital.setAPHP(aphp);
       
         assertTrue(dataManager.createAPHP(aphp));
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createPole(pole));
         assertTrue(dataManager.createService(service));
         assertFalse(dataManager.createService(service));
     }
     
     /**
      * Test if a Service exists, it don't returns null
      */
     @Test
     public void testGetService() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         
         Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
         Specialization andrologie = new Specialization(SpecializationEnum.Andrologie);
         
         NodeService serviceCreate = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie));
         List<NodeService> services = new ArrayList<>();
         services.add(serviceCreate);
         
         NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
         List<NodePole> poles = new ArrayList<>();
         poles.add(pole);
         
         NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
         List<NodeHospital> hospitals = new ArrayList<>();
         hospitals.add(hospital);
         
         NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
         serviceCreate.setPole(pole);
         pole.setHospital(hospital);
         hospital.setAPHP(aphp);
         
         assertTrue(dataManager.createAPHP(aphp));
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createPole(pole));
         assertTrue(dataManager.createService(serviceCreate));
         
         NodeService serviceResult = dataManager.getService(serviceCreate.getId());
         
         assertNotNull(serviceResult);
         assertEquals(serviceCreate.getId(), serviceResult.getId());
         assertEquals(serviceCreate.getType(), serviceResult.getType());
         assertEquals(serviceCreate.getSpecialization(), serviceResult.getSpecialization());
         assertEquals(serviceCreate.getPole(), serviceResult.getPole());
     }
     
     /**
      * Test if Services exists, it don't returns null
      */
     @Test
     public void testGetAllServices() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         
         Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
         Specialization andrologie = new Specialization(SpecializationEnum.Andrologie);
         Specialization cardiologie = new Specialization(SpecializationEnum.Cardiologie);
         
         NodeService service1 = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie));
         NodeService service2 = Mockito.spy(new NodeService(NodeEnum.SERVICE, cardiologie));
         List<NodeService> services = new ArrayList<>();
         services.add(service1);
         services.add(service2);
         
         NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
         List<NodePole> poles = new ArrayList<>();
         poles.add(pole);
         
         NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
         List<NodeHospital> hospitals = new ArrayList<>();
         hospitals.add(hospital);
         
         NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
         service1.setPole(pole);
         service2.setPole(pole);
         pole.setHospital(hospital);
         hospital.setAPHP(aphp);
         
         assertTrue(dataManager.createAPHP(aphp));
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createPole(pole));
         assertTrue(dataManager.createService(service1));
         assertTrue(dataManager.createService(service2));
         assertNotNull(dataManager.getAllServices(pole.getId()));
     }
     
     /**
      * Return an exception if a field is null
      */
     @Test
     public void testCreateHospitalUnitNull() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
        
         Mockito.doThrow(new NullPointerException()).when(dataManager).createHospitalUnit(null);
     }
     
     /**
      * Test the creation of a Hospital Unit
      */
     @Test
     public void testCreateHospitalUnit() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager()); 
         
         Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
         Specialization andrologie = new Specialization(SpecializationEnum.Andrologie);
         Specialization cardiologie = new Specialization(SpecializationEnum.Cardiologie);
         
         NodeHU hu = Mockito.spy(new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie));
         List<NodeHU> hospitalUnits = new ArrayList<>();
         hospitalUnits.add(hu);
         
         NodeService service = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits));
         List<NodeService> services = new ArrayList<>();
         services.add(service);
         
         NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
         List<NodePole> poles = new ArrayList<>();
         poles.add(pole);
         
         NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
         List<NodeHospital> hospitals = new ArrayList<>();
         hospitals.add(hospital);
         
         NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
         hu.setService(service);
         service.setPole(pole);
         pole.setHospital(hospital);
         hospital.setAPHP(aphp);
       
         assertTrue(dataManager.createAPHP(aphp));
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createPole(pole));
         assertTrue(dataManager.createService(service));
         assertTrue(dataManager.createHospitalUnit(hu));
         assertFalse(dataManager.createHospitalUnit(hu));
     }
     
     /**
      * Test if a Hospital Unit exists, it don't returns null
      */
     @Test
     public void testGetHospitalUnit() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         
         Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
         Specialization andrologie = new Specialization(SpecializationEnum.Andrologie);
         Specialization cardiologie = new Specialization(SpecializationEnum.Cardiologie);
         
         NodeHU huCreate = Mockito.spy(new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie));
         List<NodeHU> hospitalUnits = new ArrayList<>();
         hospitalUnits.add(huCreate);
         
         NodeService service = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits));
         List<NodeService> services = new ArrayList<>();
         services.add(service);
         
         NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
         List<NodePole> poles = new ArrayList<>();
         poles.add(pole);
         
         NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
         List<NodeHospital> hospitals = new ArrayList<>();
         hospitals.add(hospital);
         
         NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
         huCreate.setService(service);
         service.setPole(pole);
         pole.setHospital(hospital);
         hospital.setAPHP(aphp);
         
         assertTrue(dataManager.createAPHP(aphp));
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createPole(pole));
         assertTrue(dataManager.createService(service));
         assertTrue(dataManager.createHospitalUnit(huCreate));
         
         NodeHU huResult = dataManager.getHospitalUnit(huCreate.getId());
         
         assertNotNull(huResult);
         assertEquals(huCreate.getId(), huResult.getId());
         assertEquals(huCreate.getType(), huResult.getType());
         assertEquals(huCreate.getSpecialization(), huResult.getSpecialization());
         assertEquals(huCreate.getService(), huResult.getService());
     }
     
     /**
      * Test if Hospital Units exists, it don't returns null
      */
     @Test
     public void testGetAllHospitalUnits() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         
         Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
         Specialization andrologie = new Specialization(SpecializationEnum.Andrologie);
         Specialization cardiologie = new Specialization(SpecializationEnum.Cardiologie);
         Specialization neurologie = new Specialization(SpecializationEnum.Neurologie);
         
         NodeHU hu1 = Mockito.spy(new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie));
         NodeHU hu2 = Mockito.spy(new NodeHU(NodeEnum.HOSPITAL_UNIT, neurologie));
         List<NodeHU> hospitalUnits = new ArrayList<>();
         hospitalUnits.add(hu1);
         hospitalUnits.add(hu2);
         
         NodeService service = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits));
         List<NodeService> services = new ArrayList<>();
         services.add(service);
         
         NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
         List<NodePole> poles = new ArrayList<>();
         poles.add(pole);
         
         NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
         List<NodeHospital> hospitals = new ArrayList<>();
         hospitals.add(hospital);
         
         NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
         hu1.setService(service);
         hu2.setService(service);
         service.setPole(pole);
         pole.setHospital(hospital);
         hospital.setAPHP(aphp);
         
         assertTrue(dataManager.createAPHP(aphp));
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createPole(pole));
         assertTrue(dataManager.createService(service));
         assertTrue(dataManager.createHospitalUnit(hu1));
         assertTrue(dataManager.createHospitalUnit(hu2));
         assertNotNull(dataManager.getAllHospitalUnits(service.getId()));
     }
     
     /**
      * Return an exception if a field is null
      */
     @Test
     public void testCreateCareUnitNull() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
        
         Mockito.doThrow(new NullPointerException()).when(dataManager).createCareUnit(null);
     }
     
     /**
      * Test the creation of a Care Unit
      */
     @Test
     public void testCreateCareUnit() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager()); 
         
         Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
         Specialization andrologie = new Specialization(SpecializationEnum.Andrologie);
         Specialization cardiologie = new Specialization(SpecializationEnum.Cardiologie);
         Specialization neonatologie = new Specialization(SpecializationEnum.Neonatologie);
         
         NodeCU cu = Mockito.spy(new NodeCU(NodeEnum.CARE_UNIT, neonatologie));
         List<NodeCU> careUnits = new ArrayList<>();
         careUnits.add(cu);
         
         NodeHU hu = Mockito.spy(new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie, careUnits));
         List<NodeHU> hospitalUnits = new ArrayList<>();
         hospitalUnits.add(hu);
         
         NodeService service = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits));
         List<NodeService> services = new ArrayList<>();
         services.add(service);
         
         NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
         List<NodePole> poles = new ArrayList<>();
         poles.add(pole);
         
         NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
         List<NodeHospital> hospitals = new ArrayList<>();
         hospitals.add(hospital);
         
         NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
         cu.setHospitalUnit(hu);
         hu.setService(service);
         service.setPole(pole);
         pole.setHospital(hospital);
         hospital.setAPHP(aphp);
       
         assertTrue(dataManager.createAPHP(aphp));
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createPole(pole));
         assertTrue(dataManager.createService(service));
         assertTrue(dataManager.createHospitalUnit(hu));
         assertTrue(dataManager.createCareUnit(cu));
         assertFalse(dataManager.createCareUnit(cu));
     }
     
     /**
      * Test if a Care Unit exists, it don't returns null
      */
     @Test
     public void testGetCareUnit() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager()); 
         
         Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
         Specialization andrologie = new Specialization(SpecializationEnum.Andrologie);
         Specialization cardiologie = new Specialization(SpecializationEnum.Cardiologie);
         Specialization neonatologie = new Specialization(SpecializationEnum.Neonatologie);
         
         NodeCU cuCreate = Mockito.spy(new NodeCU(NodeEnum.CARE_UNIT, neonatologie));
         List<NodeCU> careUnits = new ArrayList<>();
         careUnits.add(cuCreate);
         
         NodeHU hu = Mockito.spy(new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie, careUnits));
         List<NodeHU> hospitalUnits = new ArrayList<>();
         hospitalUnits.add(hu);
         
         NodeService service = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits));
         List<NodeService> services = new ArrayList<>();
         services.add(service);
         
         NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
         List<NodePole> poles = new ArrayList<>();
         poles.add(pole);
         
         NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
         List<NodeHospital> hospitals = new ArrayList<>();
         hospitals.add(hospital);
         
         NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
         cuCreate.setHospitalUnit(hu);
         hu.setService(service);
         service.setPole(pole);
         pole.setHospital(hospital);
         hospital.setAPHP(aphp);
         
         assertTrue(dataManager.createAPHP(aphp));
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createPole(pole));
         assertTrue(dataManager.createService(service));
         assertTrue(dataManager.createHospitalUnit(hu));
         assertTrue(dataManager.createCareUnit(cuCreate));
         
         NodeCU cuResult = dataManager.getCareUnit(cuCreate.getId());
         
         assertNotNull(cuResult);
         assertEquals(cuCreate.getId(), cuResult.getId());
         assertEquals(cuCreate.getType(), cuResult.getType());
         assertEquals(cuCreate.getSpecialization(), cuResult.getSpecialization());
         assertEquals(cuCreate.getHospitalUnit(), cuResult.getHospitalUnit());
     }
     
     /**
      * Test if Care Units exists, it don't returns null
      */
     @Test
     public void testGetAllCareUnits() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         
         Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
         Specialization andrologie = new Specialization(SpecializationEnum.Andrologie);
         Specialization cardiologie = new Specialization(SpecializationEnum.Cardiologie);
         Specialization neonatologie = new Specialization(SpecializationEnum.Neonatologie);
         Specialization neurologie = new Specialization(SpecializationEnum.Neurologie);
         
         NodeCU cu1 = Mockito.spy(new NodeCU(NodeEnum.CARE_UNIT, neonatologie));
         NodeCU cu2 = Mockito.spy(new NodeCU(NodeEnum.CARE_UNIT, neurologie));
         List<NodeCU> careUnits = new ArrayList<>();
         careUnits.add(cu1);
         careUnits.add(cu2);
         
         NodeHU hu = Mockito.spy(new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie, careUnits));
         List<NodeHU> hospitalUnits = new ArrayList<>();
         hospitalUnits.add(hu);
         
         NodeService service = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits));
         List<NodeService> services = new ArrayList<>();
         services.add(service);
         
         NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
         List<NodePole> poles = new ArrayList<>();
         poles.add(pole);
         
         NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
         List<NodeHospital> hospitals = new ArrayList<>();
         hospitals.add(hospital);
         
         NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
         cu1.setHospitalUnit(hu);
         cu2.setHospitalUnit(hu);
         hu.setService(service);
         service.setPole(pole);
         pole.setHospital(hospital);
         hospital.setAPHP(aphp);
         
         assertTrue(dataManager.createAPHP(aphp));
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createPole(pole));
         assertTrue(dataManager.createService(service));
         assertTrue(dataManager.createHospitalUnit(hu));
         assertTrue(dataManager.createCareUnit(cu1));
         assertTrue(dataManager.createCareUnit(cu2));
         assertNotNull(dataManager.getAllCareUnits(hu.getId()));
     }
        
     /**
      * Return an exception if the doctor field is null
      */
     @Test
     public void testCreateDoctorNull() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         
         Mockito.doThrow(new NullPointerException()).when(dataManager).createDoctor(null);
     }
     
     /**
      * Test the creation of a Doctor
      */
     @Test
     public void testCreateDoctor() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager()); 
         
         Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
         
         NodePole nodePole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie));
         List<NodePole> poles = new ArrayList<>();
         poles.add(nodePole);
         
         NodeHospital nodeHospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
         List<NodeHospital> hospitals = new ArrayList<>();
         hospitals.add(nodeHospital);
         
         NodeAPHP nodeAPHP = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
         nodePole.setHospital(nodeHospital);
         nodeHospital.setAPHP(nodeAPHP);
                  
         INode pole = nodePole;
         
         Doctor doctor = Mockito.spy(new Doctor("Durand", "Emilie", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", pole, pediatrie));
       
         assertTrue(dataManager.createAPHP(nodeAPHP));
         assertTrue(dataManager.createHospital(nodeHospital));
         assertTrue(dataManager.createPole(nodePole));
         assertTrue(dataManager.createDoctor(doctor));
         assertFalse(dataManager.createDoctor(doctor));
     }
     
     /**
      * Test if a Doctor exists, it don't returns null
      */
     @Test
     public void testGetDoctor() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         
         Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
         
         NodePole nodePole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie));
         List<NodePole> poles = new ArrayList<>();
         poles.add(nodePole);
         
         NodeHospital nodeHospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
         List<NodeHospital> hospitals = new ArrayList<>();
         hospitals.add(nodeHospital);
         
         NodeAPHP nodeAPHP = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
         
         nodeHospital.setAPHP(nodeAPHP);
         nodePole.setHospital(nodeHospital);
         
         INode pole = nodePole;
         
         Doctor doctorCreate = Mockito.spy(new Doctor("Durand", "Emilie", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", pole, pediatrie));
         
         assertTrue(dataManager.createAPHP(nodeAPHP));
         assertTrue(dataManager.createHospital(nodeHospital));
         assertTrue(dataManager.createPole(nodePole));
         assertTrue(dataManager.createDoctor(doctorCreate));
         
         Doctor doctorResult = dataManager.getDoctor(doctorCreate.getId());
         
         assertNotNull(doctorResult);
         assertEquals(doctorCreate.getLastName(), doctorResult.getLastName());
         assertEquals(doctorCreate.getFirstName(), doctorResult.getFirstName());
         assertEquals(doctorCreate.getAdress(), doctorResult.getAdress());
         assertEquals(doctorCreate.getEmail(), doctorResult.getEmail());
         assertEquals(doctorCreate.getPhoneNumber(), doctorResult.getPhoneNumber());
         assertEquals(doctorCreate.getNode(), doctorResult.getNode());
         assertEquals(doctorCreate.getSpecialization(), doctorResult.getSpecialization());
     }
     
     /**
      * Test if Doctors exists, it don't returns null
      */
     @Test
     public void testGetAllDoctors() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         
         Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
         
         NodePole nodePole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie));
         List<NodePole> poles = new ArrayList<>();
         poles.add(nodePole);
         
         NodeHospital nodeHospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
         List<NodeHospital> hospitals = new ArrayList<>();
         hospitals.add(nodeHospital);
         
         NodeAPHP nodeAPHP = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
         
         nodeHospital.setAPHP(nodeAPHP);
         nodePole.setHospital(nodeHospital);
         
         INode pole = nodePole;
         
         Doctor doctor1 = Mockito.spy(new Doctor("Durand", "Emilie", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", pole, pediatrie));
         Doctor doctor2 = Mockito.spy(new Doctor("Dupond", "Patrick", "5 Avenue de Paris", "patoche@gmail.com", "0718548716", pole, pediatrie));
         
         assertTrue(dataManager.createAPHP(nodeAPHP));
         assertTrue(dataManager.createHospital(nodeHospital));
         assertTrue(dataManager.createPole(nodePole));
         assertTrue(dataManager.createDoctor(doctor1));
         assertTrue(dataManager.createDoctor(doctor2));
         
         assertTrue(dataManager.createDoctor(doctor1));
         assertTrue(dataManager.createDoctor(doctor2));
         assertNotNull(dataManager.getAllDoctors());
     }
     
     /**
      * Test if a Doctor exists, it remove them
      */
     @Test
     public void testRemoveDoctor() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         
         Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
         
         NodePole nodePole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie));
         List<NodePole> poles = new ArrayList<>();
         poles.add(nodePole);
         
         NodeHospital nodeHospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
         List<NodeHospital> hospitals = new ArrayList<>();
         hospitals.add(nodeHospital);
         
         NodeAPHP nodeAPHP = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
         
         nodeHospital.setAPHP(nodeAPHP);
         nodePole.setHospital(nodeHospital);
         
         INode pole = nodePole;
         
         Doctor doctor = Mockito.spy(new Doctor("Durand", "Emilie", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", pole, pediatrie));
         
         assertTrue(dataManager.createAPHP(nodeAPHP));
         assertTrue(dataManager.createHospital(nodeHospital));
         assertTrue(dataManager.createPole(nodePole));
         assertTrue(dataManager.createDoctor(doctor));
         
         assertTrue(dataManager.createDoctor(doctor));
         assertTrue(dataManager.removeDoctor(doctor.getId()));
         assertFalse(dataManager.removeDoctor(doctor.getId()));
     }
     
      /**
      * Return an exception if the nurse field is null
      */
     @Test
     public void testCreateNurseNull() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         
         Mockito.doThrow(new NullPointerException()).when(dataManager).createNurse(null);
     }
     
     /**
      * Test the creation of a Nurse
      */
     @Test
     public void testCreateNurse() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager()); 
         
         Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
         
         NodePole nodePole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie));
         List<NodePole> poles = new ArrayList<>();
         poles.add(nodePole);
         
         NodeHospital nodeHospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
         List<NodeHospital> hospitals = new ArrayList<>();
         hospitals.add(nodeHospital);
         
         NodeAPHP nodeAPHP = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
         nodePole.setHospital(nodeHospital);
         nodeHospital.setAPHP(nodeAPHP);
         
         INode pole = nodePole;
         
         Nurse nurse = Mockito.spy(new Nurse("Durand", "Emilie", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", pole));
       
         assertTrue(dataManager.createAPHP(nodeAPHP));
         assertTrue(dataManager.createHospital(nodeHospital));
         assertTrue(dataManager.createPole(nodePole));
         assertTrue(dataManager.createNurse(nurse));
         assertFalse(dataManager.createNurse(nurse));
     }
     
     /**
      * Test if a Nurse exists, it don't returns null
      */
     @Test
     public void testGetNurse() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         
         Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
         
         NodePole nodePole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie));
         List<NodePole> poles = new ArrayList<>();
         poles.add(nodePole);
         
         NodeHospital nodeHospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
         List<NodeHospital> hospitals = new ArrayList<>();
         hospitals.add(nodeHospital);
         
         NodeAPHP nodeAPHP = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
         nodePole.setHospital(nodeHospital);
         nodeHospital.setAPHP(nodeAPHP);
                 
         INode pole = nodePole;
         
         Nurse nurseCreate = Mockito.spy(new Nurse("Durand", "Emilie", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", pole));
         
         assertTrue(dataManager.createAPHP(nodeAPHP));
         assertTrue(dataManager.createHospital(nodeHospital));
         assertTrue(dataManager.createPole(nodePole));
         assertTrue(dataManager.createNurse(nurseCreate));
         
         Nurse nurseResult = dataManager.getNurse(nurseCreate.getId());
         
         assertNotNull(nurseResult);
         assertEquals(nurseCreate.getLastName(), nurseResult.getLastName());
         assertEquals(nurseCreate.getFirstName(), nurseResult.getFirstName());
         assertEquals(nurseCreate.getAdress(), nurseResult.getAdress());
         assertEquals(nurseCreate.getEmail(), nurseResult.getEmail());
         assertEquals(nurseCreate.getPhoneNumber(), nurseResult.getPhoneNumber());
         assertEquals(nurseCreate.getNode(), nurseResult.getNode());
     }
     
     /**
      * Test if Nurses exists, it don't returns null
      */
     @Test
     public void testGetAllNurses() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         
         Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
         
         NodePole nodePole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie));
         List<NodePole> poles = new ArrayList<>();
         poles.add(nodePole);
         
         NodeHospital nodeHospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
         List<NodeHospital> hospitals = new ArrayList<>();
         hospitals.add(nodeHospital);
         
         NodeAPHP nodeAPHP = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
         nodePole.setHospital(nodeHospital);
         nodeHospital.setAPHP(nodeAPHP);
                 
         INode pole = nodePole;
         
         Nurse nurse1 = Mockito.spy(new Nurse("Durand", "Emilie", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", pole));
         Nurse nurse2 = Mockito.spy(new Nurse("Dupond", "Marine", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", pole));
         
         assertTrue(dataManager.createAPHP(nodeAPHP));
         assertTrue(dataManager.createHospital(nodeHospital));
         assertTrue(dataManager.createPole(nodePole));
         assertTrue(dataManager.createNurse(nurse1));
         assertTrue(dataManager.createNurse(nurse2));
         assertNotNull(dataManager.getAllNurses());
     }
     
     /**
      * Test if a Nurse exists, it remove them
      */
     @Test
     public void testRemoveNurse() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         
         Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
         
         NodePole nodePole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie));
         List<NodePole> poles = new ArrayList<>();
         poles.add(nodePole);
         
         NodeHospital nodeHospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
         List<NodeHospital> hospitals = new ArrayList<>();
         hospitals.add(nodeHospital);
         
         NodeAPHP nodeAPHP = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
         nodePole.setHospital(nodeHospital);
         nodeHospital.setAPHP(nodeAPHP);
                 
         INode pole = nodePole;
         
         Nurse nurse = Mockito.spy(new Nurse("Durand", "Emilie", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", pole));
         
         assertTrue(dataManager.createAPHP(nodeAPHP));
         assertTrue(dataManager.createHospital(nodeHospital));
         assertTrue(dataManager.createPole(nodePole));
         assertTrue(dataManager.createNurse(nurse));
         assertTrue(dataManager.removeNurse(nurse.getId()));
         assertFalse(dataManager.removeNurse(nurse.getId()));
     }
     
     /**
      * Test if Staff exists, it don't returns null
      */
     @Test
     public void testGetStaff() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         
         Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
         
         NodePole nodePole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie));
         List<NodePole> poles = new ArrayList<>();
         poles.add(nodePole);
         
         NodeHospital nodeHospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
         List<NodeHospital> hospitals = new ArrayList<>();
         hospitals.add(nodeHospital);
         
         NodeAPHP nodeAPHP = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
         nodePole.setHospital(nodeHospital);
         nodeHospital.setAPHP(nodeAPHP);
                 
         INode pole = nodePole;
         
         Nurse nurse = Mockito.spy(new Nurse("Durand", "Emilie", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", pole));
         Doctor doctor = Mockito.spy(new Doctor("Dupond", "Patrick", "5 Avenue de Paris", "patoche@gmail.com", "0718548716", pole, pediatrie));
         
         assertTrue(dataManager.createAPHP(nodeAPHP));
         assertTrue(dataManager.createHospital(nodeHospital));
         assertTrue(dataManager.createPole(nodePole));
         assertTrue(dataManager.createDoctor(doctor));
         assertTrue(dataManager.createNurse(nurse));
         assertNotNull(dataManager.getStaff());
     }
}
