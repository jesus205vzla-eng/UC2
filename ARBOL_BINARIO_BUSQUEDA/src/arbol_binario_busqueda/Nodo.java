
package arbol_binario_busqueda;

public class Nodo {
    private int valor;
    private Nodo izquierda;
    private Nodo derecho;
    
    
    public Nodo (int valor ) {
        this.valor = valor;
        this.izquierda = null;
        this.derecho = null;       
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }
    
}
