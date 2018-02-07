package fr.devsquad.minutemed.arborescence.domain;

import static fr.devsquad.minutemed.arborescence.domain.NodeHospital.FIND_ALL_NODEHOSPITAL;
import fr.devsquad.minutemed.database.JPADataManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
@NamedQuery(name = FIND_ALL_NODEHOSPITAL, query = "SELECT hospital FROM NodeHospital hospital")
public class NodeHospital implements Serializable, INode {

    public static final String FIND_ALL_NODEHOSPITAL = "NodeHospital.findAllNodeHospital";
    
    @Id
    @GeneratedValue
    @Column(name = "idHospital")
    private long id;
    
    @NotNull
    private String type;
    
    @NotNull
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<NodePole> poles;

    public NodeHospital() {
    }

    /**
     * Constructor if there don't have poles in this hospital
     *
     * @param type Type of the node
     * @param name Name of the hospital
     */
    public NodeHospital(NodeEnum type, String name) {
        this.type = type.HOSPITAL.name();
        this.name = name;
        this.poles = null;
    }

    /**
     * Constructor to attach poles
     *
     * @param type Type of the node
     * @param name Name of the hospital
     * @param poles List of poles attached to this node
     */
    public NodeHospital(NodeEnum type, String name, List<NodePole> poles) {
        this.type = type.HOSPITAL.name();
        this.name = name;
        this.poles = poles;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    /*public NodeAPHP getAPHP() {
        return aphp;
    }*/

    public List<NodePole> getPoles() {
        return poles;
    }

    /*@Override
    public Node getNode() {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getNode(type, id);
    }*/

    /**
     * Get all the nodes attached with them
     *
     * @return A List of INode
     */
    public List<INode> getAttachedNodes() {

        List<INode> nodes = new ArrayList<>();

        for (NodePole p : poles) {
            for (INode node : p.getAttachedNodes()) {
                nodes.add(node);
            }
        }
        return nodes;
    }
}
