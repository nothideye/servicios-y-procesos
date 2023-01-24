package bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelos.HiloMDL;
import modelos.UsuarioMDL;


// Controlador de los hilos de la bbdd
public class HilosCTRL {
	
	// método para traer un hilo por su id
	public HiloMDL traerUno(int id) {
		HiloMDL hilo = null;
		String sql = "SELECT * FROM hilos WHERE ID = ?";
		try {
			Connection cnx = Conexion.conectar();
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id_user = rs.getInt("ID_Usuario");
				UsuarioMDL user = new UsuarioCTRL().buscarPorID(id_user);
				hilo = new HiloMDL(rs.getInt("ID"), rs.getString("nombre"), id_user, rs.getInt("ID_categorias"),
						user.toString());
			}
			rs.close();
			cnx.close();

			return hilo;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error de acceso a la BBDD");
			return null;
		}
	}

	// método para traer todos los hilos de un categoría concreta
	public ArrayList<HiloMDL> traerTodos(int idCateg) {
		ArrayList<HiloMDL> hilos = new ArrayList<HiloMDL>();
		String sql = "SELECT * FROM hilos where ID_categorias = ?";

		try {
			Connection cnx = Conexion.conectar();
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, idCateg);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id_user = rs.getInt("ID_Usuario");
				UsuarioMDL user = new UsuarioCTRL().buscarPorID(id_user);
				HiloMDL h = new HiloMDL(rs.getInt("ID"), rs.getString("nombre"), id_user, rs.getInt("ID_categorias"),
						user.toString());
				hilos.add(h);
			}
			rs.close();
			cnx.close();

			return hilos;

		} catch (Exception e) {
			System.err.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error de acceso a la BBDD");
			return null;
		}

	}

	// método par insertar un hilo nuevo en la bbdd
	public HiloMDL crearHilo(String nombre, int categoria, int usuario) {
		HiloMDL hilo = null;
		UsuarioMDL user = new UsuarioCTRL().buscarPorID(usuario);
		String sql = "INSERT INTO hilos(nombre, ID_usuario, ID_categorias) VALUES( '" + nombre + "', " + usuario + ", "
				+ categoria + ")";
		try {
			int id = 0;
			Connection cnx = Conexion.conectar();
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.executeUpdate(sql, ps.RETURN_GENERATED_KEYS);// ps.RETURN_GENERATED_KEYS para poder recuperar el id, y
															// crear el objeto en java
			ResultSet rs = ps.getGeneratedKeys();
			while (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			cnx.close();
			hilo = new HiloMDL(id, nombre, usuario, categoria, user.toString());
			return hilo;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error de acceso a la BBDD");
			return null;
		}
	}

	// método para cargar el JTable con los hilos
	public void cargarTabla(JTable jt, int idCateg) {

		ArrayList<HiloMDL> hilos = traerTodos(idCateg);
		DefaultTableModel dtm = (DefaultTableModel) jt.getModel();
		dtm.setRowCount(0);

		for (HiloMDL hilo : hilos) {
			Vector v = new Vector();
			v.add(hilo.getId());
			v.add(hilo.getNombre());
			v.add(hilo.getNombreEmail_usuario());
			v.add(hilo.getId_usuario());
			dtm.addRow(v);
		}
		jt.setModel(dtm);
	}

	// método para eliminar un hilo de la bbdd
	public void eliminar(int idHilo) {
		String sql = "DELETE FROM hilos WHERE ID = ?";
		Connection cnx = Conexion.conectar();
		try {
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, idHilo);
			ps.executeUpdate();
			ps.close();
			cnx.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la base de datos");
		}
	}

}
