package fr.devsquad.minutemed.arborescenceOld.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class NodeOld implements Serializable {
    
    @Id @GeneratedValue
    @Column(name = "idNode")
    private long id;
    
    @NotNull
    private String type;
    
    @NotNull
    private long idNodeInfo;
    
    public NodeOld() { }
    
    public NodeOld(String type, long idNodeInfo) {
        this.type = type;
        this.idNodeInfo = idNodeInfo;
    }
    
    public long getId() {
        return id;
    }
    
    public String getType() {
        return type;
    }
    
    public long getIdNodeInfo() {
        return idNodeInfo;
    }
}
