package hilos;

import java.util.ArrayList;

import compartidos.Caja;
import compartidos.Producto;

public class Cliente extends Thread {
	
	private ArrayList<Producto> carrito;
	private Caja caja;
	
	public Cliente(String name, ArrayList<Producto> carrito, Caja caja) {
		setName(name);
		this.carrito = carrito;
		this.caja = caja;
	}
	
	
	public void run() {
		
		for (Producto p : carrito) {
			caja.ponerProducto(p);
		}
		
	}

}
