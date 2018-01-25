/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.specialization;

import java.util.List;

/**
 *
 * @author jsalmon
 */
public interface ISpecializations {
    
    List<SpecializationEnum> getSpecializations();
    void putSpecialization(SpecializationEnum specialization);
    void removeSpecialization(SpecializationEnum specialization);
    
    
}
