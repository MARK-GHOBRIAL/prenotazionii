package org.example.repositories;

import org.example.entities.Postazione;
import org.example.entities.Prenotazione;
import org.example.entities.Utente;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    boolean existsByUtenteAndData(Utente utente, LocalDate data);

    List<Prenotazione> findByPostazioneAndData (Postazione postazione, LocalDate data);


}