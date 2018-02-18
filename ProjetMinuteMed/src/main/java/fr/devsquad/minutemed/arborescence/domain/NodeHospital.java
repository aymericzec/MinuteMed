/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.arborescence.domain;

import com.fasterxml.jackson.databind.annotation.*;
import fr.devsquad.minutemed.arborescence.domain.utils.*;
import fr.devsquad.minutemed.dmp.domain.*;
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
    
    private final static NodeEnum FLOOR = NodeEnum.HOSPITAL;
    
    @NotNull
    @ManyToOne
    @JsonSerialize(using = CustomNodeSerializer.class)
    private NodeAPHP father;
    
    @OneToMany(mappedBy = "father")
    private Set<NodePole> poles;

    public NodeHospital() {
        super(FLOOR.name());
    }

    public NodeHospital(NodeAPHP father) {
        super(FLOOR.name());
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
    public Set<Node> getAccessibleNode(NodeEnum stopFloor){    
        Objects.requireNonNull(stopFloor);
        Set<Node> nodes = new HashSet<>();
        System.out.println(stopFloor.compareTo(FLOOR));
        if(stopFloor.compareTo(FLOOR) > 0){
            nodes.addAll(poles); 
            nodes.addAll(poles.stream()
                            .map(pole -> pole.getAccessibleNode(stopFloor))
                            .flatMap(Set::stream)
                            .collect(Collectors.toSet()));
        }
        return Collections.unmodifiableSet(nodes);
    }

    @Override
    public Set<MedicalRecord> getMedicalRecords() {
        return poles.stream()
            .flatMap(pole -> pole.getMedicalRecords().stream())
            .collect(Collectors.toSet());
    }
    
}
