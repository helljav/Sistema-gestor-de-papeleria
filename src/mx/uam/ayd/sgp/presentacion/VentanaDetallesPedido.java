package mx.uam.ayd.sgp.presentacion;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mx.uam.ayd.sgp.modelo.Pedido;
import mx.uam.ayd.sgp.negocio.ControlVentaPedido;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class VentanaDetallesPedido extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ControlVentaPedido controlpedido;
	
	/**
	 * Create the frame.
	 */
	public VentanaDetallesPedido(int ID,ControlVentaPedido ctrl) {
		controlpedido=ctrl;
		///se trae el pedido a consultar
		Pedido p=controlpedido.traePedido(ID);
		String path = new java.io.File("").getAbsolutePath();
		setUndecorated(true);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDetallesDelPedido = new JLabel("Detalles del pedido.");
		lblDetallesDelPedido.setForeground(Color.GRAY);
		lblDetallesDelPedido.setFont(new Font("Dialog", Font.BOLD, 12));
		lblDetallesDelPedido.setBounds(25, 11, 115, 14);
		contentPane.add(lblDetallesDelPedido);
		
		JLabel lblIdPedido = new JLabel("ID Pedido:");
		lblIdPedido.setForeground(Color.GRAY);
		lblIdPedido.setFont(new Font("Dialog", Font.BOLD, 11));
		lblIdPedido.setBounds(25, 53, 56, 14);
		contentPane.add(lblIdPedido);
		
		JLabel lblNombreCliente = new JLabel("Nombre Cliente:");
		lblNombreCliente.setForeground(Color.GRAY);
		lblNombreCliente.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNombreCliente.setBounds(25, 100, 100, 14);
		contentPane.add(lblNombreCliente);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setForeground(Color.GRAY);
		lblFecha.setFont(new Font("Dialog", Font.BOLD, 11));
		lblFecha.setBounds(214, 53, 46, 14);
		contentPane.add(lblFecha);
		
		
		JScrollPane scrollPaneRealizados = new JScrollPane();
		scrollPaneRealizados.setToolTipText("");
		scrollPaneRealizados.setBounds(25, 137, 181,316);
		getContentPane().add(scrollPaneRealizados);
		///se crea la tabla donde se mostraran los productos del pedido
		table = new JTable();
		table.setEnabled(true);
		DefaultTableModel modelo=new DefaultTableModel(new Object[][] {},
				new String[] { "Producto", "Cantidad" }) {

			private static final long serialVersionUID = 1L;
			Class<?>[] columnTypes = new Class[] { Integer.class, String.class};

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
				return 30;
			}

		};
		table.setModel(modelo);
		table.getColumnModel().getColumn(1).setPreferredWidth(171);
		table.setVisible(true);
		scrollPaneRealizados.setViewportView(table);
		table.setBounds(25, 137, 181, 316);
		
		contentPane.add(scrollPaneRealizados);
		
		JLabel lblImporteDejado = new JLabel("Importe Dejado:");
		lblImporteDejado.setForeground(Color.GRAY);
		lblImporteDejado.setFont(new Font("Dialog", Font.BOLD, 11));
		lblImporteDejado.setBounds(214, 355, 95, 14);
		contentPane.add(lblImporteDejado);
		
		JLabel lblImporteTotal = new JLabel("Importe Total:");
		lblImporteTotal.setForeground(Color.GRAY);
		lblImporteTotal.setFont(new Font("Dialog", Font.BOLD, 11));
		lblImporteTotal.setBounds(214, 314, 78, 14);
		contentPane.add(lblImporteTotal);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(path+"\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\bienes.png"));
		label.setBounds(348, 140, 149, 116);
		contentPane.add(label);
		
		JButton button = new JButton("Cerrar");
		button.setBounds(290, 405, 135, 37);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setText("CERRAR");
		button.setSelected(true);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Dialog", Font.BOLD, 14));
		button.setBorder(UIManager.getBorder("EditorPane.border"));
		button.setBackground(new Color(0, 153, 255));
		contentPane.add(button);
		////Aqui enseñamos los detalles del pedido
			String IDpedido=Integer.toString(p.getNumPedido());
			String nombre=p.getNombreCliente() +" "+p.getApellidoCliente();
			String fecha=p.getFechaPedido();
			String importetotal=Double.toString(p.getImporteTotal());
			String importeDejado=Double.toString(p.getImporteDejado());
		JLabel numpedido = new JLabel(IDpedido);
		numpedido.setBounds(91, 53, 61, 14);
		contentPane.add(numpedido);
		
		JLabel fechapedido = new JLabel(fecha);
		fechapedido.setBounds(270, 53, 106, 14);
		contentPane.add(fechapedido);
		
		JLabel cliente = new JLabel(nombre);
		cliente.setBounds(123, 100, 144, 14);
		contentPane.add(cliente);
		
		JLabel importT = new JLabel(importetotal);
		importT.setBounds(314, 314, 72, 14);
		contentPane.add(importT);
		
		JLabel importD = new JLabel(importeDejado);
		importD.setBounds(314, 355, 72, 14);
		contentPane.add(importD);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
			
		});
		
	}
}
