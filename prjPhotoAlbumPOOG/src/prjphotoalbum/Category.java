/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prjphotoalbum;

import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author morgana
 */
public class Category {
    private String name;
    private String creationDate; 
    private ArrayList<Image> album;
    private String description;

    public Category (){
        this.name = "";
        this.creationDate = "";
        this.description = "";
    }

    public Category(String catName, String description) {
        setCreationDate();
        setName(catName);
        setDescription(description);
    }
    
    public void setName (String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void addPhoto(Image p){
        album.add(p);
    }
    
    public void setCreationDate (){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        creationDate = dateFormat.format(date);
    }
    
    public String getCreationDate (){
        return creationDate;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public ArrayList<Image> open(){
        return album;
    }
 
}
