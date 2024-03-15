package com.site.SDE.Entite;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Getter
@Table(name="misejour")
@ToString
public class Misejour {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        @Column
        @ElementCollection(targetClass=Integer.class)
        private List<Integer> dev;
        @ManyToOne
        @JoinColumn(name="demandeId")
        private Demande demande;
        @JsonBackReference
        public Demande getDemande() {
            return demande;
        }
}

