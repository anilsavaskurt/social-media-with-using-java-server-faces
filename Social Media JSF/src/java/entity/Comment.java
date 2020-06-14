/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author New
 */
public class Comment {
    
    private int commentId;
    private String data;
    private int userId;
    private int postId;
    private Timestamp time;
    
    public Comment() {
    }

    public Comment(int commentId, String data, int userId, int postId, Timestamp time) {
        this.commentId = commentId;
        this.data = data;
        this.userId = userId;
        this.postId = postId;
        this.time = time;
    }

    public Comment(int commentId, String data , Timestamp time) {
        this.commentId = commentId;
        this.data = data;
        this.time = time;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
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

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
    
    

    @Override
    public String toString() {
        return "Comment{" + "commentId=" + commentId + ", data=" + data + ", userId=" + userId + ", postId=" + postId + '}';
    }
    
    
}
