/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.algoritmos.proyecto.implementacion;

import co.edu.javeriana.algoritmos.proyecto.Casilla;
import co.edu.javeriana.algoritmos.proyecto.Tablero;

/**
 *
 * @author DANIEL MONSALVE
 */
public class TableroJuego implements Tablero{
    
    private int [][] tablero;
    private int Filas;
    private int Columnas;
    private int NumeroColores;
    
    @Override
    public int efectuarJugada(Casilla jugada) throws IllegalArgumentException { // Ultima en implementar
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int colorCasilla(int i, int j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[][] coloresTablero() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public boolean casillaValida(Casilla casilla){ // Juan Diego
        return true;
    }
    public int vecinosCasilla(int fila, int columna, int [][] visitados, int [][] tablero, int color){ // Gabriel
        return 0;
    }
    public void actualizarTablero(int fila, int columna, int color, int [][] tablero){ // Richard
        
    }
    public void correrIzquierda(int [][] tablero){ // Richard
        
    }
    public void correrAbajo(int [][] tablero){ // Richard
        
    }
    public int colorMaximo(int [] cantidadPorColor){ // Gabriel
        return 0;
    }
    public int cantidadColor(int [][] tablero){ // Richard
        return 0;
    }
    
    @Override
    public int simularJugada(Casilla jugada) throws IllegalArgumentException {
        throw new UnsupportedOperationException("No la usamos");
    }

    @Override
    public int getNumeroColores() {
        return NumeroColores;
    }

    @Override
    public int getFilas() {
        return Filas;
    }

    @Override
    public int getColumnas() {
        return Columnas;
    }
}
