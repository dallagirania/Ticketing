package com.site.SDE.Service;

import com.site.SDE.Entite.Client;
import com.site.SDE.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    ClientRepository proprietaireRepository;

    @Override
    public Client ajouterClient(Client proprietaire) {
        return proprietaireRepository.save(proprietaire);
    }

    @Override
    public Client modifierClient(Client proprietaire) {
        return proprietaireRepository.save(proprietaire);
    }

    @Override
    public List<Client> listClient() {
        return proprietaireRepository.findAll();
    }

    @Override
    public void supprimerById(Long id) {
        proprietaireRepository.deleteById(id);

    }

    @Override
    public Optional<Client> FindById(Long id) {

        if(id!=null) {
            return proprietaireRepository.findById(id);
        }
        else
            return Optional.empty();

    }
}


