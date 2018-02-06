package fr.devsquad.minutemed.specialization.domain;


public enum SpecializationEnum {
    
    Allergologie("Allergologue","Allergologie"),
    Anesthesiologie("Anesthésiste","Anesthésiologie"),
    Andrologie("Andrologue","Andrologie"),
    Cardiologie("Cadriologue","Cardiologie"),
    Chirurgie("Chirurgien","Chirurgie"),
    Chirurgie_cardiaque("Chirurgien cardiologue","Chirurgie cardiaque"),
    Chirurgie_esthetique("Chirurgien esthétique", "Chirurgie esthétique"),
    Chirurgie_generale("Chirurgien généraliste","Chirurgie générale"),
    Chirurgie_maxillo_faciale("Chirurgien maxillo faciale","Chirurgie maxillo faciale"),
    Chirurgie_pediatrique("Chirurgien pédiatrique","Chirurgie pédiatrique"),
    Chirurgie_thoracique("Chirurgien thoracique","Chirurgie thoracique"),
    Chirurgie_vasculaire("Chirurgien vasculaire","Chirurgie_vasculaire"),
    Neurochirurgie("Neurochirurgien","Neurochirurgie"),
    Dermatologie("Dermatologue","Dermatologie"),
    Endocrinologie("Endocrinologue","Endocrinologie"),
    Gastro_enterologie("Gastro entérologue","Gastro entérologie"),
    General("Généraliste","Général"),
    Geriatrie("Gériatrie","Gériatrie"),
    Gynecologie("Gynécologue","Gynécologie"),
    Hematologie("Hématologue","Hématologie"),
    Hepatologie("Hépatologue","Hépatologie"),
    Infectiologie("Infectiologue","Infectiologie"),
    Medecine_aigue("Médecin aiguë","Médecine aiguë"),
    Medecine_du_travail("Médecin du travail","Médecine du travail"),
    Medecine_generale("Médecin générale","Médecine générale"),
    Medecine_interne("Médecin interne","Médecine interne"),
    Medecine_nucleaire("Médecin nucléaire","Médecine nucléaire"),
    Medecine_palliative("Médecin palliative","Médecine palliative"),
    Medecine_physique("Médecin physique","Médecine physique"),
    Medecine_preventive("Médecin préventif","Médecine préventive"),
    Neonatologie("Néonatologue","Néonatologie"),
    Nephrologie("Néphrologue","Néphrologie"),
    Neurologie("Neurologue","Neurologie"),
    Odontologie("Odontologue","Odontologie"),
    Oncologie("Oncologue","Oncologie"),
    Obstetrique("Obstétricien","Obstétrique"),
    Ophtalmologie("Ophtalmologue","Ophtalmologie"),
    Orthopedie("Orthopédiste","Orthopédie"),
    Oto_rhino_laryngologie("Oto-rhino-laryngologue","Oto-rhino-laryngologie"),
    Pediatrie("Pédiatre","Pédiatrie"),
    Pneumologie("Pneumologue","Pneumologie"),
    Psychiatrie("Psychiatre","Psychiatrie"),
    Radiologie("Radiologue","Radiologie"),
    Radiotherapie("Radiothérapeute"," Radiothérapie"),
    Rhumatologie("Rhumatologue","Rhumatologie"),
    Urgence("Urgentiste","Urgence"),
    Urologie("Urologue","Urologie");

    private final String staffName;
    private final String generalName;
 

    /**
     * This constructor is use if the staffName and the generalName is the same
     * 
     * @param name is the name of the specialization
     */
    private SpecializationEnum(String name) {
        this.staffName = name;
        this.generalName = name;
    }

    /**
     * This constructor is the main constructor for the specialization
     * 
     * @param staffName is the name of the specialization for a staff
     * @param generalName is the name of the specialization
     */
    private SpecializationEnum(String staffName, String generalName) {
        this.staffName = staffName;
        this.generalName = generalName;
    }
    
    /**
     * return the name of a staff for this specialization
     * 
     * @return the staffName
     */
    public String getStaffName(){
        return staffName;
    }
    
    /**
     * return the general name of this specialization
     * 
     * @return the generalName
     */
    public String getGeneralName(){
        return generalName;
    }
    
    
}
