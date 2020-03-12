package mx.uam.ayd.sgp.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
import mx.uam.ayd.sgp.negocio.ControlRealizaVenta;

import java.awt.Toolkit;
import javax.swing.UIManager;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;

public class VentanaRealizaVenta extends JFrame {

	private JPanel contentPane;
	private ControlRealizaVenta controlventa;
	private ControlAlmacen controlAlmacen;
	private Almacen producto;
	int contador = 0;;
	JTable tablaVenta;
	private JTextField textFieldDescuentoporVenta;
	public JTextField textFieldImporteFinal;
	private int contadorProductos = 0;
	Double importefin;
	double importeFinal;

	/**
	 * Metodo que obtiene la fecha del sistema
	 * 
	 * @return Devuelve la fecha con el formato establecido
	 */
	public static String fecha() {
		Date fecha = new Date();
		SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYY");
		return formatofecha.format(fecha);
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param ctrl
	 *            es una instancia de Control Realizar Venta
	 */
	public VentanaRealizaVenta(ControlRealizaVenta ctrl) {
		String path = new java.io.File("").getAbsolutePath();
		setUndecorated(true);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\logo.png"));
		controlventa = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblDescuento = new JLabel();
		lblDescuento.setText("Realizar una Venta");
		lblDescuento.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescuento.setBounds(15, 16, 367, 26);
		lblDescuento.setForeground(new Color(153, 153, 153));
		lblDescuento.setFont(new Font("Dialog", Font.BOLD, 24));

		/*
		 * CONFIGURACION Y CARACTERISTICAS DEL BOTON AGREGAR PRODUCTOS
		 */
		JButton btnAgregaProductos = new JButton();
		btnAgregaProductos.setSize(196, 33);
		btnAgregaProductos.addActionListener(new ActionListener() {
			/**
			 * Inicia la ventana Agregar Producto A Venta
			 */
			public void actionPerformed(ActionEvent e) {
				controlventa.iniciaVAPV();
			}
		});
		btnAgregaProductos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregaProductos.setText("AGREGAR PRODUCTOS");
		btnAgregaProductos.setSelected(true);
		btnAgregaProductos.setLocation(new Point(15, 219));
		btnAgregaProductos.setHideActionText(true);
		btnAgregaProductos.setForeground(Color.WHITE);
		btnAgregaProductos.setFont(new Font("Dialog", Font.BOLD, 14));
		btnAgregaProductos.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnAgregaProductos.setBackground(new Color(0, 171, 197));
		/*
		 * CARACTERISTICAS Y CONFIGURACIONES DEL BOTON CERRAR VENTA
		 */
		JButton btnCerrarVenta = new JButton();
		btnCerrarVenta.setSize(196, 33);

		btnCerrarVenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCerrarVenta.setText("LIQUIDAR VENTA");
		btnCerrarVenta.setSelected(true);
		btnCerrarVenta.setLocation(new Point(15, 269));
		btnCerrarVenta.setHideActionText(true);
		btnCerrarVenta.setForeground(Color.WHITE);
		btnCerrarVenta.setFont(new Font("Dialog", Font.BOLD, 14));
		btnCerrarVenta.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnCerrarVenta.setBackground(new Color(0, 171, 197));
		/*
		 * CARACTERISTICAS Y CONFIGURACIONES DEL BOTON CANCELAR VENTA
		 */
		JButton btnCancelarVenta = new JButton();
		btnCancelarVenta.setSize(196, 33);
		btnCancelarVenta.addActionListener(new ActionListener() {
			/**
			 * Esta accion coloca los datos de la tabla sin nada 
			 */
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 4; i++) {
					tablaVenta.setValueAt("", i, 0);
					tablaVenta.setValueAt("", i, 1);
					tablaVenta.setValueAt("", i, 2);
					tablaVenta.setValueAt(null, i, 3);

				}

			}
		});
		btnCancelarVenta.setText("CANCELAR VENTA");
		btnCancelarVenta.setSelected(true);
		btnCancelarVenta.setLocation(new Point(15, 327));
		btnCancelarVenta.setHideActionText(true);
		btnCancelarVenta.setForeground(Color.WHITE);
		btnCancelarVenta.setFont(new Font("Dialog", Font.BOLD, 14));
		btnCancelarVenta.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnCancelarVenta.setBackground(new Color(0, 171, 197));
		/*
		 * CARACTERISTICAS Y CONFIGURACIONES DEL BOTON REGRESAR
		 */
		JButton btnRegresar = new JButton();
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnRegresar.setBounds(210, 409, 167, 33);
		btnRegresar.setText("REGRESAR");
		btnRegresar.setSelected(true);
		btnRegresar.setHideActionText(true);
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnRegresar.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnRegresar.setBackground(new Color(0, 171, 197));

		JLabel label = new JLabel("");
		label.setBounds(231, 207, 136, 191);
		label.setIcon(new ImageIcon(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\logo.png"));
		contentPane.setLayout(null);

		JScrollPane scrollPaneRealizados = new JScrollPane();
		scrollPaneRealizados.setToolTipText("");
		scrollPaneRealizados.setBounds(15, 84, 507, 124);
		getContentPane().add(scrollPaneRealizados);

		tablaVenta = new JTable();
		tablaVenta.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "NOMBRE DEL PRODUCTO", "PRECIO UNITARIO", "CANTIDAD", "TOTAL" }) {

			private static final long serialVersionUID = 1L;
			Class<?>[] columnTypes = new Class[] { Integer.class, String.class, String.class, Double.class };

			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}

