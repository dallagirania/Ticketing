package com.site.SDE.Entite;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MisejourDTO implements Serializable {
    private Long id;
    private String datemodif;
    private String nom;
    private String prenom;
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
    private List<Integer> dev;
    private Demande demande;
}
