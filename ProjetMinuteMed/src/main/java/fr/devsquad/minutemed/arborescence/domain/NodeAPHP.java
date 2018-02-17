/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.arborescence.domain;

import java.util.*;
import java.util.stream.*;
import javax.persistence.*;

/**
 *
 * @author thomas
 */
@Entity
@DiscriminatorValue("APHP")
public class NodeAPHP extends Node {
    
    private final static String FLOOR = "APHP";
    
    @OneToMany(mappedBy = "father")
    private Set<NodeHospital> hospitals;

    public NodeAPHP() {
        super(FLOOR);
    }

    public NodeAPHP(Set<NodeHospital> hospitals) {
        super(FLOOR);
        this.hospitals = Objects.requireNonNull(hospitals);
    }
    
    public boolean addHospital(NodeHospital hospital){
        return hospitals.add(Objects.requireNonNull(hospital));
    }
    
    @Override
    public Set<NodeCU> getAccessibleNode(){
        return hospitals.stream()
                .map(hospital -> hospital.getAccessibleNode())
                .flatMap(cus -> cus.stream())
                .collect(Collectors.toSet());
    }
    
}
