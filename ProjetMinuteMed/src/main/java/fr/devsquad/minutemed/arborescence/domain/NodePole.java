package fr.devsquad.minutemed.arborescence.domain;

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
import javax.persistence.OneToMany;

@Entity
public class NodePole implements Serializable, INode {

    @Id
    @GeneratedValue
    @Column(name = "idPole")
    private long id;
    private String type;
    private String specialization;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private NodeHospital hospital;
    @OneToMany(mappedBy = "pole", cascade = CascadeType.PERSIST)
    private List<NodeService> services;

    public NodePole() {
    }

    /**
     * Constructor if there don't have services in this pole
     *
     * @param type Type of the node
     * @param specialization Specialization of the pole
     */
    public NodePole(NodeEnum type, Specialization specialization) {
        this.type = type.POLE.name();
        this.specialization = specialization.getGeneralName();
        this.hospital = null;
        this.services = null;
    }

    /**
     * Constructor to attach services
     *
     * @param type Type of the node
     * @param specialization Specialization of the pole
     * @param services List of services attached to this node
     */
    public NodePole(NodeEnum type, Specialization specialization, List<NodeService> services) {
        this.type = type.POLE.name();
        this.specialization = specialization.getGeneralName();
        this.hospital = null;
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

    public NodeHospital getHospital() {
        return hospital;
    }

    public List<NodeService> getServices() {
        return services;
    }

    public void setHospital(NodeHospital hospital) {
        this.hospital = hospital;
    }

    @Override
    public Node getNode() {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getNode(type, id);
    }

    /**
     * Get all the nodes attached with them
     *
     * @return A List of INode
     */
    public List<INode> getAttachedNodes() {

        List<INode> nodes = new ArrayList<>();

        for (NodeService s : services) {
            for (INode node : s.getAttachedNodes()) {
                nodes.add(node);
            }
        }
        return nodes;
    }
}
