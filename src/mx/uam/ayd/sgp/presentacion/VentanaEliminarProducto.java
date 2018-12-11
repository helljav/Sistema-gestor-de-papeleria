package mx.uam.ayd.sgp.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Point;
import app.bolivia.swing.JCTextField;
import mx.uam.ayd.sgp.modelo.Almacen;
import mx.uam.ayd.sgp.modelo.Producto;
import mx.uam.ayd.sgp.negocio.ControlAlmacen;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.Cursor;


public class VentanaEliminarProducto extends JFrame {

	private JPanel contentPane;
	private Almacen producto;
	private ControlAlmacen controlAlmacen;
	private JTextPane lblMostrarP;
	private JCTextField textField;
	/**
	 * Create the frame.
	 */
	public VentanaEliminarProducto(ControlAlmacen ctrl) {
		setUndecorated(true);
		controlAlmacen = ctrl;
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\Desktop\\Eclipse\\Sistema Gestor de Papeleria\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\\u00EDndice.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		/*
		 * CARACTERISTICAS Y CONFIGURACIONES DEL BOTON ELIMINAR
		 */
		
		JButton btnEliminar = new JButton();
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlAlmacen.eliminarProducto(producto);
			}
		});
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setText("ELIMINAR");
		btnEliminar.setSelected(true);
		btnEliminar.setLocation(new Point(28, 7));
		btnEliminar.setHideActionText(true);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnEliminar.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnEliminar.setBackground(new Color(0, 171, 197));
		/*
		 * CONFIGURACION Y CARACTERISTICAS DEL BOTON CANCELAR
		 * 
		 */
		JButton btnCancelar = new JButton();
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				
			}
		});
		btnCancelar.setText("CANCELAR");
		btnCancelar.setSelected(true);
		btnCancelar.setLocation(new Point(28, 14));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnCancelar.setBorder(UIManager.getBorder("EditorPane.border"));
		btnCancelar.setBackground(new Color(0, 153, 255));
		
		textField = new JCTextField();
		textField.setPlaceholder("Ingrese nombre del producto");
		textField.setFont(new Font("Dialog", Font.BOLD, 18));
		textField.setBorder(null);
		/*
		 * CARACTERISTICAS Y CONFIGURACIONES DEL BOTON BUSCAR
		 */
		JButton btnBuscar = new JButton();
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String productoABuscar = textField.getText(); 
				producto = controlAlmacen.buscarProducto(productoABuscar,controlAlmacen.getTipoAlmacen());
				if (producto != null) {
					lblMostrarP.setText(producto.toString()); // Muestra el nombre del autor actualmente
																	// seleccionado				
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
		
	    lblMostrarP = new JTextPane();
		
		JLabel lblEliminarProductoDel = new JLabel("Eliminar producto de "+controlAlmacen.getTipoAlmacen());
		lblEliminarProductoDel.setForeground(Color.GRAY);
		lblEliminarProductoDel.setFont(new Font("Dialog", Font.BOLD, 24));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEliminarProductoDel, GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(45)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
								.addComponent(lblMostrarP, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
									.addGap(201)
									.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(15)
					.addComponent(lblEliminarProductoDel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addComponent(lblMostrarP, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(26))
		);
		contentPane.setLayout(gl_contentPane);
	}
	public void alertaMensaje(String mensajeVentana, String tituloventana, int numero) {
		 JOptionPane.showMessageDialog(null, mensajeVentana, tituloventana, numero);
	    }
}
