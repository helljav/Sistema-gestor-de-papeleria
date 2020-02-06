package mx.uam.ayd.sgp.presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mx.uam.ayd.sgp.negocio.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

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
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAddUser frame = new VentanaAddUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public VentanaAddUser() {
		
		//adminuser=ctrl;
		adminuser=new ControlAdminUsuario();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAgregarUsuario = new JLabel("Agregar usuario");
		lblAgregarUsuario.setBounds(12, 12, 137, 15);
		contentPane.add(lblAgregarUsuario);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 57, 70, 15);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(12, 103, 70, 15);
		contentPane.add(lblApellidos);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(12, 141, 70, 15);
		contentPane.add(lblTelefono);
		
		JLabel lblIdEmpleado = new JLabel("ID empleado");
		lblIdEmpleado.setBounds(12, 181, 106, 15);
		contentPane.add(lblIdEmpleado);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(12, 230, 70, 15);
		contentPane.add(lblCargo);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(12, 276, 70, 15);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(12, 318, 94, 15);
		contentPane.add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(142, 55, 220, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(142, 101, 220, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(142, 132, 220, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(142, 179, 220, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(143, 228, 219, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(142, 274, 220, 19);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(142, 316, 220, 19);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(260, 402, 117, 25);
		contentPane.add(btnRegistrar);
		btnRegistrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String nombre=textField.getText();
				String apellidos=textField_1.getText();
				String telefono=textField_2.getText();
				int idempleado=Integer.valueOf(textField_3.getText());
				String cargo=textField_4.getText();
				String user=textField_5.getText();
				String pass=textField_6.getText();
				/**
				 * checamos que la contraseña no se relacione con el nombre de usuario
				 * **/
				if(user.contains(pass)) {
					JOptionPane.showMessageDialog(null,"La contraseña no debe relacionarse con el nombre de usuario");
				}
				else {
					if(adminuser.adduser(nombre,apellidos,telefono,idempleado,cargo,user,pass)) {
						JOptionPane.showMessageDialog(null,"Se agrego al usuario exitosamente");
					}
					else {
						JOptionPane.showMessageDialog(null,"No se agrego al usuario");
					}
				}
				
			}
			
		});
		
		JLabel lblRegresar = new JLabel("regresar");
		lblRegresar.setBounds(48, 407, 70, 15);
		contentPane.add(lblRegresar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("E:\\Sistema-gestor-de-papeleria\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\logo.png"));
		label.setBounds(460, 103, 137, 131);
		contentPane.add(label);
		
		
		
	}
}
