/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.authentication.domain;

import fr.devsquad.minutemed.staff.domain.StaffEnum;

/**
 *
 * @author thomas
 */
public class NurseCreator extends AbstractUserCreator {
    
    public NurseCreator(){
        super();
    }
    
    public NurseCreator(String username, String password, String firstName, String lastName, String adress, String email, String phoneNumber, String typeNode, long idNode) {
        super(StaffEnum.NURSE.name(), username, password, firstName, lastName, adress, email, phoneNumber, typeNode, idNode);
    }
    
}
