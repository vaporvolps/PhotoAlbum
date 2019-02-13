

/**
 *
 * @author morgana
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import prjphotoalbum.Category;
import prjphotoalbum.Crypt;
import prjphotoalbum.ProtectedCategory;

/**
 *
 * @author morgana
 */
public class CategoryDialog extends javax.swing.JDialog implements ActionListener{
                    
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bSave;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JTextField catNameField;
    private javax.swing.JLabel catNameLabel;
    private javax.swing.JCheckBox checkPwd;
    private javax.swing.JLabel decriptionLabel;
    private javax.swing.JPanel descriptionPanel;
    private javax.swing.JScrollPane descriptionScroll;
    private javax.swing.JTextArea descriptionTxt;
    private javax.swing.JLabel labelConfPwd;
    private javax.swing.JButton loadButton;
    private javax.swing.JPanel midPanel;
    private javax.swing.JPanel passwordPanel;
    private javax.swing.JTextField textConfPwd;
    private javax.swing.JTextField textPwd;
    private javax.swing.JPanel topPanel;              
    private Category cat;
    private String catName;
    private String password;
    private int returnStatus; /**<This flag notifies if user wants save or not the category, taking value of {@code RET_CANCEL} or {@code RET_SAVE}.*/
    public static final int RET_CANCEL = 0;/**<A return status code - returned if {@code bCancel} button has been pressed.*/
    public static final int RET_SAVE = 1;
    byte [] salt;

    /**
     * Creates new form CatalogDIalog
     */
    public CategoryDialog(java.awt.Frame parent,  String title, boolean modal) {
        super(parent,title, modal);
        initComponents();
        setLocationRelativeTo(parent);
        catName="";
        password = "";
        returnStatus = RET_CANCEL; //sets default choice
        
    }
                         
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        catNameLabel = new javax.swing.JLabel();
        catNameField = new javax.swing.JTextField();
        midPanel = new javax.swing.JPanel();
        loadButton = new javax.swing.JButton();
        descriptionPanel = new javax.swing.JPanel();
        decriptionLabel = new javax.swing.JLabel();
        descriptionScroll = new javax.swing.JScrollPane();
        descriptionTxt = new javax.swing.JTextArea();
        passwordPanel = new javax.swing.JPanel();
        checkPwd = new javax.swing.JCheckBox();
        textPwd = new javax.swing.JTextField();
        labelConfPwd = new javax.swing.JLabel();
        textConfPwd = new javax.swing.JTextField();
        bottomPanel = new javax.swing.JPanel();
        bCancel = new javax.swing.JButton();
        bSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        catNameLabel.setText("Insert the new category's name:");
        topPanel.add(catNameLabel);

        catNameField.setPreferredSize(new java.awt.Dimension(150, 23));
        topPanel.add(catNameField);

        getContentPane().add(topPanel);

        midPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 15));

        loadButton.setText("load photos");
        midPanel.add(loadButton);

        descriptionPanel.setLayout(new javax.swing.BoxLayout(descriptionPanel, javax.swing.BoxLayout.Y_AXIS));

        decriptionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        decriptionLabel.setText("Description:");
        descriptionPanel.add(decriptionLabel);

        descriptionTxt.setColumns(20);
        descriptionTxt.setRows(5);
        descriptionScroll.setViewportView(descriptionTxt);

        descriptionPanel.add(descriptionScroll);

        midPanel.add(descriptionPanel);

        passwordPanel.setLayout(new java.awt.GridLayout(2, 2, 2, 7));

        checkPwd.setText("Password");
        checkPwd.addActionListener(this);
        passwordPanel.add(checkPwd);

        textPwd.setEditable(false);
        textPwd.setPreferredSize(new java.awt.Dimension(150, 23));
        passwordPanel.add(textPwd);

        labelConfPwd.setText("Confirm pwd");
        labelConfPwd.setEnabled(false);
        passwordPanel.add(labelConfPwd);

        textConfPwd.setEditable(false);
        textConfPwd.setPreferredSize(new java.awt.Dimension(150, 23));
        passwordPanel.add(textConfPwd);

        midPanel.add(passwordPanel);

        getContentPane().add(midPanel);

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.TRAILING);
        flowLayout1.setAlignOnBaseline(true);
        bottomPanel.setLayout(flowLayout1);

        bCancel.setText("Cancel");
        bCancel.addActionListener(this);
        bottomPanel.add(bCancel);

        bSave.setText("Save");
        bSave.setMaximumSize(new java.awt.Dimension(77, 31));
        bSave.setMinimumSize(new java.awt.Dimension(77, 31));
        bSave.addActionListener(this);
        bottomPanel.add(bSave);

        getContentPane().add(bottomPanel);

        pack();
    }                     
                          
    private String getPassword(){
        return password;
    }
    
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }
                                                          
    public Category getCategory (){
        return cat;
    }
    
     public int getReturnStatus() {
        return returnStatus;
    }

     @Override
 	public void actionPerformed(ActionEvent evt) {
 		Object obj = evt.getSource();
 		if (obj == checkPwd){
 			if (checkPwd.isSelected()){
 	            textPwd.setEditable(true);
 	            labelConfPwd.setEnabled(true);
 	            textConfPwd.setEditable(true);
 	        } else {
 	            textPwd.setEditable(false);
 	            labelConfPwd.setEnabled(false);
 	            textConfPwd.setEditable(false);
 	        }	
 		} else if (obj == bSave){
 			System.out.println("Il nome sarà : *" + catNameField.getText()+"*");
 			if (!catNameField.getText().equals("")){
 	            catName=catNameField.getText();
 			} else {
 	            ErrorDialog er = new ErrorDialog (this,true, "Name must be not null!" );   
 	            er.setVisible(true);
 	            return;
 	        }
 	        if (checkPwd.isSelected()){
 	            if (textPwd.getText().equals(textConfPwd.getText())){    
 	                try {
 	                salt = Crypt.calcSalt();
 	                password = Crypt.get_SHA_512_SecurePassword(textPwd.getText(), salt);
 	                System.out.println(password);
 	                System.out.println ("Password encrypted is : " + password);
 	                cat = new ProtectedCategory (catName, descriptionTxt.getText(),password, salt );
 	                System.out.println("Sto salvando una protectedCategory");
 	                } catch (NoSuchAlgorithmException ex) {
 	                    Logger.getLogger(CategoryDialog.class.getName()).log(Level.SEVERE, null, ex);
 	                }
 	            }  else {
 	                ErrorDialog er = new ErrorDialog ( this,true,"Passwords are not the same!" );
 	                er.setVisible(true);
 	                return;
 	            }
 	        } else {
 	            System.out.println("Sto salvando una Category");
 	            System.out.println(catName);
 	            cat = new Category(catName,descriptionTxt.getText());
 	        }
 	        doClose(RET_SAVE);
 		} else if (obj == bCancel)
 			doClose(RET_CANCEL);
	
 	}

    
/**< A return status code - returned if {@code bSave} button has been pressed.*/
}