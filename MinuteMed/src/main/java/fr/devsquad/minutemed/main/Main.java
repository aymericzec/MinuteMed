/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.main;

import fr.devsquad.minutemed.arborescence.NodeEnum;
import fr.devsquad.minutemed.arborescence.NodeHospital;
import fr.devsquad.minutemed.specialization.Specialization;
import fr.devsquad.minutemed.specialization.SpecializationEnum;
import fr.devsquad.minutemed.staff.DataManager;

/**
 *
 * @author home
 */
public class Main {
    
    public static void main(String [] args) {
        
        Specialization pediatrie = new Specialization(SpecializationEnum.Pediatrie);
        DataManager dataManager = new DataManager("Gerard", "Luy", "5 Rue de la butte verte", "gerard.luy@gmail.com", "0784514796");
        
        dataManager.createSpecialization(pediatrie);
        
        //NodeHospital hospital = new NodeHospital(NodeEnum.HOSPITAL, "CHU de Reims");
    }
}
