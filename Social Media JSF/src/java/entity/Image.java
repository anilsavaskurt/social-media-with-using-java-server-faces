
package entity;

import javax.servlet.http.Part;

public class Image {
    
    private int userId;
    private int postId;
    private String filePath;
    private String fileName;
    private String fileType;
    private Part document;

    public Image(String filePath, String fileName, String fileType, int postId) {
        this.postId = postId;
        this.filePath = filePath;
        this.fileName = fileName;
        this.fileType = fileType;
    }

    public Image() {
    }
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Part getDocument() {
        return document;
    }

    public void setDocument(Part document) {
        this.document = document;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

}
