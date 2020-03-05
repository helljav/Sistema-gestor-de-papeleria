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
import mx.uam.ayd.sgp.negocio.ControlAutenticacionUsusario;
import mx.uam.ayd.sgp.negocio.ControlRealizaVenta;
import mx.uam.ayd.sgp.negocio.ControlVentaPedido;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class VentanaRealizaPedido extends JFrame {

	private JPanel contentPane;
	private ControlVentaPedido controlventa;
	private Almacen producto;
	int contador = 0;;
	JTable tablaPedido;
	JTextField textFieldTotalVenta;
	private JTextField textFieldAcuentaVenta;
	private JTextField textFieldRestanteVenta;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private ControlAutenticacionUsusario ctrlau;
	private int contadorProductos = 0;

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
				if (textFieldNombre.getText().length() == 0 || textFieldApellido.getText().length() == 0
						|| textFieldAcuentaVenta.getText().length() == 0)
					alertaMensaje("Llena los campos", "Alerta", 1);

				else {
					String fecha1 = fecha();
					double precioTotal = 0;

					String empleado = ctrl.getempleadoaut();
					;
					String nombreProducto;
					String nombreCliente;
					String apellidoCliente;
					double precio;
					double descuento;
					int cantidad;
					double importeDejado;
					double importeTotal;
					nombreCliente = textFieldNombre.getText().toUpperCase();
					apellidoCliente = textFieldApellido.getText().toUpperCase();
					importeDejado = Double.parseDouble(textFieldAcuentaVenta.getText());
					// importeTotal=Double.parseDouble(textFieldTotalVenta.getText());
					DefaultTableModel modelo = (DefaultTableModel) tablaPedido.getModel();
					for (int i = 0; i < contador; i++) {
						nombreProducto = (String) modelo.getValueAt(i, 0);
						precio = (double) modelo.getValueAt(i, 1);
						cantidad = (int) modelo.getValueAt(i, 2);
						descuento = (double) modelo.getValueAt(i, 3);
						precio=precio*cantidad;
						precioTotal = precioTotal + precio;
						
					}
					//String PT = String.valueOf(precioTotal);

					//textFieldTotalVenta.setText(PT);

					System.out.println(fecha1);
					System.out.println(nombreCliente);
					System.out.println(apellidoCliente);
					System.out.println(importeDejado);
					System.out.println(precioTotal);
					System.out.println(empleado);
					
					double totalVenta = precioTotal-importeDejado;
					String total = String.valueOf(totalVenta);
					textFieldRestanteVenta.setText(total);
					
					if(importeDejado>=(precioTotal*0.1)) {
						controlventa.realizaPedido(fecha1, nombreCliente, apellidoCliente, importeDejado, precioTotal);
						alertaMensaje("Pedido registrado", "Alerta", 1);
						setVisible(false);
					}else {
						alertaMensaje("Anticipo menor del 10%", "Alerta", 0);
					}
				}
			}
		});
		btnLiquidarVenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLiquidarVenta.setText("REGISTRAR PEDIDO");
		btnLiquidarVenta.setSelected(true);
		btnLiquidarVenta.setLocation(new Point(15, 330));
		btnLiquidarVenta.setHideActionText(true);
		btnLiquidarVenta.setForeground(Color.WHITE);
		btnLiquidarVenta.setFont(new Font("Dialog", Font.BOLD, 14));
		btnLiquidarVenta.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnLiquidarVenta.setBackground(new Color(0, 171, 197));
		/*
		 * CARACTERISTICAS Y CONFIGURACIONES DEL BOTON CANCELAR Pedido
		 */
		JButton btnCancelarVenta = new JButton();
		btnCancelarVenta.setSize(189, 33);
		btnCancelarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador=0;
				contadorProductos = 0;
				for (int i = 0; i < 4; i++) {
					tablaPedido.setValueAt("", i, 0);
					tablaPedido.setValueAt("", i, 1);
					tablaPedido.setValueAt("", i, 2);
					tablaPedido.setValueAt(null, i, 3);

				}
			}
		});
		btnCancelarVenta.setText("CANCELAR ");
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
		lblfecha.setFont(new Font("Dialog", Font.BOLD, 15));
		lblfecha.setBounds(407, 28, 86, 14);
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

		JLabel lblDatosDelCliente = new JLabel("Datos del Cliente");
		lblDatosDelCliente.setFont(new Font("Dialog", Font.BOLD, 11));
		lblDatosDelCliente.setBounds(15, 72, 95, 14);
		contentPane.add(lblDatosDelCliente);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNombre.setBounds(15, 97, 50, 20);
		contentPane.add(lblNombre);

		JLabel lblNewLabelApellido = new JLabel("Apellido");
		lblNewLabelApellido.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNewLabelApellido.setBounds(293, 96, 50, 20);
		contentPane.add(lblNewLabelApellido);

		JLabel lblNewLabelTotaLVenta = new JLabel("Total");
		lblNewLabelTotaLVenta.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNewLabelTotaLVenta.setBounds(380, 285, 46, 14);
		contentPane.add(lblNewLabelTotaLVenta);

		JLabel lblNewLabelAcuentaVenta = new JLabel("A Cuenta..");
		lblNewLabelAcuentaVenta.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNewLabelAcuentaVenta.setBounds(380, 320, 60, 14);
		contentPane.add(lblNewLabelAcuentaVenta);

		JLabel lblNewLabelRestanteVenta = new JLabel("Restante");
		lblNewLabelRestanteVenta.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNewLabelRestanteVenta.setBounds(380, 361, 60, 14);
		contentPane.add(lblNewLabelRestanteVenta);

		textFieldTotalVenta = new JTextField();
		textFieldTotalVenta.setEditable(false);
		textFieldTotalVenta.setBounds(446, 282, 106, 20);
		contentPane.add(textFieldTotalVenta);
		textFieldTotalVenta.setColumns(10);

		textFieldAcuentaVenta = new JTextField();
		textFieldAcuentaVenta.setBounds(446, 314, 106, 20);
		contentPane.add(textFieldAcuentaVenta);
		textFieldAcuentaVenta.setColumns(10);

		textFieldRestanteVenta = new JTextField();
		textFieldRestanteVenta.setEditable(false);
		textFieldRestanteVenta.setBounds(446, 359, 106, 20);
		contentPane.add(textFieldRestanteVenta);
		textFieldRestanteVenta.setColumns(10);
		

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(72, 97, 193, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(351, 98, 181, 20);
		contentPane.add(textFieldApellido);
		textFieldApellido.setColumns(10);

		JLabel lblNewLabelNombreDelEmpleado = new JLabel(ctrl.getempleadoaut());
		lblNewLabelNombreDelEmpleado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabelNombreDelEmpleado.setBounds(436, 73, 86, 15);
		contentPane.add(lblNewLabelNombreDelEmpleado);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(
				"C:\\Users\\Maribel\\Desktop\\Sistema-gestor-de-papeleria\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\calendario.png"));
		lblNewLabel_1.setBounds(495, 0, 85, 67);
		contentPane.add(lblNewLabel_1);

		JLabel lblEmpleado = new JLabel("Empleado");
		lblEmpleado.setFont(new Font("Dialog", Font.BOLD, 11));
		lblEmpleado.setBounds(366, 73, 60, 14);
		contentPane.add(lblEmpleado);

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

	public int getContadorProductos() {
		return contadorProductos;
	}

	public void setContadorProductos(int contadorProductos) {
		this.contadorProductos = contadorProductos;
	}
}
