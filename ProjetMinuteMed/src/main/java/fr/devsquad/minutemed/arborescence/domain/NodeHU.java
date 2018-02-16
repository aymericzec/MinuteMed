/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.arborescence.domain;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author thomas
 */
@Entity
@DiscriminatorValue("HOSPITAL_UNIT")
public class NodeHU extends Node {
    
    private final static String FLOOR = "HOSPITAL_UNIT";
  
    @NotNull
    @ManyToOne
    private NodeService father;
    
    @OneToMany(mappedBy = "father")
    private Set<NodeCU> careUnits;

    public NodeHU() {
        super(FLOOR);
    }

    public NodeHU(NodeService father, Set<NodeCU> careUnits) {
        this.father = Objects.requireNonNull(father);
        this.careUnits = Objects.requireNonNull(careUnits);
    }
    
    public NodeService getFather(){
        return father;
    }
    
    public void setFather(NodeService service){
        this.father = Objects.requireNonNull(service);
    }
    
    public boolean addCareUnit(NodeCU cu){
        return careUnits.add(Objects.requireNonNull(cu));
    }
    
    @Override
    public Set<NodeCU> getAccessibleNode(){
        return careUnits;
    }
    
}
