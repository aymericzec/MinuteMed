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
public class DiagnosticTest {
    
    public DiagnosticTest() {
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
    
    private Diagnostic createDiagnostic () {
        long id = 1;
        String title = "Radiologie du fémur";
        IDoctor diagnotic = new IDoctor();
        IPatient patient = new IPatient();
        Date consultDiagnostic = new Date();
        String description = "Chute à vélo, demande dun' radio";
        
        List<IAnnex> annexs = new ArrayList();
        annexs.add(new IAnnex());
        
        
        Diagnostic diag = new Diagnostic(id, title, patient, consultDiagnostic, description, annexs);
        
        return diag;
    }
    
    @Test
    public void createDiagnosticTest() {
        createDiagnotic();
    }
    
    @Test(expected = NullPointerException.class)
    public void fieldNullCreate () {
        Diagnostic diagnotic = new Diagnostic(null, null, null, null, null, null);
    }
    
    @Test
    public void testGetIdEquals () {        
        Diagnostic diagnotic = createDiagnostic();
        assertEquals(diagnotic.getId(), 1l);
    }
    
    @Test
    public void testGetIdNoEquals () {
        Diagnostic diagnostic = createDiagnostic();
        assertNotEquals(diagnostic.getId(), 2l);
    }
    
    @Test
    public void testGetTitleEquals () {        
        Diagnostic diagnotic = createDiagnostic();
        assertEquals(diagnotic.getTitle(), "Radiologie du fémur");
    }
    
    @Test
    public void testGetTitleNoEquals () {
        Diagnostic diagnostic = createDiagnostic();
        assertNotEquals(diagnostic.getTitle(), "pop");
    }
    
    @Test
    public void testGetDiagnoticDoctorEquals () {        
        long id = 1;
        String title = "Radiologie du fémur";
        IDoctor diagnostic = new IDoctor();
        IPatient patient = new IPatient();
        Date consultDiagnostic = new Date();
        String description = "Chute à vélo, demande dun' radio";
        
        List<IAnnex> annexs = new ArrayList();
        annexs.add(new IAnnex());
        
        
        Diagnostic diag = new Diagnostic(id, title, diagnostic, patient, consultDiagnostic, description, annexs);
        
        assertEquals(diag.getDoctorDiagnostic(), diagnostic);
    }
    
    @Test
    public void testGetDiagnoticDoctorNoEquals () {
        Diagnostic diagnostic = createDiagnostic();
        assertNotEquals(diagnostic.getDoctorDiagnostic(), new IDoctor());
    }
    
    @Test
    public void testGetPatientEquals () {
       long id = 1;
        String title = "Radiologie du fémur";
        IDoctor diagnostic = new IDoctor();
        IPatient patient = new IPatient();
        Date consultDiagnostic = new Date();
        String description = "Chute à vélo, demande dun' radio";
        
        List<IAnnex> annexs = new ArrayList();
        annexs.add(new IAnnex());
        
        
        Diagnostic diag = new Diagnostic(id, title, diagnostic, patient, consultDiagnostic, description, annexs);
        assertEquals(diag.getPatient(), diagnostic);
    }
    
    @Test
    public void testGetPatientNoEquals () {
        Diagnostic diagnostic = createDiagnostic();
        assertNotEquals(diagnostic.getPatient(), new IPatient());
    }
    
    @Test
    public void testGetDateEquals () {
        long id = 1;
        String title = "Radiologie du fémur";
        IDoctor diagnostic = new IDoctor();
        IPatient patient = new IPatient();
        Date consultDiagnostic = new Date();
        String description = "Chute à vélo, demande dun' radio";
        
        List<IAnnex> annexs = new ArrayList();
        annexs.add(new IAnnex());
        
        
        Diagnostic diag = new Diagnostic(id, title, diagnostic, patient, consultDiagnostic, description, annexs);
        assertEquals(diag.getDateConsulting(), consultDiagnostic);
    }
    
    @Test
    public void testGetDateNoEquals () {
        Diagnostic diagnostic = createDiagnostic();
        assertNotEquals(diagnostic.getDateConsulting(), new Date());
    }
    
    @Test
    public void testGetDescriptionEquals () {
        long id = 1;
        String title = "Radiologie du fémur";
        IDoctor diagnostic = new IDoctor();
        IPatient patient = new IPatient();
        Date consultDiagnostic = new Date();
        String description = "Chute à vélo, demande dun' radio";
        
        List<IAnnex> annexs = new ArrayList();
        annexs.add(new IAnnex());
        
        
        Diagnostic diag = new Diagnostic(id, title, diagnostic, patient, consultDiagnostic, description, annexs);
        assertEquals(diag.getDescription(), description);
    }
    
    @Test
    public void testGetDescriptionNoEquals () {
        Diagnostic diagnostic = createDiagnostic();
        assertNotEquals(diagnostic.getDescription(), "toto");
    }
    
    @Test
    public void testGetAnnexEquals () {
        long id = 1;
        String title = "Radiologie du fémur";
        IDoctor diagnostic = new IDoctor();
        IPatient patient = new IPatient();
        Date consultDiagnostic = new Date();
        String description = "Chute à vélo, demande dun' radio";
        
        List<IAnnex> annexs = new ArrayList();
        annexs.add(new IAnnex());
        
        
        Diagnostic diag = new Diagnostic(id, title, diagnostic, patient, consultDiagnostic, description, annexs);
        assertEquals(diag.getAnnexes(), annexs);
    }
    
    @Test
    public void testGetAnnexNoEquals () {
        Diagnostic diagnostic = createDiagnostic();
        assertNotEquals(diagnostic.getAnnexes(), new ArrayList<>());
    }
}
