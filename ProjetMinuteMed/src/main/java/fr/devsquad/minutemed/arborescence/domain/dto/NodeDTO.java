/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.arborescence.domain.dto;

import fr.devsquad.minutemed.arborescence.domain.Node;
import fr.devsquad.minutemed.arborescence.repository.ArborescenceRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author enzo
 */
public class NodeDTO implements Serializable {
    
    private long id;
    
    private String floor;
    
    private String name;
    
    private List<NodeDTO> childrens = new ArrayList<>();
  
    
    public NodeDTO(){}
    
    public NodeDTO(long id, String floor, String name){
        this.id = id;
        this.floor = Objects.requireNonNull(floor);
        this.name = Objects.requireNonNull(name);
    }
    
    public static NodeDTO create(Node node){
        Objects.requireNonNull(node);
        List<NodeDTO> accessibles = node.getChildrens().stream().map(NodeDTO::create).collect(Collectors.toList());
        NodeDTO dto = new NodeDTO(node.getIdNode(), node.getFloor(), node.getName());
        dto.setChildrens(accessibles);
        return dto;
    }
    
    public Node toNode(ArborescenceRepository arborescenceRepository){
        Objects.requireNonNull(arborescenceRepository);
        return arborescenceRepository.findNodeWithFloor(this.id, Node.class, this.floor);
    }
    
    

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the floor
     */
    public String getFloor() {
        return floor;
    }

    /**
     * @param floor the floor to set
     */
    public void setFloor(String floor) {
        this.floor = floor;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    
    public List<NodeDTO> getChildrens() {
        return childrens;
    }
    

    public void setChildrens(List<NodeDTO> childrens) {
        this.childrens = childrens;
    }
    
}
