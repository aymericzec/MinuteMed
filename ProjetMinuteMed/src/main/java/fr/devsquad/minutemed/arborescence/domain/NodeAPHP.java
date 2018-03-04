/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.arborescence.domain;

import fr.devsquad.minutemed.arborescence.domain.utils.*;
import fr.devsquad.minutemed.dmp.domain.*;
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
    
    private final static NodeEnum FLOOR = NodeEnum.APHP;
    
    @OneToMany(mappedBy = "father")
    private Set<NodeHospital> hospitals;


    public NodeAPHP() {
        super(FLOOR.name());
    }
    
    public NodeAPHP(String name) {
        super(FLOOR.name(), Objects.requireNonNull(name));
    }
    
    public boolean addHospital(NodeHospital hospital){
        return hospitals.add(Objects.requireNonNull(hospital));
    }
    
    @Override
    public Set<Node> getAccessibleNodes(NodeEnum stopFloor){    
        Objects.requireNonNull(stopFloor);
        Set<Node> nodes = new HashSet<>();
        if(stopFloor.compareTo(FLOOR) > 0){
            nodes.addAll(hospitals); 
            nodes.addAll(hospitals.stream()
                            .map(hospital -> hospital.getAccessibleNodes(stopFloor))
                            .flatMap(Set::stream)
                            .collect(Collectors.toSet()));
        }
        return Collections.unmodifiableSet(nodes);
    }

    @Override
    public Set<MedicalRecord> getMedicalRecords() {
        return hospitals.stream()
            .flatMap(hospital -> hospital.getMedicalRecords().stream())
            .collect(Collectors.toSet());
    }

    @Override
    public Set<Node> getChildrens() {
        return Collections.unmodifiableSet(hospitals);
    }
    
}
