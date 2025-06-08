import java.util.Scanner;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Zona> zonas = new TreeSet<>();
        boolean rodando = true; 

        while (rodando) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Registrar Zona");
            System.out.println("2. Adicionar Sensor");
            System.out.println("3. Imprimir Relatório");
            System.out.println("4. Finalizar");
            System.out.print("Escolha: ");
            int opcao = Integer.parseInt(scanner.nextLine());
        }
}
}