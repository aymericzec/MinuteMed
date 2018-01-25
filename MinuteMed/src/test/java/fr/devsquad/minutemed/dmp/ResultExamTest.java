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
public class ResultExamTest {

    public ResultExamTest() {
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
    private ResultExam createTestResultExam() {
        long id = 1;
        IDoctor examinator = new IDoctor();
        Date examDate = new Date();
        String result = "Cassé";
        List<String> files = new ArrayList<>();
        files.add("fichier.jpg");

        ResultExam rs = new ResultExam(id, examinator, examDate, result, files);
        return rs;
    }

    @Test
    public void createResultExam() {
        createTestResultExam();
    }

    @Test(expected = NullPointerException.class)
    public void createNullResultExam() {
        long id = 1;
        IDoctor examinator = null;
        Date examDate = null;
        String result = null;
        List<String> files = null;

        ResultExam rs = new ResultExamTest(id, examinator, examDate, result, files);
    }

    @Test
    public void getFiles() {
        long id = 1;
        IDoctor examinator = new IDoctor();
        Date examDate = new Date();
        String result = "Cassé";
        List<String> files = new ArrayList<>();
        files.add("fichier.jpg");

        ResultExam re = new ResultExamTest(id, examinator, examDate, result, files);
        
        assertEquals(re.getFiles(), files);
    }
    
    @Test
    public void getFilesNotEqual() {
        ResultExam re = createTestResultExam();
        assertNotEquals(re.getFiles(), new ArrayList<>());
    }
    
        @Test
    public void getFiles() {
        long id = 1;
        IDoctor examinator = new IDoctor();
        Date examDate = new Date();
        String result = "Cassé";
        List<String> files = new ArrayList<>();
        files.add("fichier.jpg");

        ResultExam re = new ResultExamTest(id, examinator, examDate, result, files);
        
        assertEquals(re.getFiles(), files);
    }
    
    
    @Test (expected = NullPointerException.class)
    public void getFilesNull() {
        long id = 1;
        IDoctor examinator = new IDoctor();
        Date examDate = new Date();
        String result = "Cassé";
        List<String> files = null;
        files.add("fichier.jpg");

        ResultExam re = new ResultExamTest(id, examinator, examDate, result, files);
    }
    
    @Test
    public void getResultNotEqual() {
        ResultExam re = createTestResultExam();
        assertNotEquals(re.getResult(), "toto");
    }
    
    @Test
    public void getDateExaminate() {
        long id = 1;
        IDoctor examinator = new IDoctor();
        Date examDate = new Date();
        String result = "Cassé";
        List<String> files = new ArrayList<>();
        files.add("fichier.jpg");

        ResultExam re = new ResultExamTest(id, examinator, examDate, result, files);
        
        assertEquals(re.getDateExaminate(), result);
    }
    
    @Test
    public void getDateExaminateNotEqual() {
        ResultExam re = createTestResultExam();
        assertNotEquals(re.getDateExaminate(), new Date());
    }
   
}
