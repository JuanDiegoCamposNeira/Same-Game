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
    public TableroJuego() {
        generarTablero();
    }

    /**
     * Métodos
     */
    @Override
    public int efectuarJugada(Casilla jugada) throws IllegalArgumentException {
        // Si la casilla no es valida, arrojar excepción
        if (!this.casillaValida(jugada))
            throw new IllegalArgumentException();

        // De lo contrario, evaluar los vecinos y retornar el puntaje de la jugada
        int vecinos = this.vecinosCasilla(jugada);

        // Calcular el valor de la jugada
        int valorJugada = (int) Math.pow(vecinos - 2, 2);

        // Una vez se calcula la jugada, se actualiza (marcar -1 en cada posicion
        // correspondiente) el tablero
        int fila = jugada.getFila();
        int columna = jugada.getColumna();
        int color = this.colorCasilla(fila, columna);
        this.actualizarTablero(fila, columna, color);

        // Correr las filas y las columnas del tablero
        this.correrAbajo();
        this.correrIzquierda();

        // Retornar el valor de la jugada
        return valorJugada;
    }

    @Override
    public int colorCasilla(int i, int j) {
        return this.tablero[i][j];
    }

    @Override
    public int[][] coloresTablero() {
        return this.tablero;
    }

    // O(1), validación en tiempo constante
    public boolean casillaValida(Casilla casilla) { // Juan Diego
        // Obtener la posici'on de la casilla
        int fila = casilla.getFila();
        int columna = casilla.getColumna();
        // Verificar los l'imites de la casilla
        if (fila < 0 || columna < 0 || fila >= this.Filas || columna >= this.Columnas){
            return false;
        }
        if(this.colorCasilla(fila, columna) == -1)
            return false;
        // Si la casilla es valida verificar vecinos, si al menos un vecino es del mismo
        // color, se retorna verdadero
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

    public void actualizarTablero(int fila, int columna, int color) { // Richard
        if (this.tablero[fila][columna] != -1) {
            this.tablero[fila][columna] = -1;
        }
        if (fila > 0) {
            if (this.tablero[fila - 1][columna] != -1 && color == this.tablero[fila - 1][columna]) {
                actualizarTablero(fila - 1, columna, color);
            }
        }
        if (fila + 1 < Filas) {
            if (this.tablero[fila + 1][columna] != -1 && color == this.tablero[fila + 1][columna]) {
                actualizarTablero(fila + 1, columna, color);
            }
        }
        if (columna > 0) {
            if (this.tablero[fila][columna - 1] != -1 && color == this.tablero[fila][columna - 1]) {
                actualizarTablero(fila, columna - 1, color);
            }
        }
        if (columna + 1 < Columnas) {
            if (this.tablero[fila][columna + 1] != -1 && color == this.tablero[fila][columna + 1]) {
                actualizarTablero(fila, columna + 1, color);
            }
        }

    }

    public void correrIzquierda() { // Richard
        boolean correr = false;
        for (int j = 0; j < Columnas - 1; j++) {// TAL VEZ COLMAX-1
            correr = true;
            for (int i = 0; i < Filas; i++) {
                if (tablero[i][j] != -1) {
                    correr = false;
                    break;
                }
            }
            if (correr) {
                for (int i = 0; i < Filas; i++) {
                    tablero[i][j] = tablero[i][j + 1];
                    tablero[i][j + 1] = -1;
                }
            }
        }
    }

    public void correrAbajo() { // Richard
        boolean bandera = true;
        while (bandera) {
            bandera = false;
            for (int j = 0; j < Columnas; j++) {
                for (int i = Filas-1; i > 0; i--) {
                    if (tablero[i][j] == -1 && tablero[i - 1][j] != -1) {
                        tablero[i][j] = tablero[i - 1][j];
                        tablero[i - 1][j] = -1;
                        bandera=true;
                    }
                }
            }
        }
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
    public void generarTablero() {
        // Generar un n'umero aleatorio entre 2 y 50 para n y m
        int maximo = 49;
        int minimo = 2;
        this.Filas = (int) (Math.random() * (maximo - minimo + 1) + minimo);
        this.Columnas = (int) (Math.random() * (maximo - minimo + 1) + minimo);
        System.out.println("n {" + this.Filas + "}  m {" + this.Columnas + "}");
        // Generar un numero aleatorio de colores para el tablero entre 4 y el numero de
        // casillas
        minimo = 2;
        maximo = (Filas * Columnas) - minimo;
        this.NumeroColores = 5; // Por simplicidad de las pruebas, tendr'a 5 colores
        System.out.println("k {" + this.NumeroColores + "}");

        // Crear el tablero
        
        this.tablero = new int[this.Filas][this.Columnas];
        // Llenar el tablero aleatoriamente
        minimo = 0;
        maximo = this.NumeroColores-1;
        for (int i = 0; i < this.Filas; i++) {
            for (int j = 0; j < this.Columnas; j++) {
                tablero[i][j] = (int) (Math.random() * (maximo - minimo + 1) + minimo);
            }
        }
        // Imprimir tablero
        /*for (int i = 0; i < this.Filas; i++) {
            for (int j = 0; j < this.Columnas; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }*/

    }

    public void imprimirTablero() {
        System.out.println(); 
        for (int i = 0; i < this.Filas; i++) {
            for (int j = 0; j < this.Columnas; j++) { 
                System.out.print(this.tablero[i][j] + " ");
            }
            System.out.println(); 
        }
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public TableroJuego(int Filas, int Columnas, int NumeroColores) {
        this.Filas = Filas;
        this.Columnas = Columnas;
        this.NumeroColores = NumeroColores;
        this.tablero = new int[Filas][Columnas];
    }
    
}
