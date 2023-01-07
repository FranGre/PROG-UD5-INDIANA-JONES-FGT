public class Punto {
    private final static int TAMANYO_MAXIMO_PUNTOS = 2;

    public static void main(String[] args) {
        int[][] matrizBinaria = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10}};
        int[] punto = {3,2};

        System.out.println(hayAlgunPuntoIgual(punto,matrizBinaria));
    }

    /**
     * Determina si los dos arrays de tamaño 2 @punto1 y @punto2 proporcionados
     * contienen la misma información, es decir, la misma posición.
     * Retorna: true/false indicando si la información de ambos puntos es la misma o * bien si alguno de los arrays no es de tamaño 2
     */
    public static boolean sonIguales(int[] punto1, int[] punto2) {
        if ( punto1.length > TAMANYO_MAXIMO_PUNTOS || punto2.length > TAMANYO_MAXIMO_PUNTOS ) {
            return false;
        }

        for ( int i = 0 ; i < punto1.length ; i++ ) {
            if ( punto1[i] != punto2[i] ) {
                return false;
            }
        }
        return true;
    }


    /**
     * Determina si en la lista de puntos @listaPuntos se encuentra la posición
     *
     * @punto. Retorna true si la información del punto a comparar coincide con alguno de los
     * contenidos en la lista de puntos / false en caso contrario
     */
    public static boolean hayAlgunPuntoIgual(int[] punto, int[][] listaPuntos) {

        for ( int i = 0 ; i < punto.length ; i++ ) {
            for ( int j = 0 ; j < listaPuntos.length ; j++ ) {
                for ( int k = 0 ; k < listaPuntos[j].length ; k++ ) {
                    if ( listaPuntos[j][k] == punto[i] ){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}