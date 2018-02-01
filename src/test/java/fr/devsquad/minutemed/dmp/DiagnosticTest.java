///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package fr.devsquad.minutemed.dmp;
//
//import fr.devsquad.minutemed.arborescence.NodeAPHP;
//import fr.devsquad.minutemed.arborescence.NodeEnum;
//import fr.devsquad.minutemed.specialization.Specialization;
//import fr.devsquad.minutemed.specialization.SpecializationEnum;
//import fr.devsquad.minutemed.staff.Doctor;
//import java.util.ArrayList;
//import java.util.Date;
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
//public class DiagnosticTest {
//    
//    public DiagnosticTest() {
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
//    @Test
//    public void createDiagnosticTest() {
//        createDiagnostic();
//    }
//    
//    @Test(expected = NullPointerException.class)
//    public void fieldNullCreate () {
//        Diagnostic diagnotic = new Diagnostic(null, null, null, null, null);
//    }
//    
//    @Test
//    public void testGetIdEquals () {        
//        Diagnostic diagnotic = createDiagnostic();
//        assertEquals(diagnotic.getId(), 1l);
//    }
//    
//    @Test
//    public void testGetIdNoEquals () {
//        Diagnostic diagnostic = createDiagnostic();
//        assertNotEquals(diagnostic.getId(), 2l);
//    }
//    
//    @Test
//    public void testGetTitleEquals () {        
//        Diagnostic diagnotic = createDiagnostic();
//        assertEquals(diagnotic.getTitle(), "Radiologie du fémur");
//    }
//    
//    @Test
//    public void testGetTitleNoEquals () {
//        Diagnostic diagnostic = createDiagnostic();
//        assertNotEquals(diagnostic.getTitle(), "pop");
//    }
//    
//    @Test
//    public void testGetDiagnoticDoctorEquals () {        
//       String title = "Radiologie du fémur";
//        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
//        NodeAPHP node = new NodeAPHP(NodeEnum.POLE, new ArrayList<>());
//        Doctor diagnostic = new Doctor("Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
//        MedicalRecord medicalRecord = new MedicalRecord("194", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", GenderEnum.M);
//        Date consultDiagnostic = new Date();
//        String description = "Chute à vélo, demande dun' radio";
//    
//        Diagnostic diag = new Diagnostic(title, diagnostic, medicalRecord, consultDiagnostic, description);
//        
//        assertEquals(diag.getDiagnostic(), diagnostic);
//    }
//    
//    @Test
//    public void testGetDiagnoticDoctorNoEquals () {
//        Diagnostic diagnostic = createDiagnostic();
//        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
//        NodeAPHP node = new NodeAPHP(NodeEnum.POLE, new ArrayList<>());
//        assertNotEquals(diagnostic.getDiagnostic(), new Doctor("Thomas", "Sadaoui", "2 rue jean", "a@t.gmail", "0770138333", node, specialization));
//    }
//    
//    @Test
//    public void testGetPatientEquals () {
//        String title = "Radiologie du fémur";
//        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
//        NodeAPHP node = new NodeAPHP(NodeEnum.POLE, new ArrayList<>());
//        Doctor diagnostic = new Doctor("Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
//        MedicalRecord medicalRecord = new MedicalRecord("194", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", GenderEnum.M);
//        Date consultDiagnostic = new Date();
//        String description = "Chute à vélo, demande dun' radio";
//    
//        Diagnostic diag = new Diagnostic(title, diagnostic, medicalRecord, consultDiagnostic, description);
//        assertEquals(diag.getMedicalRecord(), diagnostic);
//    }
//    
//    @Test
//    public void testGetPatientNoEquals () {
//        Diagnostic diagnostic = createDiagnostic();
//        assertNotEquals(diagnostic.getMedicalRecord(), new MedicalRecord("194", "Lucie", "Martin", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", GenderEnum.M));
//    }
//    
//    @Test
//    public void testGetDateEquals () {
//        String title = "Radiologie du fémur";
//        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
//        NodeAPHP node = new NodeAPHP(NodeEnum.POLE, new ArrayList<>());
//        Doctor diagnostic = new Doctor("Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
//        MedicalRecord medicalRecord = new MedicalRecord("194", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", GenderEnum.M);
//        Date consultDiagnostic = new Date();
//        String description = "Chute à vélo, demande dun' radio";
//    
//        Diagnostic diag = new Diagnostic(title, diagnostic, medicalRecord, consultDiagnostic, description);
//        assertEquals(diag.getConsultDiagnostic(), consultDiagnostic);
//    }
//    
//    @Test
//    public void testGetDateNoEquals () {
//        Diagnostic diagnostic = createDiagnostic();
//        assertNotEquals(diagnostic.getConsultDiagnostic(), new Date());
//    }
//    
//    @Test
//    public void testGetDescriptionEquals () {
//        String title = "Radiologie du fémur";
//        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
//        NodeAPHP node = new NodeAPHP(NodeEnum.POLE, new ArrayList<>());
//        Doctor diagnostic = new Doctor("Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
//        MedicalRecord medicalRecord = new MedicalRecord("194", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", GenderEnum.M);
//        Date consultDiagnostic = new Date();
//        String description = "Chute à vélo, demande dun' radio";
//    
//        Diagnostic diag = new Diagnostic(title, diagnostic, medicalRecord, consultDiagnostic, description);
//        assertEquals(diag.getDescription(), description);
//    }
//    
//    @Test
//    public void testGetDescriptionNoEquals () {
//        Diagnostic diagnostic = createDiagnostic();
//        assertNotEquals(diagnostic.getDescription(), "toto");
//    }
//}
