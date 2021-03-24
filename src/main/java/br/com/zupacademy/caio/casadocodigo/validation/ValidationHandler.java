package br.com.zupacademy.caio.casadocodigo.validation;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationHandler {

    private MessageSource messageSource;

    public ValidationHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorsList> validacaoCustomizada(MethodArgumentNotValidException e) {

        ErrorsList erros = new ErrorsList();

        e.getBindingResult().getGlobalErrors().forEach(erro -> {
            String mensagem = messageSource.getMessage(erro, LocaleContextHolder.getLocale());
            erros.getGlobalErrors().add(
                    new ErroDtoResponse(erro.getObjectName(), erro.getDefaultMessage())
            );
        });

        e.getBindingResult().getFieldErrors().forEach(erro -> {
            String mensagem = messageSource.getMessage(erro, LocaleContextHolder.getLocale());
            erros.getFieldErrors().add(
                    new ErroDtoResponse(erro.getField(), mensagem)
            );
        });


        return ResponseEntity.badRequest().body(erros);
    }
}
