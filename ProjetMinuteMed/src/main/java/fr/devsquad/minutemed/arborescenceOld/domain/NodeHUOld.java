package fr.devsquad.minutemed.arborescenceOld.domain;

import static fr.devsquad.minutemed.arborescenceOld.domain.NodeHUOld.FIND_ALL_NODEHU;
import fr.devsquad.minutemed.database.JPADataManager;
import fr.devsquad.minutemed.specialization.domain.Specialization;
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
@NamedQuery(name = FIND_ALL_NODEHU, query = "SELECT hu FROM NodeHU hu")
public class NodeHUOld implements Serializable, INode {

    public static final String FIND_ALL_NODEHU = "NodeHU.findAllNodeHU";
    
    @Id
    @GeneratedValue
    @Column(name = "idHU")
    private long id;
    
    @NotNull
    private String type;
    
    @NotNull
    private String specialization;

    @NotNull
    private long service;
    
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<NodeCUOld> cu;

    public NodeHUOld() {
    }

    /**
     * Constructor if there don't have care units in this hospital unit
     *
     * @param type Type of the node
     * @param specialization Specialization of the hospital unit
     */
    public NodeHUOld(NodeEnumOld type, Specialization specialization) {
        this.type = type.HOSPITAL_UNIT.name();
        this.specialization = specialization.getGeneralName();
        this.cu = null;
    }

    /**
     * Constructor to attach care units
     *
     * @param type Type of the node
     * @param specialization Specialization of the hospital unit
     * @param cu List of care units attached to this node
     */
    public NodeHUOld(NodeEnumOld type, Specialization specialization, List<NodeCUOld> cu) {
        this.type = type.HOSPITAL_UNIT.name();
        this.specialization = specialization.getGeneralName();
        this.cu = cu;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getSpecialization() {
        return specialization;
    }

    public long getService() {
        return service;
    }

    public List<NodeCUOld> getCareUnits() {
        return cu;
    }

    public void setService(long service) {
        this.service = service;
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

        for (INode node : cu) {
            nodes.add(node);
        }
        return nodes;
    }
}
