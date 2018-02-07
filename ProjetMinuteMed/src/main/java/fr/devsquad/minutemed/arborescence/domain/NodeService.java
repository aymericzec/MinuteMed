package fr.devsquad.minutemed.arborescence.domain;

import static fr.devsquad.minutemed.arborescence.domain.NodeService.FIND_ALL_NODESERVICE;
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
@NamedQuery(name = FIND_ALL_NODESERVICE, query = "SELECT service FROM NodeService service")
public class NodeService implements Serializable, INode {

    public static final String FIND_ALL_NODESERVICE = "NodeService.findAllNodeService";
    
    @Id
    @GeneratedValue
    @Column(name = "idService")
    private long id;
    
    @NotNull
    private String type;
    
    @NotNull
    private String specialization;

    @NotNull
    private long pole;
    
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<NodeHU> hu;

    public NodeService() {
    }

    /**
     * Constructor if there don't have hospital units in this service
     *
     * @param type Type of the node
     * @param specialization Specialization of the service
     */
    public NodeService(NodeEnum type, Specialization specialization) {
        this.type = type.SERVICE.name();
        this.specialization = specialization.getGeneralName();
        this.hu = null;
    }

    /**
     * Constructor to attach services
     *
     * @param type Type of the node
     * @param specialization Specialization of the service
     * @param hu List of hosital units attached to this node
     */
    public NodeService(NodeEnum type, Specialization specialization, List<NodeHU> hu) {
        this.type = type.SERVICE.name();
        this.specialization = specialization.getGeneralName();
        this.hu = hu;
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

    public long getPole() {
        return pole;
    }

    public List<NodeHU> getHospitalUnits() {
        return hu;
    }

    public void setPole(long pole) {
        this.pole = pole;
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

        for (INode node : hu) {
            nodes.add(node);
        }

        for (NodeHU h : hu) {
            for (INode node : h.getCareUnits()) {
                nodes.add(node);
            }
        }
        return nodes;
    }
}
