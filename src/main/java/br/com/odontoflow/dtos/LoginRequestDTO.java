package br.com.odontoflow.dtos;

import jakarta.validation.constraints.NotBlank;

public class LoginRequestDTO {

    @NotBlank
    private String email;

    @NotBlank
    private String senha;

    // getters e setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
