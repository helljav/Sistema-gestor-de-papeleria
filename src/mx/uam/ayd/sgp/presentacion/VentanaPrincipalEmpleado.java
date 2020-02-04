package mx.uam.ayd.sgp.presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import mx.uam.ayd.sgp.negocio.ControlAutenticacionUsusario;
import mx.uam.ayd.sgp.negocio.ControlVEmpleado;
import mx.uam.ayd.sgp.persistencia.DAOUsuario;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.event.KeyEvent;

public class VentanaPrincipalEmpleado extends JFrame {

	private JPanel contentPane;
    private ControlVEmpleado ctrlVE;
   
	/**
	 * Launch the application.
	 */
	
	
	
	
	/**
	 * Create the frame.
	 */
	public VentanaPrincipalEmpleado(ControlVEmpleado ctrl) {
		setUndecorated(true);
		this.ctrlVE=ctrl;
		setTitle("Sistema papeleria \"Renteria\".  Empleado");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\recursosSTARSHOP\\img\\logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblElegirAlmacen = new JLabel("Elegir almacen");
		lblElegirAlmacen.setVerticalAlignment(SwingConstants.TOP);
		lblElegirAlmacen.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblElegirAlmacen.setHorizontalAlignment(SwingConstants.CENTER);
		lblElegirAlmacen.setHorizontalTextPosition(SwingConstants.CENTER);
		lblElegirAlmacen.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblElegirAlmacen.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblElegirAlmacen.setForeground(Color.BLACK);
		lblElegirAlmacen.setBackground(Color.BLUE);
		lblElegirAlmacen.setIcon(new ImageIcon("C:\\recursosSTARSHOP\\img\\icons8-producto-nuevo-64 empleado.png"));
		
		/*
		 * 		Eventos y configuraciones para el label Realizae venta
		 */
		JLabel labelRealizarVenta = new JLabel("Realizar venta");
		labelRealizarVenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelRealizarVenta.setFocusTraversalPolicyProvider(true);
		labelRealizarVenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ctrlVE.iniciaVenta();
				setExtendedState(ICONIFIED);
				System.out.println("Realizar venta");
			}
		});
		labelRealizarVenta.setIcon(new ImageIcon("C:\\recursosSTARSHOP\\img\\bienes.png"));
		labelRealizarVenta.setVerticalTextPosition(SwingConstants.BOTTOM);
		labelRealizarVenta.setVerticalAlignment(SwingConstants.BOTTOM);
		labelRealizarVenta.setHorizontalTextPosition(SwingConstants.CENTER);
		labelRealizarVenta.setHorizontalAlignment(SwingConstants.CENTER);
		labelRealizarVenta.setForeground(Color.BLACK);
		labelRealizarVenta.setFont(new Font("Consolas", Font.PLAIN, 16));
		labelRealizarVenta.setBackground(Color.BLUE);
		labelRealizarVenta.setAlignmentY(1.0f);
		
		/*
		 * 		Evenyos y configuraciones para el label de realizar pedido
		 */
		
		JLabel lblRealizarPedido = new JLabel("Realizar pedido");
		lblRealizarPedido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ctrlVE.iniciaVAdminPedido();
				setExtendedState(ICONIFIED);
			}
		});
		lblRealizarPedido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRealizarPedido.setIcon(new ImageIcon("C:\\recursosSTARSHOP\\img\\pedido-online.png"));
		lblRealizarPedido.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblRealizarPedido.setVerticalAlignment(SwingConstants.BOTTOM);
		lblRealizarPedido.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRealizarPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblRealizarPedido.setForeground(Color.BLACK);
		lblRealizarPedido.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblRealizarPedido.setBackground(Color.BLUE);
		lblRealizarPedido.setAlignmentY(1.0f);
		
		/*
		 * 		Evenyos y configuraciones para el label de consultar ventas
		 */
		
		JLabel lblConsultaVentas = new JLabel("Consulta ventas");
		lblConsultaVentas.setIcon(new ImageIcon("C:\\recursosSTARSHOP\\img\\Query_icon-icons.com_53746 - empleado.png"));
		lblConsultaVentas.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblConsultaVentas.setVerticalAlignment(SwingConstants.BOTTOM);
		lblConsultaVentas.setHorizontalTextPosition(SwingConstants.CENTER);
		lblConsultaVentas.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaVentas.setForeground(Color.BLACK);
		lblConsultaVentas.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblConsultaVentas.setBackground(Color.BLUE);
		lblConsultaVentas.setAlignmentY(1.0f);
		
		/*
		 * 		Evenyos y configuraciones para el label de administrar usuarios
		 */
		
		JLabel lblAdministrarUsuarios = new JLabel("Administrar Usuarios");
		lblAdministrarUsuarios.setIcon(new ImageIcon("C:\\recursosSTARSHOP\\img\\usuario - empleado.png"));
		lblAdministrarUsuarios.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblAdministrarUsuarios.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAdministrarUsuarios.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAdministrarUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdministrarUsuarios.setForeground(Color.BLACK);
		lblAdministrarUsuarios.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblAdministrarUsuarios.setBackground(Color.BLUE);
		lblAdministrarUsuarios.setAlignmentY(1.0f);
		
		/*
		 * 		Evenyos y configuraciones para el label de salir
		 */
		
		JLabel lblCerrarSesion = new JLabel("Cerrar Sesi\u00F3n");
		lblCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DAOUsuario dao = new DAOUsuario();
				ControlAutenticacionUsusario ctrl = new ControlAutenticacionUsusario(dao);
				ctrl.Inicia();
				setVisible(false);
			}
		});
		lblCerrarSesion.setIcon(new ImageIcon("C:\\recursosSTARSHOP\\img\\Logout_37127.png"));
		lblCerrarSesion.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblCerrarSesion.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCerrarSesion.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCerrarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrarSesion.setForeground(Color.BLACK);
		lblCerrarSesion.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblCerrarSesion.setBackground(Color.BLUE);
		lblCerrarSesion.setAlignmentY(1.0f);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(216)
					.addComponent(lblElegirAlmacen, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
					.addGap(202))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(labelRealizarVenta, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblConsultaVentas, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)))
					.addGap(172)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblRealizarPedido, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
						.addComponent(lblAdministrarUsuarios, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
					.addGap(23))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(206)
					.addComponent(lblCerrarSesion, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
					.addGap(212))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(75)
					.addComponent(lblElegirAlmacen, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addComponent(labelRealizarVenta, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addComponent(lblRealizarPedido, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)))
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdministrarUsuarios, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
						.addComponent(lblConsultaVentas, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblCerrarSesion, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