			/**
			 * Genera las filas de la tabla
			 */
			public int getRowCount() {
				// TODO Auto-generated method stub
				return 20;
			}

		});
		JLabel lblfecha = new JLabel("dd/MM/AA");
		lblfecha.setFont(new Font("Dialog", Font.BOLD, 14));
		lblfecha.setBounds(395, 16, 86, 20);
		contentPane.add(lblfecha);
		lblfecha.setText(fecha());

		scrollPaneRealizados.setViewportView(tablaVenta);
		contentPane.add(scrollPaneRealizados);
		contentPane.add(lblDescuento);
		contentPane.add(btnAgregaProductos);
		contentPane.add(btnCancelarVenta);
		contentPane.add(label);
		contentPane.add(btnCerrarVenta);
		contentPane.add(btnRegresar);

		JLabel lblAplicarDescuento = new JLabel("Aplicar Descuento");
		lblAplicarDescuento.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAplicarDescuento.setBounds(380, 206, 115, 27);
		contentPane.add(lblAplicarDescuento);

		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			/**
			 * Accion para hacer el descuento y se vea reflejado en el importe final
			 */
			public void actionPerformed(ActionEvent arg0) {
				String opcion = comboBox.getSelectedItem().toString();
				if (opcion == "5%") {
					importefin = controlventa.realizadescuento(0.05);
				}
				if (opcion == "10%") {
					importefin = controlventa.realizadescuento(0.1);
				}
				if (opcion == "15%") {
					importefin = controlventa.realizadescuento(0.15);
				}
				if (opcion == "20%") {
					importefin = controlventa.realizadescuento(0.20);
				}
				String dato = textFieldImporteFinal.getText().toUpperCase();
			
				double datof = Double.valueOf(dato);
				String importe = String.valueOf(importefin);
				textFieldDescuentoporVenta.setText(importe);

				importeFinal = datof - importefin;// <----------------------------------------->
				String importeaMostrar = String.valueOf(importeFinal);
				textFieldImporteFinal.setText(importeaMostrar);

			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "0%", "5%", "10%", "15%", "20%" }));
		comboBox.setBounds(380, 244, 142, 26);
		contentPane.add(comboBox);

		textFieldDescuentoporVenta = new JTextField();
		textFieldDescuentoporVenta.setSelectionColor(Color.WHITE);
		textFieldDescuentoporVenta.setForeground(Color.BLACK);
		textFieldDescuentoporVenta.setBounds(380, 311, 142, 26);
		contentPane.add(textFieldDescuentoporVenta);
		textFieldDescuentoporVenta.setColumns(10);

		textFieldImporteFinal = new JTextField();
		textFieldImporteFinal.setBounds(380, 370, 142, 26);
		contentPane.add(textFieldImporteFinal);
		textFieldImporteFinal.setColumns(10);

		JLabel lblDescuentoPorVenta = new JLabel("Descuento por Venta");
		lblDescuentoPorVenta.setFont(new Font("Dialog", Font.BOLD, 12));
		lblDescuentoPorVenta.setBounds(380, 280, 142, 22);
		contentPane.add(lblDescuentoPorVenta);

		JLabel lblImporteFinal = new JLabel("Importe Final");
		lblImporteFinal.setFont(new Font("Dialog", Font.BOLD, 12));
		lblImporteFinal.setBounds(380, 338, 131, 22);
		contentPane.add(lblImporteFinal);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(
				"C:\\Users\\Maribel\\Desktop\\Sistema-gestor-de-papeleria\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\calendario.png"));
		label_1.setBounds(491, 16, 28, 20);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Empleado");
		label_2.setFont(new Font("Dialog", Font.BOLD, 11));
		label_2.setBounds(322, 59, 60, 14);
		contentPane.add(label_2);

		JLabel lblNewLabelNombreDelEmpleado = new JLabel(ctrl.getempleadoaut());
		lblNewLabelNombreDelEmpleado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabelNombreDelEmpleado.setBounds(395, 58, 86, 15);
		contentPane.add(lblNewLabelNombreDelEmpleado);
		btnCerrarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Fecha
				String fecha1 = fecha();
				double precioTotal = 0;
				String usuario = "Empleado";
				String nombre;
				double precio;
				double descuento;
				int cantidad;
				DefaultTableModel modelo = (DefaultTableModel) tablaVenta.getModel();
				for (int i = 0; i < contador; i++) {
					nombre = (String) modelo.getValueAt(i, 0);
					precio = (double) modelo.getValueAt(i, 1);
					cantidad = (int) modelo.getValueAt(i, 2);
					descuento = (double) modelo.getValueAt(i, 3);
					precioTotal = precioTotal + precio * cantidad;

				}
				String opcion = comboBox.getSelectedItem().toString();
				if (opcion == "5%" || opcion == "10%" || opcion == "15%" || opcion == "20%") {
					
					controlventa.agregarProductoVenta(fecha1, usuario, importeFinal);
				} else
					controlventa.agregarProductoVenta(fecha1, usuario, precioTotal);
					controlventa.cerrarVentaProductos();

			}
		});
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
	 * Obtiene el contador de productos para hacer calculo del costo de la venta
	 * final en la Ventana Realizar Venta
	 * 
	 * @return el contador de productos
	 */
	public int getContadorProductos() {
		return contadorProductos;
	}

	/**
	 * Establede el dato del contador de productos
	 * 
	 * @param contadorProductos
	 */
	public void setContadorProductos(int contadorProductos) {
		this.contadorProductos = contadorProductos;
	}

}
