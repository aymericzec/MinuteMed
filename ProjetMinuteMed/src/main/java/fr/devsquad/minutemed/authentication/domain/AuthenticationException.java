/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.authentication.domain;

/**
 *
 * @author enzo
 */
public class AuthenticationException extends Exception {
    public AuthenticationException() { super(); }
    public AuthenticationException(String message) { super(message); }
    public AuthenticationException(String message, Throwable cause) { super(message, cause); }
    public AuthenticationException(Throwable cause) { super(cause); }
}
