package model;

import java.util.Date;
import java.util.List;

public class Post {
    private String postId;
    private String title;
    private Date date;
    private String text;
    private String image;
    private List<String> commentIds;
    private List<String> likes;

    public Post() {
    }

    public Post(String postId, String title, Date date, String text, String image, List<String> commentIds, List<String> likes) {
        this.postId = postId;
        this.title = title;
        this.date = date;
        this.text = text;
        this.image = image;
        this.commentIds = commentIds;
        this.likes = likes;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<String> getCommentIds() {
        return commentIds;
    }

    public void setCommentIds(List<String> commentIds) {
        this.commentIds = commentIds;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }
    
}
