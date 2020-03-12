package mx.uam.ayd.sgp.presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.table.DefaultTableModel;

import mx.uam.ayd.sgp.modelo.Pedido;
import mx.uam.ayd.sgp.modelo.Proveedor;
import mx.uam.ayd.sgp.negocio.ControlProveedores;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;

public class VentanaEliminarProveedor extends JFrame {

	private JPanel contentPane;
	private ControlProveedores ctrl;
	private JTable table;

	public void alertaMensaje(String mensajeVentana, String tituloventana, int numero) {
		JOptionPane.showMessageDialog(null, mensajeVentana, tituloventana, numero);
	}
	/**
	 * Launch the application.
	 * metodo solo para probar la ventana individualmente
	 */
	/**public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEliminarProveedor frame = new VentanaEliminarProveedor();
					frame.setUndecorated(true);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}**/

	/**
	 * Create the frame.
	 */
	public VentanaEliminarProveedor(ControlProveedores control) {
		
		String path = new java.io.File("").getAbsolutePath();
		
		ctrl=control;
		ArrayList<Proveedor> lista=ctrl.traeproveedor();
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\logo.png"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(20, 340, 116, 23);
		btnRegresar.setText("REGRESAR");
		btnRegresar.setSelected(true);
		btnRegresar.setHideActionText(true);
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnRegresar.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnRegresar.setBackground(new Color(0, 171, 197));
		btnRegresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnRegresar);
		btnRegresar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				
			}
				

		});
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(path+"\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\logo.png"));
		label.setBounds(643, 179, 138, 136);
		contentPane.add(label);
		
		JLabel lblEliminarProveedor = new JLabel("Eliminar Proveedor");
		lblEliminarProveedor.setForeground(Color.GRAY);
		lblEliminarProveedor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEliminarProveedor.setBounds(41, 21, 193, 33);
		contentPane.add(lblEliminarProveedor);
		
		JScrollPane scrollPaneRealizados = new JScrollPane();
		scrollPaneRealizados.setToolTipText("");
		scrollPaneRealizados.setBounds(10, 65, 518, 251);
		getContentPane().add(scrollPaneRealizados);
		
		table = new JTable();
		table.setEnabled(true);
		DefaultTableModel modelo=new DefaultTableModel(new Object[][] {},
				new String[] {"ID proveedor", "Nombre o Empresa proveedor","telefono","email","descripcion" }) {

			private static final long serialVersionUID = 1L;
			Class<?>[] columnTypes = new Class[] { Integer.class, String.class};

			

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

		};
		
		for(int i=0;i<lista.size();i++) {
			Proveedor p=(Proveedor) lista.get(i);
			modelo.setValueAt(p.getidproveedor(),i,0);
			modelo.setValueAt(p.getNombre_Empresa(),i,1);
			modelo.setValueAt(p.getNumero_Telefonico(), i, 2);
			modelo.setValueAt(p.getCorreo_Electronico(),i, 3);
			modelo.setValueAt(p.getDescripcion(), i, 4);
		}
		table.setModel(modelo);
		table.getColumnModel().getColumn(1).setPreferredWidth(171);
		table.setBounds(10, 65, 518, 251);
		table.setVisible(true);
		scrollPaneRealizados.setViewportView(table);
		contentPane.add(scrollPaneRealizados);
		
		JLabel lblParaEliminar = new JLabel("Para eliminar");
		lblParaEliminar.setBounds(538, 72, 116, 14);
		contentPane.add(lblParaEliminar);
		
		JLabel lblHagaClickEn = new JLabel("Haga click ");
		lblHagaClickEn.setBounds(538, 89, 84, 14);
		contentPane.add(lblHagaClickEn);
		
		JLabel lblSobreElProveedor = new JLabel("sobre el proveedor.");
		lblSobreElProveedor.setBounds(538, 111, 153, 14);
		contentPane.add(lblSobreElProveedor);
		
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				int punto= table.rowAtPoint(e.getPoint());
				int IDProveedor =(int) table.getValueAt(punto, 0);
				
				if(ctrl.deleteProvider(IDProveedor)) {
					alertaMensaje("El proveedor fue eliminado exitosamente", "operacion exitosa", 1);
					
				}
				else {
					alertaMensaje("El proveedor ya fue eliminado","",1);
				}
				
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
		
	}
}
