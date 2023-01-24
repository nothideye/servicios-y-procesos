package vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import bbdd.UsuarioCTRL;
import modelos.UsuarioMDL;

public class VPrincipal extends JFrame {
	
	private JTextField textEmail;
	private JPasswordField passwordContrasenya;
	private JLabel lblError;
	
	// Constructor de la Ventana Principal
	public VPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("wombat.png"));
		setResizable(false);
		getContentPane().setBackground(new Color(72, 209, 204));
		setLocation(new Point(45, 400));
		setSize(new Dimension(400, 296));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("INICIAR SESIÓN");
		lblLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Verdana", Font.BOLD, 16));
		lblLogin.setBounds(10, 11, 364, 32);
		getContentPane().add(lblLogin);
		
		JLabel lblEmailAd = new JLabel("EMAIL ADRESS");
		lblEmailAd.setBackground(new Color(0, 0, 0));
		lblEmailAd.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailAd.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblEmailAd.setBounds(10, 76, 364, 20);
		getContentPane().add(lblEmailAd);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Verdana", Font.PLAIN, 12));
		textEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textEmail.getText().equals("ejemplo@ejemplo.es")) {
					textEmail.setText("");
					textEmail.setForeground(Color.BLACK);					
				}
			}
		});
		textEmail.setForeground(Color.GRAY);
		textEmail.setText("ejemplo@ejemplo.es");
		textEmail.setBorder(null);
		textEmail.setHorizontalAlignment(SwingConstants.CENTER);
		textEmail.setBackground(new Color(72, 209, 204));
		textEmail.setBounds(10, 94, 364, 24);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPassword.setBackground(Color.BLACK);
		lblPassword.setBounds(10, 132, 364, 20);
		getContentPane().add(lblPassword);
		
		// botón para iniciar sesión, los campos han de estar rellenos, el usuario debe existir con la contraseña correcta
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioCTRL userCTRL = new UsuarioCTRL();
				if(textEmail.getText().trim().equals("")) {
					lblError.setText("Email obligatorio");
					textEmail.grabFocus();
				}else if (passwordContrasenya.getText().trim().equals("")) {
					lblError.setText("ContraseÃ±a obligatoria");
					passwordContrasenya.grabFocus();
				}else {
					int esta = userCTRL.buscarUser(textEmail.getText().trim(), passwordContrasenya.getText().trim());
					if (esta == 0) {
						lblError.setText("No existe el email o contraseña incorrecta");
					}else {
						UsuarioMDL user = userCTRL.traerUno(textEmail.getText().trim());
						lblError.setText("");
						textEmail.setText("");
						passwordContrasenya.setText("");
						VCategorias vCat = new VCategorias(user);
						vCat.setLocationRelativeTo(vCat.getParent());
						vCat.setVisible(true);
					}					
				}
			}
		});
		btnLogin.setBounds(10, 214, 160, 32);
		getContentPane().add(btnLogin);
		btnLogin.grabFocus();
		
		// botón para ir a la ventana de registrar un usuario nuevo
		JButton btnCrearCuenta = new JButton("SIGN UP");
		btnCrearCuenta.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VRegistro vr = new VRegistro();
				vr.setLocationRelativeTo(vr.getParent());
				vr.setVisible(true);
			}
		});
		
		btnCrearCuenta.setBounds(214, 214, 160, 32);
		getContentPane().add(btnCrearCuenta);
		
		lblError = new JLabel("");
		lblError.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblError.setForeground(Color.RED);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(10, 183, 364, 20);
		getContentPane().add(lblError);
		
		// checkbox para hacer visible la contraseña
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					passwordContrasenya.setFont(new Font("Verdana", Font.PLAIN, 12));
					passwordContrasenya.setEchoChar((char) 0);
				}else {
					passwordContrasenya.setFont(null);
					passwordContrasenya.setEchoChar('◉');
				}
			}
		});
		chckbxNewCheckBox.setBackground(new Color(72, 209, 204));
		chckbxNewCheckBox.setBounds(353, 148, 21, 24);
		chckbxNewCheckBox.setVisible(true);
		getContentPane().add(chckbxNewCheckBox);
		
		passwordContrasenya = new JPasswordField();
		passwordContrasenya.setBorder(null);
		passwordContrasenya.setBackground(null);
		passwordContrasenya.setHorizontalAlignment(SwingConstants.CENTER);
		passwordContrasenya.setBounds(10, 148, 364, 24);
		passwordContrasenya.setEchoChar('◉');
		passwordContrasenya.setOpaque(false);
		getContentPane().add(passwordContrasenya);
		
		
		JLabel lblNewLabel = new JLabel("_____________________________________");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 106, 364, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("_____________________________________");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 159, 364, 14);
		getContentPane().add(lblNewLabel_1);
		
	}
}
