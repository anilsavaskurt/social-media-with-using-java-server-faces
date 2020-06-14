package dao;
import util.Db;
import entity.Comment;
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

public class ProfileDao{ 
        
        public ArrayList<Person> myPosts(){

               Db db = new Db();
                Connection con = db.connect();
                ArrayList<Person> myPostList = null;
                final String sql = "SELECT * FROM POST  INNER JOIN PERSON ON ID = USER_ID WHERE ID = ? ORDER BY CREATEDTIME DESC";
                
            try {
                 myPostList = new ArrayList<>();
                  PreparedStatement ps = con.prepareStatement(sql);
                  ps.setInt(1, Person.PersonInstance.getId());
                  ResultSet rs = ps.executeQuery();
                  
                  while(rs.next()){
                      Post post = new Post(rs.getInt("POSTID"),rs.getString("DATA"),rs.getInt("LIKES"),rs.getTimestamp("CREATEDTIME"));
                      Person person = new Person(rs.getInt("ID"),rs.getString("USERNAME"),rs.getString("EMAİL"),post);
                      myPostList.add(person); 
                      
                  }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ProfileDao.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            try{
                con.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } 
               return myPostList;
        }
        
        public ArrayList<Person> myFriends(){
            
            
               Db db = new Db();
                Connection con = db.connect();
                ArrayList<Person> myFriendList = null;
                final String sql = "SELECT * FROM PERSON INNER JOIN FRIEND ON ID = FRIENDID WHERE USERID = ?";
              
            try {
                  myFriendList = new ArrayList<>();
                  PreparedStatement ps = con.prepareStatement(sql);
                  ps.setInt(1, Person.PersonInstance.getId());
                  ResultSet rs = ps.executeQuery();
                  
                  while(rs.next()){
                      Person person = new Person(rs.getInt("ID"),rs.getString("USERNAME"),rs.getString("EMAİL"));
                      myFriendList.add(person); 
                  }
                
            } catch (SQLException ex) {
                Logger.getLogger(ProfileDao.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            try{
                con.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } 
               return myFriendList;
           
        }
       
        public void changeUsername(String newUsername){
       
                Db db = new Db();
                Connection con = db.connect();
      
                final String sql = "UPDATE PERSON SET USERNAME = ? WHERE ID = ?";
              
            try {
                
                  PreparedStatement ps = con.prepareStatement(sql);
                  ps.setString(1, newUsername);
                  ps.setInt(2, Person.PersonInstance.getId());
                  ps.executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(ProfileDao.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            try{
                con.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } 

        }
               
        public void changePassword(String newPassword){
            
                Db db = new Db();
                Connection con = db.connect();
     
                final String sql = "UPDATE PERSON SET PASSWORD = ? WHERE ID = ?";
              
            try {
                
                  PreparedStatement ps = con.prepareStatement(sql);
                  ps.setString(1, newPassword);
                  ps.setInt(2, Person.PersonInstance.getId());
                  ps.executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(ProfileDao.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            try{
                con.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } 
        }
}  

