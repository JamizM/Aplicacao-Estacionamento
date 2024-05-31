import java.time.LocalDateTime;

public class Estacionamento {

    private Pilha<Carro> pilhaCarros;
    private int capacidade;
    private int numeroManobras; 

    public Estacionamento(int capacidade) {
        this.pilhaCarros = new Pilha<>();
        this.capacidade = capacidade;
        this.numeroManobras = 0;
    }

    public boolean estaCheio() {
        return pilhaCarros.getTamanho() >= capacidade;
    }

    public void registrarEntradaCarro(String placa) {
        Carro carro = new Carro(placa, LocalDateTime.now());
        pilhaCarros.push(carro);
        System.out.println("Carro com placa " + placa + " estacionado às " + carro.getHorarioEntrada());
    }

    public void consultarCarro(String placa) {
        if (pilhaCarros.estaVazia()) {
            System.out.println("Estacionamento vazio! Nenhum carro para consultar.");
            return;
        }

        boolean carroEncontrado = false;
        Pilha<Carro> carrosRemovidos = new Pilha<>();
        int posicao = 1;

        while (!pilhaCarros.estaVazia()) {
            Carro carro = pilhaCarros.pop();
            carrosRemovidos.push(carro);

            if (carro.getPlaca().equals(placa)) {
                carroEncontrado = true;
                System.out.println("Carro com placa " + placa + " encontrado na posição " + posicao);
                System.out.println("Horário de entrada: " + carro.getHorarioEntrada());
                break;
            }

            posicao++;
        }

        while (!carrosRemovidos.estaVazia()) {
            pilhaCarros.push(carrosRemovidos.pop());
        }

        if (!carroEncontrado) {
            System.out.println("Carro com placa " + placa + " não encontrado.");
        }
    }

    public void registrarSaidaCarro() {
        if (pilhaCarros.estaVazia()) {
            System.out.println("Estacionamento vazio! Nenhum carro para sair.");
            return;
        }

        Carro carroSaindo = pilhaCarros.pop();
        System.out.println("Carro com placa " + carroSaindo.getPlaca() + " saindo às " + LocalDateTime.now());
        System.out.println("Tempo total de estacionamento: " + calcularTempoEstacionamento(carroSaindo));
        System.out.println("Número de manobras: " + numeroManobras);

        reinserirCarrosRemovidos();
        numeroManobras = 0;
    }

    private String calcularTempoEstacionamento(Carro carro) {
        LocalDateTime agora = LocalDateTime.now();
        long diferencaSegundos = java.time.Duration.between(carro.getHorarioEntrada(), agora).toSeconds();
        long minutos = diferencaSegundos / 60;
        long segundosRestantes = diferencaSegundos % 60;

        return String.format("%d minutos e %d segundos", minutos, segundosRestantes);
    }

    private void reinserirCarrosRemovidos() {
        Pilha<Carro> carrosRemovidos = new Pilha<>();

        while (!pilhaCarros.estaVazia()) {
            carrosRemovidos.push(pilhaCarros.pop());
            numeroManobras++;
        }

        while (!carrosRemovidos.estaVazia()) {
            pilhaCarros.push(carrosRemovidos.pop());
        }
    }

    public void mostrarTodosCarros() {
        if (pilhaCarros.estaVazia()) {
            System.out.println("Estacionamento vazio! Nenhum carro para mostrar.");
            return;
        }

        Pilha<Carro> carrosRemovidos = new Pilha<>();

        while (!pilhaCarros.estaVazia()) {
            Carro carro = pilhaCarros.pop();
            carrosRemovidos.push(carro);
            System.out.println("Carro com placa " + carro.getPlaca() + " estacionado às " + carro.getHorarioEntrada());
        }

        while (!carrosRemovidos.estaVazia()) {
            pilhaCarros.push(carrosRemovidos.pop());
        }
    }
}

class Carro {
    private String placa;
    private LocalDateTime horarioEntrada;

    public Carro(String placa, LocalDateTime horarioEntrada) {
        this.placa = placa;
        this.horarioEntrada = horarioEntrada;
    }

    public String getPlaca() {
        return placa;
    }

    public LocalDateTime getHorarioEntrada() {
        return horarioEntrada;
    }
}
