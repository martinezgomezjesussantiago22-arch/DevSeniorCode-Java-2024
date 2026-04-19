package clase31.code;

import java.util.concurrent.ConcurrentLinkedQueue;

public class UsoColeccionesConcurrentes {
    public static void main(String[] args) {
        // Crear una cola concurrente
        var mensajes = new ConcurrentLinkedQueue<String>();

        // Productores: hilos que añaden mensajes
        Thread productor1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                mensajes.add("Mensaje de Productor 1: " + i);
                System.out.println("Productor 1 añadió: Mensaje " + i);
            }
        });

        Thread productor2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                mensajes.add("Mensaje de Productor 2: " + i);
                System.out.println("Productor 2 añadió: Mensaje " + i);
            }
        });

        // Consumidor: un hilo que consume mensajes
        Thread consumidor = new Thread(() -> {
            while (true) {
                String mensaje = mensajes.poll();
                if (mensaje != null) {
                    System.out.println("Consumidor procesó: " + mensaje);
                }

                // Salir cuando no haya más mensajes
                if (mensajes.isEmpty() && !productor1.isAlive() && !productor2.isAlive()) {
                    break;
                }
            }
        });

        // Ejecutar los hilos
        productor1.start();
        productor2.start();
        consumidor.start();
    }

}
