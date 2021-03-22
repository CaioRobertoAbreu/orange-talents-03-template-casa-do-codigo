package br.com.zupacademy.caio.casadocodigo.controller.validation;

public class ErroDtoResponse {

    private String campo;
    private String mensagem;

    public ErroDtoResponse(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
