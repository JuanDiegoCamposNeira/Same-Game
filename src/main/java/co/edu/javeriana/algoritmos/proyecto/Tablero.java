/**
 * 
 */
package co.edu.javeriana.algoritmos.proyecto;

/**
 * La implementación que se utilizará dentro del robot la suministraré yo, pero es buena idea
 * que ustedes generen la suya para probar.
 * Prohibido modificar, cambiar de paquete o definir en otro paquete.
 */
public interface Tablero extends Cloneable {

    /**
     * Efectúa una jugada sobre el tablero.
     * 
     * @param jugada La jugada a realizar
     * @return puntaje de la jugada
     * @throws IllegalArgumentException si la jugada no es válida
     */
    int efectuarJugada( Casilla jugada ) throws IllegalArgumentException;
    
    /**
     * Simula una jugada sobre el tablero sin cambiarlo.
     * 
     * @param jugada La jugada a simular
     * @return puntaje de la jugada
     * @throws IllegalArgumentException si la jugada no es válida
     */
    int simularJugada( Casilla jugada ) throws IllegalArgumentException;
	
    /**
     * 
     * @return el número de colores que tiene el juego.
     */
    int getNumeroColores();
    
    int getFilas();
    
    int getColumnas();
	
    /**
     * Retorna el color de la casilla identificada por los parámetros.  Si la casilla está vacía, retorna -1.
     * @param i fila de la casilla
     * @param j columna de la casilla
     * @return el color de la casilla
     */
    int colorCasilla( int i, int j );
	
    /**
     * 
     * @return una matriz con todos los colores.  Las casillas vacías tienen valor -1.
     */
    int[][] coloresTablero();
    
}
