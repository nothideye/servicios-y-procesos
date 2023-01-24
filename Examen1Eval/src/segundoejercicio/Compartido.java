package segundoejercicio;

import java.util.ArrayList;

public class Compartido{
	
	private ArrayList<Integer> listaNumeros = new ArrayList<Integer>();
	private boolean terminar = false;
	public int tamanyoArray;
	private int numerosRandom;
	private String ruta;
	
	public Compartido() {
		
	}
	
	public Compartido(ArrayList<Integer> listaNumeros, boolean terminar, int tamanyoArray, int numerosRandom, String ruta) {
		super();
		this.listaNumeros = listaNumeros;
		this.terminar = terminar;
		this.tamanyoArray = tamanyoArray;
		this.numerosRandom = numerosRandom;
		this.ruta = ruta;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public ArrayList<Integer> getListaNumeros() {
		return listaNumeros;
	}

	public int getNumerosRandom() {
		return numerosRandom;
	}

	public void setNumerosRandom(int numerosRandom) {
		this.numerosRandom = numerosRandom;
	}

	public void setListaNumeros(ArrayList<Integer> listaNumeros) {
		this.listaNumeros = listaNumeros;
	}

	public boolean isTerminar() {
		return terminar;
	}

	public void setTerminar(boolean terminar) {
		this.terminar = terminar;
	}

	public int getTamanyoArray() {
		return tamanyoArray;
	}

	public void setTamanyoArray(int tamanyoArray) {
		this.tamanyoArray = tamanyoArray;
	}
	
	
	
	

	
	

}
