package com.mycompany.hashmap;


// SIMULADOR DE ROUTER QUE PROCESA PAQUETES USANDO LA TABLA DE RUTEO
public class SimuladorRouter {
    private TablaRuteo tablaRuteo;

    public SimuladorRouter() {
        this.tablaRuteo = new TablaRuteo();
        inicializarRutas();
    }

    
 
    //INICIALIZA LA TABLA CON RUTAS TIPICAS DE UN ROUTER EMPRESARIAL
    private void inicializarRutas() {
        tablaRuteo.agregarRuta(new Ruta("0.0.0.0/0", "0.0.0.0",
                "200.100.50.1", "eth0", 10, "STATIC"));

        tablaRuteo.agregarRuta(new Ruta("192.168.1.0/24", "255.255.255.0",
                "0.0.0.0", "eth1", 0, "CONNECTED"));

        tablaRuteo.agregarRuta(new Ruta("10.0.0.0/8", "255.0.0.0",
                "192.168.1.254", "eth1", 20, "OSPF"));

        tablaRuteo.agregarRuta(new Ruta("172.16.0.0/16", "255.255.0.0",
                "192.168.1.253", "eth2", 5, "STATIC"));
    }

    

    //SIMULA EL PROCESAMIENTO DE PAQUETES ENTRANTES
    public void procesarPaquetes() {
        String[] paquetesEntrantes = {
                "192.168.1.50",
                "10.5.3.2",
                "172.16.10.5",
                "8.8.8.8",
                "192.168.2.1",
                "10.0.0.1"
        };

        System.out.println("========================================");
        System.out.println("SIMULADOR DE ROUTER - FORWARDING");
        System.out.println("========================================\n");

        for (String ipDestino : paquetesEntrantes) {
            Ruta ruta = tablaRuteo.buscarRuta(ipDestino);

            if (ruta != null) {
                System.out.printf("Paquete -> %s%n", ipDestino);
                System.out.printf("Ruta encontrada: %s%n", ruta.getRedDestino());
                System.out.printf("Next Hop: %s%n", ruta.getNextHop());
                System.out.printf("Interfaz salida: %s%n", ruta.getInterfaz());
                System.out.printf("Protocolo: %s (metrica: %d)%n",
                        ruta.getProtocolo(), ruta.getMetrica());
                System.out.printf("ACCION: FORWARD%n%n");
            } else {
                System.out.printf("Paquete -> %s%n", ipDestino);
                System.out.printf("ACCION: DROP (No route to host)%n%n");
            }
        }

        tablaRuteo.imprimirEstadisticas();
    }

    public static void main(String[] args) {
        SimuladorRouter router = new SimuladorRouter();
        router.procesarPaquetes();
    }
}