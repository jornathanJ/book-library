package com.jornathan.booklibrary.service.hibernate;

import com.jornathan.booklibrary.dao.hibernate.MyUserRepository;
import com.jornathan.booklibrary.model.hibernate.MyUser;

import org.springframework.stereotype.Service;

@Service
public class MyUserServiceImpl implements MyUserService {

  private MyUserRepository myUserRepository;

  public MyUserServiceImpl(MyUserRepository myUserRepository){
    this.myUserRepository = myUserRepository;
  }

  @Override
  public MyUser findById(String id) {
    return this.myUserRepository.findById(id).orElse(null);
  }

  @Override
  public MyUser save(MyUser myUser) {
    return this.myUserRepository.save(myUser);
  }

  @Override
  public void delete(MyUser myUser) {
    this.myUserRepository.delete(myUser);
  }
}
