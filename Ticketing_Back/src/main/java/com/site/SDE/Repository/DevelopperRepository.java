package com.site.SDE.Repository;
import com.site.SDE.Entite.Developper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevelopperRepository extends JpaRepository <Developper,Long> {
        Developper findIdByEmail(String email);
        boolean existsByEmail(String email);


        }

