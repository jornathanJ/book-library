package com.jornathan.booklibrary.model.hibernate;

import org.springframework.lang.NonNull;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class MyBookCommentVO implements Serializable, Cloneable {

  private String tag;
  private long sequence;
  private long userID;
  private Integer rating;

  private String userComment;

  @Id
  @NonNull
  public String getTag() {
    return tag;
  }

  public void setTag(String id) {
    this.tag = id;
  }

  @Column(name = "seq", nullable = false)
  public long getSequence() {
    return sequence;
  }

  public void setSequence(long sequence) {
    this.sequence = sequence;
  }

  @Column(name = "user_id", nullable = false)
  public long getUserID() {
    return userID;
  }

  public void setUserID(long userID) {
    this.userID = userID;
  }

  @Column(name = "rating", nullable = false)
  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  @Column(name = "comment", nullable = false)
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
