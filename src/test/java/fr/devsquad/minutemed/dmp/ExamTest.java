///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package fr.devsquad.minutemed.dmp;
//
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
//public class ExamTest {
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
//    private Exam createDefaultExamWithOutExaminator () {
//        long id = 1;
//        String title = "Radiologie du fémur";
//        //Doctor askExam = new Doctor(1L, "Aymeric", "Zecchini", "2 rue", "z@gmail.com", "0770138333", null, Specialization.Allergologie);
//        Doctor askExam = new Doctor();
//        MedicalRecord patient = new MedicalRecord();
//        Date consultExam = new Date();
//        String description = "Chute à vélo, demande dun' radio";
//              
//        Exam exam = new Exam(title, askExam, patient, consultExam, description);
//        
//        return exam;
//    }
//    
//    private Exam createDefaultExamWithExaminator () {
//        long id = 1;
//        String title = "Radiologie du fémur";
//        Doctor askExam = new Doctor();
//        MedicalRecord patient = new MedicalRecord();
//        Date consultExam = new Date();
//        String description = "Chute à vélo, demande dun' radio";
//        
//        List<IAnnex> annexs = new ArrayList();
//        annexs.add(new IAnnex());
//         
//        Exam exam = new Exam(id, title, askExam, patient, consultExam, description, annexs);
//    
//        ResultExamTest resultExam = new ResultExamTest();
//        exam.setResultExam(resultExam);
//        
//        return exam;
//    }
//    
//    @Test
//    public void createExam() {
//        createDefaultExam();
//    }
//    
//    @Test(expected = NullPointerException.class)
//    public void fieldNullCreate () {
//        Exam exam = new Exam(null, null, null, null, null, null, null);
//    }
//    
//    @Test
//    public void testGetIdEquals () {        
//        Exam exam = createDefaultExamWithOutExaminator();
//        assertEquals(exam.getId(), 1l);
//    }
//    
//    @Test
//    public void testGetIdNoEquals () {
//        Exam exam = createDefaultExamWithOutExaminator();
//        assertNotEquals(exam.getId(), 2l);
//    }
//    
//    @Test
//    public void testGetTitleEquals () {
//        Exam exam = createDefaultExamWithOutExaminator();
//        assertEquals(exam.getTitle(), "Radiologie du fémur");
//    }
//    
//    @Test
//    public void testGetTitleNoEquals () {
//        Exam exam = createDefaultExamWithOutExaminator();
//        assertNotEquals(exam.getTitle(), "OUPS");
//    }
//    
//    @Test
//    public void testGetDoctorAskExaminationEquals () {
//        long id = 1;
//        String title = "Radiologie du fémur";
//        Doctor askExam = new Doctor();
//        MedicalRecord patient = new MedicalRecord();
//        Date consultExam = new Date();
//        String description = "Chute à vélo, demande dun' radio";
//        
//        List<IAnnex> annexs = new ArrayList();
//        annexs.add(new IAnnex());
//        
//        
//        Exam exam = new Exam(id, title, askExam, patient, consultExam, description, annexs);
//        assertEquals(exam.getDoctorAskExamination(), askExam);
//    }
//    
//    @Test
//    public void testGetDoctorAskExaminationNoEquals () {
//        Exam exam = createDefaultExamWithOutExaminator();
//        assertNotEquals(exam.getDoctorAskExamination(), new Doctor());
//    }
//    
//    @Test
//    public void testGetDoctorExaminatorEquals () {
//        long id = 1;
//        String title = "Radiologie du fémur";
//        Doctor askExam = new Doctor();
//        Doctor examinator = new Doctor();
//        MedicalRecord patient = new MedicalRecord();
//        Date consultExam = new Date();
//        String description = "Chute à vélo, demande dun' radio";
//        
//        List<IAnnex> annexs = new ArrayList();
//        annexs.add(new IAnnex());
//        
//        
//        Exam exam = new Exam(id, title, askExam, examinator, patient, consultExam, description, annexs);
//        assertEquals(exam.getDoctorExaminator(), examinator);
//    }
//   
//    /* L'information sera contenu dans Result Exam, Suppresion du champs examinator de la classe Exam
//    @Test
//    public void testGetDoctorExaminatorNoEquals () {
//        Exam exam = createDefaultExamWithExaminator();
//        assertNotEquals(exam.getDoctorExaminator(), new Doctor());
//    }
//    
//    @Test
//    public void testGetDoctorExaminatorNoEquals () {
//        Exam exam = createDefaultExamWithOutExaminator();
//        assertNull(exam.getDoctorExaminator());
//    }*/
//    
//    @Test
//    public void testGetPatientEquals () {
//          long id = 1;
//        String title = "Radiologie du fémur";
//        Doctor askExam = new Doctor();
//        MedicalRecord patient = new MedicalRecord();
//        Date consultExam = new Date();
//        String description = "Chute à vélo, demande dun' radio";
//        
//        List<IAnnex> annexs = new ArrayList();
//        annexs.add(new IAnnex());
//        
//        
//        Exam exam = new Exam(id, title, askExam, patient, consultExam, description, annexs);
//        assertEquals(exam.getPatient(), patient);
//    }
//    
//    @Test
//    public void testGetPatientNoEquals () {
//        Exam exam = createDefaultExamWithExaminator();
//        assertNotEquals(exam.getPatient(), new MedicalRecord());
//    }
//    
//    @Test
//    public void testGetDateEquals () {
//        long id = 1;
//        String title = "Radiologie du fémur";
//        Doctor askExam = new Doctor();
//        MedicalRecord patient = new MedicalRecord();
//        Date consultExam = new Date();
//        String description = "Chute à vélo, demande dun' radio";
//        
//        List<IAnnex> annexs = new ArrayList();
//        annexs.add(new IAnnex());
//        
//        
//        Exam exam = new Exam(id, title, askExam, patient, consultExam, description, annexs);
//        assertEquals(exam.getDate(), consultExam);
//    }
//    
//    @Test
//    public void testGetExamNoEquals () {
//        Exam exam = createDefaultExamWithExaminator();
//        assertNotEquals(exam.getDate(), new Date());
//    }
//    
//    @Test
//    public void testGetDescriptionEquals () {
//          long id = 1;
//        String title = "Radiologie du fémur";
//        Doctor askExam = new Doctor();
//        MedicalRecord patient = new MedicalRecord();
//        Date consultExam = new Date();
//        String description = "Chute à vélo, demande dun' radio";
//        
//        List<IAnnex> annexs = new ArrayList();
//        annexs.add(new IAnnex());
//        
//        
//        Exam exam = new Exam(id, title, askExam, patient, consultExam, description, annexs);
//        assertEquals(exam.getDescription(), description);
//    }
//    
//    @Test
//    public void testGetDescriptionNoEquals () {
//        Exam exam = createDefaultExamWithExaminator();
//        assertNotEquals(exam.getDescription(), "Ceci n'est pas une description");
//    }
//    
//    @Test
//    public void testGetAnnexEquals () {
//          long id = 1;
//        String title = "Radiologie du fémur";
//        Doctor askExam = new Doctor();
//        MedicalRecord patient = new MedicalRecord();
//        Date consultExam = new Date();
//        String description = "Chute à vélo, demande dun' radio";
//        
//        List<IAnnex> annexs = new ArrayList();
//        annexs.add(new IAnnex());
//        
//        
//        Exam exam = new Exam(id, title, askExam, patient, consultExam, description, annexs);
//        assertEquals(exam.getAnnexs(), annexs);
//    }
//    
//    @Test
//    public void testGetAnnexNoEquals () {
//        Exam exam = createDefaultExamWithExaminator();
//        assertNotEquals(exam.getAnnexs(), new ArrayList<IAnnex>());
//    }
//    
//    @Test
//    public void testSetResultExam () {        
//        Exam exam = createDefaultExamWithOutExaminator();
//        ResultExamTest resultExam = new ResultExamTest();
//        exam.setResultExam(resultExam);
//    }
//    
//    @Test(expected = NullPointerException.class)
//    public void testSetNullResultExam () {        
//        Exam exam = createDefaultExamWithOutExaminator();
//        exam.setResultExam(null);
//    }
//    
//    @Test
//    public void testGetResultExamEquals () {
//        Exam exam = createDefaultExamWithOutExaminator();
//        ResultExamTest resultExam = new ResultExamTest();
//        exam.setResultExam(resultExam);
//        assertNotEquals(exam.getResultExam(), resultExam);
//    }
//    
//    @Test
//    public void testGetResultExamNoEquals () {
//        Exam exam = createDefaultExamWithOutExaminator();
//        ResultExamTest resultExam = new ResultExamTest();
//        exam.setResultExam(resultExam);
//        ResultExamTest resultExam2 = new ResultExamTest();
//        assertNotEquals(exam.getResultExam(), resultExam2);
//    }
//    
//    @Test
//    public void testGetResultExamNull () {
//        Exam exam = createDefaultExamWithOutExaminator();
//        assertNull(exam.getResultExam());
//    }
//}
