
package arbol_binario_busqueda;

public class Estudiante implements Comparable<Estudiante>{
    private String nombre;
    private int calificacion;
    
    public Estudiante ( String nombre , int calificacion ) {
        if ( calificacion < 0 || calificacion > 100) {
        throw new IllegalArgumentException (
        " Calificacion debe estar entre 0 y 100") ;
        }
    this . nombre = nombre ;
    this . calificacion = calificacion ;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public int compareTo(Estudiante otro) {
        return Integer.compare(this.calificacion,
                                    otro.calificacion);
    }
    
    @Override
     public String toString () {
         return nombre + ": " + calificacion ;
     }
}
