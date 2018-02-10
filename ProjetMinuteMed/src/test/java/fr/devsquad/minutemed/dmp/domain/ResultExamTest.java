package fr.devsquad.minutemed.dmp.domain;

import fr.devsquad.minutemed.arborescence.domain.Node;
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
public class ResultExamTest {
    private ResultExam resultExam;
    
    public ResultExamTest() {
    }
    @Before
    public void setUp() {
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Node node = new Node("Pole", 1);
        Doctor examinator = new Doctor(StaffEnum.DOCTOR, "Martin", "Paul", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        this.resultExam = new ResultExam(examinator, "15/06/2017", "fracture");
    }
    
    @Test
    public void createResultExam() {
        ResultExam rs = this.resultExam;
    }

    @Test(expected = NullPointerException.class)
    public void createNullResultExam() {
        ResultExam rs = new ResultExam(null, null, null);
    }

    @Test
    public void addFiles () {
        this.resultExam.addFiles("/path/image.jpg");
    }
    
    @Test
    public void getFiles() {
        this.resultExam.addFiles("fichier.jpg");
        String s = this.resultExam.getFiles().get(0);
        assertEquals(s, "fichier.jpg");
    }
    
    @Test
    public void getFilesNotEqual() {
        this.resultExam.addFiles("fichier.jpg");
        String s = this.resultExam.getFiles().get(0);
        assertNotEquals(s, "a");
    }

    public void getResultTest() {
        assertEquals(this.resultExam.getResult(), "fracture");
    }
    
    @Test
    public void getResultNotEqual() {
        assertNotEquals(this.resultExam.getResult(), "toto");
    }
    
    @Test
    public void getDateExaminate() {        
        assertEquals(this.resultExam.getExamDate(), "15/06/2017");
    }
    
    @Test
    public void getDateExaminateNotEqual() {
        assertNotEquals(this.resultExam.getExamDate(), "15/06/2014");
    }
   
}

