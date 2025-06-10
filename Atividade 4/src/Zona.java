public abstract class Zona implements Comparable<Zona> {
    private String nome;

    public Zona(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Zona -> " + nome;
    }

    public abstract String relatorio(); //método abstrato

    @Override
    public int compareTo(Zona outra) {
        return this.nome.compareToIgnoreCase(outra.getNome());
    }
}