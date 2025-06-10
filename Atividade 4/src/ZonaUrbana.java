import java.util.LinkedList;
import java.util.List;

public class ZonaUrbana extends Zona {
    private List<Sensor> sensores;

    public ZonaUrbana(String nome) {
        super(nome);
        this.sensores = new LinkedList<>();
    }

    public void adicionarSensor(Sensor sensor) {
        if (sensor != null) {
            sensores.add(sensor);
        }
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Sensor s : sensores) {
            total += s.getValor();
        }
        return total;
    }

    public double calcularMedia() {
        if (sensores.isEmpty()) return 0.0;
        return calcularTotal() / sensores.size();
    }

    public String classificarNivelEmergencia() {
        double media = calcularMedia();

        if (media <= 50) {
            return "Sem risco.";
        } else if (media <= 100) {
            return "Monitoramento intensificado.";
        } else if (media <= 150) {
            return "Alerta para grupos sensíveis.";
        } else if (media <= 200) {
            return "Alerta Amarelo.";
        } else if (media <= 300) {
            return "Alerta Laranja.";
        } else {
            return "Alerta Vermelho (emergência total)!";
        }
    }

    @Override
    public String relatorio() {
        double total = calcularTotal();
        double media = calcularMedia();
        String nivel = classificarNivelEmergencia();

        StringBuilder sb = new StringBuilder();
        sb.append("Zona: ").append(getNome()).append("\n");
        sb.append("Total semanal: ").append(String.format("%.2f", total)).append("\n");
        sb.append("Média semanal: ").append(String.format("%.2f", media)).append("\n");
        sb.append("Nível de emergência: ").append(nivel);

        if (nivel.equals("Alerta Vermelho (emergência total)")) {
            sb.append("\n>> Ação imediata recomendada: evacuação ou restrição de atividades externas.");
        }

        return sb.toString();
    }
}
