package com.jornathan.booklibrary.dao;

import com.jornathan.booklibrary.model.redis.MyBook;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MyBookRepository  {

    public static List<MyBook> myBooks;

    static {
        myBooks = new ArrayList<>();
        myBooks.add(new MyBook("A-001", "A 001 books"));
        myBooks.add(new MyBook("A-002", "A 002 books"));
        myBooks.add(new MyBook("A-003", "A 003 books"));
        myBooks.add(new MyBook("A-004", "A 004 books"));
        myBooks.add(new MyBook("A-005", "A 005 books"));
        myBooks.add(new MyBook("B-001", "B 001 books"));
        myBooks.add(new MyBook("B-002", "B 002 books"));
        myBooks.add(new MyBook("B-003", "B 003 books"));
        myBooks.add(new MyBook("C-001", "C 001 books"));
        myBooks.add(new MyBook("C-002", "C 002 books"));
        myBooks.add(new MyBook("C-003", "C 003 books"));
    }

    public List<MyBook> getAllBooks(){
        return this.myBooks;
    }

    public MyBook getBook(String bookName){

        MyBook rtnValue = null;
        for(MyBook item : myBooks){
            if(true == item.getTag().equals(bookName)){
                rtnValue = item;
            }
        }

        return rtnValue;
    }

    public List<MyBook> searchBooks(String keyword){


        return myBooks.stream()
                .filter(book -> book.getName().indexOf(keyword) >= 0)
                .collect(Collectors.toList());
    }

    public void updateBook(List<MyBook> myBookList){
        for(MyBook item : myBookList){
            int index = this.myBooks.indexOf(item);
            if(index >= 0){
                MyBook targetItem = this.myBooks.get(index);
                //targetItem = item.
            }
        }
    }

    public void createBook(MyBook newBook){
        this.myBooks.add(newBook);
    }

    public Map<String, Object> deleteBook(String tag){
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("RESULT", "FAIL");

        for(MyBook item : this.myBooks){
            int index = this.myBooks.indexOf(item);
            if(index >= 0){
                this.myBooks.remove(index);
                result.put("RESULT", "PASS");
                break;
            }
        }

        return result;
    }
}
