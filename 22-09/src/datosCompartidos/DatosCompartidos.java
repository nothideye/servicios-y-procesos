package datosCompartidos;

public class DatosCompartidos {

	private String palabra;
	private boolean flag;

	public DatosCompartidos(String palabra) {
		this.palabra = palabra;
		this.flag = true;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	
}