/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.dmp;

import java.util.Date;
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
public class MedicalIRecordTest {
    
    public MedicalIRecordTest() {
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
    
    private MedicalRecord createMedicalFolder () {
        String ss = "194054956815780";
        String firstName = "Aymeric";
        String lastName = "Zecchini";
        String address = "2 rue Jean Baptiste Lully, 77440 Champs sur Marne";
        String email = "";
        String phoneNumber = "0770138334";
        Date birthday = new Date();
        String gender = "M";
        
        MedicalRecord mr = new MedicalRecord (ss, firstName, lastName, address, email, phoneNumber, birthday, gender);
        
        return mr;
    }
    
    @Test
    public void createMedicalFolderTest () {
        createMedicalFolder();
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void createMedicalFolderBadSS () {
        String ss = "19405495681578";
        String firstName = "Aymeric";
        String lastName = "Zecchini";
        String address = "2 rue Jean Baptiste Lully, 77440 Champs sur Marne";
        String email = "";
        String phoneNumber = "0770138334";
        Date birthday = new Date();
        String gender = "M";
        
        MedicalRecord mr = new MedicalRecord (ss, firstName, lastName, address, email, phoneNumber, birthday, gender);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void createMedicalFolderBadGender () {
        String ss = "194054956815788";
        String firstName = "Aymeric";
        String lastName = "Zecchini";
        String address = "2 rue Jean Baptiste Lully, 77440 Champs sur Marne";
        String email = "zecchini.aymeric@gmail.com";
        String phoneNumber = "0770138334";
        Date birthday = new Date();
        String gender = "MM";
        
        MedicalRecord mr = new MedicalRecord (ss, firstName, lastName, address, email, phoneNumber, birthday, gender);
    }
    
    @Test (expected = NullPointerException.class)
    public void createMedicalFolderTestFieldNull () {
        MedicalRecord mr = new MedicalRecord (null, null, null, null, null, null, null, null);
    }
    
    @Test
    public void getSSTest () {
       MedicalRecord mr = createMedicalFolder();
       assertEquals(mr.getSs(), "194054956815780");
    }

    @Test
    public void getSSTestNotEquals () {
       MedicalRecord mr = createMedicalFolder();
       assertEquals(mr.getSs(), "194054956815720");
    }
    
    @Test
    public void getFirstNameTest () {
       MedicalRecord mr = createMedicalFolder();
       assertEquals(mr.getFirstName(), "Aymeric");
    }

    @Test
    public void getFirstNameTestNotEquals () {
       MedicalRecord mr = createMedicalFolder();
       assertEquals(mr.getFirstName(), "Aymericc");
    } 
    
    @Test
    public void getLastNameTest () {
       MedicalRecord mr = createMedicalFolder();
       assertEquals(mr.getFirstName(), "Zecchini");
    }

    @Test
    public void getLastNameTestNotEquals () {
       MedicalRecord mr = createMedicalFolder();
       assertEquals(mr.getFirstName(), "Zecchi");
    }
    
    @Test
    public void getAddressTest () {
       MedicalRecord mr = createMedicalFolder();
       assertEquals(mr.getAddress(), "2 rue Jean Baptiste Lully, 77440 Champs sur Marne");
    }

    @Test
    public void getAddressTestNotEquals () {
       MedicalRecord mr = createMedicalFolder();
       assertEquals(mr.getAddress(), "2 rue Jean Baptiste Lully");
    }
    
    @Test
    public void getEmailTest () {
       MedicalRecord mr = createMedicalFolder();
       assertEquals(mr.getAddress(), "zecchini.aymeric@gmail.com");
    }

    @Test
    public void getEmailTestNotEquals () {
       MedicalRecord mr = createMedicalFolder();
       assertEquals(mr.getAddress(), "zecchini.moi@gmail.com");
    }
    
    @Test
    public void getPhoneNumberTest () {
       MedicalRecord mr = createMedicalFolder();
       assertEquals(mr.getAddress(), "0770138334");
    }

    @Test
    public void getPhoneNumberTestNotEquals () {
       MedicalRecord mr = createMedicalFolder();
       assertEquals(mr.getAddress(), "0670138334");
    } 
    
    @Test
    public void getBirthdayTest () {
       MedicalRecord mr = createMedicalFolder();
       assertEquals(mr.getBirthday(), new Date());
    }

    @Test
    public void getBirthdayTestNotEquals () {
       MedicalRecord mr = createMedicalFolder();
       assertEquals(mr.getBirthday(), new Date());
    } 
}
