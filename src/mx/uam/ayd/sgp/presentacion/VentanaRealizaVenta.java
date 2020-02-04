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
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;

public class VentanaRealizaVenta extends JFrame {

	private JPanel contentPane;
	private ControlRealizaVenta controlventa;
	private ControlAlmacen controlAlmacen;
	private Almacen producto;
	private Almacen produtoAnterior;
	private JTable tablePedidosPorMesa;
	/**
	 * Create the frame.
	 */
	public VentanaRealizaVenta(ControlRealizaVenta ctrl) {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\recursosSTARSHOP\\img\\logo.png"));
		controlventa = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblDescuento = new JLabel("Venta");
		lblDescuento.setBounds(15, 16, 33, 16);
		lblDescuento.setFont(new Font("Dialog", Font.BOLD, 12));
		/*
		 * CARACTERISTICAS Y CONFIGURAIONES DEL BOTON QUITAR PRODUCTOS
		 */
		JButton buttonQuitaProductos = new JButton();
		buttonQuitaProductos.setSize(320, 33);
		buttonQuitaProductos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonQuitaProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						
	
				
			}
		});
		buttonQuitaProductos.setText("QUITAR PRODUCTOS");
		buttonQuitaProductos.setSelected(true);
		buttonQuitaProductos.setLocation(new Point(15, 198));
		buttonQuitaProductos.setHideActionText(true);
		buttonQuitaProductos.setForeground(Color.WHITE);
		buttonQuitaProductos.setFont(new Font("Dialog", Font.BOLD, 14));
		buttonQuitaProductos.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		buttonQuitaProductos.setBackground(new Color(0, 171, 197));
		/*
		 * CONFIGURACION Y CARACTERISTICAS DEL BOTON AGREGAR PRODUCTOS
		 */
		JButton btnAgregaProductos = new JButton();
		btnAgregaProductos.setSize(320, 33);
		btnAgregaProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			
			}
		});
		btnAgregaProductos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregaProductos.setText("AGREGAR PRODUCTOS");
		btnAgregaProductos.setSelected(true);
		btnAgregaProductos.setLocation(new Point(15, 242));
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
				
			}
		});
		btnCerrarVenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCerrarVenta.setText("LIQUIDAR VENTA");
		btnCerrarVenta.setSelected(true);
		btnCerrarVenta.setLocation(new Point(15, 296));
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
				setVisible(false);
			}
		});
		btnCancelarVenta.setText("CANCELAR VENTA");
		btnCancelarVenta.setSelected(true);
		btnCancelarVenta.setLocation(new Point(15, 340));
		btnCancelarVenta.setHideActionText(true);
		btnCancelarVenta.setForeground(Color.WHITE);
		btnCancelarVenta.setFont(new Font("Dialog", Font.BOLD, 14));
		btnCancelarVenta.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnCancelarVenta.setBackground(new Color(0, 171, 197));
		/*
		 * CARACTERISTICAS Y CONFIGURACIONES DEL BOTON REGRESAR
		 */
		JButton btnRegresar = new JButton();
		btnRegresar.setBounds(363, 423, 189, 33);
		btnRegresar.setText("REGRESAR");
		btnRegresar.setSelected(true);
		btnRegresar.setHideActionText(true);
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnRegresar.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnRegresar.setBackground(new Color(0, 171, 197));
		
		JLabel label = new JLabel("");
		label.setBounds(384, 226, 159, 191);
		label.setIcon(new ImageIcon("C:\\recursosSTARSHOP\\img\\logo.png"));
		contentPane.setLayout(null);
		
		JScrollPane scrollPaneRealizados = new JScrollPane();
		scrollPaneRealizados.setToolTipText("");
		scrollPaneRealizados.setBounds(15, 63, 507, 124);
		getContentPane().add(scrollPaneRealizados);
		
		tablePedidosPorMesa = new JTable();
		tablePedidosPorMesa.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Folio", "Fecha", "Empleado","Importe" }) {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class<?>[] columnTypes = new Class[] { Integer.class, String.class, String.class, Double.class};
			
			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			
			boolean[] columnEditables = new boolean[] { false, false, false, false };
			
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
			
			public int getRowCount() {
				// TODO Auto-generated method stub
				return 20;
			}		
			
		});
		
		scrollPaneRealizados.setViewportView(tablePedidosPorMesa);
		contentPane.add(scrollPaneRealizados);
		contentPane.add(lblDescuento);
		contentPane.add(buttonQuitaProductos);
		contentPane.add(btnAgregaProductos);
		contentPane.add(btnCancelarVenta);
		contentPane.add(label);
		contentPane.add(btnCerrarVenta);
		contentPane.add(btnRegresar);
	}
	public void alertaMensaje(String mensajeVentana, String tituloventana, int numero) {
		 JOptionPane.showMessageDialog(null, mensajeVentana, tituloventana, numero);
	    }
	/*private void seleccionaMesa(int noMesa){
		System.out.println(noMesa);
		pedido = controlVent.ped(noMesa); 
		pedidosTerminados = controlVent.PedidosFinalizados();
		try{

			for (int i = 0; i < tablePedidosPorMesa.getRowCount(); i++) {
				tablePedidosPorMesa.setValueAt("", i, 0);
				tablePedidosPorMesa.setValueAt("", i, 1);
				tablePedidosPorMesa.setValueAt(null, i, 2);
						
			}
			for (int i = 0; i < pedido.size(); i++) {
				tablePedidosPorMesa.setValueAt(pedido.get(i).getPlatillo().getNombrePlatillo(), i, 0);
				tablePedidosPorMesa.setValueAt(pedido.get(i).getCantidadPlatillo(), i, 1);
				tablePedidosPorMesa.setValueAt(pedido.get(i).getPlatillo().getPrecio(), i, 2);
				
			}
		}catch (Exception e){
			if(pedido.isEmpty()){
				tablePedidosPorMesa.setValueAt("Aun no hay pedidos en esta mesa", 0, 0);
			}

			
		}
		try{	
			for (int i = 0; i < pedidosTerminados.length; i++) {
				tablePedidosTerminados.setValueAt(pedidosTerminados[i].getNoMesa(), i , 0);
				tablePedidosTerminados.setValueAt(pedidosTerminados[i].getPlatillo().getNombrePlatillo(), i, 1);
				tablePedidosTerminados.setValueAt(pedidosTerminados[i].getCantidadPlatillo(), i, 2);
				tablePedidosTerminados.setValueAt(pedidosTerminados[i].getPlatillo().getPrecio(), i, 3);
			}
			}catch (Exception e){


		}
	}*/
	
	
	
	
}


