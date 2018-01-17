package fr.devsquad.minutemed.database;


import org.junit.Test;
import static org.junit.Assert.*;


public class JPADataManagerUnitTest {
    
     /**
      * Return an exception if a field is null
      */
     @Test(expected = IllegalArgumentException.class)
     public void testCreateAccountNull() {
         JPADataManager dataManager = new JPADataManager();    
         IHospitalStaff user;
    
         dataManager.createAccount(null, "password", user);
         dataManager.createAccount("pseudo", null, user);
         dataManager.createAccount("pseudo", "password", null);
     }
     
     /**
      * Test if a account is already present in the database or not, to create them 
      */
     @Test
     public void testCreateAccount() {
         JPADataManager dataManager = new JPADataManager();    
         IHospitalStaff doctor = new Doctor(...);
         IHospitalStaff nurse = new Nurse(...);
    
         assertTrue(dataManager.createAccount("pseudoDoctor", "passwordDoctor", doctor));
         assertTrue(dataManager.createAccount("pseudoNurse", "passwordNurse", nurse));
         assertFalse(dataManager.createAccount("pseudoDoctor", "passwordDoctor", doctor));
     }
     
     /**
      * Return an exception if a field is null
      */
     @Test(expected = IllegalArgumentException.class)
     public void testRemoveAccountNull() {
         JPADataManager dataManager = new JPADataManager();    
       
         dataManager.removeAccount(null);
     }
     
     /**
      * Test if an account is present in the database to remove them 
      */
     @Test
     public void testRemoveAccount() {
         JPADataManager dataManager = new JPADataManager();    
         IHospitalStaff doctor = new Doctor(...);
         
         assertTrue(dataManager.createAccount("pseudoDoctor", "passwordDoctor", doctor));
         assertTrue(dataManager.removeAccount("pseudoDoctor"));
         assertFalse(dataManager.removeAccount("pseudoFalse"));
     }
     
      /**
      * Return an exception if a field is null
      */
     @Test(expected = IllegalArgumentException.class)
     public void testCreateHospitalNull() {
         JPADataManager dataManager = new JPADataManager();    
       
         dataManager.createHospital(null);
     }
     
      /**
      * Test the creation of an Hospital
      */
     @Test
     public void testCreateHospital() {
         JPADataManager dataManager = new JPADataManager(); 
         NodeHospital hospital = new NodeHospital(1, "Hopital Paris");
       
         assertTrue(dataManager.createHospital(hospital));
         assertFalse(dataManager.createHospital(hospital));
     }
     
     /**
      * Test if an Hospital exists, it don't returns null
      */
     @Test
     public void testGetHospital() {
         JPADataManager dataManager = new JPADataManager();
         NodeHospital hospital = new NodeHospital(1, "Hopital Paris");
         
         assertTrue(dataManager.createHospital(hospital));
         assertNotNull(dataManager.getHospital(1));
     }
     
     /**
      * Test if Hospitals exists, it don't returns null
      */
     @Test
     public void testGetAllHospitals() {
         JPADataManager dataManager = new JPADataManager();
         NodeHospital hospital1 = new NodeHospital(1, "Hopital Paris");
         NodeHospital hospital2 = new NodeHospital(2, "Hopital Reims");
         
         assertTrue(dataManager.createHospital(hospital1));
         assertTrue(dataManager.createHospital(hospital2));
         assertNotNull(dataManager.getAllHospitals());
     }
     
     /**
      * Return an exception if a field is null
      */
     @Test(expected = IllegalArgumentException.class)
     public void testCreatePoleNull() {
         JPADataManager dataManager = new JPADataManager();
         NodeHospital hospital = new NodeHospital(1, "Hopital Paris");
         NodePole pole = new NodePole(...);
         
         assertTrue(dataManager.createHospital(hospital));
         dataManager.createPole(null, pole);
         dataManager.createPole(1, null);
     }
     
