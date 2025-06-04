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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'classificarNivelEmergencia'");
    }
}
