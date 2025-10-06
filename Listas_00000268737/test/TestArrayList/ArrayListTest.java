
package TestArrayList;

import listaArreglo.implementaciones.ArrayList;
import excepciones.ListException;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayListTest{
    
    
    
    @Test
    public void testAppendAndGet_String() throws ListException {
    ArrayList<String> lista = new ArrayList<>();
    lista.append("Hola");
    lista.append("QUE HACE");
    assertEquals("Hola", lista.get(0));
    assertEquals("QUE HACE", lista.get(1));
    }
    
    @Test
    public void testAppendAndGet_Integer() throws ListException {
    ArrayList<Integer> lista = new ArrayList<>(); 
    lista.append(10);
    lista.append(20);
    assertEquals(Integer.valueOf(10), lista.get(0));
    assertEquals(Integer.valueOf(20), lista.get(1));
}
}
