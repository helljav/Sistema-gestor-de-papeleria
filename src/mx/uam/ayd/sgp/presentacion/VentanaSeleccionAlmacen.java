package mx.uam.ayd.sgp.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mx.uam.ayd.sgp.negocio.ControlAlmacen;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaSeleccionAlmacen extends JFrame {

	private JPanel contentPane;
	private ControlAlmacen ctrlalma;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VentanaSeleccionAlmacen(ControlAlmacen alma1) {
		setUndecorated(true);
		String path = new java.io.File("").getAbsolutePath();
		// setIconImage(Toolkit.getDefaultToolkit().getImage(path+"\\src\\mx\\uam\\ayd\\sgp\\presentacion\\logo.png"));
		setTitle("Seleccionar Almacen");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\logo.png"));
		ctrlalma = alma1;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 458, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		/*
		 * Caracteristicas y configuraciones de almacen general
		 */
		JLabel lblNewLabel = new JLabel("Almacen General");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrlalma.DespliegaVCRUD("Almacen General");
			}
		});
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel.setIcon(new ImageIcon(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\almacenGeneral.png"));

		/*
		 * CARACTERISTICAS Y COFIGURACIONES DEL ALMACEN DIA DE MERTOS
		 */
		JLabel lblNewLabel_1 = new JLabel("Almacen Dia de Muertos2222");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ctrlalma.DespliegaVCRUD("Almacen dia de muertos");
			}
		});
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\almDiaMuertos.png"));

		/*
		 * CARACTERISTICAS Y CONFIGURACIONES DEL ALMCEN DIA DE NAVIDAD
		 */
		JLabel lblNewLabel_2 = new JLabel("Almacen dia de Navidad");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrlalma.DespliegaVCRUD("Almacen dia de navidad");
			}
		});
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\almNavidad.png"));
		/*
		 * CARACTERISTICAS Y CONFIGURACIONES DEL ALMCEN AMOR Y AMISTAD
		 */
		JLabel lblNewLabel_3 = new JLabel("Almacen Amor y Amistad");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrlalma.DespliegaVCRUD("Almacen dia amor y amistad");
			}
		});
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel_3.setIcon(new ImageIcon(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\almAmorAmistad.png"));
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);

		/*
		 * CARACTERISTICAS Y CONFIGURACIONES DEL ALMCEN DIA DE LAS MADRES
		 */
		JLabel lblNewLabel_4 = new JLabel("Almacen dia de las Madres");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrlalma.DespliegaVCRUD("Almacen dia de las madres");
			}
		});
		lblNewLabel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_4.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel_4.setIcon(new ImageIcon(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\almDiaMom.png"));
		lblNewLabel_4.setHorizontalTextPosition(SwingConstants.CENTER);

		/*
		 * CARACTERISTICAS Y CONFIGURACIONES DEL ALMCEN DIA DE INDEPENDENCIA
		 */

		JLabel lblNewLabel_5 = new JLabel("Almacen dia de Independencia");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrlalma.DespliegaVCRUD("Almacen dia de la independencia");
			}
		});
		lblNewLabel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_5.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel_5.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_5.setIcon(new ImageIcon(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\almIndep.png"));

		JButton buttonCancelar = new JButton();
		buttonCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		buttonCancelar.setInheritsPopupMenu(true);
		buttonCancelar.setIgnoreRepaint(true);
		buttonCancelar.setHideActionText(true);
		buttonCancelar.setDefaultCapable(false);
		buttonCancelar.setSelected(true);
		buttonCancelar.setDisabledIcon(null);
		buttonCancelar.setText("CANCELAR");
		buttonCancelar.setForeground(new Color(255, 255, 255));
		buttonCancelar.setFont(new Font("Dialog", Font.BOLD, 14));
		buttonCancelar.setBorder(UIManager.getBorder("EditorPane.border"));
		buttonCancelar.setBackground(new Color(0, 153, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(78)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
						.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5))
				.addGap(26))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
						.addContainerGap(298, Short.MAX_VALUE)
						.addComponent(buttonCancelar, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(24)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(lblNewLabel_2).addGap(31)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 104,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 97,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 120,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(lblNewLabel_3).addGap(133)))
				.addGap(47).addComponent(buttonCancelar, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}
}
