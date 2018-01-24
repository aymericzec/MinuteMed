/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.staff;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jsalmon
 */
public class DoctorTest {
    
    @Test
    public final void testCreation(){
        Doctor d = new Doctor();
    }
    
    //Test with null
    
    @Test (expected = NullPointerException.class)
    public final void testNullFirstNameCreation(){
        Doctor d = new Doctor();
    }
    
    @Test (expected = NullPointerException.class)
    public final void testNullLastNameCreation(){
        Doctor d = new Doctor();
    }
    
    @Test (expected = NullPointerException.class)
    public final void testNullAdressCreation(){
        Doctor d = new Doctor();
    }
    
    @Test (expected = NullPointerException.class)
    public final void testNullEmailCreation(){
        Doctor d = new Doctor();
    }
    
    @Test (expected = NullPointerException.class)
    public final void testNullPhoneNumberCreation(){
        Doctor d = new Doctor();
    }
    
    @Test (expected = NullPointerException.class)
    public final void testSetNullFirstName(){
        Doctor d = new Doctor();
        d.setFirstName(null);
    }
    
    @Test (expected = NullPointerException.class)
    public final void testSetNullLastName(){
        Doctor d = new Doctor();
        d.setLastName(null);
    }
    
    @Test (expected = NullPointerException.class)
    public final void testSetNullAdress(){
        Doctor d = new Doctor();
        d.setAdress(null);
    }
    
    @Test (expected = NullPointerException.class)
    public final void testSetNullEmail(){
        Doctor d = new Doctor();
        d.setEmail(null);
    }
    
    @Test (expected = NullPointerException.class)
    public final void testSetNullPhoneNumber(){
        Doctor d = new Doctor();
        d.setPhoneNumber(null);
    }
    
    //Test with '\0' or ""
    
    @Test (expected = IllegalArgumentException.class)
    public final void testEmptyFirstNameCreation(){
        Doctor d = new Doctor();
    }
    
    @Test (expected = IllegalArgumentException.class)
    public final void testEmptyLastNameCreation(){
        Doctor d = new Doctor();
    }
    
    @Test (expected = IllegalArgumentException.class)
    public final void testEmptyAdressCreation(){
        Doctor d = new Doctor();
    }
    
    @Test (expected = IllegalArgumentException.class)
    public final void testEmptyEmailCreation(){
        Doctor d = new Doctor();
    }
    
    @Test (expected = IllegalArgumentException.class)
    public final void testEmptyPhoneNumberCreation(){
        Doctor d = new Doctor();
    }
    
    @Test (expected = IllegalArgumentException.class)
    public final void testSetEmptyFirstName(){
        Doctor d = new Doctor();
        d.setFirstName("");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public final void testSetEmptyLastName(){
        Doctor d = new Doctor();
        d.setLastName("");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public final void testSetEmptyAdress(){
        Doctor d = new Doctor();
        d.setAdress("");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public final void testSetEmptyEmail(){
        Doctor d = new Doctor();
        d.setEmail("");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public final void testSetEmptyPhoneNumber(){
        Doctor d = new Doctor();
        d.setPhoneNumber("");
    }
    
    //Test with nothing "    "
    
    @Test (expected = IllegalArgumentException.class)
    public final void testNothingFirstNameCreation(){
        Doctor d = new Doctor();
    }
    
    @Test (expected = IllegalArgumentException.class)
    public final void testNothingLastNameCreation(){
        Doctor d = new Doctor();
    }
    
    @Test (expected = IllegalArgumentException.class)
    public final void testNothingAdressCreation(){
        Doctor d = new Doctor();
    }
    
    @Test (expected = IllegalArgumentException.class)
    public final void testNothingEmailCreation(){
        Doctor d = new Doctor();
    }
    
    @Test (expected = IllegalArgumentException.class)
    public final void testNothingPhoneNumberCreation(){
        Doctor d = new Doctor();
    }
    
    @Test (expected = IllegalArgumentException.class)
    public final void testSetNothingFirstName(){
        Doctor d = new Doctor();
        d.setFirstName("  ");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public final void testSetNothingLastName(){
        Doctor d = new Doctor();
        d.setLastName("  ");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public final void testSetNothingAdress(){
        Doctor d = new Doctor();
        d.setAdress("   ");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public final void testSetNothingEmail(){
        Doctor d = new Doctor();
        d.setEmail("   ");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public final void testSetNothingPhoneNumber(){
        Doctor d = new Doctor();
        d.setPhoneNumber("   ");
    }
    
}
