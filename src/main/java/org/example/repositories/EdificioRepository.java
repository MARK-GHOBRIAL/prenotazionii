package org.example.repositories;

import org.example.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {

    boolean existsByNome(String nome);

    List<Edificio> findByCity(String city);
}