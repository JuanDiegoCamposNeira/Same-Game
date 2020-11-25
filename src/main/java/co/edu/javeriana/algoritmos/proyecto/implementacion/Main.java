package co.edu.javeriana.algoritmos.proyecto.implementacion;

import co.edu.javeriana.algoritmos.proyecto.Casilla;
import co.edu.javeriana.algoritmos.proyecto.Jugador;
import co.edu.javeriana.algoritmos.proyecto.Tablero;
import java.util.List;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        
        TableroJuego tablero = new TableroJuego();
        Tablero aux = new TableroJuego(tablero.getFilas(), tablero.getColumnas(), tablero.getNumeroColores());
        for (int i = 0; i < aux.getFilas(); i++) {
            for (int j = 0; j < aux.getColumnas(); j++) {
                aux.coloresTablero()[i][j] = tablero.coloresTablero()[i][j];
            }
        }
        Jugador nosotros = new JugadorSolucion();
        List<Casilla> jugadas = nosotros.jugar(aux);
        int puntaje = 0;
        
        /*for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                System.out.print(tablero.coloresTablero()[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("\n\n");
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                System.out.print(aux.coloresTablero()[i][j] + " ");
            }
            System.out.println("");
        }*/
        
        
        for (Casilla jugada : jugadas) {
            //System.out.println("Jugada:" + jugada.toString());
            puntaje += tablero.efectuarJugada(jugada);
        }
        //tablero.imprimirTablero();
        System.out.println("Puntaje final: " + puntaje);
    }
}
