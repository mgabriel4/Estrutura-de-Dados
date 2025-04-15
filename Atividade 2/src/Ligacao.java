public class Ligacao {
    private String destino;
    private double distancia;
    private double trafego;
    private int pedagios;

    public Ligacao(String destino, double distancia, double trafego, int Pedagios) {
        this.destino = destino;
        this.distancia = distancia;
        this.trafego = trafego;
        this.pedagios = Pedagios;
    }

    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getTrafego() {
        return trafego;
    }
    public void setTrafego(double trafego) {
        this.trafego = trafego;
    }

    public int getPedagios() {
        return pedagios;
    }
    public void setPedagios(int Pedagios) {
        this.pedagios = Pedagios;
    }

    public double getTempoEstimado(){
        return (distancia * trafego) + (pedagios * 2);
    }

    @Override
    public String toString() {
        return "Ligação ->" + destino + " - " + distancia + " km - " + trafego + " km/h - " + pedagios + " Pedágios" +
                "\nTempo estimado: " + String.format ("%.2f",getTempoEstimado() )+ " min";
    }
    
}
