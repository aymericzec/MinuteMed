///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package fr.devsquad.minutemed.dmp;
//
//import fr.devsquad.minutemed.arborescence.NodeAPHP;
//import fr.devsquad.minutemed.arborescence.NodeEnum;
//import fr.devsquad.minutemed.database.IDoctor;
//import fr.devsquad.minutemed.specialization.Specialization;
//import fr.devsquad.minutemed.specialization.SpecializationEnum;
//import fr.devsquad.minutemed.staff.Doctor;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author myfou
// */
//public class PrescriptionTest {
//    
//    public PrescriptionTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    // TODO add test methods here.
//    // The methods must be annotated with annotation @Test. For example:
//    //
//    // @Test
//    // public void hello() {}
//    
//    private Diagnostic createDiagnostic () {
//        String title = "Radiologie du fémur";
//        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
//        NodeAPHP node = new NodeAPHP(NodeEnum.POLE, new ArrayList<>());
//        Doctor diagnostic = new Doctor("Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
//        MedicalRecord medicalRecord = new MedicalRecord("194", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", GenderEnum.M);
//        Date consultDiagnostic = new Date();
//        String description = "Chute à vélo, demande dun' radio";
//    
//        Diagnostic diag = new Diagnostic(title, diagnostic, medicalRecord, consultDiagnostic, description);
//        
//        return diag;
//    }
//    
//    private Prescription createTestPrescription() {
//        String title = "Ordonnance rhume";
//        NodeAPHP node = new NodeAPHP(NodeEnum.POLE, new ArrayList<>());
//        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
//        Doctor prescriptor = new Doctor("Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
//        MedicalRecord medicalRecord = new MedicalRecord("194", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", GenderEnum.M);
//        Date consultDate = new Date();
//        Diagnostic diagnostic = createDiagnostic();
//        String prescription = "doliprane, spray nasale";
//        
//        Prescription pres = new Prescription(title, prescriptor, medicalRecord, consultDate, diagnostic, prescription);
//
//        return pres;
//    }
//    
//    @Test
//    public void createPrescription() {
//        createTestPrescription();
//    }
//    
//    @Test(expected = NullPointerException.class)
//    public void createNullPrescription() {
//        Prescription pres = new Prescription(null,null,null,null,null,null);
//    }
//    
//    @Test
//    public void testGetIdEquals () {        
//        Prescription prescription = createTestPrescription();
//        assertEquals(prescription.getId(), 1l);
//    }
//    
//    @Test
//    public void testGetIdNoEquals () {        
//        Prescription prescription = createTestPrescription();
//        assertNotEquals(prescription.getId(), 2l);
//    }
//    
//    @Test
//    public void testGetTitleEquals () {        
//        Prescription prescription = createTestPrescription();
//        assertEquals(prescription.getTitle(), "doliprane, spray nasale");
//    }
//    
//    @Test
//    public void testGetTitleNoEquals () {        
//        Prescription prescription = createTestPrescription();
//        assertNotEquals(prescription.getTitle(), "bad");
//    }
//    
//    @Test
//    public void testGetDoctorEquals () {        
//        String title = "Ordonnance rhume";
//        NodeAPHP node = new NodeAPHP(NodeEnum.POLE, new ArrayList<>());
//        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
//        Doctor prescriptor = new Doctor("Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
//        MedicalRecord medicalRecord = new MedicalRecord("194", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", GenderEnum.M);
//        Date consultDate = new Date();
//        Diagnostic diagnostic = createDiagnostic();
//        String prescription = "doliprane, spray nasale";
//        
//        Prescription pres = new Prescription(title, prescriptor, medicalRecord, consultDate, diagnostic, prescription);
//
//        assertEquals(pres.getDiagnostic(), prescriptor);
//    }
//    
//    @Test
//    public void testGetDoctorNoEquals () {        
//        Prescription prescription = createTestPrescription();
//        NodeAPHP node = new NodeAPHP(NodeEnum.POLE, new ArrayList<>());
//        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
//        assertNotEquals(prescription.getPrescriptor(), new Doctor("Kevin", "VieiraNoro", "2 rue jean", "a@t.gmail", "0770138333", node, specialization));
//    }
//    
//    @Test
//    public void testGetPatientEquals () {        
//        String title = "Ordonnance rhume";
//        NodeAPHP node = new NodeAPHP(NodeEnum.POLE, new ArrayList<>());
//        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
//        Doctor prescriptor = new Doctor("Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
//        MedicalRecord medicalRecord = new MedicalRecord("194", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", GenderEnum.M);
//        Date consultDate = new Date();
//        Diagnostic diagnostic = createDiagnostic();
//        String prescription = "doliprane, spray nasale";
//        
//        Prescription pres = new Prescription(title, prescriptor, medicalRecord, consultDate, diagnostic, prescription);
//
//        assertEquals(pres.getMedicalRecord(), medicalRecord);
//    }
//    
//    @Test
//    public void testGetPatientNoEquals () {        
//        Prescription prescription = createTestPrescription();
//        assertNotEquals(prescription.getMedicalRecord(), new MedicalRecord("194", "Julie", "Perriti", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", GenderEnum.F));
//    }
//    
//    @Test
//    public void testGetDateEquals () {        
//        String title = "Ordonnance rhume";
//        NodeAPHP node = new NodeAPHP(NodeEnum.POLE, new ArrayList<>());
//        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
//        Doctor prescriptor = new Doctor("Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
//        MedicalRecord medicalRecord = new MedicalRecord("194", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", GenderEnum.M);
//        Date consultDate = new Date();
//        Diagnostic diagnostic = createDiagnostic();
//        String prescription = "doliprane, spray nasale";
//        
//        Prescription pres = new Prescription(title, prescriptor, medicalRecord, consultDate, diagnostic, prescription);
//
//
//        assertEquals(pres.getConsultDate(), consultDate);
//    }
//    
//    @Test
//    public void testGetDateNoEquals () {        
//        Prescription prescription = createTestPrescription();
//        assertNotEquals(prescription.getConsultDate(), new Date());
//    }
//
//    @Test
//    public void testGetDiagnotic () {        
//        String title = "Ordonnance rhume";
//        NodeAPHP node = new NodeAPHP(NodeEnum.POLE, new ArrayList<>());
//        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
//        Doctor prescriptor = new Doctor("Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
//        MedicalRecord medicalRecord = new MedicalRecord("194", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", GenderEnum.M);
//        Date consultDate = new Date();
//        Diagnostic diagnostic = createDiagnostic();
//        String prescription = "doliprane, spray nasale";
//        
//        Prescription pres = new Prescription(title, prescriptor, medicalRecord, consultDate, diagnostic, prescription);
//
//        assertEquals(pres.getDiagnostic(), diagnostic);
//    }
//    
//    @Test
//    public void testGetDiagnoticNotEquals () {        
//        Prescription prescription = createTestPrescription();
//        assertNotEquals(prescription.getDiagnostic(), "Diagnostic parmis tant d'autres");
//    }
//
//    @Test
//    public void testGetPrescription () {        
//        String title = "Ordonnance rhume";
//        NodeAPHP node = new NodeAPHP(NodeEnum.POLE, new ArrayList<>());
//        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
//        Doctor prescriptor = new Doctor("Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
//        MedicalRecord medicalRecord = new MedicalRecord("194", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", GenderEnum.M);
//        Date consultDate = new Date();
//        Diagnostic diagnostic = createDiagnostic();
//        String prescription = "doliprane, spray nasale";        
//        Prescription pres = new Prescription(title, prescriptor, medicalRecord, consultDate, diagnostic, prescription);
//
//        assertEquals(pres.getPrescription(), prescription);
//    }
//    
//    @Test
//    public void testGetPrescriptionNotEquals () {        
//        Prescription prescription = createTestPrescription();
//        assertNotEquals(prescription.getPrescription(), "lol");
//    } 
//}
