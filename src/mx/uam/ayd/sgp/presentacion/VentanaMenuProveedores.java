package mx.uam.ayd.sgp.presentacion;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
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

import mx.uam.ayd.sgp.negocio.ControlAlmacen;
import mx.uam.ayd.sgp.negocio.ControlProveedores;
import mx.uam.ayd.sgp.negocio.ControlVAdministrador;


public class VentanaMenuProveedores extends JFrame {
	private JPanel contentPane;
	private ControlAlmacen ctrlAlmacen;
	private ControlProveedores crtlProveedor;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public VentanaMenuProveedores(ControlAlmacen controlAlmacen) {
		String path = new java.io.File("").getAbsolutePath();
		setUndecorated(true);
		ctrlAlmacen=controlAlmacen;
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 512, 338);
		contentPane = new JPanel();
		contentPane.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		setContentPane(contentPane);
		
		//Creacion del label ¿Que desea hacer?
		JLabel lblqueDeseaHacer = new JLabel("\u00BFQue desea hacer?");
		lblqueDeseaHacer.setFont(new Font("Consolas", Font.PLAIN, 16));
		
		
		
		//Creacion del laberl Proovedores
		JLabel lblAgregarProveedor= new JLabel("Agregar Proveedor");
		lblAgregarProveedor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAgregarProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarProveedor.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAgregarProveedor.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblAgregarProveedor.setIcon(new ImageIcon(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\proveeor.png"));
		lblAgregarProveedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				crtlProveedor =new ControlProveedores();
				crtlProveedor.VentanaAñadirProveedor();
			
			}
		});
		/*
		 * CARACTERISTICAS Y CONFIGURACIONES PARA AÑADIR PRODUCTO
		 */
		JLabel lblEliminaProveedor = new JLabel("EliminarProveedor");
		lblEliminaProveedor.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEliminaProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminaProveedor.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblEliminaProveedor.setIcon(new ImageIcon(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\eliminaP.png"));
		lblEliminaProveedor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblEliminaProveedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//ctrlAlmacen.iniciaSeleccionDeAlmacen();
				//ctrl1.DespliegaVCRUD();
			}
		});
		
		
		/*
		 * CARACTERISTICAS Y CONFIGURACIONES DE MODIFICAR PRODUCTO
		 */
		
		JLabel lblRegresar = new JLabel("Regresar");
		lblRegresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
			}
		});
		lblRegresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRegresar.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblRegresar.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRegresar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegresar.setIcon(new ImageIcon(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\Logout_37127.png"));
		
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
		
		JLabel lblModificarProveedor = new JLabel("Modificar Proveedor");
		lblModificarProveedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				crtlProveedor =new ControlProveedores();
				crtlProveedor.MuestraModificaProveedor();
			}
		});
		lblModificarProveedor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblModificarProveedor.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblModificarProveedor.setHorizontalTextPosition(SwingConstants.CENTER);
		lblModificarProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarProveedor.setIcon(new ImageIcon(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\Logout_37127.png"));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(181, Short.MAX_VALUE)
					.addComponent(lblqueDeseaHacer)
					.addGap(178))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addComponent(lblAgregarProveedor)
					.addGap(55)
					.addComponent(lblModificarProveedor)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label)
							.addGap(137))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
							.addComponent(lblEliminaProveedor)
							.addGap(24))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(226)
					.addComponent(lblRegresar)
					.addContainerGap(234, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblqueDeseaHacer)
							.addPreferredGap(ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAgregarProveedor)
								.addComponent(lblModificarProveedor)
								.addComponent(lblEliminaProveedor))
							.addGap(81)
							.addComponent(lblRegresar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addComponent(label)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		
	}
}
