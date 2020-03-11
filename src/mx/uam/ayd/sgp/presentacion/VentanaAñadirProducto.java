package mx.uam.ayd.sgp.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.bolivia.swing.JCTextField;
import mx.uam.ayd.sgp.negocio.ControlAlmacen;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.Point;

public class VentanaAñadirProducto extends JFrame {

	private JPanel contentPane;
	// private JTextField txtNomProducto;
	// private JTextField txtDescripcion;
	// private JTextField txtPrecio;
	// private JTextField txtDescuento;
	private ControlAlmacen ctrlAlmacen;
	// private JTextField txtCantidad;
	// private JTextField txtFecha;
	private JCTextField txtNomProducto;
	private JCTextField txtDescripcion;
	private JCTextField txtPrecio;
	private JCTextField txtDescuento;
	private JCTextField txtCantidad;
	private JCTextField txtFecha;

	public void alertaMensaje(String mensajeVentana, String tituloventana, int numero) {
		JOptionPane.showMessageDialog(null, mensajeVentana, tituloventana, numero);
	}

	/**
	 * Create the frame.
	 */
	public VentanaAñadirProducto(ControlAlmacen ctrl) {
		setUndecorated(true);
		ctrlAlmacen = ctrl;
		System.out.println("VentanaAñadirProducto");
		System.out.println(ctrlAlmacen.getTipoAlmacen());
		setTitle("A\u00F1adir Producto");
		String path = new java.io.File("").getAbsolutePath();
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		txtNomProducto = new JCTextField();
		txtNomProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNomProducto.setPlaceholder("Ingrese el nombre");
		txtNomProducto.setColumns(10);

		txtDescripcion = new JCTextField();
		txtDescripcion.setPlaceholder("Ingrese descripcion");
		txtDescripcion.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtDescripcion.setColumns(10);

		txtPrecio = new JCTextField();
		txtPrecio.setPlaceholder("$");
		txtPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPrecio.setColumns(10);

		txtDescuento = new JCTextField();
		txtDescuento.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtDescuento.setPlaceholder("% de descuento");
		txtDescuento.setColumns(10);
		/*
		 * CARACTERISTICAS Y CONFIGURACIONES DEL BOTON ACEPTAR
		 */
		JButton btnAceptar = new JButton();
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombre = txtNomProducto.getText().toUpperCase();
					String descripcion = txtDescripcion.getText().toUpperCase();
					double precio = Double.parseDouble(txtPrecio.getText());
					double descuento = Double.parseDouble(txtDescuento.getText());
					int cantidad = Integer.parseInt(txtCantidad.getText());
					String tipoAlmacen = ctrlAlmacen.getTipoAlmacen().toUpperCase();
					String fecha = txtFecha.getText();
					if(descuento<=100) {
						precio=precio-(precio*(descuento/100));
						ctrlAlmacen.agregarProducto(nombre, precio, descripcion, cantidad, descuento, fecha, tipoAlmacen);
					}else {
						alertaMensaje("Los valores que trata de ingresar son invalidos", "Error fatality", 0);
					}
					
					
				} catch (Exception e2) {
					alertaMensaje("Los valores que trata de ingresar son invalidos", "Error fatality", 0);
				}
			}
		});
		btnAceptar.setLocation(new Point(28, 7));
		btnAceptar.setSelected(true);
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setHideActionText(true);
		btnAceptar.setText("ACEPTAR");
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnAceptar.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnAceptar.setBackground(new Color(0, 171, 197));

		JLabel lblAadirProductoAl = new JLabel();
		lblAadirProductoAl.setText("A\u00F1adir producto al almacen");
		lblAadirProductoAl.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirProductoAl.setForeground(new Color(153, 153, 153));
		lblAadirProductoAl.setFont(new Font("Dialog", Font.BOLD, 24));

		JLabel lblNombreDelProducto = new JLabel();
		lblNombreDelProducto.setText("Nombre del producto:");
		lblNombreDelProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDelProducto.setForeground(Color.BLACK);
		lblNombreDelProducto.setFont(new Font("Dialog", Font.BOLD, 12));

		JLabel lblDescripcion = new JLabel();
		lblDescripcion.setHorizontalTextPosition(SwingConstants.LEFT);
		lblDescripcion.setText("Descripci\u00F3n:");
		lblDescripcion.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescripcion.setForeground(Color.BLACK);
		lblDescripcion.setFont(new Font("Dialog", Font.BOLD, 12));

		JLabel lblPrecio = new JLabel();
		lblPrecio.setText("Precio:");
		lblPrecio.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecio.setForeground(Color.BLACK);
		lblPrecio.setFont(new Font("Dialog", Font.BOLD, 12));

		JLabel lblDescuento = new JLabel();
		lblDescuento.setText("Descuento");
		lblDescuento.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescuento.setForeground(Color.BLACK);
		lblDescuento.setFont(new Font("Dialog", Font.BOLD, 12));
		/*
		 * Caracteristicas y configuracion del boton cancelar
		 * 
		 */
		JButton buttonCancelar = new JButton();
		buttonCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		buttonCancelar.setText("CANCELAR");
		buttonCancelar.setSelected(true);
		buttonCancelar.setLocation(new Point(28, 14));
		buttonCancelar.setForeground(Color.WHITE);
		buttonCancelar.setFont(new Font("Dialog", Font.BOLD, 14));
		buttonCancelar.setBorder(UIManager.getBorder("EditorPane.border"));
		buttonCancelar.setBackground(new Color(0, 153, 255));

		JLabel lblCantidadProducto = new JLabel();
		lblCantidadProducto.setText("Cantidad producto:");
		lblCantidadProducto.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadProducto.setForeground(Color.BLACK);
		lblCantidadProducto.setFont(new Font("Dialog", Font.BOLD, 12));

		txtCantidad = new JCTextField();
		txtCantidad.setPlaceholder("Numero de piezas");
		txtCantidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtCantidad.setColumns(10);

		JLabel lblFecha = new JLabel();
		lblFecha.setText("Fecha de ingreso:");
		lblFecha.setHorizontalAlignment(SwingConstants.LEFT);
		lblFecha.setForeground(Color.BLACK);
		lblFecha.setFont(new Font("Dialog", Font.BOLD, 12));

		txtFecha = new JCTextField();
		txtFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtFecha.setPlaceholder("\"2018/01/01\"");
		txtFecha.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblDescuento, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(txtDescuento, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNombreDelProducto, GroupLayout.PREFERRED_SIZE, 129,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDescripcion, GroupLayout.PREFERRED_SIZE, 129,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPrecio, GroupLayout.PREFERRED_SIZE, 129,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtDescripcion, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
										.addComponent(txtPrecio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 385,
												Short.MAX_VALUE)
										.addComponent(txtNomProducto, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))))
				.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(lblCantidadProducto, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(txtCantidad, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
						.addContainerGap())
				.addGroup(
						gl_contentPane.createSequentialGroup().addGap(103)
								.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
								.addComponent(buttonCancelar, GroupLayout.PREFERRED_SIZE, 129,
										GroupLayout.PREFERRED_SIZE)
								.addGap(60))
				.addGroup(
						gl_contentPane.createSequentialGroup().addContainerGap(88, Short.MAX_VALUE)
								.addComponent(lblAadirProductoAl, GroupLayout.PREFERRED_SIZE, 428,
										GroupLayout.PREFERRED_SIZE)
								.addGap(36))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(lblFecha, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(txtFecha, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE).addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addComponent(lblAadirProductoAl, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE).addGap(34)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreDelProducto, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNomProducto, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescripcion, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
				.addGap(26)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrecio, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescuento, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDescuento, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCantidadProducto, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addGap(32)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFecha, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonCancelar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}
}
