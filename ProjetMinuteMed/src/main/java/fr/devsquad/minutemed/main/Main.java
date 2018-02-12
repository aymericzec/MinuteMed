/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.main;

import fr.devsquad.minutemed.specialization.domain.Specialization;
import fr.devsquad.minutemed.specialization.domain.SpecializationEnum;
import fr.devsquad.minutemed.staff.domain.DataManager;
import fr.devsquad.minutemed.staff.domain.StaffEnum;

/**
 *
 * @author home
 */
public class Main {
    
    public static void main(String [] args) {
        
        Specialization pediatrie = new Specialization(SpecializationEnum.Endocrinologie);
        DataManager dataManager = new DataManager(StaffEnum.DATAMANAGER, "Gerard", "Luy", "5 Rue de la butte verte", "gerard.luy@gmail.com", "0784514796");
        
        dataManager.createSpecialization(pediatrie);
        
        //NodeHospital hospital = new NodeHospital(NodeEnum.HOSPITAL, "CHU de Reims");
    }
}
