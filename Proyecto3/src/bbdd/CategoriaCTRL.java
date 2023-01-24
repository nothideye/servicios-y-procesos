package bbdd;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import modelos.CategoriaMDL;


// controlador de las categorias de la bbdd
public class CategoriaCTRL {

	private String sql;

	// método para traer todas las categorias de la bbdd
	public ArrayList<CategoriaMDL> getTodas() {

		sql = "SELECT * FROM categorias";
		ArrayList<CategoriaMDL> lista = new ArrayList<CategoriaMDL>();

		Conexion.conectar();

		try {
			PreparedStatement ps = Conexion.conectar().prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoriaMDL cm = new CategoriaMDL(rs.getInt("ID"), rs.getString("Nombre"));
				lista.add(cm);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		return lista;
	}

	// método para cargar el JTable con las categorías
	public void cargarTabla(JTable jt) {
		ArrayList<CategoriaMDL> lista = getTodas();
		DefaultTableModel dtm = (DefaultTableModel) jt.getModel();
		dtm.setRowCount(0);

		for (CategoriaMDL elemento : lista) {
			Vector v = new Vector();
			v.add(elemento.getId());
			v.add(elemento.getNombre());
			dtm.addRow(v);
		}
		jt.setModel(dtm);
	}

}
