package com.alexandregsouza.sistema.de.jogo.de.apostas.controller;

import com.alexandregsouza.sistema.de.jogo.de.apostas.model.Selecao;
import com.alexandregsouza.sistema.de.jogo.de.apostas.service.SelecaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/api/selecao")
public class SelecaoController {

    @Autowired
    private SelecaoService selecaoService;

    @PostMapping
    public ResponseEntity<Selecao> save(Selecao selecao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(selecaoService.save(selecao));
    }

    @GetMapping
    public ResponseEntity<List<Selecao>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(selecaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Selecao> findById(@PathVariable Long id) {
        Selecao selecao = selecaoService.findById(id).orElseThrow(() -> new RuntimeException("id is not exists"));
        return ResponseEntity.status(HttpStatus.OK).body(selecao);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        selecaoService.findById(id)
                .map(selecao -> {
                    selecaoService.delete(selecao);
                    return selecao;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Seleção não encontrado"));

    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody Selecao selecao) {
        selecaoService.findById(id).map(s -> {
            selecao.setId(id);
            selecaoService.save(selecao);
            return selecao;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seleção não encontrado"));
    }

}
