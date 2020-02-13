package mx.uam.ayd.sgp.presentacion;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Point;
import app.bolivia.swing.JCTextField;
import mx.uam.ayd.sgp.Aplicacion;
import mx.uam.ayd.sgp.modelo.Almacen;
import mx.uam.ayd.sgp.modelo.Producto;
import mx.uam.ayd.sgp.modelo.Usuario;
import mx.uam.ayd.sgp.negocio.ControlAdminUsuario;
import mx.uam.ayd.sgp.negocio.ControlAlmacen;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.Cursor;
import javax.swing.JTextField;

	
public class VentanaEliminarUsuario extends JFrame{
	private JPanel contentPane;
	private ControlAdminUsuario ctrlUsuario;
	private JTextPane MostrarU;
	private JCTextField textField;
	private JCTextField textField_1;
	private Usuario usuario;
	
	
	
	
	public VentanaEliminarUsuario(ControlAdminUsuario ctrl1) {
	setUndecorated(true);
	ctrlUsuario = ctrl1;
	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\Desktop\\Eclipse\\Sistema Gestor de Papeleria\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\\u00EDndice.jpg"));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 609, 467);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	
	textField_1 = new JCTextField();
	textField_1.setPlaceholder("Ingrese nombre del Empleado");
	textField_1.setFont(new Font("Dialog", Font.BOLD, 18));
	textField_1.setBorder(null);
	
	
	
	
	JButton btnEliminarUsuario = new JButton("Eliminar Usuario");
	btnEliminarUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnEliminarUsuario.setText("Elminar Usuario");
	btnEliminarUsuario.setSelected(true);
	btnEliminarUsuario.setLocation(new Point(28, 7));
	btnEliminarUsuario.setHideActionText(true);
	btnEliminarUsuario.setForeground(Color.WHITE);
	btnEliminarUsuario.setFont(new Font("Dialog", Font.BOLD, 14));
	btnEliminarUsuario.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
	btnEliminarUsuario.setBackground(new Color(0, 171, 197));
	
	/*Primero se tieena que buscar el usuario*/
	btnEliminarUsuario.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String dato=textField_1.getText();
			Usuario user= new Usuario();
			if (dato==null) {
				JOptionPane.showMessageDialog(null, "Favor de llenar los datos correspondientes ");	
			}
			else {	
					if(ctrlUsuario.EliminarUsuario(user)) {
						alertaMensaje("El usuario se elmino correctamente del sistema","Usuario Eliminado",0);
						
						System.out.println("ya me elimine");	
					}
					else {
						System.out.println("No me encontraron UnU");
						
					}
				
				
			}
			
		
		}
	});
	
	JButton  btnCancelar = new JButton("Cancelar");
	
	
	btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnCancelar.setText("Cancelar");
	btnCancelar.setSelected(true);
	btnCancelar.setLocation(new Point(28, 7));
	btnCancelar.setHideActionText(true);
	btnCancelar.setForeground(Color.WHITE);
	btnCancelar.setFont(new Font("Dialog", Font.BOLD, 14));
	btnCancelar.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
	btnCancelar.setBackground(new Color(0, 171, 197));
	btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnCancelar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
			
		}
	});
	 
	JButton btnBuscarusuario = new JButton("BuscarUsuario");
	btnBuscarusuario.setText("BUSCAR");
	btnBuscarusuario.setSelected(true);
	btnBuscarusuario.setLocation(new Point(28, 7));
	btnBuscarusuario.setHideActionText(true);
	btnBuscarusuario.setForeground(Color.WHITE);
	btnBuscarusuario.setFont(new Font("Dialog", Font.BOLD, 14));
	btnBuscarusuario.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
	btnBuscarusuario.setBackground(new Color(0, 171, 197));
	btnBuscarusuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnBuscarusuario.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String UsuarioBuscar = textField.getText().toUpperCase(); 
			usuario = ControlAdminUsuario.buscarUsuario(UsuarioBuscar);
			if (UsuarioBuscar != null) {
				MostrarU.setText(usuario.toString());
																		
			}
			
			
		}
	});

	 JTextPane MostrarU = new JTextPane();
	 
	 JLabel lblEliminarUsuario = new JLabel("Eliminar Usuario");
	 lblEliminarUsuario.setForeground(Color.GRAY);
	lblEliminarUsuario.setFont(new Font("Dialog", Font.BOLD, 20));
	 GroupLayout gl_contentPane = new GroupLayout(contentPane);
	 gl_contentPane.setHorizontalGroup(
	 	gl_contentPane.createParallelGroup(Alignment.TRAILING)
	 		.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
	 			.addGap(29)
	 			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	 				.addGroup(gl_contentPane.createSequentialGroup()
	 					.addComponent(lblEliminarUsuario)
	 					.addContainerGap())
	 				.addGroup(gl_contentPane.createSequentialGroup()
	 					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	 						.addComponent(MostrarU, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
	 						.addGroup(gl_contentPane.createSequentialGroup()
	 							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
	 							.addGap(18)
	 							.addComponent(btnBuscarusuario, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
	 						.addGroup(gl_contentPane.createSequentialGroup()
	 							.addComponent(btnEliminarUsuario, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
	 							.addPreferredGap(ComponentPlacement.RELATED, 468, Short.MAX_VALUE)
	 							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
	 					.addGap(35))))
	 );
	 gl_contentPane.setVerticalGroup(
	 	gl_contentPane.createParallelGroup(Alignment.TRAILING)
	 		.addGroup(gl_contentPane.createSequentialGroup()
	 			.addGap(16)
	 			.addComponent(lblEliminarUsuario)
	 			.addGap(18)
	 			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
	 				.addComponent(btnBuscarusuario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	 				.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	 			.addGap(15)
	 			.addComponent(MostrarU, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
	 			.addGap(49)
	 			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
	 				.addComponent(btnEliminarUsuario, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
	 				.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
	 			.addGap(26))
	 );
	contentPane.setLayout(gl_contentPane);

	
	
	
	

	/*
	
	JLabel IconStarShop = new JLabel("");
	IconStarShop.setIcon(new ImageIcon("C:\\Users\\980006502\\Pictures\\StarShop\\stara.png"));
	IconStarShop.setBounds(250, 35, 250, 108);
	contentPane.add(IconStarShop);
	*/
}
	public void alertaMensaje(String mensajeVentana, String tituloventana, int numero) {
		 JOptionPane.showMessageDialog(null, mensajeVentana, tituloventana, numero);
	    }
}
