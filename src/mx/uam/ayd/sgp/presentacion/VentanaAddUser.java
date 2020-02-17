package mx.uam.ayd.sgp.presentacion;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import mx.uam.ayd.sgp.negocio.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class VentanaAddUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private ControlAdminUsuario adminuser;

	/**
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { VentanaAddUser frame = new
	 * VentanaAddUser(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 **/

	public VentanaAddUser(ControlAdminUsuario ctrl) {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		String path = new java.io.File("").getAbsolutePath();
		adminuser = ctrl;

		setIconImage(
				Toolkit.getDefaultToolkit().getImage(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\logo.png"));
		setBounds(100, 100, 649, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(142, 55, 358, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(142, 102, 358, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(142, 149, 358, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(142, 190, 358, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(142, 238, 357, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(142, 280, 358, 19);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(142, 316, 358, 19);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(10, 399, 189, 33);

		btnRegistrar.setText("REGISTRAR");
		btnRegistrar.setSelected(true);
		btnRegistrar.setHideActionText(true);
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnRegistrar.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnRegistrar.setBackground(new Color(0, 171, 197));
		btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnRegistrar);

		btnRegistrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i;
				String nombre = textField.getText().toUpperCase();
				String apellidos = textField_1.getText().toUpperCase();
				String telefono = textField_2.getText();
				int idempleado = Integer.valueOf(textField_3.getText());
				String cargo = textField_4.getText().toUpperCase();
				String user = textField_5.getText();
				String pass = textField_6.getText();
				/**
				 * checamos que la contraseÃ±a no se relacione con el nombre de usuario
				 **/
				if (user.contains(pass)) {
					JOptionPane.showMessageDialog(null, "La contraseña no debe relacionarse con el nombre de usuario");
				} else {
					if (adminuser.adduser(nombre, apellidos, telefono, idempleado, cargo, user, pass)) {
						JOptionPane.showMessageDialog(null, "Se agrego al usuario exitosamente");
					} else {
						JOptionPane.showMessageDialog(null, "No se agrego al usuario");
					}
				}

			}

		});

		JLabel label = new JLabel("");
		label.setBounds(496, 163, 137, 120);
		label.setIcon(new ImageIcon(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\logo.png"));
		contentPane.add(label);

		JLabel lblAadirUsuarioNuevo = new JLabel();
		lblAadirUsuarioNuevo.setBounds(117, 11, 428, 32);
		lblAadirUsuarioNuevo.setText("A\u00F1adir usuario nuevo");
		lblAadirUsuarioNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirUsuarioNuevo.setForeground(new Color(153, 153, 153));
		lblAadirUsuarioNuevo.setFont(new Font("Dialog", Font.BOLD, 24));
		contentPane.add(lblAadirUsuarioNuevo);

		JLabel lblNombre = new JLabel();
		lblNombre.setBounds(3, 54, 129, 20);
		lblNombre.setText("Nombres:");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(lblNombre);

		JLabel lblApellidos = new JLabel();
		lblApellidos.setBounds(3, 101, 129, 19);
		lblApellidos.setText("Apellidos:");
		lblApellidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidos.setForeground(Color.BLACK);
		lblApellidos.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(lblApellidos);

		JLabel lblTelofono = new JLabel();
		lblTelofono.setBounds(3, 144, 129, 16);
		lblTelofono.setText("Telefono:");
		lblTelofono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelofono.setForeground(Color.BLACK);
		lblTelofono.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(lblTelofono);

		JLabel lblID = new JLabel();
		lblID.setBounds(3, 187, 129, 25);
		lblID.setText("ID Empleado:");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setForeground(Color.BLACK);
		lblID.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(lblID);

		JLabel lblCargo = new JLabel();
		lblCargo.setBounds(3, 235, 129, 25);
		lblCargo.setText("Cargo del empleado:");
		lblCargo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargo.setForeground(Color.BLACK);
		lblCargo.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(lblCargo);

		JLabel lblUsuario = new JLabel();
		lblUsuario.setBounds(3, 277, 129, 25);
		lblUsuario.setText("Nombre de usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(lblUsuario);

		JLabel lblContrasea = new JLabel();
		lblContrasea.setBounds(3, 313, 129, 25);
		lblContrasea.setText("Contrase\u00F1a:");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setForeground(Color.BLACK);
		lblContrasea.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(lblContrasea);

		JButton btnRegresar = new JButton("REGRESAR");
		btnRegresar.setBounds(434, 399, 189, 33);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnRegresar.setSelected(true);
		btnRegresar.setHideActionText(true);
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnRegresar.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnRegresar.setBackground(new Color(0, 171, 197));
		contentPane.add(btnRegresar);

	}
}
