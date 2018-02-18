/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.arborescence.domain.utils;

import fr.devsquad.minutemed.arborescence.domain.Node;
import fr.devsquad.minutemed.arborescence.domain.NodeAPHP;
import fr.devsquad.minutemed.arborescence.domain.NodeCU;
import fr.devsquad.minutemed.arborescence.domain.NodeHU;
import fr.devsquad.minutemed.arborescence.domain.NodeHospital;
import fr.devsquad.minutemed.arborescence.domain.NodePole;
import fr.devsquad.minutemed.arborescence.domain.NodeService;
import java.util.*;
import java.util.Map.Entry;

/**
 *
 * @author enzo
 */
public class NodeFloorSupplier {
    
    private static final Map<Class<? extends Node>, NodeEnum> FLOOR_SUPPLIER = new HashMap<Class<? extends Node>, NodeEnum>();
    static
    {
        FLOOR_SUPPLIER.put(Node.class, NodeEnum.ROOT);
        FLOOR_SUPPLIER.put(NodeAPHP.class, NodeEnum.APHP);
        FLOOR_SUPPLIER.put(NodeHospital.class, NodeEnum.HOSPITAL);
        FLOOR_SUPPLIER.put(NodePole.class, NodeEnum.POLE);
        FLOOR_SUPPLIER.put(NodeService.class, NodeEnum.SERVICE);
        FLOOR_SUPPLIER.put(NodeHU.class, NodeEnum.HOSPITAL_UNIT);
        FLOOR_SUPPLIER.put(NodeCU.class, NodeEnum.CARE_UNIT);
    }
    
    public static <T extends Node> String getFloor(Class<T> clazz){
        NodeEnum emun = FLOOR_SUPPLIER.get(Objects.requireNonNull(clazz));
        return emun == null ? null : emun.name();
    }    
    
}
