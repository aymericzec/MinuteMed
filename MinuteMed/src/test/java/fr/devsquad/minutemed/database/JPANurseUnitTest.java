package fr.devsquad.minutemed.database;


import fr.devsquad.minutemed.arborescence.INode;
import fr.devsquad.minutemed.arborescence.NodeAPHP;
import fr.devsquad.minutemed.arborescence.NodeEnum;
import fr.devsquad.minutemed.arborescence.NodeHospital;
import fr.devsquad.minutemed.arborescence.NodePole;
import fr.devsquad.minutemed.dmp.GenderEnum;
import fr.devsquad.minutemed.dmp.MedicalRecord;
import fr.devsquad.minutemed.specialization.Specialization;
import fr.devsquad.minutemed.specialization.SpecializationEnum;
import fr.devsquad.minutemed.staff.Doctor;
import fr.devsquad.minutemed.staff.Nurse;
import java.util.ArrayList;
import java.util.List;
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
       MedicalRecord mRecordCreate = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", GenderEnum.M));
       
       assertTrue(doctor.createMedicalRecord(mRecordCreate));
       
       MedicalRecord mRecordResult = nurse.getMedicalRecord(mRecordCreate.getId());
       
       assertNotNull(mRecordResult);
       assertEquals(mRecordCreate.getId(), mRecordResult.getId());
       assertEquals(mRecordCreate.getSs(), mRecordResult.getSs());
       assertEquals(mRecordCreate.getLastName(), mRecordResult.getLastName());
       assertEquals(mRecordCreate.getFirstName(), mRecordResult.getFirstName());
       assertEquals(mRecordCreate.getEmail(), mRecordResult.getEmail());
       assertEquals(mRecordCreate.getAddress(), mRecordResult.getAddress());
       assertEquals(mRecordCreate.getPhoneNumber(), mRecordResult.getPhoneNumber());
       assertEquals(mRecordCreate.getBirthday(), mRecordResult.getBirthday());
       assertEquals(mRecordCreate.getGender(), mRecordResult.getGender());
   }
   
    /**
      * Test if MedicalRecords exists, it don't returns null
      */
   @Test
   public void testGetAllMedicalRecords() {
       JPADoctor doctor = Mockito.spy(new JPADoctor());
       JPANurse nurse = Mockito.spy(new JPANurse());
       MedicalRecord mRecord1 = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", GenderEnum.M));
       MedicalRecord mRecord2 = Mockito.spy(new MedicalRecord("1947851035104", "Durand", "Emilie", "5 rue de Paris", "emilie.durand@gmail.com", "0712018751", "17/11/1994", GenderEnum.F));
       
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
         MedicalRecord mRecord = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", GenderEnum.M));
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
         MedicalRecord mRecord = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", GenderEnum.M));
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
         
         assertTrue(dataManager.createDoctor(doctorCreate));
     
         Doctor doctorResult = nurse.getDoctor(doctorCreate.getId());
         
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
      * Test if a Nurse exists, it don't returns null
      */
     @Test
     public void testGetNurse() {
         JPADataManager dataManager = Mockito.spy(new JPADataManager()); 
         JPANurse nurse = Mockito.spy(new JPANurse());
         
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
         
         Nurse nurseCreate = Mockito.spy(new Nurse("Durand", "Emilie", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", pole));
         
         assertTrue(dataManager.createNurse(nurseCreate));
         
         Nurse nurseResult = nurse.getNurse(nurseCreate.getId());
         
         assertNotNull(nurseResult);
         assertEquals(nurseCreate.getLastName(), nurseResult.getLastName());
         assertEquals(nurseCreate.getFirstName(), nurseResult.getFirstName());
         assertEquals(nurseCreate.getAdress(), nurseResult.getAdress());
         assertEquals(nurseCreate.getEmail(), nurseResult.getEmail());
         assertEquals(nurseCreate.getPhoneNumber(), nurseResult.getPhoneNumber());
         assertEquals(nurseCreate.getNode(), nurseResult.getNode());
     }
}
