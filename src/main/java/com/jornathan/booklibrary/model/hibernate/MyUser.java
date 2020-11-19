package com.jornathan.booklibrary.model.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity //for Hibernate
@Table(name = "mybook_user")  //for Hibernate
public class MyUser implements Serializable, Cloneable {
  /**
   * 사번, 사용자한테 직접 입력 받습니다.
   */
  @Id
  @Column(name = "id")
  public String id;

  /**
   * 영문 이름
   */
  @Column(name = "eng_name")
  public String engName;

  @Column(name = "kor_name")
  public String korName;

}
