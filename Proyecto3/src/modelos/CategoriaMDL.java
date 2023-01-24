package modelos;

// modelo de la Clase Categoria
public class CategoriaMDL {
	
	private int id;
	private String nombre;
	
	// Constructor
	public CategoriaMDL(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
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
	@Override
	public String toString() {
		return nombre;
	}

}
