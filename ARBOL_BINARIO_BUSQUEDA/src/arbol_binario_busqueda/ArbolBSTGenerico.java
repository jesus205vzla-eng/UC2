
package arbol_binario_busqueda;

public class ArbolBSTGenerico < T extends Comparable<T>> {
    private NodoGenerico<T> raiz;

    public boolean esVacio() {
        return raiz == null;
    }

    public void insertar(T valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private NodoGenerico<T> insertarRecursivo(NodoGenerico<T> nodo, T valor) {
        if (nodo == null) return new NodoGenerico<>(valor);

        if (valor.compareTo(nodo.getValor()) < 0) {
            nodo.setIzquierda(insertarRecursivo(nodo.getIzquierda(), valor));
        } else {
            nodo.setDerecha(insertarRecursivo(nodo.getDerecha(), valor));
        }

        return nodo;
    }

    public void inorden() {
        inordenRecursivo(raiz);
    }

    private void inordenRecursivo(NodoGenerico<T> nodo) {
        if (nodo == null) return;
        inordenRecursivo(nodo.getIzquierda());
        System.out.println(nodo.getValor());
        inordenRecursivo(nodo.getDerecha());
    }

    public NodoGenerico<T> getRaiz() {
        return raiz;
    }
}
