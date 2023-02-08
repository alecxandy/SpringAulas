package com.alexandregsouza.sistema.de.jogo.de.apostas.service;

import com.alexandregsouza.sistema.de.jogo.de.apostas.model.Selecao;
import com.alexandregsouza.sistema.de.jogo.de.apostas.repository.SelecaoRepository;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SelecaoService {

    @Autowired
    private SelecaoRepository selecaoRepository;

    public Selecao save(Selecao selecao) {
        return selecaoRepository.save(selecao);
    }

    public List<Selecao> findAll() {
        return selecaoRepository.findAll();
    }

    public Optional<Selecao> findById(Long id) {
        return selecaoRepository.findById(id);
    }

    public void deleteById(Long id) {
        selecaoRepository.deleteById(id);
    }


}
