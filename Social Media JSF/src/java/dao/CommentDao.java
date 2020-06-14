/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import util.Db;
import entity.Comment;
import entity.Person;
import entity.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author New
 */
public class CommentDao {
    
    public void addComment(Person person, Comment comment){
        
        Db db = new Db();
        Connection con = db.connect();
        
         final String sql = "INSERT INTO COMMENT(COMMENT_DATA,COMMENT_USERID,COMMENT_POSTID) VALUES(?,?,?)";
   
        PreparedStatement ps = null;
              
        try{
                  ps = con.prepareStatement(sql);
                  ps.setString(1, comment.getData());
                  ps.setInt(2, person.getId());
                  ps.setInt(3, comment.getPostId());
                  ps.execute();
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                con.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } 
    }
 
  public ArrayList<Person> GetComments(Post posted){
        
        Db db = new Db();
        Connection con = db.connect();
        
        final String sql = "SELECT * FROM POST INNER JOIN COMMENT ON POSTID = COMMENT_POSTID INNER JOIN PERSON ON ID = COMMENT_USERID WHERE POSTID = ? ORDER BY CREATEDTIME DESC";
        PreparedStatement ps = null;
        ArrayList<Person> personList=null;
        
        try{
            personList = new ArrayList<>();
            ps = con.prepareStatement(sql);
            ps.setInt(1, posted.getId());
            ResultSet rs = ps.executeQuery();
            
             while(rs.next()){
                     Comment comment = new Comment(rs.getInt("COMMENT_ID"),rs.getString("COMMENT_DATA"),rs.getTimestamp("COMMENT_CREATEDTIME"));
                     Post post = new Post(rs.getInt("POSTID"),rs.getString("DATA"),rs.getInt("LIKES"),rs.getTimestamp("CREATEDTIME"),comment);
                     Person person = new Person(rs.getInt("ID"),rs.getString("USERNAME"),rs.getString("EMAİL"),post);
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
