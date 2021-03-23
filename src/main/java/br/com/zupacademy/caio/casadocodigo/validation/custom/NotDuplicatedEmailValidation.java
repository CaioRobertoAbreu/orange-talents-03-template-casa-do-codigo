package br.com.zupacademy.caio.casadocodigo.validation.custom;

import br.com.zupacademy.caio.casadocodigo.model.Autor;
import br.com.zupacademy.caio.casadocodigo.repository.AutorRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class NotDuplicatedEmailValidation implements ConstraintValidator<NotDuplicatedEmail, String> {

    private AutorRepository autorRepository;

    public NotDuplicatedEmailValidation(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintContext) {
        Optional<Autor> emailEncontrado = autorRepository.findByEmail(email);

        if (emailEncontrado.isPresent()) {
            return false;
        }

        return true;
    }
}
