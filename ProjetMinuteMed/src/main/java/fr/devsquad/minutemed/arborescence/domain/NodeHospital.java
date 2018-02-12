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
@DiscriminatorValue("HOSPITAL")
public class NodeHospital extends Node {
    
    private final static String FLOOR = "HOSPITAL";
    
    @OneToMany(mappedBy = "poles")
    private List<NodePole> poles;

    public NodeHospital() {
        super(FLOOR);
    }

    public NodeHospital(List<NodePole> poles) {
        super(FLOOR);
        this.poles = Objects.requireNonNull(poles);
    }
    
}
