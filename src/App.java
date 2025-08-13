import com.victorgabdev.iniflex.service.FuncionarioService;

public class App {
    public static void main(String[] args) {

        FuncionarioService service = new FuncionarioService();

        service.inserirFuncionarios();
        service.imprimirTodosFuncionarios();
        System.out.println("----------------------");


        //service.aplicarAumentoDeSalario(10);
        service.imprimirTodosFuncionarios();


        /*
        System.out.println("----------------------");
        service.agruparFuncionariosPorFuncao();
        service.imprimirFuncionariosAgrupados();
        */

        service.imprimirAniversariantesMes10E12();

        System.out.println("----------------------");
        service.imprimirFuncionarioMaisVelho();

        System.out.println("----------------------");
        service.imprimirFuncionariosOrdemAlfabetica();

        System.out.println("----------------------");
        service.imprimirTotalSalarios();

        System.out.println("----------------------");
        service.imprimirSalariosEmMinimos();


    }
}