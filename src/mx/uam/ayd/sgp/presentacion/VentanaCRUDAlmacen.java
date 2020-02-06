package mx.uam.ayd.sgp.presentacion;

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

public class VentanaCRUDAlmacen extends JFrame {

	private JPanel contentPane;
	private ControlAlmacen ctrlAlmacen;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public VentanaCRUDAlmacen(ControlAlmacen ctrl1) {
		ctrlAlmacen=ctrl1;
		
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\Desktop\\Eclipse\\Sistema Gestor de Papeleria\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\\u00EDndice.jpg"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 512, 338);
		contentPane = new JPanel();
		contentPane.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		setContentPane(contentPane);
		
		JLabel lblqueDeseaHacer = new JLabel("\u00BFQue desea hacer?");
		lblqueDeseaHacer.setFont(new Font("Consolas", Font.PLAIN, 16));
		
		/*
		 * Configuracion de la etiqueta Eliminar producto
		 */
		
		JLabel lblEliminarProducto = new JLabel("Eliminar Producto");
		lblEliminarProducto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblEliminarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarProducto.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEliminarProducto.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblEliminarProducto.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Eclipse\\Sistema Gestor de Papeleria\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\eliminarproducto.png"));
		lblEliminarProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrlAlmacen.DespliegaVEliminarProducto();
			
			}
		});
		/*
		 * CARACTERISTICAS Y CONFIGURACIONES PARA Aï¿½ADIR PRODUCTO
		 */
		JLabel lblAadirProducto = new JLabel("A\u00F1adir Producto");
		lblAadirProducto.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAadirProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirProducto.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblAadirProducto.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Eclipse\\Sistema Gestor de Papeleria\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\a\u00F1adirproducto.png"));
		lblAadirProducto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAadirProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrlAlmacen.DespliegaVAñadirAlamcen();
				//ctrl1.DespliegaVCRUD();
			}
		});
		
		
		/*
		 * CARACTERISTICAS Y CONFIGURACIONES DE MODIFICAR PRODUCTO
		 */
		
		JLabel lblModificarProducto = new JLabel("Modificar Producto");
		lblModificarProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ctrlAlmacen.DespliegaVModificarProducto();
			}
		});
		lblModificarProducto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblModificarProducto.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblModificarProducto.setHorizontalTextPosition(SwingConstants.CENTER);
		lblModificarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarProducto.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Eclipse\\Sistema Gestor de Papeleria\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\modificarproducto.png"));
		
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
					.addContainerGap(349, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(137))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(56)
					.addComponent(lblEliminarProducto)
					.addPreferredGap(ComponentPlacement.RELATED, 247, Short.MAX_VALUE)
					.addComponent(lblAadirProducto)
					.addGap(50))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(362, Short.MAX_VALUE)
					.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(212)
					.addComponent(lblModificarProducto)
					.addContainerGap(211, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(181, Short.MAX_VALUE)
					.addComponent(lblqueDeseaHacer)
					.addGap(178))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(67)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAadirProducto)
								.addComponent(lblEliminarProducto))
							.addPreferredGap(ComponentPlacement.RELATED, 4, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(label)
							.addGap(82)))
					.addGap(19)
					.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblqueDeseaHacer)
					.addPreferredGap(ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
					.addComponent(lblModificarProducto)
					.addGap(55))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
