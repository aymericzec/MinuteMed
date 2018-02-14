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
public class DataManagerCreator extends AbstractUserCreator {
    
    public DataManagerCreator(){
        super();
    }
    
    public DataManagerCreator(String username, String password, String firstName, String lastName, String adress, String email, String phoneNumber, long idNode) {
        super(StaffEnum.DATA_MANAGER.name(), username, password, firstName, lastName, adress, email, phoneNumber, idNode);
    }
    
}
