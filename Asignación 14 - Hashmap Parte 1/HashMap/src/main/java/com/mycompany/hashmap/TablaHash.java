package com.mycompany.hashmap;

import java.util.LinkedList;

/*
IMPLEMENTACION DE LA TABLA HASH CON ENCADENAMIENTO SEPARADO
SOPORTA TIPOS GENERICOS Y RENDIMIENTO DINAMICO
*/
public class TablaHash<K, V> implements Diccionario<K, V>  {

    // CLASE INTERNA NODO
    private class Nodo<K, V> {
        K key;
        V value;

        public Nodo(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // ATRIBUTOS PRINCIPALES
    private LinkedList<Nodo<K, V>>[] tabla; // ARREGLO DE LISTAS (BUCKETS)
    private int size;                       // CANTIDAD DE ELEMENTOS ALMACENADO
    private int capacidad;                  // TAMAÑO DEL ARREGLO
    private static final double FACTOR_CARGA_MAX = 0.75;

    /*
    CONSTRUCTOR POR DEFECTO
    INICIALIZA LA TABLA CON CAPACIDAD DE 11 (NUMERO PRIMO)
    */
    @SuppressWarnings("unchecked")
    public TablaHash() {
        this.capacidad = 11;
        this.tabla = new LinkedList[capacidad];
        this.size = 0;

        // INICIALIZA CADA POSICION DEL ARREGLO
        for (int i = 0; i < capacidad; i++) {
            tabla[i] = new LinkedList<>();
        }
    }

    /*
    CALCULA EL INDICE HAS PARA UNA CLAVE MANEJA CORRECTAMENTE 
    LOS HASHCODES NEGATIVOS
    
    PARAM KEY LA CLAVE A PROCESAR
    RETURN INDICE VALIDO EN [0, CAPACIDAD -1 ]
    */
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % capacidad;
    }

    /*
     * INSERTA UN PAR CLAVE-VALOR EN LA TABLA HASH
     * SI LA CLAVE YA EXISTE, ACTUALIZA SU VALOR
     * VERIFICA AUTOMATICAMENTE EL FACTOR DE CARGA Y RENDIMIENTO SI ES NECESARIO 
     *
     * COMPLEJIDAD: 0(1) PROMEDIO, O(N) SI SE REQUIERE RESIZE 
    */
    public void put(K key, V value) {
        if (key == null) throw new NullPointerException("La clave no puede ser null");

        int indice = hash(key);
        LinkedList<Nodo<K, V>> lista = tabla[indice];

        for (Nodo<K, V> nodo : lista) {
            if (nodo.key.equals(key)) {
                nodo.value = value;
                return;
            }
        }

        lista.add(new Nodo<>(key, value));
        size++;

        if ((double) size / capacidad >= FACTOR_CARGA_MAX) {
            resize();
        }
    }

    /*
    RECUPERA EL VALOR ASOCIADO A UNA CLAVE
    
    key La clave a buscar KEY LA CLAVE A BUSCAR
    EL VALOR ASOCIADO, O NULL SI NO EXISTE
     */
    public V get(K key) {
        int indice = hash(key);
        LinkedList<Nodo<K, V>> lista = tabla[indice];

        for (Nodo<K, V> nodo : lista) {
            if (nodo.key.equals(key)) {
                return nodo.value;
            }
        }
        return null;
    }

    
    //ELIMINA UN PAR CLAVE-VALOR DE LA TABLA 

    public V remove(K key) {
        int indice = hash(key);
        LinkedList<Nodo<K, V>> lista = tabla[indice];

        for (int i = 0; i < lista.size(); i++) {
            Nodo<K, V> nodo = lista.get(i);
            if (nodo.key.equals(key)) {
                lista.remove(i);
                size--;
                return nodo.value;
            }
        }
        return null;
    }

    /*
    VERIFICA SI UNA CLAVE EXISTE EN LA TABLA
    
    key La clave a verificar KEY LA CLAVE A VERIFICAR
    TRUE SI EXISTE, FALSE EN CASO CONTRARIO
     */
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    /*
    RETORNA LA CANTIDAD DE ELEMENTO ALMANCENADOS 
    EL TAMAÑO ACTUAL DE LA TABLA
     */
    public int size() {
        return size;
    }

    /*
    REDIMENTSIONA LA TABLA HAS CUANDO EL FACTOR DE CARGA SUPERA EL UMBRAL 
    DUPLICA LA CAPACIDAD Y REUBICA TODOS LOS ELEMENTOS
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        LinkedList<Nodo<K, V>>[] tablaVieja = tabla;
        capacidad = capacidad * 2;
        tabla = new LinkedList[capacidad];

        for (int i = 0; i < capacidad; i++) {
            tabla[i] = new LinkedList<>();
        }

        size = 0;
        for (LinkedList<Nodo<K, V>> bucket : tablaVieja) {
            for (Nodo<K, V> nodo : bucket) {
                put(nodo.key, nodo.value);
            }
        }
    }
    
    
}
