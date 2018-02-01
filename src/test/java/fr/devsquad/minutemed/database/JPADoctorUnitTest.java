package fr.devsquad.minutemed.database;

import fr.devsquad.minutemed.arborescence.INode;
import fr.devsquad.minutemed.arborescence.Node;
import fr.devsquad.minutemed.arborescence.NodeAPHP;
import fr.devsquad.minutemed.arborescence.NodeEnum;
import fr.devsquad.minutemed.arborescence.NodeHU;
import fr.devsquad.minutemed.arborescence.NodeHospital;
import fr.devsquad.minutemed.arborescence.NodePole;
import fr.devsquad.minutemed.arborescence.NodeService;
import fr.devsquad.minutemed.dmp.Diagnostic;
import fr.devsquad.minutemed.dmp.Dosage;
import fr.devsquad.minutemed.dmp.Exam;
import fr.devsquad.minutemed.dmp.GenderEnum;
import fr.devsquad.minutemed.dmp.MedicalRecord;
import fr.devsquad.minutemed.dmp.Prescription;
import fr.devsquad.minutemed.specialization.Specialization;
import fr.devsquad.minutemed.specialization.SpecializationEnum;
import fr.devsquad.minutemed.staff.Doctor;
import fr.devsquad.minutemed.staff.Nurse;
import fr.devsquad.minutemed.staff.StaffEnum;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class JPADoctorUnitTest {

    /**
     * Return an exception if the MedicalRecord field is null
     */
    @Test
    public void testCreateMedicalRecordNull() {
        JPADoctor doctor = Mockito.spy(new JPADoctor());

        Mockito.doThrow(new NullPointerException()).when(doctor).createMedicalRecord(null);
    }

    /**
     * Test the creation of a MedicalRecord
     */
    @Test
    public void testCreateMedicalRecord() {
        JPADataManager dataManager = Mockito.spy(new JPADataManager());
        JPADoctor doctor = Mockito.spy(new JPADoctor());

        Specialization pediatrie = Mockito.spy(new Specialization(SpecializationEnum.Pediatrie));
        Specialization andrologie = Mockito.spy(new Specialization(SpecializationEnum.Andrologie));
        Specialization cardiologie = Mockito.spy(new Specialization(SpecializationEnum.Cardiologie));

        NodeHU huCreate = Mockito.spy(new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie));
        List<NodeHU> hospitalUnits = new ArrayList<>();
        hospitalUnits.add(huCreate);

        NodeService service = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits));
        List<NodeService> services = new ArrayList<>();
        services.add(service);

        NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
        List<NodePole> poles = new ArrayList<>();
        poles.add(pole);

        NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
        List<NodeHospital> hospitals = new ArrayList<>();
        hospitals.add(hospital);

        NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
        huCreate.setService(service);
        service.setPole(pole);
        pole.setHospital(hospital);
        hospital.setAPHP(aphp);

        assertTrue(dataManager.createAPHP(aphp));
        assertTrue(dataManager.createHospital(hospital));
        assertTrue(dataManager.createPole(pole));
        assertTrue(dataManager.createService(service));
        assertTrue(dataManager.createHospitalUnit(huCreate));

        MedicalRecord mRecord = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", "M", huCreate));

        assertTrue(doctor.createMedicalRecord(mRecord));
        assertFalse(doctor.createMedicalRecord(mRecord));
    }

    /**
     * Return an exception if a field is null
     */
    @Test
    public void testCreateExamNull() {
        JPADoctor doctor = Mockito.spy(new JPADoctor());

        Mockito.doThrow(new NullPointerException()).when(doctor).createExam(null);
    }

    /**
     * Test the creation of an Exam
     */
    @Test
    public void testCreateExam() {
        JPADataManager dataManager = Mockito.spy(new JPADataManager());
        JPADoctor doctor = Mockito.spy(new JPADoctor());

        Specialization pediatrie = Mockito.spy(new Specialization(SpecializationEnum.Pediatrie));
        Specialization andrologie = Mockito.spy(new Specialization(SpecializationEnum.Andrologie));
        Specialization cardiologie = Mockito.spy(new Specialization(SpecializationEnum.Cardiologie));

        NodeHU huCreate = Mockito.spy(new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie));
        List<NodeHU> hospitalUnits = new ArrayList<>();
        hospitalUnits.add(huCreate);

        NodeService service = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits));
        List<NodeService> services = new ArrayList<>();
        services.add(service);

        NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
        List<NodePole> poles = new ArrayList<>();
        poles.add(pole);

        NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
        List<NodeHospital> hospitals = new ArrayList<>();
        hospitals.add(hospital);

        NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
        huCreate.setService(service);
        service.setPole(pole);
        pole.setHospital(hospital);
        hospital.setAPHP(aphp);

        Node p = dataManager.getNode(pole.getType(), pole.getId());

        assertTrue(dataManager.createAPHP(aphp));
        assertTrue(dataManager.createHospital(hospital));
        assertTrue(dataManager.createPole(pole));
        assertTrue(dataManager.createService(service));
        assertTrue(dataManager.createHospitalUnit(huCreate));

        MedicalRecord mRecord = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", "M", huCreate));
        Doctor doc = Mockito.spy(new Doctor(StaffEnum.DOCTOR, "Dupond", "Patrick", "5 Avenue de Paris", "patoche@gmail.com", "0718548716", p, pediatrie));
        Exam exam = Mockito.spy(new Exam("Examen", "Nez enrhumé", "28/01/2018", doc, mRecord));

        assertTrue(doctor.createMedicalRecord(mRecord));
        assertTrue(doctor.createExam(exam));
        assertFalse(doctor.createExam(exam));
    }

    /**
     * Test if an Exam exists, it don't returns null
     */
    @Test
    public void testGetExam() {
        JPADataManager dataManager = Mockito.spy(new JPADataManager());
        JPADoctor doctor = Mockito.spy(new JPADoctor());

        Specialization pediatrie = Mockito.spy(new Specialization(SpecializationEnum.Pediatrie));
        Specialization andrologie = Mockito.spy(new Specialization(SpecializationEnum.Andrologie));
        Specialization cardiologie = Mockito.spy(new Specialization(SpecializationEnum.Cardiologie));

        NodeHU huCreate = Mockito.spy(new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie));
        List<NodeHU> hospitalUnits = new ArrayList<>();
        hospitalUnits.add(huCreate);

        NodeService service = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits));
        List<NodeService> services = new ArrayList<>();
        services.add(service);

        NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
        List<NodePole> poles = new ArrayList<>();
        poles.add(pole);

        NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
        List<NodeHospital> hospitals = new ArrayList<>();
        hospitals.add(hospital);

        NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
        huCreate.setService(service);
        service.setPole(pole);
        pole.setHospital(hospital);
        hospital.setAPHP(aphp);

        Node p = dataManager.getNode(pole.getType(), pole.getId());

        assertTrue(dataManager.createAPHP(aphp));
        assertTrue(dataManager.createHospital(hospital));
        assertTrue(dataManager.createPole(pole));
        assertTrue(dataManager.createService(service));
        assertTrue(dataManager.createHospitalUnit(huCreate));

        MedicalRecord mRecord = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", "M", huCreate));
        Doctor doc = Mockito.spy(new Doctor(StaffEnum.DOCTOR, "Dupond", "Patrick", "5 Avenue de Paris", "patoche@gmail.com", "0718548716", p, pediatrie));
        Exam examCreate = Mockito.spy(new Exam("Examen", "Nez enrhumé", "28/01/2018", doc, mRecord));

        assertTrue(doctor.createMedicalRecord(mRecord));
        assertTrue(doctor.createExam(examCreate));

        Exam examResult = doctor.getExam(examCreate.getId());

        assertNotNull(examResult);

        assertEquals(examCreate.getId(), examResult.getId());
        assertEquals(examCreate.getDateExam(), examResult.getDateExam());
        assertEquals(examCreate.getDoctorAskExamination(), examResult.getDoctorAskExamination());
    }

    /**
     * Test if an Exam exists, it validate them
     */
    @Test
    public void testValidateExam() {
        JPADataManager dataManager = Mockito.spy(new JPADataManager());
        JPADoctor doctor = Mockito.spy(new JPADoctor());

        Specialization pediatrie = Mockito.spy(new Specialization(SpecializationEnum.Pediatrie));
        Specialization andrologie = Mockito.spy(new Specialization(SpecializationEnum.Andrologie));
        Specialization cardiologie = Mockito.spy(new Specialization(SpecializationEnum.Cardiologie));

        NodeHU huCreate = Mockito.spy(new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie));
        List<NodeHU> hospitalUnits = new ArrayList<>();
        hospitalUnits.add(huCreate);

        NodeService service = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits));
        List<NodeService> services = new ArrayList<>();
        services.add(service);

        NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
        List<NodePole> poles = new ArrayList<>();
        poles.add(pole);

        NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
        List<NodeHospital> hospitals = new ArrayList<>();
        hospitals.add(hospital);

        NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
        huCreate.setService(service);
        service.setPole(pole);
        pole.setHospital(hospital);
        hospital.setAPHP(aphp);

        Node p = dataManager.getNode(pole.getType(), pole.getId());

        assertTrue(dataManager.createAPHP(aphp));
        assertTrue(dataManager.createHospital(hospital));
        assertTrue(dataManager.createPole(pole));
        assertTrue(dataManager.createService(service));
        assertTrue(dataManager.createHospitalUnit(huCreate));

        MedicalRecord mRecord = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", "M", huCreate));
        Doctor doc = Mockito.spy(new Doctor(StaffEnum.DOCTOR, "Dupond", "Patrick", "5 Avenue de Paris", "patoche@gmail.com", "0718548716", p, pediatrie));
        Exam exam = Mockito.spy(new Exam("Examen", "Nez enrhumé", "28/01/2018", doc, mRecord));

        assertTrue(doctor.createMedicalRecord(mRecord));
        assertTrue(doctor.createExam(exam));
        assertTrue(doctor.validateExam(exam.getId()));
        assertFalse(doctor.validateExam(exam.getId()));
    }

    /**
     * Test if an Exam exists, it remove the draft
     */
    @Test
    public void testRemoveDraftExam() {
        JPADataManager dataManager = Mockito.spy(new JPADataManager());
        JPADoctor doctor = Mockito.spy(new JPADoctor());

        Specialization pediatrie = Mockito.spy(new Specialization(SpecializationEnum.Pediatrie));
        Specialization andrologie = Mockito.spy(new Specialization(SpecializationEnum.Andrologie));
        Specialization cardiologie = Mockito.spy(new Specialization(SpecializationEnum.Cardiologie));

        NodeHU huCreate = Mockito.spy(new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie));
        List<NodeHU> hospitalUnits = new ArrayList<>();
        hospitalUnits.add(huCreate);

        NodeService service = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits));
        List<NodeService> services = new ArrayList<>();
        services.add(service);

        NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
        List<NodePole> poles = new ArrayList<>();
        poles.add(pole);

        NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
        List<NodeHospital> hospitals = new ArrayList<>();
        hospitals.add(hospital);

        NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
        huCreate.setService(service);
        service.setPole(pole);
        pole.setHospital(hospital);
        hospital.setAPHP(aphp);

        Node p = dataManager.getNode(pole.getType(), pole.getId());

        assertTrue(dataManager.createAPHP(aphp));
        assertTrue(dataManager.createHospital(hospital));
        assertTrue(dataManager.createPole(pole));
        assertTrue(dataManager.createService(service));
        assertTrue(dataManager.createHospitalUnit(huCreate));

        MedicalRecord mRecord = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", "M", huCreate));
        Doctor doc = Mockito.spy(new Doctor(StaffEnum.DOCTOR, "Dupond", "Patrick", "5 Avenue de Paris", "patoche@gmail.com", "0718548716", p, pediatrie));
        Exam exam = Mockito.spy(new Exam("Examen", "Nez enrhumé", "28/01/2018", doc, mRecord));

        assertTrue(doctor.createMedicalRecord(mRecord));
        assertTrue(doctor.createExam(exam));
        assertTrue(doctor.removeDraftExam(exam.getId()));
        assertFalse(doctor.removeDraftExam(exam.getId()));
    }

    /**
     * Return an exception if a field is null
     */
    @Test
    public void testCreatePrescriptionNull() {
        JPADoctor doctor = Mockito.spy(new JPADoctor());

        Mockito.doThrow(new NullPointerException()).when(doctor).createPrescription(null);
    }

    /**
     * Test the creation of a Prescription
     */
    @Test
    public void testCreatePrescription() {
        JPADataManager dataManager = Mockito.spy(new JPADataManager());
        JPADoctor doctor = Mockito.spy(new JPADoctor());

        Specialization pediatrie = Mockito.spy(new Specialization(SpecializationEnum.Pediatrie));
        Specialization andrologie = Mockito.spy(new Specialization(SpecializationEnum.Andrologie));
        Specialization cardiologie = Mockito.spy(new Specialization(SpecializationEnum.Cardiologie));

        NodeHU huCreate = Mockito.spy(new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie));
        List<NodeHU> hospitalUnits = new ArrayList<>();
        hospitalUnits.add(huCreate);

        NodeService service = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits));
        List<NodeService> services = new ArrayList<>();
        services.add(service);

        NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
        List<NodePole> poles = new ArrayList<>();
        poles.add(pole);

        NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
        List<NodeHospital> hospitals = new ArrayList<>();
        hospitals.add(hospital);

        NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
        huCreate.setService(service);
        service.setPole(pole);
        pole.setHospital(hospital);
        hospital.setAPHP(aphp);

        Node p = dataManager.getNode(pole.getType(), pole.getId());

        assertTrue(dataManager.createAPHP(aphp));
        assertTrue(dataManager.createHospital(hospital));
        assertTrue(dataManager.createPole(pole));
        assertTrue(dataManager.createService(service));
        assertTrue(dataManager.createHospitalUnit(huCreate));

        MedicalRecord mRecord = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", "M", huCreate));
        Doctor doc = Mockito.spy(new Doctor(StaffEnum.DOCTOR, "Dupond", "Patrick", "5 Avenue de Paris", "patoche@gmail.com", "0718548716", p, pediatrie));

        Diagnostic diagnostic = Mockito.spy(new Diagnostic("Diagnostic", doc, mRecord, "14/01/2018", "Mal à la tête"));
        Prescription prescription = Mockito.spy(new Prescription("Ordonnance", doc, mRecord, "15/01/2018", diagnostic, "2 boites de Doliprane"));

        assertTrue(doctor.createMedicalRecord(mRecord));
        assertTrue(doctor.createPrescription(prescription));
        assertFalse(doctor.createPrescription(prescription));
    }

    /**
     * Test if a Prescription exists, it don't returns null
     */
    @Test
    public void testGetPrescription() {
        JPADataManager dataManager = Mockito.spy(new JPADataManager());
        JPADoctor doctor = Mockito.spy(new JPADoctor());

        Specialization pediatrie = Mockito.spy(new Specialization(SpecializationEnum.Pediatrie));
        Specialization andrologie = Mockito.spy(new Specialization(SpecializationEnum.Andrologie));
        Specialization cardiologie = Mockito.spy(new Specialization(SpecializationEnum.Cardiologie));

        NodeHU huCreate = Mockito.spy(new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie));
        List<NodeHU> hospitalUnits = new ArrayList<>();
        hospitalUnits.add(huCreate);

        NodeService service = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits));
        List<NodeService> services = new ArrayList<>();
        services.add(service);

        NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
        List<NodePole> poles = new ArrayList<>();
        poles.add(pole);

        NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
        List<NodeHospital> hospitals = new ArrayList<>();
        hospitals.add(hospital);

        NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
        huCreate.setService(service);
        service.setPole(pole);
        pole.setHospital(hospital);
        hospital.setAPHP(aphp);

        Node p = dataManager.getNode(pole.getType(), pole.getId());

        assertTrue(dataManager.createAPHP(aphp));
        assertTrue(dataManager.createHospital(hospital));
        assertTrue(dataManager.createPole(pole));
        assertTrue(dataManager.createService(service));
        assertTrue(dataManager.createHospitalUnit(huCreate));

        MedicalRecord mRecord = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", "M", huCreate));
        Doctor doc = Mockito.spy(new Doctor(StaffEnum.DOCTOR, "Dupond", "Patrick", "5 Avenue de Paris", "patoche@gmail.com", "0718548716", p, pediatrie));

        Diagnostic diagnostic = Mockito.spy(new Diagnostic("Diagnostic", doc, mRecord, "14/01/2018", "Mal à la tête"));
        Prescription prescriptionCreate = Mockito.spy(new Prescription("Ordonnance", doc, mRecord, "15/01/2018", diagnostic, "2 boites de Doliprane"));

        assertTrue(doctor.createMedicalRecord(mRecord));
        assertTrue(doctor.createPrescription(prescriptionCreate));

        Prescription prescriptionResult = doctor.getPrescription(prescriptionCreate.getId());

        assertNotNull(prescriptionResult);

        assertEquals(prescriptionCreate.getId(), prescriptionResult.getId());
        assertEquals(prescriptionCreate.getConsultDate(), prescriptionResult.getConsultDate());
        assertEquals(prescriptionCreate.getPrescriptor(), prescriptionResult.getPrescriptor());
    }

    /**
     * Test if a Prescription exists, it validate them
     */
    @Test
    public void testValidatePrescription() {
        JPADataManager dataManager = Mockito.spy(new JPADataManager());
        JPADoctor doctor = Mockito.spy(new JPADoctor());

        Specialization pediatrie = Mockito.spy(new Specialization(SpecializationEnum.Pediatrie));
        Specialization andrologie = Mockito.spy(new Specialization(SpecializationEnum.Andrologie));
        Specialization cardiologie = Mockito.spy(new Specialization(SpecializationEnum.Cardiologie));

        NodeHU huCreate = Mockito.spy(new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie));
        List<NodeHU> hospitalUnits = new ArrayList<>();
        hospitalUnits.add(huCreate);

        NodeService service = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits));
        List<NodeService> services = new ArrayList<>();
        services.add(service);

        NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
        List<NodePole> poles = new ArrayList<>();
        poles.add(pole);

        NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
        List<NodeHospital> hospitals = new ArrayList<>();
        hospitals.add(hospital);

        NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
        huCreate.setService(service);
        service.setPole(pole);
        pole.setHospital(hospital);
        hospital.setAPHP(aphp);

        Node p = dataManager.getNode(pole.getType(), pole.getId());

        assertTrue(dataManager.createAPHP(aphp));
        assertTrue(dataManager.createHospital(hospital));
        assertTrue(dataManager.createPole(pole));
        assertTrue(dataManager.createService(service));
        assertTrue(dataManager.createHospitalUnit(huCreate));

        MedicalRecord mRecord = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", "M", huCreate));
        Doctor doc = Mockito.spy(new Doctor(StaffEnum.DOCTOR, "Dupond", "Patrick", "5 Avenue de Paris", "patoche@gmail.com", "0718548716", p, pediatrie));

        Diagnostic diagnostic = Mockito.spy(new Diagnostic("Diagnostic", doc, mRecord, "14/01/2018", "Mal à la tête"));
        Prescription prescription = Mockito.spy(new Prescription("Ordonnance", doc, mRecord, "15/01/2018", diagnostic, "2 boites de Doliprane"));

        assertTrue(doctor.createMedicalRecord(mRecord));
        assertTrue(doctor.createPrescription(prescription));
        assertTrue(doctor.validatePrescription(prescription.getId()));
        assertFalse(doctor.validatePrescription(prescription.getId()));
    }

    /**
     * Test if a Prescription exists, it remove the draft
     */
    @Test
    public void testRemoveDraftPrescription() {
        JPADataManager dataManager = Mockito.spy(new JPADataManager());
        JPADoctor doctor = Mockito.spy(new JPADoctor());

        Specialization pediatrie = Mockito.spy(new Specialization(SpecializationEnum.Pediatrie));
        Specialization andrologie = Mockito.spy(new Specialization(SpecializationEnum.Andrologie));
        Specialization cardiologie = Mockito.spy(new Specialization(SpecializationEnum.Cardiologie));

        NodeHU huCreate = Mockito.spy(new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie));
        List<NodeHU> hospitalUnits = new ArrayList<>();
        hospitalUnits.add(huCreate);

        NodeService service = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits));
        List<NodeService> services = new ArrayList<>();
        services.add(service);

        NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
        List<NodePole> poles = new ArrayList<>();
        poles.add(pole);

        NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
        List<NodeHospital> hospitals = new ArrayList<>();
        hospitals.add(hospital);

        NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
        huCreate.setService(service);
        service.setPole(pole);
        pole.setHospital(hospital);
        hospital.setAPHP(aphp);

        Node p = dataManager.getNode(pole.getType(), pole.getId());

        assertTrue(dataManager.createAPHP(aphp));
        assertTrue(dataManager.createHospital(hospital));
        assertTrue(dataManager.createPole(pole));
        assertTrue(dataManager.createService(service));
        assertTrue(dataManager.createHospitalUnit(huCreate));

        MedicalRecord mRecord = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", "M", huCreate));
        Doctor doc = Mockito.spy(new Doctor(StaffEnum.DOCTOR, "Dupond", "Patrick", "5 Avenue de Paris", "patoche@gmail.com", "0718548716", p, pediatrie));

        Diagnostic diagnostic = Mockito.spy(new Diagnostic("Diagnostic", doc, mRecord, "14/01/2018", "Mal à la tête"));
        Prescription prescription = Mockito.spy(new Prescription("Ordonnance", doc, mRecord, "15/01/2018", diagnostic, "2 boites de Doliprane"));

        assertTrue(doctor.createMedicalRecord(mRecord));
        assertTrue(doctor.createPrescription(prescription));
        assertTrue(doctor.removeDraftPrescription(prescription.getId()));
        assertFalse(doctor.removeDraftPrescription(prescription.getId()));
    }

    /**
     * Return an exception if a field is null
     */
    @Test
    public void testCreateDiagnosticNull() {
        JPADoctor doctor = Mockito.spy(new JPADoctor());

        Mockito.doThrow(new NullPointerException()).when(doctor).createDiagnostic(null);
    }

    /**
     * Test the creation of a Diagnostic
     */
    @Test
    public void testCreateDiagnostic() {
        JPADataManager dataManager = Mockito.spy(new JPADataManager());
        JPADoctor doctor = Mockito.spy(new JPADoctor());

        Specialization pediatrie = Mockito.spy(new Specialization(SpecializationEnum.Pediatrie));
        Specialization andrologie = Mockito.spy(new Specialization(SpecializationEnum.Andrologie));
        Specialization cardiologie = Mockito.spy(new Specialization(SpecializationEnum.Cardiologie));

        NodeHU huCreate = Mockito.spy(new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie));
        List<NodeHU> hospitalUnits = new ArrayList<>();
        hospitalUnits.add(huCreate);

        NodeService service = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits));
        List<NodeService> services = new ArrayList<>();
        services.add(service);

        NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
        List<NodePole> poles = new ArrayList<>();
        poles.add(pole);

        NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
        List<NodeHospital> hospitals = new ArrayList<>();
        hospitals.add(hospital);

        NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
        huCreate.setService(service);
        service.setPole(pole);
        pole.setHospital(hospital);
        hospital.setAPHP(aphp);

        Node p = dataManager.getNode(pole.getType(), pole.getId());

        assertTrue(dataManager.createAPHP(aphp));
        assertTrue(dataManager.createHospital(hospital));
        assertTrue(dataManager.createPole(pole));
        assertTrue(dataManager.createService(service));
        assertTrue(dataManager.createHospitalUnit(huCreate));

        MedicalRecord mRecord = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", "M", huCreate));
        Doctor doc = Mockito.spy(new Doctor(StaffEnum.DOCTOR, "Dupond", "Patrick", "5 Avenue de Paris", "patoche@gmail.com", "0718548716", p, pediatrie));

        Diagnostic diagnostic = Mockito.spy(new Diagnostic("Diagnostic", doc, mRecord, "14/01/2018", "Mal à la tête"));

        assertTrue(doctor.createMedicalRecord(mRecord));
        assertTrue(doctor.createDiagnostic(diagnostic));
        assertFalse(doctor.createDiagnostic(diagnostic));
    }

    /**
     * Test if a Diagnostic exists, it don't returns null
     */
    @Test
    public void testGetDiagnostic() {
        JPADataManager dataManager = Mockito.spy(new JPADataManager());
        JPADoctor doctor = Mockito.spy(new JPADoctor());

        Specialization pediatrie = Mockito.spy(new Specialization(SpecializationEnum.Pediatrie));
        Specialization andrologie = Mockito.spy(new Specialization(SpecializationEnum.Andrologie));
        Specialization cardiologie = Mockito.spy(new Specialization(SpecializationEnum.Cardiologie));

        NodeHU huCreate = Mockito.spy(new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie));
        List<NodeHU> hospitalUnits = new ArrayList<>();
        hospitalUnits.add(huCreate);

        NodeService service = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits));
        List<NodeService> services = new ArrayList<>();
        services.add(service);

        NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
        List<NodePole> poles = new ArrayList<>();
        poles.add(pole);

        NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
        List<NodeHospital> hospitals = new ArrayList<>();
        hospitals.add(hospital);

        NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
        huCreate.setService(service);
        service.setPole(pole);
        pole.setHospital(hospital);
        hospital.setAPHP(aphp);

        Node p = dataManager.getNode(pole.getType(), pole.getId());

        assertTrue(dataManager.createAPHP(aphp));
        assertTrue(dataManager.createHospital(hospital));
        assertTrue(dataManager.createPole(pole));
        assertTrue(dataManager.createService(service));
        assertTrue(dataManager.createHospitalUnit(huCreate));

        MedicalRecord mRecord = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", "M", huCreate));
        Doctor doc = Mockito.spy(new Doctor(StaffEnum.DOCTOR, "Dupond", "Patrick", "5 Avenue de Paris", "patoche@gmail.com", "0718548716", p, pediatrie));
        Diagnostic diagnosticCreate = Mockito.spy(new Diagnostic("Diagnostic", doc, mRecord, "14/01/2018", "Mal à la tête"));

        assertTrue(doctor.createMedicalRecord(mRecord));
        assertTrue(doctor.createDiagnostic(diagnosticCreate));

        Diagnostic diagnosticResult = doctor.getDiagnostic(diagnosticCreate.getId());

        assertNotNull(diagnosticResult);

        assertEquals(diagnosticCreate.getId(), diagnosticResult.getId());
        assertEquals(diagnosticCreate.getConsultDiagnostic(), diagnosticResult.getConsultDiagnostic());
    }

    /**
     * Test if a Diagnostic exists, it validate them
     */
    @Test
    public void testValidateDiagnostic() {
        JPADataManager dataManager = Mockito.spy(new JPADataManager());
        JPADoctor doctor = Mockito.spy(new JPADoctor());

        Specialization pediatrie = Mockito.spy(new Specialization(SpecializationEnum.Pediatrie));
        Specialization andrologie = Mockito.spy(new Specialization(SpecializationEnum.Andrologie));
        Specialization cardiologie = Mockito.spy(new Specialization(SpecializationEnum.Cardiologie));

        NodeHU huCreate = Mockito.spy(new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie));
        List<NodeHU> hospitalUnits = new ArrayList<>();
        hospitalUnits.add(huCreate);

        NodeService service = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits));
        List<NodeService> services = new ArrayList<>();
        services.add(service);

        NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
        List<NodePole> poles = new ArrayList<>();
        poles.add(pole);

        NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
        List<NodeHospital> hospitals = new ArrayList<>();
        hospitals.add(hospital);

        NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
        huCreate.setService(service);
        service.setPole(pole);
        pole.setHospital(hospital);
        hospital.setAPHP(aphp);

        Node p = dataManager.getNode(pole.getType(), pole.getId());

        assertTrue(dataManager.createAPHP(aphp));
        assertTrue(dataManager.createHospital(hospital));
        assertTrue(dataManager.createPole(pole));
        assertTrue(dataManager.createService(service));
        assertTrue(dataManager.createHospitalUnit(huCreate));

        MedicalRecord mRecord = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", "M", huCreate));
        Doctor doc = Mockito.spy(new Doctor(StaffEnum.DOCTOR, "Dupond", "Patrick", "5 Avenue de Paris", "patoche@gmail.com", "0718548716", p, pediatrie));
        Diagnostic diagnostic = Mockito.spy(new Diagnostic("Diagnostic", doc, mRecord, "14/01/2018", "Mal à la tête"));

        assertTrue(doctor.createMedicalRecord(mRecord));
        assertTrue(doctor.createDiagnostic(diagnostic));
        assertTrue(doctor.validateDiagnostic(diagnostic.getId()));
        assertFalse(doctor.validateDiagnostic(diagnostic.getId()));
    }

    /**
     * Test if a Diagnostic exists, it remove the draft
     */
    @Test
    public void testRemoveDraftDiagnostic() {
        JPADataManager dataManager = Mockito.spy(new JPADataManager());
        JPADoctor doctor = Mockito.spy(new JPADoctor());

        Specialization pediatrie = Mockito.spy(new Specialization(SpecializationEnum.Pediatrie));
        Specialization andrologie = Mockito.spy(new Specialization(SpecializationEnum.Andrologie));
        Specialization cardiologie = Mockito.spy(new Specialization(SpecializationEnum.Cardiologie));

        NodeHU huCreate = Mockito.spy(new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie));
        List<NodeHU> hospitalUnits = new ArrayList<>();
        hospitalUnits.add(huCreate);

        NodeService service = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits));
        List<NodeService> services = new ArrayList<>();
        services.add(service);

        NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
        List<NodePole> poles = new ArrayList<>();
        poles.add(pole);

        NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
        List<NodeHospital> hospitals = new ArrayList<>();
        hospitals.add(hospital);

        NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
        huCreate.setService(service);
        service.setPole(pole);
        pole.setHospital(hospital);
        hospital.setAPHP(aphp);

        Node p = dataManager.getNode(pole.getType(), pole.getId());

        assertTrue(dataManager.createAPHP(aphp));
        assertTrue(dataManager.createHospital(hospital));
        assertTrue(dataManager.createPole(pole));
        assertTrue(dataManager.createService(service));
        assertTrue(dataManager.createHospitalUnit(huCreate));

        MedicalRecord mRecord = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", "M", huCreate));
        Doctor doc = Mockito.spy(new Doctor(StaffEnum.DOCTOR, "Dupond", "Patrick", "5 Avenue de Paris", "patoche@gmail.com", "0718548716", p, pediatrie));
        Diagnostic diagnostic = Mockito.spy(new Diagnostic("Diagnostic", doc, mRecord, "14/01/2018", "Mal à la tête"));

        assertTrue(doctor.createMedicalRecord(mRecord));
        assertTrue(doctor.createDiagnostic(diagnostic));
        assertTrue(doctor.removeDraftDiagnostic(diagnostic.getId()));
        assertFalse(doctor.removeDraftDiagnostic(diagnostic.getId()));
    }

    /**
     * Return an exception if a field is null
     */
    @Test
    public void testCreateDosageNull() {
        JPADoctor doctor = new JPADoctor();

        Mockito.doThrow(new NullPointerException()).when(doctor).createDosage(null);
    }

    /**
     * Test the creation of a Dosage
     */
    @Test
    public void testCreateDosage() {
        JPADataManager dataManager = Mockito.spy(new JPADataManager());
        JPADoctor doctor = Mockito.spy(new JPADoctor());

        Specialization pediatrie = Mockito.spy(new Specialization(SpecializationEnum.Pediatrie));
        Specialization andrologie = Mockito.spy(new Specialization(SpecializationEnum.Andrologie));
        Specialization cardiologie = Mockito.spy(new Specialization(SpecializationEnum.Cardiologie));

        NodeHU huCreate = Mockito.spy(new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie));
        List<NodeHU> hospitalUnits = new ArrayList<>();
        hospitalUnits.add(huCreate);

        NodeService service = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits));
        List<NodeService> services = new ArrayList<>();
        services.add(service);

        NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
        List<NodePole> poles = new ArrayList<>();
        poles.add(pole);

        NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
        List<NodeHospital> hospitals = new ArrayList<>();
        hospitals.add(hospital);

        NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
        huCreate.setService(service);
        service.setPole(pole);
        pole.setHospital(hospital);
        hospital.setAPHP(aphp);

        Node p = dataManager.getNode(pole.getType(), pole.getId());

        Doctor doctorCreate = Mockito.spy(new Doctor(StaffEnum.DOCTOR, "Durand", "Emilie", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", p, pediatrie));

        assertTrue(dataManager.createAPHP(aphp));
        assertTrue(dataManager.createHospital(hospital));
        assertTrue(dataManager.createPole(pole));
        assertTrue(dataManager.createService(service));
        assertTrue(dataManager.createHospitalUnit(huCreate));

        MedicalRecord mRecord = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", "M", huCreate));
        Diagnostic diagnostic = Mockito.spy(new Diagnostic("Diagnostic", doctorCreate, mRecord, "10/01/2018", "Mal à la tête"));
        Dosage dosage = Mockito.spy(new Dosage("Posologie", doctorCreate, mRecord, "15/01/2018", diagnostic, "Prendre 2g d'aspirine", "16/01/2018", "20/01/2018"));

        assertTrue(doctor.createMedicalRecord(mRecord));
        assertTrue(doctor.createDosage(dosage));
        assertFalse(doctor.createDosage(dosage));
    }

    /**
     * Test if a Dosage exists, it validate them
     */
    @Test
    public void testValidateDosage() {
        JPADataManager dataManager = Mockito.spy(new JPADataManager());
        JPADoctor doctor = Mockito.spy(new JPADoctor());

        Specialization pediatrie = Mockito.spy(new Specialization(SpecializationEnum.Pediatrie));
        Specialization andrologie = Mockito.spy(new Specialization(SpecializationEnum.Andrologie));
        Specialization cardiologie = Mockito.spy(new Specialization(SpecializationEnum.Cardiologie));

        NodeHU huCreate = Mockito.spy(new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie));
        List<NodeHU> hospitalUnits = new ArrayList<>();
        hospitalUnits.add(huCreate);

        NodeService service = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits));
        List<NodeService> services = new ArrayList<>();
        services.add(service);

        NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
        List<NodePole> poles = new ArrayList<>();
        poles.add(pole);

        NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
        List<NodeHospital> hospitals = new ArrayList<>();
        hospitals.add(hospital);

        NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
        huCreate.setService(service);
        service.setPole(pole);
        pole.setHospital(hospital);
        hospital.setAPHP(aphp);

        Node p = dataManager.getNode(pole.getType(), pole.getId());

        Doctor doctorCreate = Mockito.spy(new Doctor(StaffEnum.DOCTOR, "Durand", "Emilie", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", p, pediatrie));

        assertTrue(dataManager.createAPHP(aphp));
        assertTrue(dataManager.createHospital(hospital));
        assertTrue(dataManager.createPole(pole));
        assertTrue(dataManager.createService(service));
        assertTrue(dataManager.createHospitalUnit(huCreate));

        MedicalRecord mRecord = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", "M", huCreate));
        Diagnostic diagnostic = Mockito.spy(new Diagnostic("Diagnostic", doctorCreate, mRecord, "10/01/2018", "Mal à la tête"));
        Dosage dosage = Mockito.spy(new Dosage("Posologie", doctorCreate, mRecord, "15/01/2018", diagnostic, "Prendre 2g d'aspirine", "16/01/2018", "20/01/2018"));

        assertTrue(doctor.createMedicalRecord(mRecord));
        assertTrue(doctor.createDosage(dosage));
        assertTrue(doctor.validateDosage(dosage.getId()));
        assertFalse(doctor.validateDosage(dosage.getId()));
    }

    /**
     * Test if a Dosage exists, it remove the draft
     */
    @Test
    public void testRemoveDraftDosage() {
        JPADataManager dataManager = Mockito.spy(new JPADataManager());
        JPADoctor doctor = Mockito.spy(new JPADoctor());

        Specialization pediatrie = Mockito.spy(new Specialization(SpecializationEnum.Pediatrie));
        Specialization andrologie = Mockito.spy(new Specialization(SpecializationEnum.Andrologie));
        Specialization cardiologie = Mockito.spy(new Specialization(SpecializationEnum.Cardiologie));

        NodeHU huCreate = Mockito.spy(new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie));
        List<NodeHU> hospitalUnits = new ArrayList<>();
        hospitalUnits.add(huCreate);

        NodeService service = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits));
        List<NodeService> services = new ArrayList<>();
        services.add(service);

        NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
        List<NodePole> poles = new ArrayList<>();
        poles.add(pole);

        NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
        List<NodeHospital> hospitals = new ArrayList<>();
        hospitals.add(hospital);

        NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
        huCreate.setService(service);
        service.setPole(pole);
        pole.setHospital(hospital);
        hospital.setAPHP(aphp);

        Node p = dataManager.getNode(pole.getType(), pole.getId());

        Doctor doctorCreate = Mockito.spy(new Doctor(StaffEnum.DOCTOR, "Durand", "Emilie", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", p, pediatrie));

        assertTrue(dataManager.createAPHP(aphp));
        assertTrue(dataManager.createHospital(hospital));
        assertTrue(dataManager.createPole(pole));
        assertTrue(dataManager.createService(service));
        assertTrue(dataManager.createHospitalUnit(huCreate));

        MedicalRecord mRecord = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", "M", huCreate));
        Diagnostic diagnostic = Mockito.spy(new Diagnostic("Diagnostic", doctorCreate, mRecord, "10/01/2018", "Mal à la tête"));
        Dosage dosage = Mockito.spy(new Dosage("Posologie", doctorCreate, mRecord, "15/01/2018", diagnostic, "Prendre 2g d'aspirine", "16/01/2018", "20/01/2018"));

        assertTrue(doctor.createMedicalRecord(mRecord));
        assertTrue(doctor.createDosage(dosage));
        assertTrue(doctor.removeDraftDosage(dosage.getId()));
        assertFalse(doctor.removeDraftDosage(dosage.getId()));
    }

    /**
     * Test if a MedicalRecord exists, it don't returns null
     */
    @Test
    public void testGetMedicalRecord() {
        JPADataManager dataManager = Mockito.spy(new JPADataManager());
        JPADoctor doctor = Mockito.spy(new JPADoctor());

        Specialization pediatrie = Mockito.spy(new Specialization(SpecializationEnum.Pediatrie));
        Specialization andrologie = Mockito.spy(new Specialization(SpecializationEnum.Andrologie));
        Specialization cardiologie = Mockito.spy(new Specialization(SpecializationEnum.Cardiologie));

        NodeHU huCreate = Mockito.spy(new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie));
        List<NodeHU> hospitalUnits = new ArrayList<>();
        hospitalUnits.add(huCreate);

        NodeService service = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits));
        List<NodeService> services = new ArrayList<>();
        services.add(service);

        NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
        List<NodePole> poles = new ArrayList<>();
        poles.add(pole);

        NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
        List<NodeHospital> hospitals = new ArrayList<>();
        hospitals.add(hospital);

        NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
        huCreate.setService(service);
        service.setPole(pole);
        pole.setHospital(hospital);
        hospital.setAPHP(aphp);

        assertTrue(dataManager.createAPHP(aphp));
        assertTrue(dataManager.createHospital(hospital));
        assertTrue(dataManager.createPole(pole));
        assertTrue(dataManager.createService(service));
        assertTrue(dataManager.createHospitalUnit(huCreate));

        MedicalRecord mRecordCreate = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", "M", huCreate));

        assertTrue(doctor.createMedicalRecord(mRecordCreate));

        MedicalRecord mRecordResult = doctor.getMedicalRecord(mRecordCreate.getId());

        assertNotNull(mRecordResult);
        assertEquals(mRecordCreate.getId(), mRecordResult.getId());
        assertEquals(mRecordCreate.getSs(), mRecordResult.getSs());
        assertEquals(mRecordCreate.getLastName(), mRecordResult.getLastName());
        assertEquals(mRecordCreate.getFirstName(), mRecordResult.getFirstName());
        assertEquals(mRecordCreate.getEmail(), mRecordResult.getEmail());
        assertEquals(mRecordCreate.getAddress(), mRecordResult.getAddress());
        assertEquals(mRecordCreate.getPhoneNumber(), mRecordResult.getPhoneNumber());
        assertEquals(mRecordCreate.getBirthday(), mRecordResult.getBirthday());
        assertEquals(mRecordCreate.getGender(), mRecordResult.getGender());
    }

    /**
     * Test if a Dosage exists, it don't returns null
     */
    @Test
    public void testGetDosage() {
        JPADataManager dataManager = Mockito.spy(new JPADataManager());
        JPADoctor doctor = Mockito.spy(new JPADoctor());

        Specialization pediatrie = Mockito.spy(new Specialization(SpecializationEnum.Pediatrie));
        Specialization andrologie = Mockito.spy(new Specialization(SpecializationEnum.Andrologie));
        Specialization cardiologie = Mockito.spy(new Specialization(SpecializationEnum.Cardiologie));

        NodeHU huCreate = Mockito.spy(new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie));
        List<NodeHU> hospitalUnits = new ArrayList<>();
        hospitalUnits.add(huCreate);

        NodeService service = Mockito.spy(new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits));
        List<NodeService> services = new ArrayList<>();
        services.add(service);

        NodePole pole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie, services));
        List<NodePole> poles = new ArrayList<>();
        poles.add(pole);

        NodeHospital hospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
        List<NodeHospital> hospitals = new ArrayList<>();
        hospitals.add(hospital);

        NodeAPHP aphp = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
        huCreate.setService(service);
        service.setPole(pole);
        pole.setHospital(hospital);
        hospital.setAPHP(aphp);

        Node p = dataManager.getNode(pole.getType(), pole.getId());

        Doctor doctorCreate = Mockito.spy(new Doctor(StaffEnum.DOCTOR, "Durand", "Emilie", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", p, pediatrie));

        assertTrue(dataManager.createAPHP(aphp));
        assertTrue(dataManager.createHospital(hospital));
        assertTrue(dataManager.createPole(pole));
        assertTrue(dataManager.createService(service));
        assertTrue(dataManager.createHospitalUnit(huCreate));

        MedicalRecord mRecord = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", "M", huCreate));
        Diagnostic diagnostic = Mockito.spy(new Diagnostic("Diagnostic", doctorCreate, mRecord, "10/01/2018", "Mal à la tête"));
        Dosage dosageCreate = Mockito.spy(new Dosage("Posologie", doctorCreate, mRecord, "15/01/2018", diagnostic, "Prendre 2g d'aspirine", "16/01/2018", "20/01/2018"));

        assertTrue(doctor.createMedicalRecord(mRecord));
        assertTrue(doctor.createDosage(dosageCreate));

        Dosage dosageResult = doctor.getDosage(dosageCreate.getId());

        assertNotNull(dosageResult);
        assertEquals(dosageCreate.getId(), dosageResult.getId());
        assertEquals(dosageCreate.getBeginDosage(), dosageResult.getBeginDosage());
        assertEquals(dosageCreate.getEndDosage(), dosageResult.getEndDosage());
        assertEquals(dosageCreate.getDoctorConsulting(), dosageResult.getDoctorConsulting());
    }

    /**
     * Test if a Doctor exists, it don't returns null
     */
    @Test
    public void testGetDoctor() {
        JPADataManager dataManager = Mockito.spy(new JPADataManager());
        JPADoctor doctor = Mockito.spy(new JPADoctor());

        Specialization pediatrie = Mockito.spy(new Specialization(SpecializationEnum.Pediatrie));

        NodePole nodePole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie));
        List<NodePole> poles = new ArrayList<>();
        poles.add(nodePole);

        NodeHospital nodeHospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
        List<NodeHospital> hospitals = new ArrayList<>();
        hospitals.add(nodeHospital);

        NodeAPHP nodeAPHP = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));

        nodeHospital.setAPHP(nodeAPHP);
        nodePole.setHospital(nodeHospital);

        Node pole = new Node(nodePole.getType(), nodePole.getId());

        Doctor doctorCreate = Mockito.spy(new Doctor(StaffEnum.DOCTOR, "Durand", "Emilie", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", pole, pediatrie));

        assertTrue(dataManager.createAPHP(nodeAPHP));
        assertTrue(dataManager.createHospital(nodeHospital));
        assertTrue(dataManager.createPole(nodePole));
        assertTrue(dataManager.createDoctor(doctorCreate));

        Doctor doctorResult = doctor.getDoctor(doctorCreate.getId());

        assertNotNull(doctorResult);
        assertEquals(doctorCreate.getLastName(), doctorResult.getLastName());
        assertEquals(doctorCreate.getFirstName(), doctorResult.getFirstName());
        assertEquals(doctorCreate.getAdress(), doctorResult.getAdress());
        assertEquals(doctorCreate.getEmail(), doctorResult.getEmail());
        assertEquals(doctorCreate.getPhoneNumber(), doctorResult.getPhoneNumber());
        assertEquals(doctorCreate.getNode(), doctorResult.getNode());
        assertEquals(doctorCreate.getSpecialization(), doctorResult.getSpecialization());
    }

    /**
     * Test if a Nurse exists, it don't returns null
     */
    @Test
    public void testGetNurse() {
        JPADataManager dataManager = Mockito.spy(new JPADataManager());
        JPADoctor doctor = Mockito.spy(new JPADoctor());

        Specialization pediatrie = Mockito.spy(new Specialization(SpecializationEnum.Pediatrie));

        NodePole nodePole = Mockito.spy(new NodePole(NodeEnum.POLE, pediatrie));
        List<NodePole> poles = new ArrayList<>();
        poles.add(nodePole);

        NodeHospital nodeHospital = Mockito.spy(new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles));
        List<NodeHospital> hospitals = new ArrayList<>();
        hospitals.add(nodeHospital);

        NodeAPHP nodeAPHP = Mockito.spy(new NodeAPHP(NodeEnum.APHP, hospitals));
        nodePole.setHospital(nodeHospital);
        nodeHospital.setAPHP(nodeAPHP);

        Node pole = new Node(nodePole.getType(), nodePole.getId());

        Nurse nurseCreate = Mockito.spy(new Nurse(StaffEnum.NURSE, "Durand", "Emilie", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", pole));

        assertTrue(dataManager.createAPHP(nodeAPHP));
        assertTrue(dataManager.createHospital(nodeHospital));
        assertTrue(dataManager.createPole(nodePole));
        assertTrue(dataManager.createNurse(nurseCreate));

        Nurse nurseResult = doctor.getNurse(nurseCreate.getId());

        assertNotNull(nurseResult);
        assertEquals(nurseCreate.getLastName(), nurseResult.getLastName());
        assertEquals(nurseCreate.getFirstName(), nurseResult.getFirstName());
        assertEquals(nurseCreate.getAdress(), nurseResult.getAdress());
        assertEquals(nurseCreate.getEmail(), nurseResult.getEmail());
        assertEquals(nurseCreate.getPhoneNumber(), nurseResult.getPhoneNumber());
        assertEquals(nurseCreate.getNode(), nurseResult.getNode());
    }
}
