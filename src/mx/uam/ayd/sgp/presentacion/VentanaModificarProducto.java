package mx.uam.ayd.sgp.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import app.bolivia.swing.JCTextField;
import mx.uam.ayd.sgp.modelo.Almacen;
import mx.uam.ayd.sgp.modelo.Producto;
import mx.uam.ayd.sgp.negocio.ControlAlmacen;
import java.awt.Toolkit;
import javax.swing.UIManager;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class VentanaModificarProducto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private ControlAlmacen controlAlmacen;
	private Almacen producto;
	private Almacen produtoAnterior;
	
	

	/**
	 * Create the frame.
	 */
	public VentanaModificarProducto(ControlAlmacen ctrl) {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\Desktop\\Eclipse\\Sistema Gestor de Papeleria\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\\u00EDndice.jpg"));
		controlAlmacen = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblModificarProducto = new JLabel("Modificar producto de "+controlAlmacen.getTipoAlmacen());
		lblModificarProducto.setForeground(Color.GRAY);
		lblModificarProducto.setFont(new Font("Dialog", Font.BOLD, 24));
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JLabel lblFechaDeIngreso = new JLabel("Fecha de ingreso:");
		lblFechaDeIngreso.setFont(new Font("Dialog", Font.BOLD, 12));
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		
		JCTextField txtProducto = new JCTextField();
		txtProducto.setPlaceholder("Ingrese producto a buscar y modificar");
		txtProducto.setFont(new Font("Dialog", Font.BOLD, 14));
		txtProducto.setBorder(null);
		/*
		 * CARACTERISTICAS Y CONFIGURAIONES DEL BOTON BUSCAR
		 */
		JButton buttonBuscar = new JButton();
		buttonBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String productoABuscar = txtProducto.getText();
				
				producto = controlAlmacen.buscarProducto(productoABuscar,controlAlmacen.getTipoAlmacen());
				if (producto != null) {
					
					textField.setEnabled(true);
					textField.setText(producto.getNombreProducto());
						
					textField_1.setEnabled(true);
					textField_1.setText(producto.getDescripcionProducto());				
										
					textField_2.setEnabled(true);
					textField_2.setText(Double.toString(producto.getPrecioProducto()));	
									
					textField_3.setEnabled(true);
					textField_3.setText(Double.toString(producto.getDesceuntoProducto()));
									
				
					textField_4.setEnabled(true);
					textField_4.setText(Integer.toString(producto.getCantidadProducto()));				
					
					textField_5.setEnabled(true);
					textField_5.setText(producto.getFechaIngreso());
					
								
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
				 produtoAnterior = new Almacen(producto.getProducto(), producto.getCantidadProducto(), producto.getFechaIngreso(),producto.getTipoAlmacen());
				 System.out.println("\n\n neta no mames carnal "+produtoAnterior.toString()+"\n\n");
				 //nuevos datos cargados desde la caja de texto
				 String nombre = textField.getText();
				 String descripcion = textField_1.getText();
				 double precio = Double.parseDouble(textField_2.getText());
				 double descuento = Double.parseDouble(textField_3.getText());
				 int cantidad = Integer.parseInt(textField_4.getText());
				 String fecha = textField_5.getText();
				 
				 Producto nproducto = new Producto(nombre, precio, descripcion, descuento);   
				 Almacen nuevoproducto = new Almacen(nproducto, cantidad, fecha, controlAlmacen.getTipoAlmacen());
				 controlAlmacen.modificarProducto(nuevoproducto,produtoAnterior);
				 textField.setText("");
				 textField_1.setText("");
				 textField_2.setText("");
				 textField_3.setText("");
				 textField_4.setText("");
				 textField_5.setText("");
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(buttonBuscar, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
									.addGap(197))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblModificarProducto, GroupLayout.PREFERRED_SIZE, 519, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
									.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFechaDeIngreso)
										.addComponent(lblCantidad)
										.addComponent(lblDescuento)
										.addComponent(lblPrecio)
										.addComponent(lblDescripcion)
										.addComponent(lblNombre)
										.addComponent(lblProducto))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtProducto, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
										.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
										.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
										.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
										.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
										.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))))
							.addGap(51))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblModificarProducto)
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProducto)
						.addComponent(txtProducto, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescripcion)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrecio)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblDescuento)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCantidad)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechaDeIngreso)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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

