package main;

public class Ascensor extends Thread {
	
	private Edificio edificio;
    private int capacidad;
    private int plantaActual;
    private int[] plantasDestino;
    private boolean[] ocupado;

    public Ascensor(Edificio edificio) {
        this.edificio = edificio;
        capacidad = 4;
        plantaActual = 0;
        plantasDestino = new int[capacidad];
        ocupado = new boolean[capacidad];
    }

    @Override
    public void run() {
        while (true) {
            Persona persona = edificio.entraAscensor(this);
            if (persona != null) {
                int pos = -1;
                for (int i = 0; i < capacidad; i++) {
                    if (!ocupado[i]) {
                        pos = i;
                        break;
                    }
                }
                if (pos != -1) {
                    plantasDestino[pos] = persona.getDestino();
                    ocupado[pos] = true;
                    System.out.println("La persona " + persona.getId() + " entra al ascensor y elige el piso " + persona.getDestino());
                }
            }
            if (plantaActual == 0) {
                int destino = -1;
                for (int i = 0; i < capacidad; i++) {
                    if (ocupado[i] && plantasDestino[i] > destino) {
                        destino = plantasDestino[i];
                    }
                }
                if (destino != -1) {
                    System.out.println("El ascensor se dirige al piso " + destino);
                    for (int i = plantaActual; i < destino; i++) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        plantaActual = i;
                        System.out.println("El ascensor ha llegado al piso " + plantaActual);
                        int personasBajando = 0;
                        for (int j = 0; j < capacidad; j++) {
                            if (ocupado[j] && plantasDestino[j] == plantaActual) {
                                ocupado[j] = false;
                                personasBajando++;
                            }
                        }
                        if (personasBajando > 0) {
                            System.out.println("El ascensor ha dejado en este piso " + personasBajando + " personas");
                        }
                        if (personasBajando <= 0) {
                        	System.out.println("Termine");
                        	System.exit(0);
                        }
                    }
                }
            }
        }
    }

	public int getPlantaActual() {
		return plantaActual;
	}
    


}
