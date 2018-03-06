package fr.devsquad.minutemed.dmp.domain;

import static fr.devsquad.minutemed.dmp.domain.Dosage.FIND_ALL_DOSAGE;
import fr.devsquad.minutemed.staff.domain.MedicalStaff;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@NamedQuery(name = FIND_ALL_DOSAGE, query = "SELECT u FROM Dosage u")
public class Dosage implements Serializable {
    public static final String FIND_ALL_DOSAGE = "Dosage.findAllDosage";
    
    @Id @GeneratedValue
    private Long idDosage;
    
    @NotNull
    private String title;
    
    @NotNull
    @ManyToOne
    private MedicalStaff creator;
    
    @NotNull
    @ManyToOne
    private MedicalRecord medicalRecord;
    
    @NotNull
    private String creationDate;
    
    @NotNull
    @OneToOne
    private Diagnostic diagnostic;
    
    @NotNull
    private String body;
    
    @NotNull
    @OneToMany(mappedBy = "dosage")
    private List<DosageReport> reports = new ArrayList<>();
    
    @NotNull
    private String beginDosage;
    
    @NotNull
    private String endDosage;
    
    @NotNull
    private boolean draft;
    
    
    public Dosage () {
        
    }
    
    public Dosage (String title, MedicalStaff creator, MedicalRecord medicalRecord, String creationDate, Diagnostic diagnostic, String body, String beginDosage, String endDosage) {
        this.title = Objects.requireNonNull(title);
        this.creator = Objects.requireNonNull(creator);
        this.creationDate = Objects.requireNonNull(creationDate);
        this.diagnostic = Objects.requireNonNull(diagnostic);
        this.medicalRecord = Objects.requireNonNull(medicalRecord);
        this.body = Objects.requireNonNull(body);
        this.reports = new ArrayList();
        this.beginDosage = Objects.requireNonNull(beginDosage);
        this.endDosage = Objects.requireNonNull(endDosage);
        this.draft = true;
    }

    public String getTitle() {
        return title;
    }

    public Long getIdDosage() {
        return idDosage;
    }

    public MedicalStaff getCreator() {
        return creator;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public Diagnostic getDiagnostic() {
        return diagnostic;
    }

    public String getBody() {
        return body;
    }

    public List<DosageReport> getReports() {
        return reports;
    }

    public String getBeginDosage() {
        return beginDosage;
    }

    public String getEndDosage() {
        return endDosage;
    }
    
    public boolean isDraft() {
        return draft;
    }
    
    public void setDraft() {
        this.draft = false;
    }
    
    public DosageReport getLastReport () {
        return reports.isEmpty() ? null : reports.get(reports.size() - 1);
    }
    
    public void addReport (DosageReport report) {
        reports.add(Objects.requireNonNull(report));
    }
    
}
