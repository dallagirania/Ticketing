package com.site.SDE.Service;

import com.site.SDE.Entite.Demande;
import com.site.SDE.Entite.Projet;

import java.util.List;

public interface DemandeService {
    Demande ajouterDemande(Demande animal);
    Demande modifierDemande(Demande animal);
    List<Demande> lstDemande();
    Demande getDemandeById(Long id);
    List<Demande> listeDemandeByProjetId(Long id);
    void supprimerDemande(Long id);
}
