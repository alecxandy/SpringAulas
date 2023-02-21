package com.alexandregsouza.sistema.de.jogo.de.apostas.model;

import java.util.List;

import com.alexandregsouza.sistema.de.jogo.de.apostas.validation.constraint.PlacaCarro;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apostador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nome")
    @NotBlank(message = "campo não informado")
    @Pattern(regexp = "^[A-Z]+(.)*", message = "Primeiro letra do nome deve começar com letra maiscula")
    private String nome;
    @Column(name = "ano_nascimento")
    @NotBlank(message = "campo não informado")
    @Min(value = 1990, message = "Ano não pode ser inferior a 1990")
    private int anoNascimento;
    @Column(name = "email")
    @NotBlank(message = "campo não informado")
    @Email(message = "campo invalido")
    private String email;
    @Column(name = "cpf")
    @NotBlank(message = "campo não informado")
    @CPF(message = "campo invalido")
    private String cpf;
    @Column(name = "placa_veiculo")
    @NotBlank(message = "campo não informado")
    @PlacaCarro(message = "informe uma placa valida")
    private String placaveiculo;

}
