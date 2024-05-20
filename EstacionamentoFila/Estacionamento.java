import java.time.LocalDateTime;

public class Estacionamento {

    private Fila<Carro> filaCarros;
    private int manobras;

    public Estacionamento(int capacidadeMaxima) {
        if (capacidadeMaxima <= 0) {
            throw new IllegalArgumentException("Capacidade máxima deve ser um valor positivo.");
        }

        this.filaCarros = new Fila<>();
        this.manobras = 0;
    }

    public void registrarEntradaCarro(String placa) {
        Carro novoCarro = new Carro(placa, LocalDateTime.now()); //chamada construtor
        filaCarros.enfileira(novoCarro);
        System.out.println("Carro com placa " + placa + " entrou na fila.");
    }

    public void registrarSaidaCarro() {
        if (filaCarros.estaVazia()) {
            System.out.println("Fila vazia. Nenhum carro para sair.");
            return;
        }

        Carro carroSaindo = filaCarros.desenfileira();
        manobras++;
        LocalDateTime saida = LocalDateTime.now();
        long tempoPermanencia = java.time.Duration.between(carroSaindo.getEntrada(), saida).toMinutes(); //tempo em minutos

        System.out.println("Carro com placa " + carroSaindo.getPlaca() + " saiu da fila.");
        System.out.println("Tempo de permanência: " + tempoPermanencia + " minutos.");
        System.out.println("Manobras realizadas: " + manobras);
        System.out.println("\n");
    }

    public void mostrarFilaCarros() {
        System.out.println("Fila de carros:");
        System.out.println(filaCarros);
    }
    public ResultadoConsulta buscarCarro(String placa) {
        No<Carro> atual = filaCarros.primeiro;
        int posicao = 1;

        while (atual != null) {
            if (atual.getInfo().getPlaca().equals(placa)) {
                LocalDateTime saida = LocalDateTime.now();
                long tempoPermanencia = java.time.Duration.between(atual.getInfo().getEntrada(), saida).toMinutes();
                return new ResultadoConsulta(posicao, tempoPermanencia, atual.getInfo().getEntrada());
            }

            posicao++;
            atual = atual.getProximo();
        }

        return null;
    }
}

class Carro {
    private String placa;
    private LocalDateTime entrada;

    public Carro(String placa, LocalDateTime entrada) {
        this.placa = placa;
        this.entrada = entrada;
    }

    public String getPlaca() {
        return placa;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + ", Entrada: " + entrada.toString() + " |||";
    }
}

class ResultadoConsulta {
    private int posicaoFila;
    private long tempoPermanencia; //colocado para manter o padrão de minutos
    private LocalDateTime entrada;

    public ResultadoConsulta(int posicaoFila, long tempoPermanencia, LocalDateTime entrada) {
        this.posicaoFila = posicaoFila;
        this.tempoPermanencia = tempoPermanencia;
        this.entrada = entrada;
    }

    public int getPosicaoFila() {
        return posicaoFila;
    }

    public long getTempoPermanencia() {
        return tempoPermanencia;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    @Override
    public String toString() {
        return "Posição na fila: " + posicaoFila +
                ", Tempo de permanência: " + tempoPermanencia + " minutos" +
                ", Entrada: " + entrada.toString();
    }
}
