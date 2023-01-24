package banco;

public class Cuenta {
	
	private double saldo;
	
	
	public Cuenta(double saldo) {
		this.saldo = saldo;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
	// Alternativa al synchronized de usuario
	
	// public synchronized void ingresar(double cantidad) {
	//	this.saldo += cantidad;
	// }
	
	

}
