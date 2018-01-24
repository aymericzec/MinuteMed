/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.dmp;

import fr.devsquad.minutemed.database.IDoctor;
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
public class PrescriptionTest {
    
    public PrescriptionTest() {
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
    
    private Prescription createTestPrescription() {
        long id = 1;
        String title = "Ordonnance rhume";
        IDoctor prescriptor = new IDoctor();
        IPatient patient = new IPatient();
        Date consultDate = new Date();
        DiagnosticTest diagnostic = new DiagnosticTest();
        String prescription = "doliprane, spray nasale";
        List<IAnnex> annexes = new ArrayList();

        Prescription pres = new Prescription(id, title, prescriptor, patient, consultDate, diagnostic, prescription, annexes);

        return pres;
    }
    
    @Test
    public void createPrescription() {
        createTestPrescription();
    }
    
    @Test(expected = NullPointerException.class)
    public void createNullPrescription() {
        long id = 1;
        String title = null;
        IDoctor prescriptor = null;
        IPatient patient = null;
        Date consultDate = null;
        DiagnosticTest diagnostic = null;
        String prescription = null;
        List<IAnnex> annexes = null;

        Prescription pres = new Prescription(id, title, prescriptor, patient, consultDate, diagnostic, prescription, annexes);
    }
    
    @Test
    public void testGetIdEquals () {        
        Prescription prescription = createTestPrescription();
        assertEquals(prescription.getId(), 1l);
    }
    
    @Test
    public void testGetIdNoEquals () {        
        Prescription prescription = createTestPrescription();
        assertNotEquals(prescription.getId(), 2l);
    }
    
    @Test
    public void testGetTitleEquals () {        
        Prescription prescription = createTestPrescription();
        assertEquals(prescription.getTitle(), "doliprane, spray nasale");
    }
    
    @Test
    public void testGetTitleNoEquals () {        
        Prescription prescription = createTestPrescription();
        assertNotEquals(prescription.getTitle(), "bad");
    }
    
    @Test
    public void testGetDoctorEquals () {        
        long id = 1;
        String title = "Ordonnance rhume";
        IDoctor prescriptor = new IDoctor();
        IPatient patient = new IPatient();
        Date consultDate = new Date();
        DiagnosticTest diagnostic = new DiagnosticTest();
        String prescription = "doliprane, spray nasale";
        List<IAnnex> annexes = new ArrayList();

        Prescription pres = new Prescription(id, title, prescriptor, patient, consultDate, diagnostic, prescription, annexes);

        assertEquals(pres.getDoctorPrescriptor(), prescriptor);
    }
    
    @Test
    public void testGetDoctorNoEquals () {        
        Prescription prescription = createTestPrescription();
        assertNotEquals(prescription.getDoctorPrescriptor(), new IDoctor());
    }
    
    @Test
    public void testGetPatientEquals () {        
        long id = 1;
        String title = "Ordonnance rhume";
        IDoctor prescriptor = new IDoctor();
        IPatient patient = new IPatient();
        Date consultDate = new Date();
        DiagnosticTest diagnostic = new DiagnosticTest();
        String prescription = "doliprane, spray nasale";
        List<IAnnex> annexes = new ArrayList();

        Prescription pres = new Prescription(id, title, prescriptor, patient, consultDate, diagnostic, prescription, annexes);

        assertEquals(pres.getPatient(), patient);
    }
    
    @Test
    public void testGetPatientNoEquals () {        
        Prescription prescription = createTestPrescription();
        assertNotEquals(prescription.getPatient(), new IPatient());
    }
    
    @Test
    public void testGetDateEquals () {        
        long id = 1;
        String title = "Ordonnance rhume";
        IDoctor prescriptor = new IDoctor();
        IPatient patient = new IPatient();
        Date consultDate = new Date();
        DiagnosticTest diagnostic = new DiagnosticTest();
        String prescription = "doliprane, spray nasale";
        List<IAnnex> annexes = new ArrayList();

        Prescription pres = new Prescription(id, title, prescriptor, patient, consultDate, diagnostic, prescription, annexes);

        assertEquals(pres.getDateConsulting(), consultDate);
    }
    
    @Test
    public void testGetDateNoEquals () {        
        Prescription prescription = createTestPrescription();
        assertNotEquals(prescription.getDateConsulting(), new Date());
    }

    @Test
    public void testGetDiagnotic () {        
        long id = 1;
        String title = "Ordonnance rhume";
        IDoctor prescriptor = new IDoctor();
        IPatient patient = new IPatient();
        Date consultDate = new Date();
        DiagnosticTest diagnostic = new DiagnosticTest();
        String prescription = "doliprane, spray nasale";
        List<IAnnex> annexes = new ArrayList();

        Prescription pres = new Prescription(id, title, prescriptor, patient, consultDate, diagnostic, prescription, annexes);

        assertEquals(pres.getDiagnotic(), diagnostic);
    }
    
    @Test
    public void testGetDiagnoticNotEquals () {        
        Prescription prescription = createTestPrescription();
        assertNotEquals(prescription.getDiagnotic(), new DiagnosticTest());
    }

    @Test
    public void testGetPrescription () {        
        long id = 1;
        String title = "Ordonnance rhume";
        IDoctor prescriptor = new IDoctor();
        IPatient patient = new IPatient();
        Date consultDate = new Date();
        DiagnosticTest diagnostic = new DiagnosticTest();
        String prescription = "doliprane, spray nasale";
        List<IAnnex> annexes = new ArrayList();

        Prescription pres = new Prescription(id, title, prescriptor, patient, consultDate, diagnostic, prescription, annexes);

        assertEquals(pres.getPrescription(), prescription);
    }
    
    @Test
    public void testGetPrescriptionNotEquals () {        
        Prescription prescription = createTestPrescription();
        assertNotEquals(prescription.getPrescription(), "lol");
    } 
    
    @Test
    public void testGetAnnexes () {        
        long id = 1;
        String title = "Ordonnance rhume";
        IDoctor prescriptor = new IDoctor();
        IPatient patient = new IPatient();
        Date consultDate = new Date();
        DiagnosticTest diagnostic = new DiagnosticTest();
        String prescription = "doliprane, spray nasale";
        List<IAnnex> annexes = new ArrayList();

        Prescription pres = new Prescription(id, title, prescriptor, patient, consultDate, diagnostic, prescription, annexes);

        assertEquals(pres.getAnnexes(), prescription);
    }
    
    @Test
    public void testGetAnnexesNotEquals () {        
        Prescription prescription = createTestPrescription();
        assertNotEquals(prescription.getAnnexes(), new ArrayList<>());
    } 
}
