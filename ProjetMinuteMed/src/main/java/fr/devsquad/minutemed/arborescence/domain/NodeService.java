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
@DiscriminatorValue("SERVICE")
public class NodeService extends Node {
    
    private final static String FLOOR = "SERVICE";
    
    @NotNull
    @ManyToOne
    private NodePole father;
    
    @OneToMany(mappedBy = "father")
    private Set<NodeHU> hospitalUnits;

    public NodeService() {
        super(FLOOR);
    }

    public NodeService(NodePole father) {
        super(FLOOR);
        this.father = Objects.requireNonNull(father);
        this.hospitalUnits = new HashSet<>();
    }
    
    public NodePole getFather(){
        return father;
    }
    
    public void setFather(NodePole pole){
        this.father = Objects.requireNonNull(pole);
    }
    
    public boolean addHospitalUnit(NodeHU hu){
        return hospitalUnits.add(Objects.requireNonNull(hu));
    }
    
    @Override
    public Set<NodeCU> getAccessibleNode(){
        return hospitalUnits.stream()
                .map(hospitalUnit -> hospitalUnit.getAccessibleNode())
                .flatMap(cus -> cus.stream())
                .collect(Collectors.toSet());    
    }
    
}