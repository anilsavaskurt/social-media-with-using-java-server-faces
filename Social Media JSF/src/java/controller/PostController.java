package controller;
import dao.PostDao;
import entity.Person;
import entity.Post;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class PostController implements Serializable {
    
    private PostDao postDao;
    private Post post;
    private Person person;
    private ArrayList<Person> personList;

    public PostController() {
        this.postDao = new PostDao();
        this.post = new Post();
        this.person = new Person();
        this.personList = new ArrayList<>();
        this.getPosts();
    }

    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Person getPerson() {
        if(person == null)
            this.person = Person.PersonInstance;
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ArrayList<Person> getPersonList() {
         this.personList = this.postDao.Posts();
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }
    
    public void Share(){
        this.person = Person.PersonInstance;
        this.postDao.SHARE(this.post, this.person);

    }
    
    public void getPosts(){
       
        this.personList = this.postDao.Posts();
    }
}
