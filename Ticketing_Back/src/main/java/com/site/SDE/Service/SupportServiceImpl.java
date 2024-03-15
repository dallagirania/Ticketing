package com.site.SDE.Service;

import com.site.SDE.Entite.Support;
import com.site.SDE.Repository.SupportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupportServiceImpl  implements SupportService{

    @Autowired
    SupportRepository supportRepository;

    @Override
    public Support ajouterSupport(Support proprietaire) {
        return supportRepository.save(proprietaire);
    }

    @Override
    public Support modifierSupport(Support proprietaire) {
        return supportRepository.save(proprietaire);
    }

    @Override
    public List<Support> listSupport() {
        return supportRepository.findAll();
    }

    @Override
    public void supprimerById(Long id) {
        supportRepository.deleteById(id);

    }

    @Override
    public Optional<Support> FindById(Long id) {

        if(id!=null) {
            return supportRepository.findById(id);
        }
        else
            return Optional.empty();

    }
}

