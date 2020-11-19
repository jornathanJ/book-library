/*
    @javax.persistence.Entity annotation 으로 해당 class가 database 와 mapping 될 것을 선언한다.
    @javax.persistence.Table 은 Mapping 할 database 에 table 을 명시적으로 적어준다.
    @javax.persistence.Id 는 해당 테이블에 ID, @GenerateValue 는 ID 값을 생성할 로직을 말해준다.

 */

package com.jornathan.booklibrary.model.hibernate;


import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity //for Hibernate
@Table(name = "mybooks")  //for Hibernate
// TYPE:001 - @Inheritance(strategy = InheritanceType.JOINED)
public class MyBook implements Serializable, Cloneable {

  @Id
  @Column(name = "id", updatable = false, nullable = false)
  private String id;

  @Column(name = "title", nullable = false)
  private String title;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  private BOOK_STATUS bookStatus;

  @Column(name = "current_user_name", nullable = true)
  private String currentUserName;

  @Column(name = "current_user_id", nullable = true)
  private String currentUserId;

  @Column(name = "has_detail_info", nullable = true)
  private Boolean hasDetailInfo;

  @Column(name = "loaned", nullable = true)
  private Boolean isLoaned;
//
//  @Column(name = "loaned_extended", nullable = true)
//  private Boolean IsLoanedExtended;
//
//  @Column(name = "loaned_user", nullable = true)
//  private String loanedUser;
//
//  @Column(name = "return_date", nullable = true)
//  private LocalDate returnDate;
//
//  @Column(name = "return_date_expired", nullable = true)
//  private LocalDate returnDateExtended;
//
//  @Column(name = "default_loan_day", nullable = true)
//  private Integer defaultLoanDay = 14;
//
//  @Column(name = "extended_loan_day", nullable = true)
//  private Integer extendLoanDay = 7;

  //private List<MyBookComment> commentList;
  @OneToOne(fetch = FetchType.LAZY, cascade={CascadeType.ALL})
  //@OneToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name = "id")
  private MybookDetail mybookDetail = new MybookDetail();

  public MyBook() {
    this.bookStatus = BOOK_STATUS.AVAILABLE;
  }

  public MyBook(String id, String title) {
    this.id = id;
    this.title = title;
    this.bookStatus = BOOK_STATUS.AVAILABLE;
  }

  public void setMybookDetail(MybookDetail mybookDetail){
    this.hasDetailInfo = true;

    this.mybookDetail = mybookDetail;
    this.mybookDetail.setId(this.id);
  }

  @Override
  public boolean equals(Object o) {
    return this.id == ((MyBook) o).getId();
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  public enum BOOK_STATUS {
    AVAILABLE, LOANED, EXTENDED, OVERDUE, SERVED
  }

}
