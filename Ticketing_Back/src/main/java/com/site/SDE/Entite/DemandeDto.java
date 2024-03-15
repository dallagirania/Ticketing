package com.site.SDE.Entite;

import lombok.Data;

import javax.persistence.Lob;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
public class DemandeDto  implements Serializable  {
    private Long id;
    private String tracker;
    private String sujet;
    private String description;
    private String statut;
    private String priorite;
    private String assigne;
    private String version;
    private String tache_patent;
    private String datedeb;
    private String echeance;
    private String temps_estime;
    private String facture;
    @Lob
    private String cv;
    private Projet projet;
    private List<Misejour> misejour;
}
