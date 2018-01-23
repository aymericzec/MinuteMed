/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.staff;

/**
 *
 * @author jsalmon
 */
public interface IHospitalStaff {
    public String getFirstName();
    public String getLastName();
    public String getAdress();
    public String getEmail();
    public String getPhoneNumber();
    public void setFirstName(String firstName);
    public void setLastName(String lastName);
    public void setAdress(String adress);
    public void setEmail(String email);
    public void setPhoneNumber(String phoneNumber);
    
}
