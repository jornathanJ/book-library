package com.jornathan.booklibrary.model.hibernate;

import org.springframework.beans.factory.annotation.Value;

public interface MyBookProjections {

  interface BookList {
    String getId();

    String getTitle();

    MyBook.BOOK_STATUS getBookStatus();

    String getCurrentUserName();

    String getCurrentUserId();

    Boolean getHasDetailInfo();

    Boolean getIsLoaned();
  }
}
