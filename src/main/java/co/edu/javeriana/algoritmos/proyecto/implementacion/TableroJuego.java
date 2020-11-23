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
    Constructor para probar m'etodo casillaValida()
    public TableroJuego() {
        this.tablero = new int[][]{{1, 2, 1, 3, 4}, 
                                   {2, 1, 2, 3, 4}, 
                                   {2, 2, 1, 1, 4},
                                   {4, 3, 2, 1, 2} }; 
        this.Columnas = 5; 
        this.Filas = 4; 
    }
    */

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
        // Verificar vecinos, si al menos un vecino es del mismo color, se retorna verdadero 
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
        // Si no encuentra ninguna coincidencia, la casilla no tiene vecinos del mismo color
        return false; 
    }

    public int vecinosCasilla(int fila, int columna, int[][] visitados, int[][] tablero, int color) { // Gabriel
        if (fila > 3)
            return 0;
        if (columna > 3)
            return 0;
        if (fila < 0)
            return 0;
        if (columna < 0)
            return 0;

        if (visitados[fila][columna] == -1)
            return 0;

        visitados[fila][columna] = -1;

        if (tablero[fila][columna] == color)
            return (1 + (vecinosCasilla(fila, columna + 1, visitados, tablero, color))
                    + (vecinosCasilla(fila, columna - 1, visitados, tablero, color))
                    + (vecinosCasilla(fila + 1, columna, visitados, tablero, color))
                    + (vecinosCasilla(fila - 1, columna + 1, visitados, tablero, color)));

        return 0;
    }

  public void actualizarTablero(int fila, int columna, int color) { // Richard
        if(tablero[fila][columna]!=-1){
	tablero[fila][columna]=-1;
		}
		if(fila>0){
			if(tablero[fila-1][columna] != -1 && color == tablero[fila-1][columna]){
				actualizarTablero(fila-1, columna, color);
			}
		}
		if(fila+1<Filas){
			if(tablero[fila+1][columna] != -1 && color == tablero[fila+1][columna]){
				actualizarTablero(fila+1, columna, color);
			}
		}
		if(columna>0){
			if(tablero[fila][columna-1] != -1 && color == tablero[fila][columna-1]){
				actualizarTablero(fila, columna-1, color);
			}
		}
		if(columna+1<Columnas){
			if(tablero[fila][columna+1] != -1 && color == tablero[fila][columna+1]){
				actualizarTablero(fila, columna+1, color);
			}
		}

    }

    public void correrIzquierda() { // Richard
        boolean correr= false;
		for(int j = 0; j < Columnas-1; j++){//TAL VEZ COLMAX-1
			correr = true;
			for(int i = 0; i < Filas; i++){		
				if(tablero[i][j]!=-1){
					correr = false;
					break;
				}
			}
			if(correr){
          for(int i = 0; i < Filas; i++){
             tablero[i][j]= tablero[i][j+1];
             tablero[i][j+1]=-1;	
				}
			}
		}
    }

  public void correrAbajo() { // Richard
        boolean bandera = true;
		while(bandera){
			bandera = false;
			for(int j = 0; j < Columnas; j++){
				for (int i = 0; i <Filas-1; i++) {
           if(tablero[i][j]==-1 && tablero[i-1][j]!=-1){
               tablero[i][j]=tablero[i-1][j];
               tablero[i-1][j]=-1;
              }
				}
			}
		}
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

  public int []cantidadColor() { // Richard
     int []resp=new int[NumeroColores];
         for (int i = 0; i < tablero.length; i++) {//filas
            for (int j = 0; j < tablero[i].length; j++) {//columnas
              for(int k=0;k<NumeroColores;k++){
                  if(k==tablero[i][j]){
                  resp[k]++;
                  }  
              }   
            }
        }
         return resp;
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
        int n = (int)(Math.random() * (maximo - minimo + 1) + minimo);
        int m = (int)(Math.random() * (maximo - minimo + 1) + minimo);
        System.out.println("n {" + n + "}  m {" + m + "}"); 
        // Generar un numero aleatorio de colores para el tablero entre 4 y el numero de casillas 
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
                tablero[i][j] = (int)(Math.random() * (maximo - minimo + 1) + minimo); 
            }
        }
        // Imprimir tablero 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(tablero[i][j] + " " ); 
            }
            System.out.println(); 
        }

    }

}
