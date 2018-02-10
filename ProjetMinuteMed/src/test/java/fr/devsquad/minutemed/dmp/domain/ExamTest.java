package fr.devsquad.minutemed.dmp.domain;

import fr.devsquad.minutemed.arborescence.domain.Node;
import fr.devsquad.minutemed.arborescence.domain.NodeEnum;
import fr.devsquad.minutemed.arborescence.domain.NodeHU;
import fr.devsquad.minutemed.specialization.domain.Specialization;
import fr.devsquad.minutemed.specialization.domain.SpecializationEnum;
import fr.devsquad.minutemed.staff.domain.Doctor;
import fr.devsquad.minutemed.staff.domain.StaffEnum;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author myfou
 */
public class ExamTest {
    private Exam examWithReport;
    private Exam examWithOutReport;
    
    @Before
    public void setUp() {
        String title = "Radiologie du fémur";
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Node node = new Node("Pole", 1);
        NodeHU nodehu = new NodeHU(NodeEnum.APHP, new Specialization(SpecializationEnum.Pediatrie));
        Doctor askExam = new Doctor(StaffEnum.DOCTOR, "Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
         MedicalRecord medicalRecord = new MedicalRecord("1945478549875", "Patient", "Martin", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", "M", nodehu);
        String consultExam = "12/12/2014";
        String description = "Chute à vélo, demande dun' radio";
              
        this.examWithOutReport = new Exam(title, description, consultExam, askExam, medicalRecord);
        
        this.examWithReport = new Exam(title, description, consultExam, askExam, medicalRecord);
        
        Doctor examinator = new Doctor(StaffEnum.DOCTOR, "Martin", "Paul", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        ResultExam resultExam = new ResultExam(examinator, "15/06/2017", "rien à signaler");
        this.examWithReport.setResultExam(resultExam);
    }
    
    @Test
    public void createExam() {
        Exam tmp = this.examWithOutReport;
    }
    
    @Test(expected = NullPointerException.class)
    public void fieldNullCreate () {
        Exam exam = new Exam(null, null, null, null, null);
    }
    
    @Test
    public void testGetIdEquals () {        
        assertEquals(this.examWithOutReport.getId(), 1l);
    }
    
    @Test
    public void testGetIdNoEquals () {
        assertNotEquals(this.examWithOutReport.getId(), 2l);
    }
    
    @Test
    public void testGetTitleEquals () {
        assertEquals(this.examWithOutReport.getTitle(), "Radiologie du fémur");
    }
    
    @Test
    public void testGetTitleNoEquals () {
        assertNotEquals(this.examWithOutReport.getTitle(), "OUPS");
    }
    
    @Test
    public void testGetDoctorAskExaminationEquals () {
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Node node = new Node("Pole", 1);
        Doctor askExam = new Doctor(StaffEnum.DOCTOR, "Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
                
        assertEquals(this.examWithOutReport.getDoctorAskExamination(), askExam);
    }
    
    @Test
    public void testGetDoctorAskExaminationNoEquals () {
        assertNotEquals(this.examWithOutReport.getDoctorAskExamination(), new Doctor());
    }
    
    @Test
    public void testGetDoctorExaminatorEquals () {
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Node node = new Node("Pole", 1);
        Doctor examinator = new Doctor(StaffEnum.DOCTOR, "Martin", "Paul", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        assertEquals(this.examWithReport.getResultExam().getExaminator(), examinator);
    }
    
    @Test
    public void testGetPatientEquals () {
        NodeHU nodehu = new NodeHU(NodeEnum.APHP, new Specialization(SpecializationEnum.Pediatrie));
        MedicalRecord medicalRecord = new MedicalRecord("1945478549875", "Patient", "Martin", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", "M", nodehu);
        
        assertEquals(this.examWithOutReport.getMedicalRecord(), medicalRecord);
    }
    
    @Test
    public void testGetPatientNoEquals () {
        NodeHU nodehu = new NodeHU(NodeEnum.APHP, new Specialization(SpecializationEnum.Pediatrie));
        MedicalRecord medicalRecord = new MedicalRecord("1945478549879", "Patient", "Martin", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", "M", nodehu);
       
        assertNotEquals(this.examWithOutReport, medicalRecord);
    }
    
    @Test
    public void testGetDateEquals () {
        String consultExam = "12/12/2014";
        assertEquals(this.examWithOutReport.getDateExam(), consultExam);
    }
    
    @Test
    public void testGetExamNoEquals () {
        assertEquals(this.examWithOutReport.getDateExam(), "14/12/1547");
    }
    
    @Test
    public void testGetDescriptionEquals () {
        String description = "Chute à vélo, demande dun' radio";
        assertEquals(this.examWithOutReport.getDescription(), description);
    }
    
    @Test
    public void testGetDescriptionNoEquals () {
        assertNotEquals(this.examWithOutReport.getDescription(), "Ceci n'est pas une description");
    }
    
    @Test
    public void testSetResultExam () {        
        Exam exam = this.examWithReport;
    }
    
    @Test(expected = NullPointerException.class)
    public void testSetNullResultExam () {        
        this.examWithOutReport.setResultExam(null);
    }
    
    @Test
    public void testGetResultExamEquals () {
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Node node = new Node("Pole", 1);
        Doctor examinator = new Doctor(StaffEnum.DOCTOR, "Martin", "Paul", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        ResultExam resultExam = new ResultExam(examinator, "15/06/2017", "rien à signaler");
        
        assertNotEquals(this.examWithReport.getResultExam(), resultExam);
    }
    
    @Test
    public void testGetResultExamNoEquals () {
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Node node = new Node("Pole", 1);
        Doctor examinator = new Doctor(StaffEnum.DOCTOR, "Martin", "Paul", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        ResultExam resultExam = new ResultExam(examinator, "15/06/2019", "rien à signaler lol");
        
        assertNotEquals(this.examWithReport.getResultExam(), resultExam);
    }
    
    @Test
    public void testGetResultExamNull () {
        assertNull(this.examWithOutReport.getResultExam());
    }
}
