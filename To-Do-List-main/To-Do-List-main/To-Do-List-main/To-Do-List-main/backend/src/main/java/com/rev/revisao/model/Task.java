package com.rev.revisao.model;

import jakarta.persistence.*;

/**
 * Entidade Task que representa uma tarefa na API.
 * Utiliza anotações JPA para mapeamento com o banco de dados.
 */
@Entity // Marca a classe como uma entidade JPA
@Table(name = "tasks") // Define o nome da tabela no banco de dados
public class Task {

    @Id // Indica o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o ID automaticamente (auto-incremento)
    private Long id;

    @Column(nullable = false) // Campo obrigatório no banco
    private String title;

    @Column // Campo opcional
    private String description;

    @Column(nullable = false) // Campo obrigatório, valor padrão false
    private Boolean completed = false;

    // Construtor padrão exigido pelo JPA
    public Task() {}

    // Construtor completo para facilitar criação manual
    public Task(Long id, String title, String description, Boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    // Getters e Setters para acessar e modificar os campos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}