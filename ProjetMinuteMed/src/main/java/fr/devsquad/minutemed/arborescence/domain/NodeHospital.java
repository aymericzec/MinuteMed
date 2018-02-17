/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.arborescence.domain;

import java.util.*;
import java.util.stream.*;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author thomas
 */
@Entity
@DiscriminatorValue("HOSPITAL")
public class NodeHospital extends Node {
    
    private final static String FLOOR = "HOSPITAL";
    
    @NotNull
    @ManyToOne
    private NodeAPHP father;
    
    @OneToMany(mappedBy = "father")
    private Set<NodePole> poles;

    public NodeHospital() {
        super(FLOOR);
    }

    public NodeHospital(NodeAPHP father) {
        super(FLOOR);
        this.father = Objects.requireNonNull(father);
        this.poles = new HashSet<>();
    }

    
    public NodeAPHP getFather(){
        return father;
    }
    
    public void setFather(NodeAPHP aphp){
        this.father = Objects.requireNonNull(aphp);
    }
    
    public boolean addPole(NodePole pole){
        return poles.add(Objects.requireNonNull(pole));
    }
    
    @Override
    public Set<NodeCU> getAccessibleNode(){
        return poles.stream()
                .map(pole -> pole.getAccessibleNode())
                .flatMap(cus -> cus.stream())
                .collect(Collectors.toSet());
    }
    
}
