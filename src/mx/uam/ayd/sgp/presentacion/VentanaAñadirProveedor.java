package mx.uam.ayd.sgp.presentacion;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import mx.uam.ayd.sgp.negocio.ControlAlmacen;
import mx.uam.ayd.sgp.negocio.ControlProveedores;
import javax.swing.JTextField;

public class VentanaAñadirProveedor extends JFrame{
	private JPanel contentPane;
	private ControlProveedores ctrlProveedor;
	private ControlAlmacen ctrlAlmacen;
	private JTextField textFieldNombre;
	private JTextField textFieldCorreoElectronico;
	private JTextField textFieldNumeroTelefonico;
	private JTextField textFieldDescripcion;
	private JTextField textFieldApellidos;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public VentanaAñadirProveedor(ControlProveedores controlProveedores) {
		ctrlProveedor=controlProveedores;
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 512, 338);
		contentPane = new JPanel();
		contentPane.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrar = new JLabel("Registrar Proveedor");
		lblRegistrar.setBounds(12, 28, 357, 33);
		lblRegistrar.setForeground(Color.GRAY);
		lblRegistrar.setFont(new Font("Dialog", Font.BOLD, 19));
		contentPane.add(lblRegistrar);
		
		JLabel lblNombreDeLa = new JLabel("Nombre:");
		lblNombreDeLa.setBounds(12, 88, 136, 16);
		lblNombreDeLa.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(lblNombreDeLa);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(12, 117, 136, 16);
		lblApellidos.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(lblApellidos);
		
		
		JLabel lblCorreoElectronico = new JLabel("Correo electronico:");
		lblCorreoElectronico.setBounds(12, 149, 136, 16);
		lblCorreoElectronico.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(lblCorreoElectronico);
		
		JLabel lblNumeroDeTelefono = new JLabel("Numero de telefono:");
		lblNumeroDeTelefono.setBounds(12, 178, 144, 16);
		lblNumeroDeTelefono.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(lblNumeroDeTelefono);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(12, 212, 136, 16);
		lblDescripcion.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(lblDescripcion);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(149, 85, 275, 22);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setBounds(149, 114, 275, 22);
		contentPane.add(textFieldApellidos);
		textFieldApellidos.setColumns(10);
		
		textFieldCorreoElectronico = new JTextField();
		textFieldCorreoElectronico.setBounds(149, 146, 275, 22);
		contentPane.add(textFieldCorreoElectronico);
		textFieldCorreoElectronico.setColumns(10);
		
		textFieldNumeroTelefonico = new JTextField();
		textFieldNumeroTelefonico.setBounds(149, 175, 275, 22);
		contentPane.add(textFieldNumeroTelefonico);
		textFieldNumeroTelefonico.setColumns(10);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(149, 209, 275, 22);
		contentPane.add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		
		
		/*CONFIGURAR*/
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(211, 245, 97, 25);
		btnRegistrar.setSelected(true);
		btnRegistrar.setLocation(new Point(220, 270));
		btnRegistrar.setHideActionText(true);
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnRegistrar.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnRegistrar.setBackground(new Color(0, 171, 197));
		btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String Nombre=textFieldNombre.getText();
				String Apellido=textFieldApellidos.getText();
				String Correo_Electronico=textFieldCorreoElectronico.getText();
				String Numero_Telefono =textFieldNumeroTelefonico.getText();
				String Descripcion=textFieldDescripcion.getText();
				/**
				 *Checamos que los campos no esten vacios
				 * 
				 * */
				 
				if (textFieldNombre.getText().isEmpty()||textFieldApellidos.getText().isEmpty() || textFieldCorreoElectronico.getText().isEmpty()||textFieldNumeroTelefonico.getText().isEmpty()||textFieldDescripcion.getText().isEmpty() )
				{
					alertaMensaje("Debes llenar todos los campos para registrar un proveedor","",0);
				}else {
					if(ctrlProveedor.addProv(Nombre,Apellido, Correo_Electronico, Numero_Telefono, Descripcion)) {
						
						JOptionPane.showMessageDialog(null, "Se agrego al proveedor exitosamente");
					}else {
						JOptionPane.showMessageDialog(null, "No se agrego al proveedor");
					}
				}
				
				
			}
			}
			
				
				);
		contentPane.add(btnRegistrar);
		
		JButton btnRegresar = new JButton("REGRESAR");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnRegresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegresar.setSelected(true);
		btnRegresar.setLocation(new Point(28, 7));
		btnRegresar.setHideActionText(true);
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnRegresar.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnRegresar.setBackground(new Color(0, 171, 197));

		btnRegresar.setBounds(12, 300, 136, 25);
		contentPane.add(btnRegresar);
		
		
		
		
		
		
		
	}

	public void alertaMensaje(String mensajeVentana, String tituloventana, int numero) {
		 JOptionPane.showMessageDialog(null, mensajeVentana, tituloventana, numero);
	    }
}

