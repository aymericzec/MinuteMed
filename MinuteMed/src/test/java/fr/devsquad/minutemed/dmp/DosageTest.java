/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.dmp;

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
        long id = 1;
        String title = "Gastro";
        IDoctor doctorConsulting = new IDoctor();
        IPatient patient = new IPatient();
        Date dateDosage = new Date();
        Diagnostic diagnostic = new Diagnostic();
        String dosagePrescription = "3 pillule à 11h\n 2 avant de se coucher";
        List<IAnnex> annexes = new ArrayList<IAnnex>();
        List<ReportDosage> repport = new ArrayList<>();
        Date beginDosage = new Date();
        Date endDosage = new Date();
        
        Dosage dosage = new Dosage(title, doctorConsulting, patient, dateDosage, diagnostic, dosagePrescription, annexes, repport, beginDosage, endDosage);
        
        return dosage;
    }
    
    @Test
    public void createDosageTest() {
        createDefaultDosage();
    }
    
    @Test(expected = NullPointerException.class)
    public void createDosageTestNull () {
        Dosage dosage = new Dosage(null, null, null, null, null, null, null, null, null, null);
    }
    
    @Test
    public void getTitleTest() {
        Dosage dosage = createDefaultDosage();
        assertEquals(dosage.getTitle(), "Oupla");
    }
    
    public void getTitleTestNotEquals () {
        Dosage dosage = createDefaultDosage();
        assertNotEquals(dosage.getTitle(), "Gastro");
    }
    
    @Test
    public void getDoctorConsultingTest() {
        long id = 1;
        String title = "Gastro";
        IDoctor doctorConsulting = new IDoctor();
        IPatient patient = new IPatient();
        Date dateDosage = new Date();
        Diagnostic diagnostic = new Diagnostic();
        String dosagePrescription = "3 pillule à 11h\n 2 avant de se coucher";
        List<IAnnex> annexes = new ArrayList<IAnnex>();
        List<ReportDosage> repport = new ArrayList<>();
        Date beginDosage = new Date();
        Date endDosage = new Date();
        
        Dosage dosage = new Dosage(title, doctorConsulting, patient, dateDosage, diagnostic, dosagePrescription, annexes, repport, beginDosage, endDosage);
        assertEquals(dosage.getDoctor(), doctorConsulting);
    }
    
    public void getDoctorConsultingTestNotEquals () {
        Dosage dosage = createDefaultDosage();
        assertNotEquals(dosage.getTitle(), new IDoctor());
    }
    
     
    @Test
    public void getPatientTest() {
        long id = 1;
        String title = "Gastro";
        IDoctor doctorConsulting = new IDoctor();
        IPatient patient = new IPatient();
        Date dateDosage = new Date();
        Diagnostic diagnostic = new Diagnostic();
        String dosagePrescription = "3 pillule à 11h\n 2 avant de se coucher";
        List<IAnnex> annexes = new ArrayList<IAnnex>();
        List<ReportDosage> repport = new ArrayList<>();
        Date beginDosage = new Date();
        Date endDosage = new Date();
        
        Dosage dosage = new Dosage(title, doctorConsulting, patient, dateDosage, diagnostic, dosagePrescription, annexes, repport, beginDosage, endDosage);
        assertEquals(dosage.getPatient(), patient);
    }
    
    public void getPatientNotEquals () {
        Dosage dosage = createDefaultDosage();
        assertNotEquals(dosage.getTitle(), new IPatient());
    }
    
    @Test
    public void getDatePosologieTest() {
        long id = 1;
        String title = "Gastro";
        IDoctor doctorConsulting = new IDoctor();
        IPatient patient = new IPatient();
        Date dateDosage = new Date();
        Diagnostic diagnostic = new Diagnostic();
        String dosagePrescription = "3 pillule à 11h\n 2 avant de se coucher";
        List<IAnnex> annexes = new ArrayList<IAnnex>();
        List<ReportDosage> repport = new ArrayList<>();
        Date beginDosage = new Date();
        Date endDosage = new Date();
        
        Dosage dosage = new Dosage(title, doctorConsulting, patient, dateDosage, diagnostic, dosagePrescription, annexes, repport, beginDosage, endDosage);
        assertEquals(dosage.getDateCreate(), dateDosage);
    }
    
    public void getDatePosologieNotEquals () {
        Dosage dosage = createDefaultDosage();
        assertNotEquals(dosage.getDateCreate(), new Date());
    }
    
    @Test
    public void getDiagnosticTest() {
        long id = 1;
        String title = "Gastro";
        IDoctor doctorConsulting = new IDoctor();
        IPatient patient = new IPatient();
        Date dateDosage = new Date();
        Diagnostic diagnostic = new Diagnostic();
        String dosagePrescription = "3 pillule à 11h\n 2 avant de se coucher";
        List<IAnnex> annexes = new ArrayList<IAnnex>();
        List<ReportDosage> repport = new ArrayList<>();
        Date beginDosage = new Date();
        Date endDosage = new Date();
        
        Dosage dosage = new Dosage(title, doctorConsulting, patient, dateDosage, diagnostic, dosagePrescription, annexes, repport, beginDosage, endDosage);
        assertEquals(dosage.getDiagnostic(), diagnostic);
    }
    
    public void getDiagnosticTestNotEquals () {
        Dosage dosage = createDefaultDosage();
        assertNotEquals(dosage.getDiagnostic(), new Diagnostic());
    }
    
    @Test
    public void getAnnexesTest() {
        long id = 1;
        String title = "Gastro";
        IDoctor doctorConsulting = new IDoctor();
        IPatient patient = new IPatient();
        Date dateDosage = new Date();
        Diagnostic diagnostic = new Diagnostic();
        String dosagePrescription = "3 pillule à 11h\n 2 avant de se coucher";
        List<IAnnex> annexes = new ArrayList<IAnnex>();
        List<ReportDosage> repport = new ArrayList<>();
        Date beginDosage = new Date();
        Date endDosage = new Date();
        
        Dosage dosage = new Dosage(title, doctorConsulting, patient, dateDosage, diagnostic, dosagePrescription, annexes, repport, beginDosage, endDosage);
        assertEquals(dosage.getAnnexes(), annexes);
    }
    
    public void getAnnexesTestNotEquals () {
        Dosage dosage = createDefaultDosage();
        assertNotEquals(dosage.getAnnexes(), new ArrayList<IAnnex>());
    }
    
    @Test
    public void getRapportTest() {
        long id = 1;
        String title = "Gastro";
        IDoctor doctorConsulting = new IDoctor();
        IPatient patient = new IPatient();
        Date dateDosage = new Date();
        Diagnostic diagnostic = new Diagnostic();
        String dosagePrescription = "3 pillule à 11h\n 2 avant de se coucher";
        List<IAnnex> annexes = new ArrayList<IAnnex>();
        List<ReportDosage> repport = new ArrayList<>();
        Date beginDosage = new Date();
        Date endDosage = new Date();
        
        Dosage dosage = new Dosage(title, doctorConsulting, patient, dateDosage, diagnostic, dosagePrescription, annexes, repport, beginDosage, endDosage);
        assertEquals(dosage.getRepports(), repport);
    }
    
    public void getRapportTestNotEquals () {
        Dosage dosage = createDefaultDosage();
        assertNotEquals(dosage.getRepports(), new ArrayList<>());
    } 
    
    @Test
    public void getDateBeginTest() {
        long id = 1;
        String title = "Gastro";
        IDoctor doctorConsulting = new IDoctor();
        IPatient patient = new IPatient();
        Date dateDosage = new Date();
        Diagnostic diagnostic = new Diagnostic();
        String dosagePrescription = "3 pillule à 11h\n 2 avant de se coucher";
        List<IAnnex> annexes = new ArrayList<IAnnex>();
        List<ReportDosage> repport = new ArrayList<>();
        Date beginDosage = new Date();
        Date endDosage = new Date();
        
        Dosage dosage = new Dosage(title, doctorConsulting, patient, dateDosage, diagnostic, dosagePrescription, annexes, repport, beginDosage, endDosage);
        assertEquals(dosage.getDateBegin(), beginDosage);
    }
    
    public void getDateBeginTestNotEquals () {
        Dosage dosage = createDefaultDosage();
        assertNotEquals(dosage.getDateBegin(), new Date());
    }
    
    @Test
    public void getDateEndTest() {
        long id = 1;
        String title = "Gastro";
        IDoctor doctorConsulting = new IDoctor();
        IPatient patient = new IPatient();
        Date dateDosage = new Date();
        Diagnostic diagnostic = new Diagnostic();
        String dosagePrescription = "3 pillule à 11h\n 2 avant de se coucher";
        List<IAnnex> annexes = new ArrayList<IAnnex>();
        List<ReportDosage> repport = new ArrayList<>();
        Date beginDosage = new Date();
        Date endDosage = new Date();
        
        Dosage dosage = new Dosage(title, doctorConsulting, patient, dateDosage, diagnostic, dosagePrescription, annexes, repport, beginDosage, endDosage);
        assertEquals(dosage.getDateEnd(), endDosage);
    }
    
    public void getDateEndTestNotEquals () {
        Dosage dosage = createDefaultDosage();
        assertNotEquals(dosage.getDateEnd(), new Date());
    }
    
        public void getDateBeginTestNotEquals () {
        Dosage dosage = createDefaultDosage();
        assertNotEquals(dosage.getDateBegin(), new Date());
    }
    
    @Test
    public void getDateLastRepportTest() {
        Dosage dosage = createDefaultDosage();
        
        assertEquals(dosage.getDateLastRepport(), new Date());
    }
    
    public void getDateLastRepportTestNotEquals () {
        Dosage dosage = createDefaultDosage();
        assertNotEquals(dosage.getDateLastRepport(), new Date());
    }
    
    @Test
    public void getUserLastRepportTest() {
        Dosage dosage = createDefaultDosage();
        
        assertEquals(dosage.getUserLastRepport(), new IUser());
    }
    
    public void getUserRepportTestNotEquals () {
        Dosage dosage = createDefaultDosage();
        assertNotEquals(dosage.getUserLastRepport(), new IUser());
    }
    
    @Test
    public void getDosagePrescriptionRepportTest() {
        Dosage dosage = createDefaultDosage();
        
        assertEquals(dosage.getDosage(), "3 pillule à 11h\n 2 avant de se coucher" );
    }
    
    public void getDosagePrescriptionRepportTestNotEquals () {
        Dosage dosage = createDefaultDosage();
        assertNotEquals(dosage.getDosage(), "Rien à faire");
    }
}
