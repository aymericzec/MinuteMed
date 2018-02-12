package fr.devsquad.minutemed.arborescenceOld.domain;

import static fr.devsquad.minutemed.arborescenceOld.domain.NodeCUOld.FIND_ALL_NODECU;
import fr.devsquad.minutemed.specialization.domain.Specialization;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@Entity
@NamedQuery(name = FIND_ALL_NODECU, query = "SELECT cu FROM NodeCU cu")
public class NodeCUOld implements Serializable, INode {
    
    public static final String FIND_ALL_NODECU = "NodeCU.findAllNodeCU";
    
    @Id @GeneratedValue
    @Column(name = "idCU")
    private long id;
    
    @NotNull
    private String type;
    
    @NotNull
    private String specialization;
    
    @NotNull
    private long hu;
    
    public NodeCUOld() { }
    
    /**
     * Constructor 
     * 
     * @param type Type of the node
     * @param specialization Specialization of the care unit
     */
    public NodeCUOld(NodeEnumOld type, Specialization specialization) {
        this.type = type.CARE_UNIT.name();
        this.specialization = specialization.getGeneralName();
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
    
    public long getHospitalUnit() {
        return hu;
    }
    
    public void setHospitalUnit(long hu) {
        this.hu = hu;
    }
    
    /*@Override
    public Node getNode() {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getNode(type, id);
    }*/
}
