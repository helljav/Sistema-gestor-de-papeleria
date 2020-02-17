package mx.uam.ayd.sgp.presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import mx.uam.ayd.sgp.negocio.ControlAdminUsuario;

public class ventanaCRUDAdminUsuarios extends JFrame {

	private JPanel contentPane;
	private ControlAdminUsuario ctrlUsuario;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public ventanaCRUDAdminUsuarios(ControlAdminUsuario ctrl1) {
		ctrlUsuario = ctrl1;
		String path = new java.io.File("").getAbsolutePath();
		setUndecorated(true);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\logo.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 536, 338);
		contentPane = new JPanel();
		contentPane.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		setContentPane(contentPane);

		JLabel lblqueDeseaHacer = new JLabel("\u00BFQue desea hacer?");
		lblqueDeseaHacer.setFont(new Font("Consolas", Font.PLAIN, 16));

		/*
		 * Configuracion de la etiqueta Eliminar usuario
		 */

		JLabel lblEliminarUsuario = new JLabel("Eliminar Usuario");
		lblEliminarUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblEliminarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarUsuario.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEliminarUsuario.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblEliminarUsuario
				.setIcon(new ImageIcon(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\eliminarproducto.png"));
		lblEliminarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrlUsuario.DespliegaVEliminaUsuario();
				// ctrlAlmacen.DespliegaVEliminarProducto();

			}
		});
		/*
		 * CARACTERISTICAS Y CONFIGURACIONES PARA AÑADIR usuario
		 */
		JLabel lblAadirUsuario = new JLabel("A\u00F1adir Usuario");
		lblAadirUsuario.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAadirUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirUsuario.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblAadirUsuario
				.setIcon(new ImageIcon(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\a\u00F1adirproducto.png"));
		lblAadirUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAadirUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrlUsuario.agregausuario();
				// ctrlAlmacen.DespliegaVAñadirAlamcen();
				// ctrl1.DespliegaVCRUD();
			}
		});

		/*
		 * CARACTERISTICAS Y CONFIGURACIONES DE MODIFICAR usuario
		 */

		JLabel lblModificarUsuario = new JLabel("Modificar Usuario");
		lblModificarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ctrlUsuario.DespliegaVModificarUsuario();
			}
		});
		lblModificarUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblModificarUsuario.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblModificarUsuario.setHorizontalTextPosition(SwingConstants.CENTER);
		lblModificarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarUsuario
				.setIcon(new ImageIcon(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\modificarproducto.png"));

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

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\logo.png"));
		lblLogo.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblLogo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(200, Short.MAX_VALUE)
								.addComponent(lblqueDeseaHacer).addGap(183))
						.addGroup(
								gl_contentPane.createSequentialGroup()
										.addGroup(
												gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
														.addGroup(gl_contentPane
																.createSequentialGroup()
																.addContainerGap(GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(lblAadirUsuario))
														.addComponent(lblLogo, Alignment.LEADING,
																GroupLayout.PREFERRED_SIZE, 131,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
														.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 140,
																GroupLayout.PREFERRED_SIZE)
														.addContainerGap())
												.addGroup(Alignment.TRAILING,
														gl_contentPane.createSequentialGroup()
																.addComponent(lblModificarUsuario).addGap(216))
												.addGroup(Alignment.TRAILING,
														gl_contentPane.createSequentialGroup().addComponent(label)
																.addGap(137))
												.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
														.addComponent(lblEliminarUsuario).addGap(30)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup().addGap(67)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblAadirUsuario).addComponent(lblEliminarUsuario))
												.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
												.addComponent(lblqueDeseaHacer)
												.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
												.addComponent(label).addGap(82)))
						.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 34,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblModificarUsuario)
										.addGap(67))
								.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))));
		contentPane.setLayout(gl_contentPane);

	}
}
