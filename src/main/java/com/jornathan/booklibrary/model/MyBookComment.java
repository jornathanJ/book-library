package com.jornathan.booklibrary.model;

import java.io.Serializable;

public class MyBookComment implements Serializable, Cloneable {

    private Integer sequence;
    private Integer userID;
    private Integer rating;

    private String userComment;

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
