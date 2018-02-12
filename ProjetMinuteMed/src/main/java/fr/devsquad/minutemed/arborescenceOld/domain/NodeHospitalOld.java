package fr.devsquad.minutemed.arborescenceOld.domain;

import static fr.devsquad.minutemed.arborescenceOld.domain.NodeHospitalOld.FIND_ALL_NODEHOSPITAL;
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
public class NodeHospitalOld implements Serializable, INode {

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
    private List<NodePoleOld> poles;

    public NodeHospitalOld() {
    }

    /**
     * Constructor if there don't have poles in this hospital
     *
     * @param type Type of the node
     * @param name Name of the hospital
     */
    public NodeHospitalOld(NodeEnumOld type, String name) {
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
    public NodeHospitalOld(NodeEnumOld type, String name, List<NodePoleOld> poles) {
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

    public List<NodePoleOld> getPoles() {
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

        for (NodePoleOld p : poles) {
            for (INode node : p.getAttachedNodes()) {
                nodes.add(node);
            }
        }
        return nodes;
    }
}
