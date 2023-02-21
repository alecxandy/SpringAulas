package com.alexandregsouza.sistema.de.jogo.de.apostas.validation;

import com.alexandregsouza.sistema.de.jogo.de.apostas.validation.constraint.PlacaCarro;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PlacaCarroValidation implements ConstraintValidator<PlacaCarro, String> {

    @Override
    public void initialize(PlacaCarro constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        String placa = value == null ? "" : value;
        return placa.matches("[a-zA-Z]{3}[0-9][A-Za-z0-9][0-9]{2}");
        //as tre primeiras são de A a Z = [a-zA-Z]{3}
        //O proximo será um numero = [0-9]
        //Pode ser um numero ou letra = [A-Za-z0-9]
        //dois numeros no final = [0-9]{2}
    }


}
