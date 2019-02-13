/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prjphotoalbum;

import GUI.PasswordDialog;
import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author morgana
 */
public class ProtectedCategory extends Category{
    private String hashedPwd;
    private byte [] salt;
    
    public ProtectedCategory(){
        super();
        this.salt = null;
        this.hashedPwd = "";
    }
    
    public ProtectedCategory(String catName, String description, String hashedPwd,byte [] salt){
        super(catName,description);
        setHashedPwd(hashedPwd);
        setSalt (salt);
    }
    
     public void setHashedPwd (String hashedPwd){
        this.hashedPwd = hashedPwd;
    }
    
    public String getPassword(){
        return hashedPwd;
    }
    
    public byte [] getSalt (){
        return salt;
    }
   
    public void setSalt(byte [] salt){
        this.salt = salt;
    }
 
    @Override
    public ArrayList<Image> open() {
        
    }
    
    
    private class PwdIncorrectException extends Exception {
        public PwdIncorrectException (){};
        public PwdIncorrectException( String msg){
            super (msg);
        };
    }
}
