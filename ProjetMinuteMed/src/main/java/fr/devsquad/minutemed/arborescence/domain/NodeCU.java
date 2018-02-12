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
@DiscriminatorValue("CARE_UNIT")
public class NodeCU extends Node {
    
    private final static String FLOOR = "CARE_UNIT";
    
    @ManyToOne
    private NodeService father;
    
    @OneToMany(mappedBy = "father")
    private List<NodeHU> hospitalUnits;

    public NodeCU() {
        super(FLOOR);
    }

    public NodeCU(NodeService father, List<NodeHU> hospitalUnits) {
        super(FLOOR);
        this.father = Objects.requireNonNull(father);
        this.hospitalUnits = Objects.requireNonNull(hospitalUnits);
    }
    
    public NodeService getFather(){
        return father;
    }
    
    public void setFather(NodeService service){
        this.father = Objects.requireNonNull(service);
    }
    
}
