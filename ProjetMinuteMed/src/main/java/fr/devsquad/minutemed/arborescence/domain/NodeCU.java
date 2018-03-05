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
    private NodeHU father;
    
    
    @OneToMany(mappedBy = "careUnit")
    private Set<MedicalRecord> medicalRecords;

    public NodeCU() {
        super(FLOOR.name());
    }

    public NodeCU(NodeHU father, String name) {
        super(FLOOR.name(), Objects.requireNonNull(name));
        this.father = Objects.requireNonNull(father);
        this.medicalRecords = new HashSet<>();
    }
    
    public NodeHU getFather(){
        return father;
    }
    
    public void setFather(NodeHU hu){
        this.father = Objects.requireNonNull(hu);
    }
    
    public void addMedicalRecord(MedicalRecord record){
        medicalRecords.add(Objects.requireNonNull(record));
    }
    
    @Override
    public Set<MedicalRecord> getMedicalRecords(){
        return medicalRecords;
    }

    @Override
    public Set<Node> getAccessibleNodes(NodeEnum stopFloor){    
        Objects.requireNonNull(stopFloor);
        Set<Node> nodes = new HashSet<>();
        if(stopFloor.compareTo(FLOOR) > 0){
            nodes.add(this);
        }
        return Collections.unmodifiableSet(nodes);
    }
    
    public boolean isUnder(Node node){
        Objects.requireNonNull(node);
        Long id = node.getIdNode();
        if(id == this.getIdNode()){
            return true;
        }
        if(id == this.father.getIdNode()){
            return true;
        }
        if(id == this.father.getFather().getIdNode()){
            return true;
        }
        if(id == this.father.getFather().getFather().getIdNode()){
            return true;
        }
        if(id == this.father.getFather().getFather().getFather().getIdNode()){
            return true;
        }
        if(id == this.father.getFather().getFather().getFather().getFather().getIdNode()){
            return true;
        }
        return false;
    }
    
    @Override
    public Set<Node> getChildrens() {
        return Collections.emptySet();
    }
    
}
