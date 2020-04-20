package com.jornathan.booklibrary.model;

import com.jornathan.booklibrary.domain.Point;
import org.springframework.data.repository.CrudRepository;

public interface BookRedisRepository extends CrudRepository<MyBook, String> {
}
