package com.victorgabdev.iniflex.repositoty;

import com.victorgabdev.iniflex.entities.FuncaoFuncionario;
import com.victorgabdev.iniflex.entities.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementação concreta do repositório de funcionários.
 * <p>
 * Esta classe fornece uma implementação em memória da interface {@link IFuncionarioRepository},
 * inicializando uma lista pré-definida de funcionários com seus respectivos dados.
 * </p>
 */
public class FuncionarioRepositoryImpl implements IFuncionarioRepository{

    public FuncionarioRepositoryImpl() {
    }

    /**
     * Retorna todos os funcionários cadastrados no repositório.
     * <p>
     * Este metodo implementa a operação definida na interface {@link IFuncionarioRepository}
     * e retorna uma lista pré-populada de funcionários com dados fictícios para demonstração.
     * </p>
     * <p>
     * A lista inclui diversos funcionários com diferentes cargos, salários e datas de nascimento,
     * formatados no padrão "dd/MM/yyyy".
     * </p>
     *
     * @return Uma lista imutável contendo todos os {@link Funcionario} cadastrados.
     *         A lista sempre conterá os 10 funcionários pré-definidos.
     * @see IFuncionarioRepository#retornaTodosFuncionarios()
     */
    @Override
    public List<Funcionario> retornaTodosFuncionarios() {

        List<Funcionario> funcionarios = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");;

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

        return funcionarios;
    }
}
