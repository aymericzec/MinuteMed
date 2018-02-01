package fr.devsquad.minutemed.arborescence;

import fr.devsquad.minutemed.arborescence.NodeHospital;
import fr.devsquad.minutemed.arborescence.NodeService;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-01T11:27:35")
@StaticMetamodel(NodePole.class)
public class NodePole_ { 

    public static volatile SingularAttribute<NodePole, String> specialization;
    public static volatile SingularAttribute<NodePole, Long> id;
    public static volatile ListAttribute<NodePole, NodeService> services;
    public static volatile SingularAttribute<NodePole, String> type;
    public static volatile SingularAttribute<NodePole, NodeHospital> hospital;

}