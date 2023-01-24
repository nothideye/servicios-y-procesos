package usuarios;

import java.util.Random;

import banco.Cuenta;

public class Usuario extends Thread {
	
	private double cantidad;
	private Cuenta cuenta;
	
	public Usuario(String name, double cantidad, Cuenta cuenta) {
		setName(name);
		
		this.cantidad = cantidad;
		this.cuenta = cuenta;
		
	}
	
	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public void run() {
		
		// 1- Ingresa la cantidad
		
		synchronized(cuenta) {
			cuenta.setSaldo(cuenta.getSaldo() + cantidad);
			System.out.println("Soy "+ getName() + " y ahora hay " + cuenta.getSaldo());
		}
		
		// Alternativa al synchronized de usuario
		
		// public synchronized void ingresar(double cantidad) {
		//	this.saldo += cantidad;
		// }
		
		
		// 2- Duerme 1 tiempo aleatorio entre 1 y 3 segundos
		
		try {
			Thread.sleep(new Random().nextInt(1000,3001));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 3- Retira la cantidad que ingreso
		
		synchronized(cuenta) {
			cuenta.setSaldo(cuenta.getSaldo() - cantidad);
			System.out.println("Soy "+ getName() + " y ahora hay " + cuenta.getSaldo());

		}
		
		
	}

}
