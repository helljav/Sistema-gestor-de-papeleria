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
import mx.uam.ayd.sgp.modelo.Proveedor;
import mx.uam.ayd.sgp.modelo.Usuario;

import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JScrollBar;
import java.awt.ComponentOrientation;
import java.awt.Component;
public class DialogoMostrarProveedor extends JDialog{
	private static final long serialVersionUID =1L;
	private JPanel jContentPane = null;
	
	private JButton jButtonAceptar = null;
	private JScrollPane scroll;
	private Proveedor[] proveedor;
	private JList JlistProv;
	
	public DialogoMostrarProveedor(Frame owner,ArrayList<Proveedor> prov) {
		super(owner, true);
		String path = new java.io.File("").getAbsolutePath();
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(path + "\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\logo.png"));
		initialize();
		// crea una lista de modelos dependiendo del arreglo pasado por el contructor
		DefaultListModel model = new DefaultListModel();
		for (Proveedor p: prov) {
			model.addElement(p);
		}
		JlistProv.setModel(model);
		
	}
	private void initialize() {
		this.setSize(666, 295);
		this.setTitle("Mostrar Proveedores");
		this.setContentPane(getJContentPane());
		this.setLocationRelativeTo(null);
		
	}
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJButtonAceptar(), null);
			JlistProv = new JList();
			JlistProv.setBounds(74, 22, 360, 187);
			jContentPane.add(getjScrollPane());

		}
		return jContentPane;
	}
	private JList getjListProveedores() {
		if (JlistProv == null) {
			JlistProv = new JList();
			JlistProv.setLayoutOrientation(JList.HORIZONTAL_WRAP);
			JlistProv.setBounds(new Rectangle(0, 13, 650, 190));

		}

		return JlistProv;
	}

	private JScrollPane getjScrollPane() {
		if (scroll == null) {
			scroll = new JScrollPane();
			scroll.setBounds(new Rectangle(0, 13, 650, 190));
			scroll.setViewportView(JlistProv);

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

	public Proveedor getProveedorSeleccionado() {

		return (Proveedor) JlistProv.getSelectedValue();
	}

}
