import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Cosmos {

    private static List < Galaxia > galaxias = new ArrayList < > ();
    private static List < SistemaSolar > sistemasSolares = new ArrayList < > ();
    private static List < Estrela > estrelas = new ArrayList < > ();
    private static List < Planeta > planetas = new ArrayList < > ();
    private static List < Lua > luas = new ArrayList < > ();
    public static void main(String[] args) throws Exception {
        while (true) {
            try {
                System.out.println("\n-----SPACE EXPO-----");
                System.out.println("\n---MENU---:");
                System.out.println("1 - Add Celestial Bodies");
                System.out.println("2 - Remove Celestial Bodies");
                System.out.println("3 - Calculate Gravitacional Strength");
                System.out.println("4 - View Celestial Bodies");
                System.out.println("5 - Exit");
                System.out.println("Note: When asked about some inputs, it's recommended you use the scientific notation (e notation) due to the size of the actual numbers.");
                System.out.print("Enter your option: ");
                Scanner scanner = new Scanner(System.in);
                int op = scanner.nextInt();
                scanner.nextLine();

                switch (op) {

                    case 1:
                        System.out.println("\n-----ADD CELESTIAL BODIES-----");
                        System.out.println("\nSelect the type of Celestial Body to create:");
                        System.out.println("1 - Add Galaxy");
                        System.out.println("2 - Add Solar System");
                        System.out.println("3 - Add Star");
                        System.out.println("4 - Add Planet");
                        System.out.println("5 - Add Moon");
                        System.out.print("Enter your option: ");
                        int subOp = scanner.nextInt();
                        scanner.nextLine();

                        switch (subOp) {
                            case 1:
                                System.out.print("\nEnter the name of the Galaxy: ");
                                String nome = scanner.nextLine();
                                Galaxia gal = new Galaxia(nome);
                                galaxias.add(gal);
                                System.out.println("\nGalaxy created: " + nome);
                                break;

                            case 2:
                                if (galaxias.isEmpty()) {
                                    System.out.println("\nThere are no Galaxies in this Space!");
                                } else {
                                    System.out.println("\nSelect in which Galaxy you want to save the Solar System:\n");
                                    int index = 1;
                                    for (Galaxia galaxia: galaxias) {
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
                                        sistemasSolares.add(solSis);
                                        System.out.println("\nSolar System created: " + name);
                                    } else {
                                        System.out.println("\nInvalid Index.");
                                    }
                                }
                                break;

                            case 3:
                                if (sistemasSolares.isEmpty()) {
                                    System.out.println("\nThere are no Solar Systems in this Space!");
                                } else {
                                    System.out.println("\nSelect in which Solar System you want to save the Star:\n");
                                    int index = 1;
                                    for (SistemaSolar sistemaSolar: sistemasSolares) {
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
                                        System.out.print("Enter the mass of the Star (Ex: 5.972e24)): ");
                                        String estMas = scanner.nextLine();
                                        Double massa = Double.parseDouble(estMas);
                                        System.out.print("Enter the radius of the Star (Ex: 6.371e6): ");
                                        String estRar = scanner.nextLine();
                                        Double raio = Double.parseDouble(estRar);
                                        System.out.print("Enter the age of the Star (Ex: 4.603e9): ");
                                        String estId = scanner.nextLine();
                                        Double idade = Double.parseDouble(estId);
                                        System.out.print("Enter the type of the Star: ");
                                        String tipoDeEstrela = scanner.nextLine();
                                        System.out.print("Enter the temperature of the Star (Ex: 5.778e3): ");
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
                                if (estrelas.isEmpty()) {
                                    System.out.println("\nThere are no Stars in this Space!");
                                } else {
                                    System.out.println("\nSelect in which Star you want to save the Planet:\n");
                                    int index = 1;
                                    for (Estrela estrela: estrelas) {
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
                                        System.out.print("Enter the mass of the Planet (Ex: 5.778e3): ");
                                        String plaMas = scanner.nextLine();
                                        Double massa = Double.parseDouble(plaMas);
                                        System.out.print("Enter the distance to the 'Sun' of the Planet (Ex: 1.496e11): ");
                                        String plaDis = scanner.nextLine();
                                        Double distanciaAoSol = Double.parseDouble(plaDis);
                                        System.out.print("Enter the number of Moons for the Planet: ");
                                        String plaLua = scanner.nextLine();
                                        int numeroDeLuas = Integer.parseInt(plaLua);
                                        System.out.print("Enter the radius of the Planet (Ex: 5.778e3): ");
                                        String plaRar = scanner.nextLine();
                                        Double raio = Double.parseDouble(plaRar);
                                        System.out.print("Enter the age of the Planet (Ex: 5.778e3): ");
                                        String plaId = scanner.nextLine();
                                        Double idade = Double.parseDouble(plaId);
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
                                if (planetas.isEmpty()) {
                                    System.out.println("\nThere are no Planets in this Space!");
                                } else {
                                    System.out.println("\nSelect in which Planet you want to save the Moon:\n");
                                    int index = 1;
                                    for (Planeta planeta: planetas) {
                                        System.out.println(index + ". " + planeta.getNome());
                                        index++;
                                    }
                                    System.out.print("\nEnter the index of the desired Planet: ");

                                    int planIndex = scanner.nextInt();
                                    scanner.nextLine();

                                    if (planIndex >= 1 && planIndex <= planetas.size()) {
                                        Planeta planeta = planetas.get(planIndex - 1);

                                        if (planeta.getLuas().size() >= planeta.getNumeroDeLuas()) {
                                            System.out.println("\nMaximum number of Moons reached!");
                                            break;
                                        }

                                        System.out.print("\nEnter the name of the Moon: ");
                                        String name = scanner.nextLine();
                                        System.out.print("Enter the mass of the Moon (Ex: 5.778e3): ");
                                        double massa = scanner.nextDouble();
                                        System.out.print("Enter the age of the Moon (Ex: 5.778e3): ");
                                        Double idade = scanner.nextDouble();
                                        System.out.print("Enter the radius of the Moon (Ex: 5.778e3): ");
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
                    System.out.println("\n-----REMOVE CELESTIAL BODIES-----");
                    System.out.println("\nSelect the type of Celestial Body to remove:");
                    System.out.println("1. Galaxy");
                    System.out.println("2. Solar System");
                    System.out.println("3. Star");
                    System.out.println("4. Planet");
                    System.out.println("5. Moon");
                    System.out.println("6. Exit");
                    System.out.print("Enter your choice: ");
                    
                    int removalChoice = scanner.nextInt();
                    scanner.nextLine();
                    
                    switch (removalChoice) {
                        case 1:
                            if (galaxias.isEmpty()) {
                                System.out.println("\nThere are no Galaxies in this Space!");
                            } else {
                                System.out.println("\nSelect which Galaxy you want to remove:\n");
                                int index = 1;
                                for (Galaxia galaxia : galaxias) {
                                    System.out.println(index + ". " + galaxia.getNome());
                                    index++;
                                }
                                System.out.print("\nEnter the index of the Galaxy to remove: ");
                                int galIndex = scanner.nextInt();
                                scanner.nextLine();
                
                                if (galIndex >= 1 && galIndex <= galaxias.size()) {
                                    Galaxia toRemove = galaxias.get(galIndex - 1);

                                    for (SistemaSolar sistemaSolar : toRemove.getSistemasSolares()) {
                                        for (Estrela estrela : sistemaSolar.getEstrelas()) {
                                            for (Planeta planeta : estrela.getPlanetas()) {
                                                for (CorpoCeleste corpo : planeta.getLuas()) {
                                                    Lua lua = (Lua) corpo;
                                                    luas.remove(lua);
                                                }
                                                planetas.remove(planeta);
                                            }
                                            estrelas.remove(estrela);
                                        }
                                        sistemasSolares.remove(sistemaSolar);
                                    }
                                    galaxias.remove(toRemove);
                                    System.out.println("\nGalaxy removed successfully.");
                                } else {
                                    System.out.println("\nInvalid Index.");
                                }
                            }
                            break;
                        case 2:
                            if (sistemasSolares.isEmpty()) {
                                System.out.println("\nThere are no Solar Systems to remove!");
                            } else {
                                System.out.println("\nSelect the Solar System to remove:\n");
                                int index = 1;
                                for (SistemaSolar sistemaSolar : sistemasSolares) {
                                    System.out.println(index + ". " + sistemaSolar.getNome());
                                    index++;
                                }
                                System.out.print("\nEnter the index of the Solar System to remove: ");
                                int ssIndex = scanner.nextInt();
                                scanner.nextLine();
                                
                                if (ssIndex >= 1 && ssIndex <= sistemasSolares.size()) {
                                    SistemaSolar toRemove = sistemasSolares.get(ssIndex - 1);
                                    
                                    for (Estrela estrela : toRemove.getEstrelas()) {
                                        for (Planeta planeta : estrela.getPlanetas()) {
                                            for (CorpoCeleste corpo : planeta.getLuas()) {
                                                Lua lua = (Lua) corpo;
                                                luas.remove(lua);
                                            }
                                            planetas.remove(planeta);
                                        }
                                        estrelas.remove(estrela);
                                    }
                                    
                                    sistemasSolares.remove(toRemove);
                                    System.out.println("\nSolar System removed successfully!");
                                } else {
                                    System.out.println("\nInvalid index. Returning to removal menu.");
                                }
                            }
                            break;
                    
                        case 3:
                            if (estrelas.isEmpty()) {
                                System.out.println("\nThere are no Stars to remove!");
                            } else {
                                System.out.println("\nSelect the Star to remove:\n");
                                int index = 1;
                                for (Estrela estrela : estrelas) {
                                    System.out.println(index + ". " + estrela.getNome());
                                    index++;
                                }
                                System.out.print("\nEnter the index of the Star to remove: ");
                                int starIndex = scanner.nextInt();
                                scanner.nextLine();
                                
                                if (starIndex >= 1 && starIndex <= estrelas.size()) {
                                    Estrela toRemove = estrelas.get(starIndex - 1);
                                    
                                    for (Planeta planeta : toRemove.getPlanetas()) {
                                        for (CorpoCeleste corpo : planeta.getLuas()) {
                                            Lua lua = (Lua) corpo;
                                            luas.remove(lua);
                                        }
                                        planetas.remove(planeta);
                                    }
                                    
                                    estrelas.remove(toRemove);
                                    System.out.println("\nStar removed successfully!");
                                } else {
                                    System.out.println("\nInvalid index. Returning to removal menu.");
                                }
                            }
                            break;
                    
                        case 4:
                            if (planetas.isEmpty()) {
                                System.out.println("\nThere are no Planets to remove!");
                            } else {
                                System.out.println("\nSelect the Planet to remove:\n");
                                int index = 1;
                                for (Planeta planeta : planetas) {
                                    System.out.println(index + ". " + planeta.getNome());
                                    index++;
                                }
                                System.out.print("\nEnter the index of the Planet to remove: ");
                                int planetIndex = scanner.nextInt();
                                scanner.nextLine();
                                
                                if (planetIndex >= 1 && planetIndex <= planetas.size()) {
                                    Planeta toRemove = planetas.get(planetIndex - 1);
                                    
                                    for (CorpoCeleste corpo : toRemove.getLuas()) {
                                        Lua lua = (Lua) corpo;
                                        luas.remove(lua);
                                    }
                                    
                                    planetas.remove(toRemove);
                                    System.out.println("\nPlanet removed successfully!");
                                } else {
                                    System.out.println("\nInvalid index. Returning to removal menu.");
                                }
                            }
                             
                            break;
                    
                        case 5:
                            if (luas.isEmpty()) {
                                System.out.println("\nThere are no Moons to remove!");
                            } else {
                                System.out.println("\nSelect the Moon to remove:\n");
                                int index = 1;
                                for (Lua lua : luas) {
                                    System.out.println(index + ". " + lua.getNome());
                                    index++;
                                }
                                System.out.print("\nEnter the index of the Moon to remove: ");
                                int moonIndex = scanner.nextInt();
                                scanner.nextLine();
                                
                                if (moonIndex >= 1 && moonIndex <= luas.size()) {
                                    Lua toRemove = luas.get(moonIndex - 1);
                                    luas.remove(toRemove);
                                    System.out.println("\nMoon removed successfully!");
                                } else {
                                    System.out.println("\nInvalid index. Returning to removal menu.");
                                }
                            }
                            break;
                        
                        case 6:
                            System.out.println("\nReturning to the menu...");
                            break;
                    
                        default:
                            System.out.println("\nInvalid choice. Returning to main menu.");
                            break;
                    }
                    break;

                    case 3:
                        System.out.println("\n-----GRAVITATIONAL FORCE-----");
                        if (sistemasSolares.isEmpty()) {
                            System.out.println("\nThere are no Solar Systems in this Space!");
                        } else {
                            System.out.println("\nSelect a Solar System:\n");
                            int index = 1;
                            for (SistemaSolar sistemaSolar: sistemasSolares) {
                                System.out.println(index + ". " + sistemaSolar.getNome());
                                index++;
                            }
                        
                            System.out.print("\nEnter the index of the Solar System:");
                            int sisIndex = scanner.nextInt();
                            scanner.nextLine();
                        
                            if (sisIndex >= 1 && sisIndex <= sistemasSolares.size()) {
                                SistemaSolar selectedSolarSystem = sistemasSolares.get(sisIndex - 1);
                                List<Estrela> availableStars = selectedSolarSystem.getEstrelas();
                        
                                if (availableStars.isEmpty()) {
                                    System.out.println("\nNo stars available in the selected Solar System.");
                                } else {
                                    System.out.println("\nSelect a Star from the Solar System:\n");
                                    index = 1;
                                    for (Estrela estrela: availableStars) {
                                        System.out.println(index + ". Star: " + estrela.getNome());
                                        index++;
                                    }
                        
                                    System.out.print("\nEnter the index of the Star: ");
                                    int starIndex = scanner.nextInt();
                                    Estrela selectedStar = availableStars.get(starIndex - 1);
                                    List<Planeta> availablePlanets = selectedStar.getPlanetas();
                        
                                    System.out.println("\nSelect two celestial bodies (planet or moon) to calculate the gravitational force between them:\n");
                                    index = 1;
                                    for (Planeta planeta: availablePlanets) {
                                        System.out.println(index + ". Planet: " + planeta.getNome());
                                        index++;
                                    }
                        
                                    List<CorpoCeleste> availableMoons = selectedStar.getPlanetas().get(0).getLuas();
                                    for (CorpoCeleste lua: availableMoons) {
                                        System.out.println(index + ". Moon: " + lua.getNome());
                                        index++;
                                    }
                        
                                    System.out.print("\nEnter the index of the first celestial body: ");
                                    int firstBodyIndex = scanner.nextInt();
                                    System.out.print("\nEnter the index of the second celestial body: ");
                                    int secondBodyIndex = scanner.nextInt();
                                    scanner.nextLine();
                        
                                    CorpoCeleste firstBody = (firstBodyIndex <= availablePlanets.size()) ? availablePlanets.get(firstBodyIndex - 1) : availableMoons.get(firstBodyIndex - availablePlanets.size() - 1);
                                    CorpoCeleste secondBody = (secondBodyIndex <= availablePlanets.size()) ? availablePlanets.get(secondBodyIndex - 1) : availableMoons.get(secondBodyIndex - availablePlanets.size() - 1);
                        
                                    double F = (6.674e-11 * firstBody.getMassa() * secondBody.getMassa()) / (1 * 1);
                                    System.out.println("\nThe gravitational force between " + firstBody.getNome() + " and " + secondBody.getNome() + " is: " + F + " N.");
                                }
                            } else {
                                System.out.println("\nInvalid Solar System index.");
                            }
                        }
                        break;

                    case 4:
                        listarAstros(scanner);
                        break;

                    case 5:
                        System.out.println("\nExiting...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("\nOption not available. Choose one of the numbers indicated in the menu!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a number.");
            } catch (Exception e) {
                System.out.println("\nAn unexpected error ocurred: " + e.getMessage());
            }
        }

    }
    private static void listarAstros(Scanner scanner) {
        if (galaxias.isEmpty()) {
            System.out.println("\nThe Space is Empty!");
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
                    for (Galaxia galaxia: galaxias) {
                        System.out.println(galaxia.descricao());
                    }
                    break;
                case 2:
                    for (SistemaSolar sistemaSolar: sistemasSolares) {
                        System.out.println(sistemaSolar.descricao());
                    }
                    break;
                case 3:
                    for (Estrela estrela: estrelas) {
                        System.out.println(estrela.descricao());
                    }
                    break;
                case 4:
                    for (Planeta planeta: planetas) {
                        System.out.println(planeta.descricao());
                    }
                    break;
                case 5:
                    for (Lua lua: luas) {
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