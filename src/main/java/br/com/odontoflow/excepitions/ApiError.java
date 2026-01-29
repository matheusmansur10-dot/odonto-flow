package br.com.odontoflow.excepitions;

import java.time.LocalDateTime;

public class ApiError {

    private int status;
    private String mensagem;
    private LocalDateTime timestamp = LocalDateTime.now();

    public ApiError(int status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }
}
