package vistas;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import bbdd.UsuarioCTRL;
import modelos.UsuarioMDL;

// Ventana de Registro de usuario
public class VRegistro extends JDialog {
	
	private JTextField textNombre;
	private JTextField textEmail;
	private JTextField textFecha;
	private JPasswordField formattedTextContrasenya;
	private Date f;
	private UsuarioCTRL controlador;
	private JLabel lblError;
	
	// Constructor de la Ventana de Registro
	public VRegistro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("wombat.png"));
		setResizable(false);
		getContentPane().setBackground(new Color(72, 209, 204));
		setSize(new Dimension(442, 460));
		setTitle("Sing in");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("NUEVO USUARIO");
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 11, 406, 40);
		getContentPane().add(lblTitulo);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNombre.setBounds(10, 82, 406, 20);
		getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Verdana", Font.PLAIN, 12));
		textNombre.setBorder(null);
		textNombre.setBackground(null);
		textNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setLabelFor(textNombre);
		textNombre.setBounds(10, 104, 406, 24);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblEmail.setBounds(10, 150, 406, 20);
		getContentPane().add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textEmail.getText().equals("ejemplo@ejemplo.com")) {
					textEmail.setText("");
					textEmail.setForeground(Color.BLACK);
				}
			}
		});
		textEmail.setText("ejemplo@ejemplo.com");
		textEmail.setForeground(Color.GRAY);
		textEmail.setFont(new Font("Verdana", Font.PLAIN, 12));
		textEmail.setBorder(null);
		textEmail.setBackground(null);
		textEmail.setHorizontalAlignment(SwingConstants.CENTER);
		textEmail.setColumns(10);
		textEmail.setBounds(10, 172, 406, 24);
		getContentPane().add(textEmail);
		
		JLabel lblContrasenya = new JLabel("CONTRASEÑA");
		lblContrasenya.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasenya.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblContrasenya.setBounds(10, 218, 406, 20);
		getContentPane().add(lblContrasenya);
		
		// checkbox para hacer visible la contraseña
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					formattedTextContrasenya.setFont(new Font("Verdana", Font.PLAIN, 12));
					formattedTextContrasenya.setEchoChar((char) 0);
				}else {
					formattedTextContrasenya.setFont(null);
					formattedTextContrasenya.setEchoChar('◉');
				}
			}
		});
		chckbxNewCheckBox.setBackground(null);
		chckbxNewCheckBox.setBounds(399, 241, 21, 23);
		getContentPane().add(chckbxNewCheckBox);
		
		formattedTextContrasenya = new JPasswordField();
		formattedTextContrasenya.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextContrasenya.setBorder(null);
		formattedTextContrasenya.setBackground(null);
		formattedTextContrasenya.setBounds(10, 240, 406, 24);
		formattedTextContrasenya.setEchoChar('◉');
		formattedTextContrasenya.setOpaque(false);
		getContentPane().add(formattedTextContrasenya);
		
		JLabel lblFecha = new JLabel("FECHA DE NACIMIENTO");
		lblFecha.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setBounds(10, 286, 406, 20);
		getContentPane().add(lblFecha);
		
		textFecha = new JTextField();
		textFecha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textFecha.getText().equals("dd/mm/yyyy")) {
					textFecha.setText("");
					textFecha.setForeground(Color.BLACK);
				}
			}
		});
		textFecha.setText("dd/mm/yyyy");
		textFecha.setForeground(Color.GRAY);
		textFecha.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFecha.setBorder(null);
		textFecha.setBackground(null);
		textFecha.setHorizontalAlignment(SwingConstants.CENTER);
		textFecha.setColumns(10);
		textFecha.setBounds(10, 308, 406, 24);
		getContentPane().add(textFecha);
		
		// botón para registrar el usuario; todos los campos han de estar rellenos correctamente
		JButton btnRegistro = new JButton("Registrarse");
		btnRegistro.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioCTRL userCTRL = new UsuarioCTRL();
				if(textNombre.getText().equals("")) {
					lblError.setText("El nombre es obligatorio");
					textNombre.grabFocus();
				}else if (!textEmail.getText().trim().matches("\\w+@\\w+\\.[A-z]{2,3}")) {
					lblError.setText("El email no es válido");
					textEmail.setText("");
					textEmail.setForeground(Color.BLACK);
					textEmail.grabFocus();
				}else if (userCTRL.buscarPorEmail(textEmail.getText().trim())) {
					lblError.setText("ERROR: email registrado");
				}else if (formattedTextContrasenya.getText().equals("")) {
					lblError.setText("La contraseña es obligatoria");
					formattedTextContrasenya.grabFocus();
				}else {
					try {
						String regexFecha = textFecha.getText();
						String regex = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
						if(regexFecha.matches(regex)) {
							Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(textFecha.getText());
							UsuarioMDL  user = userCTRL.crear(textNombre.getText().trim(), textEmail.getText().trim(), formattedTextContrasenya.getText().trim(), fecha);
							VCategorias vCat = new VCategorias(user);
							vCat.setLocationRelativeTo(vCat.getParent());
							vCat.setVisible(true);
							dispose();
						}else {
							lblError.setText("La fecha no está en un formato válido 'dd/MM/yyyy'");
							textFecha.setText("");
							textFecha.setForeground(Color.BLACK);
							textFecha.grabFocus();
						}
					} catch (ParseException e1) {
						System.err.println(e1.getMessage());
					}
				}
			}
		});
		btnRegistro.setBounds(272, 378, 144, 32);
		getContentPane().add(btnRegistro);
		
		lblError = new JLabel("");
		lblError.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblError.setForeground(Color.RED);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(10, 343, 406, 24);
		getContentPane().add(lblError);
		
		// botón para volver a la ventana anterior (la de iniciar sesión)
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnVolver.setBounds(10, 378, 144, 32);
		getContentPane().add(btnVolver);
		
		JLabel lblNewLabel = new JLabel("________________________________________________");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 116, 406, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("________________________________________________");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 184, 406, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("________________________________________________");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(10, 252, 406, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("________________________________________________");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(10, 320, 406, 14);
		getContentPane().add(lblNewLabel_1_1_1);
		
	}
}
