public class No {
    private char info;
    private No proximo;
    public No(char info) {
        this.info = info;
    }
    public char getInfo() {
        return info;
    }
    public void setInfo(char info) {
        this.info = info;
    }
    public No getProximo() {
        return proximo;
    }
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
    @Override
    public String toString() {
        return "No [info=" + info + "]";
    }
    
}