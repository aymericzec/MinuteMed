/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.authentication;

import java.util.*;
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
public class AccountManagerTest {
    
    public AccountManagerTest() {
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
     * Test of create method, of class AccountManager.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        List<UserAccount> accountsList = null;
        AccountManager expResult = null;
        AccountManager result = AccountManager.create(accountsList);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createAccount method, of class AccountManager.
     */
    @Test
    public void testCreateAccount() {
        System.out.println("createAccount");
        long userid = 0L;
        String username = "";
        String password = "";
        AccountManager instance = null;
        boolean expResult = false;
        boolean result = instance.createAccount(userid, username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAccount method, of class AccountManager.
     */
    @Test
    public void testRemoveAccount() {
        System.out.println("removeAccount");
        String username = "";
        AccountManager instance = null;
        boolean expResult = false;
        boolean result = instance.removeAccount(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccount method, of class AccountManager.
     */
    @Test
    public void testGetAccount() {
        System.out.println("getAccount");
        String username = "";
        AccountManager instance = null;
        UserAccount expResult = null;
        UserAccount result = instance.getAccount(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifyPassword method, of class AccountManager.
     */
    @Test
    public void testModifyPassword() {
        System.out.println("modifyPassword");
        long userid = 0L;
        String username = "";
        String newPassword = "";
        AccountManager instance = null;
        boolean expResult = false;
        boolean result = instance.modifyPassword(userid, username, newPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
