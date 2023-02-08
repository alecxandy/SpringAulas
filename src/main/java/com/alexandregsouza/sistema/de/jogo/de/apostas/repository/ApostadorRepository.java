package com.alexandregsouza.sistema.de.jogo.de.apostas.repository;

import com.alexandregsouza.sistema.de.jogo.de.apostas.model.Apostador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApostadorRepository extends JpaRepository<Apostador,Long> {
}
