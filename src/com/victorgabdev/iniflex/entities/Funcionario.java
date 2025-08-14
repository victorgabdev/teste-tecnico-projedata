package com.victorgabdev.iniflex.entities;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Representa um funcionário da empresa, contendo informações
 * sobre nome, data de nascimento, salário e função exercida.
 * <p>
 * Esta classe estende {@link Pessoa} e adiciona propriedades
 * específicas de um funcionário.
 * </p>
 */
public class Funcionario extends Pessoa {

    /** Salário do funcionário. */
    private BigDecimal salario;

    /** Função exercida pelo funcionário. */
    private FuncaoFuncionario funcao;

    /**
     * Construtor para inicializar um funcionário com todos os dados obrigatórios.
     *
     * @param nome           Nome completo do funcionário.
     * @param dataNascimento Data de nascimento do funcionário.
     * @param salario        Salário atual do funcionário.
     * @param funcao         Função exercida pelo funcionário.
     */
    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, FuncaoFuncionario funcao) {
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

    public FuncaoFuncionario getFuncao() {
        return funcao;
    }

    public void setFuncao(FuncaoFuncionario funcao) {
        this.funcao = funcao;
    }

    /**
     * Retorna uma representação textual formatada do funcionário,
     * incluindo nome, data de nascimento, salário e função.
     * <p>
     * O salário é formatado no padrão brasileiro e a data no formato "dd/MM/yyyy".
     * </p>
     *
     * @return String representando o funcionário.
     */
    @Override
    public String toString() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        NumberFormat numberFormat = NumberFormat.getInstance(new Locale("pt", "BR"));
        String salarioFormatado = numberFormat.format(this.salario);

        return String.format("Nome: %s, data nascimento: %s, salário: %s, função: %s",
                this.nome,
                this.dataNascimento.format(formatter),
                salarioFormatado,
                this.funcao.getDescricao());
    }
}
