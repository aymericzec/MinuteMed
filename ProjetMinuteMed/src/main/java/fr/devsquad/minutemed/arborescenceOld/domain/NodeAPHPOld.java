package fr.devsquad.minutemed.arborescenceOld.domain;

import com.sun.istack.NotNull;
import static fr.devsquad.minutemed.arborescenceOld.domain.NodeAPHPOld.FIND_ALL_NODEAPHP;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = FIND_ALL_NODEAPHP, query = "SELECT aphp FROM NodeAPHP aphp")
public class NodeAPHPOld implements Serializable, INode {

    public static final String FIND_ALL_NODEAPHP = "NodeAPHP.findAllNodeAPHP";
    
    @Id
    @GeneratedValue
    @Column(name = "idAPHP")
    private long id;
    
    @NotNull
    private String type;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<NodeHospitalOld> hospitals;

    public NodeAPHPOld() {
    }

    /**
     * Constructor to attach hospitals
     *
     * @param type Type of the Node
     * @param hospitals List of hospitals attached to this Node
     */
    public NodeAPHPOld(NodeEnumOld type, List<NodeHospitalOld> hospitals) {
        this.type = type.APHP.name();
        this.hospitals = hospitals;
    }
    

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

    public List<NodeHospitalOld> getHospitals() {
        return hospitals;
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

        for (NodeHospitalOld h : hospitals) {
            for (INode node : h.getAttachedNodes()) {
                nodes.add(node);
            }
        }
        return nodes;
    }
}