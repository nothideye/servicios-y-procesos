package hilos;

import javax.swing.JTable;
import bbdd.CategoriaCTRL;

//Thread para controlar la actualizacion del JTable de las categorías
public class HiloActuallizCateg extends Thread {

	private JTable tabla;
	private boolean terminar;

	public HiloActuallizCateg(JTable tabla) {
		this.tabla = tabla;
		terminar = false;
	}

	@Override
	public void run() {
		while (!terminar) {
			CategoriaCTRL cCTRL = new CategoriaCTRL();
			int fila = tabla.getSelectedRow();
			cCTRL.cargarTabla(tabla);
			// si hay algo seleccionado, que lo mantenga después de actualizar
			if (fila != -1) {
				tabla.changeSelection(fila, 0, false, false);
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
