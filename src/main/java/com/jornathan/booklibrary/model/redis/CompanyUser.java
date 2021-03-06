package com.jornathan.booklibrary.model.redis;

import java.io.Serializable;

public class CompanyUser implements Serializable {
  private Integer userid;
  private String userName;

  public CompanyUser() {
  }

  public CompanyUser(Integer userid, String userName) {
    this.userid = userid;
    this.userName = userName;
  }

  public Integer getUserid() {
    return userid;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

}
