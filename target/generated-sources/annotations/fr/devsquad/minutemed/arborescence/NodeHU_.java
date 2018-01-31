package fr.devsquad.minutemed.arborescence;

import fr.devsquad.minutemed.arborescence.NodeCU;
import fr.devsquad.minutemed.arborescence.NodeService;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-30T19:37:23")
@StaticMetamodel(NodeHU.class)
public class NodeHU_ { 

    public static volatile ListAttribute<NodeHU, NodeCU> cu;
    public static volatile SingularAttribute<NodeHU, NodeService> service;
    public static volatile SingularAttribute<NodeHU, String> specialization;
    public static volatile SingularAttribute<NodeHU, Long> id;
    public static volatile SingularAttribute<NodeHU, String> type;

}