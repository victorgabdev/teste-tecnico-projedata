package com.victorgabdev.iniflex.entities;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Funcionario extends Pessoa {

    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        NumberFormat numberFormat = NumberFormat.getInstance(new Locale("pt", "BR"));
        String salarioFormatado = numberFormat.format(this.salario);

        return String.format("Nome: %s, data nascimento: %s, salário: %s, função: %s",
                this.nome,
                this.dataNascimento.format(formatter),
                salarioFormatado,
                this.funcao);
    }
}
