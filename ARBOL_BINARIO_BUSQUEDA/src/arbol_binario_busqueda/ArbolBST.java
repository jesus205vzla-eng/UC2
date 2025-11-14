
package arbol_binario_busqueda;

public class ArbolBST {
        private Nodo raiz; // Nodo raíz del árbol

    /**
     * Constructor que inicializa un árbol vacío.
     */
    public ArbolBST() {
        this.raiz = null;
    }

    /**
     * Inserta un valor en el árbol.
     * @param valor El valor entero a insertar.
     */
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    /**
     * Inserta recursivamente un valor en el árbol.
     */
    private Nodo insertarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            System.out.println("INSERTAR(" + valor + ") nuevo nodo");
            return new Nodo(valor);
        }

        if (valor == nodo.getValor()) {
            System.out.println("VALOR DUPLICADO(" + valor + ") NO SE INSERTO EL VALOR.");
            return nodo;
        }

        if (valor < nodo.getValor()) {
            nodo.setIzquierda(insertarRecursivo(nodo.getIzquierda(), valor));
        } else {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), valor));
        }

        return nodo;
    }

    /**
     * Busca un valor en el árbol.
     * @param valor El valor a buscar.
     * @return true si se encuentra, false si no.
     */
    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) return false;
        if (valor == nodo.getValor()) return true;
        return valor < nodo.getValor()
            ? buscarRecursivo(nodo.getIzquierda(), valor)
            : buscarRecursivo(nodo.getDerecho(), valor);
    }

    /**
     * Elimina un valor del árbol.
     * @param valor El valor a eliminar.
     */
    public void eliminar(int valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }

    private Nodo eliminarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) return null;

        if (valor < nodo.getValor()) {
            nodo.setIzquierda(eliminarRecursivo(nodo.getIzquierda(), valor));
        } else if (valor > nodo.getValor()) {
            nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), valor));
        } else {
            // Caso 1: sin hijos
            if (nodo.getIzquierda() == null && nodo.getDerecho() == null) return null;

            // Caso 2: un hijo
            if (nodo.getIzquierda() == null) return nodo.getDerecho();
            if (nodo.getDerecho() == null) return nodo.getIzquierda();

            // Caso 3: dos hijos
            int sucesorValor = encontrarMinimoValor(nodo.getDerecho());
            nodo.setValor(sucesorValor);
            nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), sucesorValor));
        }

        return nodo;
    }

    /**
     * Encuentra el valor mínimo en un subárbol.
     */
    private int encontrarMinimoValor(Nodo nodo) {
        while (nodo.getIzquierda() != null) {
            nodo = nodo.getIzquierda();
        }
        return nodo.getValor();
    }

    /**
     * Muestra el recorrido inorden (Izquierda - Raíz - Derecha).
     */
    public void inorden() {
        System.out.print("Recorrido Inorden: ");
        inordenRecursivo(raiz);
        System.out.println();
    }

    private void inordenRecursivo(Nodo nodo) {
        if (nodo == null) return;
        inordenRecursivo(nodo.getIzquierda());
        System.out.print(nodo.getValor() + " ");
        inordenRecursivo(nodo.getDerecho());
    }

    /**
     * Muestra el recorrido preorden (Raíz - Izquierda - Derecha).
     */
    public void preorden() {
        System.out.print("Recorrido Preorden: ");
        preordenRecursivo(raiz);
        System.out.println();
    }

    private void preordenRecursivo(Nodo nodo) {
        if (nodo == null) return;
        System.out.print(nodo.getValor() + " ");
        preordenRecursivo(nodo.getIzquierda());
        preordenRecursivo(nodo.getDerecho());
    }

    /**
     * Muestra el recorrido postorden (Izquierda - Derecha - Raíz).
     */
    public void postorden() {
        System.out.print("Recorrido Postorden: ");
        postordenRecursivo(raiz);
        System.out.println();
    }

    private void postordenRecursivo(Nodo nodo) {
        if (nodo == null) return;
        postordenRecursivo(nodo.getIzquierda());
        postordenRecursivo(nodo.getDerecho());
        System.out.print(nodo.getValor() + " ");
    }

    /**
     * Calcula la altura del árbol.
     * @return Altura como número de niveles.
     */
    public int altura() {
        return alturaRecursiva(raiz);
    }

    private int alturaRecursiva(Nodo nodo) {
        if (nodo == null) return -1;
        int izq = alturaRecursiva(nodo.getIzquierda());
        int der = alturaRecursiva(nodo.getDerecho());
        return Math.max(izq, der) + 1;
    }

    /**
     * Cuenta el total de nodos en el árbol.
     */
    public int contarNodos() {
        return contarNodosRecursivo(raiz);
    }

    private int contarNodosRecursivo(Nodo nodo) {
        if (nodo == null) return 0;
        return 1 + contarNodosRecursivo(nodo.getIzquierda()) + contarNodosRecursivo(nodo.getDerecho());
    }

    /**
     * Encuentra el valor mínimo en el árbol.
     */
    public int encontrarMinimo() {
        if (raiz == null) throw new IllegalStateException("El árbol está vacío");
        Nodo actual = raiz;
        while (actual.getIzquierda() != null) {
            actual = actual.getIzquierda();
        }
        return actual.getValor();
    }

    /**
     * Encuentra el valor máximo en el árbol.
     */
    public int encontraMaximo() {
        if (raiz == null) throw new IllegalStateException("El árbol está vacío");
        Nodo actual = raiz;
        while (actual.getDerecho() != null) {
            actual = actual.getDerecho();
        }
        return actual.getValor();
    }

    /**
     * Verifica si el árbol está vacío.
     */
    public boolean esVacio() {
        return raiz == null;
    }

    /**
     * Devuelve la raíz del árbol (para pruebas).
     */
    public Nodo getRaiz() {
        return raiz;
    }
}

    


