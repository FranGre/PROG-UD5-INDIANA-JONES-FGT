public class IndianaJones {
    private final static int    X_INDIANA_JONES = 2;
    private final static int    Y_INDIANA_JONES = 2;
    final static         String INDIANA_JONES   = "\uD83D\uDEB6";

    /*
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
    public static int[] obtenerPosicionInicio() {
        return new int[]{X_INDIANA_JONES, Y_INDIANA_JONES};
    }

    /**
     * Modifica la posición proporcionada a la posición de inicio de indiana jones.
     */
    public static void reestablecerAPosicionInicial(int[] posicion) {
        int[] posicionInicio = obtenerPosicionInicio();
        posicion[0] = posicionInicio[0];
        posicion[1] = posicionInicio[1];
    }

    /**
     * Modifica, si es posible, la posición proporcionada por la posición adyacente en la dirección dada.
     * La modificación no se realizará si:
     * - La posición adyacente en la dirección dada no es una celda pisable por el
     * personaje.
     * - La dirección es un valor incorrecto. Los valores correctos son (1:Arriba,
     * 2:Abajo, 3: Derecha o 4: Izquierda)
     */
    public static void moverEnDireccion(String[][] escenario, int direccion, int[] posicion) {
        int[] posicionAdelantada = Movimiento.obtenerCoordenadaAdyacente( direccion, posicion );
        if ( Escenario.estaPermitidoElPaso( escenario, posicionAdelantada[0], posicion[1] ) && Movimiento.esUnaDireccionValida( direccion ) ) {
            posicion[0] = posicionAdelantada[0];
            posicion[1] = posicionAdelantada[1];
        }
    }
}
