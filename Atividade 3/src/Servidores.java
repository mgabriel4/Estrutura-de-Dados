import java.util.Stack;
import java.util.Scanner;

public class Servidores {
    public static int contarDias(int[] cargas) {
        Stack<Integer> pilha = new Stack<>();
        int dias = 0;
        boolean houveDesligamento;

        for (int carga : cargas) {
            pilha.push(carga);
        }

        do {
            houveDesligamento = false;
            Stack<Integer> novaPilha = new Stack<>();
            
            if (!pilha.isEmpty()) {
                novaPilha.push(pilha.get(0)); // get(0) retorna o primeiro elemento da pilha
            }

            for (int i = 1; i < pilha.size(); i++) {
                if (pilha.get(i) <= pilha.get(i - 1)) {
                    novaPilha.push(pilha.get(i));
                } else {
                    houveDesligamento = true; 
                }
            }

            pilha = novaPilha;
            if (houveDesligamento == true) {
                dias++;
            }
        } while (houveDesligamento == true);

        return dias;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite as cargas dos servidores (separadas por espaço):");
        String[] entrada = scanner.nextLine().split(" ");
        int[] cargas = new int[entrada.length];
        for (int i = 0; i < entrada.length; i++) {
            cargas[i] = Integer.parseInt(entrada[i]);
        }
        System.out.println("Número de dias: " + contarDias(cargas));
    }
}