/**
 * Authors:
 * Roberto Mestas Palafox
 * Erik Jesús Delgado Hernández
 * Armando Cifuentes González
 */

package main.app;

import java.util.Hashtable;

public class Inventario {
    Hashtable<String, Registros> table = new Hashtable<String, Registros>();
    
    Registros laptop = new Registros(6000.00, 200);
    Registros monitor = new Registros(2500.00, 200);
    Registros teclado = new Registros(500.00, 200);
    Registros mouse = new Registros(400.00, 200);
    Registros enfriador = new Registros(1500.00, 200);

    private static Inventario presetIntance;

    private Inventario() {
        init();
    }

    public void init() {
        table.put("Laptop", laptop);
        table.put("Monitor", monitor);
        table.put("Teclado", teclado);
        table.put("Mouse", mouse);
        table.put("Enfriador", enfriador);
    }

    public Hashtable<String, Registros> getTable() {
        return table;
    }

    public static Inventario getInstance() {
        if(presetIntance == null) {
            presetIntance = new Inventario();
        }

        return presetIntance;
    }
}