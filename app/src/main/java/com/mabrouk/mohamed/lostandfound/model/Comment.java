package com.mabrouk.mohamed.lostandfound.model;

public class Comment {
    private String commentOwnerName;
    private String commentText;
    private int numLikes;
    private int numDislikes;

    public Comment(){
        commentOwnerName = "";
        commentText = "";
        numLikes = 0;
        numDislikes = 0;
    }

    public Comment(String commentOwnerName,
                   String commentText,
                   int numLikes,
                   int numDislikes){
        this.commentOwnerName = commentOwnerName;
        this.commentText = commentText;
        this.numLikes = numLikes;
        this.numDislikes = numDislikes;
    }

    public void setCommentOwnerName(String commentOwnerName) {
        this.commentOwnerName = commentOwnerName;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }

    public void setNumDislikes(int numDislikes) {
        this.numDislikes = numDislikes;
    }

    public String getCommentOwnerName() {
        return commentOwnerName;
    }

    public String getCommentText() {
        return commentText;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public int getNumDislikes() {
        return numDislikes;
    }
}
