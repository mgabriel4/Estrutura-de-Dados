import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JogodasCadeiras {

    public static int jogar(int n, int k) {
        Queue<Integer> fila = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            fila.add(i); 
        }

        while (fila.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                fila.add(fila.poll()); // Move o jogador para o fim da fila
            }
            System.out.println("Jogador eliminado: " + fila.poll());
        }

        return fila.peek(); // Retorna o último jogador restante
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de jogadores (n): ");
        int n = scanner.nextInt();
        System.out.print("Digite o número de batidas (k): ");
        int k = scanner.nextInt();

        int resultado = JogodasCadeiras.jogar(n, k);
        System.out.println("O jogador vencedor é o número: " + resultado);
        scanner.close();
    }
}
