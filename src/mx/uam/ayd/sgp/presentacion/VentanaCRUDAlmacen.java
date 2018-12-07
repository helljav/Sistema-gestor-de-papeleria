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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\Desktop\\Eclipse\\Sistema Gestor de Papeleria\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\\u00EDndice.jpg"));
		ctrlAlmacen=ctrl1;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 462, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblqueDeseaHacer = new JLabel("\u00BFQue desea hacer?");
		lblqueDeseaHacer.setFont(new Font("Consolas", Font.PLAIN, 16));
		
		/*
		 * Configuracion de la etiqueta Eliminar producto
		 */
		
		JLabel lblEliminarProducto = new JLabel("Eliminar Producto");
		lblEliminarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarProducto.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEliminarProducto.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblEliminarProducto.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Eclipse\\Sistema Gestor de Papeleria\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\eliminarproducto.png"));
		lblEliminarProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrlAlmacen =new ControlAlmacen();
			
			}
		});
		
		JLabel lblAadirProducto = new JLabel("A\u00F1adir Producto");
		lblAadirProducto.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAadirProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirProducto.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblAadirProducto.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Eclipse\\Sistema Gestor de Papeleria\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\a\u00F1adirproducto.png"));
		lblAadirProducto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAadirProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrl1.DespliegaVCRUD();
			}
		});
		
		JLabel lblModificarProducto = new JLabel("Modificar Producto");
		lblModificarProducto.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblModificarProducto.setHorizontalTextPosition(SwingConstants.CENTER);
		lblModificarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarProducto.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Eclipse\\Sistema Gestor de Papeleria\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\modificarproducto.png"));
		
		JLabel label = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(299, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(137))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addComponent(lblEliminarProducto)
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
					.addComponent(lblModificarProducto)
					.addGap(40)
					.addComponent(lblAadirProducto)
					.addGap(50))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(151, Short.MAX_VALUE)
					.addComponent(lblqueDeseaHacer)
					.addGap(132))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblqueDeseaHacer)
					.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(23)
					.addComponent(lblModificarProducto)
					.addGap(31))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(67)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEliminarProducto)
						.addComponent(lblAadirProducto))
					.addContainerGap(102, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
