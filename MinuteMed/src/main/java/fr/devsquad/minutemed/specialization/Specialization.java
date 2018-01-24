/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.specialization;

/**
 *
 * @author jsalmon
 */
public enum Specialization {
    
    Allergologie("Allergologue","Allergologie"),
    Anesthésiologie("Anesthésiste","Anesthésiologie"),
    Andrologie("Andrologue","Andrologie"),
    Cardiologie("Cadriologue","Cardiologie"),
    Chirurgie("Chirurgien","Chirurgie"),
    Chirurgie_cardiaque("Chirurgien cardiologue","Chirurgie cardiaque"),
    Chirurgie_esthétique("Chirurgien esthétique", "Chirurgie esthétique"),
    Chirurgie_générale("Chirurgien généraliste","Chirurgie générale"),
    Chirurgie_maxillo_faciale("Chirurgien maxillo faciale","Chirurgie maxillo faciale"),
    Chirurgie_pédiatrique("Chirurgien pédiatrique","Chirurgie pédiatrique"),
    Chirurgie_thoracique("Chirurgien thoracique","Chirurgie thoracique"),
    Chirurgie_vasculaire("Chirurgien vasculaire","Chirurgie_vasculaire"),
    Neurochirurgie("Neurochirurgien","Neurochirurgie"),
    Dermatologie("Dermatologue","Dermatologie"),
    Endocrinologie("Endocrinologue","Endocrinologie"),
    Gastro_entérologie("Gastro entérologue","Gastro entérologie"),
    Général("Généraliste","Général"),
    Gériatrie("Gériatrie"),
    Gynécologie("Gynécologue","Gynécologie"),
    Hématologie("Hématologue","Hématologie"),
    Hépatologie("Hépatologue","Hépatologie"),
    Infectiologie("Infectiologue","Infectiologie"),
    Médecine_aiguë("Médecin aiguë","Médecine aiguë"),
    Médecine_du_travail("Médecin du travail","Médecine du travail"),
    Médecine_générale("Médecin générale","Médecine générale"),
    Médecine_interne("Médecin interne","Médecine interne"),
    Médecine_nucléaire("Médecin nucléaire","Médecine nucléaire"),
    Médecine_palliative("Médecin palliative","Médecine palliative"),
    Médecine_physique("Médecin physique","Médecine physique"),
    Médecine_préventive("Médecin préventif","Médecine préventive"),
    Néonatologie("Néonatologue","Néonatologie"),
    Néphrologie("Néphrologue","Néphrologie"),
    Neurologie("Neurologue","Neurologie"),
    Odontologie("Odontologue","Odontologie"),
    Oncologie("Oncologue","Oncologie"),
    Obstétrique("Obstétricien","Obstétrique"),
    Ophtalmologie("Ophtalmologue","Ophtalmologie"),
    Orthopédie("Orthopédiste","Orthopédie"),
    Oto_rhino_laryngologie("Oto-rhino-laryngologue","Oto-rhino-laryngologie"),
    Pédiatrie("Pédiatre","Pédiatrie"),
    Pneumologie("Pneumologue","Pneumologie"),
    Psychiatrie("Psychiatre","Psychiatrie"),
    Radiologie("Radiologue","Radiologie"),
    Radiothérapie("Radiothérapeute"," Radiothérapie"),
    Rhumatologie("Rhumatologue","Rhumatologie"),
    Urgence("Urgentiste","Urgence"),
    Urologie("Urologue","Urologie");
    
    String staffName;
    String generalName;
    
    //constructor

    private Specialization(String name) {
        this.staffName = name;
        this.generalName = name;
    }
    
    private Specialization(String staffName, String generalName) {
        this.staffName = staffName;
        this.generalName = generalName;
    }
    
    
    public String getStaffName(){
        return staffName;
    }
    
    public String getGeneralName(){
        return generalName;
    }
}
