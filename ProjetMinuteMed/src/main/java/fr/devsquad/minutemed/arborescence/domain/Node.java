/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.arborescence.domain;

import com.fasterxml.jackson.annotation.*;
import fr.devsquad.minutemed.arborescence.domain.utils.*;
import fr.devsquad.minutemed.dmp.domain.*;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author thomas
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("ROOT") //DTYPE
public abstract class Node implements Serializable {
            
    @Id @GeneratedValue
    private Long idNode;
    
    @NotNull
    private String floor;
    
    @NotNull
    private String name;
    
    
    public Node() { }
    
    public Node(String floor) {
        this.floor = Objects.requireNonNull(floor);
        this.name = Objects.requireNonNull(floor);
    }
    
    public Node(String floor, String name) {
        this.floor = Objects.requireNonNull(floor);
        this.name = Objects.requireNonNull(name);
    }
    
    public long getIdNode() {
        return idNode;
    }
    
    public String getFloor() {
        return floor;
    }
    
    public String getName() {
        return name;
    }
    
    
    @JsonIgnore
    public abstract Set<Node> getAccessibleNodes(NodeEnum stopFloor);
    
    @JsonIgnore
    public abstract Set<Node> getChildrens();
    
    @JsonIgnore
    public abstract Set<MedicalRecord> getMedicalRecords();

    
}