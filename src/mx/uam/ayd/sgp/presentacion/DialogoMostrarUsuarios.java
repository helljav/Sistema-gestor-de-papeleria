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

public class DialogoMostrarUsuarios extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JList jListProdutos = null;
	private JButton jButtonAceptar = null;
	private Usuario[] productos;
	private JScrollPane scroll;

	/**
	 * @param owner
	 */
	public DialogoMostrarUsuarios(Frame owner, Usuario users[]) {
		super(owner, true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\Desktop\\Eclipse\\Sistema Gestor de Papeleria\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\\u00EDndice.jpg"));
		initialize();
		//crea una lista de  modelos dependiendo del arreglo pasado por el contructor
		DefaultListModel model = new DefaultListModel();
		for (Usuario a : users) {
			model.addElement(a);
		}
		jListProdutos.setModel(model);
		
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(666, 295);
		this.setTitle("Mostrar productos");
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
			jListProdutos = new JList();
			jListProdutos.setBounds(74, 22, 360, 187);
			jContentPane.add(getjScrollPane());
			
		}
		return jContentPane;
	}

	/**
	 * This method initializes jListLibros
	 *
	 * @return javax.swing.JList
	 */
	private JList getjListProdutos() {
		if (jListProdutos == null) {
			jListProdutos = new JList();
			jListProdutos.setLayoutOrientation(JList.HORIZONTAL_WRAP);
			jListProdutos.setBounds(new Rectangle(0, 13, 650, 190));
			
		}	
		
		return jListProdutos;
	}
	
	private JScrollPane getjScrollPane() {
		if (scroll == null) {
			scroll = new JScrollPane();
			scroll.setBounds(new Rectangle(0, 13, 650, 190));
			scroll.setViewportView(jListProdutos);
			
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
	public Usuario getUsuarioSeleccionado() {
		
		return (Usuario) jListProdutos.getSelectedValue();
	}
}
