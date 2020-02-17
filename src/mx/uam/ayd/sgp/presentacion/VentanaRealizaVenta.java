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
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class VentanaRealizaVenta extends JFrame {

	private JPanel contentPane;
	private ControlRealizaVenta controlventa;
	private ControlAlmacen controlAlmacen;
	private Almacen producto;
	int contador = 0;;
	JTable tablaVenta;

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

		JLabel lblDescuento = new JLabel("Venta");
		lblDescuento.setBounds(15, 16, 95, 26);
		lblDescuento.setFont(new Font("Dialog", Font.BOLD, 15));
		/*
		 * CONFIGURACION Y CARACTERISTICAS DEL BOTON AGREGAR PRODUCTOS
		 */
		JButton btnAgregaProductos = new JButton();
		btnAgregaProductos.setSize(320, 33);
		btnAgregaProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlventa.iniciaVAPV();
			}
		});
		btnAgregaProductos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregaProductos.setText("AGREGAR PRODUCTOS");
		btnAgregaProductos.setSelected(true);
		btnAgregaProductos.setLocation(new Point(15, 198));
		btnAgregaProductos.setHideActionText(true);
		btnAgregaProductos.setForeground(Color.WHITE);
		btnAgregaProductos.setFont(new Font("Dialog", Font.BOLD, 14));
		btnAgregaProductos.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnAgregaProductos.setBackground(new Color(0, 171, 197));
		/*
		 * CARACTERISTICAS Y CONFIGURACIONES DEL BOTON CERRAR VENTA
		 */
		JButton btnCerrarVenta = new JButton();
		btnCerrarVenta.setSize(320, 33);
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
					precioTotal = precioTotal + precio;
				}
				controlventa.agregarProductoVenta(fecha1, usuario, precioTotal);
			}
		});
		btnCerrarVenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCerrarVenta.setText("LIQUIDAR VENTA");
		btnCerrarVenta.setSelected(true);
		btnCerrarVenta.setLocation(new Point(15, 264));
		btnCerrarVenta.setHideActionText(true);
		btnCerrarVenta.setForeground(Color.WHITE);
		btnCerrarVenta.setFont(new Font("Dialog", Font.BOLD, 14));
		btnCerrarVenta.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnCerrarVenta.setBackground(new Color(0, 171, 197));
		/*
		 * CARACTERISTICAS Y CONFIGURACIONES DEL BOTON CANCELAR VENTA
		 */
		JButton btnCancelarVenta = new JButton();
		btnCancelarVenta.setSize(320, 33);
		btnCancelarVenta.addActionListener(new ActionListener() {
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
		btnRegresar.setBounds(363, 412, 189, 33);
		btnRegresar.setText("REGRESAR");
		btnRegresar.setSelected(true);
		btnRegresar.setHideActionText(true);
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnRegresar.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnRegresar.setBackground(new Color(0, 171, 197));

		JLabel label = new JLabel("");
		label.setBounds(384, 226, 159, 191);
		label.setIcon(new ImageIcon(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\logo.png"));
		contentPane.setLayout(null);

		JScrollPane scrollPaneRealizados = new JScrollPane();
		scrollPaneRealizados.setToolTipText("");
		scrollPaneRealizados.setBounds(15, 53, 507, 124);
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
		lblfecha.setBounds(436, 11, 86, 14);
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
