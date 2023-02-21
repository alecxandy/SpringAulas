package com.alexandregsouza.sistema.de.jogo.de.apostas.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // data iso-8601 UTC/GMT
    // 2022-07-20T01:30:26-03:00 padrao brasil
    @Column(name = "datapartida")
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm z")
    private LocalDateTime dataPartida;

    @OneToOne
    @JoinColumn(name = "selecao_casa_id")
    private Selecao casa;

    @OneToOne
    @JoinColumn(name = "selecao_fora_id")
    private Selecao fora;

}

