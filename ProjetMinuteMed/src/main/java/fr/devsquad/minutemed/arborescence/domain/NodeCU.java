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
@DiscriminatorValue("CARE_UNIT")
public class NodeCU extends Node {
    
    private final static String FLOOR = "CARE_UNIT";
    
    @NotNull
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
