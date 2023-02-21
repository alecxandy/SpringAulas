package com.alexandregsouza.sistema.de.jogo.de.apostas.validation.constraint;

import com.alexandregsouza.sistema.de.jogo.de.apostas.validation.PlacaCarroValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PlacaCarroValidation.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PlacaCarro {

    String message() default "Placa de carro invalida";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
