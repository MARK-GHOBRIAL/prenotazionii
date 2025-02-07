package org.example.servicies;

import org.example.entities.Edificio;
import org.example.exceptions.ItemNotFoundException;
import org.example.repositories.EdificioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    public void saveEdificio(Edificio newEdificio){

        if(edificioRepository.existsByNome(newEdificio.getNome())) {
            throw new RuntimeException("L'edificio " + newEdificio.getNome() + " è già presente nel db!");
        }

        edificioRepository.save(newEdificio);
        System.out.println(newEdificio.getNome() + " Salvato correttamente nel db");
    }

    public Edificio findById(long edificioId){

        return edificioRepository.findById(edificioId).orElseThrow(() -> new ItemNotFoundException(edificioId));

    }

    public List<Edificio> findByCity(String city){
        return edificioRepository.findByCity(city);
    }
}
