/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.arborescence.domain;

import java.util.*;
import javax.persistence.*;

/**
 *
 * @author thomas
 */
@Entity
@DiscriminatorValue("HOSPITAL_UNIT")
public class NodeHU extends Node {
    
    private final static String FLOOR = "HOSPITAL_UNIT";
  
    @ManyToOne
    private NodeService father;
    
    @OneToMany(mappedBy = "father")
    private List<NodeCU> careUnits;

    public NodeHU() {
        super(FLOOR);
    }

    public NodeHU(NodeService father, List<NodeCU> careUnits) {
        this.father = Objects.requireNonNull(father);
        this.careUnits = Objects.requireNonNull(careUnits);
    }
    
    public NodeService getFather(){
        return father;
    }
    
    public void setFather(NodeService service){
        this.father = Objects.requireNonNull(service);
    }
    
}
