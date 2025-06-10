import java.util.Scanner;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Zona> zonas = new TreeSet<>();

        int opcao;

        do {
            System.out.println("\nSistema de Monitoramento de Qualidade do Ar");
            System.out.println("==== MENU ====");
            System.out.println("1. Registrar Zona");
            System.out.println("2. Adicionar Sensor");
            System.out.println("3. Imprimir Relatório");
            System.out.println("4. Finalizar");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Nome da zona: ");
                    String nome = scanner.nextLine();
                    System.out.print("Tipo (urbana/rural): ");
                    String tipo = scanner.nextLine().toLowerCase();
                    if (tipo.equals("urbana")) {
                        zonas.add(new ZonaUrbana(nome));
                    } else if (tipo.equals("rural")) {
                        zonas.add(new ZonaRural(nome));
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;

                case 2:
                    System.out.print("Nome da zona urbana: ");
                    String nomeZona = scanner.nextLine();
                    Zona zonaEncontrada = null;

                    for (Zona z : zonas) {
                        if (z.getNome().equalsIgnoreCase(nomeZona)) {
                            zonaEncontrada = z;
                            break;
                        }
                    }

                    if (zonaEncontrada == null) {
                        System.out.println("Zona não encontrada.");
                    } else if (zonaEncontrada instanceof ZonaUrbana) {
                        System.out.print("ID do sensor: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Data da coleta: ");
                        String data = scanner.nextLine();
                        System.out.print("Valor AQI: ");
                        double valor = scanner.nextDouble();
                        scanner.nextLine();

                        ((ZonaUrbana) zonaEncontrada).adicionarSensor(new Sensor(id, data, valor));
                    } else {
                        System.out.println("Não é possível adicionar sensor a uma zona rural.");
                    }
                    break;

                case 3:
                    System.out.print("Nome da zona: ");
                    String nomeBusca = scanner.nextLine();
                    Zona zona = null;

                    for (Zona z : zonas) {
                        if (z.getNome().equalsIgnoreCase(nomeBusca)) {
                            zona = z;
                            break;
                        }
                    }

                    if (zona == null) {
                        System.out.println("Zona não encontrada.");
                    } else {
                        String relatorio = zona.relatorio();
                        System.out.println("\n<<< RELATÓRIO DE EMERGÊNCIA AMBIENTAL >>>");
                        System.out.println(relatorio);

                        if (zona instanceof ZonaUrbana) {
                            ZonaUrbana urbana = (ZonaUrbana) zona;
                            if (urbana.calcularMedia() > 300) {
                                System.out.println("-> ALERTA EXTREMO: Média crítica ultrapassada!");
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("Programa sendo finalizado. Até mais!...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 4);

        scanner.close();
    }
}
