/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.arborescence.domain;

import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author thomas
 */
@Entity
@DiscriminatorValue("CARE_UNIT")
public class NodeCU extends Node {
    
    private final static String FLOOR = "CARE_UNIT";
    
    @ManyToOne
    private NodeHU father;

    public NodeCU() {
        super(FLOOR);
    }

    public NodeCU(NodeHU father) {
        super(FLOOR);
        this.father = Objects.requireNonNull(father);
    }
    
    public NodeHU getFather(){
        return father;
    }
    
    public void setFather(NodeHU hu){
        this.father = Objects.requireNonNull(hu);
    }
    
}
