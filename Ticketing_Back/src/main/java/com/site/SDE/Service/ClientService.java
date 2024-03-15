package com.site.SDE.Service;

import com.site.SDE.Entite.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Client ajouterClient(Client proprietaire);
    Client modifierClient(Client proprietaire);
    List<Client> listClient();
    void supprimerById(Long id);
    Optional<Client> FindById(Long id);
}
