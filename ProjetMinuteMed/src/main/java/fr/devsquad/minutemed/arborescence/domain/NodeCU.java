/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.arborescence.domain;

import java.util.List;
import java.util.Objects;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author thomas
 */
@Entity
@DiscriminatorValue("NODE_CARE_UNIT")
public class NodeCU extends Node {
    
    private final static String FLOOR = "NODE_CARE_UNIT";
    
    @OneToMany(mappedBy = "hospitalUnits")
    private List<NodeHU> hospitalUnits;

    public NodeCU() {
        super(FLOOR);
    }

    public NodeCU(List<NodeHU> hospitalUnits) {
        super(FLOOR);
        this.hospitalUnits = Objects.requireNonNull(hospitalUnits);
    }
    
}
