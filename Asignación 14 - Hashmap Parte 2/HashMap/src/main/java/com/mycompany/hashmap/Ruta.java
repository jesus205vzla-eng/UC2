package com.mycompany.hashmap;

/*
REPRESENTA UNA RUTA EN LA TABLA DE RUTEO
*/
public class Ruta {
    private String redDestino;     // Ej: "192.168.1.0/24"
    private String mascaraSubred;  // Ej: "255.255.255.0"
    private String nextHop;        // IP DEL SIGUIENTE ROUTER
    private String interfaz;       // INTERFAZ DE SALIDA (ETH0, ETH1, ETC.)
    private int metrica;           // COSTO DE LA RUTA
    private String protocolo;      // STATIC, OSPF, BGP, RIP

    /*
    CONSTRUCUTOR DE LA CLASE RUTA
    */
    public Ruta(String redDestino, String mascaraSubred,
                String nextHop, String interfaz,
                int metrica, String protocolo) {
        this.redDestino = redDestino;
        this.mascaraSubred = mascaraSubred;
        this.nextHop = nextHop;
        this.interfaz = interfaz;
        this.metrica = metrica;
        this.protocolo = protocolo;
    }

    // GETTERS
    public String getRedDestino() { return redDestino; }
    public String getMascaraSubred() { return mascaraSubred; }
    public String getNextHop() { return nextHop; }
    public String getInterfaz() { return interfaz; }
    public int getMetrica() { return metrica; }
    public String getProtocolo() { return protocolo; }

    @Override
    public String toString() {
        return String.format("Ruta: %s via %s interfaz %s protocolo %s metrica %d",
                redDestino, nextHop, interfaz, protocolo, metrica);
    }
    
    
    
}




