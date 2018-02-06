/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.dmp.domain;

/**
 *
 * @author myfou
 */
public interface IRecord {
    public boolean isDraft ();
    public void saveDraft() throws IllegalStateException;
    public void save();
    //public void delete() throws IllegalStateException; inutile
    
    
}
