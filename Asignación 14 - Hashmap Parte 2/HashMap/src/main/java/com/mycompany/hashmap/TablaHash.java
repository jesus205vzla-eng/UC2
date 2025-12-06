package com.mycompany.hashmap;

import java.util.LinkedList;

/*
Implementacion de tabla hash con encadenamiento separado
Soporta tipos genericos y redimensionamiento dinamico
*/
public class TablaHash<K, V> implements Diccionario<K, V>  {

    // Clase interna Nodo
    private class Nodo<K, V> {
        K key;
        V value;

        public Nodo(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Atributos principales
    private LinkedList<Nodo<K, V>>[] tabla; // Arreglo de listas (buckets)
    private int size;                       // Cantidad de elementos almacenados
    private int capacidad;                  // Tamano del arreglo
    private static final double FACTOR_CARGA_MAX = 0.75;

    /*
    Constructor por defecto
    Inicializa la tabla con capacidad 11 (numero primo)
    */
    @SuppressWarnings("unchecked")
    public TablaHash() {
        this.capacidad = 11;
        this.tabla = new LinkedList[capacidad];
        this.size = 0;

        // Inicializar cada posicion del arreglo
        for (int i = 0; i < capacidad; i++) {
            tabla[i] = new LinkedList<>();
        }
    }

    /*
    Calcula el indice hash para una clave
    Maneja correctamente hashCodes negativos
    
    param key La clave a procesar
    return Indice valido en [0, capacidad-1]
    */
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % capacidad;
    }

    /*
     * Inserta un par clave-valor en la tabla hash
     * Si la clave ya existe, actualiza su valor
     * Verifica automaticamente el factor de carga y redimensiona si es necesario
     *
     * Complejidad: O(1) promedio, O(n) si se requiere resize
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
    Recupera el valor asociado a una clave.
    
    key La clave a buscar
    El valor asociado, o null si no existe
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

    
    //Elimina un par clave-valor de la tabla

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
    Verifica si una clave existe en la tabla.
    
    key La clave a verificar
    true si existe, false en caso contrario
     */
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    /*
    Retorna la cantidad de elementos almacenados
    
    El tamano actual de la tabla
     */
    public int size() {
        return size;
    }

    /*
    Redimensiona la tabla hash cuando el factor de carga supera el umbral
    Duplica la capacidad y reubica todos los elementos
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
