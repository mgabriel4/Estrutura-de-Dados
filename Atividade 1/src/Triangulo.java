import java.util.ArrayList;

public class Triangulo {
    private double a;
    private double b;
    private double c;

    public Triangulo(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calcularPerimetro() {
        return a + b + c;
    }

    public double calcularArea() {
        double p = calcularPerimetro() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public double[] calcularCentroide() {
        double lambda = (Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b);
        double x = (b + a * lambda) / 3;
        double y = (a / 3) * Math.sqrt(1 - Math.pow(lambda, 2));
        return new double[]{x, y};
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public static void main(String[] args) {
        Triangulo t1 = new Triangulo(3, 4, 5);
        Triangulo t2 = new Triangulo(5, 12, 13);

        ArrayList<Triangulo> triangulos = new ArrayList<>();
        triangulos.add(t1);
        triangulos.add(t2);

        for (Triangulo t : triangulos) {
            System.out.println("Triângulo com lados: " + t.getA() + ", " + t.getB() + ", " + t.getC());
            System.out.println("Área: " + t.calcularArea());
            System.out.println("Perímetro: " + t.calcularPerimetro());
            double[] centroide = t.calcularCentroide();
            System.out.println("Centróide: (" + centroide[0] + ", " + centroide[1] + ")");
            System.out.println();
        }
    }
}