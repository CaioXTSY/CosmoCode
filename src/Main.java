import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<CorpoCeleste> corposCelestes = new ArrayList<>();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Criar Planeta");
            System.out.println("2. Criar Estrela");
            System.out.println("3. Listar Corpos Celestes");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nome do Planeta: ");
                    String nomePlaneta = scanner.next();
                    System.out.print("Massa do Planeta: ");
                    double massaPlaneta = scanner.nextDouble();
                    System.out.print("Distância ao Sol: ");
                    double distanciaAoSol = scanner.nextDouble();
                    System.out.print("Número de Luas: ");
                    int numeroDeLuas = scanner.nextInt();
                    System.out.print("Raio do Planeta: ");
                    double raioPlaneta = scanner.nextDouble();
                    Planeta novoPlaneta = new Planeta(nomePlaneta, massaPlaneta, distanciaAoSol, numeroDeLuas, raioPlaneta);
                    corposCelestes.add(novoPlaneta);
                    break;

                case 2:
                    System.out.print("Nome da Estrela: ");
                    String nomeEstrela = scanner.next();
                    System.out.print("Massa da Estrela: ");
                    double massaEstrela = scanner.nextDouble();
                    System.out.print("Tipo da Estrela: ");
                    String tipoEstrela = scanner.next();
                    System.out.print("Temperatura da Estrela: ");
                    double temperaturaEstrela = scanner.nextDouble();
                    Estrela novaEstrela = new Estrela(nomeEstrela, massaEstrela, tipoEstrela, temperaturaEstrela);
                    corposCelestes.add(novaEstrela);
                    break;

                case 3:
                    System.out.println("Corpos Celestes:");
                    for (CorpoCeleste corpo : corposCelestes) {
                        System.out.println(corpo.descricao());
                    }
                    break;

                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
