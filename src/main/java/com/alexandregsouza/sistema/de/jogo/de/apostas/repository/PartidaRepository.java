package com.alexandregsouza.sistema.de.jogo.de.apostas.repository;

import com.alexandregsouza.sistema.de.jogo.de.apostas.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository extends JpaRepository<Partida,Long> {
}
