package fr.devsquad.minutemed.database;
//
//    /**
//     * Return an exception if a field is null
//     */
//    @Test(expected = NullPointerException.class)
//    public void testCreateAccountNull() {
//        JPADataManager dataManager = new JPADataManager();
//        dataManager.createAccount(null);
//    }
//
//    /**
//     * Test if a account is already present in the database or not, to create
//     * them
//     */
//    @Test
//    public void testCreateAccount() {
//        JPADataManager dataManager = new JPADataManager();
//
//        Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
//
//        NodePole nodePole = new NodePole(NodeEnum.POLE, pediatrie);
//        List<NodePole> poles = new ArrayList<>();
//        poles.add(nodePole);
//
//        NodeHospital nodeHospital = new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles);
//        List<NodeHospital> hospitals = new ArrayList<>();
//        hospitals.add(nodeHospital);
//
//        NodeAPHP nodeAPHP = new NodeAPHP(NodeEnum.APHP, hospitals);
//
//        nodeHospital.setAPHP(nodeAPHP);
//        nodePole.setHospital(nodeHospital);
//        
//        assertTrue(dataManager.createAPHP(nodeAPHP));
//        assertTrue(dataManager.createPole(nodePole));
//
//        Node pole = dataManager.getNode(nodePole.getType(), nodePole.getId());
//
//        Doctor doctor = new Doctor(StaffEnum.DOCTOR, "Dupont", "Patrick", "5 Avenue de la Republique", "patoche@gmail.com", "0718547896", pole, pediatrie);
//        Nurse nurse = new Nurse(StaffEnum.NURSE, "Durand", "Emilie", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", pole);
//
//        assertTrue(dataManager.createDoctor(doctor));
//        assertTrue(dataManager.createNurse(nurse));
//        
//        MedicalStaff d = dataManager.getMedicalStaff(doctor.getType(), doctor.getId());
//        MedicalStaff n = dataManager.getMedicalStaff(nurse.getType(), nurse.getId());
//
//        UserAccount doctorAccount = new UserAccount("pseudoDoctor", "passwordDoctor", d);
//        UserAccount nurseAccount = new UserAccount("pseudoNurse", "passwordNurse", n);       
//        
//        assertTrue(dataManager.createAccount(doctorAccount));
//        assertTrue(dataManager.createAccount(nurseAccount));
//        assertFalse(dataManager.createAccount(doctorAccount));
//    }
//
//    /**
//     * Test if an account is present in the database to remove them
//     */
//    @Test
//    public void testRemoveAccount() {
//        JPADataManager dataManager = new JPADataManager();
//
//        Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
//
//        NodePole nodePole = new NodePole(NodeEnum.POLE, pediatrie);
//        List<NodePole> poles = new ArrayList<>();
//        poles.add(nodePole);
//
//        NodeHospital nodeHospital = new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles);
//        List<NodeHospital> hospitals = new ArrayList<>();
//        hospitals.add(nodeHospital);
//
//        NodeAPHP nodeAPHP = new NodeAPHP(NodeEnum.APHP, hospitals);
//
//        nodeHospital.setAPHP(nodeAPHP);
//        nodePole.setHospital(nodeHospital);
//        
//        assertTrue(dataManager.createAPHP(nodeAPHP));
//        assertTrue(dataManager.createPole(nodePole));
//
//        Node pole = dataManager.getNode(nodePole.getType(), nodePole.getId());
//
//        Doctor doctor = new Doctor(StaffEnum.DOCTOR, "Dupont", "Patrick", "5 Avenue de la Republique", "patoche@gmail.com", "0718547896", pole, pediatrie);
//
//        assertTrue(dataManager.createDoctor(doctor));
//        
//        MedicalStaff d = dataManager.getMedicalStaff(doctor.getType(), doctor.getId());
//
//        UserAccount doctorAccount = new UserAccount("pseudoDoctor", "passwordDoctor", d);      
//        
//        assertTrue(dataManager.createAccount(doctorAccount));
//        assertTrue(dataManager.removeAccount(doctorAccount.getIdAccount()));
//        assertFalse(dataManager.removeAccount(doctorAccount.getIdAccount()));
//    }
//
//    /**
//     * Return an exception if a field is null
//     */
//    @Test(expected = NullPointerException.class)
//    public void testCreateHospitalNull() {
//        JPADataManager dataManager = new JPADataManager();
//        dataManager.createHospital(null);
//    }
//
//    /**
//     * Test the creation of an Hospital
//     */
//    @Test
//    public void testCreateHospital() {
//        JPADataManager dataManager = new JPADataManager();
//
//        NodeHospital hospital = new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris");
//        List<NodeHospital> hospitals = new ArrayList<>();
//        hospitals.add(hospital);
//
//        NodeAPHP aphp = new NodeAPHP(NodeEnum.APHP, hospitals);
//        hospital.setAPHP(aphp);
//
//        assertTrue(dataManager.createAPHP(aphp));
//        assertTrue(dataManager.createHospital(hospital));
//        assertFalse(dataManager.createHospital(hospital));
//    }
//
//    /**
//     * Test if an Hospital exists, it don't returns null
//     */
//    @Test
//    public void testGetHospital() {
//        JPADataManager dataManager = new JPADataManager();
//
//        NodeHospital hospitalCreate = new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris");
//        List<NodeHospital> hospitals = new ArrayList<>();
//        hospitals.add(hospitalCreate);
//
//        NodeAPHP aphp = new NodeAPHP(NodeEnum.APHP, hospitals);
//        hospitalCreate.setAPHP(aphp);
//
//        assertTrue(dataManager.createAPHP(aphp));
//        assertTrue(dataManager.createHospital(hospitalCreate));
//
//        NodeHospital hospitalResult = dataManager.getHospital(hospitalCreate.getId());
//
//        assertNotNull(hospitalResult);
//        assertEquals(hospitalCreate.getId(), hospitalResult.getId());
//        assertEquals(hospitalCreate.getName(), hospitalResult.getName());
//        assertEquals(hospitalCreate.getType(), hospitalResult.getType());
//    }
//
//    /**
//     * Return an exception if a field is null
//     */
//    @Test(expected = NullPointerException.class)
//    public void testCreatePoleNull() {
//        JPADataManager dataManager = new JPADataManager();
//        dataManager.createPole(null);
//    }
//
//    /**
//     * Test the creation of a Pole
//     */
//    @Test
//    public void testCreatePole() {
//        JPADataManager dataManager = new JPADataManager();
//
//        Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
//
//        NodePole pole = new NodePole(NodeEnum.POLE, pediatrie);
//        List<NodePole> poles = new ArrayList<>();
//        poles.add(pole);
//
//        NodeHospital hospital = new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles);
//        List<NodeHospital> hospitals = new ArrayList<>();
//        hospitals.add(hospital);
//
//        NodeAPHP aphp = new NodeAPHP(NodeEnum.APHP, hospitals);
//        pole.setHospital(hospital);
//        hospital.setAPHP(aphp);
//
//        assertTrue(dataManager.createAPHP(aphp));
//        assertTrue(dataManager.createHospital(hospital));
//        assertTrue(dataManager.createPole(pole));
//    }
//
//    /**
//     * Test if a Pole exists, it don't returns null
//     */
//    @Test
//    public void testGetPole() {
//        JPADataManager dataManager = new JPADataManager();
//
//        Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
//
//        NodePole poleCreate = new NodePole(NodeEnum.POLE, pediatrie);
//        List<NodePole> poles = new ArrayList<>();
//        poles.add(poleCreate);
//
//        NodeHospital hospital = new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles);
//        List<NodeHospital> hospitals = new ArrayList<>();
//        hospitals.add(hospital);
//
//        NodeAPHP aphp = new NodeAPHP(NodeEnum.APHP, hospitals);
//        poleCreate.setHospital(hospital);
//        hospital.setAPHP(aphp);
//
//        assertTrue(dataManager.createAPHP(aphp));
//        assertTrue(dataManager.createHospital(hospital));
//        assertTrue(dataManager.createPole(poleCreate));
//
//        NodePole poleResult = dataManager.getPole(poleCreate.getId());
//
//        assertNotNull(poleResult);
//        assertEquals(poleCreate.getId(), poleResult.getId());
//        assertEquals(poleCreate.getType(), poleResult.getType());
//        assertEquals(poleCreate.getSpecialization(), poleResult.getSpecialization());
//    }
//
//    /**
//     * Return an exception if a field is null
//     */
//    @Test(expected = NullPointerException.class)
//    public void testCreateServiceNull() {
//        JPADataManager dataManager = new JPADataManager();
//        dataManager.createService(null);
//    }
//
//    /**
//     * Test the creation of a Service
//     */
//    @Test
//    public void testCreateService() {
//        JPADataManager dataManager = new JPADataManager();
//
//        Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
//        Specialization andrologie = new Specialization(SpecializationEnum.Andrologie);
//
//        NodeService service = new NodeService(NodeEnum.SERVICE, andrologie);
//        List<NodeService> services = new ArrayList<>();
//        services.add(service);
//
//        NodePole pole = new NodePole(NodeEnum.POLE, pediatrie, services);
//        List<NodePole> poles = new ArrayList<>();
//        poles.add(pole);
//
//        NodeHospital hospital = new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles);
//        List<NodeHospital> hospitals = new ArrayList<>();
//        hospitals.add(hospital);
//
//        NodeAPHP aphp = new NodeAPHP(NodeEnum.APHP, hospitals);
//        service.setPole(pole);
//        pole.setHospital(hospital);
//        hospital.setAPHP(aphp);
//
//        assertTrue(dataManager.createAPHP(aphp));
//        assertTrue(dataManager.createHospital(hospital));
//        assertTrue(dataManager.createPole(pole));
//        assertTrue(dataManager.createService(service));
//        assertFalse(dataManager.createService(service));
//    }
//
//    /**
//     * Test if a Service exists, it don't returns null
//     */
//    @Test
//    public void testGetService() {
//        JPADataManager dataManager = new JPADataManager();
//
//        Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
//        Specialization andrologie = new Specialization(SpecializationEnum.Andrologie);
//
//        NodeService serviceCreate = new NodeService(NodeEnum.SERVICE, andrologie);
//        List<NodeService> services = new ArrayList<>();
//        services.add(serviceCreate);
//
//        NodePole pole = new NodePole(NodeEnum.POLE, pediatrie, services);
//        List<NodePole> poles = new ArrayList<>();
//        poles.add(pole);
//
//        NodeHospital hospital = new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles);
//        List<NodeHospital> hospitals = new ArrayList<>();
//        hospitals.add(hospital);
//
//        NodeAPHP aphp = new NodeAPHP(NodeEnum.APHP, hospitals);
//        serviceCreate.setPole(pole);
//        pole.setHospital(hospital);
//        hospital.setAPHP(aphp);
//
//        assertTrue(dataManager.createAPHP(aphp));
//        assertTrue(dataManager.createHospital(hospital));
//        assertTrue(dataManager.createPole(pole));
//        assertTrue(dataManager.createService(serviceCreate));
//
//        NodeService serviceResult = dataManager.getService(serviceCreate.getId());
//
//        assertNotNull(serviceResult);
//        assertEquals(serviceCreate.getId(), serviceResult.getId());
//        assertEquals(serviceCreate.getType(), serviceResult.getType());
//        assertEquals(serviceCreate.getSpecialization(), serviceResult.getSpecialization());
//    }
//    
//    /**
//     * Return an exception if a field is null
//     */
//    @Test(expected = NullPointerException.class)
//    public void testCreateHospitalUnitNull() {
//        JPADataManager dataManager = new JPADataManager();
//        dataManager.createHospitalUnit(null);
//    }
//
//    /**
//     * Test the creation of a Hospital Unit
//     */
//    @Test
//    public void testCreateHospitalUnit() {
//        JPADataManager dataManager = new JPADataManager();
//
//        Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
//        Specialization andrologie = new Specialization(SpecializationEnum.Andrologie);
//        Specialization cardiologie = new Specialization(SpecializationEnum.Cardiologie);
//
//        NodeHU hu = new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie);
//        List<NodeHU> hospitalUnits = new ArrayList<>();
//        hospitalUnits.add(hu);
//
//        NodeService service = new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits);
//        List<NodeService> services = new ArrayList<>();
//        services.add(service);
//
//        NodePole pole = new NodePole(NodeEnum.POLE, pediatrie, services);
//        List<NodePole> poles = new ArrayList<>();
//        poles.add(pole);
//
//        NodeHospital hospital = new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles);
//        List<NodeHospital> hospitals = new ArrayList<>();
//        hospitals.add(hospital);
//
//        NodeAPHP aphp = new NodeAPHP(NodeEnum.APHP, hospitals);
//        hu.setService(service);
//        service.setPole(pole);
//        pole.setHospital(hospital);
//        hospital.setAPHP(aphp);
//
//        assertTrue(dataManager.createAPHP(aphp));
//        assertTrue(dataManager.createHospital(hospital));
//        assertTrue(dataManager.createPole(pole));
//        assertTrue(dataManager.createService(service));
//        assertTrue(dataManager.createHospitalUnit(hu));
//        assertFalse(dataManager.createHospitalUnit(hu));
//    }
//
//    /**
//     * Test if a Hospital Unit exists, it don't returns null
//     */
//    @Test
//    public void testGetHospitalUnit() {
//        JPADataManager dataManager = new JPADataManager();
//
//        Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
//        Specialization andrologie = new Specialization(SpecializationEnum.Andrologie);
//        Specialization cardiologie = new Specialization(SpecializationEnum.Cardiologie);
//
//        NodeHU huCreate = new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie);
//        List<NodeHU> hospitalUnits = new ArrayList<>();
//        hospitalUnits.add(huCreate);
//
//        NodeService service = new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits);
//        List<NodeService> services = new ArrayList<>();
//        services.add(service);
//
//        NodePole pole = new NodePole(NodeEnum.POLE, pediatrie, services);
//        List<NodePole> poles = new ArrayList<>();
//        poles.add(pole);
//
//        NodeHospital hospital = new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles);
//        List<NodeHospital> hospitals = new ArrayList<>();
//        hospitals.add(hospital);
//
//        NodeAPHP aphp = new NodeAPHP(NodeEnum.APHP, hospitals);
//        huCreate.setService(service);
//        service.setPole(pole);
//        pole.setHospital(hospital);
//        hospital.setAPHP(aphp);
//
//        assertTrue(dataManager.createAPHP(aphp));
//        assertTrue(dataManager.createHospital(hospital));
//        assertTrue(dataManager.createPole(pole));
//        assertTrue(dataManager.createService(service));
//        assertTrue(dataManager.createHospitalUnit(huCreate));
//
//        NodeHU huResult = dataManager.getHospitalUnit(huCreate.getId());
//
//        assertNotNull(huResult);
//        assertEquals(huCreate.getId(), huResult.getId());
//        assertEquals(huCreate.getType(), huResult.getType());
//        assertEquals(huCreate.getSpecialization(), huResult.getSpecialization());
//    }
//    
//    /**
//     * Return an exception if a field is null
//     */
//    @Test(expected = NullPointerException.class)
//    public void testCreateCareUnitNull() {
//        JPADataManager dataManager = new JPADataManager();
//        dataManager.createCareUnit(null);
//    }
//
//    /**
//     * Test the creation of a Care Unit
//     */
//    @Test
//    public void testCreateCareUnit() {
//        JPADataManager dataManager = new JPADataManager();
//
//        Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
//        Specialization andrologie = new Specialization(SpecializationEnum.Andrologie);
//        Specialization cardiologie = new Specialization(SpecializationEnum.Cardiologie);
//        Specialization neonatologie = new Specialization(SpecializationEnum.Neonatologie);
//
//        NodeCU cu = new NodeCU(NodeEnum.CARE_UNIT, neonatologie);
//        List<NodeCU> careUnits = new ArrayList<>();
//        careUnits.add(cu);
//
//        NodeHU hu = new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie, careUnits);
//        List<NodeHU> hospitalUnits = new ArrayList<>();
//        hospitalUnits.add(hu);
//
//        NodeService service = new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits);
//        List<NodeService> services = new ArrayList<>();
//        services.add(service);
//
//        NodePole pole = new NodePole(NodeEnum.POLE, pediatrie, services);
//        List<NodePole> poles = new ArrayList<>();
//        poles.add(pole);
//
//        NodeHospital hospital = new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles);
//        List<NodeHospital> hospitals = new ArrayList<>();
//        hospitals.add(hospital);
//
//        NodeAPHP aphp = new NodeAPHP(NodeEnum.APHP, hospitals);
//        cu.setHospitalUnit(hu);
//        hu.setService(service);
//        service.setPole(pole);
//        pole.setHospital(hospital);
//        hospital.setAPHP(aphp);
//
//        assertTrue(dataManager.createAPHP(aphp));
//        assertTrue(dataManager.createHospital(hospital));
//        assertTrue(dataManager.createPole(pole));
//        assertTrue(dataManager.createService(service));
//        assertTrue(dataManager.createHospitalUnit(hu));
//        assertTrue(dataManager.createCareUnit(cu));
//        assertFalse(dataManager.createCareUnit(cu));
//    }
//
//    /**
//     * Test if a Care Unit exists, it don't returns null
//     */
//    @Test
//    public void testGetCareUnit() {
//        JPADataManager dataManager = new JPADataManager();
//
//        Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
//        Specialization andrologie = new Specialization(SpecializationEnum.Andrologie);
//        Specialization cardiologie = new Specialization(SpecializationEnum.Cardiologie);
//        Specialization neonatologie = new Specialization(SpecializationEnum.Neonatologie);
//
//        NodeCU cuCreate = new NodeCU(NodeEnum.CARE_UNIT, neonatologie);
//        List<NodeCU> careUnits = new ArrayList<>();
//        careUnits.add(cuCreate);
//
//        NodeHU hu = new NodeHU(NodeEnum.HOSPITAL_UNIT, cardiologie, careUnits);
//        List<NodeHU> hospitalUnits = new ArrayList<>();
//        hospitalUnits.add(hu);
//
//        NodeService service = new NodeService(NodeEnum.SERVICE, andrologie, hospitalUnits);
//        List<NodeService> services = new ArrayList<>();
//        services.add(service);
//
//        NodePole pole = new NodePole(NodeEnum.POLE, pediatrie, services);
//        List<NodePole> poles = new ArrayList<>();
//        poles.add(pole);
//
//        NodeHospital hospital = new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles);
//        List<NodeHospital> hospitals = new ArrayList<>();
//        hospitals.add(hospital);
//
//        NodeAPHP aphp = new NodeAPHP(NodeEnum.APHP, hospitals);
//        cuCreate.setHospitalUnit(hu);
//        hu.setService(service);
//        service.setPole(pole);
//        pole.setHospital(hospital);
//        hospital.setAPHP(aphp);
//
//        assertTrue(dataManager.createAPHP(aphp));
//        assertTrue(dataManager.createHospital(hospital));
//        assertTrue(dataManager.createPole(pole));
//        assertTrue(dataManager.createService(service));
//        assertTrue(dataManager.createHospitalUnit(hu));
//        assertTrue(dataManager.createCareUnit(cuCreate));
//
//        NodeCU cuResult = dataManager.getCareUnit(cuCreate.getId());
//
//        assertNotNull(cuResult);
//        assertEquals(cuCreate.getId(), cuResult.getId());
//        assertEquals(cuCreate.getType(), cuResult.getType());
//        assertEquals(cuCreate.getSpecialization(), cuResult.getSpecialization());
//    }    
//
//    /**
//     * Return an exception if the doctor field is null
//     */
//    @Test(expected = NullPointerException.class)
//    public void testCreateDoctorNull() {
//        JPADataManager dataManager = new JPADataManager();
//        dataManager.createDoctor(null);
//    }
//
//    /**
//     * Test the creation of a Doctor
//     */
//    @Test
//    public void testCreateDoctor() {
//        JPADataManager dataManager = new JPADataManager();
//
//        Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
//
//        NodePole nodePole = new NodePole(NodeEnum.POLE, pediatrie);
//        List<NodePole> poles = new ArrayList<>();
//        poles.add(nodePole);
//
//        NodeHospital nodeHospital = new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles);
//        List<NodeHospital> hospitals = new ArrayList<>();
//        hospitals.add(nodeHospital);
//
//        NodeAPHP nodeAPHP = new NodeAPHP(NodeEnum.APHP, hospitals);
//        nodePole.setHospital(nodeHospital);
//        nodeHospital.setAPHP(nodeAPHP);
//        
//        assertTrue(dataManager.createAPHP(nodeAPHP));
//        assertTrue(dataManager.createHospital(nodeHospital));
//        assertTrue(dataManager.createPole(nodePole));
//        
//        Node pole = dataManager.getNode(nodePole.getType(), nodePole.getId());
//
//        Doctor doctor = new Doctor(StaffEnum.DOCTOR, "Durand", "Emilie", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", pole, pediatrie);
//        
//        assertTrue(dataManager.createDoctor(doctor));
//        assertFalse(dataManager.createDoctor(doctor));
//    }
//
//    /**
//     * Test if a Doctor exists, it don't returns null
//     */
//    @Test
//    public void testGetDoctor() {
//        JPADataManager dataManager = new JPADataManager();
//
//        Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
//
//        NodePole nodePole = new NodePole(NodeEnum.POLE, pediatrie);
//        List<NodePole> poles = new ArrayList<>();
//        poles.add(nodePole);
//
//        NodeHospital nodeHospital = new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles);
//        List<NodeHospital> hospitals = new ArrayList<>();
//        hospitals.add(nodeHospital);
//
//        NodeAPHP nodeAPHP = new NodeAPHP(NodeEnum.APHP, hospitals);
//
//        nodeHospital.setAPHP(nodeAPHP);
//        nodePole.setHospital(nodeHospital);
//
//        assertTrue(dataManager.createAPHP(nodeAPHP));
//        assertTrue(dataManager.createHospital(nodeHospital));
//        assertTrue(dataManager.createPole(nodePole));
//        
//        Node pole = dataManager.getNode(nodePole.getType(), nodePole.getId());
//
//        Doctor doctorCreate = new Doctor(StaffEnum.DOCTOR, "Durand", "Emilie", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", pole, pediatrie);
//        
//        assertTrue(dataManager.createDoctor(doctorCreate));
//
//        Doctor doctorResult = dataManager.getDoctor(doctorCreate.getId());
//
//        assertNotNull(doctorResult);
//        assertEquals(doctorCreate.getLastName(), doctorResult.getLastName());
//        assertEquals(doctorCreate.getFirstName(), doctorResult.getFirstName());
//        assertEquals(doctorCreate.getAdress(), doctorResult.getAdress());
//        assertEquals(doctorCreate.getEmail(), doctorResult.getEmail());
//        assertEquals(doctorCreate.getPhoneNumber(), doctorResult.getPhoneNumber());
//        assertEquals(doctorCreate.getSpecialization(), doctorResult.getSpecialization());
//    }
//
//    /**
//     * Test if a Doctor exists, it remove them
//     */
//    @Test
//    public void testRemoveDoctor() {
//        JPADataManager dataManager = new JPADataManager();
//
//        Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
//
//        NodePole nodePole = new NodePole(NodeEnum.POLE, pediatrie);
//        List<NodePole> poles = new ArrayList<>();
//        poles.add(nodePole);
//
//        NodeHospital nodeHospital = new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles);
//        List<NodeHospital> hospitals = new ArrayList<>();
//        hospitals.add(nodeHospital);
//
//        NodeAPHP nodeAPHP = new NodeAPHP(NodeEnum.APHP, hospitals);
//
//        nodeHospital.setAPHP(nodeAPHP);
//        nodePole.setHospital(nodeHospital);
//        
//        assertTrue(dataManager.createAPHP(nodeAPHP));
//        assertTrue(dataManager.createHospital(nodeHospital));
//        assertTrue(dataManager.createPole(nodePole));
//        
//        Node pole = dataManager.getNode(nodePole.getType(), nodePole.getId());
//
//        Doctor doctor = new Doctor(StaffEnum.DOCTOR, "Durand", "Emilie", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", pole, pediatrie);
//        
//        assertTrue(dataManager.createDoctor(doctor));
//
//        assertTrue(dataManager.createDoctor(doctor));
//        assertTrue(dataManager.removeDoctor(doctor.getId()));
//        assertFalse(dataManager.removeDoctor(doctor.getId()));
//    }
//
//    /**
//     * Return an exception if the nurse field is null
//     */
//    @Test(expected = NullPointerException.class)
//    public void testCreateNurseNull() {
//        JPADataManager dataManager = new JPADataManager();
//        dataManager.createNurse(null);
//    }
//
//    /**
//     * Test the creation of a Nurse
//     */
//    @Test
//    public void testCreateNurse() {
//        JPADataManager dataManager = new JPADataManager();
//
//        Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
//
//        NodePole nodePole = new NodePole(NodeEnum.POLE, pediatrie);
//        List<NodePole> poles = new ArrayList<>();
//        poles.add(nodePole);
//
//        NodeHospital nodeHospital = new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles);
//        List<NodeHospital> hospitals = new ArrayList<>();
//        hospitals.add(nodeHospital);
//
//        NodeAPHP nodeAPHP = new NodeAPHP(NodeEnum.APHP, hospitals);
//        nodePole.setHospital(nodeHospital);
//        nodeHospital.setAPHP(nodeAPHP);
//                
//        assertTrue(dataManager.createAPHP(nodeAPHP));
//        assertTrue(dataManager.createHospital(nodeHospital));
//        assertTrue(dataManager.createPole(nodePole));
//        
//        Node pole = dataManager.getNode(nodePole.getType(), nodePole.getId());
//
//        Nurse nurse = new Nurse(StaffEnum.NURSE, "Durand", "Emilie", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", pole);
//        
//        assertTrue(dataManager.createNurse(nurse));
//        assertFalse(dataManager.createNurse(nurse));
//    }
//
//    /**
//     * Test if a Nurse exists, it don't returns null
//     */
//    @Test
//    public void testGetNurse() {
//        JPADataManager dataManager = new JPADataManager();
//
//        Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
//
//        NodePole nodePole = new NodePole(NodeEnum.POLE, pediatrie);
//        List<NodePole> poles = new ArrayList<>();
//        poles.add(nodePole);
//
//        NodeHospital nodeHospital = new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles);
//        List<NodeHospital> hospitals = new ArrayList<>();
//        hospitals.add(nodeHospital);
//
//        NodeAPHP nodeAPHP = new NodeAPHP(NodeEnum.APHP, hospitals);
//        nodePole.setHospital(nodeHospital);
//        nodeHospital.setAPHP(nodeAPHP);
//
//        assertTrue(dataManager.createAPHP(nodeAPHP));
//        assertTrue(dataManager.createHospital(nodeHospital));
//        assertTrue(dataManager.createPole(nodePole));
//        
//        Node pole = dataManager.getNode(nodePole.getType(), nodePole.getId());
//
//        Nurse nurseCreate = new Nurse(StaffEnum.NURSE, "Durand", "Emilie", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", pole);
//        
//        assertTrue(dataManager.createNurse(nurseCreate));
//
//        Nurse nurseResult = dataManager.getNurse(nurseCreate.getId());
//
//        assertNotNull(nurseResult);
//        assertEquals(nurseCreate.getLastName(), nurseResult.getLastName());
//        assertEquals(nurseCreate.getFirstName(), nurseResult.getFirstName());
//        assertEquals(nurseCreate.getAdress(), nurseResult.getAdress());
//        assertEquals(nurseCreate.getEmail(), nurseResult.getEmail());
//        assertEquals(nurseCreate.getPhoneNumber(), nurseResult.getPhoneNumber());
//    }
//
//    /**
//     * Test if a Nurse exists, it remove them
//     */
//    @Test
//    public void testRemoveNurse() {
//        JPADataManager dataManager = new JPADataManager();
//
//        Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
//
//        NodePole nodePole = new NodePole(NodeEnum.POLE, pediatrie);
//        List<NodePole> poles = new ArrayList<>();
//        poles.add(nodePole);
//
//        NodeHospital nodeHospital = new NodeHospital(NodeEnum.HOSPITAL, "Hôpital de Paris", poles);
//        List<NodeHospital> hospitals = new ArrayList<>();
//        hospitals.add(nodeHospital);
//
//        NodeAPHP nodeAPHP = new NodeAPHP(NodeEnum.APHP, hospitals);
//        nodePole.setHospital(nodeHospital);
//        nodeHospital.setAPHP(nodeAPHP);
//
//        assertTrue(dataManager.createAPHP(nodeAPHP));
//        assertTrue(dataManager.createHospital(nodeHospital));
//        assertTrue(dataManager.createPole(nodePole));
//        
//        Node pole = dataManager.getNode(nodePole.getType(), nodePole.getId());
//
//        Nurse nurse = new Nurse(StaffEnum.NURSE, "Durand", "Emilie", "5 Avenue de la Republique", "emilie.durand@gmail.com", "0718547896", pole);
//        
//        assertTrue(dataManager.createNurse(nurse));
//        assertTrue(dataManager.removeNurse(nurse.getId()));
//        assertFalse(dataManager.removeNurse(nurse.getId()));
//    }
//}
