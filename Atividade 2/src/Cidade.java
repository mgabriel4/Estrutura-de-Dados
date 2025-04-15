public class Cidade {
    private String nome;
    private ListaDupla<Ligacao> ligacoes;

    public Cidade(String nome) {
        this.nome = nome;
        this.ligacoes = new ListaDupla<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ListaDupla<Ligacao> getLigacoes() {
        return ligacoes;
    }

    public void setLigacoes(ListaDupla<Ligacao> ligacoes) {
        this.ligacoes = ligacoes;
    }

    @Override
    public String toString() {
        String result = "Cidade: " + nome + "\n";
        result += (ligacoes != null ? ligacoes.toString() : "Sem ligações.");
        return result;
    }
}
