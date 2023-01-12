public class Escenario {
    /**
     * Define e inicializa estas constantes de estado de celda con estos nombres
     * Las celdas del escenario sólo podrán contener uno de estos tres valores
     */
    public static final String NADA = "\uD83D\uDFE1";
    public static final String MURO = "\uD83E\uDDF1";
    private static final String GEMA = "\uD83D\uDC8E";

    /*
    public static void main(String[] args) {
        String[][] escenario = creaEscenario();
        for ( int i = 0 ; i < escenario.length ; i++ ) {
            for ( int j = 0 ; j < escenario[i].length ; j++ ) {
                System.out.print( escenario[i][j] );
            }
            System.out.println();
        }
        System.out.println( escenario[0].length );
        System.out.println( "Hola" );
        System.out.println( "Es valido el punto? " + esUnPuntoDelEscenario( escenario, 2, 5 ) );
        System.out.println( "Hay Gema? " + hayGema( escenario, 2, 5 ) );
        System.out.println( escenario[2][5] );

        //Vaciar celda
        System.out.println( escenario[1][1] );
        vaciarCelda( escenario, 1, 1 );
        System.out.println( escenario[1][1] );


        System.out.println( quedanGemas( escenario ) );
    }

    /**
     * Crea y devuelve el escenario inicial del juego. Dispones de un ejemplo de
     * definición aquí
     */
    public static String[][] creaEscenario() {
        return new String[][]{
                {MURO, MURO, MURO, MURO, MURO, MURO, MURO},
                {MURO, NADA, NADA, NADA, NADA, NADA, MURO},
                {MURO, NADA, NADA, MURO, NADA, GEMA, MURO},
                {MURO, NADA, GEMA, MURO, MURO, NADA, MURO},
                {MURO, NADA, NADA, NADA, NADA, NADA, MURO},
                {MURO, MURO, MURO, MURO, MURO, MURO, MURO}
        };
    }

    /**
     * Retorna true si la coordenada x,y pertenece a una posición del escenario dado.
     */
    public static boolean esUnPuntoDelEscenario(String[][] escenario, int x, int y) {
        return x >= 0 && x < escenario.length && y >= 0 && y < escenario[0].length;
    }

    /**
     * Determina si la celda de la posición (x,y) del escenario es válida para ser pisada por un personaje.
     * La celda podrá ser pisada si:
     * - La coordenada x,y pertenece al escenario
     * - En la celda de la posición (x,y) no hay un MURO
     * Retorna true si está permitido el paso a un personaje / false en caso contrario
     */
    public static boolean estaPermitidoElPaso(String[][] escenario, int x, int y) {
        if ( esUnPuntoDelEscenario( escenario, x, y ) ) {
            if ( !escenario[x][y].equals( MURO ) ) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determina si en la celda de la posición (x,y) del escenario hay una gema.
     * Retorna: true si en la celda hay una gema / false si no la hay o bien si la coordenada (x,y) no pertenece a una posición del escenario
     */
    public static boolean hayGema(String[][] escenario, int x, int y) {
        if ( !esUnPuntoDelEscenario( escenario, x, y ) ) {
            return false;
        }
        return escenario[x][y].equals( GEMA );
    }

    /**
     * Vacía el contenido de la celda de la posición (x,y) del escenario. Una celda queda vacía si contiene un objeto NADA en su interior.
     * La celda no se verá modificada si:
     * - La coordenada (x,y) no pertenece a una posición al escenario
     */
    public static void vaciarCelda(String[][] escenario, int x, int y) {
        if ( esUnPuntoDelEscenario( escenario, x, y ) ) {
            escenario[x][y] = NADA;
        }
    }

    /**
     * Determina si en el escenario queda alguna gema sin recoger
     */
    public static boolean quedanGemas(String[][] escenario) {
        for ( String[] fila : escenario ) {
            for ( String columnaYFilaDato : fila ) {
                if ( columnaYFilaDato.equals( GEMA ) ) {
                    return true;
                }
            }
        }
        return false;
    }
}