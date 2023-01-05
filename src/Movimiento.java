import java.util.Arrays;

public class Movimiento {
    public static void main(String[] args) {
        System.out.println( esUnaDireccionValida( 4 ) );
        System.out.println( obtieneDireccionAleatoria() );
        int[] basePosi = {1, 1};
        int[] posicion = obtenerCoordenadaAdyacente( 1, basePosi );
        System.out.println( Arrays.toString( posicion ) );
    }

    /**
     * Determina si el valor de @direccion corresponde a un valor numérico de dirección válido (1: Arriba, 2:Abajo, 3: Derecha o 4: Izquierda)
     *
     * @return true si el valor de @direccion es válido
     */
    public static boolean esUnaDireccionValida(int direccion) {
        return direccion >= 1 && direccion <= 4;
    }

    /**
     * Obtiene una dirección de movimiento válida y aleatoria: un valor entre 1 y 4.
     *
     * @return El valor de la dirección generada
     */
    public static int obtieneDireccionAleatoria() {
        return (int) (Math.random() * (5 - 1)) + 1;
    }

    /**
     * Obtiene la posición adyacente a la posición proporcionada en la dirección.
     * La posición retornada será la misma que la original si:
     * - Se proporciona una dirección no válida (siendo los valores válidos 1:Arriba, 2:Abajo, 3: Derecha o 4: Izquierda)
     * - @posicion es un array de dimensión diferente a 2.
     * El parámetro @posicion contiene las coordenadas desde las cuales se va a calcular la nueva posición
     * Retorna La nueva posición desde @posicion en función de la dirección @direccion
     * Ejemplos:
     * - para una posición [1,1] y una dirección 2 (abajo), la posición devuelta sería * la [2,1]
     * - para una posición [1,1] y una dirección 3 (derecha), la posición devuelta
     * sería la [1,2]
     */
    public static int[] obtenerCoordenadaAdyacente(int direccion, int[] posicion) {
        if ( posicion.length != 2 || !esUnaDireccionValida( direccion ) ) {
            return posicion;
        }

        if ( direccion == 1 ) {
            posicion[0] -= 1;
        } else if ( direccion == 2 ) {
            posicion[0] += 1;
        } else if ( direccion == 3 ) {
            posicion[1] += 1;
        } else {
            posicion[1] -= 1;
        }
        return posicion;
    }
}