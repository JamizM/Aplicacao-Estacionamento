public class TesteEstacionamento {
    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento(10);

        System.out.println("Registrar Carros\n");
        estacionamento.registrarEntradaCarro("ABC1234"); //carro no final da fila
        estacionamento.registrarEntradaCarro("DEF5678"); 
        estacionamento.registrarEntradaCarro("GHI9012"); //carro no inicio da fila

        estacionamento.mostrarFilaCarros();

        //saida do carro ABC2134
        estacionamento.registrarSaidaCarro();
        estacionamento.mostrarFilaCarros();

        // Carro DEF5678 sai
        estacionamento.registrarSaidaCarro(); 
        estacionamento.mostrarFilaCarros();

        //novo carro
        estacionamento.registrarEntradaCarro("JKL3456");

        estacionamento.mostrarFilaCarros();

        estacionamento.registrarSaidaCarro(); 

        estacionamento.mostrarFilaCarros();
        estacionamento.registrarEntradaCarro("MNO7890");
        estacionamento.mostrarFilaCarros();


    }
}
