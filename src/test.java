import java.util.List;
import java.util.Scanner;

public class test {
    private static Galaxia galaxiaAtual;
    private static Galaxia galaxia;
    private static SistemaSolar sisSol;
    private static Estrela estar;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        galaxiaAtual = null;
        sisSol = null;
        estar = null;

        while (true){
            System.out.println("\nSPACE EXPO");
            System.out.println("\nMENU:");
            System.out.println("1 - Adicionar uma Galáxia");
            System.out.println("2 - Adicionar um Sistema Solar");
            System.out.println("3 - Adicionar uma Estrela");
            System.out.println("4 - Adiconar um Planeta");
            System.out.println("5 - Adicionar uma Lua");
            System.out.println("6 - Dados da Galáxia");
            System.out.println("7 - Sair");
            System.out.print("Digite sua opção: ");
            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                if (galaxiaAtual == null) {
                    System.out.print("Digite o nome da Galáxia: ");
                    String nomeGalaxia = scanner.nextLine();
                    Galaxia galaxiaAtual = new Galaxia(nomeGalaxia);
                    Galaxia galaxia = galaxiaAtual; 
                    System.out.println("Galáxia " + nomeGalaxia + " adicionada!" );
                } else {
                    System.out.println("Esta Galáxia já existe escolha outra opção.");
                }
                break;
                case 2:
                    if (galaxia != null) {
                    System.out.println("Digite o nome do Sistema Solar: ");
                    String nomeSisSol = scanner.nextLine();
                    SistemaSolar sisSol = new SistemaSolar(nomeSisSol, galaxiaAtual);
                    galaxiaAtual.adicionarSistemaSolar(sisSol);
                    System.out.println("Sistema Solar " + nomeSisSol + " adicionado");
                } else {
                    System.out.println("Para criar um Sistema Solar, deve-se criar uma Galáxia primeiro!");
                }
                break;
                case 3:
                if (galaxiaAtual != null && sisSol != null) {
                    System.out.print("Digite o nome da Estrela: ");
                    String nomeEstrela = scanner.nextLine();
                    System.out.print("Digite a massa da Estrela: ");
                    String massEstar = scanner.nextLine();
                    double masEstar = Double.parseDouble(massEstar);
                    System.out.print("Digite a idade da Estrela: ");
                    String idEstar = scanner.nextLine();
                    int idaEstar = Integer.parseInt(idEstar);
                    System.out.print("Digite o tipo de Estrela: ");
                    String tpEstar = scanner.nextLine();
                    System.out.print("Digite a temperatura da Estrela: ");
                    String temEstar = scanner.nextLine();
                    double tempEstar = Double.parseDouble(temEstar);
                    Estrela estar = new Estrela(nomeEstrela, masEstar, idaEstar, tpEstar, tempEstar, sisSol);
                    galaxiaAtual.getSistemasSolares().get(0).adicionarEstrela(estar);
                    System.out.println("Estrela " + nomeEstrela + " adicionada!");
                } else {
                    System.out.println("Para criar uma Estrela, deve-se criar um Sistema Solar primeiro!");
                }
                break;
                case 6:
                System.out.println("--- Dados da Galáxia ---");
                System.out.println("Nome: " + galaxiaAtual);
                System.out.print("Sistemas Solares: ");
                List<SistemaSolar> sList = galaxiaAtual.getSistemasSolares();
                for (SistemaSolar i : sList){
                    System.out.print(i + " ");
                }
                System.out.println("\n" + estar.descricao());
                break;
                case 7:
                System.out.println("Encerrando execução...");
                System.exit(0);
                break;
            }
        }
    }
}




/* A fazer
Outras Classes(Sistema Solar, Galaxia)
Menu
Tratamento de erros(no menu talvez?)
Revisao das formulas(?)
Refatorar o codigo(gambiarra)
Outros metodos ainda nao pensados
Ver um jeito de melhorar as entradas
Resolver bug das fontes(utf8)
Melhorar o metodo de exibição(função descrição)
Passar o nome das classes para o ingles
*/