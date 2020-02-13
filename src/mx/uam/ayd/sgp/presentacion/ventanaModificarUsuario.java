package mx.uam.ayd.sgp.presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import app.bolivia.swing.JCTextField;
import mx.uam.ayd.sgp.modelo.Usuario;
import mx.uam.ayd.sgp.negocio.ControlAdminUsuario;

public class ventanaModificarUsuario extends JFrame {
	private JPanel contentPane;
	private JTextField textContraseña;
	private JTextField textTipoCuenta;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textTelefono;
	private JTextField textidEmpleado;
	private JTextField textField_6;

	private ControlAdminUsuario ctrlUsuario;
	private Usuario usuario;
	private Usuario usuarioAnterior;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public ventanaModificarUsuario(ControlAdminUsuario ctrlU) {
		
		
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\recursosSTARSHOP\\img\\logo.png"));
		ctrlUsuario = ctrlU;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblModificarUsuario = new JLabel("Modificar cuenta de usuario");
		lblModificarUsuario.setForeground(Color.GRAY);
		lblModificarUsuario.setFont(new Font("Dialog", Font.BOLD, 19));
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JLabel lbltipoCuenta = new JLabel("Tipo de cuenta:");
		lbltipoCuenta.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JLabel lblidEmpleado = new JLabel("ID Empleado:");
		lblidEmpleado.setFont(new Font("Dialog", Font.BOLD, 12));
		
		textContraseña = new JTextField();
		textContraseña.setEnabled(false);
		textContraseña.setColumns(10);
		
		textTipoCuenta = new JTextField();
		textTipoCuenta.setEnabled(false);
		textTipoCuenta.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setEnabled(false);
		textNombre.setColumns(10);
		
		textApellidos = new JTextField();
		textApellidos.setEnabled(false);
		textApellidos.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setEnabled(false);
		textTelefono.setColumns(10);
		
		textidEmpleado = new JTextField();
		textidEmpleado.setEnabled(false);
		textidEmpleado.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setColumns(10);
		
		
		
		JCTextField txtUsuario = new JCTextField();
		txtUsuario.setPlaceholder("Ingrese Usuario a buscar y modificar");
		txtUsuario.setFont(new Font("Dialog", Font.BOLD, 14));
		txtUsuario.setBorder(null);
		/*
		 * CARACTERISTICAS Y CONFIGURAIONES DEL BOTON BUSCAR
		 */
		JButton buttonBuscar = new JButton();
		buttonBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Se obtine del cuadro de texto el libro a buscar
				String usuarioABuscar = txtUsuario.getText();
				
				usuario = ControlAdminUsuario.buscarUsuario(usuarioABuscar);
				
				if (usuario != null) {
					txtUsuario.setText(usuario.getUsuario());
					
					textContraseña.setEnabled(true);
					textContraseña.setText(usuario.getContraseña());
						
					textTipoCuenta.setEnabled(true);
					textTipoCuenta.setText(usuario.getTipoCuenta());				
										
					textNombre.setEnabled(true);
					textNombre.setText(usuario.getNombre());	
									
					textApellidos.setEnabled(true);
					textApellidos.setText(usuario.getApellidos());
									
				
					textTelefono.setEnabled(true);
					textTelefono.setText(usuario.getTelefono());				
					
					textidEmpleado.setEnabled(true);
					textidEmpleado.setText(usuario.getIdEmpleado());
					
					
				}
				
			}
		});
		buttonBuscar.setText("BUSCAR");
		buttonBuscar.setSelected(true);
		buttonBuscar.setLocation(new Point(28, 7));
		buttonBuscar.setHideActionText(true);
		buttonBuscar.setForeground(Color.WHITE);
		buttonBuscar.setFont(new Font("Dialog", Font.BOLD, 14));
		buttonBuscar.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		buttonBuscar.setBackground(new Color(0, 171, 197));
		/*
		 * CONFIGURACION Y CARACTERISTICAS DEL BOTON MODIFICAR
		 */
		JButton btnModificar = new JButton();
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				 usuarioAnterior = new Usuario(usuario.getUsuario(),usuario.getContraseña(), usuario.getTipoCuenta(),usuario.getNombre(),usuario.getApellidos(),usuario.getTelefono(),Integer.parseInt(usuario.getIdEmpleado()));
				 System.out.println("\n\n neta no carnal "+usuarioAnterior.toString()+"\n\n");
				 
				 //nuevos datos cargados desde la caja de texto
				 String usuario = textContraseña.getText();
				 String contraseña = textTipoCuenta.getText();
				 String tipoCuenta = textNombre.getText();
				 String nombre = textApellidos.getText();
				 String apellidos = textTelefono.getText();
				 String telefono = textidEmpleado.getText();
				 String idEmpleado = textField_6.getText();
				 
				 Usuario nUsuario = new Usuario(usuario.toUpperCase(), contraseña, tipoCuenta.toUpperCase(), nombre.toUpperCase(),apellidos.toUpperCase(),telefono,Integer.parseInt(idEmpleado));   
		
				 //ControlAdminUsuario.modificarUsuario(nUsuario,usuarioAnterior);
				 textContraseña.setText("");
				 textTipoCuenta.setText("");
				 textNombre.setText("");
				 textApellidos.setText("");
				 textTelefono.setText("");
				 textidEmpleado.setText("");
				}catch(Exception e2) {
					alertaMensaje("Error al intentar modificar el usuario", "Error", 0);
				}
			}
		});
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificar.setText("MODIFICAR");
		btnModificar.setSelected(true);
		btnModificar.setLocation(new Point(28, 7));
		btnModificar.setHideActionText(true);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnModificar.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnModificar.setBackground(new Color(0, 171, 197));
		/*
		 * CARACTERISTICAS Y CONFIGURACIONES DEL BOTON CANCELAR
		 */
		JButton btnCancelar = new JButton();
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setText("CANCELAR");
		btnCancelar.setSelected(true);
		btnCancelar.setLocation(new Point(28, 7));
		btnCancelar.setHideActionText(true);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnCancelar.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnCancelar.setBackground(new Color(0, 171, 197));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(buttonBuscar, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
							.addGap(197))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
									.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblidEmpleado)
										.addComponent(lblTelefono)
										.addComponent(lblApellidos)
										.addComponent(lblNombre)
										.addComponent(lbltipoCuenta)
										.addComponent(lblContraseña)
										.addComponent(lblUsuario))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtUsuario, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
										.addComponent(textContraseña, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
										.addComponent(textTipoCuenta, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
										.addComponent(textNombre, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
										.addComponent(textApellidos, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
										.addComponent(textTelefono, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
										.addComponent(textidEmpleado, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
										)))
							.addGap(51))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblModificarUsuario, GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblModificarUsuario)
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContraseña)
						.addComponent(textContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbltipoCuenta)
						.addComponent(textTipoCuenta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblApellidos)
						.addComponent(textApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefono)
						.addComponent(textTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblidEmpleado)
						.addComponent(textidEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(buttonBuscar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(27))
		);
		contentPane.setLayout(gl_contentPane);	
	}
	public void alertaMensaje(String mensajeVentana, String tituloventana, int numero) {
		 JOptionPane.showMessageDialog(null, mensajeVentana, tituloventana, numero);
	    }

}
