package entregaBuffer006;

import java.util.ArrayList;

public class Compartido {
	
	public static final int Const_max = 10;
	private ArrayList<String> comp = new ArrayList<>(Const_max);
	private boolean terminar = false;

	/*
	 * Constructores de la Clase común Compartido
	 */
	public Compartido() {
		
	}
	
	public Compartido(ArrayList<String> comp, boolean terminar) {
		this.comp = comp;
		this.terminar = terminar;
	}

	
	/*
	 * getters y setters
	 */
	public ArrayList<String> getComp() {
		return comp;
	}

	public void setComp(ArrayList<String> comp) {
		this.comp = comp;
	}

	public boolean isTerminar() {
		return terminar;
	}

	public void setTerminar(boolean terminar) {
		this.terminar = terminar;
	}
	
}
