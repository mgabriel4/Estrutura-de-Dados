public class ListaDupla<T> {
    private NoDuplo<T> primeiro;
    private NoDuplo<T> ultimo;
    private int tamanho;

    public ListaDupla() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void adicionar(T elemento) {
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        if (tamanho == 0) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            ultimo.setProximo(novoNo);
            novoNo.setAnterior(ultimo);
            ultimo = novoNo;
        }
        tamanho++;
    }

    public void remover(T elemento) {
        NoDuplo<T> atual = primeiro;
        while (atual != null) {
            if (atual.getDado().equals(elemento)) {
                if (atual.getAnterior() != null) {
                    atual.getAnterior().setProximo(atual.getProximo());
                } else {
                    primeiro = atual.getProximo();
                }
                if (atual.getProximo() != null) {
                    atual.getProximo().setAnterior(atual.getAnterior());
                } else {
                    ultimo = atual.getAnterior();
                }
                tamanho--;
                return;
            }
            atual = atual.getProximo();
        }
    }

    public void exibir() {
        NoDuplo<T> atual = primeiro;
        while (atual != null) {
            System.out.println(atual.getDado().toString());
            atual = atual.getProximo();
        }
    }

    public boolean contem(T elemento) {
        NoDuplo<T> atual = primeiro;
        while (atual != null) {
            if (atual.getDado().equals(elemento)) {
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }

    public void limpar() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public NoDuplo<T> getPrimeiro() {
        return primeiro;
    }

    public NoDuplo<T> getUltimo() {
        return ultimo;
    }

    public boolean isVazia() {
        return tamanho == 0;
    }

    @Override
    public String toString() {
        String result = "";
        NoDuplo<T> atual = primeiro;
        while (atual != null) {
            result += atual.getDado().toString() + "\n";
            atual = atual.getProximo();
        }
        return result;
    }
}
