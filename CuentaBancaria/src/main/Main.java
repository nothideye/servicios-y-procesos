package main;

import java.util.ArrayList;

import banco.Cuenta;
import banco.Sucursal;
import usuarios.Usuario;

public class Main {

	public static void main(String[] args) {
		
		int nUsuarios = 10;
		
		Cuenta cuenta = new Cuenta(0);
		
		ArrayList<Cuenta> cuentas = new ArrayList();
		
		Sucursal Sucursal = new Sucursal(null);
		
		cuentas.add(cuenta);
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		
		
		for ( int i = 0; i < nUsuarios; i++) {
			usuarios.add(new Usuario("User " + i, 10, cuenta));
		}
		
		for (Usuario u : usuarios) {
			u.start();
		}
		
		for (Usuario u : usuarios) {
			try {
				u.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Termino el programa");
		
	}

}
