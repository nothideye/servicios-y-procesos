package main;

import java.util.Random;

public class Persona extends Thread{
	
		private int id;
	    private int destino;
	    private Edificio edificio;
	    private Random rand = new Random();

	    public Persona(int id, Edificio edificio) {
	        this.id = id;
	        this.edificio = edificio;
	    }

	    @Override
	    public void run() {
	        try {
	            Thread.sleep(rand.nextInt(3) + 1 * 1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        destino = rand.nextInt(edificio.getNumPisos()) + 1;
	        System.out.println("La persona " + id + " llega al edificio y elige el piso " + destino);
	        edificio.llamaAscensor(this);
	    }

	    public int getDestino() {
	        return destino;
	    }
}
