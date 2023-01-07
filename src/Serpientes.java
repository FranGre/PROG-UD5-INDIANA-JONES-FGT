public class Serpientes {
    public static void main(String[] args) {
        int[][] posicionesInicio = obtenerPosicionesInicio();
        mostrarMatriz( posicionesInicio );
        posicionesInicio[0][0] = 5;
        posicionesInicio[0][1] = 5;
        posicionesInicio[1][0] = 5;
        posicionesInicio[1][1] = 5;
        mostrarMatriz( posicionesInicio );
        reestablecerAPosicionesIniciales( posicionesInicio );
        mostrarMatriz( posicionesInicio );

    }

    /**
     * Obtiene la posición de inicio de las serpientes del juego.
     * Elige a mano tantas posiciones de serpientes como desees.
     */
    public static int[][] obtenerPosicionesInicio() {
        return new int[][]{
                {1, 1},
                {5, 4}};
    }

    /**
     * Modifica la posición proporcionada por las posiciones de inicio de cada serpiente.
     */
    public static void reestablecerAPosicionesIniciales(int[][] posicionesSerpientes) {
        posicionesSerpientes[0][0] = obtenerPosicionesInicio()[0][0];
        posicionesSerpientes[0][1] = obtenerPosicionesInicio()[0][1];
        posicionesSerpientes[1][0] = obtenerPosicionesInicio()[1][0];
        posicionesSerpientes[1][1] = obtenerPosicionesInicio()[1][1];
    }

    public static void mostrarMatriz(int[][] matriz) {
        for ( int[] ints : matriz ) {
            for ( int anInt : ints ) {
                System.out.print( anInt + " " );
            }
            System.out.println();
        }
    }
}
