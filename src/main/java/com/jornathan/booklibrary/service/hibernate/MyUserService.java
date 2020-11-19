package com.jornathan.booklibrary.service.hibernate;

import com.jornathan.booklibrary.model.hibernate.MyUser;


public interface MyUserService {
  public MyUser findById(String id);

  public MyUser save(MyUser myUser);

  public void delete(MyUser myUser);
}
