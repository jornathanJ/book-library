package com.jornathan.booklibrary.model.hibernate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title",
    "link",
    "image",
    "author",
    "price",
    "discount",
    "publisher",
    "pubdate",
    "isbn",
    "description"
})
@Entity //for Hibernate
@Table(name = "mybook_detail")  //for Hibernate
// TYPE:001 - @PrimaryKeyJoinColumn(name = "mybooks_id")
// TYPE:001 - public class MybookDetail extends MyBook {
public class MybookDetail {

  @Id
//  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
//  @GenericGenerator(name = "native", strategy = "native")
  //@Column(name = "id")//, updatable = false, nullable = false)
  @Column(name="id")
  private String id;

//  @MapsId
//  @OneToOne(mappedBy = "mybookDetail")
//  @JoinColumn(name = "mybookDetail_id")   //same name as id @Column
//  private MyBook myBook;

  @JsonProperty("title")
  @Column(name = "title")
  private String title;

  @JsonProperty("link")
  @Column(name = "link")
  private String link;

  @JsonProperty("image")
  @Column(name = "image")
  private String image;

  @JsonProperty("author")
  @Column(name = "author")
  private String author;

  @JsonProperty("price")
  @Column(name = "price")
  private String price;

  @JsonProperty("discount")
  @Column(name = "discount")
  private String discount;

  @JsonProperty("publisher")
  @Column(name = "publisher")
  private String publisher;

  @JsonProperty("pubdate")
  @Column(name = "pubdate")
  private String pubdate;

  @JsonProperty("isbn")
  @Column(name = "isbn")
  private String isbn = "";

  @JsonProperty("description")
  @Column(name = "description")
  private String description;

  public MybookDetail() {
  }
}