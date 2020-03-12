package mx.uam.ayd.sgp.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mx.uam.ayd.sgp.negocio.ControlVEmpleado;
import mx.uam.ayd.sgp.negocio.ControlVentaPedido;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaAdminPedido extends JFrame {

	private JPanel contentPane;
	private ControlVentaPedido controlVE;

	/**
	 * Create the frame.
	 */
	public VentanaAdminPedido(ControlVentaPedido ctrl) {
		controlVE = ctrl;
		setUndecorated(true);
		String path = new java.io.File("").getAbsolutePath();
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\logo.png"));
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
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(40)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(49, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(35)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(17, Short.MAX_VALUE)));
		
		
		//CARACTERISTICAS Y CONFIGURAZIONES DE REGISTRAR PEDIDO

		JLabel lblRegistarPedido = new JLabel("Registrar pedido");
		lblRegistarPedido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controlVE.IniciaVentanaPedido();
			}
		});
		lblRegistarPedido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblRegistarPedido.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblRegistarPedido.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRegistarPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistarPedido
				.setIcon(new ImageIcon(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\Registrar pedido.png"));

		JLabel lblLiquidarPedido = new JLabel("Liquidar pedido");
		lblLiquidarPedido.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLiquidarPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblLiquidarPedido.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblLiquidarPedido
				.setIcon(new ImageIcon(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\Liquidar pedido.png"));
		
		
		
		//CARACTERISTICAS Y CONFIGURACIONES PARA CANCELAR PEDIDO
		
		
		JLabel lblCancelarPedido = new JLabel("Cancelar pedido");
		lblCancelarPedido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controlVE.IniciaVentanaCancelarPedido();
			}
		});
		lblCancelarPedido.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblCancelarPedido.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCancelarPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelarPedido
				.setIcon(new ImageIcon(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\Eliminar pedido.png"));
		
		JLabel consultarpedido = new JLabel("Consultar Pedido");
		consultarpedido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controlVE.MuestraVentanapedidos();
			}
		});
		consultarpedido.setIcon(new ImageIcon(path+"\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\pedido-online.png"));
		consultarpedido.setVerticalTextPosition(SwingConstants.BOTTOM);
		consultarpedido.setHorizontalTextPosition(SwingConstants.CENTER);
		consultarpedido.setHorizontalAlignment(SwingConstants.CENTER);
		

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(35, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblRegistarPedido, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(130))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblCancelarPedido, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(122)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLiquidarPedido, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addComponent(consultarpedido, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
					.addGap(23))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRegistarPedido, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLiquidarPedido, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCancelarPedido, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addComponent(consultarpedido, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
					.addGap(29))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
