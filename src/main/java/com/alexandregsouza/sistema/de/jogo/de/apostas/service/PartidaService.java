package com.alexandregsouza.sistema.de.jogo.de.apostas.service;

import com.alexandregsouza.sistema.de.jogo.de.apostas.model.Partida;
import com.alexandregsouza.sistema.de.jogo.de.apostas.model.Selecao;
import com.alexandregsouza.sistema.de.jogo.de.apostas.model.dto.PartidaDTO;
import com.alexandregsouza.sistema.de.jogo.de.apostas.repository.PartidaRepository;
import com.alexandregsouza.sistema.de.jogo.de.apostas.repository.SelecaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    public Partida save(Partida partida) {
        return partidaRepository.save(partida);
    }

    public Optional<Partida> findById(Long id) {
        return partidaRepository.findById(id);
    }

    public List<Partida> list() {
        return partidaRepository.findAll();
    }

    public void deleteById(Long id) {
        partidaRepository.deleteById(id);
    }
}
