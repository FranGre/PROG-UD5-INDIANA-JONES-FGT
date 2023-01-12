import java.util.Scanner;
public class Principal {

    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        inicio();
    }

    public static void inicio() {

        String[][] escenario = Escenario.creaEscenario();
        int[] posicionIndianaJones = IndianaJones.obtenerPosicionInicio();
        int[][] posicionSerpientes = Serpientes.obtenerPosicionesInicio();

        do {
            Juego.imprimirEscenario(escenario, posicionIndianaJones, posicionSerpientes);
            Juego.moverATodos(escenario, posicionIndianaJones, posicionSerpientes);
            Juego.actualizarDatos(escenario, posicionIndianaJones, posicionSerpientes);
        } while(!Juego.seHaTerminado(escenario));

        Juego.imprimirMensajeFinDeJuego(escenario);
    }
}