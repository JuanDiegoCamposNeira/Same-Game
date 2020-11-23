package co.edu.javeriana.algoritmos.proyecto.implementacion;

import co.edu.javeriana.algoritmos.proyecto.Casilla;

public class Main {

    public static void main(String[] args) {
        // Crear tablero aleatorio
        // Imprimir tablero
        // jugadorSolucion.jugar()
        // Imprimir Lista de casillas

        // Pruebas
        /*
         * Prueba para casillaValida() -> test pasados
         */
        /*
         * TableroJuego tablero = new TableroJuego(); for (int i = 0; i < 4; i++) { for
         * (int j = 0; j < 5; j++) { System.out.print(tablero.casillaValida(new
         * Casilla(i,j)) + " "); } System.out.println(); }
         */

        /**
         * Prueba para vecinosCasilla()
         */
        TableroJuego tablero = new TableroJuego();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(tablero.vecinosCasilla(new Casilla(i, j)) + " ");
            }
            System.out.println();
        }
    }
}
