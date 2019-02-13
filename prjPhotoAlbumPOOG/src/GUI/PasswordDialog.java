/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author morgana
 */
public class PasswordDialog extends javax.swing.JDialog {

    /**
     * Creates new form PasswordDialog
     */
    public PasswordDialog(java.awt.Frame parent, boolean modal, boolean panelVisible) {
        super(parent, modal);
        initComponents();
        setVisibleMsgErr(panelVisible);
        pwd = "";
        returnStatus = RET_RETURN;
    }
    
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        
        
    }
    
    public void setVisibleMsgErr(boolean visible){
        panelMsgPwd.setVisible(visible);
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pwdTxt = new javax.swing.JPasswordField();
        panelMsgPwd = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        bRetun = new javax.swing.JButton();
        bOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jLabel2.setText("Password requested!");
        jPanel3.add(jLabel2);

        jPanel1.add(jPanel3);

        jLabel1.setText(" Insert password:");
        jPanel2.add(jLabel1);

        pwdTxt.setPreferredSize(new java.awt.Dimension(150, 21));
        pwdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdTxtActionPerformed(evt);
            }
        });
        jPanel2.add(pwdTxt);

        jPanel1.add(jPanel2);

        jLabel3.setText("*Incorrect Password");
        panelMsgPwd.add(jLabel3);

        jPanel1.add(panelMsgPwd);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.TRAILING));

        bRetun.setText("Return");
        bRetun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnPressed(evt);
            }
        });
        jPanel4.add(bRetun);

        bOK.setText("OK");
        bOK.setMaximumSize(new java.awt.Dimension(78, 31));
        bOK.setMinimumSize(new java.awt.Dimension(78, 31));
        bOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdInserted(evt);
            }
        });
        jPanel4.add(bOK);

        jPanel1.add(jPanel4);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void returnPressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnPressed
        doClose (RET_RETURN);
    }//GEN-LAST:event_returnPressed

    private void pwdInserted(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdInserted
        pwd = new String(pwdTxt.getPassword());
        doClose(RET_OK);
        
    }//GEN-LAST:event_pwdInserted

    private void pwdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwdTxtActionPerformed
    public int getReturnStatus() {
        return returnStatus;
    }
     
    public String getPwd (){
        return pwd;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bOK;
    private javax.swing.JButton bRetun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel panelMsgPwd;
    private javax.swing.JPasswordField pwdTxt;
    // End of variables declaration//GEN-END:variables
    private int returnStatus; /**<This flag notifies if user wants save or not the category, taking value of {@code RET_CANCEL} or {@code RET_SAVE}.*/
    public static final int RET_RETURN = 0;/**<A return status code - returned if {@code bReturn} button has been pressed.*/
    public static final int RET_OK = 1; /**< A return status code - returned if {@code bOK} button has been pressed.*/
    String pwd;

   
}
