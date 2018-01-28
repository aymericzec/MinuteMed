package fr.devsquad.minutemed.dmp;

import fr.devsquad.minutemed.staff.Doctor;
import fr.devsquad.minutemed.staff.IHospitalStaff;
import java.io.Serializable;
import java.util.Date;
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
    @OneToOne
    @JoinColumn(name = "idStaff")
    private IHospitalStaff supervisor;
    @Temporal(TemporalType.DATE)
    private Date createDate;
    private String report;
    @ManyToOne
    private Dosage dosage;
    
    public ReportDosage () { }

    public ReportDosage(IHospitalStaff supervisor, Date createDate, String report) {
        this.supervisor = supervisor;
        this.createDate = createDate;
        this.report = report;
    }

    public long getId() {
        return id;
    }

    public IHospitalStaff getSupervisor() {
        return supervisor;
    }

    public Date getCreateDate() {
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
