/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.dmp;

import fr.devsquad.minutemed.arborescence.INode;
import fr.devsquad.minutemed.arborescence.NodeAPHP;
import fr.devsquad.minutemed.arborescence.NodeEnum;
import fr.devsquad.minutemed.specialization.Specialization;
import fr.devsquad.minutemed.specialization.SpecializationEnum;
import fr.devsquad.minutemed.staff.Doctor;
import fr.devsquad.minutemed.staff.IHospitalStaff;
import fr.devsquad.minutemed.staff.Nurse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author myfou
 */
public class DosageTest {
    
    public DosageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    private Dosage createDefaultDosage () {
        String title = "Gastro";
        NodeAPHP node = new NodeAPHP(NodeEnum.POLE, new ArrayList<>());
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Doctor doctorConsulting = new Doctor("Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        MedicalRecord medicalRecord = new MedicalRecord("194", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", GenderEnum.M);
        Date dateDosage = new Date();
        Diagnostic diagnostic = new Diagnostic();
        String dosagePrescription = "3 pillule à 11h\n 2 avant de se coucher";
        Date beginDosage = new Date();
        Date endDosage = new Date();
        
        Dosage dosage = new Dosage(title, doctorConsulting, medicalRecord, dateDosage, diagnostic, dosagePrescription, beginDosage, endDosage);
        
        return dosage;
    }
    
    @Test
    public void createDosageTest() {
        createDefaultDosage();
    }
    
    @Test(expected = NullPointerException.class)
    public void createDosageTestNull () {
        Dosage dosage = new Dosage(null, null, null, null, null, null, null, null);
    }
    
    @Test
    public void getTitleTest() {
        Dosage dosage = createDefaultDosage();
        assertEquals(dosage.getTitle(), "Gastro");
    }
    
    public void getTitleTestNotEquals () {
        Dosage dosage = createDefaultDosage();
        assertNotEquals(dosage.getTitle(), "Oupla");
    }
    
    @Test
    public void getDoctorConsultingTest() {
        String title = "Gastro";
        NodeAPHP node = new NodeAPHP(NodeEnum.POLE, new ArrayList<>());
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Doctor doctorConsulting = new Doctor("Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        MedicalRecord medicalRecord = new MedicalRecord("194", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", GenderEnum.M);
        Date dateDosage = new Date();
        Diagnostic diagnostic = new Diagnostic();
        String dosagePrescription = "3 pillule à 11h\n 2 avant de se coucher";
        Date beginDosage = new Date();
        Date endDosage = new Date();
        
        Dosage dosage = new Dosage(title, doctorConsulting, medicalRecord, dateDosage, diagnostic, dosagePrescription, beginDosage, endDosage);
        assertEquals(dosage.getDoctorConsulting(), doctorConsulting);
    }
    
