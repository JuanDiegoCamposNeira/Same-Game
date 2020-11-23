package co.edu.javeriana.algoritmos.proyecto.implementacion;

import co.edu.javeriana.algoritmos.proyecto.Casilla;
import co.edu.javeriana.algoritmos.proyecto.Tablero;

public class TableroJuego implements Tablero {

    /**
     * Atributos
     */
    private int[][] tablero;
    private int Filas;
    private int Columnas;
    private int NumeroColores;

    /**
     * Constructores
     */
    /*
     * Constructor para probar m'etodo : - casillaValida() - vecinosCasilla()
     */
    public TableroJuego() {
        this.tablero = new int[][] { { 1, 2, 1, 3, 4 }, 
                                     { 2, 1, 2, 3, 4 }, 
                                     { 2, 2, 1, 1, 4 }, 
                                     { 4, 3, 2, 1, 2 } };
        this.Columnas = 5;
        this.Filas = 4;
    }

    /**
     * Métodos
     */
    @Override
    public int efectuarJugada(Casilla jugada) throws IllegalArgumentException { // Ultima en implementar
        return 0;
    }

    @Override
    public int colorCasilla(int i, int j) {
        return this.tablero[i][j];
    }

    @Override
    public int[][] coloresTablero() {
        // TO - DO
        return null;
    }

    // O(1), validación en tiempo constante
    public boolean casillaValida(Casilla casilla) { // Juan Diego
        // Verificar vecinos, si al menos un vecino es del mismo color, se retorna
        // verdadero
        int fila = casilla.getFila();
        int columna = casilla.getColumna();
        int colorActual = this.colorCasilla(fila, columna);
        // Vecino izquierdo, [i][j - 1]
        // Se verifica que la casilla actual no esté en la primera columna
        if (columna > 0 && colorActual == this.tablero[fila][columna - 1]) {
            // System.out.print("<");
            return true;
        }
        // Vecino derecho [i][j + 1]
        // Se verifica que la columna no sea la última
        if (columna < this.Columnas - 1 && colorActual == this.tablero[fila][columna + 1]) {
            // System.out.print(">");
            return true;
        }
        // Vecino superior, [i - 1][j]
        // Se verifica que la casilla actual no esté en la primera fila
        if (fila > 0 && colorActual == this.tablero[fila - 1][columna]) {
            // System.out.print("^");
            return true;
        }
        // Vecino inferior, [i + 1][j]
        if (fila < this.Filas - 1 && colorActual == this.tablero[fila + 1][columna]) {
            // System.out.print("v");
            return true;
        }
        // Si no encuentra ninguna coincidencia, la casilla no tiene vecinos del mismo
        // color
        return false;
    }

    // O(n * m) 
    public int vecinosCasilla(Casilla casilla) { // Gabriel
        // Si la casilla no es valida, quiere decir que no tiene vecinos
        if (!this.casillaValida(casilla))
            return 0;

        // Se crea un arreglo que contiene las posiciones del tablero que ya se
        // visitaron. Al inicio ninguna posici'on se ha visitado
        int[][] visitados = new int[this.Filas][this.Columnas];
        // Si la casilla es valida, contar cuantos vecinos tiene
        int color = this.colorCasilla(casilla.getFila(), casilla.getColumna());
        int cantidadVecinosCasila = vecinosCasillaAux(casilla, color, visitados);
        // Retornar la cantidad de vecinos de la casilla
        return cantidadVecinosCasila;
    }

    // O(n * m)
    public int vecinosCasillaAux(Casilla casilla, int colorComparacion, int[][] visitados) {
        // Obtener la posici'on en el tablero de la casilla
        int fila = casilla.getFila();
        int columna = casilla.getColumna();
        // Verificar que la posici'on de la casilla sea v'alida
        if (fila < 0 || columna < 0 || fila >= this.Filas || columna >= this.Columnas || visitados[fila][columna] == -1)
            return 0;
        // De ser valida la posici'on, marcarla como visitada
        visitados[fila][columna] = -1;
        // Evaluar recursivamente sus vecinos si la casilla es del mismo color
        if (this.colorCasilla(fila, columna) == colorComparacion) {
            int vecinosIzquierda = vecinosCasillaAux(new Casilla(fila, columna - 1), colorComparacion, visitados);
            int vecinosDerecha = vecinosCasillaAux(new Casilla(fila, columna + 1), colorComparacion, visitados);
            int vecinosSuperior = vecinosCasillaAux(new Casilla(fila - 1, columna), colorComparacion, visitados);
            int vecinosInferior = vecinosCasillaAux(new Casilla(fila + 1, columna), colorComparacion, visitados);
            // Retornar la cantidad de vecinos +1, que representa la casilla actual 
            return (1 + vecinosDerecha + vecinosIzquierda + vecinosInferior + vecinosSuperior);
        }
        // Retornar cero si la casilla acutual no tiene el color de colorComparacion
        return 0;
    }

    public void actualizarTablero(int fila, int columna, int color, int[][] tablero) { // Richard
        // TO - DO
    }

    public void correrIzquierda(int[][] tablero) { // Richard
        // TO - DO
    }

    public void correrAbajo(int[][] tablero) { // Richard
        // TO - DO
    }

    public int colorMaximo(int[] cantidadPorColor) { // Gabriel

        int mayor = 0, indice = 0;

        for (int i = 0; i < 10; i++) {
            if (cantidadPorColor[i] > mayor) {
                indice = i;
                mayor = cantidadPorColor[i];
            }
        }

        return indice;
    }

    public int cantidadColor(int[][] tablero) { // Richard
        return 0;
    }

    @Override
    public int simularJugada(Casilla jugada) throws IllegalArgumentException {
        // TO - DO
        return 0;
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

    /**
     * Pruebas para el tablero
     */
    public void generarTableroPrueba() {
        // Generar un n'umero aleatorio entre 2 y 50 para n y m
        int maximo = 49;
        int minimo = 2;
        int n = (int) (Math.random() * (maximo - minimo + 1) + minimo);
        int m = (int) (Math.random() * (maximo - minimo + 1) + minimo);
        System.out.println("n {" + n + "}  m {" + m + "}");
        // Generar un numero aleatorio de colores para el tablero entre 4 y el numero de
        // casillas
        minimo = 4;
        maximo = (n * m) - minimo;
        // int k = (int)(Math.random() * (maximo - minimo + 1) + minimo);
        int k = 5; // Por simplicidad de las pruebas, tendr'a 5 colores
        System.out.println("k {" + k + "}");

        // Crear el tablero
        int tablero[][] = new int[n][m];
        // Llenar el tablero aleatoriamente
        minimo = 1;
        maximo = k;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tablero[i][j] = (int) (Math.random() * (maximo - minimo + 1) + minimo);
            }
        }
        // Imprimir tablero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }

    }

}
