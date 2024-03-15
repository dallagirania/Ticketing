package com.site.SDE.Repository;

import com.site.SDE.Entite.Support;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportRepository extends JpaRepository<Support,Long> {
    Support findIdByEmail(String email);
    boolean existsByEmail(String email);
//    Support findProprietaireByAnimalId(long id);

}

