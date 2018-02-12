/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.arborescence.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author thomas
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("ROOT")
public class Node implements Serializable {
    
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
    
    public String getLevel() {
        return floor;
    }
    
}