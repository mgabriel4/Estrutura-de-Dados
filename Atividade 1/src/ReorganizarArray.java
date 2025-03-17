import java.util.Scanner;

public class ReorganizarArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de elementos do array: ");
        int n = scanner.nextInt();
      
        int[] A = new int[n];

        System.out.println("Digite os elementos do array:");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
       
        System.out.print("Digite o valor de k: ");
        int k = scanner.nextInt();

        reorganizarArray(A, k);

        System.out.print("Array reorganizado: ");
        for (int num : A) {
            System.out.print(num + " ");
        }

        scanner.close();
    }

    public static void reorganizarArray(int[] A, int k) {
        int posicao = 0; 
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= k) {
                int temp = A[i];
                A[i] = A[posicao];
                A[posicao] = temp;
                posicao++;
            }
        }
    }
}