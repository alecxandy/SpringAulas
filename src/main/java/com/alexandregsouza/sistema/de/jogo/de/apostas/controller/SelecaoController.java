package com.alexandregsouza.sistema.de.jogo.de.apostas.controller;

import com.alexandregsouza.sistema.de.jogo.de.apostas.model.Selecao;
import com.alexandregsouza.sistema.de.jogo.de.apostas.service.SelecaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/selecao")
public class SelecaoController {

    @Autowired
    private SelecaoService selecaoService;

    @PostMapping
    public ResponseEntity<Selecao> save(Selecao selecao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(selecaoService.save(selecao));
    }


}
