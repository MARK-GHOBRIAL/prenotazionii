package org.example.repositories;

import org.example.entities.Edificio;
import org.example.entities.Postazione;
import org.example.enums.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {


    boolean existsByDescrizione (String descrizione);



    @Query("SELECT a FROM Postazione a WHERE a.tipo = UPPER(:tipo)")
    List<Postazione> findByTipo(String tipo);

    @Query("SELECT a FROM Postazione a WHERE a.tipo = UPPER(:tipo) AND a.edificio.city = :city")
    List<Postazione> findByTipoAndCity(String tipo, String city);
}
