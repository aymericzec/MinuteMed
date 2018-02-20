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
    
    private final static NodeEnum FLOOR = NodeEnum.POLE;
    
    @NotNull
    @ManyToOne
    @JsonSerialize(using = CustomNodeSerializer.class)
    private NodeHospital father;
    
    @OneToMany(mappedBy = "father")
    private Set<NodeService> services;

    public NodePole() {
        super(FLOOR.name());
    }

    public NodePole(NodeHospital father, String name) {
        super(FLOOR.name(), Objects.requireNonNull(name));
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
    public Set<Node> getAccessibleNode(NodeEnum stopFloor){    
        Objects.requireNonNull(stopFloor);
        Set<Node> nodes = new HashSet<>();
        if(stopFloor.compareTo(FLOOR) > 0){
            nodes.addAll(services); 
            nodes.addAll(services.stream()
                            .map(service -> service.getAccessibleNode(stopFloor))
                            .flatMap(Set::stream)
                            .collect(Collectors.toSet()));
        }
        return Collections.unmodifiableSet(nodes);
    }

    @Override
    public Set<MedicalRecord> getMedicalRecords() {
        return services.stream()
            .flatMap(service -> service.getMedicalRecords().stream())
            .collect(Collectors.toSet());
    }
    
}
