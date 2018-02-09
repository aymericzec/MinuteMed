package fr.devsquad.minutemed.dmp.repository;

import fr.devsquad.minutemed.arborescence.domain.Node;
import fr.devsquad.minutemed.arborescence.domain.NodeEnum;
import fr.devsquad.minutemed.arborescence.domain.NodeHU;
import fr.devsquad.minutemed.dmp.domain.Diagnostic;
import fr.devsquad.minutemed.dmp.domain.Dosage;
import fr.devsquad.minutemed.dmp.domain.MedicalRecord;
import fr.devsquad.minutemed.specialization.domain.Specialization;
import fr.devsquad.minutemed.specialization.domain.SpecializationEnum;
import fr.devsquad.minutemed.staff.domain.Doctor;
import fr.devsquad.minutemed.staff.domain.MedicalStaff;
import fr.devsquad.minutemed.staff.domain.StaffEnum;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author myfou
 */
public class DosageTest {

    private Dosage dosage;

    public DosageTest() {
    }

    @Before
    public void setUp() {
        this.dosage = createDefaultDosage();
    }

    private Dosage createDefaultDosage() {
        String title = "Gastro";
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Node node = new Node("Pole", 1);
        NodeHU nodehu = new NodeHU(NodeEnum.POLE.APHP, new Specialization(SpecializationEnum.Pediatrie));
        Doctor doctorConsulting = new Doctor(StaffEnum.DOCTOR, "Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        MedicalRecord medicalRecord = new MedicalRecord("1945478549875", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", "M", nodehu);
        String dateDosage = "12/05/1996";
        Diagnostic diagnostic = new Diagnostic();
        String dosagePrescription = "3 pillule à 11h\n 2 avant de se coucher";
        String beginDosage = "12/05/1996";
        String endDosage = "12/09/1996";

        return new Dosage(title, doctorConsulting, medicalRecord, dateDosage, diagnostic, dosagePrescription, beginDosage, endDosage);
    }

    @Test
    public void createDosageTest() {
        createDefaultDosage();
    }

    @Test(expected = NullPointerException.class)
    public void createDosageTestNull() {
        new Dosage(null, null, null, null, null, null, null, null);
    }

    @Test
    public void getTitleTest() {
        assertEquals(dosage.getTitle(), "Gastro");
    }

    public void getTitleTestNotEquals() {
        assertNotEquals(this.dosage.getTitle(), "Oupla");
    }

    @Test
    public void getDoctorConsultingTest() {
        String title = "Gastro";
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Node node = new Node("Pole", 1);
        NodeHU nodehu = new NodeHU(NodeEnum.POLE.APHP, new Specialization(SpecializationEnum.Pediatrie));
        Doctor doctorConsulting = new Doctor(StaffEnum.DOCTOR, "Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        MedicalRecord medicalRecord = new MedicalRecord("1945478549875", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", "M", nodehu);
        String dateDosage = "12/05/1996";
        Diagnostic diagnostic = new Diagnostic();
        String dosagePrescription = "3 pillule à 11h\n 2 avant de se coucher";
        String beginDosage = "12/05/1996";
        String endDosage = "12/09/1996";

        Dosage dosage = new Dosage(title, doctorConsulting, medicalRecord, dateDosage, diagnostic, dosagePrescription, beginDosage, endDosage);
        assertEquals(dosage.getDoctorConsulting(), doctorConsulting);
    }

