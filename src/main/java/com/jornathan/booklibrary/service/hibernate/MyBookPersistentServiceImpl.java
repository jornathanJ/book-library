package com.jornathan.booklibrary.service.hibernate;

import com.jornathan.booklibrary.model.hibernate.MyBookVO;
import com.jornathan.booklibrary.dao.hibernate.MyBookPersistentRepo;
import com.jornathan.booklibrary.model.redis.MyBook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MyBookPersistentServiceImpl implements MyBookPersistentService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MyBookPersistentRepo myBookPersistentRepo;

    public List<MyBookVO> findAll(){
        List<MyBookVO> myBooks = new ArrayList<>();
        this.myBookPersistentRepo.findAll().forEach(book -> myBooks.add(book) );
        return myBooks;
    }

    public List<MyBookVO> findAllByOrderByTagAsc(){
        List<MyBookVO> myBooks = new ArrayList<>();
        this.myBookPersistentRepo.findAllByOrderByTagAsc().forEach(book -> myBooks.add(book) );
        return myBooks;
    }

    public MyBookVO findByTag(String tag){
        return this.myBookPersistentRepo.findByTag(tag);
        //return this.myBookPersistentRepo.getOne(tag); 왜 안되는지 모르겠다.

    }

    public MyBookVO save(MyBookVO myBookVO){
//        MyBookVO myBook = new MyBookVO();
//        myBook.setTag(tag);
//        myBook.setName(name);

        MyBookVO result = this.myBookPersistentRepo.save(myBookVO);

        return result;
    }

    public MyBookVO update(MyBookVO myBookVO){
        MyBookVO myBook = this.myBookPersistentRepo.findByTag(myBookVO.getTag());
//        myBook.setLoaned(true);
//        myBook.setLoanedUser(myBookVO.getLoanedUser());
//
//        int defaultLoanDays = myBook.getDefaultLoanDay();
//        LocalDate rtnData = LocalDate.now().plusDays(defaultLoanDays);
//        myBook.setReturnDate(rtnData);
        myBook.setMybookDetail(myBookVO.getMybookDetail());

        MyBookVO result = this.myBookPersistentRepo.save(myBook);

        // logger.info("PASS : Current default loan days {}. return date {}", defaultLoanDays, rtnData);

        return result;
    }

    public void delete(MyBookVO myBookVO){
        MyBookVO myBook = this.myBookPersistentRepo.findByTag(myBookVO.getTag());
        this.myBookPersistentRepo.delete(myBookVO);
    }

}
