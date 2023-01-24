package compartido;

public class StringCompartido {

	private String string;
	
	public StringCompartido() {
		string  = "";
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
	
	// con synchronized los hilos esperan a que termine el otro
	
	public synchronized void concatenar(String nuevoString) {
		string +=  nuevoString;
	}
}
