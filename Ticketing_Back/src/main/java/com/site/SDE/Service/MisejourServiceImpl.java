package com.site.SDE.Service;

import com.site.SDE.Entite.Misejour;
import com.site.SDE.Entite.Projet;
import com.site.SDE.Repository.MisejourRepository;
import com.site.SDE.Repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class MisejourServiceImpl implements MisejourService{

    @Autowired
    MisejourRepository misejourRepository;

    @Override
    public Misejour ajouterMisejour(Misejour misejour) {
        return misejourRepository.save(misejour);
    }

    @Override
    public Misejour modifierMisejour(Misejour misejour) {
        return misejourRepository.save(misejour);
    }

    @Override
    public List<Misejour> lstMisejour() {
        return misejourRepository.findAll();
    }

    @Override
    public Misejour getMisejourById(Long id) {
        Optional<Misejour> misejour = misejourRepository.findById(id);

        if(misejour.isPresent()) {
            return misejour.get();
        }
        return null;
    }

    @Override
    public List<Misejour> listeMisejourByDemandeId(Long id) {
        return misejourRepository.findDemandeById(id);
    }

    @Override
    public void supprimerMisejour(Long id) {
        misejourRepository.deleteById(id);
    }
}

