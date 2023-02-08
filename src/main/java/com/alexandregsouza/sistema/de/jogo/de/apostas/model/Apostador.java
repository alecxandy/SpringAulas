package com.alexandregsouza.sistema.de.jogo.de.apostas.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apostador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "idade")
    private int idade;
    @Column(name = "email")
    private String email;
    @OneToMany
    List<Aposta> apostaList;
}
