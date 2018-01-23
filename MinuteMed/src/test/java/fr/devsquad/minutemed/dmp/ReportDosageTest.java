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
public class ReportDosageTest {
    
    public ReportDosageTest() {
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
    
    private ReportDosage createDefaultReportDosage () {
        long id = 1;
        IUser supervisor = new IUser();
        Date createDate = new Date();
        String rapport = "Ce client ne va pas bien";
        
        
        ReportDosage report = new ReportDosage(id, supervisor, createDate, rapport);
        
        return report;
    }
    
    @Test
    public void createReportDosage() {
        createDefaultReportDosage();
    }
    
    @Test(expected = NullPointerException.class)
    public void fieldNullCreate () {
         ReportDosage report = new Exam(1, null, null, null);
    }
    
    @Test
    public void testGetIdEquals () {        
        ReportDosage report = createDefaultReportDosage();
        assertEquals(report.getId(), 1l);
    }
    
    @Test
    public void testGetIdNoEquals () {
        ReportDosage report = createDefaultReportDosage();
        assertNotEquals(report.getId(), 2l);
    }
    
    @Test
    public void testGetSupervisorEquals () {        
        long id = 1;
        IUser supervisor = new IUser();
        Date createDate = new Date();
        String rapport = "Ce client ne va pas bien";
        
        ReportDosage report = new ReportDosage(id, supervisor, createDate, rapport);
        assertEquals(report.getSupervisor(), supervisor);
    }
    
    @Test
    public void testGetSupervisorNoEquals () {
        ReportDosage report = createDefaultReportDosage();
        assertNotEquals(report.getSupervisor(), new IUser());
    }
    
    @Test
    public void testGetDateEquals () {        
        long id = 1;
        IUser supervisor = new IUser();
        Date createDate = new Date();
        String rapport = "Ce client ne va pas bien";
        
        ReportDosage report = new ReportDosage(id, supervisor, createDate, rapport);
        assertEquals(report.getDate(), createDate);
    }
    
    @Test
    public void testGetDateNoEquals () {
        ReportDosage report = createDefaultReportDosage();
        assertNotEquals(report.getDate(), new Date());
    }
    
    @Test
    public void testGetDescriptionEquals () {
        long id = 1;
        IUser supervisor = new IUser();
        Date createDate = new Date();
        String rapport = "Ce client ne va pas bien";
        
        ReportDosage report = new ReportDosage(id, supervisor, createDate, rapport);

        assertEquals(report.getDescription(), rapport);
    }
    
    @Test
    public void testGetDescriptionNoEquals () {
        ReportDosage report = createDefaultReportDosage();
        assertNotEquals(report.getDescription(), "Ceci n'est pas une description");
    }
}
