/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import prjphotoalbum.Category;
import prjphotoalbum.Crypt;
import prjphotoalbum.ProtectedCategory;


/**
 *
 * @author Barbara Giberti
 */
public class MainWindow extends javax.swing.JFrame implements ActionListener{

    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane mainScrollPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton newCategory;
    private ArrayList<Category> photoAlbum;
    
    public MainWindow() {
        initComponents();
        photoAlbum = new ArrayList<>();
        //this.setName("MainWindow");
    }
    
    private void initComponents() {

        mainScrollPanel = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        newCategory = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar(); //SE NON SERVE, SI PUÒ ANDARE A TOGLIERE
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setLocationRelativeTo(null); // this shows the frame in the center of the screen OVVIAMENTE NON FUNZIA PIÙ
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        
        mainScrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        mainScrollPanel.setAutoscrolls(true);

        mainPanel.setBackground(new java.awt.Color(51, 255, 255));
        newCategory.setText("New Category");
        newCategory.setPreferredSize(new java.awt.Dimension(150, 150));
        newCategory.setToolTipText("click on this button if you want to add a new album category");
        newCategory.addActionListener(this);
        mainPanel.add(newCategory);
        mainPanel.setLayout(new WrapLayout(FlowLayout.LEFT));
        mainScrollPanel.setViewportView(mainPanel);

        getContentPane().add(mainScrollPanel);
        
        jMenu1.setText("File"); //TOGLIBILI?
        menuBar.add(jMenu1);

        jMenu2.setText("Edit");
        menuBar.add(jMenu2);

        setJMenuBar(menuBar);
       
        
        pack();
    }
    
    public void setAddButton (String s){
        newCategory.setText(s);
    }
    /*
    public void addElements (){
        int i=0;
        while (i < photoAlbum.size()){
            NewButton(photoAlbum.get(i));
            i++;
        }
    }*/
    
    private void OpenElement(java.awt.event.ActionEvent evt, Category category, boolean msgErr) throws NoSuchAlgorithmException, InvalidKeySpecException{
    	System.out.println("****OPENING ELEMENT******");
    	category.open();
        /*category.open();
        if (category.getPassword().equals("")){
           WindowSelectedCategory w = new WindowSelectedCategory ("Add photo");
           w.setVisible(true);
       }else {
       PasswordDialog p = new PasswordDialog(this,true,msgErr);
       p.setVisible(true);
       int value = p.getReturnStatus();
       if (value == PasswordDialog.RET_OK) { 
            System.out.println("Password presente!");
            String pwd = p.getPwd();
            Crypt encrypt = new Crypt();
            String control = encrypt.get_SHA_512_SecurePassword (pwd, category.getSalt());
            if (control.equals(category.getPassword())){
                System.out.println("corretto");
                WindowSelectedAlbum w = new WindowSelectedAlbum ("Add photo"); // poi dovrò aprire l'interfaccia con la categoria corretta
                w.setVisible(true);
 
            } else {
                System.out.println("non corretto!");
                OpenElement(evt,category, true); //non c'è altro modo?
                }
            }
        }*/
   }
   

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
			if (command.equals("New Category")){
				CategoryDialog d = new CategoryDialog(this, "new Category", true);
				d.setVisible(true);
				int value = d.getReturnStatus();
				System.out.println("Il valore di value è : " + value);
				if (value == CategoryDialog.RET_SAVE){
					Category newCat = d.getCategory();
					JButton bCat = new JButton (newCat.getName());
					photoAlbum.add(newCat);
					System.out.println ("Il nome della categoria è : "+ newCat.getName()+ " ed è stata creata il : " + newCat.getCreationDate());
					bCat.setPreferredSize(new Dimension(150, 150));
			        bCat.addActionListener (this);
			        mainPanel.add(bCat);
			        mainPanel.revalidate();
			        System.out.println("Repainted!");
				}
		}else {
			System.out.println("Opening element");
			//OpenElement(e.getSource(),false);	
		}
		
	}
 

    /*
    public JButton getAddButton (){
        return newCategory;
    }
    
    private void newElement(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newElement
  
        CategoryDialog d = new CategoryDialog(this, "new Category", true);
        d.setVisible(true);
        int value = d.getReturnStatus();
        System.out.println("Il valore di value è : " + value);
        if (value == CategoryDialog.RET_SAVE){
            // if user has clicked on "Save" button
            Category newCat = d.getCategory();
            if (newCat instanceof ProtectedCategory )
                System.out.println("Protected");
            else
                System.out.println("Simple");
            photoAlbum.add(newCat);
            System.out.println ("Il nome della categoria è : "+ newCat.getName()+ " ed è stata creata il : " + newCat.getCreationDate());
            NewButton(newCat);
        }
        
    }//GEN-LAST:event_newElement
    /*
    private void openAlbum(Category cat){
        for (int i = 0; i< photoAlbum.size(); i++){
            if (photoAlbum.get(i) == cat){ 
                WindowSelectedAlbum w = new WindowSelectedAlbum ("Add photo");
                w.setVisible(true);
            }
        }
    }
    
   
*/
     
    
}
