package com.site.SDE.Service;

import com.site.SDE.Entite.Projet;

import java.util.List;

public interface ProjetService {
    Projet ajouterProjet(Projet animal);
    Projet modifierProjet(Projet animal);
    List<Projet> lstProjet();
    Projet getProjetById(Long id);
    List<Projet> listeProjetByClientId(Long id);
    void supprimerProjet(Long id);
}
