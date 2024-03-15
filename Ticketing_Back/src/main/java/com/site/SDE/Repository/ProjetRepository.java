package com.site.SDE.Repository;
import com.site.SDE.Entite.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProjetRepository  extends JpaRepository<Projet,Long> {
    List<Projet> findClientById(Long id);
}
