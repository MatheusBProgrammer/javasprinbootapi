package com.exemplo.api_clientes.model;

// Importações do Jakarta Persistence
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Indica que esta classe é uma entidade JPA que será mapeada para uma tabela no banco de dados
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Construtor padrão (obrigatório para o JPA)
    public Cliente() {}

    public Cliente(String nome){
        this.nome = nome;
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
