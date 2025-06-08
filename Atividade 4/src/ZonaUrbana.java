import java.util.LinkedList;

public class ZonaUrbana extends Zona implements Emergencia {
    private LinkedList<Sensor> sensores = new LinkedList<>();

    public ZonaUrbana(String nome, Sensor sensor) {
        super(nome);
        this.sensores.add(sensor);
    }
   


    public LinkedList<Sensor> getSensores() {
        return sensores;
    }
    
    @Override
    public String toString() {
        return "Zona Urbana -> " + getNome() + ", Sensores: " + sensores.size();
    }

    @Override
    public String classificarNivelEmergencia() {
        double media = calcularMedia();
        if (media <= 50) return "Sem risco";
        else if (media <= 100) return "Monitoramento intensificado";
        else if (media <= 150) return "Alerta para grupos sensíveis";
        else if (media <= 200) return "Alerta Amarelo";
        else if (media <= 300) return "Alerta Laranja";
        else return "Alerta Vermelho (emergência total)";
    }
}
