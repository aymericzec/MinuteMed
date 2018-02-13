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
@DiscriminatorValue("POLE")
public class NodePole extends Node {
    
    private final static String FLOOR = "POLE";
    
    @ManyToOne @MapsId
    private NodeHospital father;
    
    @OneToMany(mappedBy = "father")
    private List<NodeService> services;

    public NodePole() {
        super(FLOOR);
    }

    public NodePole(NodeHospital father, List<NodeService> services) {
        super(FLOOR);
        this.father = Objects.requireNonNull(father);
        this.services = Objects.requireNonNull(services);
    }
    
    public NodeHospital getFather(){
        return father;
    }
    
    public void setFather(NodeHospital hospital){
        this.father = Objects.requireNonNull(hospital);
    }
    
}
