package fr.devsquad.minutemed.arborescence;

import fr.devsquad.minutemed.arborescence.NodeHU;
import fr.devsquad.minutemed.arborescence.NodePole;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-31T10:15:23")
@StaticMetamodel(NodeService.class)
public class NodeService_ { 

    public static volatile SingularAttribute<NodeService, String> specialization;
    public static volatile SingularAttribute<NodeService, Long> id;
    public static volatile SingularAttribute<NodeService, String> type;
    public static volatile SingularAttribute<NodeService, NodePole> pole;
    public static volatile ListAttribute<NodeService, NodeHU> hu;

}