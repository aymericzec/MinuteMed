/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.arborescence.domain;

import com.fasterxml.jackson.databind.annotation.*;
import fr.devsquad.minutemed.arborescence.domain.Node;
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
@DiscriminatorValue("HOSPITAL_UNIT")
public class NodeHU extends Node {
    
    private final static NodeEnum FLOOR = NodeEnum.HOSPITAL_UNIT;
  
    @NotNull
    @ManyToOne
    @JsonSerialize(using = CustomNodeSerializer.class)
    private NodeService father;
    
    @OneToMany(mappedBy = "father")
    private Set<NodeCU> careUnits;

    public NodeHU() {
        super(FLOOR.name());
    }

    public NodeHU(NodeService father) {
        super(FLOOR.name());
        this.father = Objects.requireNonNull(father);
        this.careUnits = new HashSet<>();
    }
    
    public NodeService getFather(){
        return father;
    }
    
    public void setFather(NodeService service){
        this.father = Objects.requireNonNull(service);
    }
    
    public boolean addCareUnit(NodeCU cu){
        return careUnits.add(Objects.requireNonNull(cu));
    }
    
    @Override
    public Set<Node> getAccessibleNode(NodeEnum stopFloor){    
        Objects.requireNonNull(stopFloor);
        Set<Node> nodes = new HashSet<>();
        if(stopFloor.compareTo(FLOOR) > 0){
            nodes.addAll(careUnits);
        }
        return Collections.unmodifiableSet(nodes);
    }

    @Override
    public Set<MedicalRecord> getMedicalRecords() {
        return careUnits.stream()
                .flatMap(cu -> cu.getMedicalRecords().stream())
                .collect(Collectors.toSet());
    }
    
}
