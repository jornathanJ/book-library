package com.jornathan.booklibrary.service.hibernate;

import com.jornathan.booklibrary.dao.hibernate.CheckOutHistoryRepository;
import com.jornathan.booklibrary.dao.hibernate.MyBookDetailRepository;
import com.jornathan.booklibrary.dao.hibernate.MyBookRepository;
import com.jornathan.booklibrary.dao.hibernate.MyUserRepository;
import com.jornathan.booklibrary.model.hibernate.CheckOutHistory;
import com.jornathan.booklibrary.model.hibernate.MyBook;
import com.jornathan.booklibrary.model.hibernate.MyBookProjections;
import com.jornathan.booklibrary.model.hibernate.MyUser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

@Service
public class MyBookServiceImpl implements MyBookService {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public static final int DEFAULT_LOAN_DATE = 7;

  private MyBookRepository myBookRepository;

  private MyBookDetailRepository myBookDetailRepository;

  private CheckOutHistoryRepository checkOutHistoryRepository;

  private MyUserRepository myUserRepository;

  public MyBookServiceImpl(MyBookRepository myBookRepository,
                           MyBookDetailRepository myBookDetailRepository,
                           CheckOutHistoryRepository checkOutHistoryRepository,
                           MyUserRepository myUserRepository) {
    this.myBookRepository = myBookRepository;
    this.myBookDetailRepository = myBookDetailRepository;
    this.checkOutHistoryRepository = checkOutHistoryRepository;
    this.myUserRepository = myUserRepository;
  }

  public List<MyBookProjections.BookList> findAllByOrderByTagAsc() {
    return this.myBookRepository.findAllByOrderByIdAsc();
  }

  public MyBook findById(String tag) {
    return this.myBookRepository.findById(tag).orElse(null);
  }

  @Transactional
  public MyBook save(MyBook myBook) {
    MyBook result = this.myBookRepository.save(myBook);

    return result;
  }

  @Transactional
  public MyBook saveBookDetail(MyBook myBook) {
    //return this.myBookRepository.save(myBookVO);
    //myBookVO.getMybookDetail().setId(myBookVO.getId());
    this.myBookDetailRepository.save(myBook.getMybookDetail());
    return this.findById(myBook.getId());
  }

  @Transactional
  public MyBook saveBookHistory(String userId, MyBook test) {

    // TODO: 이미 대출 중인 책은 대출할 수가 없음(UI 에서 이미 막혀 있긴함)
    MyUser user = this.myUserRepository.getOne(userId);
    MyBook myBook = this.myBookRepository.getOne(test.getId());

    CheckOutHistory checkOutHistory = CheckOutHistory.builder()
        .userId(user.getId())
        .bookId(myBook.getId())
        .checkOut(LocalDate.now())
        .loanPeriod(this.DEFAULT_LOAN_DATE)
        .overdueDays(0)
        .extend(false)
        .overdue(false)
        .build();

    this.checkOutHistoryRepository.save(checkOutHistory);

    myBook.setIsLoaned(true);
    myBook.setBookStatus(MyBook.BOOK_STATUS.LOANED);
    myBook.setCurrentUserId(user.getId());
    myBook.setCurrentUserName(user.getKorName());
    this.myBookRepository.save(myBook);

    // TODO: 대출에 대한 정보를 WebSocket 으로 전송한다.
    return this.findById(myBook.getId());
  }

  //  @Transactional
  //  public MyBook updateBookStatus(MyBook myBookVO) {
  //    this.myBookDetailRepository.save(myBookVO.getMybookDetail());
  //    return this.findById(myBookVO.getId());
  //  }

  @Transactional
  public void delete(MyBook myBookVO) {
    this.myBookRepository.delete(myBookVO);
  }
}
