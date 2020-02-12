package mx.uam.ayd.sgp.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mx.uam.ayd.sgp.negocio.ControlAlmacen;
import mx.uam.ayd.sgp.negocio.ControlAutenticacionUsusario;
import mx.uam.ayd.sgp.negocio.ControlConsultaVentas;
import mx.uam.ayd.sgp.negocio.ControlVAdministrador;
import mx.uam.ayd.sgp.persistencia.DAOProducto;
import mx.uam.ayd.sgp.persistencia.DAOUsuario;
import mx.uam.ayd.sgp.persistencia.DAOVenta;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaPrincipalAdministrador extends JFrame {

	private JPanel contentPane;
	private ControlVAdministrador controlVAdmin;
	private ControlConsultaVentas controlconsultaventas;
	
	
	public VentanaPrincipalAdministrador(ControlVAdministrador ctrl) {
		setUndecorated(true);
		controlVAdmin = ctrl;
		setTitle("Sistema papeleria \"Renteria\".  Administrador");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\recursosSTARSHOP\\img\\logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		/*
		 * Configuracion de la etiqueta elegir almacen
		 */
		JLabel lblElegirAlmacen = new JLabel("Administrar almacen");
		lblElegirAlmacen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlVAdmin.DespliegaVSeleccion();
				setExtendedState(ICONIFIED);
				/**DAOProducto dao=new DAOProducto();
				alma=new ControlAlmacen(dao);
				alma.iniciaSeleccionDeAlmacen();**/
			}
		});
		lblElegirAlmacen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblElegirAlmacen.setVerticalAlignment(SwingConstants.TOP);
		lblElegirAlmacen.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblElegirAlmacen.setHorizontalAlignment(SwingConstants.CENTER);
		lblElegirAlmacen.setHorizontalTextPosition(SwingConstants.CENTER);
		lblElegirAlmacen.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblElegirAlmacen.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblElegirAlmacen.setForeground(Color.BLACK);
		lblElegirAlmacen.setBackground(Color.BLUE);
		lblElegirAlmacen.setIcon(new ImageIcon("C:\\recursosSTARSHOP\\img\\icons8-producto-nuevo-64.png"));
		
		JLabel labelRealizarVenta = new JLabel("Realizar venta");
		labelRealizarVenta.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		labelRealizarVenta.setIcon(new ImageIcon("C:\\recursosSTARSHOP\\img\\bienes Empleado.png"));
		labelRealizarVenta.setVerticalTextPosition(SwingConstants.BOTTOM);
		labelRealizarVenta.setVerticalAlignment(SwingConstants.BOTTOM);
		labelRealizarVenta.setHorizontalTextPosition(SwingConstants.CENTER);
		labelRealizarVenta.setHorizontalAlignment(SwingConstants.CENTER);
		labelRealizarVenta.setForeground(Color.BLACK);
		labelRealizarVenta.setFont(new Font("Consolas", Font.PLAIN, 16));
		labelRealizarVenta.setBackground(Color.BLUE);
		labelRealizarVenta.setAlignmentY(1.0f);
		
		JLabel lblRealizarPedido = new JLabel("Realizar pedido");
		lblRealizarPedido.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblRealizarPedido.setIcon(new ImageIcon("C:\\recursosSTARSHOP\\img\\pedido-online Empleado.png"));
		lblRealizarPedido.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblRealizarPedido.setVerticalAlignment(SwingConstants.BOTTOM);
		lblRealizarPedido.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRealizarPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblRealizarPedido.setForeground(Color.BLACK);
		lblRealizarPedido.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblRealizarPedido.setBackground(Color.BLUE);
		lblRealizarPedido.setAlignmentY(1.0f);
		
		JLabel lblConsultaVentas = new JLabel("Consulta ventas");
		lblConsultaVentas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				controlconsultaventas= new ControlConsultaVentas();
				controlconsultaventas.iniciaConsultarVentas();
				controlconsultaventas.recuperaVentas();
				//controlconsultaventa
				
			}
		});
		lblConsultaVentas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblConsultaVentas.setIcon(new ImageIcon("C:\\recursosSTARSHOP\\img\\Query_icon-icons.com_53746.png"));
		lblConsultaVentas.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblConsultaVentas.setVerticalAlignment(SwingConstants.BOTTOM);
		lblConsultaVentas.setHorizontalTextPosition(SwingConstants.CENTER);
		lblConsultaVentas.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaVentas.setForeground(Color.BLACK);
		lblConsultaVentas.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblConsultaVentas.setBackground(Color.BLUE);
		lblConsultaVentas.setAlignmentY(1.0f);
		
		JLabel lblAdministrarUsuarios = new JLabel("Administrar Usuarios");
		lblAdministrarUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAdministrarUsuarios.setIcon(new ImageIcon("C:\\recursosSTARSHOP\\img\\usuario.png"));
		lblAdministrarUsuarios.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblAdministrarUsuarios.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAdministrarUsuarios.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAdministrarUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdministrarUsuarios.setForeground(Color.BLACK);
		lblAdministrarUsuarios.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblAdministrarUsuarios.setBackground(Color.BLUE);
		lblAdministrarUsuarios.setAlignmentY(1.0f);
		
		JLabel lblSalir = new JLabel("Salir");
		lblSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DAOUsuario dao = new DAOUsuario();
				ControlAutenticacionUsusario ctrl = new ControlAutenticacionUsusario(dao);
				ctrl.Inicia();
				setVisible(false);			
				
			}
		});
		lblSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSalir.setIcon(new ImageIcon("C:\\recursosSTARSHOP\\img\\Logout_37127.png"));
		lblSalir.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblSalir.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalir.setForeground(Color.BLACK);
		lblSalir.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblSalir.setBackground(Color.BLUE);
		lblSalir.setAlignmentY(1.0f);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(210)
					.addComponent(lblSalir, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
					.addGap(208))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(labelRealizarVenta, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
						.addComponent(lblConsultaVentas, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
					.addGap(175)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAdministrarUsuarios, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
						.addComponent(lblRealizarPedido, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(220)
					.addComponent(lblElegirAlmacen, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
					.addGap(195))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(lblElegirAlmacen, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(39)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRealizarPedido)
								.addComponent(labelRealizarVenta, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
							.addGap(361))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(146)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblConsultaVentas, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAdministrarUsuarios, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
							.addGap(27)
							.addComponent(lblSalir)
							.addGap(40))))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
