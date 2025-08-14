import com.victorgabdev.iniflex.exceptions.FuncionariosJaCarregadosException;
import com.victorgabdev.iniflex.service.FuncionarioService;

import java.util.NoSuchElementException;

/**
 * Classe principal que representa a interface de usuário do sistema de funcionários.
 * <p>
 * Responsável por orquestrar as operações disponíveis no {@link FuncionarioService},
 * exibindo mensagens claras e tratando possíveis erros durante a execução.
 * </p>
 *
 * <p>O fluxo padrão inclui:</p>
 * <ol>
 *   <li>Carregar funcionários</li>
 *   <li>Remover um funcionário específico ("João")</li>
 *   <li>Listar todos os funcionários</li>
 *   <li>Aplicar aumento salarial</li>
 *   <li>Agrupar por função e exibir</li>
 *   <li>Mostrar aniversariantes de outubro/dezembro</li>
 *   <li>Exibir o funcionário mais velho</li>
 *   <li>Listar em ordem alfabética</li>
 *   <li>Calcular o total de salários</li>
 *   <li>Converter salários para salários mínimos</li>
 * </ol>
 *
 * <p>Tratamento de erros:</p>
 * <ul>
 *   <li>{@link FuncionariosJaCarregadosException} - Se os funcionários já foram carregados</li>
 *   <li>{@link NoSuchElementException} - Se a lista de funcionários estiver vazia</li>
 *   <li>Erros genéricos são capturados e exibidos de forma amigável</li>
 * </ul>
 *
 * @author Victor Aquino
 * @version 1.0
 * @see FuncionarioService
 */
public class App {

    private static final FuncionarioService service = new FuncionarioService();

    public static void main(String[] args) {

        try {
            executarOperacoes();
        } catch (FuncionariosJaCarregadosException | NoSuchElementException e) {
            System.err.println("ERRO: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("ERRO inesperado: " + e.getMessage());
        } finally {
            System.out.println("-------------------------");
            System.out.println("Processo concluído");
        }

    }

    private static void executarOperacoes() {
        carregarFuncionarios();
        removerFuncionarioJoao();
        listarTodosFuncionarios();
        aplicarAumentoSalarial(10);
        agruparPorFuncao();
        listarAgrupadosPorFuncao();
        listarAniversariantesOutubroEDezembro();
        exibirFuncionarioMaisVelho();
        listarOrdemAlfabetica();
        exibirTotalSalarios();
        converterSalariosParaMinimos();
    }

    private static void carregarFuncionarios() {
        System.out.println("1) Carregando funcionários...");
        service.inserirFuncionarios();
        System.out.println("✔ Funcionários carregados com sucesso");
        printSeparador();
    }

    private static void removerFuncionarioJoao() {
        System.out.println("2) Removendo funcionário João...");
        service.removerFuncionario("João");
        System.out.println("✔ João removido com sucesso");
        printSeparador();
    }

    private static void listarTodosFuncionarios() {
        System.out.println("3) Listando todos os funcionários:");
        service.imprimirTodosFuncionarios();
        System.out.println("✔ Listagem concluída");
        printSeparador();
    }

    private static void aplicarAumentoSalarial(double percentual) {
        System.out.printf("4) Aplicando aumento de %.0f%% nos salários...\n", percentual);
        service.aplicarAumentoPercentual(percentual);
        System.out.println("✔ Aumento aplicado com sucesso");
        printSeparador();
    }

    private static void agruparPorFuncao() {
        System.out.println("5) Agrupando funcionários por função...");
        service.agruparFuncionariosPorFuncao();
        System.out.println("✔ Agrupamento concluído");
        printSeparador();
    }

    private static void listarAgrupadosPorFuncao() {
        System.out.println("6) Listando funcionários agrupados por função:");
        service.imprimirFuncionariosAgrupados();
        System.out.println("✔ Listagem agrupada concluída");
        printSeparador();
    }

    private static void listarAniversariantesOutubroEDezembro() {
        System.out.println("7) Funcionários que fazem aniversário em Outubro e Dezembro:");
        service.imprimirAniversariantesMes10E12();
        System.out.println("✔ Listagem de aniversariantes concluída");
        printSeparador();
    }

    private static void exibirFuncionarioMaisVelho() {
        System.out.println("8) Funcionário mais velho da empresa:");
        service.imprimirFuncionarioMaisVelho();
        System.out.println("✔ Informação exibida com sucesso");
        printSeparador();
    }

    private static void listarOrdemAlfabetica() {
        System.out.println("9) Listando funcionários em ordem alfabética:");
        service.imprimirFuncionariosOrdemAlfabetica();
        System.out.println("✔ Listagem ordenada concluída");
        printSeparador();
    }

    private static void exibirTotalSalarios() {
        System.out.println("10) Total dos salários dos funcionários:");
        service.imprimirTotalSalarios();
        System.out.println("✔ Total calculado e exibido");
        printSeparador();
    }

    private static void converterSalariosParaMinimos() {
        System.out.println("11) Salários em termos de salários mínimos:");
        service.imprimirSalariosEmMinimos();
        System.out.println("✔ Conversão realizada com sucesso");
    }


    private static void printSeparador() {
        System.out.println("-------------------------");
    }


}