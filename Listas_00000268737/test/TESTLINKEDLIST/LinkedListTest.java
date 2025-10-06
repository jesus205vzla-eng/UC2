
package TESTLINKEDLIST;

import ListasEnlzadas.implementaciones.Listas_Enlazadas;
import excepciones.ListException;
import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListTest {

        public LinkedListTest() {}

    @Test
    public void testAppend_Integer() {

        ListasEnlzadas.implementaciones.Listas_Enlazadas <Integer> intList = new ListasEnlzadas.implementaciones.Listas_Enlazadas<>();
        intList.append(0);
        assertEquals((Integer) 0, intList.get(0));
        assertEquals(1, intList.size());

        intList.append(1);
        assertEquals((Integer) 1, intList.get(1));
        assertEquals(2, intList.size());

        intList.append(2);
        intList.append(3);
        intList.append(4);
        assertEquals(5, intList.size());
    }

    @Test
    public void testInsert_Integer() {
        ListasEnlzadas.implementaciones.Listas_Enlazadas <Integer> intList = new ListasEnlzadas.implementaciones.Listas_Enlazadas<>();
        intList.insert(0, 0);
        assertEquals((Integer) 0, intList.get(0));
        assertEquals(1, intList.size());

        intList.insert(1, 0);
        assertEquals((Integer) 1, intList.get(0));
        assertEquals(2, intList.size());

        intList.insert(2, 1);
        assertEquals((Integer) 2, intList.get(1));
        assertEquals(3, intList.size());

        intList.insert(3, 3);
        assertEquals((Integer) 3, intList.get(3));
        assertEquals(4, intList.size());

        try {
            intList.insert(4, -1);
            fail("Se esperaba ListException");
        } catch (ListException e) {}

        try {
            intList.insert(5, 5);
            fail("Se esperaba ListException");
        } catch (ListException e) {}
    }

    @Test
    public void testGet_Integer() {
        ListasEnlzadas.implementaciones.Listas_Enlazadas <Integer> intList = new ListasEnlzadas.implementaciones.Listas_Enlazadas<>();
        try {
            intList.get(0);
            fail("Se esperaba ListException");
        } catch (ListException e) {}

        intList.append(0);
        intList.append(1);
        intList.append(2);
        intList.append(3);
        intList.append(4);

        assertEquals((Integer) 0, intList.get(0));
        assertEquals((Integer) 2, intList.get(2));
        assertEquals((Integer) 4, intList.get(4));

        try {
            intList.get(-1);
            fail("Se esperaba ListException");
        } catch (ListException e) {}

        try {
            intList.get(5);
            fail("Se esperaba ListException");
        } catch (ListException e) {}
    }

    @Test
    public void testRemove_Integer() {
        ListasEnlzadas.implementaciones.Listas_Enlazadas <Integer> intList = new ListasEnlzadas.implementaciones.Listas_Enlazadas<>();
        try {
            intList.remove(0);
            fail("Se esperaba ListException");
        } catch (ListException e) {}

        intList.append(0);
        intList.append(1);
        intList.append(2);
        intList.append(3);
        intList.append(4);

        assertEquals((Integer) 0, intList.remove(0));
        assertEquals(4, intList.size());

        assertEquals((Integer) 3, intList.remove(2));
        assertEquals(3, intList.size());

        assertEquals((Integer) 4, intList.remove(2));
        assertEquals(2, intList.size());

        try {
            intList.remove(-1);
            fail("Se esperaba ListException");
        } catch (ListException e) {}

        try {
            intList.remove(3);
            fail("Se esperaba ListException");
        } catch (ListException e) {}
    }

    @Test
    public void testEmpty_Integer() {
        ListasEnlzadas.implementaciones.Listas_Enlazadas <Integer> intList = new ListasEnlzadas.implementaciones.Listas_Enlazadas<>();
        assertTrue(intList.empty());
        intList.append(0);
        assertFalse(intList.empty());
    }

    @Test
    public void testSize_Integer() {
        ListasEnlzadas.implementaciones.Listas_Enlazadas <Integer> intList = new ListasEnlzadas.implementaciones.Listas_Enlazadas<>();
        assertEquals(0, intList.size());
        intList.append(0);
        assertEquals(1, intList.size());
    }

    @Test
    public void testIterator_Integer() {
        ListasEnlzadas.implementaciones.Listas_Enlazadas <Integer> intList = new ListasEnlzadas.implementaciones.Listas_Enlazadas<>();
        Iterator<Integer> result = intList.iterator();
        assertNotNull(result);
    }

    @Test
    public void testToString_Integer() {
        ListasEnlzadas.implementaciones.Listas_Enlazadas <Integer> intList = new ListasEnlzadas.implementaciones.Listas_Enlazadas<>();
        assertEquals("[]", intList.toString());

        intList.append(0);
        intList.append(1);
        intList.append(2);
        intList.append(3);
        intList.append(4);

        assertEquals("[0, 1, 2, 3, 4]", intList.toString());
    }

    // String tests

    @Test
    public void testAppend_String() {
        ListasEnlzadas.implementaciones.Listas_Enlazadas <String> strList = new ListasEnlzadas.implementaciones.Listas_Enlazadas();
        strList.append("Alma");
        assertEquals("Alma", strList.get(0));
        assertEquals(1, strList.size());

        strList.append("Bernardo");
        assertEquals("Bernardo", strList.get(1));
        assertEquals(2, strList.size());

        strList.append("Clara");
        strList.append("David");
        strList.append("Eva");
        assertEquals(5, strList.size());
    }

    @Test
    public void testInsert_String() {
        ListasEnlzadas.implementaciones.Listas_Enlazadas <String> strList = new ListasEnlzadas.implementaciones.Listas_Enlazadas();
        strList.insert("Alma", 0);
        assertEquals("Alma", strList.get(0));
        assertEquals(1, strList.size());

        strList.insert("Bernardo", 0);
        assertEquals("Bernardo", strList.get(0));
        assertEquals(2, strList.size());

        strList.insert("Clara", 1);
        assertEquals("Clara", strList.get(1));
        assertEquals(3, strList.size());

        strList.insert("David", 3);
        assertEquals("David", strList.get(3));
        assertEquals(4, strList.size());

        try {
            strList.insert("Eva", -1);
            fail("Se esperaba ListException");
        } catch (ListException e) {}

        try {
            strList.insert("Felipe", 5);
            fail("Se esperaba ListException");
        } catch (ListException e) {}
    }

    @Test
    public void testGet_String() {
        ListasEnlzadas.implementaciones.Listas_Enlazadas <String> strList = new ListasEnlzadas.implementaciones.Listas_Enlazadas();
        try {
            strList.get(0);
            fail("Se esperaba ListException");
        } catch (ListException e) {}

        strList.append("Alma");
        strList.append("Bernardo");
        strList.append("Clara");
        strList.append("David");
        strList.append("Eva");

        assertEquals("Alma", strList.get(0));
        assertEquals("Clara", strList.get(2));
        assertEquals("Eva", strList.get(4));

        try {
            strList.get(-1);
            fail("Se esperaba ListException");
        } catch (ListException e) {}

        try {
            strList.get(5);
            fail("Se esperaba ListException");
        } catch (ListException e) {}
    }

    @Test
    public void testRemove_String() {
        ListasEnlzadas.implementaciones.Listas_Enlazadas <String> strList = new ListasEnlzadas.implementaciones.Listas_Enlazadas();
        try {
            strList.remove(0);
            fail("Se esperaba ListException");
        } catch (ListException e) {}

        strList.append("Alma");
        strList.append("Bernardo");
        strList.append("Clara");
        strList.append("David");
        strList.append("Eva");

        assertEquals("Alma", strList.remove(0));
        assertEquals(4, strList.size());

        assertEquals("David", strList.remove(2));
        assertEquals(3, strList.size());

        assertEquals("Eva", strList.remove(2));
        assertEquals(2, strList.size());

        try {
            strList.remove(-1);
            fail("Se esperaba ListException");
        } catch (ListException e) {}

        try {
            strList.remove(3);
            fail("Se esperaba ListException");
        } catch (ListException e) {}
    }

    @Test
    public void testEmpty_String() {
        ListasEnlzadas.implementaciones.Listas_Enlazadas <String> strList = new ListasEnlzadas.implementaciones.Listas_Enlazadas();
        assertTrue(strList.empty());
        strList.append("Alma");
        assertFalse(strList.empty());
    }

    @Test
    public void testSize_String() {
        ListasEnlzadas.implementaciones.Listas_Enlazadas <String> strList = new ListasEnlzadas.implementaciones.Listas_Enlazadas();
        assertEquals(0, strList.size());
        strList.append("Alma");
        assertEquals(1, strList.size());
    }

    @Test
    public void testIterator_String() {
        ListasEnlzadas.implementaciones.Listas_Enlazadas <String> strList = new ListasEnlzadas.implementaciones.Listas_Enlazadas();
        Iterator<String> result = strList.iterator();
        assertNotNull(result);
    }

    @Test
    public void testToString_String() {
        System.out.println("Prueba del metodo toString(), de la clase LinkedList<String>");
        String expResult;
        String result;
        ListasEnlzadas.implementaciones.Listas_Enlazadas <String> strList = new ListasEnlzadas.implementaciones.Listas_Enlazadas();

        // Prueba con una lista vacía
        expResult = "[]";
        result = strList.toString();
        assertEquals(expResult, result);

        // Prueba con elementos
        strList.append("Alma");
        strList.append("Bernardo");
        strList.append("Clara");
        strList.append("David");
        strList.append("Eva");

        expResult = "[Alma, Bernardo, Clara, David, Eva]";
        result = strList.toString();
        assertEquals(expResult, result);
        }

}