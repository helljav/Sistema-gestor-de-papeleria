package mx.uam.ayd.sgp.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.table.DefaultTableModel;

import mx.uam.ayd.sgp.modelo.Pedido;
import mx.uam.ayd.sgp.negocio.ControlVentaPedido;

public class VentanaMuestraPedidos extends JFrame {

	private JPanel contentPane;
	private JTable TablaPedidos;
	private ControlVentaPedido controlpedido;


	/**
	 * Create the frame.
	 */
	public VentanaMuestraPedidos(ControlVentaPedido ctrl) {
		controlpedido=ctrl;
		String path = new java.io.File("").getAbsolutePath();
		//se obtiene la lista de pedidos 
		ArrayList<Pedido> pedidos=controlpedido.traePedidos();
		
		setUndecorated(true);
		
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListaDePedidos = new JLabel("Lista de pedidos");
		lblListaDePedidos.setBounds(31, 11, 121, 33);
		lblListaDePedidos.setForeground(Color.GRAY);
		lblListaDePedidos.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(lblListaDePedidos);
		
		JScrollPane scrollPaneRealizados = new JScrollPane();
		scrollPaneRealizados.setToolTipText("");
		scrollPaneRealizados.setBounds(40, 90, 216,256);
		getContentPane().add(scrollPaneRealizados);
		///se crea la tabla de los pedidos
		TablaPedidos = new JTable();
		TablaPedidos.setEnabled(true);
		DefaultTableModel modelo=new DefaultTableModel(new Object[][] {},
				new String[] { "ID Pedido", "Nombre Cliente" }) {

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
				return pedidos.size()+1;
			}

		};
		///se llena la tabla de los pedidos
		for(int i=0;i<pedidos.size();i++) {
			Pedido p=(Pedido) pedidos.get(i);
			modelo.setValueAt(p.getNumPedido(),i,0);
			modelo.setValueAt(p.getNombreCliente()+" "+p.getApellidoCliente(),i,1);
		}
		TablaPedidos.setModel(modelo);
		TablaPedidos.getColumnModel().getColumn(1).setPreferredWidth(171);
		TablaPedidos.setBounds(40, 90, 216,256);
		TablaPedidos.setVisible(true);
		scrollPaneRealizados.setViewportView(TablaPedidos);
		contentPane.add(scrollPaneRealizados);
		///Se añade ele vento cada que seleccione un registro de la tabla se abrira una ventana
		///donde se mostraran los detalles del pedido seleccionado
		TablaPedidos.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				int punto= TablaPedidos.rowAtPoint(e.getPoint());
				int IDpedido =(int) TablaPedidos.getValueAt(punto, 0);
				controlpedido.MuestraVentanaDetallePedido(IDpedido);
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

		
			
		});
		
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(132, 429, 127, 40);
		contentPane.add(btnRegresar);
		btnRegresar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
			
		});
		btnRegresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegresar.setText("REGRESAR");
		btnRegresar.setSelected(true);
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnRegresar.setBorder(UIManager.getBorder("EditorPane.border"));
		btnRegresar.setBackground(new Color(0, 153, 255));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(path+"\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\logo.png"));
		label.setBounds(312, 214, 138, 132);
		contentPane.add(label);
		
		JLabel lblHagaClickSobre = new JLabel("Haga click sobre un registro\r\n");
		lblHagaClickSobre.setForeground(Color.BLACK);
		lblHagaClickSobre.setFont(new Font("Dialog", Font.BOLD, 11));
		lblHagaClickSobre.setBounds(263, 11, 185, 33);
		contentPane.add(lblHagaClickSobre);
		
		JLabel lblParaVerLos = new JLabel("Para ver los detalles del pedido");
		lblParaVerLos.setForeground(Color.BLACK);
		lblParaVerLos.setFont(new Font("Dialog", Font.BOLD, 11));
		lblParaVerLos.setBounds(263, 55, 216, 14);
		contentPane.add(lblParaVerLos);
	}
}
