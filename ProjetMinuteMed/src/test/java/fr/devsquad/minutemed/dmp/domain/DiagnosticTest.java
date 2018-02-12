package fr.devsquad.minutemed.dmp.domain;

/*import fr.devsquad.minutemed.arborescence.domain.Node;
import fr.devsquad.minutemed.arborescence.domain.NodeEnum;
import fr.devsquad.minutemed.arborescence.domain.NodeHU;
import fr.devsquad.minutemed.specialization.domain.Specialization;
import fr.devsquad.minutemed.specialization.domain.SpecializationEnum;
import fr.devsquad.minutemed.staff.domain.Doctor;
import fr.devsquad.minutemed.staff.domain.StaffEnum;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;*/

/**
 *
 * @author myfou
 */
public class DiagnosticTest {
//    private Diagnostic diagnostic;
//    
//    public DiagnosticTest() {
//    }
//
//    @Before
//    public void setUp() {
//        this.diagnostic = createDiagnostic();
//    }
//    
//    
//    private Diagnostic createDiagnostic () {
//        String title = "Radiologie du fémur";
//        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
//        Node node = new Node("Pole", 1);
//        Doctor diagnosticDoctor = new Doctor(StaffEnum.DOCTOR, "Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
//        NodeHU nodehu = new NodeHU(NodeEnum.APHP, new Specialization(SpecializationEnum.Pediatrie));
//        MedicalRecord medicalRecord = new MedicalRecord("1945478549875", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", "M", nodehu);
//        String consultDiagnostic = "12/12/2012";
//        String description = "Chute à vélo, demande dun' radio";
//
//        Diagnostic diag = new Diagnostic(title, diagnosticDoctor, medicalRecord, consultDiagnostic, description);
//
//        return diag;
//    }
//    
//    @Test
//    public void createDiagnosticTest() {
//        createDiagnostic();
//    }
//    
//    @Test(expected = NullPointerException.class)
//    public void fieldNullCreate () {
//        Diagnostic diagnostic1 = new Diagnostic(null, null, null, null, null);
//    }
//    
//    @Test
//    public void testGetIdEquals () {        
//        assertEquals(this.diagnostic.getId(), 1l);
//    }
//    
//    @Test
//    public void testGetIdNoEquals () {
//        assertNotEquals(this.diagnostic.getId(), 2l);
//    }
//    
//    @Test
//    public void testGetTitleEquals () {        
//        assertEquals(this.diagnostic.getTitle(), "Radiologie du fémur");
//    }
//    
//    @Test
//    public void testGetTitleNoEquals () {
//        assertNotEquals(this.diagnostic.getTitle(), "pop");
//    }
//    
//    @Test
//    public void testGetDiagnoticDoctorEquals () {        
//        String title = "Radiologie du fémur";
//        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
//        Node node = new Node("Pole", 1);
//        Doctor diagnosticDoctor = new Doctor(StaffEnum.DOCTOR, "Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
//        NodeHU nodehu = new NodeHU(NodeEnum.APHP, new Specialization(SpecializationEnum.Pediatrie));
//        MedicalRecord medicalRecord = new MedicalRecord("1945478549875", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", "M", nodehu);
//        String consultDiagnostic = "12/12/2012";
//        String description = "Chute à vélo, demande dun' radio";
//
//        Diagnostic diag = new Diagnostic(title, diagnosticDoctor, medicalRecord, consultDiagnostic, description);
//        
//        assertEquals(diag.getDiagnostic(), diagnostic);
//    }
//    
//    @Test
//    public void testGetDiagnoticDoctorNoEquals () {
//        Node node = new Node("Pole", 1);
//        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
//        assertNotEquals(this.diagnostic.getDiagnostic(), new Doctor(StaffEnum.DOCTOR, "Kevin", "Vieira", "2 rue jean", "a@t.gmail", "0770138333", node, specialization));
//    }
//    
//    @Test
//    public void testGetPatientEquals () {
//        String title = "Radiologie du fémur";
//        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
//        Node node = new Node("Pole", 1);
//        Doctor diagnosticDoctor = new Doctor(StaffEnum.DOCTOR, "Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
//        NodeHU nodehu = new NodeHU(NodeEnum.APHP, new Specialization(SpecializationEnum.Pediatrie));
//        MedicalRecord medicalRecord = new MedicalRecord("1945478549875", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", "M", nodehu);
//        String consultDiagnostic = "12/12/2012";
//        String description = "Chute à vélo, demande dun' radio";
//
//        Diagnostic diag = new Diagnostic(title, diagnosticDoctor, medicalRecord, consultDiagnostic, description);
//        
//        assertEquals(diag.getMedicalRecord(), diagnostic);
//    }
//    
//    @Test
//    public void testGetPatientNoEquals () {
//        NodeHU nodehu = new NodeHU(NodeEnum.APHP, new Specialization(SpecializationEnum.Pediatrie));
//        assertNotEquals(this.diagnostic.getMedicalRecord(), new MedicalRecord("1945478549875", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", "M", nodehu));
//    }
//    
//    @Test
//    public void testGetDateEquals () {
//        String title = "Radiologie du fémur";
//        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
//        Node node = new Node("Pole", 1);
//        Doctor diagnosticDoctor = new Doctor(StaffEnum.DOCTOR, "Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
//        NodeHU nodehu = new NodeHU(NodeEnum.APHP, new Specialization(SpecializationEnum.Pediatrie));
//        MedicalRecord medicalRecord = new MedicalRecord("1945478549875", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", "M", nodehu);
//        String consultDiagnostic = "12/12/2012";
//        String description = "Chute à vélo, demande dun' radio";
//
//        Diagnostic diag = new Diagnostic(title, diagnosticDoctor, medicalRecord, consultDiagnostic, description);
//        assertEquals(diag.getConsultDiagnostic(), consultDiagnostic);
//    }
//    
//    @Test
//    public void testGetDateNoEquals () {
//        assertNotEquals(this.diagnostic.getConsultDiagnostic(), "16/05/2014");
//    }
//    
//    @Test
//    public void testGetDescriptionEquals () {
//        String title = "Radiologie du fémur";
//        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
//        Node node = new Node("Pole", 1);
//        Doctor diagnosticDoctor = new Doctor(StaffEnum.DOCTOR, "Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
//        NodeHU nodehu = new NodeHU(NodeEnum.APHP, new Specialization(SpecializationEnum.Pediatrie));
//        MedicalRecord medicalRecord = new MedicalRecord("1945478549875", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", "M", nodehu);
//        String consultDiagnostic = "12/12/2012";
//        String description = "Chute à vélo, demande dun' radio";
//
//        Diagnostic diag = new Diagnostic(title, diagnosticDoctor, medicalRecord, consultDiagnostic, description);
//        assertEquals(diag.getDescription(), description);
//    }
//    
//    @Test
//    public void testGetDescriptionNoEquals () {
//        assertNotEquals(this.diagnostic.getDescription(), "toto");
//    }
//    
//    @Test
//    public void testDraftCreate() {
//        assertEquals(this.diagnostic.getDraft(), true);
//    }
//    
//    @Test
//    public void testDraftFalse() {
//        this.diagnostic.setDraft(false);
//        assertEquals(this.diagnostic.getDraft(), false);
//    }
//    
//    @Test(expected = IllegalAccessException.class)
//    public void testDraftFalseAndTrue() {
//        this.diagnostic.setDraft(false);
//        this.diagnostic.setDraft(true);
//    }
}

