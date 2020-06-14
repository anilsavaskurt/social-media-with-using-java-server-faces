/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import util.Db;
import entity.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author New
 */
public class FriendDao {
    
    public ArrayList<Person> searchUsers(String per) throws ClassNotFoundException{
        
        ArrayList<Person> pList = new ArrayList();
        Db db = new Db();
        Connection con = db.connect();

        String sql = "SELECT * FROM PERSON WHERE (USERNAME LIKE ? OR USERNAME LIKE ? OR USERNAME LIKE ?) AND NOT ID = ?"; 
   
        try{
            if(!per.equals("")){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, per+"%");
            ps.setString(2, per.toUpperCase()+"%");
            ps.setString(3, per.toLowerCase()+"%");
            ps.setInt(4, Person.PersonInstance.getId());
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()){
                Person p = new Person(rs.getInt("ID"),rs.getString("USERNAME"),rs.getString("EMAİL"));
                pList.add(p);
            }
              return pList;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                con.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } 
        return null;
    }
   
    public void ADD(Person friend, Person person){
       
        Db db = new Db();
        Connection con = db.connect();
        String sqlSelect = "SELECT * FROM FRIEND WHERE USERID = ? AND FRIENDID = ?";

        String sql = "INSERT INTO FRIEND(USERID,FRIENDID) VALUES(?,?)"; 
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1,person.getId());
            ps.setInt(2,friend.getId());
            ResultSet  rs = ps.executeQuery();
            
            if(!rs.next())
            ps= con.prepareStatement(sql);
            ps.setInt(1,person.getId());
            ps.setInt(2,friend.getId());
            ps.executeUpdate();
          
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                con.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } 
      
    }
    
    public boolean checkFriend(Person friend){
    
        Db db = new Db();
        Connection con = db.connect();
        String sqlSelect = "SELECT * FROM FRIEND WHERE USERID = ? AND FRIENDID = ?";

        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1,Person.PersonInstance.getId());
            ps.setInt(2,friend.getId());
            ResultSet  rs = ps.executeQuery();
            
            if(!rs.next())
                return false;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                con.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } 
        return true;
    }

    public void DELETE(Person friend, Person person) {
        
        Db db = new Db();
        Connection con = db.connect();
        String sqlSelect = "DELETE FROM FRIEND WHERE USERID = ? AND FRIENDID = ?";

        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1,person.getId());
            ps.setInt(2,friend.getId());
            ps.execute();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                con.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } 
    }
}   
