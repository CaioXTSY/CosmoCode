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
    public static void main(String[] args) throws Exception {
            while (true) {
                try {
                    System.out.println("\n-----SPACE EXPO-----");
                    System.out.println("\n---MENU---:");
                    System.out.println("1 - Add Celestial Bodyes");
                    System.out.println("2 - Remove Celestial Bodyes");
                    System.out.println("3 - Method 1");
                    System.out.println("4 - Method 2");
                    System.out.println("5 - Method 3");
                    System.out.println("6 - View Celestial Bodyes");
                    System.out.println("7 - Exit");
                    System.out.print("Enter your option: ");
                    Scanner scanner = new Scanner(System.in);
                    int op = scanner.nextInt();
                    scanner.nextLine();

                    switch (op) {

                                case 1:
                                System.out.println("\n-----ADD CELESTIAL BODYES-----");
                                System.out.println("1 - Add Galaxy");
                                System.out.println("2 - Add Solar System");
                                System.out.println("3 - Add Star");
                                System.out.println("4 - Add Planet");
                                System.out.println("5 - Add Moon");
                                System.out.print("Enter your option  ");
                                int subOp = scanner.nextInt();
                                scanner.nextLine();

                                switch (subOp) {
                                    case 1:
                                        System.out.print("\nEnter the name of the Galaxy: ");
                                        String nome = scanner.nextLine();
                                        Galaxia gal = new Galaxia(nome);
                                        galaxias.add(gal);
                                        System.out.println("\nGaláxia criada: " + nome);
                                        break;
                                    
                                    case 2:
                                    if (galaxias.isEmpty()){
                                        System.out.println("\nThere are no Galaxies in this Space!");
                                    } else {
                                        System.out.println("\nSelect in which Galaxy you want to save the Solar System:\n");
                                        int index = 1;
                                        for (Galaxia galaxia : galaxias) {
                                            System.out.println(index + ". " + galaxia.getNome());
                                            index++;
                                        }
                                        System.out.print("\nEnter the index of the desired Galaxy: ");
                
                                        int galIndex = scanner.nextInt();
                                        scanner.nextLine();
                
                                        if (galIndex >= 1 && galIndex <= galaxias.size()) {
                                            Galaxia galaxia = galaxias.get(galIndex - 1);
                
                                            System.out.print("\nEnter the name of the Solar System: ");
                                            String name = scanner.nextLine();
                                            SistemaSolar solSis = new SistemaSolar(name, galaxia);
                                            galaxia.adicionarSistemaSolar(solSis);
                                            sistemasSolares.add(solSis);
                                            System.out.println("\nSolar System created: " + name);
                                        } else {
                                            System.out.println("\nInvalid Index.");
                                        }
                                    }
                                    break;
                
                                    case 3:
                                        if (sistemasSolares.isEmpty()){
                                        System.out.println("\nThere are no Solar Systems in this Space!");
                                    } else {
                                        System.out.println("\nSelect in which Solar System you want to save the Star:\n");
                                        int index = 1;
                                        for (SistemaSolar sistemaSolar : sistemasSolares) {
                                            System.out.println(index + ". " + sistemaSolar.getNome());
                                            index++;
                                        }
                                        System.out.print("\nEnter the index of the desired Solar System: ");
                
                                        int sisSolIndex = scanner.nextInt();
                                        scanner.nextLine();
                
                                        if (sisSolIndex >= 1 && sisSolIndex <= sistemasSolares.size()) {
                                            SistemaSolar sistemaSolar = sistemasSolares.get(sisSolIndex - 1);
                
                                            System.out.print("\nEnter the name of the Star: ");
                                            String name = scanner.nextLine();
                                            System.out.print("Enter the mass of the Star: ");
                                            String estMas = scanner.nextLine();
                                            Double massa = Double.parseDouble(estMas);
                                            System.out.print("Enter the radius of the Star: ");
                                            String estRar = scanner.nextLine();
                                            Double raio = Double.parseDouble(estRar);
                                            System.out.print("Enter the age of the Star: ");
                                            String estId = scanner.nextLine();
                                            int idade = Integer.parseInt(estId);
                                            System.out.print("Enter the type of the Star: ");
                                            String tipoDeEstrela = scanner.nextLine();
                                            System.out.print("Enter the temperature of the Star: ");
                                            String estTem = scanner.nextLine();
                                            Double temperatura = Double.parseDouble(estTem);
                                            Estrela est = new Estrela(name, massa, raio, idade, tipoDeEstrela, temperatura, sistemaSolar);
                                            sistemaSolar.adicionarEstrela(est);
                                            estrelas.add(est);
                                            System.out.println("\nStar created: " + name);
                                        } else {
                                            System.out.println("\nInvalid Index.");
                                        }
                                    }
                                    break;
                
                                    case 4:
                                    if (estrelas.isEmpty()){
                                        System.out.println("\nThere are no Stars in this Space!");
                                    } else {
                                        System.out.println("\nSelect in which Star you want to save the Planet:\n");
                                        int index = 1;
                                        for (Estrela estrela : estrelas) {
                                            System.out.println(index + ". " + estrela.getNome());
                                            index++;
                                        }
                                        System.out.print("\nEnter the index of the desired Star: ");
                
                                        int estIndex = scanner.nextInt();
                                        scanner.nextLine();
                
                                        if (estIndex >= 1 && estIndex <= estrelas.size()) {
                                            Estrela estrela = estrelas.get(estIndex - 1);
                
                                            System.out.print("\nEnter the name of the Planet: ");
                                            String name = scanner.nextLine();
                                            System.out.print("Enter the mass of the Planet: ");
                                            String plaMas = scanner.nextLine();
                                            Double massa = Double.parseDouble(plaMas);
                                            System.out.print("Enter the distance to the 'Sun' of the Planet: ");
                                            String plaDis = scanner.nextLine();
                                            Double distanciaAoSol = Double.parseDouble(plaDis);
                                            System.out.print("Enter the number of Moons for the Planet: ");
                                            String plaLua = scanner.nextLine();
                                            int numeroDeLuas = Integer.parseInt(plaLua);
                                            System.out.print("Enter the radius of the Planet: ");
                                            String plaRar = scanner.nextLine();
                                            Double raio = Double.parseDouble(plaRar);
                                            System.out.print("Enter the age of the Planet: ");
                                            String plaId = scanner.nextLine();
                                            int idade = Integer.parseInt(plaId);
                                            Planeta plan = new Planeta(name, massa, distanciaAoSol, numeroDeLuas, raio, idade, estrela);
                                            estrela.adicionarPlaneta(plan);
                                            planetas.add(plan);
                                            System.out.println("\nPlanet created: " + name);
                                        } else {
                                            System.out.println("\nInvalid Index.");
                                        }
                                    }
                                    break;
                
                                    case 5:
                                    if (planetas.isEmpty()){
                                        System.out.println("\nThere are no Planets in this Space!");
                                    } else {
                                        System.out.println("\nSelect in which Planet you want to save the Moon:\n");
                                        int index = 1;
                                        for (Planeta planeta : planetas) {
                                            System.out.println(index + ". " + planeta.getNome());
                                            index++;
                                        }
                                        System.out.print("\nEnter the index of the desired Planet: ");

                                        int planIndex = scanner.nextInt();
                                        scanner.nextLine();

                                        if (planIndex >= 1 && planIndex <= planetas.size()){
                                            Planeta planeta = planetas.get(planIndex - 1);

                                            if (planeta.getLuas().size() >= planeta.getNumeroDeLuas()){
                                                System.out.println("\nMaximum number of Moons reached!");
                                                break;
                                            }

                                            System.out.print("\nEnter the name of the Moon: ");
                                            String name = scanner.nextLine();
                                            System.out.print("Enter the mass of the Moon: ");
                                            double massa = scanner.nextDouble();
                                            System.out.print("Enter the age of the Moon: ");
                                            int idade = scanner.nextInt();
                                            System.out.print("Enter the radius of the Moon: ");
                                            double raio = scanner.nextDouble();
                                            Lua lun = new Lua(name, massa, idade, raio, planeta);
                                            planeta.adicionarLua(lun);
                                            luas.add(lun);
                                            System.out.println("Moon created: " + name);
                                        } else {
                                            System.out.println("\nInvalid index.");
                                        }
                                    }
                                }
                                    break;

                        case 2:
                            System.out.println("Choose the Celestial Body to remove:");
                            System.out.println("1 - Galaxy");
                            System.out.println("2 - Solar System");
                            System.out.println("3 - Star");
                            System.out.println("4 - Planet");
                            System.out.println("5 - Moon");
                            System.out.print("Enter your option: ");
                            int removeOp = scanner.nextInt();
                            scanner.nextLine();
                            if (removeOp == 1) {
                                if (galaxias.isEmpty()) {
                                    System.out.println("There are no galaxies to remove.");
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
                                    System.out.println("Galaxy removed.");
                                }
                            } else if (removeOp == 2) {
                                if (sistemasSolares.isEmpty()) {
                                    System.out.println("There are no solar systems to remove.");
                                } else {
                                    System.out.println("Choose the solar system to remove:");
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
                                    System.out.println("Solar System removed.");
                                }
                            } else if (removeOp == 3) {
                                if (estrelas.isEmpty()) {
                                    System.out.println("There are no stars to remove.");
                                } else {
                                    System.out.println("choose the star to remove:");
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
                                    System.out.println("Star removed.");
                                }
                            } else if (removeOp == 4) {
                                if (planetas.isEmpty()) {
                                    System.out.println("There are no planets to remove.");
                                } else {
                                    System.out.println("choose the planet to remove:");
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
                                    System.out.println("Planet removed.");
                                }
                            } else if (removeOp == 5) {
                                if (luas.isEmpty()) {
                                    System.out.println("There are no moons to remove.");
                                } else {
                                    System.out.println("choose the moon to remove:");
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
                                    System.out.println("Moon removed.");
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
                            System.out.println("\nExiting...");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("\nOption not available. Choose one of the numbers indicated in the menu!");
                            break;
                        }
                    }
                catch (InputMismatchException e) {
                    System.out.println("\nInvalid input. Please enter a number.");
                }
        }
            
    }
    private static void listarAstros(Scanner scanner) {
        if (galaxias.isEmpty()) {
            System.out.println("\nThere are no Galaxies in this Space!");
        } else {
            System.out.println("\n----- SPACE DATA -----");
            System.out.println("\nChoose the Celestial Body to view:");
            System.out.println("1. View Galaxies");
            System.out.println("2. View Solar Systems");
            System.out.println("3. View Stars");
            System.out.println("4. View Planets");
            System.out.println("5. View Moons");
            System.out.println("6. Exit");
            System.out.print("Enter your option: ");
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
                    System.out.println("\nReturning to the menu...");
                    break;
                default:
                    System.out.println("\nOption not available. Choose one of the numbers indicated in the menu!");
                    break;
            }
        }
    }
}




/* A fazer
Menu (encaminhado)
Tratamento de erros(no menu talvez?) (concluido?)
Ver um jeito de melhorar as entradas
Resolver bug das fontes(utf8) (passar pra inglês?) (feito)
Melhorar o metodo de exibição(função descrição) (encaminhado)
Passar o nome das classes para o ingles
*/