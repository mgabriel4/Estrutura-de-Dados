import java.util.LinkedList;
import java.util.Scanner;

public class IntercalarLista {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList<Integer> lista1 = new LinkedList<>();
        LinkedList<Integer> lista2 = new LinkedList<>();

        System.out.println("Quantos números deseja adicionar na Lista 1?");
        int n1 = scanner.nextInt();
        System.out.println("Digite " + n1 + " números inteiros em ordem crescente:");
        for (int i = 0; i < n1; i++) {
            lista1.add(scanner.nextInt());
        }

        System.out.println("Quantos números deseja adicionar na Lista 2?");
        int n2 = scanner.nextInt();
        System.out.println("Digite " + n2 + " números inteiros em ordem crescente:");
        for (int i = 0; i < n2; i++) {
            lista2.add(scanner.nextInt());
        }

        LinkedList<Integer> listaIntercalada = intercalarOrdenado(lista1, lista2);

        System.out.println("\nLista intercalada e ordenada:");
        for (int num : listaIntercalada) {
            System.out.print(num + " ");
        }

        scanner.close();
    }

    public static LinkedList<Integer> intercalarOrdenado(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedList<Integer> resultado = new LinkedList<>();

        int i = 0, j = 0;

        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) <= l2.get(j)) {
                resultado.add(l1.get(i));
                i++;
            } else {
                resultado.add(l2.get(j));
                j++;
            }
        }

        while (i < l1.size()) {
            resultado.add(l1.get(i));
            i++;
        }

        while (j < l2.size()) {
            resultado.add(l2.get(j));
            j++;
        }

        return resultado;
    }
}
