package org.example.entities;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Locale;

@Configuration
@PropertySource("application.properties")
public class BeansConfig {

    private final Faker faker;

    public BeansConfig() {
        this.faker = new Faker(Locale.ITALY); // Inizializzazione del Faker nel costruttore
    }

    @Bean
    public Edificio edificio1() {
        return createEdificio("Palazzo dei congressi", "Via Del Corso 9", "Roma");
    }

    @Bean
    public Edificio edificio2() {
        return createEdificio("Palazzo Sforza", "Piazza del duomo 3", "Milano");
    }

    @Bean
    public Edificio edificio3() {
        return createEdificio("Vesuviano", "Via del Plebiscito 32", "Napoli");
    }

    @Bean
    public Edificio edificio4() {
        return createEdificio("Colosseo quadrato", "Viale Marco Polo 256", "Roma");
    }

    @Bean
    public Edificio edificio5() {
        return createEdificio("Eliseo", "Via Roma 1", "Firenze");
    }

    @Bean
    public Utente utente() {
        return new Utente(
                faker.pokemon().name(),
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress()
        );
    }

    private Edificio createEdificio(String nome, String indirizzo, String citta) {
        return new Edificio(nome, indirizzo, citta);
    }
}
