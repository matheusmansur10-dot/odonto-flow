package br.com.odontoflow.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class AgendamentoRequestDTO {

    @NotNull
    private UUID clinicaId;

    @NotNull
    private UUID dentistaId;

    @NotNull
    private UUID clienteId;

    @NotNull
    private LocalDate data;

    @NotNull
    private LocalTime horaInicio;

    @NotNull
    private LocalTime horaFim;

    // getters e setters

    public UUID getClinicaId() {
        return clinicaId;
    }

    public void setClinicaId(UUID clinicaId) {
        this.clinicaId = clinicaId;
    }

    public UUID getDentistaId() {
        return dentistaId;
    }

    public void setDentistaId(UUID dentistaId) {
        this.dentistaId = dentistaId;
    }

    public UUID getClienteId() {
        return clienteId;
    }

    public void setClienteId(UUID clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }
}
