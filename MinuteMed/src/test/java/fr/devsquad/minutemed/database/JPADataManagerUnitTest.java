package fr.devsquad.minutemed.database;


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
         IHospitalStaff user = Mockito.spy(new Doctor(...));
         
         Mockito.doThrow(new IllegalArgumentException()).when(dataManager).createAccount(null, "password", user);
         Mockito.doThrow(new IllegalArgumentException()).when(dataManager).createAccount("pseudo", null, user);
         Mockito.doThrow(new IllegalArgumentException()).when(dataManager).createAccount("pseudo", "password", null);
     }
     
     /**
      * Test if a account is already present in the database or not, to create them 
      */
     @Test
     public void testCreateAccount() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());    
         IHospitalStaff doctor = Mockito.spy(new Doctor(...));
         IHospitalStaff nurse = Mockito.spy(new Nurse(...));
    
         assertTrue(dataManager.createAccount("pseudoDoctor", "passwordDoctor", doctor));
         assertTrue(dataManager.createAccount("pseudoNurse", "passwordNurse", nurse));
         assertFalse(dataManager.createAccount("pseudoDoctor", "passwordDoctor", doctor));
     }
     
     /**
      * Return an exception if a field is null
      */
     @Test
     public void testRemoveAccountNull() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());    
       
         Mockito.doThrow(new IllegalArgumentException()).when(dataManager).removeAccount(null);
     }
     
     /**
      * Test if an account is present in the database to remove them 
      */
     @Test
     public void testRemoveAccount() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());    
         IHospitalStaff doctor = Mockito.spy(new Doctor(...));
         
         assertTrue(dataManager.createAccount("pseudoDoctor", "passwordDoctor", doctor));
         assertTrue(dataManager.removeAccount("pseudoDoctor"));
         assertFalse(dataManager.removeAccount("pseudoFalse"));
     }
     
      /**
      * Return an exception if a field is null
      */
     @Test
     public void testCreateHospitalNull() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());    
       
         Mockito.doThrow(new IllegalArgumentException()).when(dataManager).createHospital(null);
     }
     
      /**
      * Test the creation of an Hospital
      */
     @Test
     public void testCreateHospital() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager()); 
         NodeHospital hospital = Mockito.spy(new NodeHospital(...));
       
         assertTrue(dataManager.createHospital(hospital));
         assertFalse(dataManager.createHospital(hospital));
     }
     
     /**
      * Test if an Hospital exists, it don't returns null
      */
     @Test
     public void testGetHospital() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         NodeHospital hospitalCreate = Mockito.spy(new NodeHospital(...));
         
         assertTrue(dataManager.createHospital(hospitalCreate));
         
         NodeHospital hospitalResult = dataManager.getHospital(hospitalCreate.getId());
         
         assertNotNull(hospitalResult);
         
         //assertEquals()
     }
     
     /**
      * Test if Hospitals exists, it don't returns null
      */
     @Test
     public void testGetAllHospitals() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         NodeHospital hospital1 = Mockito.spy(new NodeHospital(...));
         NodeHospital hospital2 = Mockito.spy(new NodeHospital(...));
         
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
         NodeHospital hospital = Mockito.spy(new NodeHospital(...));
         NodePole pole = Mockito.spy(new NodePole(...));
         
         assertTrue(dataManager.createHospital(hospital));
         Mockito.doThrow(new IllegalArgumentException()).when(dataManager).createPole(hospital.getId(), null);
     }
     
     /**
      * Test the creation of a Pole
      */
     @Test
     public void testCreatePole() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager()); 
         NodeHospital hospital1 = Mockito.spy(new NodeHospital(...));
         NodeHospital hospital2 = Mockito.spy(new NodeHospital(...));
         NodePole pole = Mockito.spy(new NodePole(...));
       
         assertTrue(dataManager.createHospital(hospital1));
         assertTrue(dataManager.createHospital(hospital2));
         assertTrue(dataManager.createPole(hospital1.getId(), pole));
         assertFalse(dataManager.createPole(hospital1.getId(), pole));
         assertTrue(dataManager.createPole(hospital2.getId(), pole));
     }
     
     /**
      * Test if a Pole exists, it don't returns null
      */
     @Test
     public void testGetPole() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         NodeHospital hospital = Mockito.spy(new NodeHospital(...);
         NodePole poleCreate = Mockito.spy(new NodePole(...));
         
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createPole(hospital.getId(), poleCreate));
         
         NodePole poleResult = dataManager.getPole(hospital.getId(), poleCreate.getId());
         
         assertNotNull(poleResult);
         
         //assertEquals()
     }
     
     /**
      * Test if Poles exists, it don't returns null
      */
     @Test
     public void testGetAllPoles() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         NodeHospital hospital = Mockito.spy(new NodeHospital(...));
         NodePole pole1 = Mockito.spy(new NodePole(...));
         NodePole pole2 = Mockito.spy(new NodePole(...));
         
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createPole(hospital.getId(), pole1.getId()));
         assertTrue(dataManager.createPole(hospital.getId(), pole2.getId()));
         assertNotNull(dataManager.getAllPoles(hospital.getId()));
     }
     
     /**
      * Return an exception if a field is null
      */
     @Test
     public void testCreateServiceNull() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         NodeHospital hospital = Mockito.spy(new NodeHospital(...));
         NodeService service = Mockito.spy(new NodeService(...));
         
         assertTrue(dataManager.createHospital(hospital));
         Mockito.doThrow(new IllegalArgumentException()).when(dataManager).createService(hospital.getId(), null);
     }
     
     /**
      * Test the creation of a Service
      */
     @Test
     public void testCreateService() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager()); 
         NodeHospital hospital = Mockito.spy(new NodeHospital(...));
         NodeService service = Mockito.spy(new NodeService(...));
       
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createService(hospital.getId(), service));
         assertFalse(dataManager.createService(hospital.getId(), service));
     }
     
     /**
      * Test if a Service exists, it don't returns null
      */
     @Test
     public void testGetService() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         NodeHospital hospital = Mockito.spy(new NodeHospital(...));
         NodeService serviceCreate = Mockito.spy(new NodeService(...));
         
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createService(hospital.getId(), serviceCreate));
         
         NodeService serviceResult = dataManager.getService(hospital.getId(), serviceCreate.getId());
         
         assertNotNull(serviceResult);
         
         //assertEquals()
     }
     
     /**
      * Test if Services exists, it don't returns null
      */
     @Test
     public void testGetAllServices() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         NodeHospital hospital = Mockito.spy(new NodeHospital(...));
         NodeService service1 = Mockito.spy(new NodeService(...));
         NodeService service2 = Mockito.spy(new NodeService(...));
         
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createService(hospital.getId(), service1));
         assertTrue(dataManager.createService(hospital.getId(), service2));
         assertNotNull(dataManager.getAllServices(hospital.getId()));
     }
     
     /**
      * Return an exception if a field is null
      */
     @Test
     public void testCreateHospitalUnitNull() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         NodeHospital hospital = Mockito.spy(new NodeHospital(...));
         NodeHU hu = Mockito.spy(new NodeHU(...));
         
         assertTrue(dataManager.createHospital(hospital));
         Mockito.doThrow(new IllegalArgumentException()).when(dataManager).createHospitalUnit(hospital.getId(), null);
     }
     
     /**
      * Test the creation of a Hospital Unit
      */
     @Test
     public void testCreateHospitalUnit() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager()); 
         NodeHospital hospital = Mockito.spy(new NodeHospital(...));
         NodeHU hu = Mockito.spy(new NodeHU(...));
       
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createHospitalUnit(hospital.getId(), hu));
         assertFalse(dataManager.createHospitalUnit(hospital.getId(), hu));
     }
     
     /**
      * Test if a Hospital Unit exists, it don't returns null
      */
     @Test
     public void testGetHospitalUnit() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         NodeHospital hospital = Mockito.spy(new NodeHospital(...));
         NodeHU huCreate = Mockito.spy(new NodeHU(...));
         
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createHospitalUnit(1, huCreate));
         
         NodeHU huResult = dataManager.getHospitalUnit(hospital.getId(), huCreate.getId());
         
         assertNotNull(huResult);
         
         //assertEquals()
     }
     
     /**
      * Test if Hospital Units exists, it don't returns null
      */
     @Test
     public void testGetAllHospitalUnits() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         NodeHospital hospital = Mockito.spy(new NodeHospital(...));
         NodeHU hu1 = Mockito.spy(new NodeHU(...));
         NodeHU hu2 = Mockito.spy(new NodeHU(...));
         
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createHospitalUnit(hospital.getId(), hu1));
         assertTrue(dataManager.createHospitalUnit(hospital.getId(), hu2));
         assertNotNull(dataManager.getAllHospitalUnits(hospital.getId()));
     }
     
     /**
      * Return an exception if a field is null
      */
     @Test
     public void testCreateCareUnitNull() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         NodeHospital hospital = Mockito.spy(new NodeHospital(...));
         NodeCU cu = Mockito.spy(new NodeCU(...));
         
         assertTrue(dataManager.createHospital(hospital));
         Mockito.doThrow(new IllegalArgumentException()).when(dataManager).createCareUnit(1, null);
     }
     
     /**
      * Test the creation of a Care Unit
      */
     @Test
     public void testCreateCareUnit() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager()); 
         NodeHospital hospital = Mockito.spy(new NodeHospital(...));
         NodeCU cu = Mockito.spy(new NodeCU(...));
       
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createCareUnit(hospital.getId(), cu));
         assertFalse(dataManager.createCareUnit(hospital.getId(), cu));
     }
     
     /**
      * Test if a Care Unit exists, it don't returns null
      */
     @Test
     public void testGetCareUnit() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager()); 
         NodeHospital hospital = Mockito.spy(new NodeHospital(...));
         NodeCU cuCreate = Mockito.spy(new NodeCU(...));
         
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createCareUnit(hospital.getId(), cuCreate));
         
         NodeCU cuResult = dataManager.getCareUnit(hospital.getId(), cuCreate.getId());
         
         assertNotNull(cuResult);
         
         //assertEquals()
     }
     
     /**
      * Test if Care Units exists, it don't returns null
      */
     @Test
     public void testGetAllCareUnits() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         NodeHospital hospital = Mockito.spy(new NodeHospital(...));
         NodeCU cu1 = Mockito.spy(new NodeCU(...));
         NodeCU cu2 = Mockito.spy(new NodeCU(...));
         
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createCareUnit(hospital.getId(), cu1));
         assertTrue(dataManager.createCareUnit(hospital.getId(), cu2));
         assertNotNull(dataManager.getAllCareUnits(hospital.getId()));
     }
     
     /**
      * Test if a Node exists, it don't returns null
      */
     @Test
     public void testGetNode() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         NodeHospital hospital = Mockito.spy(new NodeHospital(...));
         NodePole poleCreate = Mockito.spy(new NodePole(...));
         NodeService serviceCreate = Mockito.spy(new NodeService(...));
         NodeHU huCreate = Mockito.spy(new NodeHU(...));
         NodeCU cuCreate = Mockito.spy(new NodeCU(...));
         
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createPole(hospital.getId(), poleCreate));
         assertTrue(dataManager.createService(hospital.getId(), serviceCreate));
         assertTrue(dataManager.createHospitalUnit(hospital.getId(), huCreate));
         assertTrue(dataManager.createCareUnit(hospital.getId(), cuCreate));
         
         NodePole poleResult = dataManager.getNode(hospital.getId(), poleCreate.getId());
         NodeService serviceResult = dataManager.getNode(hospital.getId(), serviceCreate.getId());
         NodeHU huResult = dataManager.getNode(hospital.getId(), huCreate.getId());
         NodeCU cuResult = dataManager.getNode(hospital.getId(), cuCreate.getId());
         
         assertNotNull(poleResult);
         assertNotNull(serviceResult);
         assertNotNull(huResult);
         assertNotNull(cuResult);
         
         //assertEquals()
     }
     
     /**
      * Test if Nodes exists, it don't returns null
      */
     @Test
     public void testGetAllNodes() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         NodeHospital hospital = Mockito.spy(new NodeHospital(...));
         NodePole pole = Mockito.spy(new NodePole(...));
         NodeService service = Mockito.spy(new NodeService(...));
         NodeHU hu = Mockito.spy(new NodeHU(...));
         NodeCU cu = Mockito.spy(new NodeCU(...));
         
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createPole(hospital.getId(), pole));
         assertTrue(dataManager.createService(hospital.getId(), service));
         assertTrue(dataManager.createHospitalUnit(hospital.getId(), hu));
         assertTrue(dataManager.createCareUnit(hospital.getId(), cu));
         
         assertNotNull(dataManager.getAllNodes(hospital.getId()));
     }
     
     /**
      * Return an exception if the doctor field is null
      */
     @Test
     public void testCreateDoctorNull() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         
         Mockito.doThrow(new IllegalArgumentException()).when(dataManager).createDoctor(null);
     }
     
     /**
      * Test the creation of a Doctor
      */
     @Test
     public void testCreateDoctor() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager()); 
         Doctor doctor = Mockito.spy(new Doctor(...));
       
         assertTrue(dataManager.createDoctor(doctor));
         assertFalse(dataManager.createDoctor(doctor));
     }
     
     /**
      * Test if a Doctor exists, it don't returns null
      */
     @Test
     public void testGetDoctor() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         Doctor doctorCreate = Mockito.spy(new Doctor(...));
         
         assertTrue(dataManager.createDoctor(doctor));
         
         Doctor doctorResult = dataManager.getDoctor(doctorCreate.getId());
         
         assertNotNull(doctorResult);
         
         //assertEquals()
     }
     
     /**
      * Test if Doctors exists, it don't returns null
      */
     @Test
     public void testGetAllDoctors() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         Doctor doctor1 = Mockito.spy(new Doctor(...));
         Doctor doctor2 = Mockito.spy(new Doctor(...));
         
         assertTrue(dataManager.createDoctor(doctor1));
         assertTrue(dataManager.createDoctor(doctor2));
         assertNotNull(dataManager.getDoctors());
     }
     
     /**
      * Test if a Doctor exists, it remove them
      */
     @Test
     public void testRemoveDoctor() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         Doctor doctor = Mockito.spy(new Doctor(...));
         
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
         
         Mockito.doThrow(new IllegalArgumentException()).when(dataManager).createNurse(null);
     }
     
     /**
      * Test the creation of a Nurse
      */
     @Test
     public void testCreateNurse() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager()); 
         Nurse nurse = Mockito.spy(new Nurse(...));
       
         assertTrue(dataManager.createNurse(nurse));
         assertFalse(dataManager.createNurse(nurse));
     }
     
     /**
      * Test if a Nurse exists, it don't returns null
      */
     @Test
     public void testGetNurse() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         Nurse nurseCreate = Mockito.spy(new Nurse(...));
         
         assertTrue(dataManager.createNurse(nurseCreate));
         
         Nurse nurseResult = dataManager.getNurse(nurseCreate.getId());
         
         assertNotNull(nurseResult);
         
         //assertEquals()
     }
     
     /**
      * Test if Nurses exists, it don't returns null
      */
     @Test
     public void testGetAllNurses() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         Nurse nurse1 = Mockito.spy(new Nurse(...));
         Nurse nurse2 = Mockito.spy(new Nurse(...));
         
         assertTrue(dataManager.createNurse(nurse1));
         assertTrue(dataManager.createNurse(nurse2));
         assertNotNull(dataManager.getNurses());
     }
     
     /**
      * Test if a Nurse exists, it remove them
      */
     @Test
     public void testRemoveNurse() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager());
         Nurse nurse = Mockito.spy(new Nurse(...));
         
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
         IHospitalStaff doctor = Mockito.spy(new Doctor(...));
         IHospitalStaff nurse = Mockito.spy(new Nurse(...));
         
         assertTrue(dataManager.createDoctor(doctor));
         assertTrue(dataManager.createNurse(nurse));
         assertNotNull(dataManager.getStaff());
     }
}
