/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import util.Db;
import entity.Image;
import entity.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ImageDao {
    
    
    public ArrayList<Image> All() {
        
         Db db = new Db();
         Connection con = db.connect();
         ArrayList<Image> imageList = new ArrayList<>();
            
        try {
            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM IMAGE");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                Image img = new Image();
                img.setUserId(rs.getInt("IMAGE_USERID"));
                img.setFilePath(rs.getString("PATH"));
                img.setFileName(rs.getString("NAME"));
                img.setFileType(rs.getString("TYPE"));
                imageList.add(img);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                con.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } 
        return imageList;
    }
    
    public void insert(Image img){
        
         Db db = new Db();
         Connection con = db.connect();
         final String sql = "INSERT INTO IMAGE(PATH, NAME, TYPE, IMAGE_USERID) VALUES(?,?,?,?)";
         
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
         
            ps.setString(1, img.getFilePath());
            ps.setString(2, img.getFileName());
            ps.setString(3, img.getFileType());
            ps.setInt(4, img.getUserId());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                con.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } 
    }
    
    public Image getProfilePictrues(Person person){
        
         Db db = new Db();
         Connection con = db.connect();
         final String sql = "SELECT * FROM IMAGE WHERE IMAGE_USERID = ?";
         Image img = new Image();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, person.getId());
            ResultSet rs = ps.executeQuery();
         
            if(rs.next()){
                
                img.setUserId(rs.getInt("IMAGE_USERID"));
                img.setFilePath(rs.getString("PATH"));
                img.setFileName(rs.getString("NAME"));
                img.setFileType(rs.getString("TYPE"));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                con.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } 
       return img;
    }

    public boolean check(Image image) {
         
         Db db = new Db();
         Connection con = db.connect();
         final String sql = "SELECT * FROM IMAGE WHERE IMAGE_USERID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Person.PersonInstance.getId());
            ResultSet rs = ps.executeQuery();
         
            if(rs.next()){
                return true;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                con.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } 
        return false;
    }

    public void update(Image image) {
         
         Db db = new Db();
         Connection con = db.connect();
         final String sql = "UPDATE IMAGE SET NAME = ? , TYPE = ? WHERE IMAGE_USERID = ?";
       
        try {
          
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,image.getFileName());
            ps.setString(2,image.getFileType());
            ps.setInt(3, Person.PersonInstance.getId());
            ps.executeUpdate();  
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                con.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } 
    }
}
