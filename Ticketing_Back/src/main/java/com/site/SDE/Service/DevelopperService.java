package com.site.SDE.Service;

import com.site.SDE.Entite.Developper;

import java.util.List;
import java.util.Optional;

public interface DevelopperService {
    Developper ajouterDevelopper(Developper support);
    Developper modifierDevelopper(Developper support);
    List<Developper> listDevelopper();
    void supprimerById(Long id);
    Optional<Developper> FindById(Long id);
}
