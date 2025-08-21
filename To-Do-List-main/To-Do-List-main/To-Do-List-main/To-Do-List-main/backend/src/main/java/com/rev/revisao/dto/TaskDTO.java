package com.rev.revisao.dto;

// Importa anotações para serialização JSON e validação de campos
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO para transferência de dados da entidade Task.
 * Usado para transportar dados entre as camadas da aplicação.
 */
public class TaskDTO {

    @JsonProperty("id") // Mapeia o campo para JSON
    private Long id;

    @NotBlank(message = "Title is required") // Valida que o título não pode ser vazio
    @Size(max = 100, message = "Title must be less than 100 characters") // Limita o tamanho do título
    @JsonProperty("title")
    private String title;

    @Size(max = 500, message = "Description must be less than 500 characters") // Limita o tamanho da descrição
    @JsonProperty("description")
    private String description;

    @JsonProperty("completed")
    private Boolean completed; // Indica se a tarefa está concluída

    // Construtor padrão para frameworks e serialização
    public TaskDTO() {}

    // Construtor completo para facilitar a criação do DTO
    public TaskDTO(Long id, String title, String description, Boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    // Métodos getters e setters para acessar e modificar os campos

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