package modelos;

// modelo de la Clase Hilo
public class HiloMDL {
	
	private int id;
	private String nombre;
	private int id_usuario, id_categoria;
	private String nombreEmail_usuario;
	
	// Constructor
	public HiloMDL(int id, String nombre, int id_usuario, int id_categoria, String nombreEmail_usuario) {
		this.id = id;
		this.nombre = nombre;
		this.id_usuario = id_usuario;
		this.id_categoria = id_categoria;
		this.nombreEmail_usuario = nombreEmail_usuario;
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
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getNombreEmail_usuario() {
		return nombreEmail_usuario;
	}
	public void setNombreEmail_usuario(String nombreEmail_usuario) {
		this.nombreEmail_usuario = nombreEmail_usuario;
	}
	@Override
	public String toString() {
		return "HiloMDL [id=" + id + ", nombre=" + nombre + ", id_usuario=" + id_usuario + ", id_categoria="
				+ id_categoria + "]";
	}

}
