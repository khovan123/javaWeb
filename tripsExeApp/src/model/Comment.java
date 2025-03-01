package model;

import java.util.Date;

public class Comment {
    private String commentId;
    private String userId;
    private Date date;
    private String text;
    private String image;

    public Comment(String commentId, String userId, Date date, String text, String image) {
        this.commentId = commentId;
        this.userId = userId;
        this.date = date;
        this.text = text;
        this.image = image;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
