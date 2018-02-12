/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.arborescence.domain;

import java.util.Objects;
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
    private NodeCU father;

    public NodeHU() {
        super(FLOOR);
    }

    public NodeHU(NodeCU father) {
        this.father = Objects.requireNonNull(father);
    }
    
}
