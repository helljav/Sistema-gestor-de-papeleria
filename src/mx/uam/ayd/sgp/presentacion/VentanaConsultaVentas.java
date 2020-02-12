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

public class VentanaConsultaVentas extends JFrame {

	private JPanel contentPane;
	private ControlConsultaVentas consultarventa;
	private ControlAlmacen controlAlmacen;
	private Almacen producto;
	int contador=0;;
	//private Almacen produtoAnterior;
	JTable tablaVenta;
	private JTextField textFieldVentaTotal;
	/**
	 * Create the frame.
	 */
	
	public VentanaConsultaVentas(ControlConsultaVentas controlconsultarventas) {

		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\recursosSTARSHOP\\img\\logo.png"));
		consultarventa = controlconsultarventas;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblDescuento = new JLabel("Venta");
		lblDescuento.setBounds(15, 16, 33, 16);
		lblDescuento.setFont(new Font("Dialog", Font.BOLD, 12));
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
		label.setBounds(28, 273, 149, 160);
		label.setIcon(new ImageIcon("C:\\recursosSTARSHOP\\img\\logo.png"));
		contentPane.setLayout(null);
		
		JScrollPane scrollPaneRealizados = new JScrollPane();
		scrollPaneRealizados.setToolTipText("");
		scrollPaneRealizados.setBounds(10, 43, 507, 180);
		getContentPane().add(scrollPaneRealizados);
		
		tablaVenta = new JTable();
		tablaVenta.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "NUMERO DE FOLIO", "FECHA", "EMPLEADO","IMPORTE TOTAL" }) {
			
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
		
		scrollPaneRealizados.setViewportView(tablaVenta);
		contentPane.add(scrollPaneRealizados);
		contentPane.add(lblDescuento);
		contentPane.add(label);
		contentPane.add(btnRegresar);
		
		JLabel lblImporteTotalDel = new JLabel("IMPORTE TOTAL DEL DIA ");
		lblImporteTotalDel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblImporteTotalDel.setBounds(187, 273, 201, 33);
		contentPane.add(lblImporteTotalDel);
		
		textFieldVentaTotal = new JTextField();
		textFieldVentaTotal.setEditable(false);
		textFieldVentaTotal.setBounds(398, 273, 119, 28);
		contentPane.add(textFieldVentaTotal);
		textFieldVentaTotal.setColumns(10);
	}
	public void llenarT(ArrayList<Venta> venta) {
		//boolean Total
		for (int i=0;i<tablaVenta.getRowCount();i++) {
		tablaVenta.setValueAt(venta.get(i).getNumFolio(), i,0 );
		tablaVenta.setValueAt(venta.get(i).getFechaVenta(), i,1 );
		tablaVenta.setValueAt(venta.get(i).getEmpleado(), i,2 );
		tablaVenta.setValueAt(venta.get(i).getImporte(), i,3 );
		}

	}
	public void alertaMensaje(String mensajeVentana, String tituloventana, int numero) {
		 JOptionPane.showMessageDialog(null, mensajeVentana, tituloventana, numero);
	    }

//	vRv.tablaVenta.setValueAt(producto.getNombreProducto(),vRv.contador , 0);
//	vRv.tablaVenta.setValueAt(producto.getPrecioProducto(), vRv.contador, 1);
//	vRv.tablaVenta.setValueAt(producto.getCantidadProducto(),vRv.contador, 2);
//	vRv.tablaVenta.setValueAt(producto.getCantidadProducto()*producto.getPrecioProducto(),vRv.contador, 3);	
//	vRv.contador++;
	
	
}
