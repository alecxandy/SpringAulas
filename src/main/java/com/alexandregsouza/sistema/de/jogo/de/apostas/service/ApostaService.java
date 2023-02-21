package com.alexandregsouza.sistema.de.jogo.de.apostas.service;

import com.alexandregsouza.sistema.de.jogo.de.apostas.model.Aposta;
import com.alexandregsouza.sistema.de.jogo.de.apostas.repository.ApostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApostaService {

    @Autowired
    private ApostaRepository apostaRepository;

    private Aposta save(Aposta aposta) {
        return apostaRepository.save(aposta);
    }

    private List<Aposta> listAll() {
        return apostaRepository.findAll();
    }

    private Optional<Aposta> findById(Long id) {
        return apostaRepository.findById(id);
    }

    private void delete(Long id) {
        apostaRepository.deleteById(id);
    }

}
