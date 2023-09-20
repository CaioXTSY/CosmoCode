import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class test {

    private static List<Galaxia> galaxias = new ArrayList<>();
    private static List<SistemaSolar> sistemasSolares = new ArrayList<>();
    private static List<Estrela> estrelas = new ArrayList<>();
    private static List<Planeta> planetas = new ArrayList<>();
    private static List<Lua> luas = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.println("\n-----SPACE EXPO-----");
                    System.out.println("\n---MENU---:");
                    System.out.println("1 - Adicionar Astros");
                    System.out.println("2 - Remover Astros");
                    System.out.println("3 - Método 1");
                    System.out.println("4 - Método 2");
                    System.out.println("5 - Método 3");
                    System.out.println("6 - Listar");
                    System.out.println("7 - Sair");
                    System.out.print("Digite sua opção: ");
                    int op = scanner.nextInt();
                    scanner.nextLine();

                    switch (op) {

                        case 1:
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
                                        Galaxia galaxia = galaxias.get(galIndex - 1);
            
                                        System.out.print("\nDigite o nome do Sistema Solar: ");
                                        String nome = scanner.nextLine();
                                        SistemaSolar solSis = new SistemaSolar(nome, galaxia);
                                        galaxia.adicionarSistemaSolar(solSis);
                                        sistemasSolares.add(solSis);
                                        System.out.println("\nSistema Solar criado: " + nome);
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
                                        SistemaSolar sistemaSolar = sistemasSolares.get(sisSolIndex - 1);
            
                                        System.out.print("\nDigite o nome da Estrela: ");
                                        String nome = scanner.nextLine();
                                        System.out.print("Digite a massa da Estrela: ");
                                        String estMas = scanner.nextLine();
                                        Double massa = Double.parseDouble(estMas);
                                        System.out.print("Digite o raio da Estrela: ");
                                        String estRar = scanner.nextLine();
                                        Double raio = Double.parseDouble(estRar);
                                        System.out.print("Digite a idade da Estrela: ");
                                        String estId = scanner.nextLine();
                                        int idade = Integer.parseInt(estId);
                                        System.out.print("Digite o tipo da Estrela: ");
                                        String tipoDeEstrela = scanner.nextLine();
                                        System.out.print("Digite a temperatura da Estrela: ");
                                        String estTem = scanner.nextLine();
                                        Double temperatura = Double.parseDouble(estTem);
                                        Estrela est = new Estrela(nome, massa, raio, idade, tipoDeEstrela, temperatura, sistemaSolar);
                                        sistemaSolar.adicionarEstrela(est);
                                        estrelas.add(est);
                                        System.out.println("\nEstrela criada: " + nome);
                                    } else {
                                        System.out.println("\nÍndice Inválido.");
                                    }
                                }
                                break;
            
                                case 4:
                                if (estrelas.isEmpty()){
                                    System.out.println("\nNão existem Estrelas neste Espaço!");
                                } else {
                                    System.out.println("\nSelecione em qual Estrela você deseja salvar o Planeta:\n");
                                    int index = 1;
                                    for (Estrela estrela : estrelas) {
                                        System.out.println(index + ". " + estrela.getNome());
                                        index++;
                                    }
                                    System.out.print("\nDigite o índice da Estrela desejada: ");
            
                                    int estIndex = scanner.nextInt();
                                    scanner.nextLine();
            
                                    if (estIndex >= 1 && estIndex <= estrelas.size()) {
                                        Estrela estrela = estrelas.get(estIndex - 1);
            
                                        System.out.print("\nDigite o nome do Planeta: ");
                                        String nome = scanner.nextLine();
                                        System.out.print("Digite a massa do Planeta: ");
                                        String plaMas = scanner.nextLine();
                                        Double massa = Double.parseDouble(plaMas);
                                        System.out.print("Digite a distância ao 'Sol' do Planeta: ");
                                        String plaDis = scanner.nextLine();
                                        Double distanciaAoSol = Double.parseDouble(plaDis);
                                        System.out.print("Digite o número de Luas do Planeta: ");
                                        String plaLua = scanner.nextLine();
                                        int numeroDeLuas = Integer.parseInt(plaLua);
                                        System.out.print("Digite o raio do Planeta: ");
                                        String plaRar = scanner.nextLine();
                                        Double raio = Double.parseDouble(plaRar);
                                        System.out.print("Digite a idade do Planeta: ");
                                        String plaId = scanner.nextLine();
                                        int idade = Integer.parseInt(plaId);
                                        Planeta plan = new Planeta(nome, massa, distanciaAoSol, numeroDeLuas, raio, idade, estrela);
                                        estrela.adicionarPlaneta(plan);
                                        planetas.add(plan);
                                        System.out.println("\nPlaneta criado: " + nome);
                                    } else {
                                        System.out.println("\nÍndice Inválido.");
                                    }
                                }
                                break;
            
                                case 5:
                                if (planetas.isEmpty()){
                                    System.out.println("\nNão existem Planetas neste Espaço!");
                                } else {
                                    System.out.println("\nSelecione em qual Planeta você deseja salvar a Lua:\n");
                                    int index = 1;
                                    for (Planeta planeta : planetas) {
                                        System.out.println(index + ". " + planeta.getNome());
                                        index++;
                                    }
                                }
                            }

                        case 2:
                            System.out.println("Escolha o tipo de astro para remover:");
                            System.out.println("1 - Galáxia");
                            System.out.println("2 - Sistema Solar");
                            System.out.println("3 - Estrela");
                            System.out.println("4 - Planeta");
                            System.out.println("5 - Lua");
                            System.out.print("Digite sua opção: ");
                            int removeOp = scanner.nextInt();
                            scanner.nextLine();
                            if (removeOp == 1) {
                                if (galaxias.isEmpty()) {
                                    System.out.println("Não há galáxias para remover.");
                                } else {
                                    System.out.println("Escolha a galáxia para remover:");
                                    int index = 1;
                                    for (Galaxia galaxia : galaxias) {
                                        System.out.println(index + ". " + galaxia.getNome());
                                        index++;
                                    }
                                    int galIndex = scanner.nextInt();
                                    scanner.nextLine();
                                    Galaxia galaxia = galaxias.get(galIndex - 1);
                                    galaxias.remove(galaxia);
                                    System.out.println("Galáxia removida.");
                                }
                            } else if (removeOp == 2) {
                                if (sistemasSolares.isEmpty()) {
                                    System.out.println("Não há sistemas solares para remover.");
                                } else {
                                    System.out.println("Escolha o sistema solar para remover:");
                                    int index = 1;
                                    for (SistemaSolar sistemaSolar : sistemasSolares) {
                                        System.out.println(index + ". " + sistemaSolar.getNome());
                                        index++;
                                    }
                                    int sisIndex = scanner.nextInt();
                                    scanner.nextLine();
                                    SistemaSolar sistemaSolar = sistemasSolares.get(sisIndex - 1);
                                    sistemasSolares.remove(sistemaSolar);
                                    sistemaSolar.getGalaxia().removerSistemaSolar(sistemaSolar);
                                    System.out.println("Sistema Solar removido.");
                                }
                            } else if (removeOp == 3) {
                                if (estrelas.isEmpty()) {
                                    System.out.println("Não há estrelas para remover.");
                                } else {
                                    System.out.println("Escolha a estrela para remover:");
                                    int index = 1;
                                    for (Estrela estrela : estrelas) {
                                        System.out.println(index + ". " + estrela.getNome());
                                        index++;
                                    }
                                    int estIndex = scanner.nextInt();
                                    scanner.nextLine();
                                    Estrela estrela = estrelas.get(estIndex - 1);
                                    estrelas.remove(estrela);
                                    estrela.getSistemaSolar().removerEstrela(estrela);
                                    System.out.println("Estrela removida.");
                                }
                            } else if (removeOp == 4) {
                                if (planetas.isEmpty()) {
                                    System.out.println("Não há planetas para remover.");
                                } else {
                                    System.out.println("Escolha o planeta para remover:");
                                    int index = 1;
                                    for (Planeta planeta : planetas) {
                                        System.out.println(index + ". " + planeta.getNome());
                                        index++;
                                    }
                                    int plaIndex = scanner.nextInt();
                                    scanner.nextLine();
                                    Planeta planeta = planetas.get(plaIndex - 1);
                                    planetas.remove(planeta);
                                    // planeta.getEstrela().removerPlaneta(planeta); ta bugado(?)
                                    System.out.println("Planeta removido.");
                                }
                            } else if (removeOp == 5) {
                                if (luas.isEmpty()) {
                                    System.out.println("Não há luas para remover.");
                                } else {
                                    System.out.println("Escolha a lua para remover:");
                                    int index = 1;
                                    for (Lua lua : luas) {
                                        System.out.println(index + ". " + lua.getNome());
                                        index++;
                                    }
                                    int luaIndex = scanner.nextInt();
                                    scanner.nextLine();
                                    Lua lua = luas.get(luaIndex - 1);
                                    luas.remove(lua);
                                    lua.getPlaneta().removerLua(lua);
                                    System.out.println("Lua removida.");
                                }
                            }
                            break;
                        case 3:
                            // fazer depois
                            break;
                        case 4:
                            // fazer depois
                            break;
                        case 5:
                            // fazer depois
                            break;
                        case 6:
                            listarAstros(scanner);
                            break;
                        case 7:
                            System.out.println("\nEncerrando execução...");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("\nOpção não disponível. Escolha um dos números indicados no menu!");
                            break;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("\nEntrada inválida. Certifique-se de digitar um número.");
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("\nOcorreu um erro inesperado: " + e.getMessage());
                }
            }
        }
    }

    private static void listarAstros(Scanner scanner) {
        if (galaxias.isEmpty()) {
            System.out.println("\nEspaço Vazio..., Literalmente.");
        } else {
            System.out.println("\n----- SPACE DATA -----");
            System.out.println("\nEscolha o que deve ser apresentado:");
            System.out.println("1. Ver Gálaxias");
            System.out.println("2. Ver Sistemas Solares");
            System.out.println("3. Ver Estrelas");
            System.out.println("4. Ver Planetas");
            System.out.println("5. Ver Luas");
            System.out.println("6. Sair");
            System.out.print("Digite sua opção: ");
            int opc = scanner.nextInt();
            scanner.nextLine();
            switch (opc) {
                case 1:
                    for (Galaxia galaxia : galaxias) {
                        System.out.println(galaxia.descricao());
                    }
                    break;
                case 2:
                    for (SistemaSolar sistemaSolar : sistemasSolares) {
                        System.out.println(sistemaSolar.descricao());
                    }
                    break;
                case 3:
                    for (Estrela estrela : estrelas) {
                        System.out.println(estrela.descricao());
                    }
                    break;
                case 4:
                    for (Planeta planeta : planetas) {
                        System.out.println(planeta.descricao());
                    }
                    break;
                case 5:
                    for (Lua lua : luas) {
                        System.out.println(lua.descricao());
                    }
                    break;
                case 6:
                    System.out.println("\nVoltando para o menu...");
                    break;
                default:
                    System.out.println("\nOpção não disponível. Escolha um dos números indicados no menu!");
                    break;
            }
        }
    }
}





/* A fazer
Menu (encaminhado)
Tratamento de erros(no menu talvez?) (concluido?)
Revisao das formulas(?)
Refatorar o codigo(gambiarra)
Ver um jeito de melhorar as entradas
Resolver bug das fontes(utf8) (passar pra inglês?)
Melhorar o metodo de exibição(função descrição) (encaminhado)
Passar o nome das classes para o ingles
*/