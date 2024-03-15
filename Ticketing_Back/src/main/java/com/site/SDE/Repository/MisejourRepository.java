package com.site.SDE.Repository;

import com.site.SDE.Entite.Misejour;
import com.site.SDE.Entite.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MisejourRepository  extends JpaRepository<Misejour,Long> {
    List<Misejour> findDemandeById(Long id);
}