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
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import app.bolivia.swing.JCTextField;
import mx.uam.ayd.sgp.modelo.Almacen;
import mx.uam.ayd.sgp.modelo.Producto;
import mx.uam.ayd.sgp.negocio.ControlAlmacen;
import mx.uam.ayd.sgp.negocio.ControlRealizaVenta;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VentanaAgregarProductoVenta extends JFrame {
	private JPanel contentPane;
	private Almacen producto;
	private Producto pro;
	private ControlAlmacen controlAlmacen;
	private ControlRealizaVenta controlVenta;
	private JTextPane lblMostrarP;
	private JCTextField textField;
	private VentanaRealizaVenta vRv;
	private int contador = 0;
	private JTextField textFieldCantidad;
	public int cantidadProductos;
	public int cantidadProductosGuardados;
	double totalVenta;
	public ArrayList<Almacen> productosau;

	public VentanaAgregarProductoVenta(ControlAlmacen ctrl, ControlRealizaVenta ctrl2, VentanaRealizaVenta vRv2) {
		this.controlAlmacen = ctrl;
		this.controlVenta = ctrl2;
		this.vRv = vRv2;
		String path = new java.io.File("").getAbsolutePath();
		setUndecorated(true);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		/*
		 * CARACTERISTICAS Y CONFIGURACIONES DEL BOTON AGREGAR
		 */

		JButton btnAgregar = new JButton();

		btnAgregar.setSize(140, 31);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (textFieldCantidad.getText().length() == 0) {// de validan campos vacios en la tabla
					alertaMensaje("Llena el campo cantidad", "Alerta", 1);
				} else {

					cantidadProductos = Integer.parseInt(textFieldCantidad.getText());

					if (cantidadProductos == 0) {
						alertaMensaje("Llena el campo cantidad", "Alerta", 0);
					} else {
						if(producto.getCantidadProducto()==0) {
							alertaMensaje("No hay Productos en el almacen", "Sin Productos X(", 1);
						}else {
						// si la cantidad de productos es mayor a cero y no es vacio se agregan
						// productos a la tabla
						controlVenta.agregarProductoAviso(producto);
						llenaT(producto);
					}}

				}

			}

		});
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.setText("AGREGAR\r\n");
		btnAgregar.setSelected(true);
		btnAgregar.setLocation(new Point(50, 405));
		btnAgregar.setHideActionText(true);
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnAgregar.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnAgregar.setBackground(new Color(0, 171, 197));
		/*
		 * CONFIGURACION Y CARACTERISTICAS DEL BOTON CANCELAR
		 * 
		 */
		JButton btnCancelar = new JButton();
		btnCancelar.setSize(117, 32);
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);

			}
		});
		btnCancelar.setText("CANCELAR");
		btnCancelar.setSelected(true);
		btnCancelar.setLocation(new Point(434, 404));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnCancelar.setBorder(UIManager.getBorder("EditorPane.border"));
		btnCancelar.setBackground(new Color(0, 153, 255));

		textField = new JCTextField();
		textField.setBounds(25, 71, 331, 32);
		textField.setPlaceholder("Ingrese nombre del producto");
		textField.setFont(new Font("Dialog", Font.BOLD, 18));
		textField.setBorder(null);
		/*
		 * CARACTERISTICAS Y CONFIGURACIONES DEL BOTON BUSCAR
		 */
		JButton btnBuscar = new JButton();
		btnBuscar.setSize(117, 33);
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String productoABuscar = textField.getText().toUpperCase();
				producto = controlAlmacen.buscarProductoVenta(productoABuscar);
				if (producto != null) {
					lblMostrarP.setText(producto.toString()); // Muestra el nombre del producto actualmente
																// seleccionado
				}
			}
		});
		btnBuscar.setText("BUSCAR");
		btnBuscar.setSelected(true);
		btnBuscar.setLocation(new Point(391, 71));
		btnBuscar.setHideActionText(true);
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnBuscar.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnBuscar.setBackground(new Color(0, 171, 197));

		lblMostrarP = new JTextPane();
		lblMostrarP.setBounds(28, 188, 544, 180);
		contentPane.setLayout(null);

		JLabel lblEliminarProductoDel = new JLabel("Agregar producto:");
		lblEliminarProductoDel.setBounds(15, 20, 579, 32);
		lblEliminarProductoDel.setForeground(Color.GRAY);
		lblEliminarProductoDel.setFont(new Font("Dialog", Font.BOLD, 20));
		contentPane.add(lblEliminarProductoDel);
		contentPane.add(textField);
		contentPane.add(btnBuscar);
		contentPane.add(btnAgregar);
		contentPane.add(btnCancelar);
		contentPane.add(lblMostrarP);

		textFieldCantidad = new JTextField();
		textFieldCantidad.setBorder(null);
		textFieldCantidad.setBounds(200, 114, 156, 32);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);

		JLabel lblNewLabel = new JLabel("CANTIDAD (PZS)");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(35, 114, 155, 32);
		contentPane.add(lblNewLabel);

	}

	/**
	 * Constructor vacio para que otras clases puedan acceder a los datos
	 */
	public VentanaAgregarProductoVenta() {

	}

	/**
	 * Mensaje de alerta
	 * 
	 * @param mensajeVentana
	 *            Mensaje que se desplegará en la ventana
	 * @param tituloventana
	 *            Titulo de la ventana emergente
	 * @param numero
	 *            Consiste en el valor que puedes asignar: 1 si es exito 0 si es
	 *            error para ubicar el tipo de imagen que va a mostrar la ventana.
	 */
	public void alertaMensaje(String mensajeVentana, String tituloventana, int numero) {
		JOptionPane.showMessageDialog(null, mensajeVentana, tituloventana, numero);
	}

	/**
	 * Este metodo llena la tabla que se encuentra en la VentanaRealizarVenta
	 * 
	 * @param producto
	 *            es el producto a mostrar en la tabla (esto lo hace cuantas veces sea necesario al agregar productos)
	 */

	public void llenaT(Almacen producto) {
		productosau = new ArrayList();
		double money = 0;
		int cont = vRv.getContadorProductos();
		cantidadProductos = Integer.parseInt(textFieldCantidad.getText());
		vRv.tablaVenta.setValueAt(producto.getNombreProducto(), vRv.contador, 0);
		vRv.tablaVenta.setValueAt(producto.getPrecioProducto(), vRv.contador, 1);
		vRv.tablaVenta.setValueAt(cantidadProductos, vRv.contador, 2);
		vRv.tablaVenta.setValueAt(cantidadProductos * producto.getPrecioProducto(), vRv.contador, 3);
		totalVenta = totalVenta + cantidadProductos * producto.getPrecioProducto();
		String totalMostrar = String.valueOf(totalVenta);
		vRv.textFieldImporteFinal.setText(totalMostrar);
		vRv.contador++;
		
		cont++;
		vRv.setContadorProductos(cont);
		//este for sirve para ir guardando los datos de la venta y se muestre como venta final
		for (int i = 0; i < cont; i++) {
			money = money + Double.parseDouble(vRv.tablaVenta.getValueAt(i, 3).toString());

		}

		totalMostrar = String.valueOf(money);
		vRv.textFieldImporteFinal.setText(totalMostrar);

		productosau.add(producto);

	}
}
