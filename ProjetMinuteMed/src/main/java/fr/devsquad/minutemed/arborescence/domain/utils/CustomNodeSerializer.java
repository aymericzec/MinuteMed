/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.arborescence.domain.utils;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ser.std.*;
import fr.devsquad.minutemed.arborescence.domain.*;
import java.io.*;

/**
 *
 * @author enzo
 */
public class CustomNodeSerializer extends StdSerializer<Node> {
    
    public CustomNodeSerializer(){
        this(null);
    }
    
    public CustomNodeSerializer(Class<Node> t){
        super(t);
    }

    @Override
    public void serialize(Node t, JsonGenerator jg, SerializerProvider sp) throws IOException {
        jg.writeStartObject();
        jg.writeNumberField("id", t.getIdNode());
        jg.writeStringField("name", t.getName());
        jg.writeEndObject();
    }
    
}
