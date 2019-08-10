/**
 * Authors:
 * Roberto Mestas Palafox
 * Erik Jesús Delgado Hernández
 * Armando Cifuentes González
 */

package main.app;

public class Producto {
    private String tipo;     // product type
    private String marca;
    private String modelo;
    private int cantidad;
    private double subtotal;

    public Producto(String tipo, String marca, String modelo, int cantidad) {
        setTipo(tipo);
        setMarca(marca);
        setModelo(modelo);
        setCantidad(cantidad);
        calcularSubTotales();
    }

    public void calcularSubTotales () {
		Inventario inv = Inventario.getInstance();
        
        this.subtotal = this.cantidad * inv.getTable().get(tipo).getPrecio();
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getSubtotal() {
        return this.subtotal;
    }

    @Override
    public String toString() {

        if (cantidad <= 0) { 
            return "";
        } else {
            return "\n\nProducto: " + this.tipo + "\nCantidad: " + this.cantidad + "\nSubtotal producto: " 
            + this.subtotal + "\nMarca: " + this.marca + "\nModelo: " + this.modelo;
        }
    }
}