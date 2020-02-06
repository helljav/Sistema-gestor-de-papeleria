package mx.uam.ayd.sgp.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mx.uam.ayd.sgp.Aplicacion;
import mx.uam.ayd.sgp.modelo.Usuario;
import mx.uam.ayd.sgp.negocio.ControlAutenticacionUsusario;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Canvas;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import app.bolivia.swing.JCTextField;
import java.awt.Dialog.ModalExclusionType;

public class VentanaIniciarSesion extends javax.swing.JFrame {
	private ControlAutenticacionUsusario control;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private app.bolivia.swing.JCTextField txtusuario;
    private JCTextField txtContraseña;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private org.edisoncor.gui.panel.PanelImage panelImage2;
    private org.edisoncor.gui.panel.PanelImage panelImage3;
    private org.edisoncor.gui.panel.PanelImage panelImage4;
    private org.edisoncor.gui.panel.PanelImage panelImage5;
    private org.edisoncor.gui.panel.PanelImage panelImage6;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Metodo ventana error de usuario, no identificado
     */
    public void alertaMensaje() {
    	JOptionPane.showMessageDialog(null,"Usuario no identificado");
    }
	public void alertaMensaje(String mensajeVentana, String tituloventana, int numero) {
		 JOptionPane.showMessageDialog(null, mensajeVentana, tituloventana, numero);
	    }
	



