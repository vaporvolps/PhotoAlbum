/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import prjphotoalbum.Category;

/**
 *
 * @author morgana
 */
public class WindowSelectedCategory extends MainWindow {

    
    public WindowSelectedCategory(String s) {
        setAddButton(s);
        setDefaultCloseOperation(HIDE_ON_CLOSE); //controlla che funzioni,e valuta se fare override
        
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
    
    /*
    private void OpenPhoto (){ // in teoria questa dovrebbe fare override.
        PhotoWindow w = new PhotoWindow();
        w.setVisible(true);
    }
    
    /*
    private void setActionAddButton(){
        getAddButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) { //non funzia
                newElement(evt);
            }
        });
    }*/


       
        /*
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();*/
    // </editor-fold>//GEN-END:initComponents

   /* @Override
    public void actionPerformed(ActionEvent e) {
         String newPhotoPath;
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif", "png", "pdf");
        chooser.setFileFilter(filter);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
           File newPhoto = chooser.getSelectedFile();
           newPhotoPath = newPhoto.toString();
           System.out.println("Il newPhotoPath è : " + newPhotoPath);
           
        }
    }*/


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
