package com.jornathan.booklibrary.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@RedisHash("mybook")
public class MyBook implements Serializable, Cloneable {


    @Id
    private String tag;
    private String name;

    private boolean IsLoaned;
    private boolean IsLoanedExtended;
    private long loanedUser;

    private LocalDate returnDate;
    private LocalDate returnDateExtended;

    private int defaultLoanDay = 14;
    private int extendLoanDay = 7;

    //private List<MyBookComment> commentList;

    public MyBook(){
        this.IsLoaned = false;
    }

    public MyBook(String tag, String name){
        this.tag = tag;
        this.name = name;
        //this.IsLoaned = false;
    }


    @Id
    @NonNull
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

    public boolean getLoaned() {
        return IsLoaned;
    }

    public void setLoaned(boolean loaned) {
        IsLoaned = loaned;
    }

    public boolean getLoanedExtended() {
        return IsLoanedExtended;
    }

    public void setLoanedExtended(boolean loanedExtended) {
        IsLoanedExtended = loanedExtended;
    }

    public long getLoanedUser() {
        return loanedUser;
    }

    public void setLoanedUser(long loanedUser) {
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

    public int getDefaultLoanDay() {
        return defaultLoanDay;
    }

    public void setDefaultLoanDay(int defaultLoanDay) {
        this.defaultLoanDay = defaultLoanDay;
    }

    public int getExtendLoanDay() {
        return extendLoanDay;
    }

    public void setExtendLoanDay(int extendLoanDay) {
        this.extendLoanDay = extendLoanDay;
    }

//    public List<MyBookComment> getCommentList() {
//        return commentList;
//    }
//
//    public void setCommentList(List<MyBookComment> commentList) {
//        this.commentList = commentList;
//    }

    @Override
    public boolean equals(Object o){
        return this.tag == ((MyBook)o).getTag();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
