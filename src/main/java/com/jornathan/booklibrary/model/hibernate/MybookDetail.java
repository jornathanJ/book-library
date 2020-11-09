package com.jornathan.booklibrary.model.hibernate;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.Map;

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
public class MybookDetail {

    @Id
    @Column(name = "tag", updatable = false, nullable = false)
    private String tag;

    @JsonProperty("title")
    @Column(name = "title", nullable = true)
    private String title;

    @JsonProperty("link")
    @Column(name = "link", nullable = true)
    private String link;

    @JsonProperty("image")
    @Column(name = "image", nullable = true)
    private String image;

    @JsonProperty("author")
    @Column(name = "author", nullable = true)
    private String author;

    @JsonProperty("price")
    @Column(name = "price", nullable = true)
    private String price;

    @JsonProperty("discount")
    @Column(name = "discount", nullable = true)
    private String discount;

    @JsonProperty("publisher")
    @Column(name = "publisher", nullable = true)
    private String publisher;

    @JsonProperty("pubdate")
    @Column(name = "pubdate", nullable = true)
    private String pubdate;

    @JsonProperty("isbn")
    @Column(name = "isbn", nullable = true)
    private String isbn = "";

    @JsonProperty("description")
    @Column(name = "description", nullable = true)
    private String description;

    public MybookDetail(){
        this.isbn = "";
    }


//    @JsonIgnore
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("tag")
    public String getTag() {
        return tag;
    }

    @JsonProperty("tag")
    public void setTag(String id) {
        this.tag = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    @JsonProperty("discount")
    public String getDiscount() {
        return discount;
    }

    @JsonProperty("discount")
    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @JsonProperty("publisher")
    public String getPublisher() {
        return publisher;
    }

    @JsonProperty("publisher")
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @JsonProperty("pubdate")
    public String getPubdate() {
        return pubdate;
    }

    @JsonProperty("pubdate")
    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    @JsonProperty("isbn")
    public String getIsbn() {
        return isbn;
    }

    @JsonProperty("isbn")
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

//    @JsonAnyGetter
//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }

//    @JsonAnySetter
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }

}