package com.alexandregsouza.sistema.de.jogo.de.apostas.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApostaDTO {

    private Long id;
    private LocalDateTime localDateTime;
    private int casa;
    private int fora;
    private Long apostador;
    private Long partida;

}
