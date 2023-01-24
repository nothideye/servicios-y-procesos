package modelos;

import java.util.Date;

// modelo de la Clase Usuario
public class UsuarioMDL {

	private int id;
	private String nombre, email, contrasenya;
	private Date fecha_nacimiento;
	
	// Constructor
	public UsuarioMDL(int id, String nombre, String email, String contrasenya, Date fecha_nacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.contrasenya = contrasenya;
		this.fecha_nacimiento = fecha_nacimiento;
	}
	
	// getters y setters, y toString
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasenya() {
		return contrasenya;
	}
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	@Override
	public String toString() {
		return nombre + "<" + email + ">";
	}
	
}
