package practicados;

import java.util.Random;

public class Participante extends Thread {
	private int numeroProgreso;
	Random r = new Random();
	private String almohadillas = "";

	public Participante(int numeroProgreso, Random r, String almohadillas) {
		super();
		this.numeroProgreso = numeroProgreso;
		this.r = r;
		this.almohadillas = almohadillas;
	}
	// Constructor en vacio de la clase
	public Participante() {

	}
	// Getters y setters
	public int getNumeroProgreso() {
		return numeroProgreso;
	}

	public void setNumeroProgreso(int numeroProgreso) {
		this.numeroProgreso = numeroProgreso;
	}

	public Random r() {
		return r;
	}

	public Random getR() {
		return r;
	}

	public void setR(Random r) {
		this.r = r;
	}

	public String getAlmohadillas() {
		return almohadillas;
	}

	public void setAlmohadillas(String almohadillas) {
		this.almohadillas = almohadillas;
	}
	
	// Inicio del thread
	public void run() {

		for (int i = 1; i <= 100; i++) {
			Random r = new Random();
			// Indicamos que duerma con un numero aleatorio para que cada vez sea diferente y el progreso no sea el mismo
			try {
				Thread.sleep(r.nextInt(250, 500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (i % 25 == 0) { // Condicion para poder anyadir 4 secuencias de almohadillas
				almohadillas += "####";
				Main.flag2 = true;
			}

		}

	}
}
