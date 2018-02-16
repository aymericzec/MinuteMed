/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.arborescence.repository;

import fr.devsquad.minutemed.arborescence.domain.utils.NodeFloorSupplier;
import fr.devsquad.minutemed.arborescence.domain.*;
import fr.devsquad.minutemed.arborescence.domain.utils.*;
import java.util.*;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author enzo
 */
@Stateless
public class ArborescenceRepository {
    
    @PersistenceContext(unitName = "APHPPU")
    private EntityManager em;
    
    
    public List<Node> findAllNodes(){
        TypedQuery<Node> qry = em.createQuery("Select n FROM Node n", Node.class);
        return qry.getResultList();      
    }
    
    
    public <T extends Node> List<T> findNodes(Class<T> clazz) {
        Objects.requireNonNull(clazz);
        TypedQuery<T> qry = em.createQuery("Select n FROM Node n WHERE n.floor = :floor", clazz);
        return qry.setParameter("floor", NodeFloorSupplier.getFloor(clazz)).getResultList();
    }
    
    
    public <T extends Node> List<T> findNodesWithFatherId(Class<T> clazz, Long fatherId) {
        Objects.requireNonNull(clazz);
        Objects.requireNonNull(fatherId);
        TypedQuery<T> qry = em.createNamedQuery("Select n FROM Node n WHERE n.father_idnode = :fatherId AND n.floor = :floor", clazz);
        return qry.setParameter("fatherId", fatherId).setParameter("floor", NodeFloorSupplier.getFloor(clazz)).getResultList();
    }
    
    
    public <T extends Node> Long saveNode(T node){
        em.persist(node);
        return node.getIdNode();
    }
    
    
    public <T extends Node> T findNode(Long nodeID, Class<T> clazz){
        Objects.requireNonNull(clazz);
        T result = null;
        TypedQuery<T> qry = em.createQuery("SELECT n FROM Node n WHERE n.idNode = :id AND n.floor = :floor", clazz);
        try{
            result = qry.setParameter("id", nodeID).setParameter("floor", NodeFloorSupplier.getFloor(clazz)).getSingleResult();
        } catch (NoResultException nre){
            // do nothing
        }
        return result;
    }
    
    
    public <T extends Node> void refreshNode(T node){
        em.refresh(Objects.requireNonNull(node));
    }
    
    public <T extends Node> void removeNode(T node){
        em.remove(Objects.requireNonNull(node));
    }
    
}
