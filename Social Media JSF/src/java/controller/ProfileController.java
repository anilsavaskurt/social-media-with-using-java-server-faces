package controller;
import dao.ProfileDao;
import entity.Person;
import entity.Post;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class ProfileController implements Serializable{
    
    private Post post ;
    private ArrayList<Person> myPostList;
    private ArrayList<Person> myFriendList;
    private ArrayList<Person> myFavPostList;
    private ProfileDao profilDao;
    private String username;
    private String newPass;
    private String newNick;
    
    public ProfileController() {
        this.post = new Post();
        this.profilDao = new ProfileDao();
        this.myPostList = new ArrayList<>();
        this.myFriendList = new ArrayList<>();
        this.myFavPostList = new ArrayList<>();
        this.username = Person.PersonInstance.getUsername();
        this.getMyPosts();
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public ArrayList<Person> getMyPostList() {
        this.myPostList = this.getProfilDao().myPosts();
        return myPostList;
    }

    public void setMyPostList(ArrayList<Person> myPostList) {
        this.myPostList = myPostList;
    }

    public ArrayList<Person> getMyFriendList() {
        return myFriendList;
    }

    public void setMyFriendList(ArrayList<Person> myFriendList) {
        this.myFriendList = myFriendList;
    }

    public ProfileDao getProfilDao() {
        return profilDao;
    }

    public void setProfilDao(ProfileDao profilDao) {
        this.profilDao = profilDao;
    }

    public ArrayList<Person> getMyFavPostList() {
        return myFavPostList;
    }

    public void setMyFavPostList(ArrayList<Person> myFavPostList) {
        this.myFavPostList = myFavPostList;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public String getNewNick() {
        return newNick;
    }

    public void setNewNick(String newNick) {
        this.newNick = newNick;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public void getMyPosts(){
        
        this.myPostList = this.profilDao.myPosts();
    }
    
    public void getMyFriends(){
        this.myFriendList = this.profilDao.myFriends();
    }
        
    public void changeUsername(){
        this.getProfilDao().changeUsername(this.getNewNick());
        this.username = this.getNewNick();
    }
    
     public void changePassword(){
        this.getProfilDao().changePassword(this.getNewPass());
     }
}
