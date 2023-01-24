package banco;

import java.util.ArrayList;

public class Sucursal {
	
	private ArrayList<Cuenta> cuentas;
	
	
	public Sucursal(ArrayList<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}


	public ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}


	public void setCuentas(ArrayList<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	
	

}
