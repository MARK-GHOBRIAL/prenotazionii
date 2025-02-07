package org.example;


import org.example.entities.Edificio;
import org.example.entities.Postazione;
import org.example.entities.Prenotazione;
import org.example.entities.Utente;
import org.example.enums.Tipo;
import org.example.servicies.EdificioService;
import org.example.servicies.PostazioneService;
import org.example.servicies.PrenotazioneService;
import org.example.servicies.UtenteService;
import org.example.beans.factory.annotation.Autowired;
import org.example.boot.CommandLineRunner;
import org.example.context.annotation.AnnotationConfigApplicationContext;
import org.example.stereotype.Component;

import java.time.LocalDate;

@Component
public class GestionePrenotazioniRunner implements CommandLineRunner {

    @Autowired
    private EdificioService edificioService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private PrenotazioneService prenotazioneService;


    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(U5W1D5Application.class);

        Edificio edificio2 = (Edificio) context.getBean("edificio2");
        Edificio edificio3 = (Edificio) context.getBean("edificio3");
        Edificio edificio4 = (Edificio) context.getBean("edificio4");
        Edificio edificio5 = (Edificio) context.getBean("edificio5");
        Edificio edificio1 =  edificioService.findById(106);

        Postazione postazione1 = new Postazione("Openspace curato con postazioni singole per lavorare in pace", Tipo.OPENSPACE, 9,   edificio1);

        Utente utente1 =context.getBean(Utente.class);
        Utente utente = utenteService.findById(452);

        Postazione postazione = postazioneService.findById(402);

        Prenotazione prenotazione1 = new Prenotazione(LocalDate.now().plusWeeks(2), postazione, utente);

        postazioneService.findByTipo("PRIVATO").forEach(System.out::println);
        postazioneService.findByTipoAndCity("PRIVATO", "Roma").forEach(System.out::println);
        edificioService.findByCity("Roma").forEach(System.out::println);


        context.close();
    }
}