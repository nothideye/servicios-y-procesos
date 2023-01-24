package main;

import java.util.ArrayList;
import java.util.Iterator;

import compartidos.Caja;
import compartidos.Producto;
import hilos.Cliente;
import hilos.Dependiente;

public class Main {

	public static void main(String[] args) {
		
		Caja caja = new Caja(5);
		ArrayList<Producto> carrito = new ArrayList<>();
		Cliente cliente = new Cliente("Cliente", carrito, caja);
		Dependiente dependiente = new Dependiente("dependiente", caja, cliente);
		int numProductos = 50;
		
		// Crear productos inventados dentro del carrito 
		for(int i = 0; i < numProductos; i++) {
			carrito.add(new Producto("PRODUCTO " + i, Math.random() * 100));
			
		}
		
		// Inicio de los dos hilos
		cliente.start();
		dependiente.start();
		
		// El hilo main espera a que cliente y dependiente acaben
		try {
			cliente.join();
			dependiente.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Fin del programa");

	}

}
