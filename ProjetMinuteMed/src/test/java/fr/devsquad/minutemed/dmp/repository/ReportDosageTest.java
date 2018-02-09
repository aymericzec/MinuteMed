package fr.devsquad.minutemed.dmp.repository;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package fr.devsquad.minutemed.dmp;
//
//import fr.devsquad.minutemed.arborescence.NodeAPHP;
//import fr.devsquad.minutemed.arborescence.NodeEnum;
//import fr.devsquad.minutemed.staff.IHospitalStaff;
//import fr.devsquad.minutemed.staff.Nurse;
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
//public class ReportDosageTest {
//    
//    public ReportDosageTest() {
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
//    private ReportDosage createDefaultReportDosage () {
//        IHospitalStaff supervisor = new Nurse("Lalie", "Martin", "2 rue", "a@g.fr", "077013834", new NodeAPHP(NodeEnum.POLE, new ArrayList<>()));
//        Date createDate = new Date();
//        String rapport = "Ce client ne va pas bien";;
//        
//        ReportDosage report = new ReportDosage(supervisor, createDate, rapport);
//        
//        return report;
//    }
//    
//    @Test
//    public void createReportDosage() {
//        createDefaultReportDosage();
//    }
//    
//    @Test(expected = NullPointerException.class)
//    public void fieldNullCreate () {
//         ReportDosage report = new ReportDosage(null, null, null);
//    }
//    
//    @Test
//    public void testGetIdEquals () {        
//        ReportDosage report = createDefaultReportDosage();
//        assertEquals(report.getId(), 1l);
//    }
//    
//    @Test
//    public void testGetIdNoEquals () {
//        ReportDosage report = createDefaultReportDosage();
//        assertNotEquals(report.getId(), 2l);
//    }
//    
//    @Test
//    public void testGetSupervisorEquals () {        
//        IHospitalStaff supervisor = new Nurse("Lalie", "Martin", "2 rue", "a@g.fr", "077013834", new NodeAPHP(NodeEnum.POLE, new ArrayList<>()));
//        Date createDate = new Date();
//        String rapport = "Ce client ne va pas bien";;
//        
//        ReportDosage report = new ReportDosage(supervisor, createDate, rapport);
//        assertEquals(report.getSupervisor(), supervisor);
//    }
//    
//    @Test
//    public void testGetSupervisorNoEquals () {
//        ReportDosage report = createDefaultReportDosage();
//        assertNotEquals(report.getSupervisor(), new Nurse("Julie", "Sofia", "2 rue", "a@g.fr", "077013834", new NodeAPHP(NodeEnum.POLE, new ArrayList<>())));
//    }
//    
//    @Test
//    public void testGetDateEquals () {        
//        IHospitalStaff supervisor = new Nurse("Lalie", "Martin", "2 rue", "a@g.fr", "077013834", new NodeAPHP(NodeEnum.POLE, new ArrayList<>()));
//        Date createDate = new Date();
//        String rapport = "Ce client ne va pas bien";;
//        
//        ReportDosage report = new ReportDosage(supervisor, createDate, rapport);
//        assertEquals(report.getCreateDate(), createDate);
//    }
//    
//    @Test
//    public void testGetDateNoEquals () {
//        ReportDosage report = createDefaultReportDosage();
//        assertNotEquals(report.getCreateDate(), new Date());
//    }
//    
//    @Test
//    public void testGetDescriptionEquals () {
//        IHospitalStaff supervisor = new Nurse("Lalie", "Martin", "2 rue", "a@g.fr", "077013834", new NodeAPHP(NodeEnum.POLE, new ArrayList<>()));
//        Date createDate = new Date();
//        String rapport = "Ce client ne va pas bien";
//        
//        ReportDosage report = new ReportDosage(supervisor, createDate, rapport);
//
//        assertEquals(report.getRapport(), rapport);
//    }
//    
//    @Test
//    public void testGetDescriptionNoEquals () {
//        ReportDosage report = createDefaultReportDosage();
//        assertNotEquals(report.getRapport(), "Ceci n'est pas une description");
//    }
//}

import fr.devsquad.minutemed.dmp.*;

