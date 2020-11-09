/*
    @javax.persistence.Entity annotation 으로 해당 class가 database 와 mapping 될 것을 선언한다.
    @javax.persistence.Table 은 Mapping 할 database 에 table 을 명시적으로 적어준다.
    @javax.persistence.Id 는 해당 테이블에 ID, @GenerateValue 는 ID 값을 생성할 로직을 말해준다.

 */

package com.jornathan.booklibrary.model.hibernate;


import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity //for Hibernate
@Table(name = "mybooks")  //for Hibernate
public class MyBookVO implements Serializable, Cloneable {

  @Id
  @Column(name = "tag", updatable = false, nullable = false)
  private String tag;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "loaned", nullable = true)
  private Boolean IsLoaned;

  @Column(name = "loaned_extended", nullable = true)
  private Boolean IsLoanedExtended;

  @Column(name = "loaned_user", nullable = true)
  private String loanedUser;

  @Column(name = "return_date", nullable = true)
  private LocalDate returnDate;

  @Column(name = "return_date_expired", nullable = true)
  private LocalDate returnDateExtended;

  @Column(name = "default_loan_day", nullable = true)
  private Integer defaultLoanDay = 14;

  @Column(name = "extended_loan_day", nullable = true)
  private Integer extendLoanDay = 7;

  //private List<MyBookComment> commentList;
  // @OneToOne(fetch = FetchType.LAZY, cascade={CascadeType.ALL})
  @OneToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name = "tag", insertable = false)
  private MybookDetail mybookDetail = new MybookDetail();

  public MyBookVO() {
    this.IsLoaned = false;
  }

  public MyBookVO(String tag, String name, Boolean IsLoaned, Boolean IsLoanedExtended,
                  String loanedUser, LocalDate returnDate,
                  LocalDate returnDateExtended, Integer defaultLoanDay, Integer extendLoanDay) {
    this.tag = tag;
    this.name = name;
    this.IsLoaned = IsLoaned;

    this.IsLoanedExtended = IsLoanedExtended;
    this.loanedUser = loanedUser;
    this.returnDate = returnDate;

    this.returnDateExtended = returnDateExtended;
    this.defaultLoanDay = defaultLoanDay;
    this.extendLoanDay = extendLoanDay;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String id) {
    this.tag = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getLoaned() {
    return IsLoaned;
  }

  public void setLoaned(Boolean loaned) {
    IsLoaned = loaned;
  }

  public Boolean getLoanedExtended() {
    return IsLoanedExtended;
  }

  public void setLoanedExtended(Boolean loanedExtended) {
    IsLoanedExtended = loanedExtended;
  }

  public String getLoanedUser() {
    return loanedUser;
  }

  public void setLoanedUser(String loanedUser) {
    this.loanedUser = loanedUser;
  }

  public LocalDate getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(LocalDate returnDate) {
    this.returnDate = returnDate;
  }

  public LocalDate getReturnDateExtended() {
    return returnDateExtended;
  }

  public void setReturnDateExtended(LocalDate returnDateExtended) {
    this.returnDateExtended = returnDateExtended;
  }

  public Integer getDefaultLoanDay() {
    return defaultLoanDay;
  }

  public void setDefaultLoanDay(Integer defaultLoanDay) {
    this.defaultLoanDay = defaultLoanDay;
  }

  public Integer getExtendLoanDay() {
    return extendLoanDay;
  }

  //    public List<MyBookComment> getCommentList() {
  //        return commentList;
  //    }
  //
  //    public void setCommentList(List<MyBookComment> commentList) {
  //        this.commentList = commentList;
  //    }

  public void setExtendLoanDay(Integer extendLoanDay) {
    this.extendLoanDay = extendLoanDay;
  }

  public MybookDetail getMybookDetail() {
    return mybookDetail;
  }

  public void setMybookDetail(MybookDetail mybookDetail) {
    this.mybookDetail = mybookDetail;
  }

  @Override
  public boolean equals(Object o) {
    return this.tag == ((MyBookVO) o).getTag();
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
