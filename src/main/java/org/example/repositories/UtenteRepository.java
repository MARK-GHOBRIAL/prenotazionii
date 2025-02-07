package org.example.repositories;

import org.example.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

    boolean existsByUsername(String username);
    boolean existsByNomeAndCognome(String nome, String cognome);
    boolean existsByEmail(String email);


}
