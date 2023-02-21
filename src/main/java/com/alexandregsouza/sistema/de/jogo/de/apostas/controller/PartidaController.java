package com.alexandregsouza.sistema.de.jogo.de.apostas.controller;

import com.alexandregsouza.sistema.de.jogo.de.apostas.model.Partida;
import com.alexandregsouza.sistema.de.jogo.de.apostas.model.Selecao;
import com.alexandregsouza.sistema.de.jogo.de.apostas.model.dto.PartidaDTO;
import com.alexandregsouza.sistema.de.jogo.de.apostas.service.PartidaService;
import com.alexandregsouza.sistema.de.jogo.de.apostas.service.SelecaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/partida")
public class PartidaController {

    @Autowired
    private PartidaService partidaService;

    @Autowired
    private SelecaoService selecaoService;

    @PostMapping
    public ResponseEntity<Partida> save(@RequestBody  PartidaDTO partidaDTO) {


        Selecao selecaoCasa = selecaoService.findById(partidaDTO.getCasa())
                .orElseThrow(() -> new RuntimeException("Id invalid"));
        Selecao selecaoFora = selecaoService.findById(partidaDTO.getFora())
                .orElseThrow(() -> new RuntimeException("Id invalid"));

        Partida partida = new Partida();
        partida.setDataPartida(partidaDTO.getTeste());
        partida.setFora(selecaoFora);
        partida.setCasa(selecaoCasa);
        return ResponseEntity.status(HttpStatus.CREATED).body(partidaService.save(partida));
    }

    @GetMapping
    public ResponseEntity<List<Partida>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(partidaService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partida> findById(@PathVariable Long id) {
        Partida partida = partidaService.findById(id).orElseThrow(() -> new RuntimeException("id is not exists"));
        return ResponseEntity.status(HttpStatus.OK).body(partida);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        partidaService.findById(id).map(partida -> {
            partidaService.deleteById(id);
            return partida;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "id is not existes"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partida> update(@PathVariable long id, PartidaDTO partidaDTO) {
        Selecao selecaoCasa = selecaoService.findById(partidaDTO.getCasa())
                .orElseThrow(() -> new RuntimeException("Id invalid"));
        Selecao selecaoFora = selecaoService.findById(partidaDTO.getFora())
                .orElseThrow(() -> new RuntimeException("Id invalid"));
        Partida partida = partidaService.findById(id).map(p -> {
            p.setId(id);
            p.setDataPartida(partidaDTO.getTeste());
            p.setFora(selecaoFora);
            p.setCasa(selecaoCasa);
            return p;
        }).orElseThrow(() -> new RuntimeException("id is not existes"));
        return ResponseEntity.status(HttpStatus.OK).body(partida);
    }


}
