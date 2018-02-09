package fr.devsquad.minutemed.dmp.repository;

import fr.devsquad.minutemed.arborescence.domain.Node;
import fr.devsquad.minutemed.arborescence.domain.NodeEnum;
import fr.devsquad.minutemed.arborescence.domain.NodeHU;
import fr.devsquad.minutemed.dmp.domain.Diagnostic;
import fr.devsquad.minutemed.dmp.domain.MedicalRecord;
import fr.devsquad.minutemed.dmp.domain.Prescription;
import fr.devsquad.minutemed.specialization.domain.Specialization;
import fr.devsquad.minutemed.specialization.domain.SpecializationEnum;
import fr.devsquad.minutemed.staff.domain.Doctor;
import fr.devsquad.minutemed.staff.domain.StaffEnum;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author myfou
 */
public class PrescriptionTest {
    private Diagnostic diagnostic;
    private Prescription prescription;
    
    @Before
    public void setUp() {
        this.diagnostic = createDiagnostic();
        this.prescription = createTestPrescription();
    }

    private Diagnostic createDiagnostic () {
        String title = "Radiologie du fémur";
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Node node = new Node("Pole", 1);
        Doctor diagnosticDoctor = new Doctor(StaffEnum.DOCTOR, "Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        NodeHU nodehu = new NodeHU(NodeEnum.POLE.APHP, new Specialization(SpecializationEnum.Pediatrie));
        MedicalRecord medicalRecord = new MedicalRecord("1945478549875", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", "M", nodehu);
        String consultDiagnostic = "12/12/2012";
        String description = "Chute à vélo, demande dun' radio";

        Diagnostic diag = new Diagnostic(title, diagnosticDoctor, medicalRecord, consultDiagnostic, description);

        return diag;
    }

    private Prescription createTestPrescription() {
        String title = "Ordonnance rhume";
        Node node = new Node("Pole", 1);
        NodeHU nodehu = new NodeHU(NodeEnum.POLE.APHP, new Specialization(SpecializationEnum.Pediatrie));
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Doctor prescriptor = new Doctor(StaffEnum.DOCTOR, "Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        MedicalRecord medicalRecord = new MedicalRecord("1945478549875", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", "M", nodehu);
        String consultDate = "12/12/2015";

        Prescription pres = new Prescription(title, prescriptor, medicalRecord, consultDate, createDiagnostic(), "doliprane, spray nasale");

        return pres;
    }

    @Test
    public void createPrescription() {
        createTestPrescription();
    }
    
    @Test(expected = NullPointerException.class)
    public void createNullPrescription() {
        new Prescription(null,null,null,null,null,null);
    }

    @Test
    public void testGetIdEquals () {
        assertEquals(this.prescription.getId(), 1l);
    }

    @Test
    public void testGetIdNoEquals () {
        assertNotEquals(this.prescription.getId(), 2l);
    }

    @Test
    public void testGetTitleEquals () {
        assertEquals(this.prescription.getTitle(), "doliprane, spray nasale");
    }

    @Test
    public void testGetTitleNoEquals () {
        assertNotEquals(this.prescription.getTitle(), "bad");
    }

    @Test
    public void testGetDoctorEquals () {
        String title = "Ordonnance rhume";
        Node node = new Node("Pole", 1);
        NodeHU nodehu = new NodeHU(NodeEnum.POLE.APHP, new Specialization(SpecializationEnum.Pediatrie));
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Doctor prescriptor = new Doctor(StaffEnum.DOCTOR, "Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        MedicalRecord medicalRecord = new MedicalRecord("1945478549875", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", "M", nodehu);
        String consultDate = "12/12/2015";
        Diagnostic diagnostic = createDiagnostic();
        String prescription = "doliprane, spray nasale";

        Prescription pres = new Prescription(title, prescriptor, medicalRecord, consultDate, diagnostic, prescription);

        assertEquals(pres.getDiagnostic(), prescriptor);
    }

    @Test
    public void testGetDoctorNoEquals () {
        Node node = new Node("Pole", 1);
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        assertNotEquals(this.prescription.getPrescriptor(), new Doctor(StaffEnum.DOCTOR, "Kevin", "Vieira", "2 rue jean", "a@t.gmail", "0770138333", node, specialization));
    }

    @Test
    public void testGetPatientEquals () {
        String title = "Ordonnance rhume";
        Node node = new Node("Pole", 1);
        NodeHU nodehu = new NodeHU(NodeEnum.POLE.APHP, new Specialization(SpecializationEnum.Pediatrie));
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Doctor prescriptor = new Doctor(StaffEnum.DOCTOR, "Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        MedicalRecord medicalRecord = new MedicalRecord("1945478549875", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", "M", nodehu);
        String consultDate = "12/12/2015";
        Diagnostic diagnostic = createDiagnostic();
        String prescription = "doliprane, spray nasale";

        Prescription pres = new Prescription(title, prescriptor, medicalRecord, consultDate, diagnostic, prescription);

        assertEquals(pres.getMedicalRecord(), medicalRecord);
    }

    @Test
    public void testGetPatientNoEquals () {
        NodeHU nodehu = new NodeHU(NodeEnum.POLE.APHP, new Specialization(SpecializationEnum.Pediatrie));
        assertNotEquals(this.prescription.getMedicalRecord(), new MedicalRecord("1945478549875", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", "M", nodehu));
    }

    @Test
    public void testGetDateEquals () {
        String title = "Ordonnance rhume";
        Node node = new Node("Pole", 1);
        NodeHU nodehu = new NodeHU(NodeEnum.POLE.APHP, new Specialization(SpecializationEnum.Pediatrie));
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Doctor prescriptor = new Doctor(StaffEnum.DOCTOR, "Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        MedicalRecord medicalRecord = new MedicalRecord("1945478549875", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", "M", nodehu);
        String consultDate = "12/12/2015";
        Diagnostic diagnostic = createDiagnostic();
        String prescription = "doliprane, spray nasale";

        Prescription pres = new Prescription(title, prescriptor, medicalRecord, consultDate, diagnostic, prescription);


        assertEquals(pres.getConsultDate(), consultDate);
    }

    @Test
    public void testGetDateNoEquals () {
        assertNotEquals(this.prescription.getConsultDate(), new Date());
    }

    @Test
    public void testGetDiagnotic () {
        String title = "Ordonnance rhume";
        Node node = new Node("Pole", 1);
        NodeHU nodehu = new NodeHU(NodeEnum.POLE.APHP, new Specialization(SpecializationEnum.Pediatrie));
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Doctor prescriptor = new Doctor(StaffEnum.DOCTOR, "Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        MedicalRecord medicalRecord = new MedicalRecord("1945478549875", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", "M", nodehu);
        String consultDate = "12/12/2015";
        Diagnostic diagnostic = createDiagnostic();
        String prescription = "doliprane, spray nasale";

        Prescription pres = new Prescription(title, prescriptor, medicalRecord, consultDate, diagnostic, prescription);

        assertEquals(pres.getDiagnostic(), diagnostic);
    }

    @Test
    public void testGetDiagnoticNotEquals () {
        assertNotEquals(this.prescription.getDiagnostic(), "Diagnostic parmis tant d'autres");
    }

    @Test
    public void testGetPrescription () {
        String title = "Ordonnance rhume";
        Node node = new Node("Pole", 1);
        NodeHU nodehu = new NodeHU(NodeEnum.POLE.APHP, new Specialization(SpecializationEnum.Pediatrie));
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Doctor prescriptor = new Doctor(StaffEnum.DOCTOR, "Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        MedicalRecord medicalRecord = new MedicalRecord("1945478549875", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", "M", nodehu);
        String consultDate = "12/12/2015";
        Diagnostic diagnostic = createDiagnostic();
        String prescription = "doliprane, spray nasale";
        Prescription pres = new Prescription(title, prescriptor, medicalRecord, consultDate, diagnostic, prescription);

        assertEquals(pres.getPrescription(), prescription);
    }

    @Test
    public void testGetPrescriptionNotEquals () {
        assertNotEquals(this.prescription.getPrescription(), "lol");
    }
}
