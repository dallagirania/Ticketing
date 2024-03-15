package com.site.SDE.Service;

import com.site.SDE.Entite.Developper;
import com.site.SDE.Repository.DevelopperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DevelopperServiceImpl implements DevelopperService{
    @Autowired
    DevelopperRepository developperRepository;

    @Override
    public Developper ajouterDevelopper(Developper proprietaire) {
        return developperRepository.save(proprietaire);
    }

    @Override
    public Developper modifierDevelopper(Developper proprietaire) {
        return developperRepository.save(proprietaire);
    }

    @Override
    public List<Developper> listDevelopper() {
        return developperRepository.findAll();
    }

    @Override
    public void supprimerById(Long id) {
        developperRepository.deleteById(id);

    }

    @Override
    public Optional<Developper> FindById(Long id) {

        if(id!=null) {
            return developperRepository.findById(id);
        }
        else
            return Optional.empty();

    }
}
