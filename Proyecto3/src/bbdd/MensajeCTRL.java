package bbdd;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelos.MensajeMDL;


//Controlador de los mensajes de la bbdd
public class MensajeCTRL {

	private ArrayList<MensajeMDL> lista;
	private String sql;
	private int resp = 0;
	private Connection cnx;

	// método para traer los mensajes de un hhilo concreto
	public ArrayList<MensajeMDL> getTodos(int id_h) {
		sql = "SELECT * FROM mensaje WHERE ID_Hilo = ?)";
		lista = new ArrayList<MensajeMDL>();

		cnx = Conexion.conectar();

		try {
			PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
			ps.setInt(1, id_h);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Timestamp ts = rs.getTimestamp("fecha_y_hora");
				MensajeMDL mm = new MensajeMDL(rs.getInt("id"), rs.getString("titulo"), rs.getString("cuerpo"),
						new Date(ts.getTime()), rs.getInt("id_usuario"), rs.getInt("id_hilo"));
				lista.add(mm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, ("Error en getTodos() de MensajeMDL" + id_h));
		}

		return lista;
	}

	// método para insertar un mensaje nuevo en la bbdd
	public int insertar(String t, String c, int id_u, int id_h) {
		sql = "INSERT INTO mensaje(Titulo, Cuerpo, ID_Usuario, ID_Hilo) VALUES (?,?,?,?)";

		cnx = Conexion.conectar();

		try {
			// PreparedStatement.RETURN_GENERATED_KEYS para recuperar el id generado para
			// poder crear el objeto en java
			PreparedStatement ps = Conexion.conectar().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, t);
			ps.setString(2, c);
			ps.setInt(3, id_u);
			ps.setInt(4, id_h);

			resp = ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();

			System.out.println(ps.toString());

			while (rs.next()) {
				resp = rs.getInt(1);
			}

			Conexion.conectar().close();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					("Error en insertar() de MensajeMDL" + t + " " + c + " " + id_u + " " + id_h));
		}

		return resp;
	}

	// método para elminar un mensaje de la bbdd
	public int eliminar(int id_m) {
		sql = "DELETE FROM mensaje WHERE ID = ?";

		cnx = Conexion.conectar();
		try {
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id_m);

			resp = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, ("Error en eliminar() de MensajeMDL" + id_m));
		}
		return resp;
	}

	// método para cargar la JTable con los mensajes
	public void cargarTabla(JTable jt, int id_h) {
		lista = getTodos(id_h);

		DefaultTableModel dtm = (DefaultTableModel) jt.getModel();
		dtm.setRowCount(0);

		for (MensajeMDL elemento : lista) {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Vector v = new Vector();
			v.add(elemento.getId());
			v.add(elemento.getTitulo());
			v.add(elemento.getUser().toString());
			v.add(df.format(elemento.getFecha_y_hora()));
			v.add(elemento.getCuerpo());
			v.add(elemento.getId_usuario());
			dtm.addRow(v);
		}
		jt.setModel(dtm);
	}

}