    public void getDoctorConsultingTestNotEquals () {
        Dosage dosage = createDefaultDosage();
        NodeAPHP node = new NodeAPHP(NodeEnum.POLE, new ArrayList<>());
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Doctor doctorConsulting = new Doctor("Alice", "Martin", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        
        assertNotEquals(dosage.getTitle(), doctorConsulting);
    }
    
     
    @Test
    public void getPatientTest() {
        String title = "Gastro";
        NodeAPHP node = new NodeAPHP(NodeEnum.POLE, new ArrayList<>());
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Doctor doctorConsulting = new Doctor("Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        MedicalRecord medicalRecord = new MedicalRecord("194", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", GenderEnum.M);
        Date dateDosage = new Date();
        Diagnostic diagnostic = new Diagnostic();
        String dosagePrescription = "3 pillule à 11h\n 2 avant de se coucher";
        Date beginDosage = new Date();
        Date endDosage = new Date();
        
        Dosage dosage = new Dosage(title, doctorConsulting, medicalRecord, dateDosage, diagnostic, dosagePrescription, beginDosage, endDosage);
        assertEquals(dosage.getMedicalRecord(), medicalRecord);
    }
    
    public void getPatientNotEquals () {
        Dosage dosage = createDefaultDosage();
        assertNotEquals(dosage.getMedicalRecord(), new MedicalRecord("194", "ALice", "Martin", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", GenderEnum.M));
    }
    
    @Test
    public void getDatePosologieTest() {
        String title = "Gastro";
        NodeAPHP node = new NodeAPHP(NodeEnum.POLE, new ArrayList<>());
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Doctor doctorConsulting = new Doctor("Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        MedicalRecord medicalRecord = new MedicalRecord("194", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", GenderEnum.M);
        Date dateDosage = new Date();
        Diagnostic diagnostic = new Diagnostic();
        String dosagePrescription = "3 pillule à 11h\n 2 avant de se coucher";
        Date beginDosage = new Date();
        Date endDosage = new Date();
        
        Dosage dosage = new Dosage(title, doctorConsulting, medicalRecord, dateDosage, diagnostic, dosagePrescription, beginDosage, endDosage);
        assertEquals(dosage.getDateDosage(), dateDosage);
    }
    
    public void getDatePosologieNotEquals () {
        Dosage dosage = createDefaultDosage();
        assertNotEquals(dosage.getDateDosage(), new Date());
    }
    
    @Test
    public void getDiagnosticTest() {
        String title = "Gastro";
        NodeAPHP node = new NodeAPHP(NodeEnum.POLE, new ArrayList<>());
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Doctor doctorConsulting = new Doctor("Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        MedicalRecord medicalRecord = new MedicalRecord("194", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", GenderEnum.M);
        Date dateDosage = new Date();
        Diagnostic diagnostic = new Diagnostic();
        String dosagePrescription = "3 pillule à 11h\n 2 avant de se coucher";
        Date beginDosage = new Date();
        Date endDosage = new Date();
        
        Dosage dosage = new Dosage(title, doctorConsulting, medicalRecord, dateDosage, diagnostic, dosagePrescription, beginDosage, endDosage);
        assertEquals(dosage.getDiagnostic(), diagnostic);
    }
    
    public void getDiagnosticTestNotEquals () {
        Dosage dosage = createDefaultDosage();
        assertNotEquals(dosage.getDiagnostic(), new Diagnostic());
    }
    
    @Test
    public void getRapportTest() {
        String title = "Gastro";
        NodeAPHP node = new NodeAPHP(NodeEnum.POLE, new ArrayList<>());
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Doctor doctorConsulting = new Doctor("Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        MedicalRecord medicalRecord = new MedicalRecord("194", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", GenderEnum.M);
        Date dateDosage = new Date();
        Diagnostic diagnostic = new Diagnostic();
        String dosagePrescription = "3 pillule à 11h\n 2 avant de se coucher";
        Date beginDosage = new Date();
        Date endDosage = new Date();
        
        Dosage dosage = new Dosage(title, doctorConsulting, medicalRecord, dateDosage, diagnostic, dosagePrescription, beginDosage, endDosage);
        
        assertEquals(dosage.getRepport(), new ArrayList<>());
    }
    
    public void getRapportTestNotEquals () {
        Dosage dosage = createDefaultDosage();
        assertNotEquals(dosage.getRepport(), new ArrayList<>());
    } 
    
    @Test
    public void getDateBeginTest() {
        String title = "Gastro";
        NodeAPHP node = new NodeAPHP(NodeEnum.POLE, new ArrayList<>());
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Doctor doctorConsulting = new Doctor("Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        MedicalRecord medicalRecord = new MedicalRecord("194", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", GenderEnum.M);
        Date dateDosage = new Date();
        Diagnostic diagnostic = new Diagnostic();
        String dosagePrescription = "3 pillule à 11h\n 2 avant de se coucher";
        Date beginDosage = new Date();
        Date endDosage = new Date();
        
        Dosage dosage = new Dosage(title, doctorConsulting, medicalRecord, dateDosage, diagnostic, dosagePrescription, beginDosage, endDosage);
        assertEquals(dosage.getBeginDosage(), beginDosage);
    }
    
    public void getDateBeginTestNotEquals () {
        Dosage dosage = createDefaultDosage();
        assertNotEquals(dosage.getEndDosage(), new Date());
    }
    
    @Test
    public void getDateEndTest() {
        String title = "Gastro";
        NodeAPHP node = new NodeAPHP(NodeEnum.POLE, new ArrayList<>());
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Doctor doctorConsulting = new Doctor("Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        MedicalRecord medicalRecord = new MedicalRecord("194", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", GenderEnum.M);
        Date dateDosage = new Date();
        Diagnostic diagnostic = new Diagnostic();
        String dosagePrescription = "3 pillule à 11h\n 2 avant de se coucher";
        Date beginDosage = new Date();
        Date endDosage = new Date();
        
        Dosage dosage = new Dosage(title, doctorConsulting, medicalRecord, dateDosage, diagnostic, dosagePrescription, beginDosage, endDosage);
        assertEquals(dosage.getEndDosage(), endDosage);
    }
    
    public void getDateEndTestNotEquals () {
        Dosage dosage = createDefaultDosage();
        
        INode node = new NodeAPHP(NodeEnum.POLE, new ArrayList<>());
        IHospitalStaff hospitalStaff = new Nurse("Elodie", "Vincent", "2 rue", "zec@gmail.com", "0770138325", node);
        Date dateDosage = new Date();
        String report = "Tout va bien";

        dosage.addReport(hospitalStaff, dateDosage, report);
        
        assertNotEquals(dosage.getLastReport(), dateDosage);
    }
    
    public void getDateLastRepportTestNotEquals () {
        Dosage dosage = createDefaultDosage();
        INode node = new NodeAPHP(NodeEnum.POLE, new ArrayList<>());
        IHospitalStaff hospitalStaff = new Nurse("Elodie", "Vincent", "2 rue", "zec@gmail.com", "0770138325", node);
        Date dateDosage = new Date();
        String report = "Tout va bien";

        dosage.addReport(hospitalStaff, dateDosage, report);
        
        assertNotEquals(dosage.getLastReport().getCreateDate(), new Date());
    }
    
    @Test
    public void getUserLastRepportTest() {
        Dosage dosage = createDefaultDosage();
        INode node = new NodeAPHP(NodeEnum.POLE, new ArrayList<>());
        IHospitalStaff hospitalStaff = new Nurse("Elodie", "Vincent", "2 rue", "zec@gmail.com", "0770138325", node);
        Date dateDosage = new Date();
        String report = "Tout va bien";
        
        dosage.addReport(hospitalStaff, dateDosage, report);
  
        
        assertEquals(dosage.getLastReport().getSupervisor(), hospitalStaff);
    }
    
    public void getUserRepportTestNotEquals () {
        Dosage dosage = createDefaultDosage();
        
        INode node = new NodeAPHP(NodeEnum.POLE, new ArrayList<>());
        IHospitalStaff hospitalStaff = new Nurse("Elodie", "Vincent", "2 rue", "zec@gmail.com", "0770138325", node);
        Date dateDosage = new Date();
        String report = "Tout va bien";
        
        dosage.addReport(hospitalStaff, dateDosage, report);
        
        IHospitalStaff hospitalStaff2 = new Nurse("Julie", "Vincent", "2 rue", "zec@gmail.com", "0770138325", node);
        
        assertNotEquals(dosage.getLastReport().getSupervisor(), hospitalStaff2);
    }
    
    @Test
    public void getDosagePrescriptionRepportTest() {
        Dosage dosage = createDefaultDosage();
        
        assertEquals(dosage.getDosagePrescription(), "3 pillule à 11h\n 2 avant de se coucher" );
    }
    
    public void getDosagePrescriptionRepportTestNotEquals () {
        Dosage dosage = createDefaultDosage();
        assertNotEquals(dosage.getDosagePrescription(), "Rien à faire");
    }
}
