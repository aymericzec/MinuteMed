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
@DiscriminatorValue("SERVICE")
public class NodeService extends Node {
    
    private final static String FLOOR = "SERVICE";
    
    @ManyToOne @MapsId
    private NodePole father;
    
    @OneToMany(mappedBy = "father")
    private List<NodeCU> careUnits;

    public NodeService() {
        super(FLOOR);
    }

    public NodeService(NodePole father, List<NodeCU> careUnits) {
        super(FLOOR);
        this.father = Objects.requireNonNull(father);
        this.careUnits = Objects.requireNonNull(careUnits);
    }
    
    public NodePole getFather(){
        return father;
    }
    
    public void setFather(NodePole pole){
        this.father = Objects.requireNonNull(pole);
    }
    
}