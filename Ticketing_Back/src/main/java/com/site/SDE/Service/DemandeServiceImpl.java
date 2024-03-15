package com.site.SDE.Service;

import com.site.SDE.Entite.Demande;
import com.site.SDE.Entite.Projet;
import com.site.SDE.Repository.DemandeRepository;
import com.site.SDE.Repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DemandeServiceImpl implements DemandeService{

    @Autowired
    DemandeRepository demandeRepository;

    @Override
    public Demande ajouterDemande(Demande offre) {
        return demandeRepository.save(offre);
    }

    @Override
    public Demande modifierDemande(Demande offre) {
        return demandeRepository.save(offre);
    }

    @Override
    public List<Demande> lstDemande() {
        return demandeRepository.findAll();
    }

    @Override
    public Demande getDemandeById(Long id) {
        Optional<Demande> projet = demandeRepository.findById(id);

        if(projet.isPresent()) {
            return projet.get();
        }
        return null;
    }

    @Override
    public List<Demande> listeDemandeByProjetId(Long id) {
        return demandeRepository.findProjetById(id);
    }

    @Override
    public void supprimerDemande(Long id) {
        demandeRepository.deleteById(id);
    }
}
