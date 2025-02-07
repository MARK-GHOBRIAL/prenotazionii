package org.example.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "edificio")
@Getter
@Setter
@NoArgsConstructor

@ToString
public class Edificio {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private long id;
    private String nome;
    private String indirizzo;
    private String city;


    public Edificio(String nome, String indirizzo, String city) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.city = city;
    }
}