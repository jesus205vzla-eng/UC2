
package interfaces;

import excepciones.ListException;
import java.util.Iterator;

public interface Ilist <T> {
    
    public void append(T o) throws ListException;
    public void insert(T o, int i) throws ListException;
    public T remove(int i) throws ListException;
    boolean remove(T o);
    int indexOf(T o);
    void clear();
    boolean empty();
    int size();
    T get(int i) throws ListException;
}
