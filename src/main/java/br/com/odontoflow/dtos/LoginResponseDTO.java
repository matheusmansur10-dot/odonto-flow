package br.com.odontoflow.dtos;

import java.util.UUID;

public class LoginResponseDTO {

    private String token;
    private UUID usuarioId;
    private String tipoUsuario;
    private UUID clinicaId; // null para cliente
    private String perfil;  // null para cliente

    // getters e setters

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UUID getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(UUID usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public UUID getClinicaId() {
        return clinicaId;
    }

    public void setClinicaId(UUID clinicaId) {
        this.clinicaId = clinicaId;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
