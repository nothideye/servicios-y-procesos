package hilos;

import javax.swing.JTable;
import bbdd.HilosCTRL;


//Thread para controlar la actualizacion del JTable de los hilos
public class HiloActualHilos extends Thread {

	private JTable tablaCateg;
	private JTable tablaHilos;
	// flag para controlar el final del hilo
	private boolean terminar;

	public HiloActualHilos(JTable tablaCateg, JTable tablaHilos) {
		this.tablaCateg = tablaCateg;
		this.tablaHilos = tablaHilos;
		terminar = false;
	}

	@Override
	public void run() {
		while (!terminar) {
			int fila = tablaCateg.getSelectedRow();
			// si no se ha seleccionado categoría aún, que no actualice los hilos
			while (fila == -1) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.err.println(e.getMessage());
				}
				fila = tablaCateg.getSelectedRow();
			}

			int id_categ = (int) tablaCateg.getValueAt(fila, 0);
			HilosCTRL hCTRL = new HilosCTRL();
			hCTRL.cargarTabla(tablaHilos, id_categ);
			// si hay algo seleccionado, que lo mantenga seleccionado después de actualizar
			if (fila != -1) {
				tablaHilos.changeSelection(fila, 0, false, false);
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}

		}
	}

	public boolean isTerminar() {
		return terminar;
	}

	public void setTerminar(boolean terminar) {
		this.terminar = terminar;
	}

}
