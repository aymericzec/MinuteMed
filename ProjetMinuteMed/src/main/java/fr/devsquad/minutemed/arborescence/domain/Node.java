/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.arborescence.domain;

import static fr.devsquad.minutemed.arborescence.domain.Node.FIND_ALL_NODES;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author thomas
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("ROOT") //DTYPE
@NamedQuery(name = FIND_ALL_NODES, query = "SELECT n FROM Node n")
public class Node implements Serializable {
    
    public static final String FIND_ALL_NODES = "Node.findAllNodes";
        
    @Id @GeneratedValue
    private long idNode;
    
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

    
}