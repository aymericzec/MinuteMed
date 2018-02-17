/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.arborescence.domain;

import java.util.*;
import java.util.stream.*;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author thomas
 */
@Entity
@DiscriminatorValue("POLE")
public class NodePole extends Node {
    
    private final static String FLOOR = "POLE";
    
    @NotNull
    @ManyToOne
    private NodeHospital father;
    
    @OneToMany(mappedBy = "father")
    private Set<NodeService> services;

    public NodePole() {
        super(FLOOR);
    }

    public NodePole(NodeHospital father) {
        super(FLOOR);
        this.father = Objects.requireNonNull(father);
        this.services = new HashSet<>();
    }
    
    public NodeHospital getFather(){
        return father;
    }
    
    public void setFather(NodeHospital hospital){
        this.father = Objects.requireNonNull(hospital);
    }
    
    public boolean addService(NodeService service){
        return services.add(Objects.requireNonNull(service));
    }
    
    @Override
    public Set<NodeCU> getAccessibleNode(){
        return services.stream()
                .map(service -> service.getAccessibleNode())
                .flatMap(cus -> cus.stream())
                .collect(Collectors.toSet());   
    }
    
}
