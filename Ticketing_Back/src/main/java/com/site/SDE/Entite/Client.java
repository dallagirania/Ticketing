package com.site.SDE.Entite;

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
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String domain;
    private String adresse;
    private String tel;
    private String fax;
    private String site;
    private String directeur;
    private String directeur_fon;
    private String directeur_email;
    private String consultant;
    private String consultant_fon;
    private String consultant_email;
    private String email;
    private String mdp;
    @Lob
    private String img;

    public String getDirecteur_fon() {
        return directeur_fon;
    }

    public String getDirecteur_email() {
        return directeur_email;
    }

    public String getConsultant_fon() {
        return consultant_fon;
    }

    public String getConsultant_email() {
        return consultant_email;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDomain() {
        return domain;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTel() {
        return tel;
    }

    public String getFax() {
        return fax;
    }

    public String getSite() {
        return site;
    }

    public String getDirecteur() {
        return directeur;
    }

    public String getConsultant() {
        return consultant;
    }

    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }

    public String getImg() {
        return img;
    }

    @OneToMany (mappedBy ="client")
    private List<Projet> projet;

    @JsonManagedReference
    public List<Projet> getProjet() {
        return projet;
    }
}
