package mx.uam.ayd.sgp.presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mx.uam.ayd.sgp.negocio.ControlProveedor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class VentanaEliminarProveedor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private ControlProveedor ctrl;

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
	public VentanaEliminarProveedor(ControlProveedor control) {
		
		String path = new java.io.File("").getAbsolutePath();
		ctrl=control;
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\logo.png"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreProveedor = new JLabel("Nombre proveedor");
		lblNombreProveedor.setBounds(10, 40, 121, 14);
		lblNombreProveedor.setText("Nombre Proveedor:");
		lblNombreProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreProveedor.setForeground(Color.BLACK);
		lblNombreProveedor.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(lblNombreProveedor);
		
		textField = new JTextField();
		textField.setBounds(166, 37, 193, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(41, 153, 116, 23);
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
		
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(219, 153, 140, 23);
		btnEliminar.setText("ELIMINAR");
		btnEliminar.setSelected(true);
		btnEliminar.setHideActionText(true);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnEliminar.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnEliminar.setBackground(new Color(0, 171, 197));
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);
		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nombreC=textField.getText();
				if(ctrl.deleteProvider(nombreC)) {
					JOptionPane.showMessageDialog(null, "Se elimino al proveedor exitosamente");
				}
				else {
					JOptionPane.showMessageDialog(null, "El proveedor ya fue eliminado");
				}
				
			}
				

		});
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(path+"\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\logo.png"));
		label.setBounds(418, 40, 138, 136);
		contentPane.add(label);
	}
}
