/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.arborescence.domain;

import java.util.List;
import java.util.Objects;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author thomas
 */
@Entity
@DiscriminatorValue("POLE")
public class NodePole extends Node {
    
    private final static String FLOOR = "POLE";
    
    @OneToMany(mappedBy = "services")
    private List<NodeService> services;

    public NodePole() {
        super(FLOOR);
    }

    public NodePole(List<NodeService> services) {
        super(FLOOR);
        this.services = Objects.requireNonNull(services);
    }
    
}
