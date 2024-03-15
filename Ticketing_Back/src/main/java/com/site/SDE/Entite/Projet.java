package com.site.SDE.Entite;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String Domaine;
    private String description;
    private String datedeb;

    @ManyToOne
    @JoinColumn(name="clientId")
    private Client client;

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDomaine() {
        return Domaine;
    }

    public String getDescription() {
        return description;
    }

    public String getDatedeb() {
        return datedeb;
    }

    @JsonBackReference
    public Client getClient() {
        return client;
    }

    @OneToMany (mappedBy ="projet")
    private List<Demande> demande;

    @JsonManagedReference
    public List<Demande> getDemande() {
        return demande;
    }

}
