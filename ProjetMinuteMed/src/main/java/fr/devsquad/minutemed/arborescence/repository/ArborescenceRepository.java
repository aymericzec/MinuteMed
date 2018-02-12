/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.arborescence.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author thomas
 */
@Stateless
public class ArborescenceRepository {
    
    @PersistenceContext(unitName = "APHPPU")
    private EntityManager em;
    
}
