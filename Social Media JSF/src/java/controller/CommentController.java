package controller;

import dao.CommentDao;
import entity.Comment;
import entity.Person;
import entity.Post;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class CommentController implements Serializable {
    
    private CommentDao commentDao;
    private Comment comment;
    private Post post;
    private String postUser;
    private String commentData;
    private ArrayList<Person> commentList;
    
    public CommentController() {
        this.commentDao = new CommentDao();
        this.post = new Post();
        this.comment = new Comment();
        this.commentList = new ArrayList<>();
        this.getComments();
    }

    public CommentDao getCommentDao() {
        return commentDao;
    }

    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getCommentData() {
        return commentData;
    }

    public void setCommentData(String commentData) {
        this.commentData = commentData;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public ArrayList<Person> getCommentList() {
        return commentList;
    }

    public void setCommentList(ArrayList<Person> commentList) {
        this.commentList = commentList;
    }

    public String getPostUser() {
        return postUser;
    }

    public void setPostUser(String postUser) {
        this.postUser = postUser;
    }
    
    public String toPostXhtml(Person personPost){
        this.post = personPost.getPost();
        this.postUser = personPost.getUsername();
        this.getComments();
        return "post";
    }
    
    public String Comment(){
        this.comment.setPostId(this.post.getId());
        this.commentDao.addComment(Person.PersonInstance,this.comment);
        this.commentList = this.getCommentDao().GetComments(this.post);
        return "post";
    }
    
    public void getComments(){
        
        this.commentList = this.getCommentDao().GetComments(this.post);
    }
    
}
