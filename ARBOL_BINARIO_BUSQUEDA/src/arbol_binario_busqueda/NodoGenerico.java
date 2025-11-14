
package arbol_binario_busqueda;


public class NodoGenerico<T> {
    
    private T valor;
    private NodoGenerico<T> izquierda;
    private NodoGenerico<T> derecha;

    public NodoGenerico(T valor) {
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }

    public NodoGenerico<T> getIzquierda() {
        return izquierda;
    }

    public NodoGenerico<T> getDerecha() {
        return derecha;
    }

    public void setIzquierda(NodoGenerico<T> izquierda) {
        this.izquierda = izquierda;
    }

    public void setDerecha(NodoGenerico<T> derecha) {
        this.derecha = derecha;
    }
}
