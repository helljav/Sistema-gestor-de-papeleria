package mx.uam.ayd.sgp.presentacion;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mx.uam.ayd.sgp.modelo.Almacen;
import mx.uam.ayd.sgp.negocio.ControlAlmacen;
import mx.uam.ayd.sgp.negocio.ControlRealizaVenta;
import mx.uam.ayd.sgp.negocio.ControlVentaPedido;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class VentanaRealizaPedido extends JFrame {

	private JPanel contentPane;
	private ControlVentaPedido controlventa;
	private ControlAlmacen controlAlmacen;
	private Almacen producto;
	int contador = 0;;
	JTable tablaPedido;
	private JTextField textFieldTotalVenta;
	private JTextField textFieldAcuentaVenta;
	private JTextField textFieldRestanteVenta;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;

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
	public VentanaRealizaPedido(ControlVentaPedido ctrl) {
		String path = new java.io.File("").getAbsolutePath();
		setUndecorated(true);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\logo.png"));
		controlventa = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblDescuento = new JLabel("Ventana Pedido");
		lblDescuento.setBounds(15, 16, 143, 26);
		lblDescuento.setFont(new Font("Dialog", Font.BOLD, 15));
		/*
		 * CONFIGURACION Y CARACTERISTICAS DEL BOTON AGREGAR PRODUCTOS
		 */
		JButton btnAgregaProductos = new JButton();
		btnAgregaProductos.setSize(189, 33);
		btnAgregaProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlventa.iniciaVentanaAgregarProducto();
			}
		});
		btnAgregaProductos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregaProductos.setText("AGREGAR PRODUCTOS");
		btnAgregaProductos.setSelected(true);
		btnAgregaProductos.setLocation(new Point(15, 274));
		btnAgregaProductos.setHideActionText(true);
		btnAgregaProductos.setForeground(Color.WHITE);
		btnAgregaProductos.setFont(new Font("Dialog", Font.BOLD, 14));
		btnAgregaProductos.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnAgregaProductos.setBackground(new Color(0, 171, 197));
		/*
		 * CARACTERISTICAS Y CONFIGURACIONES DEL BOTON CERRAR VENTA
		 */
		JButton btnLiquidarVenta = new JButton();
		btnLiquidarVenta.setSize(189, 33);
		btnLiquidarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Fecha
				String fecha1 = fecha();
				double precioTotal = 0;
				String empleado = "Empleado";
				String nombreProducto;
				String nombreCliente;
				String apellidoCliente;
				double precio;
				double descuento;
				int cantidad;
				double importeDejado;
				double importeTotal;
				
				nombreCliente=textFieldNombre.getText();
				apellidoCliente=textFieldApellido.getText();
				importeDejado=Double.parseDouble(textFieldAcuentaVenta.getText());
				//importeTotal=Double.parseDouble(textFieldTotalVenta.getText());
				DefaultTableModel modelo = (DefaultTableModel) tablaPedido.getModel();
				for (int i = 0; i < contador; i++) {
					nombreProducto = (String) modelo.getValueAt(i, 0);
					precio = (double) modelo.getValueAt(i, 1);
					cantidad = (int) modelo.getValueAt(i, 2);
					descuento = (double) modelo.getValueAt(i, 3);
					precioTotal = precioTotal + precio;
				}
					controlventa.realizaPedido(fecha1, nombreCliente, apellidoCliente, importeDejado, precioTotal, empleado);
			}
		});
		btnLiquidarVenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLiquidarVenta.setText("LIQUIDAR VENTA");
		btnLiquidarVenta.setSelected(true);
		btnLiquidarVenta.setLocation(new Point(15, 330));
		btnLiquidarVenta.setHideActionText(true);
		btnLiquidarVenta.setForeground(Color.WHITE);
		btnLiquidarVenta.setFont(new Font("Dialog", Font.BOLD, 14));
		btnLiquidarVenta.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnLiquidarVenta.setBackground(new Color(0, 171, 197));
		/*
		 * CARACTERISTICAS Y CONFIGURACIONES DEL BOTON CANCELAR VENTA
		 */
		JButton btnCancelarVenta = new JButton();
		btnCancelarVenta.setSize(189, 33);
		btnCancelarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 4; i++) {
					tablaPedido.setValueAt("", i, 0);
					tablaPedido.setValueAt("", i, 1);
					tablaPedido.setValueAt("", i, 2);
					tablaPedido.setValueAt(null, i, 3);

				}
			}
		});
		btnCancelarVenta.setText("CANCELAR VENTA");
		btnCancelarVenta.setSelected(true);
		btnCancelarVenta.setLocation(new Point(15, 385));
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
		btnRegresar.setBounds(436, 423, 143, 33);
		btnRegresar.setText("REGRESAR");
		btnRegresar.setSelected(true);
		btnRegresar.setHideActionText(true);
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnRegresar.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnRegresar.setBackground(new Color(0, 171, 197));

		JLabel label = new JLabel("");
		label.setBounds(211, 274, 159, 191);
		label.setIcon(new ImageIcon(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\logo.png"));
		contentPane.setLayout(null);

		JScrollPane scrollPaneRealizados = new JScrollPane();
		scrollPaneRealizados.setToolTipText("");
		scrollPaneRealizados.setBounds(15, 139, 546, 124);
		getContentPane().add(scrollPaneRealizados);

		tablaPedido = new JTable();
		tablaPedido.setModel(new DefaultTableModel(new Object[][] {},
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
		lblfecha.setBounds(380, 24, 86, 14);
		contentPane.add(lblfecha);
		lblfecha.setText(fecha());

		scrollPaneRealizados.setViewportView(tablaPedido);
		contentPane.add(scrollPaneRealizados);
		contentPane.add(lblDescuento);
		contentPane.add(btnAgregaProductos);
		contentPane.add(btnCancelarVenta);
		contentPane.add(label);
		contentPane.add(btnLiquidarVenta);
		contentPane.add(btnRegresar);

		JLabel lblNewLabel = new JLabel("No. Pedido");
		lblNewLabel.setBounds(15, 53, 60, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabelNoPedido = new JLabel("New label");
		lblNewLabelNoPedido.setBounds(85, 53, 46, 14);
		contentPane.add(lblNewLabelNoPedido);

		JLabel lblDatosDelCliente = new JLabel("Datos del Cliente");
		lblDatosDelCliente.setBounds(15, 73, 95, 14);
		contentPane.add(lblDatosDelCliente);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(15, 114, 46, 14);
		contentPane.add(lblNombre);

		JLabel lblNewLabelApellido = new JLabel("Apellido");
		lblNewLabelApellido.setBounds(310, 114, 60, 14);
		contentPane.add(lblNewLabelApellido);

		JLabel lblNewLabelTotaLVenta = new JLabel("Total");
		lblNewLabelTotaLVenta.setBounds(380, 285, 46, 14);
		contentPane.add(lblNewLabelTotaLVenta);

		JLabel lblNewLabelAcuentaVenta = new JLabel("A Cuenta..");
		lblNewLabelAcuentaVenta.setBounds(380, 320, 60, 14);
		contentPane.add(lblNewLabelAcuentaVenta);

		JLabel lblNewLabelRestanteVenta = new JLabel("Restante");
		lblNewLabelRestanteVenta.setBounds(380, 361, 60, 14);
		contentPane.add(lblNewLabelRestanteVenta);

		textFieldTotalVenta = new JTextField();
		textFieldTotalVenta.setBounds(436, 282, 116, 20);
		contentPane.add(textFieldTotalVenta);
		textFieldTotalVenta.setColumns(10);

		textFieldAcuentaVenta = new JTextField();
		textFieldAcuentaVenta.setBounds(436, 314, 116, 20);
		contentPane.add(textFieldAcuentaVenta);
		textFieldAcuentaVenta.setColumns(10);

		textFieldRestanteVenta = new JTextField();
		textFieldRestanteVenta.setBounds(436, 358, 116, 20);
		contentPane.add(textFieldRestanteVenta);
		textFieldRestanteVenta.setColumns(10);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(64, 108, 193, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(380, 108, 181, 20);
		contentPane.add(textFieldApellido);
		textFieldApellido.setColumns(10);

		JLabel lblNewLabelNombreDelEmpleado = new JLabel("New label");
		lblNewLabelNombreDelEmpleado.setBounds(463, 73, 46, 14);
		contentPane.add(lblNewLabelNombreDelEmpleado);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(486, 24, 46, 14);
		contentPane.add(lblNewLabel_1);

	}
	public VentanaRealizaPedido() {
		// TODO Auto-generated constructor stub
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
}
