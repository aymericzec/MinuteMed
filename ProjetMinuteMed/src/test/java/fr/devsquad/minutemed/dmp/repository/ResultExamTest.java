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
//public class ResultExamTest {
//
//    public ResultExamTest() {
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
//    private ResultExam createTestResultExam() {
//        Doctor examinator = new Doctor("Frederic", "Marti", "5 rue caude siche", "a.o.fr", "0770138475", new NodeAPHP(NodeEnum.POLE, new ArrayList<>()), new Specialization(SpecializationEnum.Pediatrie));
//        Date examDate = new Date();
//        String result = "fracture";
//
//        ResultExam rs = new ResultExam(examinator, examDate, result);
//        return rs;
//    }
//
//    @Test
//    public void createResultExam() {
//        createTestResultExam();
//    }
//
//    @Test(expected = NullPointerException.class)
//    public void createNullResultExam() {
//        ResultExam rs = new ResultExam(null, null, null);
//    }
//
//    @Test
//    public void getFiles() {
//        ResultExam re = createTestResultExam();
//        re.addFiles("fichier.jpg");
//
//        String s = re.getFiles().get(0);
//        
//        assertEquals(s, "fichier.jpg");
//    }
//    
//    @Test
//    public void getFilesNotEqual() {
//        ResultExam re = createTestResultExam();
//        re.addFiles("fichier.jpg");
//
//        String s = re.getFiles().get(0);
//        
//        assertNotEquals(s, "a");
//    }
//
//    public void getResultTest() {
//        ResultExam re = createTestResultExam();
//        assertEquals(re.getResult(), "fracture");
//    }
//    
//    @Test
//    public void getResultNotEqual() {
//        ResultExam re = createTestResultExam();
//        assertNotEquals(re.getResult(), "toto");
//    }
//    
//    @Test
//    public void getDateExaminate() {
//        Doctor examinator = new Doctor("Frederic", "Marti", "5 rue caude siche", "a.o.fr", "0770138475", new NodeAPHP(NodeEnum.POLE, new ArrayList<>()), new Specialization(SpecializationEnum.Pediatrie));
//        Date examDate = new Date();
//        String result = "fracture";
//
//        ResultExam rs = new ResultExam(examinator, examDate, result);
//        
//        assertEquals(rs.getExamDate(), examDate);
//    }
//    
//    @Test
//    public void getDateExaminateNotEqual() {
//        ResultExam re = createTestResultExam();
//        assertNotEquals(re.getExamDate(), new Date());
//    }
//   
//}

import fr.devsquad.minutemed.dmp.*;

