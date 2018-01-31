/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.authentication;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author enzo
 */
public class ConnectedUserManagerTest {
    
    public ConnectedUserManagerTest() {
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

    /**
     * Test of login method, of class ConnectedUserManager.
     */
    @Test
    public void testLogin() throws Exception {
        System.out.println("login");
        UserAccount userAccount = null;
        ConnectedUserManager instance = new ConnectedUserManager();
        instance.login(userAccount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logout method, of class ConnectedUserManager.
     */
    @Test
    public void testLogout() throws Exception {
        System.out.println("logout");
        long userid = 0L;
        ConnectedUserManager instance = new ConnectedUserManager();
        boolean expResult = false;
        boolean result = instance.logout(userid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
