package controller;
import dao.UserProfileDao;
import entity.Image;
import entity.Person;
import entity.Post;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class UserProfileController implements Serializable{
    
    private Person user;
    private Post post ;
    private ArrayList<Person> userPostList;
    private ArrayList<Person> userFriendList;
    private ArrayList<Person> userFavPostList;
    private UserProfileDao userProfilDao;

    public UserProfileController() {
        
        this.user = new Person();
        this.post = new Post();
        this.userProfilDao = new UserProfileDao();
        this.userPostList = new ArrayList<>();
        this.userFriendList = new ArrayList<>();
        this.userFavPostList = new ArrayList<>();
        this.getUserPosts();
        this.getUserFriends();
    }

    public Person getUser() {
        return user;
    }

    public void setUser(Person user) {
        this.user = user;
    }
    
   
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public ArrayList<Person> getUserPostList() {
        this.userPostList = this.getUserProfilDao().userPosts(this.user);
        return userPostList;
    }

    public void setUserPostList(ArrayList<Person> userPostList) {
        this.userPostList = userPostList;
    }

    public ArrayList<Person> getUserFriendList() {
        this.userFriendList = this.getUserProfilDao().userFriends(this.user);
        return userFriendList;
    }

    public void setUserFriendList(ArrayList<Person> userFriendList) {
        this.userFriendList = userFriendList;
    }

    public ArrayList<Person> getUserFavPostList() {
        return userFavPostList;
    }

    public void setUserFavPostList(ArrayList<Person> userFavPostList) {
        this.userFavPostList = userFavPostList;
    }

    public UserProfileDao getUserProfilDao() {
        return userProfilDao;
    }

    public void setUserProfilDao(UserProfileDao userProfilDao) {
        this.userProfilDao = userProfilDao;
    }

    public void getUserPosts(){
        this.userPostList = this.getUserProfilDao().userPosts(this.user);
    }
    
    public void getUserFriends(){
        this.userFriendList = this.getUserProfilDao().userFriends(this.user);
    }
    
   
     public String UserprofileXhtml(Person users){
        this.user = users;
        Person.UserInstance = this.user;
        return "userprofile";
    }
}


