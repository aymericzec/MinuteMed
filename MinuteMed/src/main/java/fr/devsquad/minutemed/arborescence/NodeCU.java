package fr.devsquad.minutemed.arborescence;

import fr.devsquad.minutemed.specialization.Specialization;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class NodeCU implements Serializable, INode {
    
    @Id @GeneratedValue
    @Column(name = "idCU")
    private long id;
    private String type;
    private String specialization;
    
    @ManyToOne
    private NodeHU hu;
    
    public NodeCU() { }
    
    /**
     * Constructor 
     * 
     * @param type Type of the node
     * @param specialization Specialization of the care unit
     */
    public NodeCU(NodeEnum type, Specialization specialization) {
        this.type = type.CARE_UNIT.name();
        this.specialization = specialization.getGeneralName();
        this.hu = null;
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
    
    public NodeHU getHospitalUnit() {
        return hu;
    }
    
    public void setHospitalUnit(NodeHU hu) {
        this.hu = hu;
    }
}
