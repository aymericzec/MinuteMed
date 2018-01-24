package fr.devsquad.minutemed.database;


import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class JPANurseUnitTest {
    
    /**
      * Test if a MedicalRecord exists, it don't returns null
      */
   @Test
   public void testGetMedicalRecord() {
       JPADoctor doctor = Mockito.spy(new JPADoctor());
       JPANurse nurse = Mockito.spy(new JPANurse());
       MedicalRecord mRecordCreate = Mockito.spy(new MedicalRecord(...));
       
       assertTrue(doctor.createMedicalRecord(mRecordCreate));
       
       MedicalRecord mRecordResult = nurse.getMedicalRecord(mRecordCreate.getId());
       
       assertNotNull(mRecordResult);
       
       //assertEquals()
   }
   
    /**
      * Test if MedicalRecords exists, it don't returns null
      */
   @Test
   public void testGetAllMedicalRecords() {
       JPADoctor doctor = Mockito.spy(new JPADoctor());
       JPANurse nurse = Mockito.spy(new JPANurse());
       MedicalRecord mRecord1 = Mockito.spy(new MedicalRecord(...));
       MedicalRecord mRecord2 = Mockito.spy(new MedicalRecord(...;
       
       assertTrue(doctor.createMedicalRecord(mRecord1));
       assertTrue(doctor.createMedicalRecord(mRecord2));
       assertNotNull(nurse.getAllMedicalRecords());
   }
   
    /**
      * Test if a Dosage exists, it don't returns null
      */
     @Test
     public void testGetDosage() {
         JPADoctor doctor = Mockito.spy(new JPADoctor()); 
         JPANurse nurse = Mockito.spy(new JPANurse());
         MedicalRecord mRecord = Mockito.spy(new MedicalRecord(...));
         Dosage dosageCreate = Mockito.spy(new Dosage(...));
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createDosage(mRecord.getId(), dosageCreate));
         
         Dosage dosageResult = nurse.getDosage(mRecord.getId(), dosageCreate.getId());
         
         assertNotNull(dosageResult);
         
         //assertEquals()
     }
     
     /**
      * Test if Dosages exists, it don't returns null
      */
     @Test
     public void testGetAllDosages() {
         JPADoctor doctor = Mockito.spy(new JPADoctor()); 
         JPANurse nurse = Mockito.spy(new JPANurse());
         MedicalRecord mRecord = Mockito.spy(new MedicalRecord(...));
         Dosage dosage1 = Mockito.spy(new Dosage(...));
         Dosage dosage2 = Mockito.spy(new Dosage(...));
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createDosage(mRecord.getId(), dosage1));
         assertTrue(doctor.createDosage(mRecord.getId(), dosage2));
         assertNotNull(nurse.getAllDosages(mRecord.getId()));
     }
     
     /**
      * Test if a Doctor exists, it don't returns null
      */
     @Test
     public void testGetDoctor() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager()); 
         JPANurse nurse = Mockito.spy(new JPANurse());
         Doctor doctorCreate = Mockito.spy(new Doctor(...));
         
         assertTrue(dataManager.createDoctor(doctorCreate));
     
         Doctor doctorResult = nurse.getDoctor(doctorCreate.getId());
         
         assertNotNull(doctorResult);
         
         //assertEquals()
     }
     
     /**
      * Test if a Nurse exists, it don't returns null
      */
     @Test
     public void testGetNurse() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager()); 
         JPANurse nurse = Mockito.spy(new JPANurse());
         Nurse nurseCreate = Mockito.spy(new Nurse("Durand", "Emilie", "5 Avenue de la Republique", "0718547896"));
         
         assertTrue(dataManager.createNurse(nurseCreate));
         
         Nurse nurseResult = nurse.getNurse(nurseCreate.getId());
         
         assertNotNull(nurseResult);
         assertEquals(nurseCreate.getLastName(), nurseResult.getLastName());
         assertEquals(nurseCreate.getFirstName(), nurseResult.getFirstName());
         assertEquals(nurseCreate.getAdress(), nurseResult.getAdress());
         assertEquals(nurseCreate.getPhoneNumber, nurseResult.getPhoneNumber());
     }
}
