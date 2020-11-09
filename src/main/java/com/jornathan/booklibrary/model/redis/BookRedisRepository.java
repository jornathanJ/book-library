package com.jornathan.booklibrary.model.redis;

import org.springframework.data.repository.CrudRepository;

public interface BookRedisRepository extends CrudRepository<MyBook, String> {
}
