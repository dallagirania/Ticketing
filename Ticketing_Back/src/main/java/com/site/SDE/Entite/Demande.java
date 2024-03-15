package com.site.SDE.Entite;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Getter
@Table(name="demande")
@ToString
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String cv;
    @ManyToOne
    @JoinColumn(name="projetId")
    private Projet projet;
    @JsonBackReference
    public Projet getProjet() {
        return projet;
    }

    @OneToMany (mappedBy ="demande")
    private List<Misejour> misejour;

    @JsonManagedReference
    public List<Misejour> getMisejour() {
        return misejour;
    }


}
