package br.com.fiap.checkpoint1.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "profissional_id", nullable = false)
    private Profissional profissional;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    private LocalDateTime dataConsulta;

    private String statusConsulta;

    private Integer quantidadeHoras;

    private Double valorConsulta;

    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Consulta() {}

    public Consulta(Profissional profissional, Paciente paciente, LocalDateTime dataConsulta,
                    String statusConsulta, Integer quantidadeHoras, Double valorConsulta) {
        this.profissional = profissional;
        this.paciente = paciente;
        this.dataConsulta = dataConsulta;
        this.statusConsulta = statusConsulta;
        this.quantidadeHoras = quantidadeHoras;
        this.valorConsulta = valorConsulta;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public String getStatusConsulta() {
        return statusConsulta;
    }

    public Integer getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public Double getValorConsulta() {
        return valorConsulta;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public void setStatusConsulta(String statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    public void setQuantidadeHoras(Integer quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }

    public void setValorConsulta(Double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
