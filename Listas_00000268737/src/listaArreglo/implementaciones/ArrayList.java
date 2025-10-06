
package listaArreglo.implementaciones;

import excepciones.ListException;
import interfaces.Ilist;
import static java.lang.ModuleLayer.empty;
import java.util.Iterator;

public  class ArrayList <T> implements Ilist<T>, Iterable<T> {

        protected int nElementos;
        private final int tamLista;
        private final T lista[];

        
    
        
  
    
    public void set(int i, T o) throws ListException {
    if (empty())
        throw new ListException("Lista vacía");
    else if (i < 0 || i >= nElementos)
        throw new ListException("Índice fuera de límites");
    lista[i] = o;
    }   
       

    @Override
    public int indexOf(T o) {
    for (int i = 0; i < nElementos; i++) {
        if (lista[i] != null && lista[i].equals(o)) {
            return i;
        }
    }
    return -1;
}

    @Override
    public void clear() {
        for (int i = 0; i < nElementos; i++) {
        lista[i] = null;
        }
    nElementos = 0;
    }

    @Override
    public boolean remove(T o) {
         int index = indexOf(o);
    if (index == -1) return false;
    for (int i = index; i < nElementos - 1; i++) {
        lista[i] = lista[i + 1];
    }
    lista[--nElementos] = null;
    return true;
    }
        
   private class ListIterator<T> implements Iterator<T> {
    private int actual = 0;

        @Override
        public boolean hasNext() {
            return actual < nElementos;
        }

        @Override
        public T next() {
            return (T)lista[actual++];
        }
   }
        public ArrayList(Class<T> tipoDato, int tamLista) {
        this.tamLista = tamLista;
        nElementos = 0;
        lista = (T[]) java.lang.reflect.Array.newInstance(tipoDato, tamLista);
    }   
        
        public ArrayList() {
        this.tamLista = 10; 
        this.nElementos = 0;
        this.lista = (T[]) new Object[tamLista];
    }
        
        @Override
        public void append(T o) throws ListException {
        // Si la lista esta llena, lanza una excepcion
        if (nElementos >= tamLista){
        throw new ListException("Lista llena");
        }
        // Inserta el dato en el nElementos de la lista
        lista[nElementos] = o; 
        nElementos++;
        }
        
        @Override
        public void insert(T o, int i) throws ListException {
        // Si la lista esta llena, lanza una excepcion
        if (nElementos >= tamLista){
        throw new ListException("Lista llena");
        }
        // Si el indice i esta fuera de los limites de los datos
        if(i < 0 || i > nElementos) {
        throw new ListException("Indice fuera de limites");
        }
        for(int j = nElementos; j > i; j--) { 
        lista[j] = lista[j - 1];
        }
        lista[i] = o; //tiene ese error
        nElementos++;
        }
        
       
        public T get(int i) throws ListException {
        // Si la lista esta vacia lanza una excepcion
        if (empty()) {
        throw new ListException("Lista vacia");
        }
        // Si el indice i esta fuera de los limites de los datos
        if(i < 0 || i >= nElementos) { 
        throw new ListException("Indice fuera de limites");
        }
        return lista[i]; //tiene ese error
        }
        
        @Override
        public T remove(int i) throws ListException {
        T o = get(i);
        for(int j = i; j < nElementos - 1; j++) {
        lista[j] = lista[j+1];
        }
        nElementos--; //tiene ese error
        return o;
        }
        
        public boolean empty() {
            return nElementos == 0;
        }
        
        public int size() {
            return nElementos;
        }
        
    /**
     *
     * @return
     */
    @Override
        public Iterator<T> iterator() {
        return new ListIterator();
        }
       
        @Override
        public String toString() {
        String s = "[";
        for(int i = 0; i < nElementos; i++) {
        s += lista[i];
        if(i < nElementos - 1) s += ", ";
}
        s += "]";
        return s;
}
}
        
        

        
        
   

