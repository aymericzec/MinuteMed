package fr.devsquad.minutemed.arborescenceOld.domain;

import static fr.devsquad.minutemed.arborescenceOld.domain.NodePoleOld.FIND_ALL_NODEPOLE;
import fr.devsquad.minutemed.specialization.domain.Specialization;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
@NamedQuery(name = FIND_ALL_NODEPOLE, query = "SELECT pole FROM NodePole pole")
public class NodePoleOld implements Serializable, INode {
    
    public static final String FIND_ALL_NODEPOLE = "NodePole.findAllNodePole";
    
    @Id
    @GeneratedValue
    @Column(name = "idPole")
    private long id;
    
    @NotNull
    private String type;
    
    @NotNull
    private String specialization;

    @NotNull
    private long hospital;
    
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<NodeServiceOld> services;

    public NodePoleOld() {
    }

    /**
     * Constructor if there don't have services in this pole
     *
     * @param type Type of the node
     * @param specialization Specialization of the pole
     */
    public NodePoleOld(NodeEnumOld type, Specialization specialization) {
        this.type = type.POLE.name();
        this.specialization = specialization.getGeneralName();
        this.services = null;
    }

    /**
     * Constructor to attach services
     *
     * @param type Type of the node
     * @param specialization Specialization of the pole
     * @param services List of services attached to this node
     */
    public NodePoleOld(NodeEnumOld type, Specialization specialization, List<NodeServiceOld> services) {
        this.type = type.POLE.name();
        this.specialization = specialization.getGeneralName();
        this.services = services;
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

    public long getHospital() {
        return hospital;
    }

    public List<NodeServiceOld> getServices() {
        return services;
    }

    public void setHospital(long hospital) {
        this.hospital = hospital;
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

        for (NodeServiceOld s : services) {
            for (INode node : s.getAttachedNodes()) {
                nodes.add(node);
            }
        }
        return nodes;
    }
}
