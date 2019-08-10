/**
 * Authors:
 * Roberto Mestas Palafox
 * Erik Jesús Delgado Hernández
 * Armando Cifuentes González
 */

package main.app;

import java.util.PriorityQueue;

public class Main {

    static Inventario inv = Inventario.getInstance();
    public static void main(String args[]) {
        System.out.println("Bienvenido a la tienda");

        PriorityQueue<Cliente> priorityQueue = new PriorityQueue<Cliente>();
        priorityQueue.add(new Cliente("Jesus", 7, 30, 30, 30, 30, 0));
        priorityQueue.add(new Cliente("Carlos", 3, 40, 40, 0, 0, 0));
        priorityQueue.add(new Cliente("Isaac", 15, 20, 0, 0, 0, 0));
        priorityQueue.add(new Cliente("Diego", 14, 100, 100, 100, 100, 0));
        //priorityQueue.add(new Cliente("Blanca", 3, 20, 20, 20, 20, 20));

        inventario();
        
        int n = 1;
        int dias = 1;

        while(!priorityQueue.isEmpty()) {
            System.out.println("\n\nCLIENTE #" + n);

            Cliente cliente = priorityQueue.remove();

            System.out.println(cliente);

            n++;
            actualizarInventario(cliente);
            inventario();

            if (inv.getTable().get("Laptop").getCantFalt() > 0 || inv.getTable().get("Monitor").getCantFalt() > 0 
                    || inv.getTable().get("Teclado").getCantFalt() > 0 || inv.getTable().get("Mouse").getCantFalt() > 0
                    || inv.getTable().get("Enfriador").getCantFalt() > 0) {
                dias += 7;
            } else {
                dias += 2;
            }

            System.out.println("\nDIAS ESTIMADOS PARA LA ENTREGA: " + dias + " dias");
            
            if (cliente.getDias() < dias) {
                System.out.println("Disculpe la tardanza, se le aplicara un 5% descuento a su pedido" +
                "\nPRECIO TOTAL NUEVO: " + (cliente.getTotal() - (cliente.getTotal() * 0.05)) );
            }
        }
    }

    public static void actualizarInventario(Cliente cliente) {
        inv.getTable().get("Laptop").setCantidad(inv.getTable().get("Laptop").getCantidad() - cliente.getLaptops());
        inv.getTable().get("Monitor").setCantidad( inv.getTable().get("Monitor").getCantidad() - cliente.getMonitores());
        inv.getTable().get("Teclado").setCantidad( inv.getTable().get("Teclado").getCantidad() - cliente.getTeclados());
        inv.getTable().get("Mouse").setCantidad( inv.getTable().get("Mouse").getCantidad() - cliente.getMouse());
        inv.getTable().get("Enfriador").setCantidad( inv.getTable().get("Enfriador").getCantidad() - cliente.getEnfriadores());
    }

    public static void inventario() {
        if (inv.getTable().get("Laptop").getCantFalt() > 0) {
            System.out.println("\nINVENTARIO\nNo hay suficientes laptops en el inventario");
            System.out.println("Laptops faltantes: " + inv.getTable().get("Laptop").getCantFalt());
        } else {
            System.out.println("\nINVENTARIO\nLaptops: " + inv.getTable().get("Laptop").getCantidad());
        }

        if (inv.getTable().get("Monitor").getCantFalt() > 0) {
            System.out.println("No hay suficientes monitores en el inventario");
            System.out.println("(Monitores faltantes: " + inv.getTable().get("Monitor").getCantFalt());
        } else {
            System.out.println("Monitores: " + inv.getTable().get("Monitor").getCantidad());
        }

        if (inv.getTable().get("Teclado").getCantFalt() > 0) {
            System.out.println("No hay suficientes teclados en el inventario");
            System.out.println("(Teclados faltantes: " + inv.getTable().get("Teclado").getCantFalt());
        } else {
            System.out.println("Teclados: " + inv.getTable().get("Teclado").getCantidad());
        }

        if (inv.getTable().get("Mouse").getCantFalt() > 0) {
            System.out.println("No hay suficientes mouses en el inventario");
            System.out.println("(Mouses faltantes: " + inv.getTable().get("Mouse").getCantFalt());
        } else {
            System.out.println("Mouses: " + inv.getTable().get("Mouse").getCantidad());
        }

        if (inv.getTable().get("Enfriador").getCantFalt() > 0) {
            System.out.println("No hay suficientes enfriadores en el inventario");
            System.out.println("(Enfriadores faltantes: " + inv.getTable().get("Enfriador").getCantFalt());
        } else {
            System.out.println("Enfriadores: " + inv.getTable().get("Enfriador").getCantidad());
        }
    }
}