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
	private JTextField textFieldNomEmpresa;
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
		lblRegistrar.setBounds(194, 26, 114, 16);
		contentPane.add(lblRegistrar);
		
		JLabel lblNombreDeLa = new JLabel("Nombre:");
		lblNombreDeLa.setBounds(12, 70, 136, 16);
		contentPane.add(lblNombreDeLa);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(12, 80, 136, 16);
		contentPane.add(lblApellidos);
		
		
		JLabel lblCorreoElectronico = new JLabel("Correo electronico:");
		lblCorreoElectronico.setBounds(12, 99, 136, 16);
		contentPane.add(lblCorreoElectronico);
		
		JLabel lblNumeroDeTelefono = new JLabel("Numero de telefono:");
		lblNumeroDeTelefono.setBounds(12, 128, 144, 16);
		contentPane.add(lblNumeroDeTelefono);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(12, 157, 136, 16);
		contentPane.add(lblDescripcion);
		
		textFieldNomEmpresa = new JTextField();
		textFieldNomEmpresa.setBounds(160, 67, 275, 22);
		contentPane.add(textFieldNomEmpresa);
		textFieldNomEmpresa.setColumns(10);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setBounds(160, 67, 275, 22);
		contentPane.add(textFieldApellidos);
		textFieldApellidos.setColumns(10);
		
		textFieldCorreoElectronico = new JTextField();
		textFieldCorreoElectronico.setBounds(160, 96, 275, 22);
		contentPane.add(textFieldCorreoElectronico);
		textFieldCorreoElectronico.setColumns(10);
		
		textFieldNumeroTelefonico = new JTextField();
		textFieldNumeroTelefonico.setBounds(160, 125, 275, 22);
		contentPane.add(textFieldNumeroTelefonico);
		textFieldNumeroTelefonico.setColumns(10);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(160, 154, 275, 22);
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
				String Nombre_Empresa=textFieldNomEmpresa.getText();
				String Apellido=textFieldApellidos.getText();
				String Correo_Electronico=textFieldCorreoElectronico.getText();
				String Numero_Telefono =textFieldNumeroTelefonico.getText();
				String Descripcion=textFieldDescripcion.getText();
				/**
				 *Checamos que los campos no esten vacios
				 * 
				 * */
				 
				if (textFieldNomEmpresa.getText().isEmpty() || textFieldCorreoElectronico.getText().isEmpty()||textFieldNumeroTelefonico.getText().isEmpty()||textFieldDescripcion.getText().isEmpty() )
				{
					alertaMensaje("Debes llenar todos los campos para registrar un proveedor","",0);
				}else {
					if(ctrlProveedor.addProv(Nombre_Empresa,Apellido, Correo_Electronico, Numero_Telefono, Descripcion)) {
						
						JOptionPane.showMessageDialog(null, "Se agrego al proveedor exitosamente");
					}else {
						JOptionPane.showMessageDialog(null, "No se agrego al proveedor");
					}
				}
				
				
			}
			}
			
				
				);
		contentPane.add(btnRegistrar);
		
		
		
		
		JLabel lblRegresar = new JLabel("regresar");
		lblRegresar.setBounds(12, 309, 56, 16);
		lblRegresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
			}
		});
		
		
		contentPane.add(lblRegresar);
	
	}

	public void alertaMensaje(String mensajeVentana, String tituloventana, int numero) {
		 JOptionPane.showMessageDialog(null, mensajeVentana, tituloventana, numero);
	    }
}

