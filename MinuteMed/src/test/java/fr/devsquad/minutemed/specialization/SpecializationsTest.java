/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.specialization;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jsalmon
 */
public class SpecializationsTest {
    
    
    @Test
    public final void testCreation(){
        Specializations s = new Specializations();
    }
    
    @Test (expected = NullPointerException.class)
    public final void testPutNullSpecialization(){
        Specializations s = new Specializations();
        s.putSpecialization(null);
    }
    
    @Test (expected = NullPointerException.class)
    public final void testRemoveNullSpecialization(){
        Specializations s = new Specializations();
        s.removeSpecialization(null);
    }
    
    @Test
    public final void testDoublePutSpecialization(){
        Specializations s1 = new Specializations();
        s1.removeSpecialization(Specialization.Andrologie);
        s1.removeSpecialization(Specialization.Andrologie);
        
        Specializations s2 = new Specializations();
        s2.removeSpecialization(Specialization.Andrologie);
        
        Assert.assertEquals( s1 , s2 );
    }
}
