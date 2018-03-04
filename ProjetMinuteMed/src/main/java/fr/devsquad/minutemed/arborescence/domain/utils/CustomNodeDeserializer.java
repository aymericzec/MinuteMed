/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.arborescence.domain.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import fr.devsquad.minutemed.arborescence.domain.Node;
import fr.devsquad.minutemed.arborescence.repository.ArborescenceRepository;
import java.io.IOException;
import javax.ejb.EJB;

/**
 *
 * @author enzo
 */
public class CustomNodeDeserializer extends StdDeserializer<Node> {
    
    @EJB
    private ArborescenceRepository repository;
    
    
    public CustomNodeDeserializer() { 
        this(null); 
    } 
 
    public CustomNodeDeserializer(Class<?> vc) { 
        super(vc); 
    }
 
    @Override
    public Node deserialize(JsonParser jp, DeserializationContext ctxt) 
      throws IOException, JsonProcessingException {

        System.out.println("Custom node deserializer");
        JsonNode jsnode = jp.getCodec().readTree(jp);
        Long id = Long.valueOf(jsnode.get("idNode").asText());
        String floor = jsnode.get("floor").asText();
        
        System.out.println("idNode : " + id + ", floor : " + floor);
        
        Node node = repository.findNodeWithFloor(id, Node.class, floor);
        System.out.println("Repository node = idNode : " + node.getIdNode() + ", floor : " + node.getFloor());
        return node;
    }
    
}