	/**
	 * Create the frame.
	 */
	public VentanaIniciarSesion(ControlAutenticacionUsusario ctrl) {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\Desktop\\Eclipse\\Sistema Gestor de Papeleria\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\\u00EDndice.jpg"));
		control = ctrl;
		
		    jPanel1 = new javax.swing.JPanel();
	        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
	        panelImage2 = new org.edisoncor.gui.panel.PanelImage();
	        panelImage3 = new org.edisoncor.gui.panel.PanelImage();
	        txtusuario = new app.bolivia.swing.JCTextField();
	        jLabel1 = new javax.swing.JLabel();
	        panelImage4 = new org.edisoncor.gui.panel.PanelImage();
	        panelImage5 = new org.edisoncor.gui.panel.PanelImage();
	        jButton1 = new javax.swing.JButton();
	        jButton1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		String usuarioventana = txtusuario.getText();
	        		String contraseñaventana = txtContraseña.getText();					
					control.Autentifica(usuarioventana, contraseñaventana);
					        		
	        	}
	        });
	        panelImage6 = new org.edisoncor.gui.panel.PanelImage();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        jPanel1.setBackground(new java.awt.Color(231, 231, 231));

	        panelImage1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Eclipse\\Sistema Gestor de Papeleria\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\img1.png")); // NOI18N

	        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
	        panelImage1.setLayout(panelImage1Layout);
	        panelImage1Layout.setHorizontalGroup(
	            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 175, Short.MAX_VALUE)
	        );
	        panelImage1Layout.setVerticalGroup(
	            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 180, Short.MAX_VALUE)
	        );

	        //panelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/campos.png"))); // NOI18N

	        panelImage3.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Eclipse\\Sistema Gestor de Papeleria\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\icono1.png")); // NOI18N

	        javax.swing.GroupLayout panelImage3Layout = new javax.swing.GroupLayout(panelImage3);
	        panelImage3.setLayout(panelImage3Layout);
	        panelImage3Layout.setHorizontalGroup(
	            panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 27, Short.MAX_VALUE)
	        );
	        panelImage3Layout.setVerticalGroup(
	            panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 32, Short.MAX_VALUE)
	        );

	        txtusuario.setBorder(null);
	        txtusuario.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
	        txtusuario.setPlaceholder("Nombre de usuario");

	        javax.swing.GroupLayout panelImage2Layout = new javax.swing.GroupLayout(panelImage2);
	        panelImage2.setLayout(panelImage2Layout);
	        panelImage2Layout.setHorizontalGroup(
	            panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(panelImage2Layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(panelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(txtusuario, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
	                .addContainerGap())
	        );
	        panelImage2Layout.setVerticalGroup(
	            panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(panelImage2Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(panelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );

	        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
	        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
	        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel1.setText("Ingrese usuario");

	        //panelImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/campos.png"))); // NOI18N

	        panelImage5.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\Eclipse\\Sistema Gestor de Papeleria\\src\\mx\\uam\\ayd\\sgp\\presentacion\\img\\password1.png")); // NOI18N

	        javax.swing.GroupLayout panelImage5Layout = new javax.swing.GroupLayout(panelImage5);
	        panelImage5.setLayout(panelImage5Layout);
	        panelImage5Layout.setHorizontalGroup(
	            panelImage5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 27, Short.MAX_VALUE)
	        );
	        panelImage5Layout.setVerticalGroup(
	            panelImage5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 32, Short.MAX_VALUE)
	        );
	        
	        txtContraseña = new JCTextField();
	        txtContraseña.setPlaceholder("Contrase\u00F1a");
	        txtContraseña.setFont(new Font("Dialog", Font.BOLD, 18));
	        txtContraseña.setBorder(null);

	        javax.swing.GroupLayout panelImage4Layout = new javax.swing.GroupLayout(panelImage4);
	        panelImage4Layout.setHorizontalGroup(
	        	panelImage4Layout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(panelImage4Layout.createSequentialGroup()
	        			.addContainerGap()
	        			.addComponent(panelImage5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addComponent(txtContraseña, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
	        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        panelImage4Layout.setVerticalGroup(
	        	panelImage4Layout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(panelImage4Layout.createSequentialGroup()
	        			.addContainerGap()
	        			.addGroup(panelImage4Layout.createParallelGroup(Alignment.LEADING)
	        				.addComponent(txtContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(panelImage5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        panelImage4.setLayout(panelImage4Layout);

	        jButton1.setBackground(new java.awt.Color(0, 171, 197));
	        jButton1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
	        jButton1.setForeground(new java.awt.Color(255, 255, 255));
	        jButton1.setText("LOGIN");
	        jButton1.setBorder(null);
	        jButton1.setBorderPainted(false);
	        jButton1.setContentAreaFilled(false);
	        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	        jButton1.setOpaque(true);

	        //panelImage6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/acerca.png"))); // NOI18N

	        javax.swing.GroupLayout panelImage6Layout = new javax.swing.GroupLayout(panelImage6);
	        panelImage6.setLayout(panelImage6Layout);
	        panelImage6Layout.setHorizontalGroup(
	            panelImage6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 0, Short.MAX_VALUE)
	        );
	        panelImage6Layout.setVerticalGroup(
	            panelImage6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 43, Short.MAX_VALUE)
	        );
	        
	        JButton btnSalir = new JButton();
	        btnSalir.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		alertaMensaje("El sistema se cerrara", "Adios", 1);
	        		System.exit(0);
	        	}
	        });
	        btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        btnSalir.setContentAreaFilled(false);
	        btnSalir.setBorderPainted(false);
	        btnSalir.setText("SALIR");
	        btnSalir.setOpaque(true);
	        btnSalir.setForeground(Color.WHITE);
	        btnSalir.setFont(new Font("Dialog", Font.BOLD, 14));
	        btnSalir.setBorder(null);
	        btnSalir.setBackground(new Color(0, 171, 197));

	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	        jPanel1Layout.setHorizontalGroup(
	        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(jPanel1Layout.createSequentialGroup()
	        			.addGap(77)
	        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
	        				.addComponent(panelImage4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(panelImage2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        			.addGap(0, 57, Short.MAX_VALUE))
	        		.addGroup(jPanel1Layout.createSequentialGroup()
	        			.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
	        			.addContainerGap())
	        		.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
	        			.addGap(131)
	        			.addComponent(panelImage1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        			.addPreferredGap(ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
	        			.addComponent(panelImage6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        		.addGroup(jPanel1Layout.createSequentialGroup()
	        			.addGap(37)
	        			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
	        			.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
	        			.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
	        			.addGap(36))
	        );
	        jPanel1Layout.setVerticalGroup(
	        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(jPanel1Layout.createSequentialGroup()
	        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
	        				.addComponent(panelImage6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        				.addGroup(jPanel1Layout.createSequentialGroup()
	        					.addContainerGap()
	        					.addComponent(panelImage1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	        			.addGap(24)
	        			.addComponent(jLabel1)
	        			.addGap(18)
	        			.addComponent(panelImage2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        			.addPreferredGap(ComponentPlacement.UNRELATED)
	        			.addComponent(panelImage4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        			.addGap(45)
	        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
	        				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
	        			.addContainerGap(19, Short.MAX_VALUE))
	        );
	        jPanel1.setLayout(jPanel1Layout);

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );

	        pack();
	    }// </editor-fold>//GEN-END:initComponents
}
