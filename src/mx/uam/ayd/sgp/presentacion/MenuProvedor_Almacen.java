package mx.uam.ayd.sgp.presentacion;
/*********************Include´s******************/
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mx.uam.ayd.sgp.negocio.ControlAlmacen;
import mx.uam.ayd.sgp.negocio.ControlVAdministrador;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class MenuProvedor_Almacen extends JFrame {
	private JPanel contentPane;
	private ControlAlmacen ctrlAlmacen;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 */
	public MenuProvedor_Almacen(ControlAlmacen ctrl1) {
		String path = new java.io.File("").getAbsolutePath();
		ctrlAlmacen=ctrl1;
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 512, 338);
		contentPane = new JPanel();
		contentPane.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		setContentPane(contentPane);
		
		//Creacion del label ¿Que desea hacer?
		JLabel lblqueDeseaHacer = new JLabel("\u00BFQue desea hacer?");
		lblqueDeseaHacer.setFont(new Font("Consolas", Font.PLAIN, 16));
		
		
		
		//Creacion del laberl Proovedores
		JLabel lblProveedores= new JLabel("Proveedores");
		lblProveedores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblProveedores.setHorizontalAlignment(SwingConstants.CENTER);
		lblProveedores.setHorizontalTextPosition(SwingConstants.CENTER);
		lblProveedores.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblProveedores.setIcon(new ImageIcon(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\proveeor.png"));
		lblProveedores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ctrlAlmacen=ctrl1;/*Modificar*/
				ctrlAlmacen.DespliegaVCRUDProveedores();
			
			}
		});
		/*
		 * CARACTERISTICAS Y CONFIGURACIONES PARA AÑADIR PRODUCTO
		 */
		JLabel lblAlmacen = new JLabel("Almacen");
		lblAlmacen.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAlmacen.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlmacen.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblAlmacen.setIcon(new ImageIcon(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\almacenes.png"));
		lblAlmacen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAlmacen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrl1.iniciaSeleccionDeAlmacen();
			}
		});
		
		
		/*
		 * CARACTERISTICAS Y CONFIGURACIONES DE MODIFICAR PRODUCTO
		 */
		
		JLabel lblRegresar = new JLabel("Regresar");
		lblRegresar.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRegresar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegresar.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblRegresar.setIcon(new ImageIcon(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\Logout_37127.png"));
		lblRegresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblRegresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
			}
		});
		JLabel label = new JLabel("");
		
		/*
		 * Caracteristicas y configuraciones del boton cancela
		 */
		JButton btnCancelar = new JButton();
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setText("CANCELAR");
		btnCancelar.setOpaque(true);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnCancelar.setBorder(UIManager.getBorder("EditorPane.border"));
		btnCancelar.setBackground(new Color(0, 171, 197));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(375, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(137))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(181, Short.MAX_VALUE)
					.addComponent(lblqueDeseaHacer)
					.addGap(178))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(58)
					.addComponent(lblProveedores)
					.addPreferredGap(ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
					.addComponent(lblAlmacen)
					.addGap(62))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(236, Short.MAX_VALUE)
					.addComponent(lblRegresar)
					.addGap(224))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(label)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblqueDeseaHacer)
					.addPreferredGap(ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProveedores)
						.addComponent(lblAlmacen))
					.addGap(57)
					.addComponent(lblRegresar)
					.addGap(37))
		);
		contentPane.setLayout(gl_contentPane);
		
		
	}
/*Revisar*/
	public MenuProvedor_Almacen(ControlVAdministrador controlVAdministrador) {
		
	}
	
}
