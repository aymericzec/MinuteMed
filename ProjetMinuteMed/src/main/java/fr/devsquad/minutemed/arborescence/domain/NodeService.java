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
@DiscriminatorValue("SERVICE")
public class NodeService extends Node {
    
    private final static NodeEnum FLOOR = NodeEnum.SERVICE;
    
    @NotNull
    @ManyToOne
    @JsonSerialize(using = CustomNodeSerializer.class)
    private NodePole father;
    
    @OneToMany(mappedBy = "father")
    private Set<NodeHU> hospitalUnits;

    public NodeService() {
        super(FLOOR.name());
    }

    public NodeService(NodePole father) {
        super(FLOOR.name());
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
    public Set<Node> getAccessibleNode(NodeEnum stopFloor){    
        Objects.requireNonNull(stopFloor);
        Set<Node> nodes = new HashSet<>();
        if(stopFloor.compareTo(FLOOR) > 0){
            nodes.addAll(hospitalUnits); 
            nodes.addAll(hospitalUnits.stream()
                            .map(hu -> hu.getAccessibleNode(stopFloor))
                            .flatMap(Set::stream)
                            .collect(Collectors.toSet()));
        }
        return Collections.unmodifiableSet(nodes);
    }

    @Override
    public Set<MedicalRecord> getMedicalRecords() {
        return hospitalUnits.stream()
            .flatMap(hu -> hu.getMedicalRecords().stream())
            .collect(Collectors.toSet());
    }
    
}