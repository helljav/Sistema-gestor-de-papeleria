package mx.uam.ayd.sgp.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mx.uam.ayd.sgp.negocio.ControlVEmpleado;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Point;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAdminPedido extends JFrame {

	private JPanel contentPane;
	private ControlVEmpleado controlVE;

	/**
	 * Create the frame.
	 */
	public VentanaAdminPedido(ControlVEmpleado ctrl) {
		controlVE = ctrl;
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\recursosSTARSHOP\\img\\logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		/*
		 * Configuracion del boton cancelar
		 */
		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setText("CANCELAR");
		button.setSelected(true);
		button.setLocation(new Point(28, 14));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Dialog", Font.BOLD, 14));
		button.setBorder(UIManager.getBorder("EditorPane.border"));
		button.setBackground(new Color(0, 153, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		
		JLabel lblRegistarPedido = new JLabel("Registrar pedido");
		lblRegistarPedido.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblRegistarPedido.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRegistarPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistarPedido.setIcon(new ImageIcon("C:\\recursosSTARSHOP\\img\\Registrar pedido.png"));
		
		JLabel lblLiquidarPedido = new JLabel("Liquidar pedido");
		lblLiquidarPedido.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLiquidarPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblLiquidarPedido.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblLiquidarPedido.setIcon(new ImageIcon("C:\\recursosSTARSHOP\\img\\Liquidar pedido.png"));
		
		JLabel lblCancelarPedido = new JLabel("Cancelar pedido");
		lblCancelarPedido.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblCancelarPedido.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCancelarPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelarPedido.setIcon(new ImageIcon("C:\\recursosSTARSHOP\\img\\Eliminar pedido.png"));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(35)
					.addComponent(lblRegistarPedido, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(130)
					.addComponent(lblLiquidarPedido, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(26))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(160, Short.MAX_VALUE)
					.addComponent(lblCancelarPedido, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(142))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRegistarPedido, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLiquidarPedido, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(lblCancelarPedido, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
