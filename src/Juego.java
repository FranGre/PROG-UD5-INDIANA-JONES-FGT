public class Juego {
    static int VIDAS_INDIANA_JONES = 3;
    static int GEMAS_RECOLECTADAS  = 0;
    static int GEMAS_TOTALES       = 2;

    /**
     * Imprime el escenario celda a celda. Tendrán prioridad de impresión los
     * personajes antes que el objeto de escenario que contenga (nada, muro o gema).
     * Tras imprimir el escenario, también se imprime el número de vidas y de gemas
     * recogidas hasta el momento.
     */
    public static void imprimirEscenario(String[][] escenario, int[] posicionIndianaJones, int[][] posicionSerpientes) {
        for ( int i = 0 ; i < escenario.length ; i++ ) {
            for ( int j = 0 ; j < escenario[i].length ; j++ ) {
                int[] punto = new int[]{i, j};
                if ( Punto.sonIguales( punto, posicionIndianaJones ) ) {
                    System.out.print( IndianaJones.INDIANA_JONES );
                } else if ( Punto.hayAlgunPuntoIgual( punto, posicionSerpientes ) ) {
                    System.out.print( Serpientes.SERPIENTE );
                } else {
                    System.out.print( escenario[i][j] );
                }
            }
            System.out.println();
        }
        System.out.println( "GEMAS: " + GEMAS_RECOLECTADAS );
        System.out.println( "VIDAS: " + VIDAS_INDIANA_JONES );
    }

    /**
     * Mueve a todos los personajes siguiendo los siguientes pasos:
     * 1º Se solicita el movimiento de Indiana Jones.
     * 2º Se mueve a Indiana Jones en la dirección seleccionada.
     * 3º Si tras el movimiento de Indiana Jones, éste no se encuentra ya sobre alguna
     * de ellas, se mueven a todas las serpientes.
     */
    public static void moverATodos(String[][] escenario, int[] posicionIndianaJones, int[][] posicionSerpientes) {
        int movimientoIndianaJones = Movimiento.pedirDireccion();
        IndianaJones.moverEnDireccion( escenario, movimientoIndianaJones, posicionIndianaJones );

        if ( !Punto.hayAlgunPuntoIgual( posicionIndianaJones, posicionSerpientes ) ) {
            Serpientes.mover( escenario, posicionSerpientes );
        }
    }

    /**
     * Actualiza los datos de vidas y gemas de la partida si procede.
     * <p>
     * Las vidas se verán decrementadas si la posición de Indiana Jones coincide con
     * alguna de las serpientes. En este caso se reestablecerán las posiciones de todos
     * (Indiana Jones y serpientes).
     * <p>
     * Si no se ha perdido una vida, las gemas recolectadas se verán incrementadas si
     * la posición de Indiana jones coincide con la posición de alguna de las gemas del
     * escenario, vaciándose esta celda posteriormente.
     * <p>
     * ESTE MÉTODO MODIFICA LAS VARIABLES GLOBALES de vidas y gemas recolectadas que
     * hayas declarado en esta clase.
     */
    public static void actualizarDatos(String[][] escenario, int[] posicionIndianaJones, int[][] posicionSerpientes) {
        if ( Punto.hayAlgunPuntoIgual( posicionIndianaJones, posicionSerpientes ) ) {
            --VIDAS_INDIANA_JONES;
            IndianaJones.reestablecerAPosicionInicial( posicionIndianaJones );
            Serpientes.reestablecerAPosicionesIniciales( posicionSerpientes );
        } else if ( Escenario.hayGema( escenario, posicionIndianaJones[0], posicionIndianaJones[1] ) ) {
            ++GEMAS_RECOLECTADAS;
            Escenario.vaciarCelda( escenario, posicionIndianaJones[0], posicionIndianaJones[1] );
        }
    }

    /**
     * Se encarga de imprimir el mensaje:
     * "Has perdido. Fin del juego" --> si no quedan vidas (registradas en la variable
     * global)
     * o bien el mensaje:
     * "Has ganado. ¡Enhorabuena!" --> si no quedan gemas en el escenario proporcionado
     */
    public static void imprimirMensajeFinDeJuego(String[][] escenario) {
        if ( VIDAS_INDIANA_JONES == 0 ) {
            System.out.println( "Has perdido. Fin del juego" );
        } else if ( GEMAS_RECOLECTADAS == GEMAS_TOTALES ) {
            System.out.println( "Has ganado. ¡Enhorabuena!" );
        }
    }

    /**
     * Indica si el juego ha terminado. El juego termina si no quedan vidas o si no quedan gemas en el escenario.
     */
    public static boolean seHaTerminado(String[][] escenario) {
        return !Escenario.quedanGemas( escenario ) || VIDAS_INDIANA_JONES == 0;
    }
}
