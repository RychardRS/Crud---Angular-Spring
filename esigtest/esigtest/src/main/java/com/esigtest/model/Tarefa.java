package com.esigtest.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Objects;

@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;
    private String descricao;
    private String responsavel;
    private String prioridade;
    private LocalDate deadline;
    private String situacao; // Em andamento ou Concluída
    


    public Tarefa() {
    }

    public Tarefa(Long id, String titulo, String descricao, String responsavel, String prioridade, LocalDate deadline, String situacao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.prioridade = prioridade;
        this.deadline = deadline;
        this.situacao = situacao;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResponsavel() {
        return this.responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getPrioridade() {
        return this.prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public LocalDate getDeadline() {
        return this.deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getSituacao() {
        return this.situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Tarefa id(Long id) {
        setId(id);
        return this;
    }

    public Tarefa titulo(String titulo) {
        setTitulo(titulo);
        return this;
    }

    public Tarefa descricao(String descricao) {
        setDescricao(descricao);
        return this;
    }

    public Tarefa responsavel(String responsavel) {
        setResponsavel(responsavel);
        return this;
    }

    public Tarefa prioridade(String prioridade) {
        setPrioridade(prioridade);
        return this;
    }

    public Tarefa deadline(LocalDate deadline) {
        setDeadline(deadline);
        return this;
    }

    public Tarefa situacao(String situacao) {
        setSituacao(situacao);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Tarefa)) {
            return false;
        }
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(id, tarefa.id) && Objects.equals(titulo, tarefa.titulo) && Objects.equals(descricao, tarefa.descricao) && Objects.equals(responsavel, tarefa.responsavel) && Objects.equals(prioridade, tarefa.prioridade) && Objects.equals(deadline, tarefa.deadline) && Objects.equals(situacao, tarefa.situacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, descricao, responsavel, prioridade, deadline, situacao);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", titulo='" + getTitulo() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", responsavel='" + getResponsavel() + "'" +
            ", prioridade='" + getPrioridade() + "'" +
            ", deadline='" + getDeadline() + "'" +
            ", situacao='" + getSituacao() + "'" +
            "}";
    }
    
}

