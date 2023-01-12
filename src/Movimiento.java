public class Movimiento {
    /*
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner( System.in );
        System.out.println( esUnaDireccionValida( 4 ) );
        System.out.println( obtieneDireccionAleatoria() );
        int[] basePosi = {1, 1};
        int[] posicion = obtenerCoordenadaAdyacente( 1, basePosi );
        System.out.println( Arrays.toString( posicion ) );
        System.out.println( pedirDireccion() );
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
        if ( longitudEsDiferenteDe2s( posicion ) || !esUnaDireccionValida( direccion ) ) {
            return posicion;
        }
        devolverLaNuevaPosicion( direccion, posicion );
        return posicion;
    }

    public static void devolverLaNuevaPosicion(int direccion, int[] posicion) {
        if ( direccion == 1 ) {
            //Arriba
            posicion[0] -= 1;
        } else if ( direccion == 2 ) {
            //Abajo
            posicion[0] += 1;
        } else if ( direccion == 3 ) {
            //Derecha
            posicion[1] += 1;
        } else {
            //Izquierda
            posicion[1] -= 1;
        }
    }

    private static boolean longitudEsDiferenteDe2s(int[] array) {
        return array.length != 2;
    }

    /**
     * Pide al usuario, previa muestra del texto ‘Introduce el movimiento (W/A/S/D):’ que se introduzca por teclado un movimiento.
     * Los posibles movimientos son A: Izquierda S: Abajo D: Derecha W: Arriba
     * Se admiten valores tanto en minúsculas como en mayúsculas.
     * Si se introduce un valor diferente a los enumerados se vuelve a solicitar el dato sin mostrar mensaje de error alguno
     * Este método hace uso del objeto Scanner declarado globalmente en la clase principal.
     * Retorna el valor numérico de la dirección leída (1:Arriba, 2:Abajo, 3: Derecha, 4: Izquierda)
     */
    public static int pedirDireccion() {
        do {
            System.out.print( "Introduce el movimiento (W/A/S/D): " );
            String direccion = Principal.scanner.next();
            if ( direccion.equalsIgnoreCase( "W" ) ) {
                return 1;
            } else if ( direccion.equalsIgnoreCase( "A" ) ) {
                return 4;
            } else if ( direccion.equalsIgnoreCase( "S" ) ) {
                return 2;
            } else if ( direccion.equalsIgnoreCase( "D" ) ) {
                return 3;
            }
        } while ( true );
    }
}