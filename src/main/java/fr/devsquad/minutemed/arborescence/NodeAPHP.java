package fr.devsquad.minutemed.arborescence;

import fr.devsquad.minutemed.database.JPADataManager;
import fr.devsquad.minutemed.staff.IHospitalStaff;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class NodeAPHP implements Serializable, INode {
    
    @Id @GeneratedValue
    @Column(name = "idAPHP")
    private long id;
    private String type;
    
    @OneToMany(mappedBy = "aphp")
    private List<NodeHospital> hospitals;
    
    public NodeAPHP () { }
    
    /**
     * Constructor to attach hospitals
     * 
     * @param type Type of the Node
     * @param hospitals List of hospitals attached to this Node
     */
    public NodeAPHP(NodeEnum type, List<NodeHospital> hospitals) {
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
    
    public List<NodeHospital> getHospitals() {
        return hospitals;
    }
    
    @Override
    public Node getNode() {
        JPADataManager dataManager = new JPADataManager();
        return dataManager.getNode(type, id);
    }
}
