package br.com.zupacademy.caio.casadocodigo.controller.validation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ErrorsList {

    private LocalDateTime instante = LocalDateTime.now();
    private List<ErroDtoResponse> globalErrors = new ArrayList<>();
    private List<ErroDtoResponse> fieldErrors = new ArrayList<>();


    public LocalDateTime getInstante() {
        return instante;
    }

    public List<ErroDtoResponse> getFieldErrors() {
        return fieldErrors;
    }

    public List<ErroDtoResponse> getGlobalErrors() {
        return globalErrors;
    }
}
