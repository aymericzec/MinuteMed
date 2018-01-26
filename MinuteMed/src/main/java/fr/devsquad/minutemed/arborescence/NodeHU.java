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
public class NodeHU implements Serializable, INode {
    
    @Id @GeneratedValue
    @Column(name = "idHU")
    private long id;
    private String type;
    private String specialization;
    
    @ManyToOne
    private NodeService service;
    @OneToMany(mappedBy = "hu")
    private List<NodeCU> cu;
    
    public NodeHU() { }
    
    /**
     * Constructor if there don't have care units in this hospital unit
     * 
     * @param type Type of the node
     * @param specialization Specialization of the hospital unit
     */
    public NodeHU(NodeEnum type, Specialization specialization) {
        this.type = type.HOSPITAL_UNIT.name();
        this.specialization = specialization.getGeneralName();
        this.service = null;
        this.cu = null;
    }
    
     /**
     * Constructor to attach care units
     * 
     * @param type Type of the node
     * @param specialization Specialization of the hospital unit
     * @param cu List of care units attached to this node
     */
    public NodeHU(NodeEnum type, Specialization specialization, List<NodeCU> cu) {
        this.type = type.HOSPITAL_UNIT.name();
        this.specialization = specialization.getGeneralName();
        this.service = null;
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
    
    public NodeService getService() {
        return service;
    }
    
    public List<NodeCU> getCareUnits() {
        return cu;
    }
    
    public void setService(NodeService service) {
        this.service = service;
    }
}
