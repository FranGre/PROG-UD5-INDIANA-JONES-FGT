import java.util.Arrays;

public class IndianaJones {
    private final static int X_INDIANA_JONES = 2;
    private final static int Y_INDIANA_JONES = 2;
    public static void main(String[] args) {
        int[] posicionInicio = obtenerPosicionInicio();
        System.out.println( Arrays.toString(posicionInicio) );
        posicionInicio[0] = 3;
        posicionInicio[1] = 5;
        System.out.println( Arrays.toString(posicionInicio) );
        System.out.println("aaaaa");
        reestablecerAPosicionInicial( posicionInicio );
        System.out.println(Arrays.toString( posicionInicio ));

    }
    /**
     * Obtiene la posición de inicio de Indiana Jones.
     * Genera una posición transitable por el personaje dentro del escenario.
     */
    public static int[] obtenerPosicionInicio(){
        return new int[]{X_INDIANA_JONES, Y_INDIANA_JONES};
    }

    /**
     * Modifica la posición proporcionada a la posición de inicio de indiana jones.
     */
    public static void reestablecerAPosicionInicial(int[] posicion){
        posicion[0] = obtenerPosicionInicio()[0];
        posicion[1] = obtenerPosicionInicio()[1];
    }

    /**
     * Modifica, si es posible, la posición proporcionada por la posición adyacente en la dirección dada.
     * La modificación no se realizará si:
     * - La posición adyacente en la dirección dada no es una celda pisable por el
     * personaje.
     * - La dirección es un valor incorrecto. Los valores correctos son (1:Arriba,
     * 2:Abajo, 3: Derecha o 4: Izquierda)
     */
    public static void moverEnDireccion(String[][] escenario, int direccion, int[]posicion){
        if ( !Escenario.estaPermitidoElPaso( escenario,posicion[0], posicion[1] ) || !Movimiento.esUnaDireccionValida( direccion ) ){
        }else {
            Movimiento.obtenerCoordenadaAdyacente( direccion,posicion );
        }
    }
}
