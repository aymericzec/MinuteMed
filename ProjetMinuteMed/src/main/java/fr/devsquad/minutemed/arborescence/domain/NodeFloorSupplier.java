/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.arborescence.domain;

import java.util.*;

/**
 *
 * @author enzo
 */
public class NodeFloorSupplier {
    
    private static final Map<Class<? extends Node>, String> FLOOR_SUPPLIER = new HashMap<Class<? extends Node>, String>();
    static
    {
        FLOOR_SUPPLIER.put(Node.class, "ROOT");
        FLOOR_SUPPLIER.put(NodeAPHP.class, "APHP");
        FLOOR_SUPPLIER.put(NodeHospital.class, "HOSPITAL");
        FLOOR_SUPPLIER.put(NodePole.class, "POLE");
        FLOOR_SUPPLIER.put(NodeService.class, "SERVICE");
        FLOOR_SUPPLIER.put(NodeHU.class, "HOSPITAL_UNIT");
        FLOOR_SUPPLIER.put(NodeCU.class, "CARE_UNIT");
    }
    
    public static <T extends Node> String getFloor(Class<T> clazz){
        return FLOOR_SUPPLIER.getOrDefault(Objects.requireNonNull(clazz), "NULL");
    }
    
}
