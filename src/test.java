import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {

    private static List<Galaxia> galaxias = new ArrayList<>();
    private static List<SistemaSolar> sistemasSolares = new ArrayList<>();
    private static List<Estrela> estrelas = new ArrayList<>();
    private static List<Planeta> planetas;
    private static List<Lua> luas;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
                        System.out.print("\nDigite o nome da Galáxia: ");
                        String nomeGalaxia = scanner.nextLine();
                        Galaxia novGalaxia = new Galaxia(nomeGalaxia);
                        galaxias.add(novGalaxia);
                        System.out.println("\nGaláxia " + nomeGalaxia + " adicionada!" );
                    break;

                    case 2:
                    if (galaxias.isEmpty()){
                        System.out.println("\nNão existem Galáxias neste Espaço!");
                    } else {
                        System.out.println("\nSelecione em qual Galáxia você deseja salvar o Sistema Solar:\n");
                        int index = 1;
                        for (Galaxia galaxia : galaxias) {
                            System.out.println(index + ". " + galaxia.getNome());
                            index++;
                        }
                        System.out.print("\nDigite o índice da Galáxia desejada: ");

                        int galIndex = scanner.nextInt();
                        scanner.nextLine();

                        if (galIndex >= 1 && galIndex <= galaxias.size()) {
                            Galaxia galEsc = galaxias.get(galIndex - 1);

                            System.out.print("\nDigite o nome do Sistema Solar: ");
                            String solSisNome = scanner.nextLine();
                            SistemaSolar solSis = new SistemaSolar(solSisNome, galEsc);
                            galEsc.adicionarSistemaSolar(solSis);
                            sistemasSolares.add(solSis);
                            System.out.println("\nSistema Solar criado: " + solSisNome);
                        } else {
                            System.out.println("\nÍndice Inválido.");
                        }
                    }
                    break;

                    case 3:
                        if (sistemasSolares.isEmpty()){
                        System.out.println("\nNão existem Sistemas Solares neste Espaço!");
                    } else {
                        System.out.println("\nSelecione em qual Sistema Solar você deseja salvar a Estrela:\n");
                        int index = 1;
                        for (SistemaSolar sistemaSolar : sistemasSolares) {
                            System.out.println(index + ". " + sistemaSolar.getNome());
                            index++;
                        }
                        System.out.print("\nDigite o índice do Sistema Solar desejado: ");

                        int sisSolIndex = scanner.nextInt();
                        scanner.nextLine();

                        if (sisSolIndex >= 1 && sisSolIndex <= sistemasSolares.size()) {
                            SistemaSolar sisEsc = sistemasSolares.get(sisSolIndex - 1);

                            System.out.print("\nDigite o nome da Estrela: ");
                            String nome = scanner.nextLine();
                            System.out.print("Digite a massa da Estrela: ");
                            String estMas = scanner.nextLine();
                            Double estMassa = Double.parseDouble(estMas);
                            System.out.print("Digite a idade da Estrela: ");
                            String estId = scanner.nextLine();
                            int idade = Integer.parseInt(estId);
                            System.out.print("Digite o tipo da Estrela: ");
                            String tipoDeEstrela = scanner.nextLine();
                            System.out.print("Digite a temperatura da Estrela: ");
                            String estTem = scanner.nextLine();
                            Double temperatura = Double.parseDouble(estTem);
                            Estrela est = new Estrela(nome, estMassa, idade, tipoDeEstrela, temperatura, sisEsc);
                            sisEsc.adicionarEstrela(est);
                            estrelas.add(est);
                            System.out.println("\nEstrela criada: " + nome);
                        } else {
                            System.out.println("\nÍndice Inválido.");
                        }
                    }
                    break;

                    case 6:
                    System.out.println("----- SPACE DATA -----");
                    for (Galaxia galaxia : galaxias) {
                        System.out.println(galaxia.descricao());
                    }
                    for (SistemaSolar sistemaSolar : sistemasSolares) {
                        System.out.println(sistemaSolar.descricao());
                    }
                    for (Estrela estrela : estrelas) {
                        System.out.println(estrela.descricao());
                    }
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