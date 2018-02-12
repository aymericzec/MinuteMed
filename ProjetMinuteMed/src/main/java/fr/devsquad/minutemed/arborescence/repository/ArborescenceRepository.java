/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.arborescence.repository;

import fr.devsquad.minutemed.arborescence.domain.*;
import fr.devsquad.minutemed.arborescenceOld.domain.*;
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
        return em.createNamedQuery(Node.FIND_ALL_NODES, Node.class).getResultList();
    }
    
    public <T extends Node> List<T> getGenericNodes(Class<T> clazz) {
        Objects.requireNonNull(clazz);
        TypedQuery<T> qry = em.createQuery("Select n FROM Node n WHERE n.floor = :floor", clazz);
        return qry.setParameter("floor", NodeFloorSupplier.getFloor(clazz)).getResultList();
    }
    
    public <T extends Node> List<T> getGenericNodesWithFatherId(Class<T> clazz, Long fatherId) {
        Objects.requireNonNull(clazz);
        Objects.requireNonNull(fatherId);
        TypedQuery<T> qry = em.createNamedQuery("Select n FROM Node n WHERE n.father_idnode = :fatherId AND n.floor = :floor", clazz);
        return qry.setParameter("fatherId", fatherId).setParameter("floor", NodeFloorSupplier.getFloor(clazz)).getResultList();
    }
    
    public <T extends Node> Long saveGenericNode(T node){
        em.persist(node);
        return node.getIdNode();
    }
    
    public <T extends Node> T findNodeGeneric(Long nodeID, Class<T> clazz){
        Objects.requireNonNull(clazz);
        TypedQuery<T> qry = em.createQuery("SELECT n FROM Node n WHERE n.idNode = :id AND n.floor = :floor", clazz);
        return qry.setParameter("id", nodeID).setParameter("floor", NodeFloorSupplier.getFloor(clazz)).getSingleResult();  
    }
    
}
