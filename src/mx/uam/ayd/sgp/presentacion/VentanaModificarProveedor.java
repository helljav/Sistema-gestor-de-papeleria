package mx.uam.ayd.sgp.presentacion;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.border.EmptyBorder;

import app.bolivia.swing.JCTextField;
import mx.uam.ayd.sgp.modelo.Proveedor;
import mx.uam.ayd.sgp.modelo.Usuario;
import mx.uam.ayd.sgp.negocio.ControlAdminUsuario;
import mx.uam.ayd.sgp.negocio.ControlProveedores;
import javax.swing.SwingConstants;





public class VentanaModificarProveedor extends JFrame{
	
	/*****************Variables***********************/
	private JPanel contentPane;
	private JTextField apellido;
	private JTextField numTel;
	private JTextField correo;
	private JTextField descripcion;
	private JCTextField textFieldNombre = new JCTextField();

	private ControlProveedores CtrlProveedor;
	private Proveedor proveedor;
	private Proveedor proveedorAnterior;
	private JTextField nameProv;
	/*****************Variables***********************/
	
	
	
	public VentanaModificarProveedor (ControlProveedores ctrl) {
		
		
		
		String path = new java.io.File("").getAbsolutePath();

		setUndecorated(true);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\logo.png"));
		CtrlProveedor=ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*********************Declaracion de etiquetas de la ventana************************/
		
		JLabel lblModificarProveedor = new JLabel("Modificar Proveedor");
		lblModificarProveedor.setForeground(Color.GRAY);
		lblModificarProveedor.setFont(new Font("Dialog", Font.BOLD, 19));
		lblModificarProveedor.setBounds(12, 35, 223, 25);
		contentPane.add(lblModificarProveedor);
		
		JLabel lblNombreDelProveedor = new JLabel("Nombre del Proveedor:");
		lblNombreDelProveedor.setBounds(22, 177, 144, 16);
		lblNombreDelProveedor.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(lblNombreDelProveedor);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(22, 206, 57, 25);
		lblApellidos.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(lblApellidos);
		
		JLabel lblIngreseProveedor = new JLabel("Ingrese proveedor");
		lblIngreseProveedor.setBounds(12, 91, 140, 16);
		lblIngreseProveedor.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(lblIngreseProveedor);
		
		JLabel lblNumeroTelefonico = new JLabel("Numero Telefonico");
		lblNumeroTelefonico.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumeroTelefonico.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNumeroTelefonico.setBounds(12, 244, 119, 16);
		contentPane.add(lblNumeroTelefonico);
		
		JLabel lblCorreoElectronico = new JLabel("Correo Electronico:");
		lblCorreoElectronico.setBounds(22, 273, 119, 16);
		lblCorreoElectronico.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(lblCorreoElectronico);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Dialog", Font.BOLD, 12));
		lblDescripcion.setBounds(22, 302, 76, 16);
		contentPane.add(lblDescripcion);
		
		/*********************Declaracion de etiquetas de la ventana************************/

		
		/**********************Declaracion de los TextField usados en la ventana*****************/
		
		textFieldNombre.setPlaceholder("Ingrese el nombre del proveedor a  buscar");
		textFieldNombre.setFont(new Font("Dialog", Font.BOLD, 14));
		textFieldNombre.setBorder(null);
		textFieldNombre.setBounds(164, 87, 392, 23);
		contentPane.add(textFieldNombre);
		
		apellido =new JTextField();
		apellido.setEnabled(false);
		apellido.setColumns(10);
		apellido.setBounds(164, 207, 392, 22);
		contentPane.add(apellido);
		
		numTel = new JTextField();
		numTel.setEnabled(false);
		numTel.setColumns(10);
		numTel.setBounds(164, 240, 392, 22);
		contentPane.add(numTel);
		
		correo= new JTextField();
		correo.setEnabled(false);
		correo.setColumns(10);
		correo.setBounds(164, 270, 392, 22);
		contentPane.add(correo);
		
		nameProv = new JTextField();
		nameProv.setEnabled(false);
		nameProv.setColumns(10);
		nameProv.setBounds(164, 174, 392, 22);
		contentPane.add(nameProv);
		
		descripcion = new JTextField();
		descripcion.setEnabled(false);
		descripcion.setColumns(10);
		descripcion.setBounds(164, 299, 392, 22);
		contentPane.add(descripcion);
		
		/**********************Declaracion de los TextField usados en la ventana*****************/
		
		/**********************************Creacion y funcionamiento del boton Buscar************/
		
		JButton btnBuscar = new JButton();
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				
				//Se requiere un proveedor que es el que ingresa el usuario en la ventana
				String ProveedorABuscar = textFieldNombre.getText();
				proveedor = ControlProveedores.BuscaProveedor(ProveedorABuscar);
				//Al momento de tomar un proveedor ya existente se agregan kis datos del proveedor a la ventana
				if (proveedor != null) {
					nameProv.setText(proveedor.getNombre());

					apellido.setEnabled(true);
					apellido.setText(proveedor.getApellido());

					numTel.setEnabled(true);
					numTel.setText(proveedor.getNumero_Telefonico());

					correo.setEnabled(true);
					correo.setText(proveedor.getCorreo_Electronico());

					descripcion.setEnabled(true);
					descripcion.setText(proveedor.getDescripcion());
					
				}

			}
		});
		btnBuscar.setText("BUSCAR");
		btnBuscar.setSelected(true);
		btnBuscar.setLocation(new Point(28, 7));
		btnBuscar.setHideActionText(true);
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnBuscar.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnBuscar.setBackground(new Color(0, 171, 197));
		btnBuscar.setBounds(235, 128, 156, 33);
		contentPane.add(btnBuscar);
		
		/**********************************Creacion y funcionamiento del boton Buscar************/
		
		
		//Caracteristicas ty funcionamiento del boton modificar
		
		
		JButton btnModificar = new JButton();
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					//En base a un proveedor ya encontrado se crea una copia para porder modificar despues el proveedor
					
					proveedorAnterior = new Proveedor(proveedor.getNombre(),proveedor.getApellido(),proveedor.getCorreo_Electronico(),proveedor.getNumero_Telefonico(),proveedor.getDescripcion());
					System.out.println("\n\n neta no carnal " + proveedorAnterior.toString() + "\n\n");

					// nuevos datos cargados desde la caja de texto
					String Name =textFieldNombre.getText();
					String Apellidos = apellido.getText();
					String NumeroTelefonico = numTel.getText();
					String Correo1 = correo.getText();
					String Descripcion1 =descripcion.getText();

					Proveedor nProveedor = new Proveedor(Name,Apellidos,Correo1,NumeroTelefonico,Descripcion1);

					CtrlProveedor.ModificaProv(nProveedor, proveedorAnterior);
					////
					textFieldNombre.setText("");
					apellido.setText("");
					numTel.setText("");
					correo.setText("");
					descripcion.setText("");
				} catch (Exception e2) { 
					alertaMensaje("Error al intentar modificar el usuario", "Error", 0);
				}
			}
		});
		btnModificar.setText("MODIFICAR");
		btnModificar.setSelected(true);
		btnModificar.setLocation(new Point(28, 7));
		btnModificar.setHideActionText(true);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnModificar.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnModificar.setBackground(new Color(0, 171, 197));
		btnModificar.setBounds(22, 401, 133, 33);
		contentPane.add(btnModificar);
		
		//Caracteristicas y funcionamiento del boton cancelar
		
		JButton btnCancelar = new JButton();
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnCancelar.setText("CANCELAR");
		btnCancelar.setSelected(true);
		btnCancelar.setLocation(new Point(28, 7));
		btnCancelar.setHideActionText(true);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnCancelar.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnCancelar.setBackground(new Color(0, 171, 197));
		btnCancelar.setBounds(461, 401, 127, 33);
		contentPane.add(btnCancelar);
		


		
		
		
		
		
		
	}
	
	public void alertaMensaje(String mensajeVentana, String tituloventana, int numero) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, mensajeVentana, tituloventana, numero);
	}
}
