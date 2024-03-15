package com.site.SDE.Entite;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProjetDto implements Serializable {
    private Long id;
    private String nom;
    private String Domaine;
    private String description;
    private String datedeb;
    private Client client;
    private List<Demande> demande;


}
