package com.alexandregsouza.sistema.de.jogo.de.apostas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aposta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "data")
    private LocalDateTime localDateTime;
    @ManyToOne
    @JoinColumn(name = "apostador_id")
    private Apostador apostador;
    @ManyToMany
    private List<Partida> partidaList;


}