     /**
      * Test the creation of a Pole
      */
     @Test
     public void testCreatePole() {
         JPADataManager dataManager = new JPADataManager(); 
         NodeHospital hospital1 = new NodeHospital(1, "Hopital Paris");
         NodeHospital hospital2 = new NodeHospital(2, "Hopital Reims");
         NodePole pole = new NodePole(...);
       
         assertTrue(dataManager.createHospital(hospital1));
         assertTrue(dataManager.createHospital(hospital2));
         assertTrue(dataManager.createPole(1, pole));
         assertFalse(dataManager.createPole(1, pole));
         assertTrue(dataManager.createPole(2, pole));
     }
     
     /**
      * Test if a Pole exists, it don't returns null
      */
     @Test
     public void testGetPole() {
         JPADataManager dataManager = new JPADataManager();
         NodeHospital hospital = new NodeHospital(1, "Hopital Paris");
         NodePole pole = new NodePole(...);
         
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createPole(1, pole));
         assertNotNull(dataManager.getPole(1, 2));
     }
     
     /**
      * Test if Poles exists, it don't returns null
      */
     @Test
     public void testGetAllPoles() {
         JPADataManager dataManager = new JPADataManager();
         NodeHospital hospital = new NodeHospital(1, "Hopital Paris");
         NodePole pole1 = new NodePole(...);
         NodePole pole2 = new NodePole(...);
         
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createPole(1, pole1));
         assertTrue(dataManager.createPole(1, pole2));
         assertNotNull(dataManager.getAllPoles(1));
     }
     
     /**
      * Return an exception if a field is null
      */
     @Test(expected = IllegalArgumentException.class)
     public void testCreateServiceNull() {
         JPADataManager dataManager = new JPADataManager();
         NodeHospital hospital = new NodeHospital(1, "Hopital Paris");
         NodeService service = new NodeService(...);
         
         assertTrue(dataManager.createHospital(hospital));
         dataManager.createService(null, service);
         dataManager.createService(1, null);
     }
     
     /**
      * Test the creation of a Service
      */
     @Test
     public void testCreateService() {
         JPADataManager dataManager = new JPADataManager(); 
         NodeHospital hospital = new NodeHospital(1, "Hopital Paris");
         NodeService service = new NodeService(...);
       
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createService(1, service));
         assertFalse(dataManager.createService(1, service));
     }
     
     /**
      * Test if a Service exists, it don't returns null
      */
     @Test
     public void testGetService() {
         JPADataManager dataManager = new JPADataManager();
         NodeHospital hospital = new NodeHospital(1, "Hopital Paris");
         NodeService service = new NodeService(...);
         
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createService(1, service));
         assertNotNull(dataManager.getService(1, 2));
     }
     
     /**
      * Test if Services exists, it don't returns null
      */
     @Test
     public void testGetAllServices() {
         JPADataManager dataManager = new JPADataManager();
         NodeHospital hospital = new NodeHospital(1, "Hopital Paris");
         NodeService service1 = new NodeService(...);
         NodeService service2 = new NodeService(...);
         
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createService(1, service1));
         assertTrue(dataManager.createService(1, service2));
         assertNotNull(dataManager.getAllServices(1));
     }
     
     /**
      * Return an exception if a field is null
      */
     @Test(expected = IllegalArgumentException.class)
     public void testCreateHospitalUnitNull() {
         JPADataManager dataManager = new JPADataManager();
         NodeHospital hospital = new NodeHospital(1, "Hopital Paris");
         NodeHU hu = new NodeHU(...);
         
         assertTrue(dataManager.createHospital(hospital));
         dataManager.createHospitalUnit(null, hu);
         dataManager.createHospitalUnit(1, null);
     }
     
     /**
      * Test the creation of a Hospital Unit
      */
     @Test
     public void testCreateHospitalUnit() {
         JPADataManager dataManager = new JPADataManager(); 
         NodeHospital hospital = new NodeHospital(1, "Hopital Paris");
         NodeHU hu = new NodeHU(...);
       
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createHospitalUnit(1, hu));
         assertFalse(dataManager.createHospitalUnit(1, hu));
     }
     
     /**
      * Test if a Hospital Unit exists, it don't returns null
      */
     @Test
     public void testGetHospitalUnit() {
         JPADataManager dataManager = new JPADataManager();
         NodeHospital hospital = new NodeHospital(1, "Hopital Paris");
         NodeHU hu = new NodeHU(...);
         
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createHospitalUnit(1, hu));
         assertNotNull(dataManager.getHospitalUnit(1, 2));
     }
     
     /**
      * Test if Hospital Units exists, it don't returns null
      */
     @Test
     public void testGetAllHospitalUnits() {
         JPADataManager dataManager = new JPADataManager();
         NodeHospital hospital = new NodeHospital(1, "Hopital Paris");
         NodeHU hu1 = new NodeHU(...);
         NodeHU hu2 = new NodeHU(...);
         
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createHospitalUnit(1, hu1));
         assertTrue(dataManager.createHospitalUnit(1, hu2));
         assertNotNull(dataManager.getAllHospitalUnits(1));
     }
     
     /**
      * Return an exception if a field is null
      */
     @Test(expected = IllegalArgumentException.class)
     public void testCreateCareUnitNull() {
         JPADataManager dataManager = new JPADataManager();
         NodeHospital hospital = new NodeHospital(1, "Hopital Paris");
         NodeCU cu = new NodeCU(...);
         
         assertTrue(dataManager.createHospital(hospital));
         dataManager.createCareUnit(null, cu);
         dataManager.createCareUnit(1, null);
     }
     
     /**
      * Test the creation of a Care Unit
      */
     @Test
     public void testCreateCareUnit() {
         JPADataManager dataManager = new JPADataManager(); 
         NodeHospital hospital = new NodeHospital(1, "Hopital Paris");
         NodeCU cu = new NodeCU(...);
       
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createCareUnit(1, cu));
         assertFalse(dataManager.createCareUnit(1, cu));
     }
     
     /**
      * Test if a Care Unit exists, it don't returns null
      */
     @Test
     public void testGetCareUnit() {
         JPADataManager dataManager = new JPADataManager();
         NodeHospital hospital = new NodeHospital(1, "Hopital Paris");
         NodeCU cu = new NodeCU(...);
         
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createCareUnit(1, cu));
         assertNotNull(dataManager.getCareUnit(1, 2));
     }
     
     /**
      * Test if Care Units exists, it don't returns null
      */
     @Test
     public void testGetAllCareUnits() {
         JPADataManager dataManager = new JPADataManager();
         NodeHospital hospital = new NodeHospital(1, "Hopital Paris");
         NodeCU cu1 = new NodeCU(...);
         NodeCU cu2 = new NodeCU(...);
         
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createCareUnit(1, cu1));
         assertTrue(dataManager.createCareUnit(1, cu2));
         assertNotNull(dataManager.getAllCareUnits(1));
     }
     
     /**
      * Test if a Node exists, it don't returns null
      */
     @Test
     public void testGetNode() {
         JPADataManager dataManager = new JPADataManager();
         NodeHospital hospital = new NodeHospital(1, "Hopital Paris");
         NodePole pole = new NodePole(...);
         NodeService service = new NodeService(...);
         NodeHU hu = new NodeHU(...);
         NodeCU cu = new NodeCU(...);
         
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createPole(1, pole));
         assertTrue(dataManager.createService(1, service));
         assertTrue(dataManager.createHospitalUnit(1, hu));
         assertTrue(dataManager.createCareUnit(1, cu));
         
         assertNotNull(dataManager.getNode(1, 2));
         assertNotNull(dataManager.getNode(1, 3));
         assertNotNull(dataManager.getNode(1, 4));
         assertNotNull(dataManager.getNode(1, 5));
     }
     
     /**
      * Test if Nodes exists, it don't returns null
      */
     @Test
     public void testGetAllNodes() {
         JPADataManager dataManager = new JPADataManager();
         NodeHospital hospital = new NodeHospital(1, "Hopital Paris");
         NodePole pole = new NodePole(...);
         NodeService service = new NodeService(...);
         NodeHU hu = new NodeHU(...);
         NodeCU cu = new NodeCU(...);
         
         assertTrue(dataManager.createHospital(hospital));
         assertTrue(dataManager.createPole(1, pole));
         assertTrue(dataManager.createService(1, service));
         assertTrue(dataManager.createHospitalUnit(1, hu));
         assertTrue(dataManager.createCareUnit(1, cu));
         
         assertNotNull(dataManager.getAllNodes(1));
     }
     
     /**
      * Return an exception if the doctor field is null
      */
     @Test(expected = IllegalArgumentException.class)
     public void testCreateDoctoNull() {
         JPADataManager dataManager = new JPADataManager();
         
         dataManager.createDoctor(null);
     }
     
     /**
      * Test the creation of a Doctor
      */
     @Test
     public void testCreateDoctor() {
         JPADataManager dataManager = new JPADataManager(); 
         Doctor doctor = new Doctor(...);
       
         assertTrue(dataManager.createDoctor(doctor));
         assertFalse(dataManager.createDoctor(doctor));
     }
     
     /**
      * Test if a Doctor exists, it don't returns null
      */
     @Test
     public void testGetDoctor() {
         JPADataManager dataManager = new JPADataManager();
         Doctor doctor = new Doctor(...);
         
         assertTrue(dataManager.createDoctor(doctor));
         assertNotNull(dataManager.getDoctor(1));
     }
     
     /**
      * Test if Doctors exists, it don't returns null
      */
     @Test
     public void testGetAllDoctors() {
         JPADataManager dataManager = new JPADataManager();
         Doctor doctor1 = new Doctor(...);
         Doctor doctor2 = new Doctor(...);
         
         assertTrue(dataManager.createDoctor(doctor1));
         assertTrue(dataManager.createDoctor(doctor2));
         assertNotNull(dataManager.getDoctors());
     }
     
     /**
      * Test if a Doctor exists, it remove them
      */
     @Test
     public void testRemoveDoctor() {
         JPADataManager dataManager = new JPADataManager();
         Doctor doctor = new Doctor(...);
         
         assertTrue(dataManager.createDoctor(doctor));
         assertTrue(dataManager.removeDoctor(1));
         assertFalse(dataManager.removeDoctor(1));
     }
     
      /**
      * Return an exception if the nurse field is null
      */
     @Test(expected = IllegalArgumentException.class)
     public void testCreateNurseNull() {
         JPADataManager dataManager = new JPADataManager();
         
         dataManager.createNurse(null);
     }
     
     /**
      * Test the creation of a Nurse
      */
     @Test
     public void testCreateNurse() {
         JPADataManager dataManager = new JPADataManager(); 
         Nurse nurse = new Nurse(...);
       
         assertTrue(dataManager.createNurse(nurse));
         assertFalse(dataManager.createNurse(nurse));
     }
     
     /**
      * Test if a Nurse exists, it don't returns null
      */
     @Test
     public void testGetNurse() {
         JPADataManager dataManager = new JPADataManager();
         Nurse nurse = new Nurse(...);
         
         assertTrue(dataManager.createNurse(nurse));
         assertNotNull(dataManager.getNurse(1));
     }
     
     /**
      * Test if Nurses exists, it don't returns null
      */
     @Test
     public void testGetAllNurses() {
         JPADataManager dataManager = new JPADataManager();
         Nurse nurse1 = new Nurse(...);
         Nurse nurse2 = new Nurse(...);
         
         assertTrue(dataManager.createNurse(nurse1));
         assertTrue(dataManager.createNurse(nurse2));
         assertNotNull(dataManager.getNurses());
     }
     
     /**
      * Test if a Nurse exists, it remove them
      */
     @Test
     public void testRemoveNurse() {
         JPADataManager dataManager = new JPADataManager();
         Nurse nurse = new Nurse(...);
         
         assertTrue(dataManager.createNurse(nurse));
         assertTrue(dataManager.removeNurse(1));
         assertFalse(dataManager.removeNurse(1));
     }
     
     /**
      * Test if Staff exists, it don't returns null
      */
     @Test
     public void testGetStaff() {
         JPADataManager dataManager = new JPADataManager();
         Doctor doctor = new Doctor(...);
         Nurse nurse = new Nurse(...);
         
         assertTrue(dataManager.createDoctor(doctor));
         assertTrue(dataManager.createNurse(nurse));
         assertNotNull(dataManager.getStaff());
     }
}
