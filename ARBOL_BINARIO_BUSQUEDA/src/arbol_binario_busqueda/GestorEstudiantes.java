
package arbol_binario_busqueda;


public class GestorEstudiantes {
    private ArbolBSTGenerico < Estudiante > arbol ;
    
    public GestorEstudiantes () {
        arbol = new ArbolBSTGenerico < >() ;
    }
     public void agregarEstudiante ( String nombre ,
     int calificacion ) {
     Estudiante estudiante = new Estudiante (
     nombre , calificacion ) ;
     arbol . insertar ( estudiante ) ;
     System . out . println (" Estudiante agregado : " +
     estudiante ) ;
     }
     
     public void mostrarEstudiantes () {
     System . out . println ("\n=== Estudiantes ordenados " + "por calificacion ===") ;
     arbol . inorden () ;
     }
     
    public void estudiantesEnRango (int min , int max ) {
        System.out.println("\nEstudiantes con calificación entre " + min + " y " + max + ":");
        mostrarEnRangoRecursivo(arbol.getRaiz(), min, max);
     }
     
    private void mostrarEnRangoRecursivo(NodoGenerico<Estudiante> nodo, int min, int max) {
        if (nodo == null) return;
        Estudiante est = nodo.getValor();
    
        // Recorrer subárbol izquierdo si puede haber valores menores
        if (est.getCalificacion() > min) {
        mostrarEnRangoRecursivo(nodo.getIzquierda(), min, max);
        }

        // Mostrar si está dentro del rango
        if (est.getCalificacion() >= min && est.getCalificacion() <= max) {
        System.out.println(est);
        }

        // Recorrer subárbol derecho si puede haber valores mayores
        if (est.getCalificacion() < max) {
        mostrarEnRangoRecursivo(nodo.getDerecha(), min, max);
        }
    }
    


    /**
    * Calcula el promedio de todas las calificaciones
    * @return El promedio
    */
    
    public double promedioCalificaciones () {
        ResultadoAcumulado resultado = new ResultadoAcumulado();
        acumularCalificaciones(arbol.getRaiz(), resultado);

    if (resultado.contador == 0) {
        throw new IllegalStateException("No hay estudiantes en el árbol");
    }

    return (double) resultado.suma / resultado.contador;
}

    /**
    * Clase auxiliar para acumular suma y conteo
    */
    
    private static class ResultadoAcumulado {
        int suma = 0;
        int contador = 0;
    }

    /**
    * Método recursivo para recorrer el árbol y acumular calificaciones
    */
    
    private void acumularCalificaciones(NodoGenerico<Estudiante> nodo, ResultadoAcumulado resultado) {
        if (nodo == null) return;

         acumularCalificaciones(nodo.getIzquierda(), resultado);

        Estudiante est = nodo.getValor();
        resultado.suma += est.getCalificacion();
        resultado.contador++;

        acumularCalificaciones(nodo.getDerecha(), resultado);
    }
    
    public Estudiante mejorEstudiante () {
        if (arbol.getRaiz() == null) {
            throw new IllegalStateException("No hay estudiantes en el árbol");
        }
        
        NodoGenerico<Estudiante> actual = arbol.getRaiz();
        while (actual.getDerecha() != null) {
        actual = actual.getDerecha();
        }
        return actual.getValor();
    }
    
    public int contarAprobados() {
        return contarAprobadosRecursivo(arbol.getRaiz());
    }
    
    private int contarAprobadosRecursivo(NodoGenerico<Estudiante> nodo) {
        if (nodo == null) return 0;

        int cuentaIzq = contarAprobadosRecursivo(nodo.getIzquierda());
        int cuentaDer = contarAprobadosRecursivo(nodo.getDerecha());

        int aprobado = nodo.getValor().getCalificacion() >= 70 ? 1 : 0;
    
        return cuentaIzq + cuentaDer + aprobado;
    }
}


