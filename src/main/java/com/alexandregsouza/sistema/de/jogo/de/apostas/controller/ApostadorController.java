package com.alexandregsouza.sistema.de.jogo.de.apostas.controller;

import com.alexandregsouza.sistema.de.jogo.de.apostas.model.Apostador;
import com.alexandregsouza.sistema.de.jogo.de.apostas.service.ApostadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/apostador")
public class ApostadorController {

    @Autowired
    private ApostadorService apostadorService;

    @PostMapping
    public ResponseEntity<Apostador> save(@RequestBody @Valid Apostador apostador) {
        return ResponseEntity.status(HttpStatus.CREATED).body(apostadorService.save(apostador));
    }

    @GetMapping
    public ResponseEntity<List<Apostador>> ListAll() {
        return ResponseEntity.status(HttpStatus.OK).body(apostadorService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apostador> findById(@PathVariable Long id) {
        Apostador apostador = apostadorService.findById(id).orElseThrow(() -> new RuntimeException("id is not existes"));
        return ResponseEntity.status(HttpStatus.OK).body(apostador);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        apostadorService.findById(id).map(apostador -> {
            apostadorService.deleteById(id);
            return apostador;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Apostador> update(@PathVariable Long id, @RequestBody Apostador apostador) {
        Apostador ap = apostadorService.findById(id).map(apostador1 -> {
            apostador1.setEmail(apostador.getEmail());
            apostador1.setId(id);
            apostador1.setNome(apostador.getNome());
            apostador1.setAnoNascimento(apostador.getAnoNascimento());
            apostador1.setCpf(apostador.getCpf());
            apostador1.setPlacaveiculo(apostador.getPlacaveiculo());
            return apostador1;
        }).orElseThrow(() -> new RuntimeException("id is not existes"));
        return ResponseEntity.status(HttpStatus.OK).body(ap);
    }


}
