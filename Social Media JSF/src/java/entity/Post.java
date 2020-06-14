
package entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author New
 */
public class Post {
    
    private int id;
    private String data;
    private int userId;
    private String userName;
    private Timestamp time;
    private int likes;
    private Comment comment;
    private Image postPic;
    
    public Post(int id, String data, int userId, Timestamp time, int likes) {
        this.id = id;
        this.data = data;
        this.userId = userId;
        this.time = time;
        this.likes = likes;
    }

    public Post() {
    
    }

    public Post(int id, String data, int likes, Timestamp createdTime) {
      this.id = id;
      this.data = data;
      this.likes = likes;
      this.time = createdTime;
    }
    
      public Post(int id, String data, int likes, Timestamp createdTime, Comment comment) {
      this.id = id;
      this.data = data;
      this.likes = likes;
      this.time = createdTime;
      this.comment = comment;
    }
      
     public Post(int id, String data, int likes, Timestamp createdTime, Comment comment, Image pic) {
      this.id = id;
      this.data = data;
      this.likes = likes;
      this.time = createdTime;
      this.comment = comment;
      this.postPic = pic;
    }
     
     public Post(int id, String data, int likes, Timestamp createdTime, Image pic) {
      this.id = id;
      this.data = data;
      this.likes = likes;
      this.time = createdTime;
      this.postPic = pic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Image getPostPic() {
        return postPic;
    }

    public void setPostPic(Image postPic) {
        this.postPic = postPic;
    }
    
     @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Post{id=").append(id);
        sb.append(", data=").append(data);
        sb.append(", userId=").append(userId);
        sb.append(", time=").append(time);
        sb.append(", likes=").append(likes);
        sb.append('}');
        return sb.toString();
    }
    
}
