import com.victorgabdev.iniflex.exceptions.FuncionariosJaCarregadosException;
import com.victorgabdev.iniflex.service.FuncionarioService;

import java.util.NoSuchElementException;

public class App {
    public static void main(String[] args) {

        FuncionarioService service = new FuncionarioService();

        System.out.println("---TESTE TECNICO---");

        try {
            System.out.println("-Inserindo Funcionários-");
            service.inserirFuncionarios();
            System.out.println("-Funcionários Inseridos");
            System.out.println("-------------------------");

            System.out.println("-Imprimir-");
            service.imprimirTodosFuncionarios();
            System.out.println("-------------------------");

            System.out.println("-Arupar-");
            service.agruparFuncionariosPorFuncao();
            System.out.println("-Funcionários Agrupados");
            System.out.println("-------------------------");

            System.out.println("-Imprimir Agrupados");
            service.imprimirFuncionariosAgrupados();
            System.out.println("-------------------------");
        } catch (FuncionariosJaCarregadosException | NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }


    }
}