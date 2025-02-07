package org.example.entities;

import org.example.enums.Tipo;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "postazione")
@Getter
@Setter
@NoArgsConstructor

@ToString
public class Postazione {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private long id;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    @Column(name = "max_partecipanti")
    private int numeroMaxPartecipanti;

    @ManyToOne
    @JoinColumn(name = "id_edificio")
    private Edificio edificio;


    public Postazione(String descrizione, Tipo tipo, int numeroMaxPartecipanti, Edificio edificio) {
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.numeroMaxPartecipanti = numeroMaxPartecipanti;
        this.edificio = edificio;
    }
}