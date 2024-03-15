package com.site.SDE.Repository;

import com.site.SDE.Entite.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findIdByEmail(String email);
    boolean existsByEmail(String email);
//    Client findClientByProjectId(long id);

}
