package mx.uam.ayd.sgp.presentacion;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.ScrollPane;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import mx.uam.ayd.sgp.modelo.Almacen;
import mx.uam.ayd.sgp.modelo.Usuario;

import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JScrollBar;
import java.awt.ComponentOrientation;
import java.awt.Component;
import mx.uam.ayd.sgp.modelo.Pedido;


public class DialogoMostrarPedido extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JList jListPedidos = null;
	private JButton jButtonAceptar = null;
	private Pedido[] pedidos;
	private JScrollPane scroll;
	
	/**
	 * 
	 * @param owner
	 */	
	public DialogoMostrarPedido(Frame owner, Pedido pedidos[]) {
		// TODO Auto-generated constructor stub
		super(owner, true);
		String path = new java.io.File("").getAbsolutePath();
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\logo.png"));
		initialize();
		// crea una lista de modelos dependiendo del arreglo pasado por el contructor
		DefaultListModel model = new DefaultListModel();
		for (Pedido p : pedidos) {
			model.addElement(p);
		}
		jListPedidos.setModel(model);
	}
	
	/**
	 * Este metodo inicializa la ventana (contentpane)
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(666, 295);
		this.setTitle("Mostrar pedidos");
		this.setContentPane(getJContentPane());
		this.setLocationRelativeTo(null);
	}
	
	
	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJButtonAceptar(), null);
			jListPedidos = new JList();
			jListPedidos.setBounds(74, 22, 360, 187);
			jContentPane.add(getjScrollPane());

		}
		return jContentPane;
	}
	
	/**
	 * This method initializes jLisPedidos
	 *
	 * @return javax.swing.JList
	 */
	private JList getjListPedidos() {
		if (jListPedidos == null) {
			jListPedidos = new JList();
			jListPedidos.setLayoutOrientation(JList.HORIZONTAL_WRAP);
			jListPedidos.setBounds(new Rectangle(0, 13, 650, 190));

		}

		return jListPedidos;
	}
	/**
	 * Estemetodo ayuda a poner un scroll a la tabla al momento de mostrar los pedidos
	 * @return scroll
	 */	
	
	private JScrollPane getjScrollPane() {
		if (scroll == null) {
			scroll = new JScrollPane();
			scroll.setBounds(new Rectangle(0, 13, 650, 190));
			scroll.setViewportView(jListPedidos);

		}

		return scroll;
	}
	
	
	/**
	 * This method initializes jButtonAceptar
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAceptar() {
		if (jButtonAceptar == null) {
			jButtonAceptar = new JButton();
			jButtonAceptar.setBounds(new Rectangle(240, 214, 138, 28));
			jButtonAceptar.setText("Aceptar");
			jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					setVisible(false);
				}
			});
		}
		return jButtonAceptar;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public Pedido getClienteSeleccionado() {

		return (Pedido) jListPedidos.getSelectedValue();
	}
	
	
	
	

}
