package controller;
import dao.ImageDao;
import dao.UserImageDao;
import entity.Image;
import entity.Person;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;


@ManagedBean
@SessionScoped

public class UserImageController implements Serializable{
   
    private Person user;
    private Image userImage;
    private UserImageDao userImageDao;
    private Part doc;
    private final String uploadTo = "C:/Users/New/Documents/NetBeansProjects/JavaWeb1/web/resources/pp/";
  
    public UserImageController() {

         this.userImageDao = new UserImageDao();
         this.userImage = this.getUserPP();
          this.user = Person.UserInstance;
    }

    public String getUploadTo() {
        return uploadTo;
    }

    public Person getUser() {
        return user;
    }

    public void setUser(Person user) {
        this.user = user;
    }

    public Image getUserImage() {
        return userImage;
    }

    public void setUserImage(Image image) {
        this.userImage = image;
    }

    public UserImageDao getUserImageDao() {
        return userImageDao;
    }

    public void setUserImageDao(UserImageDao imageDao) {
        this.userImageDao = imageDao;
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }
    
    public Image getUserPP(){
        this.user = Person.UserInstance;
        this.userImage  = this.getUserImageDao().getProfilePictrues(this.user);
        return this.userImage;
    }
}
