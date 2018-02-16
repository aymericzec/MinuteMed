/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.arborescence.domain.utils;

import fr.devsquad.minutemed.arborescence.domain.*;
import java.util.*;

/**
 *
 * @author enzo
 */
public class NodeClassSupplier {
    
    private static final Map<String, Class<? extends Node>> CLASS_SUPPLIER = new HashMap();
    static
    {
        CLASS_SUPPLIER.put("ROOT", Node.class);
        CLASS_SUPPLIER.put("APHP", NodeAPHP.class);
        CLASS_SUPPLIER.put("HOSPITAL", NodeHospital.class);
        CLASS_SUPPLIER.put("POLE", NodePole.class);
        CLASS_SUPPLIER.put("SERVICE", NodeService.class);
        CLASS_SUPPLIER.put("HOSPITAL_UNIT", NodeHU.class);
        CLASS_SUPPLIER.put("CARE_UNIT", NodeCU.class);
    }
    
    public static Class<? extends Node> getClass(String floor){
        return CLASS_SUPPLIER.getOrDefault(Objects.requireNonNull(floor), Node.class);
    }
    
}
