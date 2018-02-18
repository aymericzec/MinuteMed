/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.authentication.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author thomas
 */
abstract class AbstractUserCreator implements Serializable{

    private String type;
    private String username;
    private String password; //encrypted password
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phoneNumber;
    private long idNode;
    private String floorNode;

    
    public AbstractUserCreator(){}
    
    public AbstractUserCreator(String type, String username, String password, String firstName, String lastName,
            String address, String email, String phoneNumber, long idNode, String floorNode) {
        this.username = Objects.requireNonNull(username);
        this.password = Objects.requireNonNull(password);
        this.type = Objects.requireNonNull(type);
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.address = Objects.requireNonNull(address);
        this.email = Objects.requireNonNull(email);
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
        this.idNode = idNode;
        this.floorNode = Objects.requireNonNull(floorNode);
    }
    
    //to debug
    @Override
    public String toString(){
        return username + ", " + password + ", " + type + ", " + firstName + ", " + lastName + ", " +address + ", " + email + ", " + phoneNumber + ", " + idNode + ", " + floorNode;
    }
    

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the idNode
     */
    public long getIdNode() {
        return idNode;
    }

    /**
     * @param idNode the idNode to set
     */
    public void setIdNode(long idNode) {
        this.idNode = idNode;
    }

    /**
     * @return the floorNode
     */
    public String getFloorNode() {
        return floorNode;
    }

    /**
     * @param floorNode the floorNode to set
     */
    public void setFloorNode(String floorNode) {
        this.floorNode = floorNode;
    }
    
    
    
}