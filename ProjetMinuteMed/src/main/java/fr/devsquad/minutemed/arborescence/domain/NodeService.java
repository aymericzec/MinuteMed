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
@DiscriminatorValue("SERVICE")
public class NodeService extends Node {
    
    private final static String FLOOR = "SERVICE";
    
    @OneToMany(mappedBy = "careUnits")
    private List<NodeCU> careUnits;

    public NodeService() {
        super(FLOOR);
    }

    public NodeService(List<NodeCU> careUnits) {
        super(FLOOR);
        this.careUnits = Objects.requireNonNull(careUnits);
    }
    
}