/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.specialization;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author JSalmon
 */
public class SpecializationTest {
    @Test (expected = NullPointerException.class)
     public void testCreateNotNull() {
         Specialization spe =new Specialization(null);
     }
     
     @Test
     public void testEqualsTrue(){
         Specialization spe1 = new Specialization(SpecializationEnum.Allergologie);
         Specialization spe2 = new Specialization(SpecializationEnum.Allergologie);
         assertTrue(spe1.equals(spe2));
     }
     
     @Test
     public void testEqualsFalse(){
         Specialization spe1 = new Specialization(SpecializationEnum.Allergologie);
         Specialization spe2 = new Specialization(SpecializationEnum.Andrologie);
         assertFalse(spe1.equals(spe2));
     }
     
    @Test
     public void testGetStaffName(){
         Specialization spe = Mockito.spy(new Specialization(SpecializationEnum.Allergologie));
         assertNotNull(spe.getStaffName());
     }
     
     @Test
     public void testGetStaffNameIsTheSame(){
         SpecializationEnum speEnum = SpecializationEnum.Allergologie;
         Specialization spe = new Specialization(SpecializationEnum.Allergologie);
         assertEquals(spe.getStaffName(), speEnum.getStaffName());
     }
     
     @Test
     public void testGetGeneralName(){
         Specialization spe = new Specialization(SpecializationEnum.Allergologie);
         assertNotNull(spe.getGeneralName());
     }
     
     @Test
     public void testGetGeneralNameIsTheSame(){
         SpecializationEnum speEnum = SpecializationEnum.Allergologie;
         Specialization spe = new Specialization(SpecializationEnum.Allergologie);
         assertEquals(spe.getGeneralName(), speEnum.getGeneralName());
     }
}
