package org.example.servicies;

import org.example.entities.Edificio;
import org.example.entities.Postazione;
import org.example.entities.Utente;
import org.example.exceptions.ItemNotFoundException;
import org.example.repositories.UtenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;


    public void saveUtente(Utente newUtente){

        if(utenteRepository.existsByUsername(newUtente.getUsername())) {
            throw new RuntimeException("Lo username ' " + newUtente.getUsername() + " è già presente nel db!");
        }
        if(utenteRepository.existsByNomeAndCognome(newUtente.getNome(), newUtente.getCognome())) {
            throw new RuntimeException("L'utente " + newUtente.getNome() + " " +newUtente.getCognome() + " è già presente nel db!");
        }
        if(utenteRepository.existsByEmail(newUtente.getEmail())) {
            throw new RuntimeException("La mail " + newUtente.getEmail() + " è già presente nel db!");
        }

        utenteRepository.save(newUtente);
        System.out.println("L'utente " + newUtente.getNome() + " è stato salvato nel db");



    }
    public Utente findById(long utenteId){

        return utenteRepository.findById(utenteId).orElseThrow(() -> new ItemNotFoundException(utenteId));

    }

}