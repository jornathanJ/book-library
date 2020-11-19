package com.jornathan.booklibrary.model.hibernate;


import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Entity //for Hibernate
@Table(name = "checkout_history")  //for Hibernate
public class CheckOutHistory implements Serializable, Cloneable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "user_id")
  private String userId;

  @Column(name = "mybook_id")
  private String bookId;

  @Column(name = "check_out")
  private LocalDate checkOut;

  @Column(name = "check_in")
  private LocalDate checkIn;

  @Column(name = "loan_period")
  private Integer loanPeriod;

  @Column(name = "overdue_days")
  private Integer overdueDays;

  @Column(name = "extend")
  private Boolean extend;

  @Column(name = "overdue")
  private Boolean overdue;
}
