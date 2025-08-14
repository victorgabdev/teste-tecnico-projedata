package com.victorgabdev.iniflex.entities;

/**
 * Enum que representa as funções possíveis de um funcionário na empresa.
 * Cada função possui uma descrição legível que pode ser usada para exibição.
 */
public enum FuncaoFuncionario {

    OPERADOR("Operador"),
    COORDENADOR("Coordenador"),
    DIRETOR("Diretor"),
    RECEPCIONISTA("Recepcionista"),
    CONTADOR("Contador"),
    GERENTE("Gerente"),
    ELETRICISTA("Eletricista");

    private final String descricao;

    FuncaoFuncionario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }


    /**
     * Busca uma função de funcionário pelo nome (case-insensitive).
     *
     * @param nome nome da função (ex.: "operador").
     * @return {@link FuncaoFuncionario} correspondente.
     * @throws IllegalArgumentException se a função não for encontrada.
     */
    public static FuncaoFuncionario buscarPorNome(String nome) {
        for (FuncaoFuncionario funcao : values()) {
            if (funcao.name().equalsIgnoreCase(nome) || funcao.descricao.equalsIgnoreCase(nome)) {
                return funcao;
            }
        }
        throw new IllegalArgumentException("Função inválida: " + nome);
    }

    @Override
    public String toString() {
        return descricao;
    }
}
