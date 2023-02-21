package com.alexandregsouza.sistema.de.jogo.de.apostas.controller;

import com.alexandregsouza.sistema.de.jogo.de.apostas.model.Aposta;
import com.alexandregsouza.sistema.de.jogo.de.apostas.model.Apostador;
import com.alexandregsouza.sistema.de.jogo.de.apostas.model.Partida;
import com.alexandregsouza.sistema.de.jogo.de.apostas.model.dto.ApostaDTO;
import com.alexandregsouza.sistema.de.jogo.de.apostas.repository.ApostaRepository;
import com.alexandregsouza.sistema.de.jogo.de.apostas.service.ApostaService;
import com.alexandregsouza.sistema.de.jogo.de.apostas.service.ApostadorService;
import com.alexandregsouza.sistema.de.jogo.de.apostas.service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ApostaController {

    @Autowired
    private ApostadorService apostadorService;
    @Autowired
    private PartidaService partidaService;
    @Autowired
    private ApostaRepository apostaRepository;
    @Autowired
    private ApostaService apostaService;

    @PostMapping
    public ResponseEntity<Aposta> save(@RequestBody ApostaDTO apostaDTO) {
        Apostador apostador = apostadorService.findById(apostaDTO.getApostador())
                .orElseThrow(() -> new RuntimeException("id is not existes"));
        Partida partida = partidaService.findById(apostaDTO.getPartida())
                .orElseThrow(() -> new RuntimeException("id is not existes"));
        Aposta aposta = new Aposta();
        aposta.setApostador(apostador);
        aposta.setPartida(partida);
        aposta.setPlacarFora(apostaDTO.getFora());
        aposta.setPlacarCasa(apostaDTO.getCasa());
        aposta.setLocalDateTime(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.OK).body(apostaRepository.save(aposta));
    }


    @GetMapping
    public ResponseEntity<List<Aposta>> ListAll() {
        return ResponseEntity.status(HttpStatus.OK).body(apostaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aposta> findById(@PathVariable Long id) {
        Aposta aposta = apostaRepository.findById(id).orElseThrow(() -> new RuntimeException("id is not existes"));
        return ResponseEntity.status(HttpStatus.OK).body(aposta);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        apostaRepository.findById(id).map(aposta -> {
            apostaRepository.deleteById(id);
            return aposta;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aposta> update(@PathVariable Long id, @RequestBody ApostaDTO apostaDTO) {
        Apostador apostador = apostadorService.findById(apostaDTO.getApostador())
                .orElseThrow(() -> new RuntimeException("id is not existes"));
        Partida partida = partidaService.findById(apostaDTO.getPartida())
                .orElseThrow(() -> new RuntimeException("id is not existes"));
        Aposta ap = apostaRepository.findById(id).map(apost -> {
            apost.setLocalDateTime(LocalDateTime.now());
            apost.setId(id);
            apost.setApostador(apostador);
            apost.setPartida(partida);
            apost.setPlacarFora(apostaDTO.getFora());
            apost.setPlacarCasa(apostaDTO.getCasa());
            return apost;
        }).orElseThrow(() -> new RuntimeException("id is not existes"));
        return ResponseEntity.status(HttpStatus.OK).body(ap);
    }


}
