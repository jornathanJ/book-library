package com.jornathan.booklibrary.dao.hibernate;

import com.jornathan.booklibrary.model.hibernate.MyBookVO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MyBookPersistentRepo extends JpaRepository<MyBookVO, String> {

  //    // 비워있어도 잘 작동함.
  //    // long 이 아니라 Long으로 작성. ex) int => Integer 같이 primitive형식 사용못함
  //    // findBy뒤에 컬럼명을 붙여주면 이를 이용한 검색이 가능하다
  //    public List<MyBookEntity> findByTag(String tag);
  //
  //    //public List<MyBookEntity> findByName(String name); //like검색도 가능
  //
  //    public List<MyBookEntity> findByNameLike(String keyword);
    /*
    List<T> findAll();

    List<T> findAll(Sort var1);

    List<T> findAllById(Iterable<ID> var1);

    <S extends T> List<S> saveAll(Iterable<S> var1);

    void flush();

    <S extends T> S saveAndFlush(S var1);

    void deleteInBatch(Iterable<T> var1);

    void deleteAllInBatch();

    T getOne(ID var1);

    <S extends T> List<S> findAll(Example<S> var1);

    <S extends T> List<S> findAll(Example<S> var1, Sort var2);
     */
  MyBookVO findByTag(String tag);

  List<MyBookVO> findAllByOrderByTagAsc();

  //MyBookVO getOne(String tag);
}
