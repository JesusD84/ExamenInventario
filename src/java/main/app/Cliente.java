/**
 * Authors:
 * Roberto Mestas Palafox
 * Erik Jesús Delgado Hernández
 * Armando Cifuentes González
 */

package main.app;

public class Cliente implements Comparable<Cliente> {
    private String nombre;
	private int dias;
	private int laptops;
	private int monitores;
	private int teclados;
	private int mouses;
	private int enfriadores;
	
	private Producto laptop;
	private Producto monitor;
	private Producto teclado;
	private Producto mouse;
	private Producto enfriador;

    private double subtotal;
	private double total;

	public Cliente (String nombre, int dias, int laptops, int monitores,int teclados,int mouses,int enfriadores) {
		setNombre(nombre);
		setDias(dias);
		setLaptops(laptops);
		setMonitores(monitores);
		setTeclados(teclados);
		setMouse(mouses);
		setEnfriadores(enfriadores);
		calcularPrecios();
	}

	public void calcularPrecios () {
		this.laptop = new Producto("Laptop", "HP", "HP2003", laptops);
		this.monitor = new Producto("Monitor", "Samsung", "SM2121", monitores);
		this.teclado = new Producto("Teclado", "Manhatan", "MN2010", teclados);
		this.mouse = new Producto("Mouse", "HP", "Z5000", mouses);
		this.enfriador = new Producto("Enfriador", "Enfriadores Inc", "F4300", enfriadores);
		
		//Calculando subtotal general
		this.subtotal = laptop.getSubtotal() + monitor.getSubtotal() + teclado.getSubtotal() + mouse.getSubtotal() + enfriador.getSubtotal();
		
		//Calculando Total (incluyendo descuentos e IVA)
		if(this.subtotal >= 100000.00 && this.subtotal < 200000.00) {
			this.total = this.subtotal - (this.subtotal * 0.2) + (this.subtotal * 0.16);
		} else if (this.subtotal >= 200000.00) {
			this.total = this.subtotal - (this.subtotal * 0.3) + (this.subtotal * 0.16);
		} else {
			this.total = this.subtotal + (this.subtotal * 0.16);
		}
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
    }
    
    public String getNombre() {
		return this.nombre;
	}

	public void setDias(int dias) {
		this.dias = dias;
    }
    
    public int getDias() {
		return this.dias;
	}

	public void setLaptops(int laptops) {
		this.laptops = laptops;
    }
    
    public int getLaptops() {
		return this.laptops;
	}

	public void setMonitores(int monitores) {
		this.monitores = monitores;
    }
    
    public int getMonitores() {
		return this.monitores;
	}

	public void setTeclados(int teclados) {
		this.teclados = teclados;
    }
    
    public int getTeclados() {
		return this.teclados;
	}

	public void setMouse(int mouse) {
		this.mouses = mouse;
    }
    
    public int getMouse() {
		return this.mouses;
	}

	public void setEnfriadores(int enfriadores) {
		this.enfriadores = enfriadores;
	}

	public int getEnfriadores() {
		return this.enfriadores;
	}
	
	public double getSubtotal() {
		return this.subtotal;
	}
	
	public double getTotal() {
		return this.total;
    }
    
    @Override
    public int compareTo(Cliente cliente) {
        if(this.getDias() > cliente.getDias()) {
            return 1;
        } else if(this.getDias() < cliente.getDias()) {
            return -1;
        } else {
			if (this.getTotal() < cliente.getTotal()) {
				return 1;
			} else if (this.getTotal() > cliente.getTotal()) {
				return -1;
			} else {
				return 0;
			}
        }
	}
	
	@Override
	public String toString() {
		return "------------------------------\nCliente: " + this.nombre + "\nDias de entrega: " + this.dias 
			+ " dias" + this.laptop + this.monitor
			+ this.teclado + this.mouse + this.enfriador + "\n\nSUBTOTAL: " + this.subtotal + "\nTOTAL: " + this.total;
	}
}