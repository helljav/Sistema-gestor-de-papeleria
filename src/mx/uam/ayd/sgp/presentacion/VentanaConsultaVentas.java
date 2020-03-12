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
import mx.uam.ayd.sgp.modelo.Venta;
import mx.uam.ayd.sgp.negocio.ControlAlmacen;
import mx.uam.ayd.sgp.negocio.ControlConsultaVentas;
import mx.uam.ayd.sgp.negocio.ControlRealizaVenta;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaConsultaVentas extends JFrame {

	private JPanel contentPane;
	private ControlConsultaVentas consultarventa;
	private ControlAlmacen controlAlmacen;
	private Almacen producto;
	int contador = 0;;
	JTable tablaVenta;
	private JTextField textFieldVentaTotal;

	/**
	 * Constructor que genera los aditamentos a la Ventana Consultar Ventas
	 * 
	 * @param controlconsultarventas
	 *            Se pasa para utilizar el metodo que permite consultar las ventas
	 */
	public VentanaConsultaVentas(ControlConsultaVentas controlconsultarventas) {
		String path = new java.io.File("").getAbsolutePath();
		setUndecorated(true);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\logo.png"));
		consultarventa = controlconsultarventas;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblTitulo = new JLabel("Venta");
		lblTitulo.setBounds(10, 11, 119, 28);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 24));
		lblTitulo.setForeground(new Color(153, 153, 153));

		/*
		 * CARACTERISTICAS Y CONFIGURACIONES DEL BOTON REGRESAR
		 */
		JButton btnRegresar = new JButton();
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnRegresar.setBounds(328, 400, 189, 33);
		btnRegresar.setText("REGRESAR");
		btnRegresar.setSelected(true);
		btnRegresar.setHideActionText(true);
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnRegresar.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnRegresar.setBackground(new Color(0, 171, 197));

		JLabel label = new JLabel("");
		label.setBounds(30, 273, 149, 160);
		label.setIcon(new ImageIcon(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\logo.png"));
		contentPane.setLayout(null);

		JScrollPane scrollPaneRealizados = new JScrollPane();
		scrollPaneRealizados.setToolTipText("");
		scrollPaneRealizados.setBounds(10, 82, 507, 180);
		getContentPane().add(scrollPaneRealizados);

		tablaVenta = new JTable();
		tablaVenta.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "NUMERO DE FOLIO", "FECHA", "EMPLEADO", "IMPORTE TOTAL" }) {

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

		scrollPaneRealizados.setViewportView(tablaVenta);
		contentPane.add(scrollPaneRealizados);
		contentPane.add(lblTitulo);
		contentPane.add(label);
		contentPane.add(btnRegresar);

		JLabel lblImporteTotalDel = new JLabel("IMPORTE TOTAL DEL DIA ");
		lblImporteTotalDel.setFont(new Font("Dialog", Font.BOLD, 12));
		lblImporteTotalDel.setBounds(227, 282, 150, 33);
		contentPane.add(lblImporteTotalDel);

		textFieldVentaTotal = new JTextField();
		textFieldVentaTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		textFieldVentaTotal.setDoubleBuffered(true);
		textFieldVentaTotal.setDisabledTextColor(Color.BLACK);
		textFieldVentaTotal.setSelectionColor(Color.WHITE);
		textFieldVentaTotal.setEditable(false);
		textFieldVentaTotal.setEnabled(false);
		textFieldVentaTotal.setBackground(Color.WHITE);

		textFieldVentaTotal.setToolTipText("");

		textFieldVentaTotal.setForeground(Color.WHITE);
		textFieldVentaTotal.setBounds(387, 285, 119, 28);
		contentPane.add(textFieldVentaTotal);
		textFieldVentaTotal.setColumns(10);
	}

	/**
	 * LLena la tabla que se encuentra en Consultar Ventas con datos de la tabla
	 * venta ya almacenados
	 * 
	 * @param arreglo
	 *            de ventas que se encuentran almacenanos.
	 */
	public void llenarT(ArrayList<Venta> venta) {
		double suma = 0, suma1 = 0;

		try {

			for (int i = 0; i < tablaVenta.getRowCount(); i++) {

				tablaVenta.setValueAt(venta.get(i).getNumFolio(), i, 0);
				tablaVenta.setValueAt(venta.get(i).getFechaVenta(), i, 1);
				tablaVenta.setValueAt(venta.get(i).getEmpleado(), i, 2);
				tablaVenta.setValueAt(venta.get(i).getImporte(), i, 3);
				suma = (double) tablaVenta.getValueAt(i, 3);
				suma1 = suma1 + suma;
				String cadena = String.valueOf(suma1);
				textFieldVentaTotal.setText(cadena);

			}

		} catch (Exception e) {
			if (venta.isEmpty()) {
				tablaVenta.setValueAt("Aun no hay ventas", 0, 0);
			}
		}

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
