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
@DiscriminatorValue("APHP")
public class NodeAPHP extends Node {
    
    private final static String FLOOR = "APHP";
    
    @OneToMany(mappedBy = "hospitals")
    private List<NodeHospital> hospitals;

    public NodeAPHP() {
        super(FLOOR);
    }

    public NodeAPHP(List<NodeHospital> hospitals) {
        super(FLOOR);
        this.hospitals = Objects.requireNonNull(hospitals);
    }
    
    
    
}
