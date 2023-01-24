package vistas;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

import bbdd.HilosCTRL;
import hilos.HiloActualHilos;
import hilos.HiloActuallizCateg;
import modelos.CategoriaMDL;
import modelos.HiloMDL;
import modelos.UsuarioMDL;

// ventana de visualización de Categorías
public class VCategorias extends JDialog {
	
	private UsuarioMDL user;
	private ArrayList<CategoriaMDL> categorias;
	private JTable tableHilos;
	private JTable tableCategorias;
	private HiloActuallizCateg hCateg;
	private HiloActualHilos hHilos;
	private JLabel lblError;
	
	// Contructor de la Ventana de Categorías
	public VCategorias(UsuarioMDL user) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("wombat.png"));
		getContentPane().setBackground(new Color(72, 209, 204));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				hCateg.setTerminar(true);
				hHilos.setTerminar(true);
			}
		});
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.user = user;
		setSize(new Dimension(600, 427));
		getContentPane().setSize(new Dimension(600, 500));
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 137, 243);
		getContentPane().add(scrollPane);
		
		// tabla de categorías
		tableCategorias = new JTable();
		tableCategorias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableCategorias.setFont(new Font("Verdana", Font.PLAIN, 12));
		tableCategorias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id_categoria = (int) tableCategorias.getValueAt(tableCategorias.getSelectedRow(), 0);
				HilosCTRL hCTRL = new HilosCTRL();
				hCTRL.cargarTabla(tableHilos, id_categoria);
			}
		});
		tableCategorias.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Categorías"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableCategorias.getColumnModel().getColumn(0).setPreferredWidth(0);
		tableCategorias.getColumnModel().getColumn(0).setMinWidth(0);
		tableCategorias.getColumnModel().getColumn(0).setMaxWidth(0);
		tableCategorias.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 12));
		scrollPane.setViewportView(tableCategorias);
		
		// botón de abrir post, habiendo seleccionado uno de la tabla
		JButton btnAbrirPost = new JButton("ABRIR POST");
		btnAbrirPost.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnAbrirPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableHilos.getSelectedRow();
				if(row != -1) {
					int idHilo = (int) tableHilos.getValueAt(row, 0);
					HilosCTRL hCTRL = new HilosCTRL();
					HiloMDL hilo = hCTRL.traerUno(idHilo);
					lblError.setText("");
					VMensaje vm = new VMensaje(user, hilo);
					vm.setLocationRelativeTo(vm.getParent());
					vm.setVisible(true);
				}else {
					lblError.setText("No has seleccionado ningún post para abrir");
				}
			}
		});
		btnAbrirPost.setBounds(392, 343, 182, 34);
		getContentPane().add(btnAbrirPost);
		
		JButton btnCerrarSesion = new JButton("CERRAR SESIÓN");
		btnCerrarSesion.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrarSesion.setBounds(420, 11, 154, 34);
		getContentPane().add(btnCerrarSesion);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(157, 82, 417, 217);
		getContentPane().add(scrollPane_1);
		
		// tabla de los hilos; ID e id_user ocultos
		tableHilos = new JTable();
		tableHilos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableHilos.setFont(new Font("Verdana", Font.PLAIN, 12));
		tableHilos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "Autor", "id_user"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableHilos.getColumnModel().getColumn(0).setPreferredWidth(0);
		tableHilos.getColumnModel().getColumn(0).setMinWidth(0);
		tableHilos.getColumnModel().getColumn(0).setMaxWidth(0);
		tableHilos.getColumnModel().getColumn(3).setPreferredWidth(15);
		tableHilos.getColumnModel().getColumn(3).setMinWidth(0);
		tableHilos.getColumnModel().getColumn(3).setMaxWidth(0);
		tableHilos.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 12));
		scrollPane_1.setViewportView(tableHilos);
		
		// botón de crear un post nuevo
		JButton btnCrearPost = new JButton("CREAR POST");
		btnCrearPost.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnCrearPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblError.setText("");
				VCreandoHilo cr = new VCreandoHilo(user);
				cr.setLocationRelativeTo(cr.getParent());
				cr.setVisible(true);
			}
		});
		btnCrearPost.setBounds(201, 343, 182, 34);
		getContentPane().add(btnCrearPost);
		
		// botón de eliminar un post, debe ser del usuario actual
		JButton btnBorrarPost = new JButton("BORRAR POST");
		btnBorrarPost.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnBorrarPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableHilos.getSelectedRow();
				if (row != -1) {
					int id_user = (int) tableHilos.getValueAt(row, 3);
					int idHilo = (int) tableHilos.getValueAt(row, 0);
					int idCat = (int) tableCategorias.getValueAt(tableCategorias.getSelectedRow(), 0);
					HilosCTRL hCTRL = new HilosCTRL();
					if (id_user == user.getId()) {
						hCTRL.eliminar(idHilo);
						hCTRL.cargarTabla(tableHilos, idCat);
						lblError.setText("");
					}else {
						lblError.setText("No puedes borrar un post que no creaste tú");
					}
				}else {
					lblError.setText("No has seleccionado ningún post que borrar");
				}
			}
		});
		btnBorrarPost.setBounds(10, 343, 182, 34);
		getContentPane().add(btnBorrarPost);
		
		JLabel lblBienvenida = new JLabel("Bienvenido " + user.toString());
		lblBienvenida.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblBienvenida.setBounds(10, 16, 400, 24);
		getContentPane().add(lblBienvenida);
		
		JLabel lblPosts = new JLabel("Posts");
		lblPosts.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPosts.setBounds(157, 56, 418, 21);
		getContentPane().add(lblPosts);
		
		lblError = new JLabel("");
		lblError.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblError.setForeground(Color.RED);
		lblError.setBounds(10, 310, 564, 22);
		getContentPane().add(lblError);
		
		hCateg = new HiloActuallizCateg(tableCategorias);
		hCateg.start();
		
		hHilos = new HiloActualHilos(tableCategorias, tableHilos);
		hHilos.start();
		
	}
}
