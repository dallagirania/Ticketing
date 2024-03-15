package com.site.SDE.Service;

import com.site.SDE.Entite.Support;

import java.util.List;
import java.util.Optional;

public interface SupportService {
         Support ajouterSupport(Support support);
         Support modifierSupport(Support support);
         List<Support> listSupport();
         void supprimerById(Long id);
         Optional<Support> FindById(Long id);
        }