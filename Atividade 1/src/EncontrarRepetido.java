import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

// Complexidade do método: (On), sendo n o tamanho do array.
// O(n) para percorrer o array e O(1) para verificar se o número já foi visto.

public class EncontrarRepetido {
   
    public static int encontrarNumeroRepetido(ArrayList<Integer> array) {
        HashSet<Integer> numerosVistos = new HashSet<>();
        for (int num : array) {
            if (numerosVistos.contains(num)) {
                return num;
            }
            numerosVistos.add(num);
        }
        return -1; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<>();

        System.out.println("Digite os números do array (separados por espaço):");
        String[] entrada = scanner.nextLine().split(" ");
       
        for (String str : entrada) {
            int num = Integer.parseInt(str);
            array.add(num);
        }

        int numeroRepetido = encontrarNumeroRepetido(array);
        System.out.println("Número repetido = " + numeroRepetido);

        scanner.close();
    }
}