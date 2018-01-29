package fr.devsquad.minutemed.arborescence;

import fr.devsquad.minutemed.database.JPADataManager;
import fr.devsquad.minutemed.specialization.Specialization;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class NodeService implements Serializable, INode {
    
    @Id @GeneratedValue
    @Column(name = "idService")
    private long id;
    private String type;
    private String specialization;
    
    @ManyToOne
    private NodePole pole;
    @OneToMany(mappedBy = "service")
    private List<NodeHU> hu;
    
    public NodeService() { }
    
    /**
     * Constructor if there don't have hospital units in this service
     * 
     * @param type Type of the node
     * @param specialization Specialization of the service
     */
    public NodeService(NodeEnum type, Specialization specialization) {
        this.type = type.SERVICE.name();
        this.specialization = specialization.getGeneralName();
        this.pole = null;
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
        this.pole = null;
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
    
    public NodePole getPole() {
        return pole;
    }
    
    public List<NodeHU> getHospitalUnits() {
        return hu;
    }
    
    public void setPole(NodePole pole) {
        this.pole = pole;
    }
    
    @Override
    public Node getNode() {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getNode(type, id);
    }
}
