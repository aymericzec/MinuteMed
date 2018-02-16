/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.arborescence.domain;

import com.fasterxml.jackson.annotation.*;
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
public class Node implements Serializable {
            
    @Id @GeneratedValue
    private Long idNode;
    
    @NotNull
    private String floor;
    
    
    public Node() { }
    
    public Node(String floor) {
        this.floor = Objects.requireNonNull(floor);
    }
    
    public long getIdNode() {
        return idNode;
    }
    
    public String getFloor() {
        return floor;
    }
    
    @JsonIgnore
    public Set<NodeCU> getAccessibleNode(){
        return Collections.emptySet();
    }

    
}