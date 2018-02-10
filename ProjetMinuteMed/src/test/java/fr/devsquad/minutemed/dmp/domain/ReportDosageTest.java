package fr.devsquad.minutemed.dmp.domain;

import fr.devsquad.minutemed.staff.domain.MedicalStaff;
import fr.devsquad.minutemed.staff.domain.StaffEnum;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author myfou
 */
public class ReportDosageTest {
    private ReportDosage reportDosage;
    
    public ReportDosageTest() {
    }
    
    @Before
    public void setUp() {
        MedicalStaff supervisor = new MedicalStaff(StaffEnum.DOCTOR.name(), 1);
        String createDate = "12/12/2016";
        String rapport = "Ce client ne va pas bien";
        
        this.reportDosage =  new ReportDosage(supervisor, createDate, rapport);
    }
    
    @Test
    public void createReportDosage() {
        ReportDosage reportDosage = this.reportDosage;
    }
    
    @Test(expected = NullPointerException.class)
    public void fieldNullCreate () {
         ReportDosage report = new ReportDosage(null, null, null);
    }
    
    @Test
    public void testGetIdEquals () {        
        assertEquals(this.reportDosage.getId(), 1l);
    }
    
    @Test
    public void testGetIdNoEquals () {
        assertNotEquals(this.reportDosage.getId(), 2l);
    }
    
    @Test
    public void testGetSupervisorEquals () {        
        MedicalStaff supervisor = new MedicalStaff(StaffEnum.DOCTOR.name(), 1);
        assertEquals(this.reportDosage.getSupervisor(), supervisor);
    }
    
    @Test
    public void testGetSupervisorNoEquals () {
        assertNotEquals(this.reportDosage.getSupervisor(), new MedicalStaff(StaffEnum.DOCTOR.name(), 2));
    }
    
    @Test
    public void testGetDateEquals () {        
        assertEquals(this.reportDosage.getCreateDate(), "12/12/2016");
    }
    
    @Test
    public void testGetDateNoEquals () {
        assertNotEquals(this.reportDosage.getCreateDate(), "08/07/2015");
    }
    
    @Test
    public void testGetDescriptionEquals () {
        String rapport = "Ce client ne va pas bien";
        assertEquals(this.reportDosage.getRapport(), rapport);
    }
    
    @Test
    public void testGetDescriptionNoEquals () {
        assertNotEquals(this.reportDosage.getRapport(), "Ceci n'est pas une description");
    }
}

