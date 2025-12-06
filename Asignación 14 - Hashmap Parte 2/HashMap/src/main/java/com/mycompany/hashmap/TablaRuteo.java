package com.mycompany.hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Tabla de ruteo implementada con HashMap personalizado.
*/
public class TablaRuteo {
    private TablaHash<String, Ruta> tabla;
    private int consultasExitosas;
    private int consultasFallidas;

    public TablaRuteo() {
        this.tabla = new TablaHash<>();
        this.consultasExitosas = 0;
        this.consultasFallidas = 0;
    }

    /*
    AGREGA O ACTUALIZA UNA RUTA EN LA TABLA
    APLICA LA LOGICA DE MENOR METRICA (MEJOR RUTA)
    */
    public void agregarRuta(Ruta ruta) {
        String clave = ruta.getRedDestino();

        if (tabla.containsKey(clave)) {
            Ruta rutaExistente = tabla.get(clave);
            if (ruta.getMetrica() < rutaExistente.getMetrica()) {
                tabla.put(clave, ruta);
                System.out.println("[UPDATE] Ruta mejorada: " + clave);
            }
        } else {
            tabla.put(clave, ruta);
            System.out.println("[ADD] Nueva ruta: " + clave);
        }
    }

    /*
    BUSCAR LA RUTA APROPIADA PARA UNA IP DESTINO
    SIMPLIFICADO: BUSCA POR PREFIJO COMUN
    */
    public Ruta buscarRuta(String ipDestino) {
        for (String red : obtenerRedesOrdenadas()) {
            if (ipPerteneceARedSimplificado(ipDestino, red)) {
                consultasExitosas++;
                return tabla.get(red);
            }
        }

        if (tabla.containsKey("0.0.0.0/0")) {
            consultasExitosas++;
            return tabla.get("0.0.0.0/0");
        }

        consultasFallidas++;
        return null;
    }

    
    
    // ELIMINA UNA RUTA DE LA TABLA
    
    public boolean eliminarRuta(String redDestino) {
        if (tabla.containsKey(redDestino)) {
            tabla.remove(redDestino);
            System.out.println("[DELETE] Ruta eliminada: " + redDestino);
            return true;
        }
        return false;
    }

    
    
    // DEVUELVE LAS REDES ORDENANDA POR LONGITUD DE PREFIJO
    private List<String> obtenerRedesOrdenadas() {
        List<String> redes = new ArrayList<>();
        for (int i = 0; i < tabla.size(); i++) {
            
            //EN ESTA VERSION SIMPLIFIACADA DEVOLVEMOS LAS CLAVES
            // EN UNA IMPLEMENTACION REAL SE ORDENA POR LOGITUD DE PREFIJO
        }
        redes.addAll(tablaKeys());
        Collections.sort(redes, (a, b) -> b.length() - a.length());
        return redes;
    }

    private List<String> tablaKeys() {
        List<String> keys = new ArrayList<>();
        // RECORREMOS BUCKETS DE LA TABLAHASH
        // EN ESTA VERSION SIMPLIFICADA ASUMIMOS QUE TENEMOS ACCESOS A LAS CLAVES
        // PUEDES EXTENDER TABLAHASH PARA DEVOLVER UN LISTADO DE CLAVES
        return keys;
    }

    /*
    METOOD SIMPLIFICADO PARA VERIFICAR SI UNA IP PERTENECE A UNA RED
    AQUI SOLO SE COMPRA SI SE EMPIEZA CON EL MISMO PREFIJO
    */
    private boolean ipPerteneceARedSimplificado(String ip, String red) {
        return ip.startsWith(red.split("\\.")[0]);
    }

    
    //IMPRIME ESTADISCTICAS DE LA TABLA DE RUTEO
    
    public void imprimirEstadisticas() {
        System.out.println("========================================");
        System.out.println("ESTADISTICAS DE LA TABLA DE RUTEO:");
        System.out.println("- Total de rutas activas: " + tabla.size());
        System.out.println("- Consultas exitosas: " + consultasExitosas);
        System.out.println("- Consultas fallidas: " + consultasFallidas);
        double tasaExito = consultasExitosas + consultasFallidas == 0 ? 0 :
                (consultasExitosas * 100.0) / (consultasExitosas + consultasFallidas);
        System.out.println("- Tasa de exito: " + tasaExito + " %");
        System.out.println("========================================");
    }
    
    
    
}