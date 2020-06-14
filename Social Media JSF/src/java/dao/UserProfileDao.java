/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Person;
import entity.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Db;

/**
 *
 * @author New
 */
public class UserProfileDao {
    
     public ArrayList<Person> userPosts(Person user){

               Db db = new Db();
                Connection con = db.connect();
                ArrayList<Person> userPostList = null;
                final String sql = "SELECT * FROM POST INNER JOIN PERSON ON ID = USER_ID WHERE ID = ? ORDER BY CREATEDTIME DESC";
                
            try {
                
                  userPostList = new ArrayList<>();
                  PreparedStatement ps = con.prepareStatement(sql);
                  ps.setInt(1, user.getId());
                  ResultSet rs = ps.executeQuery();
                  
                  while(rs.next()){
                      Post post = new Post(rs.getInt("POSTID"),rs.getString("DATA"),rs.getInt("LIKES"),rs.getTimestamp("CREATEDTIME"));
                      Person person = new Person(rs.getInt("ID"),rs.getString("USERNAME"),rs.getString("EMAİL"),post);
                      userPostList.add(person); 
                  }
                 
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally{
            try{
                con.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } 
              return userPostList;
        }
        
        public ArrayList<Person> userFriends(Person user){
            
            
               Db db = new Db();
                Connection con = db.connect();
                ArrayList<Person> userFriendList = null;
                final String sql = "SELECT * FROM PERSON INNER JOIN FRIEND ON ID = FRIENDID WHERE USERID = ?";
              
            try {
                  userFriendList = new ArrayList<>();
                  PreparedStatement ps = con.prepareStatement(sql);
                  ps.setInt(1, user.getId());
                  ResultSet rs = ps.executeQuery();
                  
                  while(rs.next()){
                      Person person = new Person(rs.getInt("ID"),rs.getString("USERNAME"),rs.getString("EMAİL"));
                      userFriendList.add(person); 
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
               return userFriendList;
           
        }
       
}
