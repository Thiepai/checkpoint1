package br.com.fiap.checkpoint1.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String especialidade;

    private Double valorHora;


    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Profissional() {
    }

    public Profissional(String nome, String especialidade, Double valorHora) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.valorHora = valorHora;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public Double getValorHora() {
        return valorHora;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
