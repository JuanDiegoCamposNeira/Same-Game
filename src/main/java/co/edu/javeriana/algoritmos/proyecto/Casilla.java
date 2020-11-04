/**
 * 
 */
package co.edu.javeriana.algoritmos.proyecto;

/**
 * Clase que representa una jugada.  Prohibido modificar, cambiar de paquete o definir en otro paquete.
 *
 */
public class Casilla 
{
    private int fila;
    private int columna;
    
    public Casilla( int fila, int columna ) 
    {
        super();
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    @Override
    public String toString() {
        return "Casilla [fila=" + fila + ", columna=" + columna + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + columna;
        result = prime * result + fila;
        return result;
    }

    @Override
    public boolean equals( Object obj ) {
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        Casilla other = ( Casilla ) obj;
        if ( columna != other.columna )
            return false;
        if ( fila != other.fila )
            return false;
        return true;
    }
    
}
