import java.util.ArrayList;
import java.util.Scanner;

// Complexidade do método: O(n^3), onde n é o tamanho do vetor. 
// O(n^2) para percorrer o vetor e O(n) para verificar se a soma de dois elementos anteriores é igual ao elemento atual.

public class SomarAnterior{

    public static boolean contemSomaDeAnteriores(ArrayList<Integer> vetor) {
        for (int i = 2; i < vetor.size(); i++) {
            int elementoAtual = vetor.get(i);

            for (int j = 0; j < i; j++) {
                for (int k = j + 1; k < i; k++) {
                    if (vetor.get(j) + vetor.get(k) == elementoAtual) {
                        return true; 
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> vetor = new ArrayList<>();

        System.out.print("Digite o número de elementos do vetor: ");
        int n = scanner.nextInt();

        System.out.println("Digite os elementos do vetor (um por linha):");
        for (int i = 0; i < n; i++) {
            vetor.add(scanner.nextInt());
        }

        if (contemSomaDeAnteriores(vetor)) {
            System.out.println("Existe um elemento que é a soma de dois anteriores.");
        } else {
            System.out.println("Nenhum elemento é a soma de dois anteriores.");
        }

        scanner.close();
    }
}
