/**
 * 
 */
package co.edu.javeriana.algoritmos.proyecto;

import java.util.List;

/**
 * Esta es la interfaz principal que ustedes deberían implementar.  Su implementación DEBE tener una constructora
 * sin parámetros que no lance excepciones.
 * Prohibido modificar, cambiar de paquete o definir en otro paquete.
 */
public interface Jugador {

    /**
     * Recibe el tablero y retorna la mejor lista de jugadas posible.
     * 
     * @param tablero Tablero para jugar
     * @return Lista de jugadas a realizar en el tablero
     */
    List<Casilla> jugar( Tablero tablero );
    
    /**
     * 
     * @return una cadena que sirva para identificar a su jugador.  Sólo se permiten letras y números, la presencia de otros caracteres
     * en esta cadena, o una cadena vacía o nula, pueden ser causal de descalificación.
     */
    String identificacionJugador();
    
}
