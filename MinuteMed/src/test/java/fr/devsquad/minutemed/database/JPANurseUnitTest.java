package fr.devsquad.minutemed.database;


import org.junit.Test;
import static org.junit.Assert.*;


public class JPANurseUnitTest {
    
    /**
      * Test if a MedicalRecord exists, it don't returns null
      */
   @Test
   public void testGetMedicalRecord() {
       JPADoctor doctor = new JPADoctor();
       JPANurse nurse = new JPANurse();
       MedicalRecord mRecord = new MedicalRecord(...);
       
       assertTrue(doctor.createMedicalRecord(mRecord));
       assertNotNull(nurse.getMedicalRecord(1));
   }
   
    /**
      * Test if MedicalRecords exists, it don't returns null
      */
   @Test
   public void testGetAllMedicalRecords() {
       JPADoctor doctor = new JPADoctor();
       JPANurse nurse = new JPANurse();
       MedicalRecord mRecord1 = new MedicalRecord(...);
       MedicalRecord mRecord2 = new MedicalRecord(...);
       
       assertTrue(doctor.createMedicalRecord(mRecord1));
       assertTrue(doctor.createMedicalRecord(mRecord2));
       assertNotNull(nurse.getAllMedicalRecords());
   }
   
    /**
      * Test if a Dosage exists, it don't returns null
      */
     @Test
     public void testGetDosage() {
         JPADoctor doctor = new JPADoctor(); 
         JPANurse nurse = new JPANurse();
         MedicalRecord mRecord = new MedicalRecord(...);
         Dosage dosage = new Dosage(...);
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createDosage(1, dosage));
         assertNotNull(nurse.getDosage(1, 2));
     }
     
     /**
      * Test if Dosages exists, it don't returns null
      */
     @Test
     public void testGetAllDosages() {
         JPADoctor doctor = new JPADoctor(); 
         JPANurse nurse = new JPANurse();
         MedicalRecord mRecord = new MedicalRecord(...);
         Dosage dosage1 = new Dosage(...);
         Dosage dosage2 = new Dosage(...);
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createDosage(1, dosage1));
         assertTrue(doctor.createDosage(1, dosage2));
         assertNotNull(nurse.getAllDosages(1));
     }
     
     /**
      * Test if a Doctor exists, it don't returns null
      */
     @Test
     public void testGetDoctor() {
         JPADataManager dataManager = new JPADataManager(); 
         JPADoctor doctor = new JPADoctor(); 
         JPANurse nurse = new JPANurse();
         Doctor doctor1 = new Doctor(...);
         
         assertTrue(dataManager.createDoctor(doctor1));
         assertNotNull(doctor.getDoctor(1));
         assertNotNull(nurse.getDoctor(1));
     }
     
     /**
      * Test if a Nurse exists, it don't returns null
      */
     @Test
     public void testGetNurse() {
         JPADataManager dataManager = new JPADataManager(); 
         JPADoctor doctor = new JPADoctor(); 
         JPANurse nurse = new JPANurse();
         Nurse nurse1 = new Nurse(...);
         
         assertTrue(dataManager.createNurse(nurse1));
         assertNotNull(doctor.getNurse(1));
         assertNotNull(nurse.getNurse(1));
     }
}
