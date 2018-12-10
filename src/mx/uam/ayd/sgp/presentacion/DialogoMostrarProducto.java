package mx.uam.ayd.sgp.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Rectangle;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import mx.uam.ayd.sgp.modelo.Almacen;

public class DialogoMostrarProducto extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JList jListProdutos = null;
	private JButton jButtonAceptar = null;
	private Almacen[] productos;

	/**
	 * @param owner
	 */
	public DialogoMostrarProducto(Frame owner, Almacen produc[]) {
		super(owner, true);
		initialize();
		//crea una lista de  modelos dependiendo del arreglo pasado por el contructor
		DefaultListModel model = new DefaultListModel();
		for (Almacen a : produc) {
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
		this.setSize(406, 295);
		this.setTitle("Mostrar productos");
		this.setContentPane(getJContentPane());
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
			jContentPane.add(getjListProdutos(), null);
			jContentPane.add(getJButtonAceptar(), null);
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
			jListProdutos.setBounds(new Rectangle(15, 15, 362, 190));
		}
		return jListProdutos;
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
	public Almacen getProductoSeleccionado() {
		
		return (Almacen) jListProdutos.getSelectedValue();
	}

}
