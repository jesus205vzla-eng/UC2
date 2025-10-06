
package ListasEnlzadas.implementaciones;

import excepciones.ListException;
import interfaces.Ilist;
import java.util.Iterator;

public class Listas_Enlazadas<T> implements Ilist<T>, Iterable<T> {
            
    protected NodoSimple<T> inicio;
    protected int nElementos;

    @Override
    public boolean remove(T o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(T o) {
        throw new UnsupportedOperationException(); 
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException(); 
    }
      

    private class NodoSimple<T> {
     private T dato;
    private NodoSimple<T> sig;
    
        public NodoSimple(T dato) {
        this.dato = dato;
        }
    }
    
    private class ListIterator<T> implements Iterator<T> {
        private NodoSimple<T> nodoActual;
    
    public ListIterator(NodoSimple<T> inicio) {
        nodoActual = inicio;
        }
    
    
    @Override
    public boolean hasNext() {
        return nodoActual != null;
    }
    
    @Override
    public T next() {
        T dato = nodoActual.dato;
        nodoActual = nodoActual.sig;
        return dato;
        }
    }
    
    public Listas_Enlazadas() {
    inicio = null;
    nElementos = 0;
    }
    
    @Override
    public void append(T o) {
        NodoSimple<T> nodoNuevo = new NodoSimple<>(o);
        NodoSimple<T> nodo = inicio;
        
        if (inicio == null) {
            inicio = nodoNuevo;
        } else {

        while (nodo.sig != null) {
            nodo = nodo.sig;
            }

            nodo.sig = nodoNuevo;
        }
            nElementos++;
        }
    
    @Override
    public void insert(T o, int i) throws ListException {
        NodoSimple<T> nodoNuevo = new NodoSimple<>(o);
            if (i < 0 || i > nElementos) {
                throw new ListException("Indice fuera de limites");
            }
            if (i == 0) {

                if (inicio != null) {

                    nodoNuevo.sig = inicio;
                }
            inicio = nodoNuevo;
            } else {

                NodoSimple<T> nodo = inicio;

                for (int j = 0; j < i - 1; j++) {
                    nodo = nodo.sig;
                }

            nodoNuevo.sig = nodo.sig;

            nodo.sig = nodoNuevo;
            }
        nElementos++;
    }
    
    @Override
    public T get(int i) throws ListException {
        if (empty()) {
                throw new ListException("Lista vacia");
        }
        if (i < 0 || i >= nElementos) {
            throw new ListException("Indice fuera de limites");
        }
        NodoSimple<T> nodo = inicio;
        
        for (int j = 0; j < i; j++) {
            nodo = nodo.sig;
        }

        return nodo.dato;
    }
    
    
    @Override
    public T remove(int i) throws ListException {
    T o;
        if (empty()) {
            throw new ListException("Lista vacia");
        }
        if (i < 0 || i >= nElementos) {
            throw new ListException("Indice fuera de limites");
        }
        if (i == 0) {

         o = inicio.dato;

            inicio = inicio.sig;
        } else {
 
        NodoSimple<T> nodo = inicio;

        for (int j = 0; j < i - 1; j++) {
             nodo = nodo.sig;
            }

            o = nodo.sig.dato;

            nodo.sig = nodo.sig.sig;
            }
        nElementos--;

        return o;
    }
    
    @Override
    public boolean empty() {
        return inicio == null;
    }
    
    @Override
    public int size() {
        return nElementos;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new ListIterator(inicio);
    }
    
    @Override
    public String toString() {
        String s = "[";
        NodoSimple<T> nodo = inicio;
        while (nodo != null) {
            s += nodo.dato;
                if (nodo.sig != null) {
                    s += ", ";
                }   
            nodo = nodo.sig;
        }
        s += "]";
        return s;
        }
}

