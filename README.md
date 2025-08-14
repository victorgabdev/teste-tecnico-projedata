# Gerenciamento de Funcionários

Este projeto é uma aplicação Java para o gerenciamento de funcionários, simulando diversas operações sobre uma lista de dados pré-definidos. Ele foi desenvolvido como parte de um teste técnico e demonstra o uso de conceitos como **orientação a objetos**, **coleções**, **tratamento de exceções** e manipulação de datas e números em Java.

---

### Funcionalidades

O programa executa uma sequência de operações pré-determinadas para demonstrar as capacidades do serviço de gerenciamento de funcionários (`FuncionarioService`):

1.  **Inserção de dados**: Carrega uma lista de 10 funcionários.
2.  **Remoção de funcionário**: Remove o funcionário chamado "João" da lista.
3.  **Listagem de dados**: Imprime todas as informações dos funcionários.
4.  **Aumento salarial**: Aplica um aumento de 10% no salário de todos os funcionários.
5.  **Agrupamento**: Agrupa os funcionários por função.
6.  **Aniversariantes**: Exibe os funcionários que fazem aniversário nos meses de outubro e dezembro.
7.  **Funcionário mais velho**: Identifica e imprime o nome e a idade do funcionário mais velho.
8.  **Ordenação alfabética**: Imprime a lista de funcionários em ordem alfabética.
9.  **Total de salários**: Calcula e exibe o total de todos os salários.
10. **Salários por salário mínimo**: Imprime o salário de cada funcionário em múltiplos do salário mínimo (considerando R$ 1.212,00).

---

### Estrutura do Projeto

O projeto é organizado em pacotes para manter a clareza e a modularidade:

* `com.victorgabdev.iniflex`: Contém a classe principal `App` para execução.
* `com.victorgabdev.iniflex.entities`: Inclui as classes de modelo, como `Pessoa`, `Funcionario` e o enum `FuncaoFuncionario`.
* `com.victorgabdev.iniflex.exceptions`: Contém a exceção customizada `FuncionariosJaCarregadosException`.
* `com.victorgabdev.iniflex.service`: Contém a classe `FuncionarioService`, que concentra toda a lógica de negócio e manipulação dos dados.

---

### Como Executar

Para executar o projeto, siga estes passos:

1.  Clone este repositório para sua máquina local.
2.  Abra o projeto em sua IDE Java preferida (como IntelliJ IDEA, Eclipse ou VS Code).
3.  Certifique-se de que a versão 8 ou superior do Java Development Kit (JDK) está instalada.
4.  Compile e execute a classe `com.victorgabdev.iniflex.App`.

A saída do programa será exibida diretamente no console, mostrando cada passo e o resultado correspondente.

---

### Autor

* **Victor Aquino**