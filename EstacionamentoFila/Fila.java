public class Fila <E>{
    No<E> primeiro;
    private No<E> ultimo;
    //construtor padrão

    public boolean estaVazia() {
        return primeiro == null;
    }
    public void enfileira(E i) {
        No<E> novo = new No<>(i);
        if (estaVazia()) {
            primeiro = novo;
        }
        else {
            ultimo.setProximo(novo);
        }
        ultimo = novo;
    }
    public E desenfileira () {
        if (estaVazia()) return null;
        E temp = primeiro.getInfo();
        primeiro = primeiro.getProximo();
        if (primeiro == null) { //esvaziou a fila
            ultimo = null;
        }
        return temp;
    }
    @Override
    public String toString () {
        if (estaVazia()) return "fila vazia";
        String s = "";
        No<E> aux = primeiro;
        while (aux != ultimo) {
            s += aux + " - ";
            aux = aux.getProximo();
        }
        s += aux;
        return s;
    }
}

class No <E>{
    private E info;
    private No<E> proximo;
    //construtor para armazenar uma informação
    public No (E info) {
        this.info = info;
        setProximo(null); //por clareza
    }
    public E getInfo() {
        return info;
    }
    public No<E> getProximo () {
        return proximo;
    }
    public void setInfo (E info) {
        this.info = info;
    }
    public void setProximo (No<E> proximo) {
        this.proximo = proximo;
    }
    @Override
    public String toString() {
        return "" + info;
    }
}
