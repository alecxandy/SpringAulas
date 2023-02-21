package com.alexandregsouza.sistema.de.jogo.de.apostas.service;

import com.alexandregsouza.sistema.de.jogo.de.apostas.model.Apostador;
import com.alexandregsouza.sistema.de.jogo.de.apostas.repository.ApostadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApostadorService {

    @Autowired
    private ApostadorRepository apostadorRepository;

    public Apostador save(Apostador apostador) {
        return apostadorRepository.save(apostador);
    }

    public List<Apostador> listAll() {
        return apostadorRepository.findAll();
    }

    public Optional<Apostador> findById(Long id) {
        return apostadorRepository.findById(id);
    }

    public void deleteById(Long id) {
        apostadorRepository.deleteById(id);
    }

}
