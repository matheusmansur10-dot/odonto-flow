package br.com.odontoflow.dtos;

public class AtendimentoRequestDTO {

    private String observacoes;
    private String procedimentos;

    // getters e setters

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getProcedimentos() {
        return procedimentos;
    }

    public void setProcedimentos(String procedimentos) {
        this.procedimentos = procedimentos;
    }
}
