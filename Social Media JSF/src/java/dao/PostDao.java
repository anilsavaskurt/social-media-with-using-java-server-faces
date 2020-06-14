/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Image;
import util.Db;
import entity.Person;
import entity.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author New
 */
public class PostDao {
    
    public void SHARE(Post post, Person person){
        
        Db db = new Db();
        Connection con = db.connect();
        String sql = "INSERT INTO POST(DATA,USER_ID) VALUES(?,?)";
        
        PreparedStatement ps = null;
        try {
           
            ps = con.prepareStatement(sql);
            ps.setString(1, post.getData());
            ps.setInt(2, person.getId());
            ps.executeUpdate();
                
        } catch (SQLException ex) {
            Logger.getLogger(PostDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                con.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } 
    }
    
  public ArrayList<Person> Posts(){
        
         Db db = new Db();
         Connection con = db.connect();
         PreparedStatement ps;
 
         String sql = "SELECT * FROM PERSON INNER JOIN POST ON ID = USER_ID INNER JOIN IMAGE ON IMAGE_USERID = USER_ID INNER JOIN FRIEND ON FRIENDID = USER_ID WHERE USERID = ? ORDER BY CREATEDTIME DESC";
      
         ArrayList<Person> personList=null;
         
         try{
            
                 personList = new ArrayList<>();
                 ps = con.prepareStatement(sql);
                 ps.setInt(1, Person.PersonInstance.getId());
                 ResultSet rs = ps.executeQuery();
                 
                 while(rs.next()){
                  
                     Post post = new Post(rs.getInt("POSTID"),rs.getString("DATA"),rs.getInt("LIKES"),rs.getTimestamp("CREATEDTIME"));
                     Person person = new Person(rs.getInt("ID"),rs.getString("USERNAME"),rs.getString("EMAİL"),post,rs.getString("NAME"));
                     personList.add(person);
                 }
                  
                 
                 
         }catch(SQLException ex){
                ex.printStackTrace();
         }finally{
            try{
                con.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } 
           return personList;
    }
  
  
}
 