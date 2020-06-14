/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import util.Db;
import entity.Person;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author New
 */
public class PersonDao {
    
    public Person login(Person person) throws ClassNotFoundException{
        
        Db db = new Db();
        Connection con = db.connect();
        
        String sql = "SELECT * FROM PERSON WHERE EMAİL = ? AND PASSWORD = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, person.getEmail());
            ps.setString(2, person.getPassword());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 person.setId(rs.getInt("id"));
                 person.setUsername(rs.getString("username"));
                 person.setEmail(rs.getString("email")); 
                 person.setPassword(rs.getString("password"));
                 
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
        
        return person;
    }
    
    public boolean register(Person person) throws ClassNotFoundException{
        
        Db db = new Db();
        Connection con = db.connect();
        boolean status = false;
        int count = 0;
     
        
         String sql = "INSERT INTO PERSON(USERNAME,EMAİL,PASSWORD) VALUES(?,?,?)";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, person.getUsername());
            ps.setString(2, person.getEmail());
            ps.setString(3, person.getPassword());
            count = ps.executeUpdate();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                con.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } 
        if(count != 0){
            status = true;
        }
        return status;
    }
    
    public boolean forgotPassword(Person person) {
    
        Db db = new Db();
        Connection con = db.connect();
        boolean status = false;
         int flag = 0;
         String sql = "UPDATE PERSON SET PASSWORD = ? WHERE EMAİL = ? AND USERNAME = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, person.getPassword());
            ps.setString(2, person.getEmail());
            ps.setString(3, person.getUsername());
            flag = ps.executeUpdate();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                con.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } 
        
         if(flag != 0){
            status = true;
        }
        return status;
    }
 }
