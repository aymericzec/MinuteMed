package fr.devsquad.minutemed.dmp;


import fr.devsquad.minutemed.staff.MedicalStaff;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ReportDosage implements Serializable {

    @Id @GeneratedValue
    @Column(name = "idReportDosage")
    private long id;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idStaff")
    private MedicalStaff supervisor;
    private String createDate;
    private String report;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Dosage dosage;
    
    public ReportDosage () { }

    public ReportDosage(MedicalStaff supervisor, String createDate, String report) {
        this.supervisor = supervisor;
        this.createDate = createDate;
        this.report = report;
    }

    public long getId() {
        return id;
    }

    public MedicalStaff getSupervisor() {
        return supervisor;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getRapport() {
        return report;
    }
    
    public Dosage getDosage() {
        return dosage;
    }
    
    public void setDosage(Dosage dosage) {
        this.dosage = dosage;
    }
    
    
    
   
    
}
