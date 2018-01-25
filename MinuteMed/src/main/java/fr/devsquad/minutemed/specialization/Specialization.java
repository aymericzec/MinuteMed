/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.specialization;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author jsalmon
 */
@Entity
public enum Specialization {
    
    Allergologie(0,"Allergologue","Allergologie"),
    Anesthésiologie(1,"Anesthésiste","Anesthésiologie"),
    Andrologie(2,"Andrologue","Andrologie"),
    Cardiologie(3,"Cadriologue","Cardiologie"),
    Chirurgie(4,"Chirurgien","Chirurgie"),
    Chirurgie_cardiaque(5,"Chirurgien cardiologue","Chirurgie cardiaque"),
    Chirurgie_esthétique(6,"Chirurgien esthétique", "Chirurgie esthétique"),
    Chirurgie_générale(7,"Chirurgien généraliste","Chirurgie générale"),
    Chirurgie_maxillo_faciale(8,"Chirurgien maxillo faciale","Chirurgie maxillo faciale"),
    Chirurgie_pédiatrique(9,"Chirurgien pédiatrique","Chirurgie pédiatrique"),
    Chirurgie_thoracique(10,"Chirurgien thoracique","Chirurgie thoracique"),
    Chirurgie_vasculaire(11,"Chirurgien vasculaire","Chirurgie_vasculaire"),
    Neurochirurgie(12,"Neurochirurgien","Neurochirurgie"),
    Dermatologie(13,"Dermatologue","Dermatologie"),
    Endocrinologie(14,"Endocrinologue","Endocrinologie"),
    Gastro_entérologie(15,"Gastro entérologue","Gastro entérologie"),
    Général(16,"Généraliste","Général"),
    Gériatrie(17,"Gériatrie","Gériatrie"),
    Gynécologie(18,"Gynécologue","Gynécologie"),
    Hématologie(19,"Hématologue","Hématologie"),
    Hépatologie(20,"Hépatologue","Hépatologie"),
    Infectiologie(21,"Infectiologue","Infectiologie"),
    Médecine_aiguë(22,"Médecin aiguë","Médecine aiguë"),
    Médecine_du_travail(23,"Médecin du travail","Médecine du travail"),
    Médecine_générale(24,"Médecin générale","Médecine générale"),
    Médecine_interne(25,"Médecin interne","Médecine interne"),
    Médecine_nucléaire(26,"Médecin nucléaire","Médecine nucléaire"),
    Médecine_palliative(27,"Médecin palliative","Médecine palliative"),
    Médecine_physique(28,"Médecin physique","Médecine physique"),
    Médecine_préventive(29,"Médecin préventif","Médecine préventive"),
    Néonatologie(30,"Néonatologue","Néonatologie"),
    Néphrologie(31,"Néphrologue","Néphrologie"),
    Neurologie(32,"Neurologue","Neurologie"),
    Odontologie(33,"Odontologue","Odontologie"),
    Oncologie(34,"Oncologue","Oncologie"),
    Obstétrique(35,"Obstétricien","Obstétrique"),
    Ophtalmologie(36,"Ophtalmologue","Ophtalmologie"),
    Orthopédie(37,"Orthopédiste","Orthopédie"),
    Oto_rhino_laryngologie(38,"Oto-rhino-laryngologue","Oto-rhino-laryngologie"),
    Pédiatrie(39,"Pédiatre","Pédiatrie"),
    Pneumologie(40,"Pneumologue","Pneumologie"),
    Psychiatrie(41,"Psychiatre","Psychiatrie"),
    Radiologie(42,"Radiologue","Radiologie"),
    Radiothérapie(43,"Radiothérapeute"," Radiothérapie"),
    Rhumatologie(44,"Rhumatologue","Rhumatologie"),
    Urgence(45,"Urgentiste","Urgence"),
    Urologie(46,"Urologue","Urologie");
    
    @Id @GeneratedValue
    private long id;
    private String staffName;
    private String generalName;
    
    //constructor

    /**
     * This constructor is the default constructor for the JEE
     */
    private Specialization() {
        
    }

    /**
     * This constructor is use if the staffName and the generalName is the same
     * @param id is the id of the specialization
     * @param name is the name of the specialization
     */
    private Specialization(long id,String name) {
        this.staffName = name;
        this.generalName = name;
        this.id = id;
    }

    /**
     * This constructor is the main constructor for the specialization
     * @param id is the id of the specialisation
     * @param staffName is the name of the specialization for a staff
     * @param generalName is the name of the specialization
     */
    private Specialization(long id, String staffName, String generalName) {
        this.id = id;
        this.staffName = staffName;
        this.generalName = generalName;
    }
    
    /**
     * This methode return the id of this specialization
     * @return the id
     */
    public long getId(){
        return id;
    }
    
    /**
     * return the name of a staff for this specialization
     * @return the staffName
     */
    public String getStaffName(){
        return staffName;
    }
    
    /**
     * return the general name of this specialization
     * @return the generalName
     */
    public String getGeneralName(){
        return generalName;
    }
    
    public static int insertAllSpecialisationInBDD(){
        int nbInsertion =0;
        return nbInsertion;
    }
}
