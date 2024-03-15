package com.site.SDE.Service;

import com.site.SDE.Entite.Misejour;
import com.site.SDE.Entite.Projet;

import java.util.List;

public interface MisejourService {
    Misejour ajouterMisejour(Misejour animal);
    Misejour modifierMisejour(Misejour animal);
    List<Misejour> lstMisejour();
    Misejour getMisejourById(Long id);
    List<Misejour> listeMisejourByDemandeId(Long id);
    void supprimerMisejour(Long id);
}
