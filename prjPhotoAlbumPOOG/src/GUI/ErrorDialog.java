/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author morgana
 */
public class ErrorDialog extends javax.swing.JDialog implements ActionListener {

    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelError;
    
    ErrorDialog(Dialog parent, boolean modal, String err) {
    	super(parent,modal);
        initComponents();
        labelError.setText(err);
        pack(); 
        
    }

    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        labelError = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        labelError.setText("Error!");
        jPanel2.add(labelError);

        getContentPane().add(jPanel2);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.TRAILING));

        jButton2.setText("OK");
        jButton2.addActionListener(this);
        jPanel1.add(jButton2);
        
        getContentPane().add(jPanel1);

    }

	@Override
	public void actionPerformed(ActionEvent e) {
		 setVisible(false);
	        dispose();
		
	}

}
