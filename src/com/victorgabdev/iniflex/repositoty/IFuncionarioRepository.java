package com.victorgabdev.iniflex.repositoty;

import com.victorgabdev.iniflex.entities.Funcionario;

import java.util.List;

/**
 * Interface que define o contrato para um repositório de funcionários.
 * <p>
 * Esta interface especifica os métodos que devem ser implementados por classes
 * que fornecem acesso a dados de funcionários.
 * </p>
 */
public interface IFuncionarioRepository {

    /**
     * Retorna uma lista contendo todos os funcionários cadastrados.
     * <p>
     * A implementação deste metodo deve recuperar e retornar todos os funcionários
     * disponíveis no repositório de dados.
     * </p>
     *
     * @return Uma {@link List} de {@link Funcionario} contendo todos os funcionários.
     *         Se não houver funcionários cadastrados, retorna uma lista vazia.
     */
    List<Funcionario> retornaTodosFuncionarios();
}
