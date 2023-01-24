package modelos;

import java.sql.Date;
import bbdd.UsuarioCTRL;

//modelo de la Clase Mensaje
public class MensajeMDL {

	private int id;
	private String titulo, cuerpo;
	private Date fecha_y_hora;
	private int id_usuario, id_hilo;
	private UsuarioMDL user; 
	
	// Constructor
	public MensajeMDL(int id, String titulo, String cuerpo, Date fecha_y_hora, int id_usuario, int id_hilo) {
		this.id = id;
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.fecha_y_hora = fecha_y_hora;
		this.id_usuario = id_usuario;
		this.id_hilo = id_hilo;
		user = new UsuarioCTRL().buscarPorID(id_usuario);
	}

	// getters y setters, y toString
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	public Date getFecha_y_hora() {
		return fecha_y_hora;
	}
	public void setFecha_y_hora(Date fecha_y_hora) {
		this.fecha_y_hora = fecha_y_hora;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public int getId_hilo() {
		return id_hilo;
	}
	public void setId_hilo(int id_hilo) {
		this.id_hilo = id_hilo;
	}
	public UsuarioMDL getUser() {
		return user;
	}
	public void setUser(UsuarioMDL user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "mensajeMDL [id=" + id + ", titulo=" + titulo + ", cuerpo=" + cuerpo + ", id_usuario=" + id_usuario
				+ ", id_hilo=" + id_hilo + "]";
	} 
}
