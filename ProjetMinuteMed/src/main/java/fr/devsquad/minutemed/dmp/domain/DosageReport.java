package fr.devsquad.minutemed.dmp.domain;

import static fr.devsquad.minutemed.dmp.domain.DosageReport.FIND_ALL_REPORT_DOSAGE;
import static fr.devsquad.minutemed.dmp.domain.DosageReport.FIND_REPORT_DOSAGE_WITH_ID_DOSAGE;
import fr.devsquad.minutemed.staff.domain.MedicalStaff;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@NamedQueries({
    @NamedQuery(name = FIND_ALL_REPORT_DOSAGE,
            query = "SELECT dr FROM DosageReport dr"),
    @NamedQuery(name= FIND_REPORT_DOSAGE_WITH_ID_DOSAGE,
                query="SELECT dr FROM DosageReport dr WHERE :idDosage = dr.dosage.idDosage")    
}) 
public class DosageReport implements Serializable {
    public static final String FIND_ALL_REPORT_DOSAGE = "DosageReport.findAllDosageReport";
    public static final String FIND_REPORT_DOSAGE_WITH_ID_DOSAGE = "DosageReport.findAllDosageReportWithIdDosage";
    
    @Id @GeneratedValue
    private long idReportDosage;
    
    @NotNull
    @ManyToOne
    private MedicalStaff supervisor;
    
    @NotNull
    private String creationDate;
    
    @NotNull
    private String body;
    
    @NotNull
    @ManyToOne
    private Dosage dosage;
    
    
    public DosageReport () { }

    public DosageReport(MedicalStaff supervisor, Dosage dosage, String creationDate, String body) {
        this.supervisor = Objects.requireNonNull(supervisor);
        this.dosage = Objects.requireNonNull(dosage);
        this.creationDate = Objects.requireNonNull(creationDate);
        this.body = Objects.requireNonNull(body);
    }

    public long getIdReportDosage() {
        return idReportDosage;
    }

    public MedicalStaff getSupervisor() {
        return supervisor;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getBody() {
        return body;
    }
    
    public Dosage getDosage() {
        return dosage;
    }
    
    public void setDosage(Dosage dosage) {
        this.dosage = Objects.requireNonNull(dosage);
    }

    
}
