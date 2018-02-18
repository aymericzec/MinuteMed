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
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author thomas
 */
@Entity
@DiscriminatorValue("CARE_UNIT")
public class NodeCU extends Node {
    
    private final static NodeEnum FLOOR = NodeEnum.CARE_UNIT;
    
    @NotNull
    @ManyToOne
    @JsonSerialize(using = CustomNodeSerializer.class)
    private NodeHU father;
    
    @OneToMany(mappedBy = "careUnit")
    private Set<MedicalRecord> medicalRecords;

    public NodeCU() {
        super(FLOOR.name());
    }

    public NodeCU(NodeHU father) {
        super(FLOOR.name());
        this.father = Objects.requireNonNull(father);
        this.medicalRecords = new HashSet<>();
    }
    
    public NodeHU getFather(){
        return father;
    }
    
    public void setFather(NodeHU hu){
        this.father = Objects.requireNonNull(hu);
    }
    
    @Override
    public Set<MedicalRecord> getMedicalRecords(){
        return medicalRecords;
    }

    @Override
    public Set<Node> getAccessibleNode(NodeEnum stopFloor){    
        Objects.requireNonNull(stopFloor);
        Set<Node> nodes = new HashSet<>();
        if(stopFloor.compareTo(FLOOR) > 0){
            nodes.add(this);
        }
        return Collections.unmodifiableSet(nodes);
    }
    
}
