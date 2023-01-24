package hilos;

import javax.swing.JTable;
import bbdd.MensajeCTRL;
//Thread para controlar la actualizacion del JTable de los hilos
public class HiloActualMsgs extends Thread {
	
	private JTable tabla;
	private int idHilo;
	private boolean terminar;
	
	public HiloActualMsgs(JTable tabla, int idHilo) {
		this.tabla = tabla;
		this.idHilo = idHilo;
		terminar=false;
	}
	
	public void run() {
		
		while(!terminar) {
			MensajeCTRL mCTRL = new MensajeCTRL();
			int fila = tabla.getSelectedRow();
			mCTRL.cargarTabla(tabla, idHilo);
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
