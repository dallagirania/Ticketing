package com.site.SDE.Service;

import com.site.SDE.Entite.Projet;
import com.site.SDE.Repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProjetServiceImpl implements ProjetService{

    @Autowired
    ProjetRepository projetRepository;

    @Override
    public Projet ajouterProjet(Projet offre) {
        return projetRepository.save(offre);
    }

    @Override
    public Projet modifierProjet(Projet offre) {
        return projetRepository.save(offre);
    }

    @Override
    public List<Projet> lstProjet() {
        return projetRepository.findAll();
    }

    @Override
    public Projet getProjetById(Long id) {
        Optional<Projet> projet = projetRepository.findById(id);

        if(projet.isPresent()) {
            return projet.get();
        }
        return null;
    }

    @Override
    public List<Projet> listeProjetByClientId(Long id) {
        return projetRepository.findClientById(id);
    }

    @Override
    public void supprimerProjet(Long id) {
        projetRepository.deleteById(id);
    }
}

