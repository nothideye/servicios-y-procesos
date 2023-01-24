package vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

import bbdd.MensajeCTRL;
import hilos.HiloActualMsgs;
import modelos.HiloMDL;
import modelos.UsuarioMDL;

// ventana de visualización de Mensajes
public class VMensaje extends JDialog {
	
	private JTable table;
	private JTextField textTitulo;
	private JTextArea textCuerpo;
	private MensajeCTRL controlador;
	private JTextArea textAreaMensaje;
	private JLabel lblErrorEliminar;
	private JLabel lblErrorPubicar;
	private HiloActualMsgs hMensajes;
	
	// Constructor de la Ventana de Mensajes
	public VMensaje(UsuarioMDL user, HiloMDL hilo) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("wombat.png"));
		getContentPane().setBackground(new Color(72, 209, 204));
		getContentPane().setForeground(new Color(0, 0, 0));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				hMensajes.setTerminar(true);
			}
		});
		controlador = new MensajeCTRL();
		setTitle("Post");
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		setSize(new Dimension(1000, 571));
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 56, 604, 465);
		getContentPane().add(scrollPane);
		
		// tabla para mostrar los mensajes y sus datos; id, cuerpo e id_user están ocultos
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Verdana", Font.PLAIN, 12));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = table.getSelectedRow();
				String cuerpo = (String) table.getValueAt(fila, 4);
				textAreaMensaje.setText(cuerpo);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "T\u00EDtulo", "Autor", "Fecha y hora", "cuerpo", "id_user"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setMinWidth(150);
		table.getColumnModel().getColumn(3).setMaxWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(0);
		table.getColumnModel().getColumn(4).setMinWidth(0);
		table.getColumnModel().getColumn(4).setMaxWidth(0);
		table.getColumnModel().getColumn(5).setPreferredWidth(0);
		table.getColumnModel().getColumn(5).setMinWidth(0);
		table.getColumnModel().getColumn(5).setMaxWidth(0);
		table.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 12));
		scrollPane.setViewportView(table);
		
		JLabel lblNuevoMensaje = new JLabel("AÑADIR MENSAJE");
		lblNuevoMensaje.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNuevoMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoMensaje.setBounds(624, 232, 352, 20);
		getContentPane().add(lblNuevoMensaje);
		
		JLabel lblTitulo = new JLabel("Título:");
		lblTitulo.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblTitulo.setBounds(624, 263, 59, 14);
		getContentPane().add(lblTitulo);
		
		JLabel lblCuerpo = new JLabel("Cuerpo:");
		lblCuerpo.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblCuerpo.setBounds(624, 319, 59, 14);
		getContentPane().add(lblCuerpo);
		
		// botón para publicar un mensaje nuevo; todos los campos han de estar rellenos y correctamente
		JButton btnPublicar = new JButton("PUBLICAR");
		btnPublicar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnPublicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textTitulo.getText().trim().equals("")) {
					lblErrorPubicar.setText("Título obligatorio.");
					textTitulo.grabFocus();
				}else if(textCuerpo.getText().trim().equals("")) {
					lblErrorPubicar.setText("Cuerpo obligatorio.");
					textCuerpo.grabFocus();
				}else if(textCuerpo.getText().trim().length() > 250) {
					lblErrorPubicar.setText("Máximo 250 caracteres");
					textCuerpo.grabFocus();
				}else {
					controlador.insertar(textTitulo.getText(), textCuerpo.getText(), user.getId(), hilo.getId());
					controlador.cargarTabla(table, hilo.getId());
					textTitulo.setText("");
					textCuerpo.setText("");
					lblErrorPubicar.setText("");
				}
			}
		});
		btnPublicar.setBounds(857, 487, 119, 34);
		getContentPane().add(btnPublicar);
		
		// botón de cerrar post actual
		JButton btnVolver = new JButton("CERRAR POST");
		btnVolver.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(826, 11, 148, 34);
		getContentPane().add(btnVolver);
		
		// botón de eliminar post actual, ha de estar uno seleccionado, y debe ser del usuario actual
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row != -1) {
					int id_m = (int) table.getValueAt(row, 0);
					int id_user = (int) table.getValueAt(row, 5);
					if(user.getId() == id_user) {
						controlador.eliminar(id_m);
						controlador.cargarTabla(table, hilo.getId());
						lblErrorEliminar.setText("");
						textAreaMensaje.setText("");
					}else {
						lblErrorEliminar.setText("Este mensaje no es tuyo");
					}
				}else {
					lblErrorEliminar.setText("No hay mensaje seleccionado");
				}
			}
		});
		btnEliminar.setBounds(855, 187, 119, 34);
		getContentPane().add(btnEliminar);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(624, 86, 350, 90);
		getContentPane().add(scrollPane_1);
		
		textAreaMensaje = new JTextArea();
		textAreaMensaje.setFont(new Font("Verdana", Font.PLAIN, 12));
		scrollPane_1.setViewportView(textAreaMensaje);
		textAreaMensaje.setEditable(false);
		textAreaMensaje.setLineWrap(true);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(624, 344, 352, 132);
		getContentPane().add(scrollPane_2);
		
		textCuerpo = new JTextArea();
		scrollPane_2.setViewportView(textCuerpo);
		textCuerpo.setFont(new Font("Verdana", Font.PLAIN, 12));
		textCuerpo.setLineWrap(true);
		
		textTitulo = new JTextField();
		textTitulo.setFont(new Font("Verdana", Font.PLAIN, 12));
		textTitulo.setBounds(624, 288, 352, 20);
		getContentPane().add(textTitulo);
		textTitulo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Post " + hilo.getNombre() + " de " + hilo.getNombreEmail_usuario());
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 470, 34);
		getContentPane().add(lblNewLabel);
		
		lblErrorEliminar = new JLabel("");
		lblErrorEliminar.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblErrorEliminar.setForeground(Color.RED);
		lblErrorEliminar.setBounds(624, 187, 221, 34);
		getContentPane().add(lblErrorEliminar);
		
		lblErrorPubicar = new JLabel("");
		lblErrorPubicar.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblErrorPubicar.setForeground(Color.RED);
		lblErrorPubicar.setBounds(624, 487, 223, 34);
		getContentPane().add(lblErrorPubicar);
		
		hMensajes = new HiloActualMsgs(table, hilo.getId());
		
		JLabel lblNewLabel_1 = new JLabel("CUERPO DEL MENSAJE");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(624, 56, 350, 19);
		getContentPane().add(lblNewLabel_1);
		hMensajes.start();
		
	}
}
