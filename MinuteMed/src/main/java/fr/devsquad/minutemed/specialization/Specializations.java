/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.specialization;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jsalmon
 */
public class Specializations implements ISpecializations {

    private ArrayList<Specialization> specializations = new ArrayList<>();
    
    /**
     * This methode can get all specializations of this class
     * @return Return the list of all specializations
     */
    @Override
    public List<Specialization> getSpecializations() {
        return specializations;
    }

    /**
     * This method can add a specialization at all specializations
     * @param specialization 
     */
    @Override
    public void putSpecialization(Specialization specialization) {
        if(specializations.contains(specialization)){
            return ;
        }
        specializations.add(specialization);
    }

    
    /**
     * This method can remove specialization in all specializations if it is present
     * @param specialization 
     */
    @Override
    public void removeSpecialization(Specialization specialization) {
        specializations.remove(specialization);
    }

    /**
     * This method can print all specializations
     * @return all specializations in a String
     */
    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
        
        for(Specialization s : specializations){
            stb.append(s).append(" ");
        }
        
        return stb.toString();
    }
    
    
    
}
