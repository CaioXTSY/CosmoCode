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
        Scanner scanner = new Scanner(System.in);

        while (true){
            try {
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
                        System.out.print("\nDigite o índice do Planeta desejado: ");

                        int planIndex = scanner.nextInt();
                        scanner.nextLine();

                        if (planIndex >= 1 && planIndex <= planetas.size()) {
                            Planeta planeta = planetas.get(planIndex - 1);

                            if (planeta.getLuas().size() >= planeta.getNumeroDeLuas()) {
                                System.out.println("\nNúmero máximo de Luas atingido para este planeta");
                                break;
                            }

                            System.out.print("\nDigite o nome da Lua: ");
                            String nome = scanner.nextLine();
                            System.out.print("Digite a massa da Lua: ");
                            String luaMas = scanner.nextLine();
                            Double massa = Double.parseDouble(luaMas);
                            System.out.print("Digite o raio da Lua: ");
                            String luaRar = scanner.nextLine();
                            Double raio = Double.parseDouble(luaRar);
                            System.out.print("Digite a idade da Lua: ");
                            String luaId = scanner.nextLine();
                            int idade = Integer.parseInt(luaId);
                            Lua lun = new Lua(nome, massa, idade, raio, planeta);
                            planeta.adicionarLua(lun);
                            luas.add(lun);
                            System.out.println("\nLua criada: " + nome);
                        } else {
                            System.out.println("\nÍndice Inválido.");
                        }
                    }
                    break;

                    case 6:
                    if (galaxias.isEmpty()){
                        System.out.println("\nEspaço Vazio..., Literalmente.");
                    } else {
                    System.out.println("\n----- SPACE DATA -----");
                    for (Galaxia galaxia : galaxias) {
                        System.out.println(galaxia.descricao());
                    }
                    for (SistemaSolar sistemaSolar : sistemasSolares) {
                        System.out.println(sistemaSolar.descricao());
                    }
                    for (Estrela estrela : estrelas) {
                        System.out.println(estrela.descricao());
                    }
                    for (Planeta planeta : planetas) {
                        System.out.println(planeta.descricao());
                    }
                    for (Lua lua : luas) {
                        System.out.println(lua.descricao());
                    }
                    }
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




/* A fazer
Menu (encaminhado)
Tratamento de erros(no menu talvez?) (encaminhado)
Revisao das formulas(?)
Refatorar o codigo(gambiarra)
Ver um jeito de melhorar as entradas
Resolver bug das fontes(utf8) (passar pra inglês?)
Melhorar o metodo de exibição(função descrição)
Passar o nome das classes para o ingles
*/