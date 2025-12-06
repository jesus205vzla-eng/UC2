package com.mycompany.hashmap;

public class TestTablaHash {
    public static void main(String[] args) {
        TablaHash<String, Integer> mapa = new TablaHash<>();

        mapa.put("manzana", 5);
        mapa.put("pera", 3);
        mapa.put("manzana", 10);

        System.out.println("Valor de manzana: " + mapa.get("manzana")); // 10
        System.out.println("Contiene 'pera'? " + mapa.containsKey("pera")); // TRUE
        System.out.println("Size: " + mapa.size()); // 2

        mapa.remove("pera");
        System.out.println("Contiene 'pera'? " + mapa.containsKey("pera")); // FALSE
        System.out.println("Size: " + mapa.size()); // 1
    }
}



