package fr.devsquad.minutemed.database;


import org.junit.Test;
import static org.junit.Assert.*;


public class JPADoctorUnitTest {
    
    /**
      * Return an exception if the MedicalRecord field is null
      */
     @Test(expected = IllegalArgumentException.class)
     public void testCreateMedicalRecordNull() {
         JPADoctor doctor = new JPADoctor(); 
         
         doctor.createMedicalRecord(null);
     }
     
     /**
      * Test the creation of a MedicalRecord
      */
     @Test
     public void testCreateMedicalRecord() {
         JPADoctor doctor = new JPADoctor(); 
         MedicalRecord mRecord = new MedicalRecord(...);
       
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertFalse(doctor.createMedicalRecord(mRecord));
     }
     
     /**
      * Return an exception if a field is null
      */
     @Test(expected = IllegalArgumentException.class)
     public void testCreateExamNull() {
         JPADoctor doctor = new JPADoctor(); 
         MedicalRecord mRecord = new MedicalRecord(...);
         Exam exam = new Exam(...);
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         doctor.createExam(null, exam);
         doctor.createExam(1, null);
     }
    
     /**
      * Test the creation of an Exam
      */
     @Test
     public void testCreateExam() {
         JPADoctor doctor = new JPADoctor(); 
         MedicalRecord mRecord = new MedicalRecord(...);
         Exam exam = new Exam(...);
       
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createExam(1, exam));
         assertFalse(doctor.createExam(1, exam));
     }
     
     /**
      * Test if an Exam exists, it don't returns null
      */
     @Test
     public void testGetExam() {
         JPADoctor doctor = new JPADoctor(); 
         MedicalRecord mRecord = new MedicalRecord(...);
         Exam exam = new Exam(...);
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createExam(1, exam));
         assertNotNull(doctor.getExam(1, 2));
     }
     
     /**
      * Test if Exams exists, it don't returns null
      */
     @Test
     public void testGetAllExams() {
         JPADoctor doctor = new JPADoctor(); 
         MedicalRecord mRecord = new MedicalRecord(...);
         Exam exam1 = new Exam(...);
         Exam exam2 = new Exam(...);
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createExam(1, exam1));
         assertTrue(doctor.createExam(1, exam2));
         assertNotNull(doctor.getAllExams(1));
     }
     
     /**
      * Test if an Exam exists, it validate them
      */
     @Test
     public void testValidateExam() {
         JPADoctor doctor = new JPADoctor(); 
         MedicalRecord mRecord = new MedicalRecord(...);
         Exam exam = new Exam(...);
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createExam(1, exam));
         assertTrue(doctor.validateExam(1, 2));
         assertFalse(doctor.validateExam(1, 2));
     }
     
     /**
      * Test if an Exam exists, it remove the draft
      */
     @Test
     public void testRemoveDraftExam() {
         JPADoctor doctor = new JPADoctor(); 
         MedicalRecord mRecord = new MedicalRecord(...);
         Exam exam = new Exam(...);
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createExam(1, exam));
         assertTrue(doctor.removeDraftExam(1, 2));
         assertFalse(doctor.removeDraftExam(1, 2));
     }
     
     /**
      * Return an exception if a field is null
      */
     @Test(expected = IllegalArgumentException.class)
     public void testCreatePrescriptionNull() {
         JPADoctor doctor = new JPADoctor(); 
         MedicalRecord mRecord = new MedicalRecord(...);
         Prescription prescription = new Prescription(...);
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         doctor.createPrescription(null, prescription);
         doctor.createPrescription(1, null);
     }
    
     /**
      * Test the creation of a Prescription
      */
     @Test
     public void testCreatePrescription() {
         JPADoctor doctor = new JPADoctor(); 
         MedicalRecord mRecord = new MedicalRecord(...);
         Prescription prescription = new Prescription(...);
       
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createPrescription(1, prescription));
         assertFalse(doctor.createPrescription(1, prescription));
     }
     
     /**
      * Test if a Prescription exists, it don't returns null
      */
     @Test
     public void testGetPrescription() {
         JPADoctor doctor = new JPADoctor(); 
         MedicalRecord mRecord = new MedicalRecord(...);
         Prescription prescription = new Prescription(...);
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createPrescription(1, prescription));
         assertNotNull(doctor.getPrescription(1, 2));
     }
     
     /**
      * Test if Prescriptions exists, it don't returns null
      */
     @Test
     public void testGetAllPrescriptions() {
         JPADoctor doctor = new JPADoctor(); 
         MedicalRecord mRecord = new MedicalRecord(...);
         Prescription prescription1 = new Prescription(...);
         Prescription prescription2 = new Prescription(...);
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createPrescription(1, prescription1));
         assertTrue(doctor.createPrescription(1, prescription2));
         assertNotNull(doctor.getAllPrescriptions(1));
     }
     
     /**
      * Test if a Prescription exists, it validate them
      */
     @Test
     public void testValidatePrescription() {
         JPADoctor doctor = new JPADoctor(); 
         MedicalRecord mRecord = new MedicalRecord(...);
         Prescription prescription = new Prescription(...);
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createPrescription(1, prescription));
         assertTrue(doctor.validatePrescription(1, 2));
         assertFalse(doctor.validatePrescription(1, 2));
     }
     
     /**
      * Test if a Prescription exists, it remove the draft
      */
     @Test
     public void testRemoveDraftPrescription() {
         JPADoctor doctor = new JPADoctor(); 
         MedicalRecord mRecord = new MedicalRecord(...);
         Prescription prescription = new Prescription(...);
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createPrescription(1, prescription));
         assertTrue(doctor.removeDraftPrescription(1, 2));
         assertFalse(doctor.removeDraftPrescription(1, 2));
     }
     
     /**
      * Return an exception if a field is null
      */
     @Test(expected = IllegalArgumentException.class)
     public void testCreateDiagnosticNull() {
         JPADoctor doctor = new JPADoctor(); 
         MedicalRecord mRecord = new MedicalRecord(...);
         Diagnostic diagnostic = new Diagnostic(...);
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         doctor.createDiagnostic(null, diagnostic);
         doctor.createDiagnostic(1, null);
     }
    
     /**
      * Test the creation of a Diagnostic
      */
     @Test
     public void testCreateDiagnostic() {
         JPADoctor doctor = new JPADoctor(); 
         MedicalRecord mRecord = new MedicalRecord(...);
         Diagnostic diagnostic = new Diagnostic(...);
       
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createDiagnostic(1, diagnostic));
         assertFalse(doctor.createDiagnostic(1, diagnostic));
     }
     
     /**
      * Test if a Diagnostic exists, it don't returns null
      */
     @Test
     public void testGetDiagnostic() {
         JPADoctor doctor = new JPADoctor(); 
         MedicalRecord mRecord = new MedicalRecord(...);
         Diagnostic diagnostic = new Diagnostic(...);
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createDiagnostic(1, diagnostic));
         assertNotNull(doctor.getDiagnostic(1, 2));
     }
     
     /**
      * Test if Diagnostics exists, it don't returns null
      */
     @Test
     public void testGetAllDiagnostics() {
         JPADoctor doctor = new JPADoctor(); 
         MedicalRecord mRecord = new MedicalRecord(...);
         Diagnostic diagnostic1 = new Diagnostic(...);
         Diagnostic diagnostic2 = new Diagnostic(...);
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createDiagnostic(1, diagnostic1));
         assertTrue(doctor.createDiagnostic(1, diagnostic2));
         assertNotNull(doctor.getAllDiagnostics(1));
     }
     
     /**
      * Test if a Diagnostic exists, it validate them
      */
     @Test
     public void testValidateDiagnostic() {
         JPADoctor doctor = new JPADoctor(); 
         MedicalRecord mRecord = new MedicalRecord(...);
         Diagnostic diagnostic = new Diagnostic(...);
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createDiagnostic(1, diagnostic));
         assertTrue(doctor.validateDiagnostic(1, 2));
         assertFalse(doctor.validateDiagnostic(1, 2));
     }
     
     /**
      * Test if a Diagnostic exists, it remove the draft
      */
     @Test
     public void testRemoveDraftDiagnostic() {
         JPADoctor doctor = new JPADoctor(); 
         MedicalRecord mRecord = new MedicalRecord(...);
         Diagnostic diagnostic = new Diagnostic(...);
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createDiagnostic(1, diagnostic));
         assertTrue(doctor.removeDraftDiagnostic(1, 2));
         assertFalse(doctor.removeDraftDiagnostic(1, 2));
     }
     
     /**
      * Return an exception if a field is null
      */
     @Test(expected = IllegalArgumentException.class)
     public void testCreateDosageNull() {
         JPADoctor doctor = new JPADoctor(); 
         MedicalRecord mRecord = new MedicalRecord(...);
         Dosage dosage = new Dosage(...);
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         doctor.createDosage(null, dosage);
         doctor.createDosage(1, null);
     }
    
     /**
      * Test the creation of a Dosage
      */
     @Test
     public void testCreateDosage() {
         JPADoctor doctor = new JPADoctor(); 
         MedicalRecord mRecord = new MedicalRecord(...);
         Dosage dosage = new Dosage(...);
       
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createDosage(1, dosage));
         assertFalse(doctor.createDosage(1, dosage));
     }
     
     /**
      * Test if a Dosage exists, it validate them
      */
     @Test
     public void testValidateDosage() {
         JPADoctor doctor = new JPADoctor(); 
         MedicalRecord mRecord = new MedicalRecord(...);
         Dosage dosage = new Dosage(...);
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createDosage(1, dosage));
         assertTrue(doctor.validateDosage(1, 2));
         assertFalse(doctor.validateDosage(1, 2));
     }
     
     /**
      * Test if a Dosage exists, it remove the draft
      */
     @Test
     public void testRemoveDraftDosage() {
         JPADoctor doctor = new JPADoctor(); 
         MedicalRecord mRecord = new MedicalRecord(...);
         Dosage dosage = new Dosage(...);
         
         assertTrue(doctor.createMedicalRecord(mRecord));
         assertTrue(doctor.createDosage(1, dosage));
         assertTrue(doctor.removeDraftDosage(1, 2));
         assertFalse(doctor.removeDraftDosage(1, 2));
     }
}
