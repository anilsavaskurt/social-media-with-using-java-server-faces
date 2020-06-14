/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author New
 */
public class Person {
    
    private int id;
    private String username;
    private String email;
    private String password;
    private Post post;
    private Image pp;
    public static Person PersonInstance;
    public static Person UserInstance;
    private String imgName;
    
    public Person(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    
    public Person() {
    }

    
    public Person(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public Person(int id, String username, String email, Post post) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.post = post;
      
    }
    
      public Person(int id, String username, String email, Post post, Image img) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.post = post;
        this.pp = img;
    }
   
            
            public Person(int id, String username, String email, Post post, String  imgName) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.post = post;
        this.imgName =  imgName;
    }
      
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Image getPp() {
        return pp;
    }

    public void setPp(Image pp) {
        this.pp = pp;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", post=" + post + ", comment=" + post.getComment() +'}';
    }

}
