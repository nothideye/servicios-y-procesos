package bbdd;

import java.sql.*;
import java.util.Date;
import javax.swing.JOptionPane;
import modelos.UsuarioMDL;

// Controlador de los usuarios de la bbdd
public class UsuarioCTRL {

	private UsuarioMDL user;
	private int resp;

	// método para traer un usuario por id
	public UsuarioMDL buscarPorID(int id) {
		String sql = "SELECT * FROM usuarios WHERE ID = ?";
		UsuarioMDL user = null;

		try {
			Connection cnx = Conexion.conectar();

			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = new UsuarioMDL(rs.getInt("ID"), rs.getString("Nombre"), rs.getString("Email"),
						rs.getString("Contrasenya"), rs.getDate("Fecha_Nacimiento"));
			}
			rs.close();
			cnx.close();
			return user;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en la base de datos");
			System.err.println(e.getMessage());
			return null;
		}

	}

	// método para comprobar si existe un usuario con el email dado
	public boolean buscarPorEmail(String email) {
		String sql = "SELECT count(*) FROM usuarios WHERE email = ?";
		int result = 0;

		try {
			Connection cnx = Conexion.conectar();

			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				result = rs.getInt(1);
			}

			rs.close();
			cnx.close();

			if (result == 0)
				return false;
			else
				return true;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en buscar");
			System.err.println(e.getMessage());
			return true;
		}
	}

	// método para comprobar si existe un usario con el email y la contraseña dados
	public int buscarUser(String em, String contr) {
		String sql = "SELECT count(*) FROM usuarios WHERE email = ? AND contrasenya = ?";
		int result = 0;

		try {
			Connection cnx = Conexion.conectar();

			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, em);
			ps.setString(2, contr);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				result = rs.getInt(1);
			}

			rs.close();
			cnx.close();

			return result;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en buscar");
			System.err.println(e.getMessage());
			return -1;
		}

	}

	// método para traer un usuario con su email
	public UsuarioMDL traerUno(String email) {
		String sql = "SELECT * FROM usuarios WHERE email = ?";
		UsuarioMDL user = null;
		Connection cnx = Conexion.conectar();

		PreparedStatement ps;
		try {
			ps = cnx.prepareStatement(sql);
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = new UsuarioMDL(rs.getInt("ID"), rs.getString("Nombre"), rs.getString("Email"),
						rs.getString("Contrasenya"), rs.getDate("Fecha_Nacimiento"));
			}
			rs.close();
			cnx.close();

			return user;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en la base de datos");
			System.err.println(e.getMessage());
			return null;
		}
	}

	// método para insertar un usuario en la bbdd
	public UsuarioMDL crear(String nom, String em, String contr, Date fn) {
		String sql = "INSERT INTO usuarios VALUES (null,?,?,?,?)";
		UsuarioMDL usuario = null;
		int id = 0;
		try {
			Conexion.conectar();

			Connection cnx = Conexion.conectar();

			PreparedStatement ps = cnx.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setString(1, nom);
			ps.setString(2, em);
			ps.setString(3, contr);
			java.sql.Date fechSQL = new java.sql.Date(fn.getTime());
			ps.setDate(4, fechSQL);

			resp = ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();

			while (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			cnx.close();

			usuario = new UsuarioMDL(id, nom, em, contr, fn);

			return usuario;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en añadir");
			System.err.println(e.getMessage());
			return null;
		}

	}

}
