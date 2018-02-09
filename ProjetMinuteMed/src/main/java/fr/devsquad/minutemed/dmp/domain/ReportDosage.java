package fr.devsquad.minutemed.dmp.domain;

import static fr.devsquad.minutemed.dmp.domain.ReportDosage.FIND_ALL_REPORT_DOSAGE;
import fr.devsquad.minutemed.staff.domain.MedicalStaff;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = FIND_ALL_REPORT_DOSAGE, query = "SELECT u FROM ReportDosage u")
public class ReportDosage implements Serializable {
    public static final String FIND_ALL_REPORT_DOSAGE = "ReportDosage.findAllReportDosage";
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
