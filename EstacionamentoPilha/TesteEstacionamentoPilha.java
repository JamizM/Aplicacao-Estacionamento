
public class TesteEstacionamentoPilha {
    public static void main(String[] args) {

        Estacionamento e = new Estacionamento(20);

        e.registrarEntradaCarro("ABC1234");
        e.registrarEntradaCarro("DEF5678");
        e.registrarEntradaCarro("GHI9012");
        System.out.println("\n");


        e.consultarCarro("GHI9012");

        System.out.println("\n");
        e.mostrarTodosCarros();

    }
}