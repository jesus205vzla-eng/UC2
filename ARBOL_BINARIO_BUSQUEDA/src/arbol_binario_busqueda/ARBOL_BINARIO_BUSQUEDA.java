
package arbol_binario_busqueda;


public class ARBOL_BINARIO_BUSQUEDA {


    public static void main(String[] args) {
       
        System.out.println("=================================");
        System.out.println(" DEMOSTRACIÓN ÁRBOL BST");
        System.out.println("=================================\n");

        // PARTE 1: Pruebas básicas del BST con enteros
        pruebasBST();

        // PARTE 2: Sistema de gestión de estudiantes
        pruebaGestorEstudiantes();
    }

    private static void pruebasBST() {
        System.out.println("--- PRUEBAS BST BÁSICO ---\n");

        ArbolBST arbol = new ArbolBST();

        // Insertar valores
        System.out.println("Insertando valores: 50, 30, 70, 20, 40, 60, 80");
        int[] valores = {50, 30, 70, 20, 40, 60, 80};
        for (int valor : valores) {
            arbol.insertar(valor);
        }

        // Mostrar recorridos
        System.out.println("\nRECORRIDOS:");
        arbol.inorden();
        arbol.preorden();
        arbol.postorden();

        // Búsquedas
        System.out.println("\nBÚSQUEDAS:");
        System.out.println("Buscar 40: " + arbol.buscar(40));
        System.out.println("Buscar 100: " + arbol.buscar(100));

        // Información del árbol
        System.out.println("\nINFORMACIÓN DEL ÁRBOL:");
        System.out.println("Altura: " + arbol.altura());
        System.out.println("Total nodos: " + arbol.contarNodos());
        System.out.println("Mínimo: " + arbol.encontrarMinimo());
        System.out.println("Máximo: " + arbol.encontraMaximo());

        // Eliminaciones
        System.out.println("\nELIMINACIONES:");
        System.out.println("Eliminando 20 (sin hijos)...");
        arbol.eliminar(20);
        arbol.inorden();

        System.out.println("\nEliminando 30 (con hijos)...");
        arbol.eliminar(30);
        arbol.inorden();

        System.out.println("\nEliminando 50 (raíz)...");
        arbol.eliminar(50);
        arbol.inorden();
    }

    private static void pruebaGestorEstudiantes() {
        System.out.println("\n\n--- SISTEMA GESTOR DE ESTUDIANTES ---\n");

        GestorEstudiantes gestor = new GestorEstudiantes();

        // Agregar estudiantes
        gestor.agregarEstudiante("Ana García", 95);
        gestor.agregarEstudiante("Carlos López", 78);
        gestor.agregarEstudiante("María Rodríguez", 88);
        gestor.agregarEstudiante("Juan Martínez", 65);
        gestor.agregarEstudiante("Laura Sánchez", 92);
        gestor.agregarEstudiante("Pedro Gómez", 58);
        gestor.agregarEstudiante("Sofía Torres", 85);

        // Mostrar todos
        gestor.mostrarEstudiantes();

        // Estudiantes en rango
        gestor.estudiantesEnRango(80, 95);

        // Estadísticas
        System.out.println("\nESTADÍSTICAS:");
        System.out.println("Promedio: " + gestor.promedioCalificaciones());
        System.out.println("Mejor estudiante: " + gestor.mejorEstudiante());
        System.out.println("Aprobados: " + gestor.contarAprobados());
    }
    
    
}
