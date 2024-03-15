package com.site.SDE.Repository;

import com.site.SDE.Entite.Demande;
import com.site.SDE.Entite.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DemandeRepository extends JpaRepository<Demande,Long> {
    List<Demande> findProjetById(Long id);
}
