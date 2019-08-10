/**
 * Authors:
 * Roberto Mestas Palafox
 * Erik Jesús Delgado Hernández
 * Armando Cifuentes González
 */

package main.app;

public class Registros {
    private double precio;
    private int cantidad;
    private int cantFalt;

    public Registros(double precio, int cantidad) {
        setPrecio(precio);
        setCantidad(cantidad);
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setCantidad(int cantidad) {
        if (cantidad >= 0) {
            this.cantidad = cantidad;
        } else {
            this.cantidad = 0;
            this.cantFalt += Math.abs(cantidad);
        }
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public int getCantFalt() {
        return this.cantFalt;
    }
}