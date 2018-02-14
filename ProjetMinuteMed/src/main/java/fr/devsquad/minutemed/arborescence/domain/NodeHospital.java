/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.arborescence.domain;

import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author thomas
 */
@Entity
@DiscriminatorValue("HOSPITAL")
public class NodeHospital extends Node {
    
    private final static String FLOOR = "HOSPITAL";
    
    @ManyToOne
    private NodeAPHP father;
    
    @OneToMany(mappedBy = "father")
    private List<NodePole> poles;

    public NodeHospital() {
        super(FLOOR);
    }

    public NodeHospital(NodeAPHP father, List<NodePole> poles) {
        super(FLOOR);
        this.father = Objects.requireNonNull(father);
        this.poles = Objects.requireNonNull(poles);
    }
    
    public NodeAPHP getFather(){
        return father;
    }
    
    public void setFather(NodeAPHP aphp){
        this.father = Objects.requireNonNull(aphp);
    }
    
}
