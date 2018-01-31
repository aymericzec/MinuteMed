package fr.devsquad.minutemed.arborescence;

import fr.devsquad.minutemed.arborescence.NodeAPHP;
import fr.devsquad.minutemed.arborescence.NodePole;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-31T10:15:23")
@StaticMetamodel(NodeHospital.class)
public class NodeHospital_ { 

    public static volatile ListAttribute<NodeHospital, NodePole> poles;
    public static volatile SingularAttribute<NodeHospital, String> name;
    public static volatile SingularAttribute<NodeHospital, NodeAPHP> aphp;
    public static volatile SingularAttribute<NodeHospital, Long> id;
    public static volatile SingularAttribute<NodeHospital, String> type;

}