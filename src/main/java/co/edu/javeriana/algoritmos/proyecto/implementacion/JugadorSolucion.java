package co.edu.javeriana.algoritmos.proyecto.implementacion;

import co.edu.javeriana.algoritmos.proyecto.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JugadorSolucion implements Jugador {

    @Override
    public List<Casilla> jugar(Tablero tablero) {
        int[] cantidadPorColor = cantidadColor(tablero);
        int colorMax = colorMaximo(cantidadPorColor, tablero);
        System.out.println("Color mas grande: " + colorMax);
        int contador;
        Boolean posiblesJugadas = false;
        List<Casilla> retornar = new ArrayList<>();
        do {
            contador = 0;
            for (int i = 0; i < tablero.getFilas(); i++) {
                for (int j = 0; j < tablero.getColumnas(); j++) {
                    Casilla casilla = new Casilla(i, j);
                    if (tablero.coloresTablero()[i][j] != colorMax && casillaValida(casilla, tablero)) {
                        tablero.efectuarJugada(casilla);
                        retornar.add(casilla);
                        contador++;
                    } else if (tablero.coloresTablero()[i][j] == colorMax && posiblesJugadas
                            && casillaValida(casilla, tablero)) {
                        tablero.efectuarJugada(casilla);
                        retornar.add(casilla);
                        contador++;
                    }
                }
            }
            if (contador == 0 && posiblesJugadas == false) {
                posiblesJugadas = true;
                contador = 1;
            }
        } while (contador != 0);
        return retornar;
    }

    @Override
    public String identificacionJugador() {
        return "LosCompadres-Mudkip";
    }

    public int colorMaximo(int[] cantidadPorColor, Tablero tablero) { // Gabriel

        int mayor = 0, indice = 0;
        for (int i = 0; i < tablero.getNumeroColores(); i++) {
            if (cantidadPorColor[i] > mayor) {
                indice = i;
                mayor = cantidadPorColor[i];
            }
        }
        return indice;
    }

    public int[] cantidadColor(Tablero tablero) { // Richard
        int[] resp = new int[tablero.getNumeroColores()];
        for (int i = 0; i < tablero.getFilas(); i++) {// filas
            for (int j = 0; j < tablero.getColumnas(); j++) {// columnas
                for (int k = 0; k < tablero.getNumeroColores(); k++) {
                    if (k == tablero.coloresTablero()[i][j]) {
                        resp[k]++;
                    }
                }
            }
        }
        return resp;
    }

    public boolean casillaValida(Casilla casilla, Tablero tablero) { // Juan Diego
        // Obtener la posici'on de la casilla
        int fila = casilla.getFila();
        int columna = casilla.getColumna();
        // Verificar los l'imites de la casilla
        if (fila < 0 || columna < 0 || fila >= tablero.getFilas() || columna >= tablero.getColumnas()) {
            return false;
        }
        if (tablero.coloresTablero()[fila][columna] == -1)
            return false;
        // Si la casilla es valida verificar vecinos, si al menos un vecino es del mismo
        // color, se retorna verdadero
        int colorActual = tablero.colorCasilla(fila, columna);
        // Vecino izquierdo, [i][j - 1]
        // Se verifica que la casilla actual no esté en la primera columna
        if (columna > 0 && colorActual == tablero.coloresTablero()[fila][columna - 1]) {
            // System.out.print("<");
            return true;
        }
        // Vecino derecho [i][j + 1]
        // Se verifica que la columna no sea la última
        if (columna < tablero.getColumnas() - 1 && colorActual == tablero.coloresTablero()[fila][columna + 1]) {
            // System.out.print(">");
            return true;
        }
        // Vecino superior, [i - 1][j]
        // Se verifica que la casilla actual no esté en la primera fila
        if (fila > 0 && colorActual == tablero.coloresTablero()[fila - 1][columna]) {
            // System.out.print("^");
            return true;
        }
        // Vecino inferior, [i + 1][j]
        if (fila < tablero.getFilas() - 1 && colorActual == tablero.coloresTablero()[fila + 1][columna]) {
            // System.out.print("v");
            return true;
        }
        // Si no encuentra ninguna coincidencia, la casilla no tiene vecinos del mismo
        // color
        return false;
    }
}
