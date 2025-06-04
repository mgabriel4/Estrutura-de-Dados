public class ZonaRural extends Zona {
    public ZonaRural(String nome) {
        super(nome);
    }

    @Override
    public String toString() {
        return "Zona Rural -> " + getNome();
    }
    
}
