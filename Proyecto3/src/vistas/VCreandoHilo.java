package vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import bbdd.CategoriaCTRL;
import bbdd.HilosCTRL;
import modelos.CategoriaMDL;
import modelos.HiloMDL;
import modelos.UsuarioMDL;

// Ventana de añadir un nuevo Hilo
public class VCreandoHilo extends JDialog {
	
	private JTextField textFieldNombreHilo;
	private JLabel lblError;
	private JComboBox comboBoxCategorias;
	private UsuarioMDL user;
	
	// Constructor de la Ventana de Hilos
	public VCreandoHilo(UsuarioMDL user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("wombat.png"));
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src//wombat.png"));
		getContentPane().setBackground(new Color(72, 209, 204));
		setTitle("Crear hilo");
		
		this.user = user;
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(new Dimension(400, 327));
		getContentPane().setLayout(null);
		
		JLabel lblNombreHilo = new JLabel("NOMBRE DEL HILO");
		lblNombreHilo.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNombreHilo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreHilo.setBounds(10, 74, 364, 22);
		getContentPane().add(lblNombreHilo);
		
		textFieldNombreHilo = new JTextField();
		textFieldNombreHilo.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNombreHilo.setBorder(null);
		textFieldNombreHilo.setBackground(new Color(72, 209, 204));
		textFieldNombreHilo.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldNombreHilo.setBounds(10, 92, 364, 27);
		getContentPane().add(textFieldNombreHilo);
		textFieldNombreHilo.setColumns(10);
		
		// botón para crear un hilo nuevo
		JButton btnCrearHilo = new JButton("CREAR HILO");
		btnCrearHilo.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnCrearHilo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CategoriaMDL categoria = (CategoriaMDL) comboBoxCategorias.getSelectedItem();
				if (textFieldNombreHilo.getText().trim().equals("")) {
					lblError.setText("El nombre es obligatorio");
					textFieldNombreHilo.grabFocus();
				}else {
					HilosCTRL hCTRL = new HilosCTRL();
					HiloMDL hilo = hCTRL.crearHilo(textFieldNombreHilo.getText(), categoria.getId(), user.getId());
					VMensaje vm = new VMensaje(user, hilo);
					vm.setLocationRelativeTo(vm.getParent());
					vm.setVisible(true);
					dispose();
				}
			}
		});
		btnCrearHilo.setBounds(215, 243, 159, 33);
		getContentPane().add(btnCrearHilo);
		
		// botón para volver a la ventana anterior (la de categorías)
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnVolver.setBounds(10, 243, 159, 33);
		getContentPane().add(btnVolver);
		
		JLabel lblCategoria = new JLabel("CATEGORÍA");
		lblCategoria.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoria.setBounds(10, 136, 364, 27);
		getContentPane().add(lblCategoria);
		
		CategoriaCTRL cCTRL = new CategoriaCTRL();
		ArrayList<CategoriaMDL> categorias =  cCTRL.getTodas();
		CategoriaMDL[] categoriasList = new CategoriaMDL[categorias.size()];
		for (int i = 0; i < categoriasList.length; i++) {
			categoriasList[i] = categorias.get(i);
		}
		comboBoxCategorias = new JComboBox(categoriasList);
		comboBoxCategorias.setBounds(120, 174, 144, 22);
		getContentPane().add(comboBoxCategorias);
		
		lblError = new JLabel("");
		lblError.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblError.setForeground(Color.RED);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(10, 205, 364, 27);
		getContentPane().add(lblError);
		
		JLabel lblTituloVentana = new JLabel("HILO NUEVO");
		lblTituloVentana.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloVentana.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblTituloVentana.setBounds(10, 11, 364, 33);
		getContentPane().add(lblTituloVentana);
		
		JLabel label = new JLabel("___________________________________________");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0, 0, 0));
		label.setBounds(10, 107, 364, 14);
		getContentPane().add(label);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(10, 174, 100, 1);
		getContentPane().add(horizontalStrut);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setBounds(274, 174, 100, 1);
		getContentPane().add(horizontalStrut_1);
		
	}
}
