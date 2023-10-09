package com.desanlesr95.pizzeria.persitence.repository;

import com.desanlesr95.pizzeria.persitence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,String> {
}
