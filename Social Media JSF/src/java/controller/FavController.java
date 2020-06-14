package controller;
import dao.FavDao;
import entity.Post;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class FavController implements Serializable{
    
    private Post post ;
    private FavDao favDao;

    public FavController() {
        this.post = new Post();
        this.favDao = new FavDao();
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public FavDao getFavDao() {
        return favDao;
    }

    public void setFavDao(FavDao favDao) {
        this.favDao = favDao;
    }
    
     public void Like(Post post){
 
        this.favDao.addLike(post);
    }

}