    public void getDoctorConsultingTestNotEquals() {
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Node node = new Node("Pole", 1);
        Doctor doctorConsulting = new Doctor(StaffEnum.DOCTOR, "Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);

        assertNotEquals(this.dosage.getTitle(), doctorConsulting);
    }

    @Test
    public void getPatientTest() {
        String title = "Gastro";
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Node node = new Node("Pole", 1);
        NodeHU nodehu = new NodeHU(NodeEnum.POLE.APHP, new Specialization(SpecializationEnum.Pediatrie));
        Doctor doctorConsulting = new Doctor(StaffEnum.DOCTOR, "Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        MedicalRecord medicalRecord = new MedicalRecord("1945478549875", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", "M", nodehu);
        String dateDosage = "12/05/1996";
        Diagnostic diagnostic = new Diagnostic();
        String dosagePrescription = "3 pillule à 11h\n 2 avant de se coucher";
        String beginDosage = "12/05/1996";
        String endDosage = "12/09/1996";

        Dosage dosage = new Dosage(title, doctorConsulting, medicalRecord, dateDosage, diagnostic, dosagePrescription, beginDosage, endDosage);
        assertEquals(dosage.getMedicalRecord(), medicalRecord);
    }

    public void getPatientNotEquals() {
        NodeHU nodehu = new NodeHU(NodeEnum.POLE.APHP, new Specialization(SpecializationEnum.Pediatrie));
        assertNotEquals(this.dosage.getMedicalRecord(), new MedicalRecord("1945478549875", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", "M", nodehu));
    }

    @Test
    public void getDatePosologieTest() {
        String title = "Gastro";
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Node node = new Node("Pole", 1);
        NodeHU nodehu = new NodeHU(NodeEnum.POLE.APHP, new Specialization(SpecializationEnum.Pediatrie));
        Doctor doctorConsulting = new Doctor(StaffEnum.DOCTOR, "Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        MedicalRecord medicalRecord = new MedicalRecord("1945478549875", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", "M", nodehu);
        String dateDosage = "12/05/1996";
        Diagnostic diagnostic = new Diagnostic();
        String dosagePrescription = "3 pillule à 11h\n 2 avant de se coucher";
        String beginDosage = "12/05/1996";
        String endDosage = "12/09/1996";

        Dosage dosage = new Dosage(title, doctorConsulting, medicalRecord, dateDosage, diagnostic, dosagePrescription, beginDosage, endDosage);
        assertEquals(dosage.getDateDosage(), dateDosage);
    }

    public void getDatePosologieNotEquals() {
        assertNotEquals(this.dosage.getDateDosage(), new Date());
    }

    @Test
    public void getDiagnosticTest() {
        String title = "Gastro";
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Node node = new Node("Pole", 1);
        NodeHU nodehu = new NodeHU(NodeEnum.POLE.APHP, new Specialization(SpecializationEnum.Pediatrie));
        Doctor doctorConsulting = new Doctor(StaffEnum.DOCTOR, "Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        MedicalRecord medicalRecord = new MedicalRecord("1945478549875", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", "M", nodehu);
        String dateDosage = "12/05/1996";
        Diagnostic diagnostic = new Diagnostic();
        String dosagePrescription = "3 pillule à 11h\n 2 avant de se coucher";
        String beginDosage = "12/05/1996";
        String endDosage = "12/09/1996";

        Dosage dosage = new Dosage(title, doctorConsulting, medicalRecord, dateDosage, diagnostic, dosagePrescription, beginDosage, endDosage);
        assertEquals(dosage.getDiagnostic(), diagnostic);
    }

    public void getDiagnosticTestNotEquals() {
        assertNotEquals(this.dosage.getDiagnostic(), new Diagnostic());
    }

    @Test
    public void getRapportTest() {
        String title = "Gastro";
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Node node = new Node("Pole", 1);
        NodeHU nodehu = new NodeHU(NodeEnum.POLE.APHP, new Specialization(SpecializationEnum.Pediatrie));
        Doctor doctorConsulting = new Doctor(StaffEnum.DOCTOR, "Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        MedicalRecord medicalRecord = new MedicalRecord("1945478549875", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", "M", nodehu);
        String dateDosage = "12/05/1996";
        Diagnostic diagnostic = new Diagnostic();
        String dosagePrescription = "3 pillule à 11h\n 2 avant de se coucher";
        String beginDosage = "12/05/1996";
        String endDosage = "12/09/1996";

        Dosage dosage = new Dosage(title, doctorConsulting, medicalRecord, dateDosage, diagnostic, dosagePrescription, beginDosage, endDosage);

        assertEquals(dosage.getRepport(), new ArrayList<>());
    }

    public void getRapportTestNotEquals() {
        assertNotEquals(this.dosage.getRepport(), new ArrayList<>());
    }

    @Test
    public void getDateBeginTest() {
        String title = "Gastro";
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Node node = new Node("Pole", 1);
        NodeHU nodehu = new NodeHU(NodeEnum.POLE.APHP, new Specialization(SpecializationEnum.Pediatrie));
        Doctor doctorConsulting = new Doctor(StaffEnum.DOCTOR, "Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        MedicalRecord medicalRecord = new MedicalRecord("1945478549875", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", "M", nodehu);
        String dateDosage = "12/05/1996";
        Diagnostic diagnostic = new Diagnostic();
        String dosagePrescription = "3 pillule à 11h\n 2 avant de se coucher";
        String beginDosage = "12/05/1996";
        String endDosage = "12/09/1996";

        Dosage dosage = new Dosage(title, doctorConsulting, medicalRecord, dateDosage, diagnostic, dosagePrescription, beginDosage, endDosage);
        assertEquals(this.dosage.getBeginDosage(), beginDosage);
    }

    public void getDateBeginTestNotEquals() {
        Dosage dosage = createDefaultDosage();
        assertNotEquals(dosage.getEndDosage(), new Date());
    }

    @Test
    public void getDateEndTest() {
        String title = "Gastro";
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Node node = new Node("Pole", 1);
        NodeHU nodehu = new NodeHU(NodeEnum.POLE.APHP, new Specialization(SpecializationEnum.Pediatrie));
        Doctor doctorConsulting = new Doctor(StaffEnum.DOCTOR, "Aymeric", "Zecchini", "2 rue jean", "a@t.gmail", "0770138333", node, specialization);
        MedicalRecord medicalRecord = new MedicalRecord("1945478549875", "Aymeric", "Zecchini", "2 rue jean", "a@a.gmail", "0770138334", "02/03/94", "M", nodehu);
        String dateDosage = "12/05/1996";
        Diagnostic diagnostic = new Diagnostic();
        String dosagePrescription = "3 pillule à 11h\n 2 avant de se coucher";
        String beginDosage = "12/05/1996";
        String endDosage = "12/09/1996";

        Dosage dosage = new Dosage(title, doctorConsulting, medicalRecord, dateDosage, diagnostic, dosagePrescription, beginDosage, endDosage);
        assertEquals(dosage.getEndDosage(), endDosage);
    }

    public void getDateEndTestNotEquals() {
        MedicalStaff medicalStaff = new MedicalStaff(StaffEnum.NURSE.name(), 1);
        String dateDosage = "12/06/2554";
        String report = "Tout va bien";

        dosage.addReport(medicalStaff, dateDosage, report);

        assertNotEquals(dosage.getLastReport(), dateDosage);
    }

    public void getDateLastRepportTestNotEquals() {
        Dosage dosage = createDefaultDosage();

        MedicalStaff medicalStaff = new MedicalStaff(StaffEnum.NURSE.name(), 1);
        String dateDosage = "12/06/2554";
        String report = "Tout va bien";

        dosage.addReport(medicalStaff, dateDosage, report);

        dosage.addReport(medicalStaff, dateDosage, report);

        assertNotEquals(dosage.getLastReport().getCreateDate(), new Date());
    }

    @Test
    public void getUserLastRepportTest() {
        Dosage dosage = createDefaultDosage();
        MedicalStaff medicalStaff = new MedicalStaff(StaffEnum.NURSE.name(), 1);
        String dateDosage = "12/06/2554";
        String report = "Tout va bien";
        dosage.addReport(medicalStaff, dateDosage, report);
        dosage.addReport(medicalStaff, dateDosage, report);

        assertEquals(dosage.getLastReport().getSupervisor(), medicalStaff);
    }

    public void getUserRepportTestNotEquals() {
        Dosage dosage = createDefaultDosage();
        MedicalStaff medicalStaff = new MedicalStaff(StaffEnum.NURSE.name(), 1);
        String dateDosage = "12/06/2554";
        String report = "Tout va bien";
        dosage.addReport(medicalStaff, dateDosage, report);
        dosage.addReport(medicalStaff, dateDosage, report);

        MedicalStaff medicalStaff2 = new MedicalStaff(StaffEnum.NURSE.name(), 5);

        assertNotEquals(dosage.getLastReport().getSupervisor(), medicalStaff2);
    }

    @Test
    public void getDosagePrescriptionRepportTest() {
        assertEquals(this.dosage.getDosagePrescription(), "3 pillule à 11h\n 2 avant de se coucher");
    }

    public void getDosagePrescriptionRepportTestNotEquals() {
        assertNotEquals(this.dosage.getDosagePrescription(), "Rien à faire");
    }
}
