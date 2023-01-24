package hilos;

import compartido.StringCompartido;

public class HiloUno extends Thread {
	
	private StringCompartido stringCompartido;
	
	public HiloUno(String name, StringCompartido stringCompartido) {
		setName(name);
		this.stringCompartido = stringCompartido;
	}

	public void run() {
		stringCompartido.concatenar(getName());

	}
	
}
