package br.com.odontoflow.dtos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class AgendamentoResponseDTO {

    private UUID id;
    private UUID clinicaId;
    private UUID dentistaId;
    private UUID clienteId;
    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private String status;

    // getters e setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
