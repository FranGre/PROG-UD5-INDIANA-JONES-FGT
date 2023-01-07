import java.util.Arrays;

public class IndianaJones {
    final static int X_INDIANA_JONES = 2;
    final static int Y_INDIANA_JONES = 2;
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
}
