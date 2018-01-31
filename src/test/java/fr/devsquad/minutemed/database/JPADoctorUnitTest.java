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
public class JPADoctorUnitTest {
    
    /**
      * Return an exception if the MedicalRecord field is null
      */
     @Test
     public void testCreateMedicalRecordNull() {
         JPADoctor doctor = Mockito.spy(new JPADoctor()); 
         
         Mockito.doThrow(new NullPointerException()).when(doctor).createMedicalRecord(null);
     }
     
     /**
      * Test the creation of a MedicalRecord
      */
     @Test
     public void testCreateMedicalRecord() {
         JPADoctor doctor = Mockito.spy(new JPADoctor()); 
         MedicalRecord mRecord = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", GenderEnum.M));
       
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertFalse(doctor.createMedicalRecord(mRecord));
     }
     
     /**
      * Return an exception if a field is null
      */
     @Test
     public void testCreateExamNull() {
         JPADoctor doctor = Mockito.spy(new JPADoctor()); 
         
         Mockito.doThrow(new NullPointerException()).when(doctor).createExam(null);
     }
    
     /**
      * Test the creation of an Exam
      */
     @Test
     public void testCreateExam() {
         JPADoctor doctor = Mockito.spy(new JPADoctor()); 
         MedicalRecord mRecord = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", GenderEnum.M));
         Exam exam = Mockito.spy(new Exam(...));
       
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createExam(mRecord.getId(), exam));
         assertFalse(doctor.createExam(mRecord.getId(), exam));
     }
     
     /**
      * Test if an Exam exists, it don't returns null
      */
     @Test
     public void testGetExam() {
         JPADoctor doctor = Mockito.spy(new JPADoctor()); 
         MedicalRecord mRecord = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", GenderEnum.M));
         Exam examCreate = Mockito.spy(new Exam(...));
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createExam(mRecord.getId(), examCreate));
         
         Exam examResult = doctor.getExam(mRecord.getId(), examCreate.getId());
         
         assertNotNull(examResult);
         
         //assertEquals()
     }
     
     /**
      * Test if Exams exists, it don't returns null
      */
     @Test
     public void testGetAllExams() {
         JPADoctor doctor = Mockito.spy(new JPADoctor()); 
         MedicalRecord mRecord = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", GenderEnum.M));
         Exam exam1 = Mockito.spy(new Exam(...));
         Exam exam2 = Mockito.spy(new Exam(...));
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createExam(mRecord.getId(), exam1));
         assertTrue(doctor.createExam(mRecord.getId(), exam2));
         assertNotNull(doctor.getAllExams(mRecord.getId()));
     }
     
     /**
      * Test if an Exam exists, it validate them
      */
     @Test
     public void testValidateExam() {
         JPADoctor doctor = Mockito.spy(new JPADoctor()); 
         MedicalRecord mRecord = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", GenderEnum.M));
         Exam exam = Mockito.spy(new Exam(...));
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createExam(mRecord.getId(), exam));
         assertTrue(doctor.validateExam(mRecord.getId(), exam.getId()));
         assertFalse(doctor.validateExam(mRecord.getId(), exam.getId()));
     }
     
     /**
      * Test if an Exam exists, it remove the draft
      */
     @Test
     public void testRemoveDraftExam() {
         JPADoctor doctor = Mockito.spy(new JPADoctor()); 
         MedicalRecord mRecord = Mockito.spy(new MedicalRecord(...));
         Exam exam = Mockito.spy(new Exam(...));
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createExam(mRecord.getId(), exam));
         assertTrue(doctor.removeDraftExam(mRecord.getId(), exam.getId()));
         assertFalse(doctor.removeDraftExam(mRecord.getId(), exam.getId()));
     }
     
     /**
      * Return an exception if a field is null
      */
     @Test
     public void testCreatePrescriptionNull() {
         JPADoctor doctor = Mockito.spy(new JPADoctor()); 
         MedicalRecord mRecord = Mockito.spy(new MedicalRecord(...));
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         Mockito.doThrow(new NullPointerException()).when(doctor).createPrescription(mRecord.getId(), null);
     }
    
     /**
      * Test the creation of a Prescription
      */
     @Test
     public void testCreatePrescription() {
         JPADoctor doctor = Mockito.spy(new JPADoctor()); 
         MedicalRecord mRecord = Mockito.spy(new MedicalRecord(...));
         Prescription prescription = Mockito.spy(new Prescription(...));
       
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createPrescription(mRecord.getId(), prescription));
         assertFalse(doctor.createPrescription(mRecord.getId(), prescription));
     }
     
     /**
      * Test if a Prescription exists, it don't returns null
      */
     @Test
     public void testGetPrescription() {
         JPADoctor doctor = Mockito.spy(new JPADoctor()); 
         MedicalRecord mRecord = Mockito.spy(new MedicalRecord(...));
         Prescription prescriptionCreate = Mockito.spy(new Prescription(...));
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createPrescription(mRecord.getId(), prescriptionCreate));
         
         Prescription prescriptionResult = doctor.getPrescription(mRecord.getId(), prescriptionCreate.getId());
         
         assertNotNull(prescriptionResult);
         
         //assertEquals()
     }
     
     /**
      * Test if Prescriptions exists, it don't returns null
      */
     @Test
     public void testGetAllPrescriptions() {
         JPADoctor doctor = Mockito.spy(new JPADoctor()); 
         MedicalRecord mRecord = Mockito.spy(new MedicalRecord(...));
         Prescription prescription1 = Mockito.spy(new Prescription(...));
         Prescription prescription2 = Mockito.spy(new Prescription(...));
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createPrescription(mRecord.getId(), prescription1));
         assertTrue(doctor.createPrescription(mRecord.getId(), prescription2));
         assertNotNull(doctor.getAllPrescriptions(mRecord.getId()));
     }
     
     /**
      * Test if a Prescription exists, it validate them
      */
     @Test
     public void testValidatePrescription() {
         JPADoctor doctor = Mockito.spy(new JPADoctor()); 
         MedicalRecord mRecord = Mockito.spy(new MedicalRecord(...));
         Prescription prescription = Mockito.spy(new Prescription(...));
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createPrescription(mRecord.getId(), prescription));
         assertTrue(doctor.validatePrescription(mRecord.getId(), prescription.getId()));
         assertFalse(doctor.validatePrescription(mRecord.getId(), prescription.getId()));
     }
     
     /**
      * Test if a Prescription exists, it remove the draft
      */
     @Test
     public void testRemoveDraftPrescription() {
         JPADoctor doctor = Mockito.spy(new JPADoctor()); 
         MedicalRecord mRecord = Mockito.spy(new MedicalRecord(...));
         Prescription prescription = Mockito.spy(new Prescription(...));
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createPrescription(mRecord.getId(), prescription));
         assertTrue(doctor.removeDraftPrescription(mRecord.getId(), prescription.getId()));
         assertFalse(doctor.removeDraftPrescription(mRecord.getId(), prescription.getId()));
     }
     
     /**
      * Return an exception if a field is null
      */
     @Test
     public void testCreateDiagnosticNull() {
         JPADoctor doctor = Mockito.spy(new JPADoctor()); 
         MedicalRecord mRecord = Mockito.spy(new MedicalRecord(...));
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         Mockito.doThrow(new NullPointerException()).when(doctor).createDiagnostic(mRecord.getId(), null);
     }
    
     /**
      * Test the creation of a Diagnostic
      */
     @Test
     public void testCreateDiagnostic() {
         JPADoctor doctor = Mockito.spy(new JPADoctor()); 
         MedicalRecord mRecord = Mockito.spy(new MedicalRecord(...));
         Diagnostic diagnostic = Mockito.spy(new Diagnostic(...));
       
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createDiagnostic(mRecord.getId(), diagnostic));
         assertFalse(doctor.createDiagnostic(mRecord.getId(), diagnostic));
     }
     
     /**
      * Test if a Diagnostic exists, it don't returns null
      */
     @Test
     public void testGetDiagnostic() {
         JPADoctor doctor = Mockito.spy(new JPADoctor()); 
         MedicalRecord mRecord = Mockito.spy(new MedicalRecord(...));
         Diagnostic diagnosticCreate = Mockito.spy(new Diagnostic(...));
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createDiagnostic(mRecord.getId(), diagnosticCreate));
         
         Diagnostic diagnosticResult = doctor.getDiagnostic(mRecord.getId(), diagnosticCreate.getId());
         
         assertNotNull(diagnosticResult);
         
         //assertEquals()
     }
     
     /**
      * Test if Diagnostics exists, it don't returns null
      */
     @Test
     public void testGetAllDiagnostics() {
         JPADoctor doctor = Mockito.spy(new JPADoctor()); 
         MedicalRecord mRecord = Mockito.spy(new MedicalRecord(...));
         Diagnostic diagnostic1 = Mockito.spy(new Diagnostic(...));
         Diagnostic diagnostic2 = Mockito.spy(new Diagnostic(...));
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createDiagnostic(mRecord.getId(), diagnostic1));
         assertTrue(doctor.createDiagnostic(mRecord.getId(), diagnostic2));
         assertNotNull(doctor.getAllDiagnostics(mRecord.getId()));
     }
     
     /**
      * Test if a Diagnostic exists, it validate them
      */
     @Test
     public void testValidateDiagnostic() {
         JPADoctor doctor = Mockito.spy(new JPADoctor()); 
         MedicalRecord mRecord = Mockito.spy(new MedicalRecord(...));
         Diagnostic diagnostic = Mockito.spy(new Diagnostic(...));
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createDiagnostic(mRecord.getId(), diagnostic));
         assertTrue(doctor.validateDiagnostic(mRecord.getId(), diagnostic.getId()));
         assertFalse(doctor.validateDiagnostic(mRecord.getId(), diagnostic.getId()));
     }
     
     /**
      * Test if a Diagnostic exists, it remove the draft
      */
     @Test
     public void testRemoveDraftDiagnostic() {
         JPADoctor doctor = Mockito.spy(new JPADoctor()); 
         MedicalRecord mRecord = Mockito.spy(new MedicalRecord(...));
         Diagnostic diagnostic = Mockito.spy(new Diagnostic(...));
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createDiagnostic(mRecord.getId(), diagnostic));
         assertTrue(doctor.removeDraftDiagnostic(mRecord.getId(), diagnostic.getId()));
         assertFalse(doctor.removeDraftDiagnostic(mRecord.getId(), diagnostic.getId()));
     }
     
     /**
      * Return an exception if a field is null
      */
     @Test
     public void testCreateDosageNull() {
         JPADoctor doctor = new JPADoctor(); 
         MedicalRecord mRecord = new MedicalRecord(...);
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         Mockito.doThrow(new NullPointerException()).when(doctor).createDosage(mRecord.getId(), null);
     }
    
     /**
      * Test the creation of a Dosage
      */
     @Test
     public void testCreateDosage() {
         JPADoctor doctor = Mockito.spy(new JPADoctor()); 
         MedicalRecord mRecord = Mockito.spy(new MedicalRecord(...));
         Dosage dosage = Mockito.spy(new Dosage(...));
       
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createDosage(mRecord.getId(), dosage));
         assertFalse(doctor.createDosage(mRecord.getId(), dosage));
     }
     
     /**
      * Test if a Dosage exists, it validate them
      */
     @Test
     public void testValidateDosage() {
         JPADoctor doctor = Mockito.spy(new JPADoctor()); 
         MedicalRecord mRecord = Mockito.spy(new MedicalRecord(...));
         Dosage dosage = Mockito.spy(new Dosage(...));
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createDosage(mRecord.getId(), dosage));
         assertTrue(doctor.validateDosage(mRecord.getId(), dosage.getId()));
         assertFalse(doctor.validateDosage(mRecord.getId(), dosage.getId()));
     }
     
     /**
      * Test if a Dosage exists, it remove the draft
      */
     @Test
     public void testRemoveDraftDosage() {
         JPADoctor doctor = Mockito.spy(new JPADoctor()); 
         MedicalRecord mRecord = Mockito.spy(new MedicalRecord(...));
         Dosage dosage = Mockito.spy(new Dosage(...));
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createDosage(mRecord.getId(), dosage));
         assertTrue(doctor.removeDraftDosage(mRecord.getId(), dosage.getId()));
         assertFalse(doctor.removeDraftDosage(mRecord.getId(), dosage.getId()));
     }
     
        /**
        * Test if a MedicalRecord exists, it don't returns null
        */
        @Test
        public void testGetMedicalRecord() {
            JPADoctor doctor = Mockito.spy(new JPADoctor());
            MedicalRecord mRecordCreate = Mockito.spy(new MedicalRecord(...));

            assertTrue(doctor.createMedicalRecord(mRecordCreate));

            MedicalRecord mRecordResult = doctor.getMedicalRecord(mRecordCreate.getId());

            assertNotNull(mRecordResult);

            //assertEquals()
        }
   
        /**
          * Test if MedicalRecords exists, it don't returns null
          */
        @Test
        public void testGetAllMedicalRecords() {
            JPADoctor doctor = Mockito.spy(new JPADoctor());
            MedicalRecord mRecord1 = Mockito.spy(new MedicalRecord(...));
            MedicalRecord mRecord2 = Mockito.spy(new MedicalRecord(...;

            assertTrue(doctor.createMedicalRecord(mRecord1));
            assertTrue(doctor.createMedicalRecord(mRecord2));
            assertNotNull(doctor.getAllMedicalRecords());
        }
   
        /**
          * Test if a Dosage exists, it don't returns null
          */
         @Test
         public void testGetDosage() {
             JPADoctor doctor = Mockito.spy(new JPADoctor()); 
             MedicalRecord mRecord = Mockito.spy(new MedicalRecord(...));
             Dosage dosageCreate = Mockito.spy(new Dosage(...));

             assertTrue(doctor.createMedicalRecord(mRecord));
             assertTrue(doctor.createDosage(mRecord.getId(), dosageCreate));

             Dosage dosageResult = doctor.getDosage(mRecord.getId(), dosageCreate.getId());

             assertNotNull(dosageResult);

             //assertEquals()
         }
     
        /**
         * Test if Dosages exists, it don't returns null
         */
        @Test
        public void testGetAllDosages() {
            JPADoctor doctor = Mockito.spy(new JPADoctor()); 
            MedicalRecord mRecord = Mockito.spy(new MedicalRecord(...));
            Dosage dosage1 = Mockito.spy(new Dosage(...));
            Dosage dosage2 = Mockito.spy(new Dosage(...));

            assertTrue(doctor.createMedicalRecord(mRecord));
            assertTrue(doctor.createDosage(mRecord.getId(), dosage1));
            assertTrue(doctor.createDosage(mRecord.getId(), dosage2));
            assertNotNull(doctor.getAllDosages(mRecord.getId()));
        }
     
        /**
         * Test if a Doctor exists, it don't returns null
         */
        @Test
        public void testGetDoctor() {
            JPADataManager dataManager = Mockito.spy(new JPADataManager());
            JPADoctor doctor = Mockito.spy(new JPADoctor()); 
            
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

            Doctor doctorResult = doctor.getDoctor(doctorCreate.getId());

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
            JPADoctor doctor = Mockito.spy(new JPADoctor()); 
            
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

            Nurse nurseResult = doctor.getNurse(nurseCreate.getId());

            assertNotNull(nurseResult);
            assertEquals(nurseCreate.getLastName(), nurseResult.getLastName());
            assertEquals(nurseCreate.getFirstName(), nurseResult.getFirstName());
            assertEquals(nurseCreate.getAdress(), nurseResult.getAdress());
            assertEquals(nurseCreate.getEmail(), nurseResult.getEmail());
            assertEquals(nurseCreate.getPhoneNumber(), nurseResult.getPhoneNumber());
            assertEquals(nurseCreate.getNode(), nurseResult.getNode());
        }
}
