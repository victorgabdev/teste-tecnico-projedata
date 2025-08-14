package com.victorgabdev.iniflex.entities;

import java.time.LocalDate;

/**
 * Classe abstrata que representa uma pessoa no sistema.
 * <p>
 * Contém os atributos básicos {@code nome} e {@code dataNascimento}
 * que são comuns a diferentes tipos de entidades, como {@link Funcionario}.
 * </p>
 */
public abstract class Pessoa {

    protected String nome;
    protected LocalDate dataNascimento;

    public Pessoa() {
    }

    /**
     * Construtor que inicializa nome e data de nascimento.
     *
     * @param nome Nome completo da pessoa.
     * @param dataNascimento Data de nascimento da pessoa.
     */
    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
