package fr.devsquad.minutemed.arborescence;

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
public class NodePole implements Serializable, INode {
    
    @Id @GeneratedValue
    @Column(name = "idPole")
    private long id;
    private String type;
    private String specialization;
    
    @ManyToOne
    private NodeHospital hospital;
    @OneToMany(mappedBy = "pole")
    private List<NodeService> services;
    
    public NodePole() { }
    
    /**
     * Constructor if there don't have services in this pole
     * 
     * @param type Type of the node
     * @param specialization Specialization of the pole
     * @param hospital Parent node
     */
    public NodePole(NodeEnum type, Specialization specialization, NodeHospital hospital) {
        this.type = type.POLE.name();
        this.specialization = specialization.getGeneralName();
        this.hospital = hospital;
        this.services = null;
    }
    
    /**
     * Constructor to attach services
     * 
     * @param type Type of the node
     * @param specialization Specialization of the pole
     * @param hospital  Parent node
     * @param services List of services attached to this node
     */
    public NodePole(NodeEnum type, Specialization specialization, NodeHospital hospital, List<NodeService> services) {
        this.type = type.POLE.name();
        this.specialization = specialization.getGeneralName();
        this.hospital = hospital;
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
}
