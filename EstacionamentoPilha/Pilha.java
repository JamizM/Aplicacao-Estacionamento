public class Pilha {
    private No topo;
    public boolean estaVazia() {
        return topo==null;
    }
    public void push (char i) {
        No novo = new No(i);
        if (!estaVazia()) {
            novo.setProximo(topo);
        }
        topo = novo;
    }
    public char pop () {
        char aux = topo.getInfo();
        topo = topo.getProximo();
        return aux;
    }
    @Override 
    public String toString() {
        String s = "pilha: ";
        if (estaVazia()) 
            s += "vazia";
        else {
            No temp = topo;
            while (temp != null) {
                s += temp + "\n";
                temp = temp.getProximo();
            }
            s += "\\\\";
        }
        return s + "\n";
    }

    public char consultaTopo() {
        return topo.getInfo();
    }
}
