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
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "casa")
    private String casa;
    @Column(name = "fora")
    private String fora;
    @Column(name = "datapartida")
    private LocalDateTime dataPartida;
    @Column(name = "resultado", length = 45)
    private String resultado;

    @ManyToMany
    @JoinTable(name = "tb_partida_has_selecao",
            joinColumns = {@JoinColumn(name = "partida_id_selecao")},
            inverseJoinColumns = {@JoinColumn(name = "selecao_id")})
    private List<Selecao> selecaoList;

    @ManyToMany
    @JoinTable(name = "tb_partida_has_aposta",
            joinColumns = {@JoinColumn(name = "partida_id_aposta")},
            inverseJoinColumns = {@JoinColumn(name = "aposta_id")})
    private List<Aposta> apostaList;


}

