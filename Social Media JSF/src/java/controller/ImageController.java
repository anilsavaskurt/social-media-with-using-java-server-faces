/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ImageDao;
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

public class ImageController implements Serializable{
   
    private Image image;
    private ArrayList<Image> imageList;
    private ImageDao imageDao;
    private Part doc;
    private final String uploadTo = "C:/Users/New/Documents/NetBeansProjects/JavaWeb1/web/resources/pp/";
  
    public ImageController() {
        
        this.image = new Image();
        this.imageDao = new ImageDao();
        this.imageList = new ArrayList<Image>();
        this.GETMYPP(Person.PersonInstance);
    }

    public String getUploadTo() {
        return uploadTo;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public ArrayList<Image> getImageList() {
        this.imageList = this.getImageDao().All();
        return imageList;
    }

    public void setImageList(ArrayList<Image> imageList) {
        this.imageList = imageList;
    }

    public ImageDao getImageDao() {
        return imageDao;
    }

    public void setImageDao(ImageDao imageDao) {
        this.imageDao = imageDao;
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }

    public String upload(){
        
        try{
                InputStream input = doc.getInputStream();
                String fileName = Paths.get(doc.getSubmittedFileName()).getFileName().toString();
                File f = new File(uploadTo+fileName);
                Files.copy(input,f.toPath());
                
                image = this.getImage();
                image.setFilePath(f.getParent());
                image.setFileName(f.getName());
                image.setFileType(doc.getContentType());
                image.setUserId(Person.PersonInstance.getId());  
                Person.PersonInstance.setPp(image);
                
                if(!this.getImageDao().check(image)){
                     this.getImageDao().insert(image);
                 }else{
                    this.getImageDao().update(image);
                }
                 this.GETMYPP(Person.PersonInstance);
                
        }catch(Exception e){
            e.printStackTrace();
        }
        return "myprofile";
    }
    
    public void GETMYPP(Person person){
        this.image = this.getImageDao().getProfilePictrues(person);
    }
}
