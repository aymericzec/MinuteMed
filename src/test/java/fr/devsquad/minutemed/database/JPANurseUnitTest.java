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
import fr.devsquad.minutemed.dmp.GenderEnum;
import fr.devsquad.minutemed.dmp.MedicalRecord;
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
public class JPANurseUnitTest {

    /**
     * Test if a MedicalRecord exists, it don't returns null
     */
    @Test
    public void testGetMedicalRecord() {
        JPADataManager dataManager = Mockito.spy(new JPADataManager());
        JPADoctor doctor = Mockito.spy(new JPADoctor());
        JPANurse nurse = Mockito.spy(new JPANurse());

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

        MedicalRecord mRecordResult = nurse.getMedicalRecord(mRecordCreate.getId());

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
     * Test if MedicalRecords exists, it don't returns null
     */
    @Test
    public void testGetAllMedicalRecords() {
        JPADataManager dataManager = Mockito.spy(new JPADataManager());
        JPADoctor doctor = Mockito.spy(new JPADoctor());
        JPANurse nurse = Mockito.spy(new JPANurse());

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

        MedicalRecord mRecord1 = Mockito.spy(new MedicalRecord("1950745656561", "Menez", "Pierre", "5 rue Saint Antoine", "pierrot@gmail.com", "0745898751", "14/08/1964", "M", huCreate));
        MedicalRecord mRecord2 = Mockito.spy(new MedicalRecord("1947851035104", "Durand", "Emilie", "5 rue de Paris", "emilie.durand@gmail.com", "0712018751", "17/11/1994", "F", huCreate));

        assertTrue(doctor.createMedicalRecord(mRecord1));
        assertTrue(doctor.createMedicalRecord(mRecord2));
        assertNotNull(nurse.getAllMedicalRecords());
    }

    /**
     * Test if a Dosage exists, it don't returns null
     */
    @Test
    public void testGetDosage() {
        JPADataManager dataManager = Mockito.spy(new JPADataManager());
        JPADoctor doctor = Mockito.spy(new JPADoctor());
        JPANurse nurse = Mockito.spy(new JPANurse());

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

        Dosage dosageResult = nurse.getDosage(dosageCreate.getId());

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
        JPANurse nurse = Mockito.spy(new JPANurse());

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

        Doctor doctorCreate = Mockito.spy(new Doctor(StaffEnum.DOCTOR, "Durand", "Emilie", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", pole, pediatrie));

        assertTrue(dataManager.createAPHP(nodeAPHP));
        assertTrue(dataManager.createHospital(nodeHospital));
        assertTrue(dataManager.createPole(nodePole));
        assertTrue(dataManager.createDoctor(doctorCreate));

        Doctor doctorResult = nurse.getDoctor(doctorCreate.getId());

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
        JPANurse nurse = Mockito.spy(new JPANurse());

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

        Node pole = dataManager.getNode(nodePole.getType(), nodePole.getId());

        Nurse nurseCreate = Mockito.spy(new Nurse(StaffEnum.NURSE, "Durand", "Emilie", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", pole));

        assertTrue(dataManager.createAPHP(nodeAPHP));
        assertTrue(dataManager.createHospital(nodeHospital));
        assertTrue(dataManager.createPole(nodePole));
        assertTrue(dataManager.createNurse(nurseCreate));

        Nurse nurseResult = nurse.getNurse(nurseCreate.getId());

        assertNotNull(nurseResult);
        assertEquals(nurseCreate.getLastName(), nurseResult.getLastName());
        assertEquals(nurseCreate.getFirstName(), nurseResult.getFirstName());
        assertEquals(nurseCreate.getAdress(), nurseResult.getAdress());
        assertEquals(nurseCreate.getEmail(), nurseResult.getEmail());
        assertEquals(nurseCreate.getPhoneNumber(), nurseResult.getPhoneNumber());
        assertEquals(nurseCreate.getNode(), nurseResult.getNode());
    }
}
