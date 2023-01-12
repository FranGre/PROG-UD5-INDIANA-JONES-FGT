public class Serpientes {
    final static String SERPIENTE                 = "\uD83D\uDC0D";
    final static int    INTENTOS_MOVER_SERPIENTES = 3;

    /**
     * public static void main(String[] args) {
     * int[][] posicionesInicio = obtenerPosicionesInicio();
     * mostrarMatriz( posicionesInicio );
     * posicionesInicio[0][0] = 5;
     * posicionesInicio[0][1] = 5;
     * posicionesInicio[1][0] = 5;
     * posicionesInicio[1][1] = 5;
     * mostrarMatriz( posicionesInicio );
     * reestablecerAPosicionesIniciales( posicionesInicio );
     * mostrarMatriz( posicionesInicio );
     * System.out.println( SERPIENTE );
     * System.out.println( "\n" );
     * String[][] escenario = Escenario.creaEscenario();
     * for ( int i = 0 ; i < escenario.length ; i++ ) {
     * for ( int j = 0 ; j < escenario[i].length ; j++ ) {
     * System.out.print( escenario[i][j] );
     * }
     * System.out.println();
     * }
     * <p>
     * System.out.println( "\n" );
     * escenario[posicionesInicio[0][0]][posicionesInicio[0][1]] = SERPIENTE;
     * escenario[posicionesInicio[1][1]][posicionesInicio[1][0]] = SERPIENTE;
     * for ( int i = 0 ; i < escenario.length ; i++ ) {
     * for ( int j = 0 ; j < escenario[i].length ; j++ ) {
     * System.out.print( escenario[i][j] );
     * }
     * System.out.println();
     * }
     * <p>
     * System.out.println( "\n" );
     * mover( escenario, posicionesInicio );
     * for ( int i = 0 ; i < escenario.length ; i++ ) {
     * for ( int j = 0 ; j < escenario[i].length ; j++ ) {
     * System.out.print( escenario[i][j] );
     * }
     * System.out.println();
     * }
     * }
     * <p>
     * /**
     * Obtiene la posición de inicio de las serpientes del juego.
     * Elige a mano tantas posiciones de serpientes como desees.
     */
    public static int[][] obtenerPosicionesInicio() {
        return new int[][]{
                {1, 1},
                {4, 4}};
    }

    /**
     * Modifica la posición proporcionada por las posiciones de inicio de cada serpiente.
     */
    public static void reestablecerAPosicionesIniciales(int[][] posicionesSerpientes) {
        int[][] posicionSnakesOriginales = obtenerPosicionesInicio();
        for ( int i = 1 ; i < posicionesSerpientes.length ; i++ ) {
            for ( int j = 0 ; j < posicionesSerpientes[i].length ; j++ ) {
                posicionesSerpientes[i][i] = posicionSnakesOriginales[i][j];
            }
        }
    }

    /**
     * Modifica las posiciones de las serpientes siguiendo el
     * algoritmo de movimiento de las serpientes
     * 1ro -> 3 intentos para mover de manera random each Snake
     * 2do -> Si se han agotado esos 3 intentos(debido a que hay
     * otra Snake o un Muro). Se buscará un hueco siguiente estos
     * pasos:
     * -Arriba
     * -Abajo
     * -Derecha
     * -Izquierda
     */
    public static void mover(String[][] escenario, int[][] posicionSerpientes) {
        int moverSnakeRandomWay1 = moverSerpienteFormaAleatoria( escenario, posicionSerpientes, 0 );
        if ( moverSnakeRandomWay1 == -1 ) {
            moverSerpientePorPrioridad( escenario, posicionSerpientes, 0 );
        }

        int moverSnakeRandomWay2 = moverSerpienteFormaAleatoria( escenario, posicionSerpientes, 1 );
        if ( moverSnakeRandomWay2 == -1 ) {
            moverSerpientePorPrioridad( escenario, posicionSerpientes, 1 );
        }
    }

    private static int moverSerpienteFormaAleatoria(String[][] escenario, int[][] posicionSerpientes, int serpienteAMover) {
        for ( int i = 1 ; i <= INTENTOS_MOVER_SERPIENTES ; i++ ) {
            int   movimientoRandom            = Movimiento.obtieneDireccionAleatoria();
            int[] posicionSerpiente           = {posicionSerpientes[0][0], posicionSerpientes[0][1]};
            int[] posicionSerpienteModificada = Movimiento.obtenerCoordenadaAdyacente( movimientoRandom, posicionSerpiente );
            if ( Escenario.estaPermitidoElPaso( escenario, posicionSerpienteModificada[0], posicionSerpienteModificada[1] ) && !escenario[posicionSerpienteModificada[0]][posicionSerpienteModificada[1]].equals( SERPIENTE ) ) {
                posicionSerpientes[serpienteAMover][0] = posicionSerpiente[0];
                posicionSerpientes[serpienteAMover][1] = posicionSerpiente[1];
                return 1;
                // Tiene que devolver un entero para que no finalize,ya que estamos trabajando
                // con un método void
            }
        }
        return -1;
    }

    public static void moverSerpientePorPrioridad(String[][] escenario, int[][] posicionSerpientes, int serpienteAMover) {
        int[] posicionSerpiente = {posicionSerpientes[serpienteAMover][0], posicionSerpientes[serpienteAMover][1],};
        for ( int i = 1 ; i <= 4 ; i++ ) {
            int[]   nuevaCoordenadaSnake = Movimiento.obtenerCoordenadaAdyacente( i, posicionSerpiente );
            boolean sonIguales           = Punto.sonIguales( posicionSerpiente, nuevaCoordenadaSnake );
            if ( !sonIguales && Escenario.estaPermitidoElPaso( escenario, posicionSerpiente[serpienteAMover], posicionSerpiente[0] ) && haySnake( posicionSerpientes, posicionSerpiente[0], posicionSerpiente[1] ) ) {
                posicionSerpientes[serpienteAMover][0] = posicionSerpiente[0];
                posicionSerpientes[serpienteAMover][1] = posicionSerpiente[1];
                return;
            }
        }
    }

    public static boolean haySnake(int[][] posicionSerpientes, int x, int y) {
        for ( int i = 0 ; i < posicionSerpientes.length ; i++ ) {
            for ( int j = 0 ; j < posicionSerpientes[i].length ; j++ ) {
                if ( posicionSerpientes[i][j] == x && posicionSerpientes[i][j] == y ) {
                    return true;
                }
            }
        }
        return false;
    }
}
