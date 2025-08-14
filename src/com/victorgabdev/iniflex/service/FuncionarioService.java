package com.victorgabdev.iniflex.service;

import com.victorgabdev.iniflex.entities.FuncaoFuncionario;
import com.victorgabdev.iniflex.entities.Funcionario;
import com.victorgabdev.iniflex.entities.Pessoa;
import com.victorgabdev.iniflex.exceptions.FuncionariosJaCarregadosException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Serviço responsável por gerenciar operações relacionadas aos funcionários,
 * como inserção, remoção, impressão de dados, aplicação de aumentos salariais,
 * agrupamento por função, cálculo de aniversariantes e demais informações.
 */
public class FuncionarioService {

    /** Lista de funcionários cadastrados. */
    private final List<Funcionario> funcionarios = new ArrayList<>();

    /** Mapa que agrupa funcionários por função. A chave é a função e o valor é a lista de funcionários. */
    private final Map<FuncaoFuncionario, List<Funcionario>> funcionariosAgrupadosPorFuncao = new HashMap<>();

    /**
     * Insere todos os funcionários na lista, utilizando dados pré-definidos.
     *
     * @throws FuncionariosJaCarregadosException caso os funcionários já tenham sido cadastrados anteriormente.
     */
    public void inserirFuncionarios() {

        if (!funcionarios.isEmpty()) throw new FuncionariosJaCarregadosException("Funcionarios já foram cadastrados");

        DateTimeFormatter formatter = getFormatter();

        funcionarios.add(new Funcionario("Maria", LocalDate.parse("18/10/2000", formatter), new BigDecimal("2009.44"), FuncaoFuncionario.OPERADOR));
        funcionarios.add(new Funcionario("João", LocalDate.parse("12/05/1990", formatter), new BigDecimal("2284.38"), FuncaoFuncionario.OPERADOR));
        funcionarios.add(new Funcionario("Caio", LocalDate.parse("02/05/1961", formatter), new BigDecimal("9836.14"), FuncaoFuncionario.COORDENADOR));
        funcionarios.add(new Funcionario("Miguel", LocalDate.parse("14/10/1988", formatter), new BigDecimal("19119.88"), FuncaoFuncionario.DIRETOR));
        funcionarios.add(new Funcionario("Alice", LocalDate.parse("05/01/1995", formatter), new BigDecimal("2234.68"), FuncaoFuncionario.RECEPCIONISTA));
        funcionarios.add(new Funcionario("Heitor", LocalDate.parse("19/11/1999", formatter), new BigDecimal("1582.72"), FuncaoFuncionario.OPERADOR));
        funcionarios.add(new Funcionario("Arthur", LocalDate.parse("31/03/1993", formatter), new BigDecimal("4071.84"), FuncaoFuncionario.CONTADOR));
        funcionarios.add(new Funcionario("Laura", LocalDate.parse("08/07/1994", formatter), new BigDecimal("3017.45"), FuncaoFuncionario.GERENTE));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.parse("24/05/2003", formatter), new BigDecimal("1606.85"), FuncaoFuncionario.ELETRICISTA));
        funcionarios.add(new Funcionario("Helena", LocalDate.parse("02/09/1996", formatter), new BigDecimal("2799.93"), FuncaoFuncionario.GERENTE));
    }

    /**
     * Remove um funcionário da lista pelo nome.
     *
     * @param nome Nome do funcionário a ser removido.
     * @throws NoSuchElementException se a lista de funcionários estiver vazia ou se o funcionário não existir.
     */
    public void removerFuncionario(String nome) {
        if (funcionarios.isEmpty()) throw new NoSuchElementException("Não há funcionários cadastrados.");
        boolean funcionarioRemovido = funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase(nome));
        if (!funcionarioRemovido)
            throw new NoSuchElementException(String.format("Funcionário com nome '%s' não existe", nome));
    }

    /**
     * Imprime todos os funcionários cadastrados com todas as suas informações.
     *
     * @throws NoSuchElementException se a lista de funcionários estiver vazia.
     */
    public void imprimirTodosFuncionarios() {
        if (funcionarios.isEmpty()) throw new NoSuchElementException("Não há funcionários cadastrados.");
        funcionarios.forEach(System.out::println);
    }

    /**
     * Aplica um aumento percentual no salário de todos os funcionários.
     *
     * @param percentual Percentual de aumento a ser aplicado (ex: 10 para 10%).
     * @throws NoSuchElementException se a lista de funcionários estiver vazia.
     */
    public void aplicarAumentoPercentual(double percentual) {
        if (funcionarios.isEmpty()) throw new NoSuchElementException("Não há funcionários cadastrados.");

        funcionarios.forEach(f -> {
            var novoSalario = calculaNovoSalario(f.getSalario(), percentual);
            f.setSalario(novoSalario);
        });
    }

    /**
     * Agrupa os funcionários por função em um mapa.
     * A chave é a função e o valor é a lista de funcionários que ocupam essa função.
     *
     * @throws NoSuchElementException se a lista de funcionários estiver vazia.
     */
    public void agruparFuncionariosPorFuncao() {
        if (funcionarios.isEmpty()) throw new NoSuchElementException("Não há funcionários cadastrados.");

        funcionariosAgrupadosPorFuncao.clear();
        for (Funcionario funcionario : funcionarios) {
            FuncaoFuncionario funcao = funcionario.getFuncao();

            if (!funcionariosAgrupadosPorFuncao.containsKey(funcao))
                funcionariosAgrupadosPorFuncao.put(funcao, new ArrayList<>());

            funcionariosAgrupadosPorFuncao.get(funcao).add(funcionario);
        }
    }

    /**
     * Imprime os funcionários agrupados por função.
     *
     * @throws NoSuchElementException se os funcionários ainda não tiverem sido agrupados.
     */
    public void imprimirFuncionariosAgrupados() {
        if (funcionariosAgrupadosPorFuncao.isEmpty())
            throw new NoSuchElementException("Os funcionários ainda não foram agrupados");

        for (var entry : funcionariosAgrupadosPorFuncao.entrySet()) {

            System.out.print(entry.getKey() + " = ");

            boolean primeiro = true;
            for (Funcionario f : entry.getValue()) {
                if (!primeiro) System.out.print(", ");
                System.out.print(f.getNome());
                primeiro = false;
            }

            System.out.println();
        }
    }

    /**
     * Imprime os funcionários que fazem aniversário nos meses 10 (outubro) e 12 (dezembro),
     * mostrando o nome e a data de nascimento.
     *
     * @throws NoSuchElementException se a lista de funcionários estiver vazia.
     */
    public void imprimirAniversariantesMes10E12() {
        if (funcionarios.isEmpty()) throw new NoSuchElementException("Não há funcionários cadastrados.");

        DateTimeFormatter formatter = getFormatter();

        funcionarios.stream()
                .filter(f -> {
                    int mes = f.getDataNascimento().getMonthValue();
                    return mes == 10 || mes == 12;
                })
                .forEach(f -> System.out.println(f.getNome() + " - " + f.getDataNascimento().format(formatter)));
    }

    /**
     * Imprime o funcionário com a maior idade, mostrando nome e idade.
     *
     * @throws NoSuchElementException se a lista de funcionários estiver vazia.
     */
    public void imprimirFuncionarioMaisVelho() {
        if (funcionarios.isEmpty()) throw new NoSuchElementException("Não há funcionários cadastrados.");

        Funcionario maisVelho = funcionarios.stream()
                .max(Comparator.comparing(f -> Period.between(f.getDataNascimento(), LocalDate.now()).getYears()))
                .get();

        int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
        System.out.println("Nome: " + maisVelho.getNome() + ", Idade: " + idade);
    }

    /**
     * Imprime a lista de funcionários em ordem alfabética pelo nome.
     *
     * @throws NoSuchElementException se a lista de funcionários estiver vazia.
     */
    public void imprimirFuncionariosOrdemAlfabetica() {
        if (funcionarios.isEmpty()) throw new NoSuchElementException("Não há funcionários cadastrados.");

        funcionarios.stream()
                .sorted(Comparator.comparing(Pessoa::getNome))
                .forEach(System.out::println);
    }

    /**
     * Imprime o total de salários de todos os funcionários.
     *
     * @throws NoSuchElementException se a lista de funcionários estiver vazia.
     */
    public void imprimirTotalSalarios() {
        if (funcionarios.isEmpty()) throw new NoSuchElementException("Não há funcionários cadastrados.");

        BigDecimal total = BigDecimal.ZERO;
        for (Funcionario f : funcionarios) total = total.add(f.getSalario());

        NumberFormat numberFormat = NumberFormat.getInstance(new Locale("pt", "BR"));
        System.out.println("Total de salários: " + numberFormat.format(total));
    }

    /**
     * Imprime quantos salários mínimos cada funcionário ganha.
     * Considera o salário mínimo como R$ 1212,00.
     *
     * @throws NoSuchElementException se a lista de funcionários estiver vazia.
     */
    public void imprimirSalariosEmMinimos() {
        if (funcionarios.isEmpty()) throw new NoSuchElementException("Não há funcionários cadastrados.");

        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        for (Funcionario funcionario : funcionarios) {
            BigDecimal quantidade = funcionario.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.println(funcionario.getNome() + " ganha " + quantidade + " salários mínimos");
        }
    }

    /**
     * Retorna um DateTimeFormatter com o padrão "dd/MM/yyyy".
     *
     * @return DateTimeFormatter
     */
    private DateTimeFormatter getFormatter() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    /**
     * Calcula o novo salário aplicando um percentual de aumento.
     *
     * @param salario Salário atual
     * @param percentual Percentual de aumento
     * @return Novo salário arredondado para 2 casas decimais
     */
    private BigDecimal calculaNovoSalario(BigDecimal salario, double percentual) {
        BigDecimal fator = BigDecimal.valueOf(percentual).divide(BigDecimal.valueOf(100));
        return salario.add(salario.multiply(fator)).setScale(2, RoundingMode.HALF_UP);
    }

}

